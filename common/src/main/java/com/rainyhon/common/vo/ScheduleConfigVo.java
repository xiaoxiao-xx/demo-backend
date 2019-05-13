package com.rainyhon.common.vo;

import com.rainyhon.common.model.ScheduleConfig;
import com.rainyhon.common.model.SchedulePerson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ScheduleConfigVo extends ScheduleConfig {

	private List<SchedulePerson> schedulePersonList;

}
