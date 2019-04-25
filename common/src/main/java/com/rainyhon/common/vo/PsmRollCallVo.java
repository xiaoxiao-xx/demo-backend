package com.rainyhon.common.vo;

import com.microcore.center.model.PsmRollCall;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PsmRollCallVo extends PsmRollCall {
	private String callResName ;
	private String teamName ;
	private String leaderName ;
}
