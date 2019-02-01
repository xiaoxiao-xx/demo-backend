package com.microcore.center.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.microcore.common.util.ResultVo;
import com.microcore.center.dto.DbConnectionDto;
import com.microcore.center.model.DbFieldCnf;
import com.microcore.center.model.DbTableCnf;
import com.microcore.center.model.DbConnection;

public interface DbConnectionService {

	ResultVo addDbConnection(DbConnectionDto dbConnection);

	ResultVo<DbConnectionDto> getConnectionTree(String conId);

	ResultVo updateDbConnection(DbConnectionDto dbConnection);

//	List<DbConnection> getDbConnections(String type, String orgId, Integer pageIndex, Integer pageSize);

//	ResultVo<List<DbConnection>> queryDbConnections(String type, String orgId, Integer pageIndex, Integer pageSize);

	ResultVo<List<DbConnectionDto>> getDbConnections(String type);

	PageInfo<DbConnection> getDbConnectionList(String type, Integer pageIndex, Integer pageSize);

//	int getDbConnectionCount(String type);

	DbConnection getDbConnectionById(String id);

	String getDatabaseNameById(String id);

	ResultVo<List<DbTableCnf>> getTablesByConId(String conId);

	ResultVo<List<DbFieldCnf>> getTableColumns(String tableId);

	ResultVo checkIpAndPort(String ip, Integer port);

	ResultVo checkDatabaseConnection(DbConnectionDto dbConnection);

	ResultVo refreshDbConnection(String id,String kitId);

	ResultVo storeTableFieldInfo(DbConnectionDto dbConnectionDto);

	ResultVo deleteDbConnectionById(String id, String kitId);

	ResultVo getConnectionById(String id);

	ResultVo getOrgDbConnections(String type, String orgId);
}
