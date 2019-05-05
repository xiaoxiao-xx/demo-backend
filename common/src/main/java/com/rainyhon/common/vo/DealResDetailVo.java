package com.rainyhon.common.vo;

import com.rainyhon.common.model.DealResDetail;
import com.rainyhon.common.model.PersonInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DealResDetailVo extends DealResDetail {
	private PersonInfo personInfo ;
}
