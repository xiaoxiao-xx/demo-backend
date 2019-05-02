package com.rainyhon.backend.controller;

import com.microcore.center.model.Org;
import com.rainyhon.common.service.OrgService;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("org")
public class OrgController {

	@Autowired
	private OrgService orgService;

	@GetMapping("getOrgList")
	public ResultVo getOrgList(@RequestParam Integer pageIndex,
	                           @RequestParam Integer pageSize) {
		return ResultVo.ok(orgService.getOrgList(pageIndex, pageSize));
	}

	@GetMapping("getAllOrgs")
	public ResultVo getOrgList() {
		return ResultVo.ok(orgService.getAllOrgs());
	}

	@PostMapping("addOrg")
	public ResultVo addOrg(@RequestBody Org vo) {
		orgService.addOrg(vo);
		return ResultVo.ok();
	}

	@PostMapping("deleteOrgById")
	public ResultVo deleteOrgById(@RequestParam String id) {
		orgService.deleteOrgById(id);
		return ResultVo.ok();
	}

	@PostMapping("batchDelete")
	public ResultVo batchDelete(@RequestBody List<String> idList) {
		orgService.batchDelete(idList);
		return ResultVo.ok();
	}

	@PostMapping("updateOrg")
	public ResultVo updateOrg(@RequestBody Org vo) {
		orgService.updateOrg(vo);
		return ResultVo.ok();
	}

	@GetMapping("getOrgTree")
	public ResultVo<?> getOrgTree() {
		return orgService.getOrgTree();
	}

}
