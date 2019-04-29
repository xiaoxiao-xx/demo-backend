package com.microcore.center.mapper;

import com.microcore.center.model.ColumnVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ViewMapper {

	List<ColumnVo> getColumnByViewName(String name);

	List<String> getAllViewName();

	List<Map<String, String>> query(@Param("sql") String sql);
}
