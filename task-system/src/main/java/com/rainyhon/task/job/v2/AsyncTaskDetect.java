package com.rainyhon.task.job.v2;

import com.google.gson.Gson;
import com.rainyhon.common.cllient.HttpTemplate;
import com.microcore.center.mapper.DetectResultMapper;
import com.microcore.center.model.DetectResult;
import com.rainyhon.common.util.*;
import com.rainyhon.common.vo.FaceSdkRecVo;
import com.rainyhon.common.vo.PsmFaceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
@Component
@Slf4j
public class AsyncTaskDetect {

	private final HttpTemplate httpTemplate;

	private final ThreadLocal<SimpleDateFormat> df = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyyMMddHHmmss"));

	@Autowired
	private AsyncTaskRec asyncTaskRec;

	@Autowired
	private DetectResultMapper detectResultMapper;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	@Autowired
	public AsyncTaskDetect(HttpTemplate httpTemplate) {
		this.httpTemplate = httpTemplate;
	}

	/**
	 *
	 */
	@Async
	public void detect(String materialId, FaceSdkRecVo faceSdkRecVo) {
		long ctm = System.currentTimeMillis();
		String ret = "";
		try {
			long t = System.currentTimeMillis();
			ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/detect", faceSdkRecVo, String.class);
			long tx = System.currentTimeMillis() - t;
			log.info("detect: {}", tx);
		} catch (Exception e) {
			log.error("Face detection error", e);
		}

		// log.info("face.ip: {}, face.port: {}", faceApiIp, faceApiPort);

		// 保存人脸识别结果
		Gson gson = new Gson();
		DataStructure.DetectResult result = gson.fromJson(ret, DataStructure.DetectResult.class);
		if (result == null) {
			return;
		}

		List<DataStructure.FaceInfo> faces = result.getFaces();
		if (faces == null) {
			faces = new ArrayList<>();
		}

		List<PsmFaceVo> faceList = convertFaces(materialId, faces);
		if (faceList.size() > 0) {
			log.info("faceList size: {}", faceList.size());
			for (PsmFaceVo face : faceList) {
				String detectResultId = CommonUtil.getUUID();

				DetectResult detectResult = new DetectResult();
				detectResult.setId(detectResultId);
				detectResult.setMaterialId(materialId);
				detectResult.setAngle(face.getAngle());
				detectResult.setCenterX(face.getCenterX());
				detectResult.setCenterY(face.getCenterY());
				detectResult.setGroupId(face.getGroupId());
				detectResult.setHeight(face.getHeight());
				detectResult.setWidth(face.getWidth());
				// detectResult.setBase64(face.getBase64());
				detectResult.setCreateTime(CommonUtil.getCurrentTime());
				detectResultMapper.insert(detectResult);

				face.setDetectResultId(detectResultId);
			}
		}

		// TODO
		// faceList = new ArrayList<>();

		for (PsmFaceVo face : faceList) {// Drop the faces which scores under 60
			// 封装请求JSON
			FaceSdkRecVo faceSdkRec = new FaceSdkRecVo();
			faceSdkRec.setGroup_id("g1");

			// 需要设备ID 如摄像头
			faceSdkRec.setDevice_id("001");

			// 获得seiralNo
			String seiralNo = getSerialNumber();
			faceSdkRec.setSeiralNo(seiralNo);

			faceSdkRec.setImage(face.getBase64());

			String a = face.getBase64();
			byte[] bytes = Base64.getDecoder().decode(a.getBytes(Charset.forName("UTF-8")));
			CommonUtil.saveFile("D:/temp/" + System.currentTimeMillis() + ".bmp", bytes);

			String detectResultId = face.getDetectResultId();
			asyncTaskRec.rec(materialId, detectResultId, faceSdkRec);
		}
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

	private String getSerialNumber() {
		long ctm = System.currentTimeMillis();
		return df.get().format(new Date(ctm)) + "-" + ctm % 1000;
	}

}

