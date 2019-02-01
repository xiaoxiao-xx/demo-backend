package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.DbCodeTbMapper;
import com.microcore.center.model.DbCodeTb;
import com.microcore.center.model.DbCodeTbExample;
import com.microcore.center.service.DbCodeTbService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DbCodeTbServiceImpl implements DbCodeTbService {

	@Autowired
	private DbCodeTbMapper dbCodeTbMapper;

	@Override
	public PageInfo<DbCodeTb> queryDbCodeTb(String nspaceId, String name, Integer pageIndex, Integer pageSize) {
		DbCodeTbExample example = new DbCodeTbExample();
		DbCodeTbExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.andNameLike("%" + name.trim() + "%");
		}
		criteria.andDelStatusEqualTo("NOR");
		criteria.andNspaceIdEqualTo(nspaceId);
		return PageHelper.startPage(pageIndex, pageSize)
			.doSelectPageInfo(() -> dbCodeTbMapper.selectByExample(example));
	}

	@Override
	public void add(DbCodeTb dbCodeTb) {
		DbCodeTb record = new DbCodeTb();
		record.setDelStatus("NOR");
		record.setId(CommonUtil.getUUID());
		record.setRemark(dbCodeTb.getRemark());
		record.setName(dbCodeTb.getName());
		record.setCode(dbCodeTb.getCode());
		record.setNspaceId(dbCodeTb.getNspaceId());
		if (StringUtil.isEmpty(dbCodeTb.getPid())) {//新增代码类型
			record.setType("B");//大类
		} else {//新增代码明细
			DbCodeTb precord = dbCodeTbMapper.selectByPrimaryKey(dbCodeTb.getPid());
			record.setNspaceId(precord.getNspaceId());
			record.setPcode(precord.getCode());
			record.setPid(precord.getId());
			record.setType("S");//小类
		}
		EntityUtils.setCreateInfo(record);
		dbCodeTbMapper.insert(record);
	}

	@Override
	public void update(DbCodeTb dbCodeTb) {
		if (StringUtil.isEmpty(dbCodeTb.getId())) {
			return;
		}
		DbCodeTb record = dbCodeTbMapper.selectByPrimaryKey(dbCodeTb.getId());
		record.setCode(dbCodeTb.getCode());
		record.setName(dbCodeTb.getName());
		record.setRemark(dbCodeTb.getRemark());
		EntityUtils.setUpdateInfo(record);
		dbCodeTbMapper.updateByPrimaryKey(record);
	}

	@Override
	public void delete(String id) {
		dbCodeTbMapper.deleteByPrimaryKey(id);
	}

	@Override
	public DbCodeTb get(String id) {
		return dbCodeTbMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DbCodeTb> queryByNspaceId(String nspaceId) {
		DbCodeTbExample example = new DbCodeTbExample();
		DbCodeTbExample.Criteria criteria = example.createCriteria();
		criteria.andNspaceIdEqualTo(nspaceId);
		criteria.andTypeEqualTo("B");//大类型
		return dbCodeTbMapper.selectByExample(example);
	}

	@Override
	public PageInfo queryPid(String pid, String name, Integer pageIndex, Integer pageSize) {
		DbCodeTbExample example = new DbCodeTbExample();
		DbCodeTbExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		criteria.andTypeEqualTo("S");//小类型
		if (StringUtil.isNotEmpty(name)) {
			criteria.andNameLike("%" + name.trim() + "%");
		}
		return PageHelper.startPage(pageIndex, pageSize).<DbCodeTb>doSelectPageInfo(() -> dbCodeTbMapper.selectByExample(example));
	}
}
