package com.microcore.center.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.DbPubColumnMapper;
import com.microcore.center.model.DbPubColumn;
import com.microcore.center.model.DbPubColumnExample;
import com.microcore.center.service.DbPubColumnService;
import com.microcore.common.util.CommonUtil;

/**
 * @author   whater
 */
@Service
@Transactional
public class DbPubColumnServiceImpl implements DbPubColumnService {
	@Autowired
	private DbPubColumnMapper dbPubColumnMapper ;
	
	@Override
	public DbPubColumn getDbPubColumnByPolicyId(String policyId) {
		DbPubColumnExample example = new DbPubColumnExample();
		DbPubColumnExample.Criteria criteria = example.createCriteria();
		criteria.andPolIdEqualTo(policyId);
		List<DbPubColumn> list = dbPubColumnMapper.selectByExample(example);
		if(!CommonUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

}

