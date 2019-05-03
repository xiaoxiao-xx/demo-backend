package com.rainyhon.common.service;

import java.util.List;
import java.util.Map;

import com.rainyhon.common.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommonService {

	@Autowired
	private CommonMapper commonMapper;

	public List<Map<String, Object>> executeSelectSQL(Map<String, Object> params) {
		return commonMapper.executeSelectSQL(params);
	}

	public void executeUpdateSQL(Map<String, Object> params) {
		commonMapper.executeUpdateSQL(params);
	}

	public void executeInsertSQL(Map<String, Object> params) {
		commonMapper.executeInsertSQL(params);
	}

	public void executeDeleteSQL(Map<String, Object> params) {
		commonMapper.executeDeleteSQL(params);
	}

	public Map<String, Object> findOne(Map<String, Object> params) {
		List<Map<String, Object>> result = commonMapper.executeSelectSQL(params);
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public Long executeGetCount(Map<String, Object> params) {
		params.put("sql", "select count(*) count " + params.get("sql"));
		Object object = findOne(params).get("count");
		return (Long) object;
	}

}

