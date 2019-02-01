package com.microcore.center.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.api.SysApi;
import com.microcore.api.model.DbDbKit;
import com.microcore.api.model.DbFileKit;
import com.microcore.api.model.DbLabelKit;
import com.microcore.api.model.DbServiceKit;
import com.microcore.api.vo.KitVo;
import com.microcore.center.client.DbSafeguardTemplate;
import com.microcore.center.mapper.DbDbKitMapper;
import com.microcore.center.mapper.DbFileKitMapper;
import com.microcore.center.mapper.DbLabelKitMapper;
import com.microcore.center.mapper.DbServerMapper;
import com.microcore.center.mapper.DbServiceKitMapper;
import com.microcore.center.model.DbServer;
import com.microcore.center.model.DbServerExample;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
@RestController
@RequestMapping("dbServer")
public class DbServerController {

	@Autowired
	private DbServerMapper dbServerMapper;
	@Autowired
	private DbFileKitMapper dbFileKitMapper;
	@Autowired
	private DbDbKitMapper dbDbKitMapper;
	@Autowired
	private DbServiceKitMapper dbServiceKitMapper;
	@Autowired
	private DbLabelKitMapper dbLabelKitMapper;
	@Autowired
	private DbSafeguardTemplate dbSafeguardTemplate;
	@Autowired
	private SysApi sysApi ;

	private static final String SAFE_GUARD_KIT ="safeguardKit";
	
	@GetMapping("getDbServer")
	public ResultVo getDbServer(@RequestParam(name = "ip") String ip, @RequestParam(name = "port") Integer port) {
		DbServerExample example = new DbServerExample();
		DbServerExample.Criteria criteria = example.createCriteria();
		criteria.andIpEqualTo(ip);
		criteria.andPortEqualTo(port);
		List<DbServer> list = dbServerMapper.selectByExample(example);
		if (!list.isEmpty()) {
			return ResultVo.ok(list.get(0));
		}
		return ResultVo.ok();
	}

	@PostMapping("startTag")
	public ResultVo startTag(@RequestBody KitVo kitVo) {
		getKitVo(kitVo);
		if(StringUtil.isEmpty(kitVo.getServerId())) {
			return ResultVo.fail("未注册该服务器无法启动服务！");
		}
		ResultVo resultVo = sysApi.isRun(kitVo.getServerId());
		if(resultVo.getStatus() == 200) {
			Map<String,Object> result = (Map<String, Object>) resultVo.getData() ;
			if("true".equals(result.get(SAFE_GUARD_KIT)+"")) {
				dbSafeguardTemplate.startTag(kitVo.getServerId(), kitVo);
			}else if("false".equals(result.get(SAFE_GUARD_KIT)+"")) {
				return ResultVo.fail("套件守护进程未启动！");
			}else {
				return ResultVo.fail("套件守护进程未安装！");
			}
		}else {
			return resultVo;
		}
		return ResultVo.ok();
	}

	@PostMapping("stopTag")
	public ResultVo stopTag(@RequestBody KitVo kitVo) {
		getKitVo(kitVo);
		if(StringUtil.isEmpty(kitVo.getServerId())) {
			return ResultVo.fail("未注册该服务器无法停止服务！");
		}
		ResultVo resultVo = sysApi.isRun(kitVo.getServerId());
		if(resultVo.getStatus() == 200) {
			Map<String,Object> result = (Map<String, Object>) resultVo.getData() ;
			if("true".equals(result.get(SAFE_GUARD_KIT)+"")) {
				dbSafeguardTemplate.stopTag(kitVo.getServerId(), kitVo);
			}else if("false".equals(result.get(SAFE_GUARD_KIT)+"")) {
				return ResultVo.fail("套件守护进程未启动！");
			}else {
				return ResultVo.fail("套件守护进程未安装！");
			}
		}else {
			return resultVo;
		}
		return ResultVo.ok();
	}

	private DbServer getServer(String ip) {
		DbServerExample example = new DbServerExample();
		DbServerExample.Criteria criteria = example.createCriteria();
		criteria.andIpEqualTo(ip);
		List<DbServer> list = dbServerMapper.selectByExample(example);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	private KitVo getKitVo(KitVo kitVo) {
		DbServer dbServer;
		switch (kitVo.getType()) {
		case "file":
			DbFileKit dbFileKit = dbFileKitMapper.selectByPrimaryKey(kitVo.getId());
			kitVo.setRunCmd(dbFileKit.getRunCmd());
			kitVo.setStatusCmd(dbFileKit.getKillCmd());
			dbServer = getServer(dbFileKit.getTagIp());
			if (dbServer != null) {
				kitVo.setServerId(dbServer.getId());
			}
			break;
		case "db":
			DbDbKit dbDbKit = dbDbKitMapper.selectByPrimaryKey(kitVo.getId());
			kitVo.setRunCmd(dbDbKit.getRunCmd());
			kitVo.setStatusCmd(dbDbKit.getKillCmd());
			dbServer = getServer(dbDbKit.getTagIp());
			if (dbServer != null) {
				kitVo.setServerId(dbServer.getId());
			}
			break;
		case "service":
			DbServiceKit dbServiceKit = dbServiceKitMapper.selectByPrimaryKey(kitVo.getId());
			kitVo.setRunCmd(dbServiceKit.getRunCmd());
			kitVo.setStatusCmd(dbServiceKit.getKillCmd());
			dbServer = getServer(dbServiceKit.getTagIp());
			if (dbServer != null) {
				kitVo.setServerId(dbServer.getId());
			}
			break;
		case "label":
			DbLabelKit dbLabelKit = dbLabelKitMapper.selectByPrimaryKey(kitVo.getId());
			kitVo.setRunCmd(dbLabelKit.getRunCmd());
			kitVo.setStatusCmd(dbLabelKit.getKillCmd());
			dbServer = getServer(dbLabelKit.getTagIp());
			if (dbServer != null) {
				kitVo.setServerId(dbServer.getId());
			}
			break;
		default:
			break;
		}
		return kitVo;
	}

}
