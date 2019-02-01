package com.microcore.center.dto;

import com.microcore.api.model.DbDbKit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbDbKitDto extends DbDbKit {

	/**
	 * 当前套件所属机构的排序号
	 */
	private Integer currentOrgSort;

}

