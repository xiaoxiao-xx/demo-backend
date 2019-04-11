package com.microcore.center.service;

import java.util.List;
import java.util.Map;

public interface CommonService {

	List<Map<String, Object>> executeSelectSQL(Map<String, Object> params);

	void executeUpdateSQL(Map<String, Object> params);

	void executeInsertSQL(Map<String, Object> params);

	void executeDeleteSQL(Map<String, Object> params);

	Map<String, Object> findOne(Map<String, Object> params);

	Long executeGetCount(Map<String, Object> params);

}
