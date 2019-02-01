package com.microcore.center.controller;

import com.microcore.api.vo.DbSubTsVo;
import com.microcore.center.service.DbSubTsService;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 库表服务订阅
 *
 * @author lmh
 */
@RestController
@RequestMapping("subTableService")
public class DbSubTsController {

	private final DbSubTsService dbSubTableService;

	@Autowired
	public DbSubTsController(DbSubTsService dbSubTsService) {
		this.dbSubTableService = dbSubTsService;
	}

	@ApiOperation(value = "提交订阅信息", notes = "提交订阅信息")
	@ApiImplicitParam(name = "vo", value = "SubTableVo对象", required = true, dataType = "SubTsVo")
	@PostMapping("addSub")
	public ResultVo addSub(@RequestBody DbSubTsVo vo) {
		return dbSubTableService.addSub(vo);
	}

	@ApiOperation(value = "启动订阅", notes = "启动订阅")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@PostMapping("startSub")
	public ResultVo startPub(@RequestBody String id) {
		dbSubTableService.startSub(id);
		return ResultVo.ok("启动成功");
	}

	@ApiOperation(value = "批量启动订阅", notes = "批量启动订阅")
	@ApiImplicitParam(name = "idList", value = "ID列表", required = true, dataType = "List")
	@PostMapping("batchStartSub")
	public ResultVo batchStartPub(@RequestBody List<String> idList) {
		dbSubTableService.batchStartSub(idList);
		return ResultVo.ok("启动成功");
	}

	@ApiOperation(value = "停止订阅", notes = "停止订阅")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@PostMapping("stopSub")
	public ResultVo stopSub(@RequestBody String id) {
		dbSubTableService.stopSub(id);
		return ResultVo.ok("停止成功");
	}

	@ApiOperation(value = "批量停止订阅", notes = "批量停止订阅")
	@ApiImplicitParam(name = "idList", value = "ID列表", required = true, dataType = "List")
	@PostMapping("batchStopSub")
	public ResultVo batchStopSub(@RequestBody List<String> idList) {
		dbSubTableService.batchStopSub(idList);
		return ResultVo.ok("停止成功");
	}

	@ApiOperation(value = "删除订阅", notes = "删除订阅信息")
	@ApiImplicitParam(name = "idList", value = "ID列表", required = true, dataType = "List")
	@PostMapping("deleteSub")
	public ResultVo delSub(@RequestBody String id) {
		dbSubTableService.deleteSub(id);
		return ResultVo.ok("删除成功");
	}

	@ApiOperation(value = "批量删除订阅", notes = "批量删除订阅信息")
	@ApiImplicitParam(name = "idList", value = "ID列表", required = true, dataType = "List")
	@PostMapping("batchDeleteSub")
	public ResultVo batchDeleteSub(@RequestBody List<String> idList) {
		dbSubTableService.batchDeleteSub(idList);
		return ResultVo.ok("删除成功");
	}

	@ApiOperation(value = "获取订阅详细信息", notes = "获取订阅详细信息")
	@ApiImplicitParam(name = "id", value = "订阅ID", required = true, dataType = "String")
	@GetMapping("detailedInfo")
	public ResultVo detailedInfo(@RequestParam String id) {
		return dbSubTableService.getDetailedInfo(id);
	}

	@ApiOperation(value = "分页获取订阅", notes = "分页获取订阅")
	@GetMapping("getSubList")
	public ResultVo getSubList(@RequestParam(required = false) String taskName,
	                           @RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
		return dbSubTableService.getSubList(taskName, pageIndex, pageSize);
	}

}
