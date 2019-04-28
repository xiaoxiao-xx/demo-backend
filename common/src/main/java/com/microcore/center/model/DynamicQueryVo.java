package com.microcore.center.model;

import com.rainyhon.common.vo.Unary;
import lombok.Data;

import java.util.List;

/**
 * 动态查询视图传输对象
 */
@Data
public class DynamicQueryVo {

	/**
	 * 视图表名
	 */
	private String view;

	/**
	 * 视图显示名
	 */
	private String viewDisplayName;

	/**
	 * 显示字段
	 */
	private List<Column> columns;

	/**
	 * 查询条件
	 */
	private Unary unary;
}
