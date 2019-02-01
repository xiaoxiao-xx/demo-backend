package com.microcore.center.service;

import com.microcore.api.model.DbDbKit;
import com.microcore.center.vo.DbKitVo;
import com.microcore.common.util.ResultVo;

public interface DbDbKitService {

	void addKitInfo(DbKitVo dbKitVo);

	DbDbKit getDbKitById(String id);
	
	DbDbKit getDbKitByOrgId(String orgId);

	DbDbKit getCurrentUsersDbKit();

	String getCurrentUsersDbKitId();
	
	void updateKitInfo(DbKitVo dbKitVo);
	
	void deleteKitInfoById(String id);
	
	void enableDbKit(String id);
	
	void disableDbKit(String id);

	void updateDbKitStatus(String id, String status);

	void unbindMacAddress(String id);
	
	DbDbKit selectByIpAndPort(String ip, String port);

	void setMacAddress(String id, String macAddress);

	ResultVo authDbKitInfo(DbKitVo dbKitDto);
	
//	Long getKitInfoCount();

}
