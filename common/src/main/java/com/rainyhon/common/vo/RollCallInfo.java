package com.rainyhon.common.vo;

import com.rainyhon.common.model.ScheduleDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RollCallInfo extends ScheduleDetail {

	/**
	 * 实到人数
	 */
	private Integer realRollCallCount;

	private String orgName;

	private String teacherName;

	private String addressName;

	/**
	 * 点名状态
	 */
	private String rollCallStatus;

}
