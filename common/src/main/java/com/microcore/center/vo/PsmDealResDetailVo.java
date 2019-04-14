package com.microcore.center.vo;

import com.microcore.center.model.PsmDealResDetail;
import com.microcore.center.model.PsmPersonInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PsmDealResDetailVo extends PsmDealResDetail {
	private PsmPersonInfo psmPersonInfo ;
}
