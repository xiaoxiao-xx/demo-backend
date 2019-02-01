package com.microcore.center.service;

import com.microcore.center.dto.TaskInfo;
import com.microcore.common.util.ResultVo;

/**
 * 发布订阅任务信息服务
 */
public interface DbPubSubInfoService {

	/**
	 * 获取发布或订阅任务的信息
	 *
	 * @param taskType 任务类型 (发布-PUB/订阅-SUB)
	 * @param dataType 数据类型 (DB/SERVICE/FILE)
	 * @param taskId   任务ID
	 * @return 任务信息
	 */
	TaskInfo getTaskInfo(String taskType, String dataType, String taskId);

	ResultVo pub(String taskType, String dataType, String taskId);

	/**
	 * 设置发布的状态
	 *
	 * @param dataType 数据类型(DB, FILE, SERVICE)
	 * @param id       发布ID
	 * @param status   发布状态
	 */
	void setPubStatus(String dataType, String id, String status);

	void setSubStatus(String dataType, String id);

	void rejectSubStatus(String dataType, String id);
}


