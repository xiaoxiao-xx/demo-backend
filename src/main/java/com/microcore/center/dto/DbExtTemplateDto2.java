package com.microcore.center.dto;

import com.microcore.center.model.DbExtTemplate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DbExtTemplateDto2 extends DbExtTemplate {

	/**
	 * 序号
	 */
	private Integer sequenceNumber;

	/**
	 * 是否必填
	 */
	private String required;

}
