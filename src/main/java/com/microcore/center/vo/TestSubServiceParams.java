package com.microcore.center.vo;

import com.microcore.center.model.DbServiceParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class TestSubServiceParams {
	
	/**
	 * 使用凭证
	 */
	private String token;
	
	/**
	 * 输入or输出参数
	 */
	//private LinkedHashMap<String, Object> parameters;
	/**
	 * 请求参数
	 */
	private List<DbServiceParam> parameters;


	//	public LinkedHashMap<String, Object> getParameters() {
//		return parameters;
//	}
//
//	public void setParameters(LinkedHashMap<String, Object> parameters) {
//		this.parameters = parameters;
//	}
}
