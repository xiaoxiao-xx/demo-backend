package com.microcore.center.service.impl;

import com.microcore.center.mapper.DbTableCnfMapper;
import com.microcore.center.model.DbTableCnf;
import com.microcore.center.model.DbTableCnfExample;
import com.microcore.center.model.DbTableCnfExample.Criteria;
import com.microcore.center.service.DbTableCnfService;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lmh
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DbTableCnfServiceImpl implements DbTableCnfService {

	@Autowired
	private DbTableCnfMapper dbTableCnfMapper;

	@Autowired
	private CommonService commonService;

	@Override
	public ResultVo<String> addDbTableCnf(DbTableCnf dbTableCnf) {
		dbTableCnfMapper.insert(dbTableCnf);
		return ResultVo.ok();
	}

	@Override
	public ResultVo<String> deleteById(String id) {
		dbTableCnfMapper.deleteByPrimaryKey(id);
		return ResultVo.ok();
	}

	@Override
	public ResultVo<String> deleteByPid(String pid) {
		DbTableCnfExample example = new DbTableCnfExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		dbTableCnfMapper.deleteByExample(example);
		return ResultVo.ok();
	}

	@Override
	public ResultVo<String> deleteDbTableCnf(DbTableCnf dbTableCnf) {
		dbTableCnfMapper.deleteByPrimaryKey(dbTableCnf.getId());
		return ResultVo.ok();
	}

	@Override
	public ResultVo<String> updateDbTableCnf(DbTableCnf dbTableCnf) {
		dbTableCnfMapper.updateByPrimaryKey(dbTableCnf);
		return ResultVo.ok();
	}

	@Override
	public List<DbTableCnf> getDbTableCnfByPid(String pid) {
		DbTableCnfExample example = new DbTableCnfExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		return dbTableCnfMapper.selectByExample(example);
	}

	@Override
	public int getConIdCount(Integer id) {
		String sql = "from db_table_cnf where 1=1";
		if (id != null) {
			sql += " and con_id = #{id}";
		}

		Map<String, Object> params = new HashMap<>(2);
		params.put("sql", sql);
		params.put("id", id);

		return commonService.executeGetCount(params).intValue();
	}

	@Override
	public String getIdByPidAndTableName(String pid, String tableName) {
		DbTableCnfExample example = new DbTableCnfExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		criteria.andTableNameEqualTo(tableName);
		List<DbTableCnf> dbTableCnfs = dbTableCnfMapper.selectByExample(example);
		if (dbTableCnfs.size() > 0) {
			return dbTableCnfs.get(0).getId();
		} else {
			return "";
		}
	}

}
