package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbModelDetailDto;
import com.microcore.center.mapper.DbElementMapper;
import com.microcore.center.model.DbElement;
import com.microcore.center.model.DbElementExample;
import com.microcore.center.model.DbModelDetail;
import com.microcore.center.service.DbElementService;
import com.microcore.center.vo.DbElementVo;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lmh
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DbElementServiceImpl implements DbElementService {

	@Autowired
	private DbElementMapper dbElementMapper;

	@Override
	public ResultVo<?> queryCoreElement(String name) {
		return ResultVo.ok(queryDbElementVo(name, "core"));
	}

	@Override
	public ResultVo<?> queryDefineElement(String name) {
		return ResultVo.ok(queryDbElementVo(name, "define"));
	}

	@Override
	public List<DbElementVo> queryDbElementVo(String name, String type) {
		DbElementExample example = createExample(name, type);
		return CommonUtil.listPo2VO(dbElementMapper.selectByExample(example), DbElementVo.class);
	}

	@Override
	public PageInfo queryDbElementVo(String name, String type, Integer pageIndex, Integer pageSize) {
		DbElementExample example = createExample(name, type);
		return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() ->
				dbElementMapper.selectByExample(example));
	}

	private DbElementExample createExample(String name, String type) {
		DbElementExample example = new DbElementExample();
		DbElementExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(type)) {
			criteria.andTypeEqualTo(type);
		}
		criteria.andDelStatusEqualTo("NOR");
		if (StringUtil.isNotEmpty(name)) {
			criteria.andNameLike("%" + name.trim() + "%");
		}
		return example;
	}

	@Override
	public ResultVo addElement(DbElementVo dbElementVo) {
		DbElement dbElement = new DbElement();
		dbElement.setId(CommonUtil.getUUID());
		dbElement.setCond(dbElementVo.getCond());
		dbElement.setDataType(dbElementVo.getDataType());
		dbElement.setDefine(dbElementVo.getDefine());
		dbElement.setName(dbElementVo.getName());
		dbElement.setRemark(dbElementVo.getRemark());
		dbElement.setShowTimes(dbElementVo.getShowTimes());
		EntityUtils.setCreateInfo(dbElement);
		dbElementMapper.insert(dbElement);
		return ResultVo.ok();
	}

	@Override
	public ResultVo updateElement(DbElementVo dbElementVo) {
		DbElement dbElement = dbElementMapper.selectByPrimaryKey(dbElementVo.getId());
		dbElement.setCond(dbElementVo.getCond());
		dbElement.setDataType(dbElementVo.getDataType());
		dbElement.setDefine(dbElementVo.getDefine());
		dbElement.setName(dbElementVo.getName());
		dbElement.setRemark(dbElementVo.getRemark());
		dbElement.setShowTimes(dbElementVo.getShowTimes());
		EntityUtils.setUpdateInfo(dbElement);
		dbElementMapper.updateByPrimaryKey(dbElement);
		return ResultVo.ok();
	}

	@Override
	public ResultVo delElement(String id) {
		DbElement dbElement = dbElementMapper.selectByPrimaryKey(id);
		dbElement.setDelStatus("DEL");
		EntityUtils.setUpdateInfo(dbElement);
		dbElementMapper.updateByPrimaryKey(dbElement);
		return ResultVo.ok();
	}

	@Override
	public DbElementVo getElement(String id) {
		DbElement dbElement = dbElementMapper.selectByPrimaryKey(id);
		return CommonUtil.po2VO(dbElement, DbElementVo.class);
	}

	@Override
	public ResultVo getDbElements() {
		DbElementExample example = new DbElementExample();
		DbElementExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		List<DbElement> elementList = dbElementMapper.selectByExample(example);
		List<DbModelDetailDto> list = new ArrayList<>();
		for (DbElement element : elementList) {
			DbModelDetailDto modelDetail = new DbModelDetailDto();
			modelDetail.setId(element.getId());
			modelDetail.setFieldCname(element.getName());
			modelDetail.setFieldEname(element.getId());
			modelDetail.setFieldDesc(element.getDefine());
			modelDetail.setRemark(element.getRemark());
			modelDetail.setCond(element.getCond());
			modelDetail.setShowTimes(element.getShowTimes());
			modelDetail.setFieldType(element.getDataType());
			modelDetail.setType(element.getType());
			list.add(modelDetail);
		}
		return ResultVo.ok(list);
	}
}

