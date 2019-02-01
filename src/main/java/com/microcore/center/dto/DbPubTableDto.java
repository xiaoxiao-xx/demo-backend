package com.microcore.center.dto;

import java.util.ArrayList;
import java.util.List;

import com.microcore.center.model.DbPubTable;
import com.microcore.center.model.DbPubTableRel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbPubTableDto extends DbPubTable {

	/**
	 * 列信息
	 */
	private List<DbPubColumnDto> pubColumnDto = new ArrayList<>();

	/**
	 * 扩展信息
 	 */
	private List<DbPubTableExtDto> pubTableExtDtos = new ArrayList<>();

	/**
	 * 表关联信息
	 */
	private List<DbPubTableRel> pubTableRel = new ArrayList<>();
	/**
	 * 模型名称
	 */
	private String modelName;

	/**
	 * 发布人名称
	 */
	private String pubOrgName;

	/**
	 * 发布人机构名称
	 */
	private String pubUserName;

	/**
	 * 创建人名称
	 */
	private String createOrgName;

	/**
	 * 创建人机构名称
	 */
	private String createUserName;

	/**
	 * 数据类别字符串
	 */
	private String dataTypeStr;

	/**
	 * 是否可以撤回
	 */
	private String canBeWithdrawn;

}
