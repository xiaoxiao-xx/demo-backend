package com.microcore.center.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.DbNameSpaceMapper;
import com.microcore.center.mapper.DbParamsMapper;
import com.microcore.center.model.DbNameSpace;
import com.microcore.center.model.DbNameSpaceExample;
import com.microcore.center.model.DbParams;
import com.microcore.center.model.DbParamsExample;
import com.microcore.center.service.DbNameSpaceService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.StringUtil;

@Service
@Transactional
public class DbNameSpaceServiceImpl implements DbNameSpaceService {

	@Autowired
	private DbNameSpaceMapper dbNameSpaceMapper;
	@Autowired
	private DbParamsMapper dbParamsMapper;

	@Override
	public PageInfo queryNameSpace(String cname, Integer pageIndex, Integer pageSize) {
		DbNameSpaceExample example = new DbNameSpaceExample();
		DbNameSpaceExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(cname)) {
			criteria.andCnameLike("%" + cname.trim() + "%");
		}
		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> dbNameSpaceMapper.selectByExample(example));
	}

	@Override
	public List<DbNameSpace> queryNameSpace() {
		DbNameSpaceExample example = new DbNameSpaceExample();
		return dbNameSpaceMapper.selectByExample(example);
	}

	@Override
	public void add(DbNameSpace dbNameSpace) {
		DbNameSpace record = new DbNameSpace();
		record.setId(CommonUtil.getUUID());
		record.setCname(dbNameSpace.getCname());
		record.setEname(dbNameSpace.getEname());
		record.setRemark(dbNameSpace.getRemark());
		record.setSname(dbNameSpace.getSname());
		record.setPath(dbNameSpace.getPath());
		EntityUtils.setCreateInfo(dbNameSpace);
		dbNameSpaceMapper.insert(record);

		DbParams dbParams = new DbParams();
		dbParams.setId(record.getId());
		dbParams.setParamsKey(record.getId());
		dbParams.setParamsType("data_cate");
		dbParams.setParamsValue(record.getCname());
		dbParamsMapper.insert(dbParams);
	}

	@Override
	public void update(DbNameSpace dbNameSpace) {
		if (StringUtil.isEmpty(dbNameSpace.getId())) {
			return;
		}
		DbNameSpace record = this.get(dbNameSpace.getId());
		record.setCname(dbNameSpace.getCname());
		record.setEname(dbNameSpace.getEname());
		record.setRemark(dbNameSpace.getRemark());
		record.setSname(dbNameSpace.getSname());
		record.setPath(dbNameSpace.getPath());
		EntityUtils.setUpdateInfo(record);
		dbNameSpaceMapper.updateByPrimaryKey(record);

		DbParams dbParams = getDbParams("data_cate", record.getId());
		if (dbParams != null) {
			dbParams.setParamsValue(record.getCname());
			dbParamsMapper.updateByPrimaryKey(dbParams);
		} else {
			dbParams = new DbParams();
			dbParams.setId(record.getId());
			dbParams.setParamsKey(record.getId());
			dbParams.setParamsType("data_cate");
			dbParams.setParamsValue(record.getCname());
			dbParamsMapper.insert(dbParams);
		}
	}

	public DbParams getDbParams(String paramsType, String paramsKey) {
		DbParamsExample example = new DbParamsExample();
		DbParamsExample.Criteria criteria = example.createCriteria();
		criteria.andParamsTypeEqualTo(paramsType);
		criteria.andParamsKeyEqualTo(paramsKey);
		List<DbParams> list = dbParamsMapper.selectByExample(example);
		if (!CommonUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public DbNameSpace get(String id) {
		return dbNameSpaceMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(String id) {
		DbNameSpace dbNameSpace = dbNameSpaceMapper.selectByPrimaryKey(id);
		if (dbNameSpace != null) {
			DbParamsExample example = new DbParamsExample();
			DbParamsExample.Criteria criteria = example.createCriteria();
			criteria.andParamsValueEqualTo(dbNameSpace.getCname());
			criteria.andParamsTypeEqualTo("data_cate");
			criteria.andParamsKeyEqualTo(dbNameSpace.getId());
			dbParamsMapper.deleteByExample(example);
		}
		dbNameSpaceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public String getCnameById(String id) {
		DbNameSpace dbNameSpace = get(id);
		if (dbNameSpace != null) {
			return dbNameSpace.getCname();
		}
		return null;
	}

}
