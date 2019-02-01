package com.microcore.center.client;

import java.util.List;

import com.microcore.common.util.SendUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microcore.api.model.DbFileKit;
import com.microcore.center.mapper.DbFileKitMapper;
import com.microcore.center.model.DbFileKitExample;
import com.microcore.common.constant.Constants;
import com.microcore.common.dto.SubDelDto;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.vo.WithdrawPubVo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author
 */
@Component
@Slf4j
public class FileKitTemplate {

	private final DbFileKitMapper dbFileKitMapper;

	private SendUtil sendUtil;

	@Autowired
	public FileKitTemplate(SendUtil sendUtil, DbFileKitMapper dbFileKitMapper) {
		this.sendUtil = sendUtil;
		this.dbFileKitMapper = dbFileKitMapper;
	}

	private String getKitId() {
		String orgId = CommonUtil.getOrgId();
		return getKitIdByOrgId(orgId);
	}

	private String getKitIdByOrgId(String orgId) {
		DbFileKitExample example = new DbFileKitExample();
		DbFileKitExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		List<DbFileKit> list = dbFileKitMapper.selectByExample(example);
		String kitId = "";
		if (!CommonUtil.isEmpty(list)) {
			kitId = list.get(0).getId();
		}
		return kitId;
	}

	private void send(String uri, Object param) {
		sendUtil.send(getKitId(), uri, param);
	}

	private void send(String uri, Object param, String orgId) {
		sendUtil.send(getKitIdByOrgId(orgId), uri, param);
	}

	public ResultVo fileService(String serviceURL, Object params) {
		send(serviceURL, params);
		return ResultVo.ok();
	}

	public ResultVo fileServiceByOrg(String serviceURL, Object params, String orgId) {
		send(serviceURL, params, orgId);
		return ResultVo.ok();
	}

	public void fileService(String serviceURL, Object params, String kitId) {
		sendUtil.send(kitId, serviceURL, params);
	}

	public ResultVo fileServiceRPC(String serviceURL, Object params, String kitId) {
		try {
			return sendUtil.sendKitService(kitId, serviceURL, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultVo.fail("套件连接失败");
	}

	public ResultVo fileServiceRPC(String serviceURL, Object params) {
		try {
			return sendUtil.sendKitService(getKitId(), serviceURL, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultVo.fail();
	}

	public void withdrawPub(WithdrawPubVo vo) {
		send("/filePub/withdrawPub", vo);
	}

	public void deleteSubByPubIdAndSubOrgId(String pubId, String subOrgId) {
		sendUtil.send(subOrgId, "/fileSub/deleteSubByPubIdAndSubOrgId", new SubDelDto(pubId, subOrgId));
	}

}
