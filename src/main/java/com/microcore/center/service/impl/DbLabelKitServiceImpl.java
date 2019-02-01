/**
 * Project Name:sls-center
 * File Name:DbLabelKitServiceImpl.java
 * Package Name:com.microcore.center.service.impl
 * Date:2018年8月17日下午3:31:13
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.microcore.center.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbLabelKit;
import com.microcore.center.mapper.DbLabelKitMapper;
import com.microcore.center.model.DbLabelKitExample;
import com.microcore.center.service.DbLabelKitService;
import com.microcore.common.exception.CommonException;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

@Service
@Transactional
public class DbLabelKitServiceImpl implements DbLabelKitService {

	@Autowired
	private DbLabelKitMapper dbLabelKitMapper;

	@Override
	public DbLabelKit add(DbLabelKit dbLabelKit) {
		if (getDbLabelKitByOrgId(dbLabelKit.getOrgId()) != null) {
			throw new CommonException("该机构已经存在标签服务！");
		}
		dbLabelKit.setId(CommonUtil.getUUID());
		dbLabelKit.setStatus("INI");
		EntityUtils.setCreateInfo(dbLabelKit);
		dbLabelKitMapper.insert(dbLabelKit);
		return dbLabelKit;
	}

	@Override
	public DbLabelKit update(DbLabelKit dbLabelKit) {
		EntityUtils.setUpdateInfo(dbLabelKit);
		DbLabelKit dbLabelKitpo = dbLabelKitMapper.selectByPrimaryKey(dbLabelKit.getId());
		dbLabelKitpo.setTagName(dbLabelKit.getTagName());
		dbLabelKitpo.setTagIp(dbLabelKit.getTagIp());
		dbLabelKitpo.setTagPort(dbLabelKit.getTagPort());
		dbLabelKitpo.setRemark(dbLabelKit.getRemark());
		dbLabelKitpo.setMacAddress(dbLabelKit.getMacAddress());
		dbLabelKitpo.setStatus(dbLabelKit.getStatus());
		dbLabelKitMapper.updateByPrimaryKey(dbLabelKitpo);
		return dbLabelKitpo ;
	}

	@Override
	public void delete(String id) {
		DbLabelKit dbLabelKit = dbLabelKitMapper.selectByPrimaryKey(id);
		dbLabelKit.setDelStatus("DEL");
		EntityUtils.setUpdateInfo(dbLabelKit);
		dbLabelKitMapper.updateByPrimaryKey(dbLabelKit);
	}

	@Override
	public DbLabelKit getDbLabelKit(String id) {
		return dbLabelKitMapper.selectByPrimaryKey(id);
	}

	@Override
	public DbLabelKit getDbLabelKitByOrgId(String orgId) {
		DbLabelKitExample example = new DbLabelKitExample();
		DbLabelKitExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		criteria.andDelStatusEqualTo("NOR");
		List<DbLabelKit> list = dbLabelKitMapper.selectByExample(example);
		if (!CommonUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public PageInfo<DbLabelKit> labelKitList(String orgId, Integer pageIndex, Integer pageSize) {
		DbLabelKitExample example = new DbLabelKitExample();
		DbLabelKitExample.Criteria criteria = example.createCriteria();
		if(StringUtil.isNotEmpty(orgId)) {
			criteria.andOrgIdEqualTo(orgId);
		}
		criteria.andDelStatusEqualTo("NOR");
		return PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbLabelKitMapper.selectByExample(example));
	}

	@Override
	public DbLabelKit getDbLabelKit(String tagIp, String tagPort) {
		DbLabelKitExample example = new DbLabelKitExample();
		DbLabelKitExample.Criteria criteria = example.createCriteria();
		criteria.andTagIpEqualTo(tagIp);
		criteria.andTagPortEqualTo(tagPort);
		criteria.andDelStatusEqualTo("NOR");
		List<DbLabelKit> list = dbLabelKitMapper.selectByExample(example);
		if (!CommonUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public ResultVo clearMAC(DbLabelKit dbLabelKit) {
		if (StringUtil.isEmpty(dbLabelKit.getId())) {
			return ResultVo.fail("套件ID为空！");
		}
		DbLabelKit labelKit = getDbLabelKit(dbLabelKit.getId());
		if (null==labelKit) {
			return ResultVo.fail("该套件不存在！");
		}
		labelKit.setMacAddress("");
		dbLabelKitMapper.updateByPrimaryKey(labelKit);
		return ResultVo.ok("清除成功！");
	}

}
