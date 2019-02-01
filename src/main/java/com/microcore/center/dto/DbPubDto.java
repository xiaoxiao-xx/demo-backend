package com.microcore.center.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbPubDto {

	private String id;
	/**
	 * 发布名称
	 */
	private String pubName;
	/**
	 * 发布描述
	 */
	private String pubDesc;
	/**
	 * 关键字
	 */
	private String keywords;
	/**
	 * 行业类别
	 */
	private String type;
	/**
	 * 发布机构
	 */
	private String org;
	/**
	 * 资源类型
	 */
	private String dataType;
	
	
	
}
