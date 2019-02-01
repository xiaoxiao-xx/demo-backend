package com.microcore.center.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WithdrawOrgDto {

	private String orgId;

	private String orgName;

	public WithdrawOrgDto() {
	}

	public WithdrawOrgDto(String orgId, String orgName) {
		this.orgId = orgId;
		this.orgName = orgName;
	}

}
