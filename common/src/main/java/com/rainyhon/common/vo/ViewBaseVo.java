package com.rainyhon.common.vo;

import com.rainyhon.common.vo.ColumnVo;
import lombok.Data;

import java.util.List;

/**
 * 动态查询视图传输对象
 */
@Data
public class ViewBaseVo {

	/**
	 * 视图表名
	 */
	private String viewName;

	/**
	 * 显示字段
	 */
	private List<ColumnVo> columns;
}
