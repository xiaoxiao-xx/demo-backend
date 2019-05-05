package com.rainyhon.common.vo;

import com.rainyhon.common.model.AlarmResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlarmResultVo extends AlarmResult {

	private String stateName;

	private String alarmTypeName;

	private String groupString;

}
