package com.rainyhon.common.vo;

import com.rainyhon.common.model.PersonInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PersonInfoVo extends PersonInfo {

	/**
	 * 机构名称
	 */
	private String deptName;

	/**
	 * 是否在位
	 */
	private boolean onDuty;

	/**
	 * 人员所在区域ID
	 */
	private String areaId;

	/**
	 * 区域
	 */
	private String area;

	/**
	 * 用户展示的机构列表
	 */
	private List<String> displayOrgList;

}
