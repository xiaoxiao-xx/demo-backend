package com.rainyhon.common.mapper;

import com.rainyhon.common.vo.ColumnVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ViewMapper {

	List<ColumnVo> getColumnByViewName(String name);

	List<String> getAllViewName();

	List<Map<String, String>> query(@Param("sql") String sql);
}
