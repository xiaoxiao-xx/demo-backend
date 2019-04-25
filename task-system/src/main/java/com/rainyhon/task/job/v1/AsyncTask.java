package com.rainyhon.task.job.v1;

import com.google.gson.Gson;
import com.rainyhon.common.cllient.HttpTemplate;
import com.microcore.center.model.Face;
import com.microcore.center.model.PsmMaterial;
import com.microcore.center.model.PsmPersonInfo;
import com.rainyhon.common.service.MaterialService;
import com.rainyhon.common.service.PersonService;
import com.rainyhon.common.service.AlarmResultService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.JedisPoolUtil;
import com.rainyhon.common.mq.rabbit.RabbitMQUtil;
import com.rainyhon.common.vo.FaceSdkRecVo;
import com.rainyhon.common.vo.PsmDealResDetailVo;
import com.rainyhon.common.vo.AlarmResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.rainyhon.task.job.v1.CaptureTask.convertFaces;
import static com.rainyhon.common.util.CommonUtil.random;

/**
 *
 */
@Component
@Slf4j
public class AsyncTask {

	private final HttpTemplate httpTemplate;

	private final MaterialService materialService;

	private final JedisPoolUtil redisUtil;

	private final PersonService personService;

	private final RabbitMQUtil rabbitMQUtil;

	private final AlarmResultService alarmResultService;

	private Gson gson = new Gson();

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	private final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));

	private Map<String, String> addressList = new HashMap<>();

	{
		addressList.put("1", "入口");
		addressList.put("2", "入口");
		addressList.put("3", "工作区");
		addressList.put("4", "会议室");
		addressList.put("5", "总经理室");
	}

	@Autowired
	public AsyncTask(HttpTemplate httpTemplate, MaterialService materialService,
	                 JedisPoolUtil redisUtil, PersonService personService, RabbitMQUtil rabbitMQUtil, AlarmResultService alarmResultService) {
		this.httpTemplate = httpTemplate;
		this.materialService = materialService;
		this.redisUtil = redisUtil;
		this.personService = personService;
		this.rabbitMQUtil = rabbitMQUtil;
		this.alarmResultService = alarmResultService;
	}

	/**
	 *
	 */
	@Async
	public void detect(String materialId, FaceSdkRecVo faceSdkRecVo) {
		long ctm = System.currentTimeMillis();
		String ret = "";
		try {
			ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/detect", faceSdkRecVo, String.class);
		} catch (Exception e) {
			log.error("Face detection error", e);
		}

		// log.info("face.ip: {}, face.port: {}", faceApiIp, faceApiPort);

		// 保存人脸识别结果
		Gson gson = new Gson();
		DataStructure.DetectResult result = gson.fromJson(ret, DataStructure.DetectResult.class);

		List<DataStructure.FaceInfo> faces = result.getFaces();
		if (faces == null) {
			faces = new ArrayList<>();
		}

		List<Face> faceList = convertFaces(materialId, faces);
		for (Face face : faceList) {// Drop the faces which scores under 60
			try {
				if (Double.parseDouble(face.getScore()) < 60.00D) {
					continue;
				}
			} catch (Exception e) {
				log.error("{}", e);
			}

			sendEvent(face);

			PsmMaterial material = materialService.getMaterial(materialId);
			String areaId = material.getAreaId();
			String userId = face.getUserId();
			log.info(">>> detected face: {}, score: {}", personService.getPsmPersonInfoName(userId), face.getScore());
			log.info(">>> detect cost=" + (System.currentTimeMillis() - ctm) + "ms, ret=" + ret);

			// k-v  k: user_id, v: area_id & capture_time
			Map<String, String> map = new HashMap<>();
			map.put("userName", personService.getPsmPersonInfoName(userId));
			map.put("areaId", areaId);
			map.put("captureTime", dateFormat.get().format(material.getCreateTime()));
			map.put("teamId", personService.getPsmPersonInfo(userId).getDeptId());
			redisUtil.hmset("user:" + userId, map);

			// k-v  k: area_id, v: user_id set
			String areaKey = "area:" + areaId;
			// Remove the user from other areas
			for (int i = 1; i < 6; i++) {
				redisUtil.srem("area:" + i, userId);
			}
			// Add the user to the current area
			redisUtil.sadd(areaKey, userId);
		}

		materialService.addFaceList(faceList);

		// log.info("thread id= {}", Thread.currentThread().getName());
	}

	private void sendEvent(Face face) {
		PsmDealResDetailVo vo = new PsmDealResDetailVo();
		String materialId = face.getMaterialId();
		PsmMaterial material = materialService.getMaterial(materialId);
		String areaId = material.getAreaId();
		vo.setAddress(addressList.get(areaId));

		// TODO
		vo.setAlarmState(random("是", "否"));
		vo.setAlarmType(random("警告弹出框", "警报声音"));

		String userId = face.getUserId();
		PsmPersonInfo psmPersonInfo = personService.getPsmPersonInfo(userId);
		if (psmPersonInfo == null) {
			psmPersonInfo = new PsmPersonInfo();
		}

		vo.setPsmPersonInfo(psmPersonInfo);
		vo.setCharacterInfo(psmPersonInfo.getPersonId());

		Date d = face.getCreateTime();
		// 某人离开或者进入区域也要推送消息
		String personName = psmPersonInfo.getName();
		vo.setEventInfo("人员：" + personName
				+ "，时间：" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(d)
				+ "，进入" + getAreaName(areaId) + ""
		);

		vo.setResId(CommonUtil.getUUID());
		vo.setSrcId("");
		vo.setTime(CommonUtil.getCurrentTime());
		vo.setValidState(random("是", "否"));

		try {
			if (Double.parseDouble(face.getScore()) >= 60.00D) {
				rabbitMQUtil.sendMsg(gson.toJson(vo));

				String alarmAreaId = "5";
				if ("1".equals(psmPersonInfo.getDeptId()) && alarmAreaId.equals(areaId)) {
					generateAlarmMessage(face, personName);
				}
			}
		} catch (Exception e) {
			log.error("{}", e);
		}
	}

	private String getAreaName(String areaId) {
		return addressList.get(areaId);
	}

	private void generateAlarmMessage(Face face, String personName) {
		PsmMaterial material = materialService.getMaterial(face.getMaterialId());
		String areaId = material.getAreaId();
		Date captureTime = material.getCreateTime();

		String reason = "人员：" + personName
				+ "，时间：" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(captureTime)
				+ "，进入" + getAreaName(areaId);

		AlarmResultVo alarm = new AlarmResultVo();
		String uuid = CommonUtil.getUUID();
		alarm.setId(uuid);
		alarm.setOperator("");
		alarm.setRemark("");
		alarm.setState("0");
		alarm.setTriggerTime(CommonUtil.getCurrentTime());
		alarm.setObjectId(face.getUserId());
		alarm.setObjectType(random("1", "2"));
		alarm.setAlarmModeType(random("1", "2"));
		alarm.setAlarmReason(reason);
		alarmResultService.add(alarm);
	}

}

