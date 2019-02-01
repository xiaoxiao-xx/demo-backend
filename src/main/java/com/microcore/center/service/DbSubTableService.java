package com.microcore.center.service;

import com.microcore.center.dto.TaskInfo;
import com.microcore.center.model.DbSubTable;
import com.microcore.center.vo.SubTableVo;
import com.microcore.common.util.ResultVo;

import java.util.List;

/**
 * @author lmh
 */
public interface DbSubTableService {

	ResultVo updateSub(SubTableVo subTableVo);

	ResultVo startSub(String id);

	ResultVo batchStartSub(List<String> idList);

	/**
	 * @param id
	 * @return
	 */
	ResultVo stopSub(String id);

	ResultVo batchStopSub(List<String> idList);

	ResultVo deleteSub(String id);

	ResultVo batchDeleteSub(List<String> idList);

	void deleteSubByPubIdAndSubOrgId(String pubId, String subOrgId);

	ResultVo submitTableSubInfo(SubTableVo subInfo);

	/**
	 * @param pubId
	 * @return
	 */
	ResultVo getTableColumns(String pubId);

	/**
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ResultVo getSubList(Integer pageIndex, Integer pageSize);

	ResultVo getAllSubs(String taskName, String pubOrgName, Integer pageIndex, Integer pageSize);

	ResultVo setSubTableStatus(String subId, String taskStatus);

//	List<DbSubTable> getSubsByStatus(String taskStatus);

	ResultVo getColumns(String conId, String tableName);

//	ResultVo subTable(String id);

	/**
	 * 清空缓存
	 *
	 * @param id 订阅ID
	 * @return 清理结果
	 */
	void clearCache(String id);

	/**
	 * 根据ID查询库表发布
	 *
	 * @param id 发布ID
	 * @return DbPubTable对象
	 */
	DbSubTable getSubTableById(String id);

	/**
	 * 获取发布详细信息
	 *
	 * @param id 库表发布ID
	 * @return 发布详细信息
	 */
	ResultVo getDetailedInfo(String id);

	/**
	 * 根据ID查询库表订阅任务名
	 *
	 * @param id 发布ID
	 * @return 任务名
	 */
	TaskInfo getTaskInfoById(String id);

	/**
	 * @param id
	 * @param status
	 */
	void setRunStatus(String id, String status);


}
