package com.rainyhon.common.vo;

import lombok.Data;

/**
 * 动态查询视图传输对象
 */
@Data
public class ViewQueryVo extends ViewBaseVo{

	/**
	 * 查询条件
	 */
	private Unary unary;

	private Integer pageIndex;

	private Integer pageSize;
}
