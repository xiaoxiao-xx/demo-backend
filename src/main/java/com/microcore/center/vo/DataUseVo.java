package com.microcore.center.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DataUseVo {

	/**
	 * 机构信息
	 */
	private Object orgObj;
	/**
	 * 机构数据流转信息(发布)
	 */
	private Object orgPubObj;
	/**
	 * 机构数据流转信息(订阅)
	 */
	private Object orgSubObj;
	
}
