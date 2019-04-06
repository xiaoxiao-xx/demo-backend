package com.microcore.center.vo;

import com.microcore.center.model.PsmAlarmStrategy;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PsmAlarmStrategyVo extends PsmAlarmStrategy {
	private String alarmTypeName ;
	private String alarmModeName ;
}
