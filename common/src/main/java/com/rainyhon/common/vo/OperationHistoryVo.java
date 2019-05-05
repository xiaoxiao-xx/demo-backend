package com.rainyhon.common.vo;

import com.rainyhon.common.model.OperationHistory;
import lombok.Data;

@Data
public class OperationHistoryVo extends OperationHistory {

	private String operTypeName;

	private String operatorName;

}
