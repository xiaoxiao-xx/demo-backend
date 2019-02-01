/**
 * Project Name:sls-center
 * File Name:DbPolicyEncryptServiceImpl.java
 * Package Name:com.microcore.center.service.impl
 * Date:2018年12月20日上午10:36:47
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.microcore.center.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.DbPolicyEncryptMapper;
import com.microcore.center.model.DbPolicyEncrypt;
import com.microcore.center.model.DbPolicyEncryptExample;
import com.microcore.center.service.DbPolicyEncryptService;
import com.microcore.common.util.CommonUtil;

/**
 * ClassName:DbPolicyEncryptServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年12月20日 上午10:36:47 <br/>
 * @author   whater
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class DbPolicyEncryptServiceImpl implements DbPolicyEncryptService {
	
	@Autowired
	private DbPolicyEncryptMapper dbPolicyEncryptMapper ;
	
	@Override
	public Map<String, DbPolicyEncrypt> getDbPolicyEncryptMap(String templateId) {
		Map<String, DbPolicyEncrypt> map = new HashMap<>();
		List<DbPolicyEncrypt> list = getDbPolicyEncrypt(templateId);
		if(!CommonUtil.isEmpty(list)) {
			list.forEach((policy)->{
				map.put(policy.getSecurityLevel(), policy);
			});
		}
		return map;
	}

	@Override
	public List<DbPolicyEncrypt> getDbPolicyEncrypt(String templateId) {
		DbPolicyEncryptExample example = new DbPolicyEncryptExample() ;
		DbPolicyEncryptExample.Criteria criteria = example.createCriteria();
		criteria.andPolicyItemIdEqualTo(templateId);
		List<DbPolicyEncrypt> list = dbPolicyEncryptMapper.selectByExample(example);
		return list;
	}

}

