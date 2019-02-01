package com.microcore.center.controller;

import com.microcore.center.service.DbPubTsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.api.vo.DbPubTsVo;
import com.microcore.common.util.ResultVo;

import java.util.List;

/**
 * 库表发布成服务
 *
 * @author whater
 */
@RestController
@RequestMapping("pubTableService")
public class DbPubTsController {

	@Autowired
	private DbPubTsService dbPubTsService;

	@ApiOperation(value = "分页获取发布列表", notes = "分页获取发布列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pubName", value = "发布名", required = true, dataType = "String"),
			@ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "Integer"),
			@ApiImplicitParam(name = "orgId", value = "机构ID", dataType = "String"),
			@ApiImplicitParam(name = "status", value = "运行状态", dataType = "String")
	})
	@GetMapping("getPubList")
	public ResultVo<?> getPubList(@RequestParam(name = "pubName", required = false) String pubName,
	                              @RequestParam(name = "status", required = false) String status,
	                              @RequestParam(name = "pubStatus", required = false) String pubStatus,
	                              @RequestParam(name = "orgId") String orgId,
	                              @RequestParam(name = "pageIndex") Integer pageIndex,
	                              @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(dbPubTsService.getPubList(pubName, status, pubStatus, orgId, pageIndex, pageSize));
	}

	@ApiOperation(value = "分页获取其它机构的发布列表", notes = "分页获取其它机构的发布列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pubName", value = "发布名", required = true, dataType = "String"),
			@ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "Integer"),
			@ApiImplicitParam(name = "status", value = "运行状态", dataType = "String")
	})
	@PostMapping("getOthersPubList")
	public ResultVo<?> getOthersPubList(@RequestParam(name = "pubName", required = false) String pubName,
	                                    @RequestParam(name = "status", required = false) String status,
	                                    @RequestParam(name = "orgId") String orgId,
	                                    @RequestParam(name = "pubStatus", required = false) String pubStatus,
	                                    @RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
		return ResultVo.ok(dbPubTsService.getOthersPubList(pubName, status, orgId, pubStatus, pageIndex, pageSize));
	}

	@PostMapping("add")
	public ResultVo<?> add(@RequestBody DbPubTsVo dbPubTsVo) {
		return dbPubTsService.add(dbPubTsVo);
	}

	@PostMapping("del")
	public ResultVo<?> del(@RequestBody String id) {
		return dbPubTsService.del(id);
	}

	@ApiOperation(value = "批量删除发布", notes = "批量删除发布")
	@PostMapping("batchDeletePub")
	public ResultVo batchDeletePub(@RequestBody List<String> idList) {
		return dbPubTsService.batchDeletePub(idList);
	}

	@ApiOperation(value = "无审批发布", notes = "无审批发布")
	@ApiImplicitParam(name = "id", value = "发布ID", required = true, dataType = "String")
	@PostMapping("pub")
	public ResultVo pubTable(@RequestParam String id) {
		dbPubTsService.pubTs(id);
		return ResultVo.ok("发布成功");
	}

	@ApiOperation(value = "批量发布库表", notes = "批量发布库表")
	@ApiImplicitParam(name = "idList", value = "发布ID列表", required = true, dataType = "List<String>")
	@PostMapping("pubBatch")
	public ResultVo pubTableBatch(@RequestBody List<String> idList) {
		return dbPubTsService.pubBatch(idList);
	}

	@PostMapping("startPub")
	public ResultVo startPub(@RequestBody String id) {
		dbPubTsService.startPub(id);
		return ResultVo.ok("启动成功");
	}

	@ApiOperation(value = "批量启动发布", notes = "批量启动发布")
	@PostMapping("batchStartPub")
	public ResultVo batchStartPub(@RequestBody List<String> idList) {
		return dbPubTsService.batchStartPub(idList);
	}

	@PostMapping("stopPub")
	public ResultVo stopPub(@RequestBody String id) {
		dbPubTsService.stopPub(id);
		return ResultVo.ok("停止成功");
	}

	@ApiOperation(value = "批量停止发布", notes = "批量停止发布")
	@PostMapping("batchStopPub")
	public ResultVo batchStopPub(@RequestBody List<String> idList) {
		return dbPubTsService.batchStopPub(idList);
	}

	@ApiOperation(value = "获取发布详细信息", notes = "获取发布详细信息")
	@ApiImplicitParam(name = "id", value = "发布ID", required = true, dataType = "String")
	@GetMapping("getDetailedInfo")
	public ResultVo getDetailedInfo(@RequestParam String id) {
		return dbPubTsService.getDetailedInfo(id);
	}

	@ApiOperation(value = "获取接口类型", notes = "获取接口类型")
	@GetMapping("getInterfaceType")
	public ResultVo getInterfaceType() {
		return ResultVo.ok(dbPubTsService.getInterfaceType());
	}

}

