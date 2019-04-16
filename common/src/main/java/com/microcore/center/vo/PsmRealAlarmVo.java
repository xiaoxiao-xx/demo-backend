package com.microcore.center.vo;

import com.microcore.center.model.PsmRealAlarm;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PsmRealAlarmVo extends PsmRealAlarm {
	private String stateName ; 
	private String alarmTypeName ;

	private String groupString;

}
