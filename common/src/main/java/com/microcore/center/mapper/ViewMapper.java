package com.microcore.center.mapper;

import com.microcore.center.model.Column;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ViewMapper {

	List<Column> getColumnByViewName(String name);

	List<String> getAllViewName();

	List<Map<String, String>> query(@Param("sql") String sql);
}
