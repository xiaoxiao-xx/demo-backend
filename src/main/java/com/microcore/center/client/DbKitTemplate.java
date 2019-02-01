package com.microcore.center.client;

import java.lang.reflect.Type;
import java.util.List;

import com.microcore.common.dto.SubDelDto;
import com.microcore.common.vo.WithdrawPubVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microcore.api.vo.ClearTableOpVo;
import com.microcore.center.dto.DbConnectionDto;
import com.microcore.center.dto.DbPubTableDto;
import com.microcore.center.dto.DbSubTableDto;
import com.microcore.center.model.DbConnection;
import com.microcore.center.service.DbDbKitService;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.SendUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lmh
 */
@Component
@Slf4j
public class DbKitTemplate {

	private final SendUtil sendUtil;

	private final DbDbKitService dbDbKitService;

	@Autowired
	public DbKitTemplate(DbDbKitService dbDbKitService, SendUtil sendUtil) {
		this.dbDbKitService = dbDbKitService;
		this.sendUtil = sendUtil;
	}

	private String getKitId() {
		return dbDbKitService.getCurrentUsersDbKitId();
	}

	private void send(String uri, Object param) {
		sendUtil.send(getKitId(), uri, param);
	}

	private ResultVo sendKitService(String uri, Object object) {
		return sendUtil.sendKitService(getKitId(), uri, object);
	}

	/*
	 * 库表发布
	 */

	public void saveTablePubInfo(DbPubTableDto dbPubTableDto) {
		send("/pubTable/saveTablePubInfo", dbPubTableDto);
	}

	public void startPub(String id) {
		send("/pubTable/startPub", id);
	}

	public void stopPub(String id) {
		send("/pubTable/stopPub", id);
	}

	public void deletePub(String id) {
		send("/pubTable/deletePub", id);
	}

	public void clearPubCache(String id) {
		send("/pubTable/clearCache", id);
	}

	public void withdrawPub(WithdrawPubVo vo) {
		send("/pubTable/withdrawPub", vo);
	}

	public void deleteSubByPubIdAndSubOrgId(String pubId, String subOrgId) {
		sendUtil.send(subOrgId, "/subTable/deleteSubByPubIdAndSubOrgId", new SubDelDto(pubId, subOrgId));
	}

	/*
	 * 库表订阅
	 */

	/**
	 * 下发库表订阅信息
	 *
	 * @param subInfo 订阅信息
	 */
	public void saveSub(DbSubTableDto subInfo) {
		send("/subTable/saveSub", subInfo);
	}

	public void startSub(String id) {
		send("/subTable/startSub", id);
	}

	public void stopSub(String id) {
		send("/subTable/stopSub", id);
	}

	public void deleteSub(String id) {
		send("/subTable/deleteSub", id);
	}

	public void clearSubCache(String id) {
		send("/subTable/clearCache", id);
	}

	/*
	 * 数据库连接
	 */

	public void saveDbConnection(DbConnectionDto dbConnection) {
		sendUtil.send(dbConnection.getKitId(),"/dbConnection/saveDbConnection", dbConnection);
	}

	public ResultVo<DbConnectionDto> refreshDbConnection(String kitId, String id) {
		String s = sendUtil.sendKitServiceStrTake(kitId, "/dbConnection/refreshDbConnection", id);
		Type type = new TypeToken<ResultVo<DbConnectionDto>>() {
		}.getType();
		return new Gson().fromJson(s, type);
	}

	public void deleteDbConnectionById(String id, String kitId) {
		sendUtil.send(kitId,"/dbConnection/deleteDbConnectionById", id);
	}

	public void updateDbConnection(DbConnectionDto dbConnection) {
		sendUtil.send(dbConnection.getKitId(),"/dbConnection/updateDbConnection", dbConnection);
	}

	public ResultVo checkIpAndPort(DbConnection connection) {
		return sendKitService("/dbConnection/checkIpAndPort", connection);
	}

	public ResultVo checkDatabaseConnection(DbConnectionDto connection) {
		return sendUtil.sendKitService(connection.getKitId(),"/dbConnection/checkDatabaseConnection", connection);
	}

	@GetMapping("getDbTableInfo")
	public ResultVo getDbTableInfo(String kitId, String type) {
		try {
			return sendUtil.sendKitService(kitId, "/dbKit/getDbTableInfo", type);
		} catch (Exception e) {
			log.error("getDbTableInfo fail", e);
		}
		return ResultVo.fail();
	}
	
	@GetMapping("getDbTableInfoOfAll")
	public ResultVo getDbTableInfoOfAll(String kitId) {
		try {
			return sendUtil.sendKitService(kitId, "/dbKit/getDbTableInfoOfAll", null);
		} catch (Exception e) {
			log.error("getDbTableInfo fail", e);
		}
		return ResultVo.fail();
	}

	@PostMapping("clearTable")
	public void clearTable(ClearTableOpVo clearTableOpVo) {
		sendUtil.sendKitService(clearTableOpVo.getKitId(), "/dbKit/clearTable", clearTableOpVo);
	}

}

