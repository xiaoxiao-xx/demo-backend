package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbApprovalDto;
import com.microcore.center.model.DbApproval;
import com.microcore.center.vo.DbApprovalVo;
import com.microcore.common.util.ResultVo;

import java.util.List;

/**
 * 审批管理服务
 */
public interface DbApprovalService {

	/**
	 * 根据ID获取审批对象
	 *
	 * @param id 审批ID
	 * @return DbApprovalDto对象
	 */
	DbApprovalDto getDbApprovalById(String id);

	/**
	 * 根据发布ID获取审批
	 *
	 * @param pubId 发布ID
	 * @return DbApprovalDto对象
	 */
	DbApprovalDto getDbApprovalByPubId(String pubId);

	/**
	 * 分页查询审批
	 *
	 * @param type      审批类型 (CreatedByMe-由我发起的审批, ApprovedByMe-由我处理的审批)
	 * @param status    审批状态
	 * @param pageIndex 页码
	 * @param pageSize  每页大小
	 * @return DbApprovalDto对象列表
	 */
	PageInfo<DbApprovalDto> getDbApprovalList(String type, String status, Integer pageIndex, Integer pageSize);

	/**
	 * 添加审批
	 *
	 * @param dbApproval 审批对象
	 * @return 插入的对象
	 */
	DbApproval addApproval(DbApproval dbApproval);


	/**
	 * 根据ID删除审批
	 *
	 * @param id 审批ID
	 */
	ResultVo deleteApprovalById(String id);

	/**
	 * 更新审批
	 *
	 * @param dbApproval 审批对象
	 */
	void handleApproval(DbApprovalVo dbApproval);

	/**
	 * 提交发布审批
	 *
	 * @param dbApproval 审批对象
	 * @return 发布结果
	 */
	ResultVo submitPubApproval(DbApproval dbApproval);

	/**
	 * 批量提交发布审批
	 *
	 * @param list 审批对象列表
	 * @return 发布结果
	 */
	ResultVo submitPubApprovalBatch(List<DbApproval> list);

	/**
	 * 提交发布审批
	 *
	 * @param dbApproval 审批对象
	 * @return 发布结果
	 */
	ResultVo submitSubApproval(DbApproval dbApproval);


	/**
	 * 重新提请审批
	 *
	 * @param dbApproval 审批对象
	 * @return 结果
	 */
	ResultVo resubmitPubApproval(DbApproval dbApproval);

	/**
	 * 查询库表发布为无审批发布还是有审批发布
	 *
	 * @return YES-有审批发布，NO-无审批发布
	 */
	ResultVo pubWithApproval();

}

