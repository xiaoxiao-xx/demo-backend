package com.microcore.center.dto;

import java.util.List;

import com.microcore.center.model.DbPubService;
import com.microcore.center.model.DbServiceParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbPubServiceDto extends DbPubService {
	
	/**
	 * 发布人名
	 */
	private String pubName;

	/**
	 * 输入(INPUT)、输出(OUTPUT)参数List
	 */
	private List<DbServiceParam> parameters;
	
	/**
	 * 授权范围
	 */
	private List<?> realm;

	/**
	 * 发布机构名称
	 */
	private String pubOrgName;

	/**
	 * 是否可以撤回
	 */
	private String canBeWithdrawn;

	private List<String> ids;

}
