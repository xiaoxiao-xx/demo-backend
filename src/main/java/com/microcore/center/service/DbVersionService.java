package com.microcore.center.service;

import java.util.List;

import com.microcore.common.util.ResultVo;
import com.microcore.center.model.DbVersion;

public interface DbVersionService {
	
	ResultVo addDbVersion(DbVersion dbVersion);

	ResultVo deleteDbVersion(DbVersion dbVersion);

	ResultVo updateDbVersion(DbVersion dbVersion);

//	ResultVo<List<DbVersion>> queryDbVersions(Integer id, String dbType, Integer pageIndex, Integer pageSize);

//	List<DbVersion> getDbVersions(Integer id, String dbType, Integer pageIndex, Integer pageSize);

	DbVersion getDbVersionById(String id);

	int getDbVersionCount(Integer id, String dbType);

	ResultVo<List<DbVersion>> getAllDbVersions();

	String getDbTypeString(String dbVersionId);

}
