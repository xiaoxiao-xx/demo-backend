package com.rainyhon.common.vo;

import com.rainyhon.common.model.AlarmPolicy;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlarmPolicyVo extends AlarmPolicy {

	private String alarmTypeName;

	private String alarmModeName;

}
