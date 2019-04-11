package com.microcore.center.vo;

import com.microcore.center.model.PsmOperHis;

import lombok.Data;
@Data
public class PsmOperHisVo extends PsmOperHis {
	private String operTypeName ;
	private String operatorName ;
}
