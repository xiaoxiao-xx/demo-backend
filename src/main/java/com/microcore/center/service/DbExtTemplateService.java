package com.microcore.center.service;

import com.microcore.center.dto.DbExtTemplateDto;
import com.microcore.center.model.DbExtTemplate;
import com.microcore.common.util.ResultVo;

import java.util.List;

/**
 * 策略扩展服务
 */
public interface DbExtTemplateService {

	/**
	 * 查询所有扩展属性
	 *
	 * @return 扩展属性列表
	 */
	List<DbExtTemplateDto> getExtTemplateList(String templateType, boolean getAll);

	/**
	 * 添加扩展属性
	 *
	 * @param extTemplate 扩展属性对象
	 * @return 插入的对象
	 */
	void addExtTemplate(DbExtTemplate extTemplate);

	/**
	 * 根据ID删除扩展属性
	 *
	 * @param id ID
	 */
	ResultVo<String> deleteExtTemplateById(String id);

	/**
	 * 更新扩展属性
	 *
	 * @param extTemplate 扩展属性对象
	 */
	void updateExtTemplate(DbExtTemplate extTemplate);

	/**
	 * 根据ID查询扩展属性
	 *
	 * @param id 扩展属性ID
	 * @return DbExtTemplateDto对象
	 */
	DbExtTemplateDto getExtTemplateById(String id);

}

