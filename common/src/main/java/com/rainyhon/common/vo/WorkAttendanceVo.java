package com.rainyhon.common.vo;

import com.rainyhon.common.model.WorkAttendance;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class WorkAttendanceVo extends WorkAttendance {

	private String personName;

	private String resultName;

	private String orgName;

	private String dayOfWeek;

}
