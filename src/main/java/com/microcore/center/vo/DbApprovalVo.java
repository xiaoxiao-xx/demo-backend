package com.microcore.center.vo;

import com.microcore.center.model.DbApproval;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbApprovalVo extends DbApproval {

	/**
	 * 消息ID
	 */
	private String msgId;

}
