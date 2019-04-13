package com.microcore.center.task;

import com.google.gson.Gson;
import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.model.PsmFace;
import com.microcore.center.service.MaterialService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.FaceSdkRecVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.microcore.center.task.CaptureTask.convertFaces;

/**
 * @author
 */
@Component
@Slf4j
public class AsyncTask {

	@Autowired
	private HttpTemplate httpTemplate;

	@Autowired
	private MaterialService materialService;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	/**
	 *
	 */
	@Async
	public void detect(String materialId, FaceSdkRecVo faceSdkRecVo) {
		long ctm = System.currentTimeMillis();
		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/detect", faceSdkRecVo, String.class);
		log.info("face.ip: {}, face.port: {}", faceApiIp, faceApiPort);

		// 保存人脸识别结果
		Gson gson = new Gson();
		CaptureTask.DetectResult result = gson.fromJson(ret, CaptureTask.DetectResult.class);

		List<CaptureTask.FaceInfo> faces = result.getFaces();
		if (faces == null) {
			faces = new ArrayList<>();
		}

		List<PsmFace> faceList = convertFaces(materialId, faces);
		faceList.forEach(face -> {
			// face.setUserId(CommonUtil.random("1", "2", "u17", "u9", "u3", "u4", "u5", "u6", "u7", "u8"));
		});

		materialService.addFaceList(faceList);

		log.info(">>> detect cost=" + (System.currentTimeMillis() - ctm) + "ms, ret=" + ret);

		// log.info("thread id= {}", Thread.currentThread().getName());
	}

}
