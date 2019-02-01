package com.microcore.center.service.impl;

import com.microcore.center.mapper.DbEncryptionTypeMapper;
import com.microcore.center.model.DbEncryptionType;
import com.microcore.center.model.DbEncryptionTypeExample;
import com.microcore.center.service.DbEncryptionTypeService;
import com.microcore.common.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class DbEncryptionTypeServiceImpl implements DbEncryptionTypeService {

	@Autowired
	private DbEncryptionTypeMapper dbEncryptionTypeMapper;

	@Override
	public void addEncryptionType(DbEncryptionType type) {
		type.setId(CommonUtil.getUUID());
		dbEncryptionTypeMapper.insert(type);
	}

	@Override
	public void updateEncryptionType(DbEncryptionType type) {
		dbEncryptionTypeMapper.updateByPrimaryKeySelective(type);
	}

	@Override
	public List<DbEncryptionType> getEncryptionTypeList() {
		DbEncryptionTypeExample example = new DbEncryptionTypeExample();
		return dbEncryptionTypeMapper.selectByExample(example);
	}

	@Override
	public void deleteEncryptionType(String id) {
		dbEncryptionTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public DbEncryptionType getEncryptionTypeById(String id) {
		return dbEncryptionTypeMapper.selectByPrimaryKey(id);
	}

}
