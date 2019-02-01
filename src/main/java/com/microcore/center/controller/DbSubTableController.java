package com.microcore.center.controller;

import com.microcore.center.model.DbDistillRecord;
import com.microcore.center.service.DbDistillRecordService;
import com.microcore.center.service.DbSubTableService;
import com.microcore.center.vo.SubTableVo;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 库表订阅
 */
@RestController
@RequestMapping("subTable")
public class DbSubTableController {

	private final DbSubTableService dbSubTableService;

	private final DbDistillRecordService dbDistillRecordService;

	@Autowired
	public DbSubTableController(DbSubTableService dbSubTableService, DbDistillRecordService dbDistillRecordService) {
		this.dbSubTableService = dbSubTableService;
		this.dbDistillRecordService = dbDistillRecordService;
	}

	@ApiOperation(value = "获取要订阅的表的列信息", notes = "获取要订阅的表的列信息")
	@ApiImplicitParam(name = "pubId", value = "发布ID", required = true, dataType = "String")
	@PostMapping("getTableColumns")
	public ResultVo getTableColumns(@RequestParam(name = "pubId") String pubId) {
		return dbSubTableService.getTableColumns(pubId);
	}

	@ApiOperation(value = "获取指定连接ID和表名的表的列信息", notes = "获取指定连接ID和表名的表的列信息")
	@PostMapping("getColumnsByConIdTableName")
	@ApiImplicitParams({ @ApiImplicitParam(name = "conId", value = "连接ID", required = true, dataType = "String"),
			@ApiImplicitParam(name = "tableName", value = "表名", required = true, dataType = "String") })
	public ResultVo getColumnsByConIdTableName(@RequestParam(name = "conId") String conId,
	                                           @RequestParam(name = "tableName") String tableName) {
		return dbSubTableService.getColumns(conId, tableName);
	}

	@ApiOperation(value = "提交库表订阅信息", notes = "提交库表订阅信息")
	@ApiImplicitParam(name = "subInfo", value = "SubTableVo对象", required = true, dataType = "SubTableVo")
	@PostMapping("submitSub")
	public ResultVo submitSub(@RequestBody SubTableVo subInfo) {
		return dbSubTableService.submitTableSubInfo(subInfo);
	}

	@ApiOperation(value = "启动订阅", notes = "启动订阅")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@PostMapping("startSub")
	public ResultVo startPub(@RequestParam String id) {
		return dbSubTableService.startSub(id);
	}

	@ApiOperation(value = "批量启动订阅", notes = "批量启动订阅")
	@ApiImplicitParam(name = "idList", value = "ID列表", required = true, dataType = "List")
	@PostMapping("batchStartSub")
	public ResultVo batchStartPub(@RequestBody List<String> idList) {
		return dbSubTableService.batchStartSub(idList);
	}

	@ApiOperation(value = "停止订阅", notes = "停止订阅")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@PostMapping("stopSub")
	public ResultVo stopSub(@RequestBody String id) {
		return dbSubTableService.stopSub(id);
	}

	@ApiOperation(value = "批量停止订阅", notes = "批量停止订阅")
	@ApiImplicitParam(name = "idList", value = "ID列表", required = true, dataType = "List")
	@PostMapping("batchStopSub")
	public ResultVo batchStopSub(@RequestBody List<String> idList) {
		return dbSubTableService.batchStopSub(idList);
	}

	@ApiOperation(value = "删除订阅", notes = "删除订阅信息")
	@ApiImplicitParam(name = "id", value = "订阅ID", required = true, dataType = "String")
	@PostMapping("deleteSub")
	public ResultVo delSub(@RequestParam(value = "id") String id) {
		return dbSubTableService.deleteSub(id);
	}

	@ApiOperation(value = "批量删除订阅", notes = "删除订阅信息")
	@ApiImplicitParam(name = "idList", value = "ID列表", required = true, dataType = "List")
	@PostMapping("batchDeleteSub")
	public ResultVo batchDeleteSub(@RequestBody List<String> idList) {
		return dbSubTableService.batchDeleteSub(idList);
	}

	@ApiOperation(value = "获取所有订阅", notes = "获取所有订阅")
	@GetMapping("getAllSubs")
	public ResultVo getAllSubs(@RequestParam String taskName,
	                           @RequestParam String pubOrgName,
	                           @RequestParam Integer pageIndex,
	                           @RequestParam Integer pageSize) {
		return dbSubTableService.getAllSubs(taskName, pubOrgName, pageIndex, pageSize);
	}

	@ApiOperation(value = "分页获取订阅", notes = "分页获取订阅")
	@GetMapping("getSubList")
	public ResultVo getSubList(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
		return dbSubTableService.getSubList(pageIndex, pageSize);
	}

	@ApiOperation(value = "设置脱标任务状态", notes = "根据脱标任务ID设置脱标任务状态")
	@ApiImplicitParams({ @ApiImplicitParam(name = "taskId", value = "任务ID字符串", required = true, dataType = "String"),
			@ApiImplicitParam(name = "taskStatus", value = "任务状态字符串（RUN或者STOP）", required = true, dataType = "String") })
	@PostMapping("setSubTableStatus")
	public ResultVo setSubTableStatus(@RequestParam(name = "subId") String subId,
	                                  @RequestParam(name = "taskStatus") String taskStatus) {
		return dbSubTableService.setSubTableStatus(subId, taskStatus);
	}

	@ApiOperation(value = "清理缓存", notes = "清理缓存")
	@ApiImplicitParam(name = "id", value = "发布的ID", required = true, dataType = "String")
	@PostMapping("clearCache")
	public ResultVo clearCache(@RequestParam String id) {
		dbSubTableService.clearCache(id);
		return ResultVo.ok();
	}

	@ApiOperation(value = "上报脱标记录", notes = "上报脱标记录")
	@PostMapping("uploadDbDistillRecord")
	public ResultVo uploadDbDistillRecord(@RequestBody DbDistillRecord dbDistillRecord) {
		dbDistillRecordService.addDbDistillRecord(dbDistillRecord);
		return ResultVo.ok();
	}

	@ApiOperation(value = "获取订阅详细信息", notes = "获取订阅详细信息")
	@ApiImplicitParam(name = "id", value = "订阅ID", required = true, dataType = "String")
	@GetMapping("detailedInfo")
	public ResultVo detailedInfo(@RequestParam String id) {
		return dbSubTableService.getDetailedInfo(id);
	}

}
