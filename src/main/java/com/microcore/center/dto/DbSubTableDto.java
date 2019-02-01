package com.microcore.center.dto;

import java.util.ArrayList;
import java.util.List;

import com.microcore.center.model.DbPubTable;
import com.microcore.center.model.DbSubTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lmh
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DbSubTableDto extends DbSubTable {

	/**
	 * 打标表名
	 */
	private String makeTableName;

	/**
	 * 列信息
	 */
	private List<DbSubColumnDto> subColumnDto = new ArrayList<>();

	/**
	 * 发布机构名称
	 */
	private String pubOrgName;

	/**
	 * 数据源名称
	 */
	private String dataSourceName;

	/**
	 * 发布任务名称
	 */
	private String pubTaskName;

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 发布人
	 */
	private String pubUserName;

	/**
	 * 订阅用户名
	 */
	private String subUserName;

	/**
	 * 订阅机构名
	 */
	private String subOrgName;

	/**
	 * 目的表类型（新建的-NEW，已有的-EXISTING）
	 */
	private String storeTableType;

	private DbPubTable pubTable;

	/**
	 * 脱标目的数据库名
	 */
	private String targetDbName;

}
