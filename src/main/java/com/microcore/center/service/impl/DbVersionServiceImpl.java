package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.common.jdbc.JdbcUtil;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.center.mapper.DbVersionMapper;
import com.microcore.center.model.DbVersion;
import com.microcore.center.model.DbVersionExample;
import com.microcore.center.service.DbVersionService;

/**
 * @author lmh
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DbVersionServiceImpl implements DbVersionService {

	@Autowired
	private DbVersionMapper dbVersionMapper;

	@Autowired
	private CommonService commonService;

	@Override
	public ResultVo addDbVersion(DbVersion dbVersion) {
		dbVersionMapper.insert(dbVersion);
		return ResultVo.ok();
	}

	@Override
	public ResultVo updateDbVersion(DbVersion dbVersion) {
		dbVersionMapper.updateByPrimaryKey(dbVersion);
		return ResultVo.ok();
	}

	@Override
	public ResultVo deleteDbVersion(DbVersion dbVersion) {
		dbVersionMapper.deleteByPrimaryKey(dbVersion.getId());
		return ResultVo.ok();
	}

	@Override
	public int getDbVersionCount(Integer id, String dbType) {
		Map<String, Object> params = new HashMap<>(3);
		String sql = "from db_version where 1=1";
		if (id != null) {
			sql += " and id = #{id}";
		}
		if (StringUtil.isNotEmpty(dbType)) {
			sql += " and db_type = #{dbType}";
		}

		params.put("sql", sql);
		params.put("id", id);
		params.put("dbType", dbType);

		return commonService.executeGetCount(params).intValue();
	}

	@Override
	public DbVersion getDbVersionById(String id) {
		return dbVersionMapper.selectByPrimaryKey(id);
	}

	@Override
	public ResultVo<List<DbVersion>> getAllDbVersions() {
		DbVersionExample example = new DbVersionExample();
		List<DbVersion> list = dbVersionMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			list = new ArrayList<>();
			return ResultVo.ok(list);
		}

		return ResultVo.ok(list);
	}

	/**
	 * 获取数据库类型字符串，仅三种：MySQL, Oracle, SQL Server
	 */
	@Override
	public String getDbTypeString(String dbVersionId) {
		DbVersion dbVersion = dbVersionMapper.selectByPrimaryKey(dbVersionId);
		return JdbcUtil.judgeDbType(dbVersion.getVersion());
	}

}
