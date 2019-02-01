package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbPubColumnDto;
import com.microcore.center.dto.DbPubTableDto;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.model.DbPubTable;
import com.microcore.center.vo.DbPubTableVo;
import com.microcore.common.vo.WithdrawPubVo;
import com.microcore.common.util.ResultVo;

import java.util.List;

/**
 * 库表发布
 */
public interface DbPubTableService {

	/**
	 * 提交发布信息
	 *
	 * @param dbPubTableVo
	 * @return
	 */
	ResultVo submitTablePubInfo(DbPubTableVo dbPubTableVo);

	/**
	 * @return
	 */
	String getUniqueTableNameSuffix();

	DbPubTable getDbPubTableById(String id);

	/**
	 * @param pubStatus
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ResultVo<List<DbPubTableDto>> getPubList(String pubStatus, Integer pageIndex, Integer pageSize, String orgId);

	ResultVo<PageInfo<DbPubTableDto>> getPubList2(String pubStatus, String pubName, Integer pageIndex, Integer pageSize);

	/**
	 * @param pubStatus
	 * @param pageIndex
	 * @param pageSize
	 * @param pubName
	 * @param pubOrgName
	 * @return
	 */
	ResultVo<PageInfo<DbPubTableDto>> getOthersPubList(String pubStatus, Integer pageIndex,
	                                                   Integer pageSize, String orgId, String pubName, String pubOrgName);

	/**
	 * @param pid
	 * @return
	 */
	List<DbPubColumnDto> getDbPubColumns(String pid);

	/**
	 * 发布库表
	 *
	 * @param id
	 * @return
	 */
	ResultVo pubTable(String id);

	/**
	 * 批量发布库表
	 *
	 * @param idList
	 * @return
	 */
	ResultVo pubTableBatch(List<String> idList);

	/**
	 * @param id
	 * @param status
	 */
	void setRunStatus(String id, String status);

	/**
	 * 启动发布
	 * 将已经发布的库表发布的状态改成RUN
	 *
	 * @param id 发布ID
	 * @return 启动结果
	 */
	ResultVo startPub(String id);

	ResultVo stopPub(String id);

	/**
	 * @param id
	 * @return
	 */
	ResultVo<String> donePub(String id);

	/**
	 * @param dbPubTableVo
	 * @return
	 */
	ResultVo updatePub(DbPubTableVo dbPubTableVo);

	/**
	 * @param id
	 * @return
	 */
	ResultVo deletePub(String id);

	/**
	 * 清空缓存
	 *
	 * @param id 发布ID
	 * @return 清理结果
	 */
	void clearCache(String id);

	/**
	 * 根据ID查询库表发布
	 *
	 * @param id 发布ID
	 * @return DbPubTable对象
	 */
	DbPubTable getPubTableById(String id);

	/**
	 * 根据ID查询库表发布任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	TaskInfo getTaskInfoById(String id);

	/**
	 * 获取发布详细信息
	 *
	 * @param id 库表发布ID
	 * @return 发布详细信息
	 */
	ResultVo getDetailedInfo(String id);

	/**
	 * 设置发布状态
	 *
	 * @param id     发布ID
	 * @param status 发布状态
	 */
	void setPubStatus(String id, String status);

	/**
	 * 撤回发布
	 *
	 * @param vo 撤回信息
	 * @return 撤回结果
	 */
	ResultVo withdrawPub(WithdrawPubVo vo);

	/**
	 * 获取可撤回机构列表
	 *
	 * @param pubId 发布ID
	 * @return 机构列表
	 */
	ResultVo getWithdrawOrgList(String pubId);

	DbPubTable getDbPubTableByMakeTableName(String makeTableName);

	ResultVo batchDeletePub(List<String> idList);

	ResultVo batchStartPub(List<String> idList);

	ResultVo batchStopPub(List<String> idList);

}
