package com.microcore.center.service;

import com.microcore.api.model.DbSubTs;
import com.microcore.api.vo.DbSubTsVo;
import com.microcore.center.dto.TaskInfo;
import com.microcore.common.util.ResultVo;

import java.util.List;

/**
 *
 */
public interface DbSubTsService {

	ResultVo addSub(DbSubTsVo vo);

	TaskInfo getTaskInfoById(String taskId);

	DbSubTs getSubTsById(String id);

	void setStatus(String id, String status);

	void startSub(String id);

	void batchStartSub(List<String> idList);

	void stopSub(String id);

	void batchStopSub(List<String> idList);

	void deleteSub(String id);

	void batchDeleteSub(List<String> idList);

	ResultVo getDetailedInfo(String id);

	ResultVo getSubList(String taskName, Integer pageIndex, Integer pageSize);

}
