package com.microcore.center.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 库表订阅请求信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SubTableVo {
	
	/**
	 * 表ID
	 */
	private String pubId;

	/**
	 * 要脱标的表
	 */
	private String distillTableName;

	/**
	 * 任务名
	 */
	private String taskName;

	/**
	 * 任务描述
	 */
	private String taskDesc;

	/**
	 * 脱标后的目的表的表名
	 */
	private String storeTableName;
	
	/**
	 * 目的表类型（新建的-NEW，已有的-EXISTING） 
	 */
	private String storeTableType;
	
	/**
	 * 连接ID
	 */
	private String conId;
	
	/**
	 * 发布任务ID (pubId的整型版)
	 */
	private int taskId;

	/**
	 * 列信息
	 */
	private List<Map<String, String>> columnList = new ArrayList<>();

	/**
	 * 发布人ID
	 */
	private String pubUserId;

	/**
	 * 发布机构ID
	 */
	private String pubOrgId;

}
