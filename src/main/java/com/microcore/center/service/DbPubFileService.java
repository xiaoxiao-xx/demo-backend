package com.microcore.center.service;

import com.microcore.center.dto.DbPubFileDto;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.model.DbParams;
import com.microcore.center.model.DbPubFile;
import com.microcore.common.util.ResultVo;
import com.microcore.common.vo.WithdrawPubVo;

import java.util.List;

/**
 */
public interface DbPubFileService {

	ResultVo addDbPubFile(DbPubFileDto dbPubFileDto);

	ResultVo updDbPubFile(DbPubFileDto dbPubFileDto);

	ResultVo delDbPubFile(String fid);
	
	ResultVo delDbPubFileOfBatch(String[] ids);

	ResultVo startDbPubFile(String fid);
	
	ResultVo startDbPubFileOfBatch(String[] ids);

	ResultVo stopDbPubFileOfBatch(String[] ids);
	/**
	 * 提交发布申请（审批流程）
	 *
	 * @param fid    发布id
	 * @param status 发布状态
	 * @return
	 */
	ResultVo pubDbPubFile(String fid, String status);

	/**
	 * 文件发布（无审批流程）
	 *
	 * @param fid 发布id
	 * @return
	 */
	ResultVo pubFile(String fid);
	
	ResultVo pubFileOfBatch(String[] ids);

	ResultVo cleanFileCache(String fid);

	ResultVo getDbPubFile(String fid);

	/**
	 * 根据ID查询文件发布任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	TaskInfo getTaskInfoById(String id);

	ResultVo getDbPubFilelistO(String autoChange, String pubName, String pubPath, Integer pageIndex, Integer pageSize);

	ResultVo getDbPubFilelistT(String orgId, String autoChange, String pubName, String pubPath, Integer pageIndex, Integer pageSize);

	String addParams(String dto, List<DbParams> senGrade);

	DbPubFile dbPubFile(String fid);

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

	ResultVo getDbPubFileDetails(String fid);
}
