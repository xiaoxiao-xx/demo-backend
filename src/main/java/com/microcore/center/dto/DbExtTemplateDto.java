package com.microcore.center.dto;

import com.microcore.center.model.DbExtTemplate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DbExtTemplateDto extends DbExtTemplate {

	/**
	 * 扩展参数值
	 */
	private String extValue;
	/**
	 * 是否必填
	 */
	private String required;

}
