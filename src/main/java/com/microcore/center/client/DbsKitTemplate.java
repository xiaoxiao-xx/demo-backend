package com.microcore.center.client;

import com.microcore.api.vo.DbBaseKitVo;
import com.microcore.api.vo.DbPubTsVo;
import com.microcore.api.vo.DbSubTsVo;
import com.microcore.center.service.DbBaseKitService;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.SendUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.microcore.common.util.CommonUtil.getOrgId;

/**
 * @author lmh
 */
@Component
@Slf4j
public class DbsKitTemplate {

	private final DbBaseKitService dbBaseKitService;

	private final SendUtil sendUtil;

	@Autowired
	public DbsKitTemplate(DbBaseKitService dbBaseKitService, SendUtil sendUtil) {
		this.dbBaseKitService = dbBaseKitService;
		this.sendUtil = sendUtil;
	}

	private String getKitId() {
		String orgId = getOrgId();
		DbBaseKitVo dbsKit = dbBaseKitService.getKitByOrgAndTagType(orgId, Constants.TAG_TYPE_DBS);
		return dbsKit.getId();
	}

	private void send(String uri, Object param) {
		sendUtil.send(getKitId(), uri, param);
	}

	public void addPubTs(DbPubTsVo vo) {
		send("/pubTableService/add", vo);
	}

	public void delPubTs(String id) {
		send("/pubTableService/del", id);
	}

	public void pub(String id) {
		send("/pubTableService/pub", id);
	}

	public void startPub(String id) {
		send("/pubTableService/startPub", id);
	}

	public void stopPub(String id) {
		send("/pubTableService/stopPub", id);
	}

	public void addSub(DbSubTsVo vo) {
		send("/subTableService/addSub", vo);
	}

	public void startSub(String id) {
		send("/subTableService/startSub", id);
	}

	public void stopSub(String id) {
		send("/subTableService/stopSub", id);
	}

	public void deleteSub(String id) {
		send("/subTableService/deleteSub", id);
	}

}

