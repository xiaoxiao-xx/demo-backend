package com.rainyhon.common.service.impl;

import java.util.List;
import java.util.Map;

import com.rainyhon.common.mapper.CommonMapper;
import com.rainyhon.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonMapper commonMapper;

	@Override
	public List<Map<String, Object>> executeSelectSQL(Map<String, Object> params) {
		return commonMapper.executeSelectSQL(params);
	}

	@Override
	public void executeUpdateSQL(Map<String, Object> params) {
		commonMapper.executeUpdateSQL(params);
	}

	@Override
	public void executeInsertSQL(Map<String, Object> params) {
		commonMapper.executeInsertSQL(params);
	}

	@Override
	public void executeDeleteSQL(Map<String, Object> params) {
		commonMapper.executeDeleteSQL(params);
	}

	@Override
	public Map<String, Object> findOne(Map<String, Object> params) {
		List<Map<String, Object>> result = commonMapper.executeSelectSQL(params);
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public Long executeGetCount(Map<String, Object> params) {
		params.put("sql", "select count(*) count " + params.get("sql"));
		Object object = findOne(params).get("count");
		return (Long) object;
	}

}
