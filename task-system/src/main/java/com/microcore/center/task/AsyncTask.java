package com.microcore.center.task;


import com.google.gson.Gson;
import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.model.PsmFace;
import com.microcore.center.service.MaterialService;
import com.microcore.center.vo.FaceSdkRecVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

	/**
	 *
	 */
	@Async
	public void detect(String materialId, FaceSdkRecVo faceSdkRecVo) {
		long ctm = System.currentTimeMillis();
		String ret = httpTemplate.post("127.0.0.1", "8080", "/face/api/v1/detect", faceSdkRecVo, String.class);

		// 保存识别结果
		Gson gson = new Gson();
		CaptureTask.DetectResult result = gson.fromJson(ret, CaptureTask.DetectResult.class);

		List<CaptureTask.FaceInfo> faces = result.getFaces();
		if (faces == null) {
			faces = new ArrayList<>();
		}

		List<PsmFace> faceList = convertFaces(materialId, faces);
		materialService.addFaceList(faceList);

		log.info(">>>detect cost=" + (System.currentTimeMillis() - ctm) + "ms, ret=" + ret);

		log.info("thread id= {}", Thread.currentThread().getName());
	}

}
