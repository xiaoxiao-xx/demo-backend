package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbPubTs;
import com.microcore.api.vo.DbPubTsVo;
import com.microcore.center.dto.TaskInfo;
import com.microcore.common.util.ResultVo;

import java.util.List;
import java.util.Map;

/**
 * @author lmh
 */
public interface DbPubTsService {

	/**
	 * @param pubName
	 * @param status
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	PageInfo<DbPubTsVo> getPubList(String pubName, String status, String pubStatus,
	                               String orgId, Integer pageIndex, Integer pageSize);

	/**
	 * @param dbPubTsVo
	 * @return
	 */
	ResultVo<?> add(DbPubTsVo dbPubTsVo);

	void pubTs(String id);

	void setPubStatus(String id, String status);

	/**
	 * @param id
	 * @return
	 */
	ResultVo<?> del(String id);

	void setRunStatus(String id, String status);

	void startPub(String id);

	void stopPub(String id);

	PageInfo<DbPubTsVo> getOthersPubList(String pubName, String status, String orgId,
	                                     String pubStatus, Integer pageIndex, Integer pageSize);

	ResultVo getDetailedInfo(String id);

	DbPubTsVo getDetailedPubTsInfo(String id);

	DbPubTs getPubTsById(String id);

	/**
	 * 根据ID查询发布任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	TaskInfo getTaskInfoById(String id);

	List<Map<String, String>> getInterfaceType();

	ResultVo batchDeletePub(List<String> idList);

	ResultVo pubBatch(List<String> idList);

	ResultVo batchStartPub(List<String> idList);

	ResultVo batchStopPub(List<String> idList);

}
