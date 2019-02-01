package com.microcore.center.controller;

import java.util.List;

import com.microcore.center.model.ShArea;
import com.microcore.center.service.DbOrgAreaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbOrg;
import com.microcore.api.vo.DbBaseKitVo;
import com.microcore.center.client.DbKitTemplate;
import com.microcore.center.dto.DbOrgDto;
import com.microcore.center.model.DbArea;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.vo.DbOrgVo;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;

@RestController
@RequestMapping("dbOrg")
public class DbOrgController {

	private final DbOrgService dbOrgService;
	private final DbOrgAreaService dbOrgAreaService;

	@Autowired
	public DbOrgController(DbOrgService dbOrgService, DbOrgAreaService dbOrgAreaService,
	                       DbKitTemplate dbDbKitTemplate) {
		this.dbOrgService = dbOrgService;
		this.dbOrgAreaService = dbOrgAreaService;
		dbOrgService.setDbDbKitTemplate(dbDbKitTemplate);
	}

	@GetMapping("orgList")
	public ResultVo<PageInfo<DbOrgVo>> orgList(@RequestParam(name = "orgName") String orgName,
	                                           @RequestParam(name = "pageIndex") Integer pageIndex,
	                                           @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(dbOrgService.orgList(null, orgName, pageIndex, pageSize));
	}

	@GetMapping("queryDbOrg")
	public ResultVo<PageInfo<DbOrgVo>> queryDbOrg(@RequestParam(name = "orgId", required = false) String orgId,
	                                              @RequestParam(name = "orgName", required = false) String orgName,
	                                              @RequestParam(name = "areaId") String areaId,
	                                              @RequestParam(name = "pageIndex") Integer pageIndex,
	                                              @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(dbOrgService.queryDbOrg(orgId, orgName, areaId, pageIndex, pageSize));
	}

	@ApiOperation(value = "查询当前用户可见的所有机构的列表", notes = "查询当前用户可见的所有机构的列表")
	@GetMapping("list")
	public ResultVo<List<DbOrg>> list() {
		return ResultVo.ok(dbOrgService.list());
	}

	@ApiOperation(value = "查询所有机构的列表", notes = "查询所有机构的列表")
	@GetMapping("listOfAll")
	public ResultVo<List<DbOrg>> listOfAll() {
		return ResultVo.ok(dbOrgService.listOfAll());
	}

	@ApiOperation(value = "查询当前用户可见的所有其它机构的列表", notes = "查询当前用户可见的所有其它机构的列表")
	@GetMapping("otherList")
	public ResultVo<List<DbOrg>> otherList() {
		return ResultVo.ok(dbOrgService.otherList());
	}

	@ApiOperation(value = "查询当前用户可订阅的机构的列表", notes = "查询当前用户可订阅的机构的列表")
	@GetMapping("getOrgListByPub")
	public ResultVo getOrgListByPub(String type) {
		return dbOrgService.getOrgListByPub(type);
	}

	@GetMapping("otherListForLabelManage")
	public ResultVo otherListForLabelManage() {
		return dbOrgService.otherListForLabelManage();
	}

	@PostMapping("add")
	public ResultVo add(@RequestBody DbOrgVo dbOrgVo) {
		dbOrgService.add(dbOrgVo);
		return ResultVo.ok();
	}

	@PostMapping("update")
	public ResultVo update(@RequestBody DbOrgVo dbOrgVo) {
		dbOrgService.update(dbOrgVo);
		return ResultVo.ok();
	}

	@PostMapping("delete")
	public ResultVo delete(@RequestBody String orgId) {
		dbOrgService.delete(orgId);
		return ResultVo.ok();
	}

	@GetMapping("getDbOrg")
	public ResultVo<DbOrg> getDbOrg(@RequestParam(name = "orgId") String orgId) {
		return ResultVo.ok(dbOrgService.getDbOrgByOrgSort(orgId));
	}

	@GetMapping("getDbOrgVo")
	public ResultVo<?> getDbOrgVo(@RequestParam(name = "orgId") String orgId) {
		PageInfo<DbOrgVo> page = dbOrgService.orgList(orgId, null, 1, 10);
		if (CommonUtil.isEmpty(page.getList())) {
			return ResultVo.ok();
		}
		return ResultVo.ok(page.getList().get(0));
	}

	@ApiOperation(value = "获取区域联动信息", notes = "获取区域联动信息")
	@GetMapping("getLayerArea")
	public ResultVo<List<ShArea>> getLayerArea(String id) {
		return dbOrgAreaService.getLayerArea(id);
	}

	@GetMapping("getDbAreaByOrgId")
	public ResultVo<List<DbArea>> getDbAreaByOrgId(String orgId) {
		return ResultVo.ok(dbOrgAreaService.getDbAreaByOrgId(orgId));
	}

	@GetMapping("getKitInfoByOrgId")
	public ResultVo<List<DbBaseKitVo>> getKitInfoByOrgId(String orgId, String type) {
		return ResultVo.ok(dbOrgService.getKitInfoByOrgId(orgId, type));
	}

	@GetMapping("getOrgKitInfo")
	public ResultVo<List<DbOrgDto>> getOrgKitInfo() {
		return dbOrgService.getOrgKitInfo();
	}

	@GetMapping("getLabelKitInfo")
	public ResultVo<List<DbOrgDto>> getLabelKitInfo() {
		return dbOrgService.getLabelKitInfo();
	}
}
