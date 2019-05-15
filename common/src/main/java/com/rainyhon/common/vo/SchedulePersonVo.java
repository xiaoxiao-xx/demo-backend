package com.rainyhon.common.vo;

import com.rainyhon.common.model.SchedulePerson;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SchedulePersonVo extends SchedulePerson {

	private String orgId;

}
