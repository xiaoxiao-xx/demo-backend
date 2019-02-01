package com.microcore.center.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 发布和订阅任务信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TaskInfo {

	/**
	 * 任务名
	 */
	private String taskName;

	/**
	 * 任务描述
	 */
	private String taskDesc;

}
