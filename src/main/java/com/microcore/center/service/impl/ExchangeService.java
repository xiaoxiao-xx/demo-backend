package com.microcore.center.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.client.FileKitTemplate;
import com.microcore.center.dto.DbFileKitDto;
import com.microcore.center.mapper.DbOrgAreaRelMapper;
import com.microcore.center.mapper.DbPubFileMapper;
import com.microcore.center.mapper.DbSubFileMapper;
import com.microcore.center.model.DbPubFile;
import com.microcore.center.model.DbSubFile;
import com.microcore.center.service.DbApprovalService;
import com.microcore.center.service.DbFileKitService;
import com.microcore.center.service.DbOrgAreaService;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.service.DbParamsService;
import com.microcore.center.service.DbPubFileService;
import com.microcore.common.rabbit.MqExchangeVo;
import com.microcore.common.rabbit.RPCRabbitClient;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.UserUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Service
@Transactional
@Slf4j
public class ExchangeService {

	@Autowired
	private DbSubFileMapper dbSubFileMapper;
	@Autowired
	private DbPubFileMapper dbPubFileMapper;
	@Autowired
	private DbPubFileService dbPubFileService;
	@Autowired
	private DbParamsService dbParamsService;
	@Autowired
	private FileKitTemplate fileKitTemplate;
	@Autowired
	private DbFileKitService dbFileKitService;
	@Autowired
	private DbOrgService dbOrgService;
	@Autowired
	private UserService userService;
	@Autowired
	private DbOrgAreaService dbOrgAreaService;
	@Autowired
	private RPCRabbitClient rabbitClient;
	@Autowired
	private DbApprovalService dbApprovalService;
	@Autowired
	private DbOrgAreaRelMapper dbOrgAreaRelMapper;
	
	/**
	 * 异步创建交换信息
	 *
	 * @param dbSubFile
	 * @param myOrgId
	 * @return 
	 * @return
	 * @throws Exception
	 */
	@Async
	public void createExchangeInfo(String id,String pubId,String pubExchangeId,String myExchangeId) {
		String time = "10";
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("subpath", pubId);
		pMap.put("sourceinfoid", Long.parseLong(pubExchangeId));
		pMap.put("targetinfoid", Long.parseLong(myExchangeId));
		pMap.put("dispatchstrategy", time);

		MqExchangeVo<Map<String, Object>> exchangeVo = new MqExchangeVo<>();
		exchangeVo.setURI("/api/file/createExchangeInfo");
		exchangeVo.setParam(pMap);
		JSONObject resJson = new JSONObject();
		log.info("创建交换信息开始："+JSONObject.fromObject(exchangeVo).toString());
		try {
			String res = rabbitClient.callExchange(exchangeVo);
			log.info("创建交换信息结果："+res);
			resJson = JSONObject.fromObject(res);
		} catch (Exception e) {
			log.error("交换信息创建异常[{}]",e.getMessage());
		}
		if (!"200".equals(resJson.get("status") + "")) {
			log.error("交换信息创建失败！");
			return;
		}
		String exchangeInfoId = resJson.get("data") + "";
		DbSubFile dbSubFile = new DbSubFile();
		dbSubFile.setSubId(id);
		dbSubFile.setExchangeInfoId(exchangeInfoId);
		dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
	}
	
	@Async
	public JSONObject runExchange(DbSubFile dbSubFile) {
		MqExchangeVo<Long> exchangeVo = new MqExchangeVo<>();
		exchangeVo.setURI("/api/file/runExchange");
		exchangeVo.setParam(Long.parseLong(dbSubFile.getExchangeInfoId()));
		JSONObject resJson = null;
		try {
			String res = rabbitClient.callExchange(exchangeVo);
			log.info("启动交换结果："+res);
			resJson = JSONObject.fromObject(res);
		} catch (Exception e) {
			log.error("文件交换异常[{}]",e.getMessage());
		}
		return resJson;
	}
	
	@Async
	public JSONObject stopExchange(DbSubFile dbSubFile) {
		MqExchangeVo<Long> exchangeVo = new MqExchangeVo<>();
		exchangeVo.setURI("/api/file/stopExchange");
		exchangeVo.setParam(Long.parseLong(dbSubFile.getExchangeInfoId()));
		JSONObject resJson = null;
		try {
			String res = rabbitClient.callExchange(exchangeVo);
			log.info("停止交换结果："+res);
			resJson = JSONObject.fromObject(res);
		} catch (Exception e) {
			log.error("文件交换异常[{}]",e.getMessage());
		}
		return resJson;
	}
	
	
	
	
	
}
