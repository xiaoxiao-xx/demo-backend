package com.rainyhon.task.job.v1;

import com.google.gson.Gson;
import com.rainyhon.common.cllient.HttpTemplate;
import com.rainyhon.common.model.Face;
import com.rainyhon.common.model.Material;
import com.rainyhon.common.model.PersonInfo;
import com.rainyhon.common.service.MaterialService;
import com.rainyhon.common.service.PersonInfoService;
import com.rainyhon.common.service.AlarmResultService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.JedisPoolUtil;
import com.rainyhon.common.mq.rabbit.RabbitMQUtil;
import com.rainyhon.common.vo.FaceSdkRecVo;
import com.rainyhon.common.vo.DealResDetailVo;
import com.rainyhon.common.vo.AlarmResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.rainyhon.common.constant.AreaDef.getAreaNameById;
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

	private final PersonInfoService personInfoService;

	private final RabbitMQUtil rabbitMQUtil;

	private final AlarmResultService alarmResultService;

	private final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));

	private Gson gson = new Gson();

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	@Autowired
	public AsyncTask(HttpTemplate httpTemplate, MaterialService materialService,
	                 JedisPoolUtil redisUtil, PersonInfoService personInfoService, RabbitMQUtil rabbitMQUtil, AlarmResultService alarmResultService) {
		this.httpTemplate = httpTemplate;
		this.materialService = materialService;
		this.redisUtil = redisUtil;
		this.personInfoService = personInfoService;
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

			Material material = materialService.getMaterial(materialId);
			String areaId = material.getAreaId();
			String userId = face.getUserId();
			log.info(">>> detected face: {}, score: {}", personInfoService.getPersonInfoName(userId), face.getScore());
			log.info(">>> detect cost=" + (System.currentTimeMillis() - ctm) + "ms, ret=" + ret);

			// k-v  k: user_id, v: area_id & capture_time
			Map<String, String> map = new HashMap<>();
			map.put("userName", personInfoService.getPersonInfoName(userId));
			map.put("areaId", areaId);
			map.put("captureTime", dateFormat.get().format(material.getCreateTime()));
			map.put("teamId", personInfoService.getPersonInfo(userId).getOrgId());
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
		DealResDetailVo vo = new DealResDetailVo();
		String materialId = face.getMaterialId();
		Material material = materialService.getMaterial(materialId);
		String areaId = material.getAreaId();
		vo.setAddress(getAreaNameById(areaId));

		// TODO
		vo.setAlarmState(random("是", "否"));
		vo.setAlarmType(random("警告弹出框", "警报声音"));

		String userId = face.getUserId();
		PersonInfo personInfo = personInfoService.getPersonInfo(userId);
		if (personInfo == null) {
			personInfo = new PersonInfo();
		}

		vo.setPersonInfo(personInfo);
		vo.setCharacterInfo(personInfo.getId());

		Date d = face.getCreateTime();
		// 某人离开或者进入区域也要推送消息
		String personName = personInfo.getName();
		vo.setEventInfo("人员：" + personName
				+ "，时间：" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(d)
				+ "，进入" + getAreaNameById(areaId) + ""
		);

		vo.setResId(CommonUtil.getUUID());
		vo.setSrcId("");
		vo.setTime(CommonUtil.getCurrentTime());
		vo.setValidState(random("是", "否"));

		try {
			if (Double.parseDouble(face.getScore()) >= 60.00D) {
				rabbitMQUtil.sendMsg(gson.toJson(vo));

				String alarmAreaId = "5";
				if ("1".equals(personInfo.getOrgId()) && alarmAreaId.equals(areaId)) {
					generateAlarmMessage(face, personName);
				}
			}
		} catch (Exception e) {
			log.error("{}", e);
		}
	}

	private void generateAlarmMessage(Face face, String personName) {
		Material material = materialService.getMaterial(face.getMaterialId());
		String areaId = material.getAreaId();
		Date captureTime = material.getCreateTime();

		String reason = "人员：" + personName
				+ "，时间：" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(captureTime)
				+ "，进入" + getAreaNameById(areaId);

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

