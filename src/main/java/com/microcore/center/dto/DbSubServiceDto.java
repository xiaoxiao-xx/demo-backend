package com.microcore.center.dto;

import com.microcore.center.model.DbServiceParam;
import com.microcore.center.model.DbSubService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbSubServiceDto extends DbSubService {

	/**
	 * 发布人名
	 */
	private String pubName;

	/**
	 * 发布机构名
	 */
	private String pubOrgName;

	/**
	 * 输入(INPUT)、输出(OUTPUT)参数List
	 */
	private List<DbServiceParam> parameters;

}
