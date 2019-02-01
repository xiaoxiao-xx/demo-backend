package com.microcore.center.service.impl;

import com.microcore.center.dto.TaskInfo;
import com.microcore.center.service.*;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.ResultVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 发布订阅任务信息服务
 *
 * @author lmh
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DbPubSubInfoServiceImpl implements DbPubSubInfoService {

	@Autowired
	private DbPubTableService dbPubTableService;

	@Autowired
	private DbPubTsService dbPubTsService;

	@Autowired
	private DbPubFileService dbPubFileService;

	@Autowired
	private DbPubServiceService dbPubServiceService;

	@Autowired
	private DbSubTableService dbSubTableService;

	@Autowired
	private DbSubTsService dbSubTsService;

	@Autowired
	private DbSubFileService dbSubFileService;

	@Autowired
	private DbSubServiceService dbSubServiceService;

	/**
	 * 获取发布或订阅任务的信息
	 *
	 * @param taskType 任务类型 (发布-PUB/订阅-SUB)
	 * @param dataType 数据类型 (DB/SERVICE/FILE)
	 * @param taskId   任务ID
	 * @return 任务信息
	 */
	@Override
	public TaskInfo getTaskInfo(String taskType, String dataType, String taskId) {
		TaskInfo taskInfo = null;

		if ("PUB".equals(taskType)) {
			switch (dataType) {
				case "DB":
					taskInfo = dbPubTableService.getTaskInfoById(taskId);
					break;

				case "DBS":
					taskInfo = dbPubTsService.getTaskInfoById(taskId);
					break;

				case "FILE":
					taskInfo = dbPubFileService.getTaskInfoById(taskId);
					break;

				case "SERVICE":
					taskInfo = dbPubServiceService.getTaskInfoById(taskId);
					break;

				default:
					break;
			}
		} else {
			switch (dataType) {
				case "DB":
					taskInfo = dbSubTableService.getTaskInfoById(taskId);
					break;

				case "DBS":
					taskInfo = dbSubTsService.getTaskInfoById(taskId);
					break;

				case "FILE":
					taskInfo = dbSubFileService.getTaskInfoById(taskId);
					break;

				case "SERVICE":
					taskInfo = dbSubServiceService.getTaskInfoById(taskId);
					break;

				default:
					break;
			}
		}

		return taskInfo;
	}

	@Override
	public ResultVo pub(String taskType, String dataType, String taskId) {
		ResultVo res = null;
		if ("PUB".equals(taskType)) {
			switch (dataType) {
				case "DB":
					res = dbPubTableService.pubTable(taskId);
					break;
				case "DBS":
					dbPubTsService.pubTs(taskId);
					res = ResultVo.ok();
					break;
				case "FILE":
					res = dbPubFileService.pubFile(taskId);
					break;
				case "SERVICE":
					res = dbPubServiceService.publishService(taskId);
					break;
				default:
					break;
			}
		}
		return res;
	}

	/**
	 * 设置发布的状态
	 *
	 * @param dataType 数据类型(DB, FILE, SERVICE)
	 * @param id       发布ID
	 * @param status   发布状态
	 */
	@Override
	public void setPubStatus(String dataType, String id, String status) {
		switch (dataType) {
			case "DB":
				dbPubTableService.setPubStatus(id, status);
				break;

			case "DBS":
				dbPubTsService.setPubStatus(id, status);
				break;

			case "FILE":
				dbPubFileService.pubDbPubFile(id, status);
				break;

			case "SERVICE":
				dbPubServiceService.pubStatus(id, status);
				break;

			default:
				break;
		}
	}

	@Override
	public void setSubStatus(String dataType, String id) {
		switch (dataType) {
			case "DB":
				dbSubTableService.stopSub(id);
				break;

			case "DBS":
				dbSubTsService.stopSub(id);
				break;

			case "FILE":
				dbSubFileService.stopSubFile(id, Constants.RUN_STATUS_STOP);
				break;

			case "SERVICE":
				dbSubServiceService.setStatus(id, Constants.RUN_STATUS_RUN);
				break;

			default:
				break;
		}
	}

	@Override
	public void rejectSubStatus(String dataType, String id) {
		switch (dataType) {
			case "DB":
				dbSubTableService.setRunStatus(id, Constants.PUB_STATUS_REJECTED);
				break;

			case "DBS":
				dbSubTsService.setStatus(id, Constants.PUB_STATUS_REJECTED);
				break;

			case "FILE":
				dbSubFileService.setSubFile(id, Constants.PUB_STATUS_REJECTED);
				break;

			case "SERVICE":
				dbSubServiceService.setStatus(id, Constants.PUB_STATUS_REJECTED);
				break;

			default:
				break;
		}
	}

}

