package com.microcore.center.service;

import com.microcore.center.dto.TaskInfo;
import com.microcore.center.model.DbPubFile;
import com.microcore.common.util.ResultVo;
import com.microcore.center.dto.DbSubFileDto;

/**
 * @Auther: ZY
 * @Date: 2018/8/9 19:19:12
 * @描述：
 */
public interface DbSubFileService {

	ResultVo addDbSubFile(DbSubFileDto dbSubFileDto);

	ResultVo addDbSubFileWithApproval(DbSubFileDto filesDto);

	ResultVo updDbSubFile(DbSubFileDto dbSubFileDto);

	ResultVo delDbSubFile(String sid);

	ResultVo getDbSubFile(String sid);

	ResultVo getDbSubFileListA(String orgName, String subName, String pubUser, Integer pageIndex, Integer pageSize);

	ResultVo getDbSubFileListC(String orgId, String orgName, String pubName, String pubUserName, Integer pageIndex, Integer pageSize);

	ResultVo pubDbSubFile(String sid);

	ResultVo stopSubFile(String sid, String status);

	void setSubFile(String sid, String status);

	ResultVo startSubFile(String sid);

	/**
	 * 根据ID查询文件订阅任务名
	 *
	 * @param id 发布ID
	 * @return 任务名
	 */
	TaskInfo getTaskInfoById(String id);

	void deleteSubByPubIdAndSubOrgId(String pubId, String subOrgId);
	
	void autoChangeOfSubFile(DbPubFile dFile);
	
	ResultVo startSubFileOfBatch(String[] ids);

	ResultVo stopSubFileOfBatch(String[] ids);
	
	ResultVo delSubFileOfBatch(String[] ids);
	
	ResultVo subFileOfBatch(String[] ids);

}
