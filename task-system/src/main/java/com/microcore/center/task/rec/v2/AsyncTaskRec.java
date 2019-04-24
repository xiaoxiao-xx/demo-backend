package com.microcore.center.task.rec.v2;

import com.google.gson.Gson;
import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.model.PsmFace;
import com.microcore.center.model.PsmMaterial;
import com.microcore.center.model.PsmPersonInfo;
import com.microcore.center.service.MaterialService;
import com.microcore.center.service.PersonService;
import com.microcore.center.service.RealAlarmService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.JedisPoolUtil;
import com.microcore.center.util.RabbitMQUtil;
import com.microcore.center.vo.FaceSdkRecVo;
import com.microcore.center.vo.PsmDealResDetailVo;
import com.microcore.center.vo.PsmFaceVo;
import com.microcore.center.vo.PsmRealAlarmVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.microcore.center.util.CommonUtil.random;

/**
 *
 */
@Component
@Slf4j
public class AsyncTaskRec {

	private final HttpTemplate httpTemplate;

	private final MaterialService materialService;

	private final JedisPoolUtil redisUtil;

	private final PersonService personService;

	private final RabbitMQUtil rabbitMQUtil;

	private final RealAlarmService realAlarmService;

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
	public AsyncTaskRec(HttpTemplate httpTemplate, MaterialService materialService,
	                    JedisPoolUtil redisUtil, PersonService personService,
	                    RabbitMQUtil rabbitMQUtil, RealAlarmService realAlarmService) {
		this.httpTemplate = httpTemplate;
		this.materialService = materialService;
		this.redisUtil = redisUtil;
		this.personService = personService;
		this.rabbitMQUtil = rabbitMQUtil;
		this.realAlarmService = realAlarmService;
	}

	/**
	 *
	 */
	@Async
	public void rec(String materialId, FaceSdkRecVo faceSdkRec) {
		String ret2 = "";

		try {
			long t1 = System.currentTimeMillis();
			ret2 = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/rec", faceSdkRec, String.class);
			long time = System.currentTimeMillis() - t1;
			log.info("rec: {} ms", time);
		} catch (Exception e) {
			log.error("Face detection error", e);
		}

		// 保存人脸识别结果
		DataStructure.DetectResult2 result2 = gson.fromJson(ret2, DataStructure.DetectResult2.class);

		List<DataStructure.FaceInfo> faces2 = result2.getData().getResult();
		if (faces2 == null) {
			faces2 = new ArrayList<>();
		}

		List<PsmFaceVo> faceList2 = convertFaces(materialId, faces2);
		if (faceList2.size() > 0) {
			// log.info("faceList2 size: {}", faceList2.size());
		}

		for (PsmFace face2 : faceList2) {// Drop the faces which scores under 60
			try {
				if (Double.parseDouble(face2.getScore()) < 60.00D) {
					continue;
				}
			} catch (Exception e) {
				log.error("{}", e);
			}

			// log.info("name: {}", face2.getUserId());
			sendEvent(face2);

			PsmMaterial material = materialService.getMaterial(materialId);
			String areaId = material.getAreaId();
			String userId = face2.getUserId();
			// log.info(">>> detected face: {}, score: {}", personService.getPsmPersonInfoName(userId), face2.getScore());
			// log.info(">>> detect cost=" + (System.currentTimeMillis() - ctm) + "ms, ret=" + ret);

			// k-v  k: user_id, v: area_id & capture_time
			Map<String, String> map = new HashMap<>();
			map.put("userName", personService.getPsmPersonInfoName(userId));
			map.put("areaId", areaId);
			map.put("captureTime", dateFormat.get().format(material.getCreateTime()));
			map.put("teamId", personService.getPsmPersonInfo(userId).getDeptId());
			redisUtil.hmset(userId, map);

			// k-v  k: area_id, v: user_id set
			String areaKey = "area:" + areaId;
			// Remove the user from other areas
			for (int i = 1; i < 6; i++) {
				redisUtil.srem("area:" + i, userId);
			}
			// Add the user to the current area
			redisUtil.sadd(areaKey, userId);
		}

		List<PsmFace> facest = CommonUtil.listPo2VO(faceList2, PsmFace.class);
		materialService.addFaceList(facest);
		// log.info("thread id= {}", Thread.currentThread().getName());
	}

	private List<PsmFaceVo> convertFaces(String materialId, List<DataStructure.FaceInfo> faceInfoList) {
		return faceInfoList.stream().map(faceInfo -> {
			PsmFaceVo face = new PsmFaceVo();

			face.setId(CommonUtil.getUUID());
			face.setMaterialId(materialId);
			face.setCreateTime(CommonUtil.getCurrentTime());

			face.setAngle(faceInfo.getAngle());
			face.setCenterX(faceInfo.getCenter_x());
			face.setCenterY(faceInfo.getCenter_y());
			face.setGroupId(faceInfo.getGroup_id());
			face.setUserId(faceInfo.getUser_id());
			face.setHeight(faceInfo.getHeight());
			face.setWidth(faceInfo.getWidth());
			face.setScore(faceInfo.getScore());
			face.setBase64(faceInfo.getBase64());

			return face;
		}).collect(Collectors.toList());
	}

	private void sendEvent(PsmFace face) {
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

	private void generateAlarmMessage(PsmFace face, String personName) {
		PsmMaterial material = materialService.getMaterial(face.getMaterialId());
		String areaId = material.getAreaId();
		Date captureTime = material.getCreateTime();

		String reason = "人员：" + personName
				+ "，时间：" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(captureTime)
				+ "，进入" + getAreaName(areaId);

		PsmRealAlarmVo alarm = new PsmRealAlarmVo();
		String uuid = CommonUtil.getUUID();
		alarm.setId(uuid);
		alarm.setOperator("");
		alarm.setRemark("");
		alarm.setState("0");
		alarm.setTriggerTime(CommonUtil.getCurrentTime());
		alarm.setObjectId(face.getUserId());
		alarm.setObjectType(random("1", "2"));
		alarm.setAlarmType(random("1", "2"));
		alarm.setAlarmReason(reason);
		realAlarmService.add(alarm);
	}

}

