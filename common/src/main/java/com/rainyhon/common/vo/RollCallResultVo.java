package com.rainyhon.common.vo;

import com.rainyhon.common.model.RollCallResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RollCallResultVo extends RollCallResult {

	private String resultStr;

	private String personName;

	private String orgName;

}
