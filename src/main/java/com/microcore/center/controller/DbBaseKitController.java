package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.api.SysApi;
import com.microcore.api.vo.DbBaseKitVo;
import com.microcore.center.service.DbBaseKitService;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

@RestController
@RequestMapping("baseKit")
public class DbBaseKitController {

	@Autowired
	private DbBaseKitService dbBaseKitService;
	@Autowired
	private SysApi sysApi ;
	
	@PostMapping("add")
	public ResultVo<?> add(@RequestBody DbBaseKitVo dbLabelKit) {
		return dbBaseKitService.add(dbLabelKit);
	}

	@PostMapping("update")
	public ResultVo<?> update(@RequestBody DbBaseKitVo dbLabelKit) {
		return dbBaseKitService.update(dbLabelKit);
	}

	@GetMapping("delete")
	public ResultVo<?> delete(@RequestParam(name = "id") String id) {
		return dbBaseKitService.delete(id);
	}

	@GetMapping("clearnMAC")
	public ResultVo<?> cleanMAC(@RequestParam(name = "id") String id) {
		return dbBaseKitService.cleanMAC(id);
	}

	@GetMapping("getVCode")
	public ResultVo<?> getVCode(@RequestParam(name = "id") String id) {
		return dbBaseKitService.getVCode(id);
	}

	@PostMapping("startKit")
	public ResultVo<?> startKit(@RequestBody DbBaseKitVo dbLabelKitVo) {
		return dbBaseKitService.startKit(dbLabelKitVo);
	}

	@GetMapping("getKit")
	public ResultVo<?> getKit(@RequestParam(name = "orgId") String orgId,
	                          @RequestParam(name = "tagType") String tagType) {
		return ResultVo.ok(dbBaseKitService.getKitByOrgAndTagType(orgId, tagType));
	}

	@GetMapping("getKitById")
	public ResultVo<?> getKitById(@RequestParam(name = "id") String id) {
		return ResultVo.ok(dbBaseKitService.getKitByKitId(id));
	}
	
	@GetMapping("getLabelService")
	public ResultVo<?> getLabelService(@RequestParam(name = "orgId") String orgId) {
		ResultVo vo = sysApi.getPolicyOrLabelOrg(orgId, "label");
		if(vo.getData() != null && StringUtil.isNotEmpty(vo.getData().toString())) {
			return ResultVo.ok(dbBaseKitService.getKitByOrgAndTagType(vo.getData().toString(), "LABEL")); 
		}
		return ResultVo.ok();
	}
	
	@GetMapping("getPolicyService")
	public ResultVo<?> getPolicyService(@RequestParam(name = "orgId") String orgId) {
		ResultVo vo = sysApi.getPolicyOrLabelOrg(orgId, "policy");
		if(vo.getData() != null && StringUtil.isNotEmpty(vo.getData().toString())) {
			return ResultVo.ok(dbBaseKitService.getKitByOrgAndTagType(vo.getData().toString(), "POLICY")); 
		}
		return ResultVo.ok();
	}
	
}
