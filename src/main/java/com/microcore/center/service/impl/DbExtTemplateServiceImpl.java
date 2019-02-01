package com.microcore.center.service.impl;

import com.microcore.center.dto.DbExtTemplateDto;
import com.microcore.center.mapper.DbExtTemplateMapper;
import com.microcore.center.mapper.DbPolicyTemplateMapper;
import com.microcore.center.model.DbExtTemplate;
import com.microcore.center.model.DbExtTemplateExample;
import com.microcore.center.model.DbPolicyTemplateExample;
import com.microcore.center.service.DbExtTemplateService;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microcore.common.constant.Constants.DEL_STATUS_NOR;

/**
 * 策略扩展服务
 */
@Service
@Transactional
public class DbExtTemplateServiceImpl implements DbExtTemplateService {

	@Autowired
	private DbExtTemplateMapper dbExtTemplateMapper;

	@Autowired
	private DbPolicyTemplateMapper dbPolicyTemplateMapper;

	/**
	 * 查询所有扩展属性
	 *
	 * @return 扩展属性列表
	 */
	@Override
	public List<DbExtTemplateDto> getExtTemplateList(String templateType, boolean getAll) {
		DbExtTemplateExample example = new DbExtTemplateExample();
		DbExtTemplateExample.Criteria criteria = example.createCriteria();

		if (!getAll) {
			criteria.andVisiableEqualTo("1");
		}

		if (StringUtil.isNotEmpty(templateType)) {
			criteria.andTemplateTypeEqualTo(templateType);
		}

		criteria.andDelStatusEqualTo(DEL_STATUS_NOR);
		// TODO 暂时不支持ENUM类型
		// criteria.andDataTypeNotEqualTo("ENUM");
		return CommonUtil.listPo2VO(dbExtTemplateMapper.selectByExample(example), DbExtTemplateDto.class);
	}

	/**
	 * 添加扩展属性
	 *
	 * @param extTemplate 扩展属性对象
	 * @return 插入的对象
	 */
	@Override
	public void addExtTemplate(DbExtTemplate extTemplate) {
		extTemplate.setId(CommonUtil.getUUID());
		extTemplate.setVersion("1.0");
		extTemplate.setVisiable("1");
		extTemplate.setDelStatus(DEL_STATUS_NOR);
		dbExtTemplateMapper.insert(extTemplate);
	}

	/**
	 * 根据ID删除扩展属性
	 *
	 * @param id ID
	 */
	@Override
	public ResultVo<String> deleteExtTemplateById(String id) {
		// 如果被依赖，将不会删除
		if (getPolicyTemplateCountByTemplateId(id) > 0) {
			return ResultVo.fail("该规则已经被依赖，不可删除");
		}

		DbExtTemplate template = new DbExtTemplate();
		template.setId(id);
		template.setDelStatus(Constants.DEL_STATUS_DEL);
		dbExtTemplateMapper.updateByPrimaryKeySelective(template);

		return ResultVo.ok();
	}

	private int getPolicyTemplateCountByTemplateId(String id) {
		DbPolicyTemplateExample example = new DbPolicyTemplateExample();
		DbPolicyTemplateExample.Criteria criteria = example.createCriteria();
		criteria.andExtTemplateIdEqualTo(id);
		return dbPolicyTemplateMapper.countByExample(example);
	}

	/**
	 * 更新扩展属性
	 *
	 * @param extTemplate 扩展属性对象
	 */
	@Override
	public void updateExtTemplate(DbExtTemplate extTemplate) {
		dbExtTemplateMapper.updateByPrimaryKey(extTemplate);
	}

	/**
	 * 根据ID查询扩展属性
	 *
	 * @param id 扩展属性ID
	 * @return DbExtTemplateDto对象
	 */
	@Override
	public DbExtTemplateDto getExtTemplateById(String id) {
		DbExtTemplate template = dbExtTemplateMapper.selectByPrimaryKey(id);
		return CommonUtil.po2VO(template, DbExtTemplateDto.class);
	}

}

