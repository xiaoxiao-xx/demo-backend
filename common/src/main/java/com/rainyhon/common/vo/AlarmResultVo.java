package com.rainyhon.common.vo;

import com.microcore.center.model.AlarmResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlarmResultVo extends AlarmResult {

	private String stateName;

	private String alarmTypeName;

	private String groupString;

}
