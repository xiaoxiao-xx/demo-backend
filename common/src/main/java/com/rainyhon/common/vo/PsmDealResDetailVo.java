package com.rainyhon.common.vo;

import com.microcore.center.model.PsmDealResDetail;

import com.rainyhon.common.model.PersonInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PsmDealResDetailVo extends PsmDealResDetail {
	private PersonInfo personInfo ;
}
