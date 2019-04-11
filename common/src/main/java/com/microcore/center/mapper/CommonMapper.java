package com.microcore.center.mapper;

import java.util.List;
import java.util.Map;

public interface CommonMapper {

	List<Map<String, Object>> executeSelectSQL(Map<String, Object> params);

	void executeUpdateSQL(Map<String, Object> params);

	void executeInsertSQL(Map<String, Object> params);

	void executeDeleteSQL(Map<String, Object> params);

}
