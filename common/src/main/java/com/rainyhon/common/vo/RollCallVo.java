package com.rainyhon.common.vo;

import com.rainyhon.common.model.RollCall;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RollCallVo extends RollCall {
	private String callResName ;
	private String teamName ;
	private String leaderName ;
}
