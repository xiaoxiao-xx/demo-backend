package com.microcore.center.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.api.model.DbLabelKit;
import com.microcore.api.model.DbOrg;
import com.microcore.api.vo.PolicyVo;
import com.microcore.center.client.LabelTemplate;
import com.microcore.center.service.DbAreaService;
import com.microcore.center.service.DbLabelKitService;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.service.DbParamsService;
import com.microcore.common.util.ByteUtils;
import com.microcore.common.util.JSONUtils;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 溯源
 *
 * @author whater
 */
@RestController
@RequestMapping("/dbTrace")
@Slf4j
public class DbTraceController {

	private final LabelTemplate labelTemplate;

	@Autowired
	public DbTraceController(LabelTemplate labelTemplate) {
		this.labelTemplate = labelTemplate;
	}

	@Autowired
	private DbLabelKitService dbLabelKitService;
	@Autowired
	private DbOrgService dbOrgService;
	@Autowired
	private DbAreaService dbAreaService;
	@Autowired
	private DbParamsService dbParamsService;

	private static final String DATA_CHANGED = "数据被篡改！";

	@GetMapping("traceInfo")
	public ResultVo getTraceInfo(@RequestParam(name = "label") String label) {
		log.info("溯源:[{}]", label);

		DbLabelKit dbLabelKit;
		try {
			byte[] valueBinary = ByteUtils.hex2byte(label);
			if (valueBinary.length <= 16) {
				return ResultVo.fail(DATA_CHANGED);
			}
			int orgSort = ByteUtils.byte4ToInt(ByteUtils.bytesSub(valueBinary, 0, 4));
			DbOrg dbOrg = dbOrgService.getDbOrgByOrgSort(orgSort);
			if (dbOrg == null) {
				return ResultVo.fail(DATA_CHANGED);
			}
			dbLabelKit = dbLabelKitService.getDbLabelKitByOrgId(dbOrg.getOrgId());
			if (dbLabelKit == null) {
				return ResultVo.fail(DATA_CHANGED);
			}
			log.info("标签 信息:[{}]", JSONUtils.toJSONObject(dbLabelKit));
		} catch (Exception e1) {
			log.error("标签套件异常！", e1);
			return ResultVo.fail(DATA_CHANGED);
		}
		try {
			ResultVo<PolicyVo> vo = labelTemplate.traceInfo(dbLabelKit.getTagIp(), dbLabelKit.getTagPort(), label);
			if (vo.getStatus() == 200) {
				log.info("溯源返回信息:[{}]", JSONUtils.toJSONObject(vo));
				PolicyVo data = vo.getData();
				String[] d = data.getTraceInfo().split("\\|");
				int rid = Integer.parseInt(d[0]);
				DbOrg rdbOrg = dbOrgService.getDbOrgByOrgSort(rid);
				int uid = Integer.parseInt(d[1]);
				DbOrg udbOrg = dbOrgService.getDbOrgByOrgSort(uid);
				String result = d[2];
				Map<String, Object> value = new HashMap<>();
				value.put("rid_org", rdbOrg);
				value.put("uid_org", udbOrg);
				value.put("result", result);
				value.put("policy", data);
				if ("ORG".equalsIgnoreCase(data.getPolAuthType())) {
					StringBuilder name = new StringBuilder();
					String[] authScope = data.getPolAuthScope().split(",");
					for (String orgId : authScope) {
						name.append(",").append(dbOrgService.getOrgNameByOrgId(orgId));
					}
					if (StringUtil.isNotEmpty(name.toString())) {
						data.setPolAuthScopeName(name.substring(1));
					}
				} else {
					StringBuilder name = new StringBuilder();
					String[] authScope = data.getPolAuthScope().split(",");
					for (String areaId : authScope) {
						name.append(",").append(dbAreaService.getAreaNameByAreaId(areaId));
					}
					if (StringUtil.isNotEmpty(name.toString())) {
						data.setPolAuthScopeName(name.substring(1));
					}
				}
				if (StringUtil.isNotEmpty(data.getPolSecurityLevel())) {
					String polSecurityLevelName = dbParamsService.getParamsValueByTypeAndKey("sen_grade",
							data.getPolSecurityLevel());
					data.setPolSecurityLevelName(polSecurityLevelName);
				}
				return ResultVo.ok(value);
			} else {
				return vo;
			}
		} catch (Exception e) {
			log.error("标签套件网络异常！", e);
			return ResultVo.fail("标签套件网络异常！");
		}

	}
}

