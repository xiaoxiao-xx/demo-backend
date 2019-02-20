package com.microcore.center.vo;

import com.microcore.center.model.PsmPersonInfo;

import lombok.Data;
@Data
public class PersonInfoVo extends PsmPersonInfo {
	/**
	 * 机构名称
	 */
	private String deptName ;
}
