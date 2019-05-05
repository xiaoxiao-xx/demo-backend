package com.rainyhon.common.vo;

import lombok.Data;

@Data
public class ColumnVo {

	/**
	 * 字段
	 */
	private String columnName;

	/**
	 * 显示名
	 */
	private String columnDisplayName;

	/**
	 * 类型
	 */
	private String type;
}
