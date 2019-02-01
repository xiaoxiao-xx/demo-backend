package com.microcore.center.vo;

import com.microcore.center.model.DbServiceParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class UseService {

	/**
	 * 使用凭证
	 */
	private String token;

	/**
	 * 输入or输出参数
	 */
	private LinkedHashMap<String, Object> parameters;

	/**
	 * 详细的输入参数 包括类型
	 */
	private List<DbServiceParam> inputParams;

}
