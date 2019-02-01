/**
 * Project Name:sls-center
 * File Name:BlockChServiceImpl.java
 * Package Name:com.microcore.center.service.impl
 * Date:2019年1月15日上午10:25:28
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved.
 */

package com.microcore.center.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microcore.api.model.DbOrg;
import com.microcore.center.service.BlockChService;
import com.microcore.center.service.DbParamsService;
import com.microcore.common.util.BlockChainUtil;
import com.microcore.common.util.UserUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:BlockChServiceImpl <br/>
 * Date: 2019年1月15日 上午10:25:28 <br/>
 *
 * @author whater
 * @version
 * @since JDK 1.8
 * @see
 */
@Service
@Slf4j
public class BlockChServiceImpl implements BlockChService {

	private boolean start = false;

	@Autowired
	private DbParamsService dbParamsService;

	@Override
	public boolean inite() {
		if (!start) {
			try {
				String blockchainIp = dbParamsService.getParamsValueByTypeAndKey("blockchain",
						"blockchainIp");
				start = BlockChainUtil.init(blockchainIp);
				log.info("区块链初始化成功！");
			} catch (Exception e) {
				log.error("区块链初始化失败！", e.getMessage());
			}
		}
		return start;
	}

	@Override
	public Map<String, String> registUser(String userId, String name, String email) {
		return BlockChainUtil.registUser(userId, name, email);
	}

	@Override
	public void dataPubAndShare(String labelId, String dDomain, String dSensitivity, String dataType, String orgIds) {
		if (!inite()) {
			return;
		}
		DbOrg dbOrg = UserUtil.getCurrentLoginUser().getDbOrg();
		String sk = dbOrg.getSk();
		String fromUserId = dbOrg.getOrgId();
		BlockChainUtil.dataPub(labelId, dDomain, dSensitivity, dataType, fromUserId, sk, getfinger());
		dataShare(labelId, orgIds);
	}

	@Override
	public void dataShare(String labelId, String orgIds) {
		if (!inite()) {
			return;
		}
		DbOrg dbOrg = UserUtil.getCurrentLoginUser().getDbOrg();
		String sk = dbOrg.getSk();
		String fromUserId = dbOrg.getOrgId();
		BlockChainUtil.dataShare(labelId, fromUserId, orgIds, sk, getfinger());
	}

	@Override
	public boolean dataRead(String labelId, String orgId) {
		if (!inite()) {
			return false;
		}
		DbOrg dbOrg = UserUtil.getCurrentLoginUser().getDbOrg();
		String toUserId = dbOrg.getOrgId();
		String sk = dbOrg.getSk();
		return BlockChainUtil.dataRead(labelId, toUserId, sk);
	}

	public String getfinger() {
		String fingerPath = dbParamsService.getParamsValueByTypeAndKey("BlockCh", "PATH");
		File file = new File(fingerPath);
		if (file.exists() && file.isDirectory()) {
			File[] files = file.listFiles();
			List<File> fileList = new ArrayList<>();
			for (File file2 : files) {
				if (file2.isFile()) {
					fileList.add(file2);
				}
			}
			if (!fileList.isEmpty()) {
				int size = fileList.size();
				int index = Double.valueOf(Math.random() * size).intValue();
				String finger = BlockChainUtil.fuzzyHashFile(fileList.get(index).getAbsolutePath());
				log.info("计算数据指纹:[{}],[{}]", index, finger);
				return finger;
			}
		}
		//默认的数据指纹
		log.info("默认的数据指纹:[96:ccKj1roV4tQHhByfNKqf2B6fd9ufdidsafxWg2:ccikb2iGOj]");
		return "96:ccKj1roV4tQHhByfNKqf2B6fd9ufdidsafxWg2:ccikb2iGOj";
	}

	@Override
	public void dataRequest(String labelId) {
		if (!inite()) {
			return;
		}
		DbOrg dbOrg = UserUtil.getCurrentLoginUser().getDbOrg();
		String sk = dbOrg.getSk();
		BlockChainUtil.dataRequest(labelId, dbOrg.getOrgId(), sk);
	}

	@Override
	public void dataEvaluation(String labelId) {
		if (!inite()) {
			return;
		}
		DbOrg dbOrg = UserUtil.getCurrentLoginUser().getDbOrg();
		String userId = dbOrg.getOrgId();
		String sk = dbOrg.getSk();
		int s = Double.valueOf(Math.random() * 30).intValue() + 70;
		String rEvalData = "数据质量良好！";
		if (s <= 80) {
			rEvalData = "数据质量一般！";
		} else if (s <= 90) {
			rEvalData = "数据质量良好！";
		} else if (s <= 100) {
			rEvalData = "数据质量优秀！";
		}
		String score = s + "";
		BlockChainUtil.dataEvaluation(labelId, userId, rEvalData, score, getfinger(), sk);
	}
}
