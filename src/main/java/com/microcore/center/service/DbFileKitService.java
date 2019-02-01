package com.microcore.center.service;

import com.microcore.api.model.DbFileKit;
import com.microcore.center.dto.DbFileKitDto;
import com.microcore.center.vo.DbFileKitVo;
import com.microcore.common.util.ResultVo;

/**
 */
public interface DbFileKitService {

	ResultVo addDbFileKit(DbFileKitDto dbFileKitDto);

	ResultVo updDbFileKit(DbFileKitDto dbFileKitDto);

	ResultVo clearMAC(DbFileKitDto dbFileKitDto);

	ResultVo delDbFileKit(String kid);

	ResultVo startDbFileKit(String kid);

	ResultVo getDbFileKitByOrgId(String orgId);
	
	DbFileKit getDbFileKitByOrg();
	
	ResultVo getDbFileKitById(String id);

	ResultVo getVCode(String fid);

	ResultVo contrast(DbFileKitVo dbFileKitVo);

	String getPathDir(String orgId, String pathType);
}
