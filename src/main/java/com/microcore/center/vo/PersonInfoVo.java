package com.microcore.center.vo;

import com.microcore.center.model.PsmPersonInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PersonInfoVo extends PsmPersonInfo {

	/**
	 * 机构名称
	 */
	private String deptName ;
}
