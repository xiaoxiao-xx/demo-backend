package com.microcore.center.vo;

import java.util.List;
import java.util.Map;

import com.microcore.center.model.DbPolicyItem;
import com.microcore.center.model.DbPubService;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 新增或修改接口服务VO类
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AddPubServiceVo extends DbPubService {
	
	/**
	 * 发布人名
	 */
	private String pubName;

	/**
	 * 输入(INPUT)、输出(OUTPUT)参数List
	 */
//	private List<AddServiceParamVo> parameters;
	private List<Map<String,Object>> parameters;
	/**
	 * 自定义策略扩展参数
	 */
//	private List<DbExtTemplateDto> template;
	private List<Map<String,Object>> template;
	/**
	 * 授权范围
	 */
	private List<?> realm;

	/**
	 * 发布机构名称
	 */
	private String pubOrgName;

	/**
	 *策略模板信息
	 */
	private DbPolicyItem dbPolicyItem;

}
