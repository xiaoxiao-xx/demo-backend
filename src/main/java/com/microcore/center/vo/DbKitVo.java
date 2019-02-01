package com.microcore.center.vo;

import com.microcore.api.model.DbDbKit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbKitVo extends DbDbKit {

	private String verificationCode;

	private String orgName;
	
	private String runStatus;
}
