package com.microcore.center.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbPubDto;

public interface DbPubResourceService {

	PageInfo<DbPubDto> getPubResourceByOrg(String orgId,String keywords,Integer pageIndex,Integer pageSize);
	
	PageInfo<DbPubDto> getPubResourceByTrade(String paramsKey,String keywords,Integer pageIndex,Integer pageSize);
	
	List<Map<String, Object>> getTradeList();
}
