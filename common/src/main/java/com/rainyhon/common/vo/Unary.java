package com.rainyhon.common.vo;

import lombok.Data;

import java.util.List;

/**
 * 一元
 */
@Data
public class Unary {

	/**
	 * 后一元
	 */
	private Unary aftUnary;

	/**
	 * 关系运算符  and or
	 */
	private String relation;

	/**
	 * 子一元组
	 */
	private Unary childUnary;

	/**
	 * 排序
	 */
	private Integer order;

	/**
	 * 字段名称
	 */
	private String column;

	/**
	 * 字段显示名
	 */
	private String columnDisplayName;

	/**
	 * 数据类型
	 */
	private String type;

	/**
	 * 字段值
	 */
	private String value;

	/**
	 * 逻辑运算符 gt lt eq between
	 */
	private String condition;
}
