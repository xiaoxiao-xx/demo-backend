package com.microcore.center.controller;

import com.microcore.center.model.DbTransRecord;
import com.microcore.center.service.DbPubTableService;
import com.microcore.center.service.DbTransRecordService;
import com.microcore.center.vo.DbPubTableVo;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.vo.WithdrawPubVo;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 库表发布
 *
 * @author lmh
 */
@RestController
@RequestMapping("pubTable")
public class DbPubTableController {

	private final DbPubTableService dbPubTableService;

	private final DbTransRecordService dbTransRecordService;

	@Autowired
	public DbPubTableController(DbPubTableService dbPubTableService, DbTransRecordService dbTransRecordService) {
		this.dbPubTableService = dbPubTableService;
		this.dbTransRecordService = dbTransRecordService;
	}

	@ApiOperation(value = "提交库表发布信息", notes = "提交库表发布信息")
	@ApiImplicitParam(name = "dbPubTableVo", value = "库表表发布信息", required = true, dataType = "DbPubTableVo")
	@PostMapping("submitTablePubInfo")
	public ResultVo submitTablePubInfo(@RequestBody DbPubTableVo dbPubTableVo) {
		return dbPubTableService.submitTablePubInfo(dbPubTableVo);
	}

	@GetMapping("getDbPubTableById")
	public ResultVo getPubList(@RequestParam String pubId) {
		return ResultVo.ok(dbPubTableService.getDbPubTableById(pubId));
	}

	@GetMapping("getDbPubTableByMakeTableName")
	public ResultVo getDbPubTableByMakeTableName(@RequestParam String makeTableName) {
		return ResultVo.ok(dbPubTableService.getDbPubTableByMakeTableName(makeTableName));
	}

	@ApiOperation(value = "分页获取发布列表", notes = "分页获取发布列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pubStatus", value = "发布状态(YES, NO)", required = true, dataType = "String"),
			@ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "Integer") })
	@PostMapping("getPubList")
	public ResultVo getPubList(@RequestParam String pubStatus, @RequestParam Integer pageIndex,
	                           @RequestParam Integer pageSize) {
		return dbPubTableService.getPubList(pubStatus, pageIndex, pageSize, null);
	}

	@ApiOperation(value = "分页获取发布列表", notes = "分页获取发布列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pubStatus", value = "发布状态(YES, NO)", required = true, dataType = "String"),
			@ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "Integer") })
	@PostMapping("getPubList2")
	public ResultVo getPubList2(@RequestParam String pubStatus,
	                            @RequestParam(required = false) String pubName,
	                            @RequestParam Integer pageIndex,
	                            @RequestParam Integer pageSize) {
		return dbPubTableService.getPubList2(pubStatus, pubName, pageIndex, pageSize);
	}

	@ApiOperation(value = "分页获取其它机构的发布列表", notes = "分页获取其它机构的发布列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pubStatus", value = "发布状态(YES, NO)", required = true, dataType = "String"),
			@ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "Integer"),
			@ApiImplicitParam(name = "orgId", value = "机构id", dataType = "String"),
			@ApiImplicitParam(name = "pubName", value = "发布名", dataType = "String"),
			@ApiImplicitParam(name = "pubOrgName", value = "机构名", dataType = "String") })
	@PostMapping("getOthersPubList")
	public ResultVo getOthersPubList(@RequestParam String pubStatus, @RequestParam Integer pageIndex,
	                                 @RequestParam Integer pageSize, @RequestParam String orgId,
	                                 @RequestParam(required = false) String pubName,
	                                 @RequestParam(required = false) String pubOrgName) {
		return dbPubTableService.getOthersPubList(pubStatus, pageIndex, pageSize, orgId, pubName, pubOrgName);
	}

	/**
	 * 无审批发布调用该接口
	 */
	@ApiOperation(value = "发布库表", notes = "发布库表")
	@ApiImplicitParam(name = "id", value = "发布ID", required = true, dataType = "String")
	@PostMapping("pubTable")
	public ResultVo pubTable(@RequestParam String id) {
		return dbPubTableService.pubTable(id);
	}

	@ApiOperation(value = "批量发布库表", notes = "批量发布库表")
	@ApiImplicitParam(name = "idList", value = "发布ID列表", required = true, dataType = "List<String>")
	@PostMapping("pubTableBatch")
	public ResultVo pubTableBatch(@RequestBody List<String> idList) {
		return dbPubTableService.pubTableBatch(idList);
	}

	@ApiOperation(value = "启动发布", notes = "启动发布")
	@ApiImplicitParam(name = "id", value = "发布ID", required = true, dataType = "String")
	@PostMapping("startPub")
	public ResultVo startPub(@RequestParam String id) {
		return dbPubTableService.startPub(id);
	}

	@ApiOperation(value = "批量启动发布", notes = "批量启动发布")
	@PostMapping("batchStartPub")
	public ResultVo batchStartPub(@RequestBody List<String> idList) {
		return dbPubTableService.batchStartPub(idList);
	}

	@ApiOperation(value = "停止发布", notes = "停止发布")
	@ApiImplicitParam(name = "id", value = "发布ID", required = true, dataType = "String")
	@PostMapping("stopPub")
	public ResultVo stopPub(@RequestParam String id) {
		return dbPubTableService.stopPub(id);
	}

	@ApiOperation(value = "批量停止发布", notes = "批量停止发布")
	@PostMapping("batchStopPub")
	public ResultVo batchStopPub(@RequestBody List<String> idList) {
		return dbPubTableService.batchStopPub(idList);
	}

	@ApiOperation(value = "完成发布打标", notes = "完成发布打标")
	@ApiImplicitParam(name = "id", value = "发布ID", required = true, dataType = "String")
	@PostMapping("donePub")
	public ResultVo donePub(@RequestBody String id) {
		return dbPubTableService.donePub(id);
	}

	@ApiOperation(value = "删除发布", notes = "删除发布")
	@ApiImplicitParam(name = "id", value = "发布的ID", required = true, dataType = "String")
	@PostMapping("deletePub")
	public ResultVo deletePub(@RequestParam String id) {
		return dbPubTableService.deletePub(id);
	}

	@ApiOperation(value = "批量删除发布", notes = "批量删除发布")
	@PostMapping("batchDeletePub")
	public ResultVo batchDeletePub(@RequestBody List<String> idList) {
		return dbPubTableService.batchDeletePub(idList);
	}

	@ApiOperation(value = "更新发布", notes = "更新发布")
	@ApiImplicitParam(name = "dbPubTableDto", value = "表格发布实体", required = true, dataType = "DbPubTableDto")
	@PostMapping("updatePub")
	public ResultVo updatePub(@RequestBody DbPubTableVo dbPubTableVo) {
		return dbPubTableService.updatePub(dbPubTableVo);
	}

	@ApiOperation(value = "清理缓存", notes = "清理缓存")
	@ApiImplicitParam(name = "id", value = "发布ID", required = true, dataType = "String")
	@PostMapping("clearCache")
	public ResultVo clearCache(@RequestParam String id) {
		dbPubTableService.clearCache(id);
		return ResultVo.ok();
	}

	@ApiOperation(value = "上报打标操作记录", notes = "上报打标操作记录")
	@ApiImplicitParam(name = "record", value = "打标操作纪录", required = true, dataType = "DbTransRecord")
	@PostMapping("uploadTransRecord")
	public ResultVo uploadTransRecord(@RequestBody DbTransRecord record) {
		dbTransRecordService.addDbTransRecord(record);
		return ResultVo.ok();
	}

	@ApiOperation(value = "获取发布详细信息", notes = "获取发布详细信息")
	@ApiImplicitParam(name = "id", value = "发布ID", required = true, dataType = "String")
	@GetMapping("detailedInfo")
	public ResultVo detailedInfo(@RequestParam String id) {
		return dbPubTableService.getDetailedInfo(id);
	}

	@GetMapping("getWithdrawOrgList")
	public ResultVo getWithdrawOrgList(@RequestParam String pubId) {
		return dbPubTableService.getWithdrawOrgList(pubId);
	}

	@PostMapping("withdrawPub")
	public ResultVo withdrawPub(@RequestBody WithdrawPubVo vo) {
		return dbPubTableService.withdrawPub(vo);
	}

}
