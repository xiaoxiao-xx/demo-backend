package com.microcore.center.service;

import java.util.List;

import com.microcore.common.util.ResultVo;
import com.microcore.center.model.DbTableCnf;

public interface DbTableCnfService {

	ResultVo addDbTableCnf(DbTableCnf dbTableCnf);

	ResultVo deleteDbTableCnf(DbTableCnf dbTableCnf);

	ResultVo deleteById(String id);

	ResultVo deleteByPid(String pid);

	ResultVo updateDbTableCnf(DbTableCnf dbTableCnf);

	List<DbTableCnf> getDbTableCnfByPid(String pid);

	int getConIdCount(Integer id);

	String getIdByPidAndTableName(String pid, String tableName);
}
