package com.microcore.center.model;

import com.rainyhon.common.vo.Unary;
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

}
