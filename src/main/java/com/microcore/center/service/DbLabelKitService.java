package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbLabelKit;
import com.microcore.common.util.ResultVo;

public interface DbLabelKitService {
	
	DbLabelKit add(DbLabelKit dbLabelKit);
	
	DbLabelKit update(DbLabelKit dbLabelKit);
	
	void delete(String id);
	
	DbLabelKit getDbLabelKit(String id);
	
	DbLabelKit getDbLabelKit(String tagIp,String tagPort);
	
	DbLabelKit getDbLabelKitByOrgId(String orgId);
	
	PageInfo<DbLabelKit> labelKitList(String orgId,Integer pageIndex,Integer pageSize);
	
	ResultVo clearMAC(DbLabelKit dbLabelKit);
}

