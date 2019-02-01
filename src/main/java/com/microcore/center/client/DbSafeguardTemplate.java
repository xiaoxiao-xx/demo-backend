package com.microcore.center.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microcore.api.vo.KitVo;
import com.microcore.common.util.SendUtil;

/**
 *
 * @author whater
 */
@Component
public class DbSafeguardTemplate {

	private final SendUtil sendUtil;

	@Autowired
	public DbSafeguardTemplate(SendUtil sendUtil) {
		this.sendUtil = sendUtil;
	}

	public void startTag(String id, KitVo kitVo) {
		sendUtil.send(id, "/serverOpt/startTag", kitVo);
	}

	public void stopTag(String id, KitVo kitVo) {
		sendUtil.send(id, "/serverOpt/stopTag", kitVo);
	}

}
