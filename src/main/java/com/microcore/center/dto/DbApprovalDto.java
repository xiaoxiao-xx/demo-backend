package com.microcore.center.dto;

import com.microcore.center.model.DbApproval;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbApprovalDto extends DbApproval {

	/**
	 * 申请任务名称
	 */
	private String taskName;

	/**
	 * 申请任务描述
	 */
	private String taskDesc;

	/**
	 * 审批人名
	 */
	private String approverUserName;

	/**
	 * 审批人机构名
	 */
	private String approverOrgName;

	/**
	 * 申请人姓名
	 */
	private String applicantName;

	/**
	 * 申请人机构名
	 */
	private String applicantOrgName;

	/**
	 * 申请任务详情
	 */
	private Object taskInfo;

}
