package com.microcore.center.controller;

import com.microcore.center.dto.DbConnectionDto;
import com.microcore.center.model.DbConnection;
import com.microcore.center.service.DbConnectionService;
import com.microcore.center.service.DbVersionService;
import com.microcore.common.exception.CommonException;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据源管理
 */
@RestController
@RequestMapping("dbConnection")
public class DbConnectionController {

	private final DbConnectionService dbConnectionService;

	private final DbVersionService dbVersionService;

	@Autowired
	public DbConnectionController(DbConnectionService dbConnectionService, DbVersionService dbVersionService) {
		this.dbConnectionService = dbConnectionService;
		this.dbVersionService = dbVersionService;
	}

	@ApiOperation(value = "添加数据库连接信息", notes = "添加数据库连接信息")
	@ApiImplicitParam(name = "dbConnection", value = "DbConnection对象", required = true, dataType = "DbConnection")
	@PostMapping("addDbConnection")
	public ResultVo addDbConnection(@RequestBody DbConnectionDto dbConnection) {
		return dbConnectionService.addDbConnection(dbConnection);
	}

	@ApiOperation(value = "添加数据库表格字段信息", notes = "添加数据库表格字段信息")
	@ApiImplicitParam(name = "dbConnection", value = "DbConnectionDto对象", required = true, dataType = "DbConnectionDto")
	@PostMapping("storeTableFieldInfo")
	public ResultVo storeTableFieldInfo(@RequestBody DbConnectionDto dbConnection) {
		return dbConnectionService.storeTableFieldInfo(dbConnection);
	}

	@ApiOperation(value = "更新数据库连接", notes = "根据id更新数据库连接")
	@ApiImplicitParam(name = "dbConnectionMsg", value = "连接对象", required = true, dataType = "DbConnectionMsg")
	@PostMapping("updateDbConnection")
	public ResultVo updateDbConnection(@RequestBody DbConnectionDto dbConnection) {
		if (dbConnection == null) {
			throw new CommonException("dbConnection 为 null");
		}

		// 更新后不用刷新，用户自己点击按钮刷新
		dbConnectionService.updateDbConnection(dbConnection);
		return ResultVo.ok();
	}

	@ApiOperation(value = "获取数据库类型", notes = "获取所有数据库类型")
	@GetMapping("getDbVersions")
	public ResultVo getDbVersions() {
		return dbVersionService.getAllDbVersions();
	}

	@ApiOperation(value = "刷新数据库信息缓存", notes = "刷新数据库信息缓存")
	@ApiImplicitParam(name = "id", value = "DbConnection的ID", required = true, dataType = "String")
	@PostMapping("refreshDbConnection")
	public ResultVo refreshDbConnection(@RequestParam String id, String kitId) {
		return dbConnectionService.refreshDbConnection(id, kitId);
	}

	@ApiOperation(value = "删除数据库连接", notes = "根据id删除数据库连接")
	@ApiImplicitParam(name = "id", value = "连接id", required = true, dataType = "String")
	@PostMapping("deleteById")
	public ResultVo deleteDbConnectionById(@RequestParam String id, String kitId) {
		if (StringUtil.isEmpty(id) || StringUtil.isEmpty(kitId)) {
			return ResultVo.fail("id 或 kitId 为 null");
		}

		return dbConnectionService.deleteDbConnectionById(id, kitId);
	}

	@ApiOperation(value = "批量删除数据库连接", notes = "根据传入的List批量删除数据库连接")
	@ApiImplicitParam(name = "delList", value = "要删除的连接的id列表", required = true, dataType = "List<String>")
	@PostMapping("batchDelete")
	public ResultVo batchDeleteDbConnection(String[] delList, String kitId) {
		if (delList.length < 1) {
			return ResultVo.fail("delList 为空");
		}

		for (String id : delList) {
			dbConnectionService.deleteDbConnectionById(id,kitId);
		}

		return ResultVo.ok();
	}

	@ApiOperation(value = "获取数据库连接列表", notes = "获取pub或者sub类型下所有数据库连接")
	@ApiImplicitParam(name = "type", value = "数据源类型", required = false, dataType = "String")
	@GetMapping("getDbConnections")
	public ResultVo getConnections(@RequestParam(name = "type") String type) {
		return dbConnectionService.getDbConnections(type);
	}

	@GetMapping("getOrgDbConnections")
	public ResultVo getOrgDbConnections(String type, String orgId) {
		return dbConnectionService.getOrgDbConnections(type, orgId);
	}

	@ApiOperation(value = "根据ID查询数据库连接", notes = "根据ID查询数据库连接")
	@ApiImplicitParam(name = "id", value = "数据源类型", required = false, dataType = "String")
	@GetMapping("getConnectionById")
	public ResultVo getConnectionById(@RequestParam(name = "id") String id) {
		return dbConnectionService.getConnectionById(id);
	}

	@ApiOperation(value = "根据数据库连接ID获取库表树", notes = "获取数据库，表，字段树")
	@ApiImplicitParam(name = "conId", value = "连接ID", required = true, dataType = "String")
	@GetMapping("getConnectionTree")
	public ResultVo getConnectionTree(@RequestParam(name = "conId") String conId) {
		return dbConnectionService.getConnectionTree(conId);
	}

	@ApiOperation(value = "根据连接ID获取数据库中所有表", notes = "根据连接ID获取数据库中所有表")
	@ApiImplicitParam(name = "conId", value = "连接ID", required = true, dataType = "String")
	@GetMapping("getTablesByConId")
	public ResultVo getTablesByConId(@RequestParam(name = "conId") String conId) {
		return dbConnectionService.getTablesByConId(conId);
	}

	@ApiOperation(value = "获取表的列信息", notes = "根据表的ID获取表的列信息")
	@ApiImplicitParam(name = "tableId", value = "连接ID", required = true, dataType = "String")
	@GetMapping("getTableColumns")
	public ResultVo getTableColumns(@RequestParam(name = "tableId") String tableId) {
		return dbConnectionService.getTableColumns(tableId);
	}

	@ApiOperation(value = "检验IP地址和端口", notes = "检验用户填写的IP地址和端口是否可以连通")
	@ApiImplicitParams({@ApiImplicitParam(name = "ip", value = "IP地址", required = true, dataType = "String"),
			@ApiImplicitParam(name = "port", value = "端口", required = true, dataType = "Integer")})
	@GetMapping("checkIpAndPort")
	public ResultVo checkIpAndPort(@RequestParam(name = "ip") String ip, @RequestParam(name = "port") Integer port) {
		return dbConnectionService.checkIpAndPort(ip, port);
	}

	@ApiOperation(value = "检验数据库是否可连通", notes = "根据用户填写的IP地址、端口、用户名、密码、数据库名检验数据库是否可以连通")
	@ApiImplicitParam(name = "dbConnection", value = "DbConnection实体", required = true, dataType = "DbConnection")
	@PostMapping("checkDatabaseConnection")
	public ResultVo checkDatabaseConnection(@RequestBody DbConnectionDto dbConnection) {
		return dbConnectionService.checkDatabaseConnection(dbConnection);
	}

}
