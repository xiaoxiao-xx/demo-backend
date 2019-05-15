package com.rainyhon.common.vo;

import com.rainyhon.common.model.ScheduleDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ScheduleDetailVo extends ScheduleDetail {

	/**
	 * 主管姓名
	 */
	private String teacherName;

	/**
	 * 所属区域
	 */
	private String areaName;

	/**
	 * 结果
	 */
	private String resultName;

	/**
	 * 所属机构
	 */
	private String crtOrgName;

}
