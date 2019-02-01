package com.microcore.center.service.impl;

import com.microcore.center.mapper.DbFieldCnfMapper;
import com.microcore.center.model.DbFieldCnf;
import com.microcore.center.model.DbFieldCnfExample;
import com.microcore.center.model.DbFieldCnfExample.Criteria;
import com.microcore.center.service.DbFieldCnfService;
import com.microcore.center.service.DbTableCnfService;
import com.microcore.common.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class DbFieldCnfServiceImpl implements DbFieldCnfService {

	@Autowired
	private DbFieldCnfMapper dbFieldCnfMapper;

	@Autowired
	private DbTableCnfService dbTableCnfService;

	@Override
	public ResultVo addDbFieldCnf(DbFieldCnf dbFieldCnf) {
		dbFieldCnfMapper.insert(dbFieldCnf);
		return ResultVo.ok();
	}

	@Override
	public ResultVo deleteDbFieldCnf(DbFieldCnf dbFieldCnf) {
		dbFieldCnfMapper.deleteByPrimaryKey(dbFieldCnf.getId());
		return ResultVo.ok();
	}

	@Override
	public ResultVo deleteByPid(String pid) {
		DbFieldCnfExample example = new DbFieldCnfExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		dbFieldCnfMapper.deleteByExample(example);
		return ResultVo.ok();
	}

	@Override
	public ResultVo deleteByConId(String conId) {
		DbFieldCnfExample example = new DbFieldCnfExample();
		Criteria criteria = example.createCriteria();
		criteria.andConIdEqualTo(conId);
		dbFieldCnfMapper.deleteByExample(example);
		return ResultVo.ok();
	}

	@Override
	public ResultVo updateDbFieldCnf(DbFieldCnf dbFieldCnf) {
		dbFieldCnfMapper.updateByPrimaryKey(dbFieldCnf);
		return ResultVo.ok();
	}

	@Override
	public List<DbFieldCnf> getDbFieldCnfByPid(String pid) {
		DbFieldCnfExample example = new DbFieldCnfExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		return dbFieldCnfMapper.selectByExample(example);
	}

	/**
	 * 获取某张表的所有字段注释
	 *
	 * @param conId
	 * @param tableName
	 * @return
	 */
	@Override
	public Map<String, String> getCommentMap(String conId, String tableName) {
		String tableCnfId = dbTableCnfService.getIdByPidAndTableName(conId, tableName);
		List<DbFieldCnf> dbFieldCnfByPid = getDbFieldCnfByPid(tableCnfId);
		Map<String, String> commentMap = new HashMap<>();
		for (DbFieldCnf cnf : dbFieldCnfByPid) {
			String fieldName = cnf.getFieldName();
			String comment = cnf.getFieldNote();
			commentMap.put(fieldName, comment);
		}

		return commentMap;
	}

}
