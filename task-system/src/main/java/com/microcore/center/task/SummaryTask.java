package com.microcore.center.task;

import com.google.gson.Gson;
import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.model.PsmFace;
import com.microcore.center.service.MaterialService;
import com.microcore.center.service.SummaryService;
import com.microcore.center.vo.FaceSdkRecVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.microcore.center.task.CaptureTask.convertFaces;

/**
 * 汇总任务
 */
@Component
@Slf4j
public class SummaryTask {

	@Autowired
	private HttpTemplate httpTemplate;

	@Autowired
	private MaterialService materialService;

	@Autowired
	private SummaryService summaryService;

	/**
	 *
	 */
	@Async
	public void detect(String materialId, FaceSdkRecVo faceSdkRecVo) {
	}

}
