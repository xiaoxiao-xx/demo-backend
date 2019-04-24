package com.microcore.center.vo;

import com.microcore.center.model.AlarmPolicy;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlarmPolicyVo extends AlarmPolicy {

	private String alarmTypeName;

	private String alarmModeName;

}
