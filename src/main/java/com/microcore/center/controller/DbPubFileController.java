package com.microcore.center.controller;

import com.microcore.center.dto.DbPubFileDto;
import com.microcore.center.model.DbApproval;
import com.microcore.center.service.DbPubFileService;
import com.microcore.common.util.ResultVo;
import com.microcore.common.vo.WithdrawPubVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文件发布
 */
@RestController
@RequestMapping("pubfile")
public class DbPubFileController {

	private final DbPubFileService dbPubFileService;

	@Autowired
	public DbPubFileController(DbPubFileService dbPubFileService) {
		this.dbPubFileService = dbPubFileService;
	}

	@ApiOperation(value = "新增文件发布任务", notes = "新增文件发布任务")
	@ApiImplicitParam(name = "filesDto", value = "文件发布实体", required = true, dataType = "DbPubFileDto")
	@PostMapping("addDbPubFile")
	public ResultVo addDbPubFile(@RequestBody DbPubFileDto filesDto) {
		return dbPubFileService.addDbPubFile(filesDto);
	}

	@ApiOperation(value = "修改文件发布任务", notes = "修改文件发布任务")
	@ApiImplicitParam(name = "filesDto", value = "文件发布实体", required = true, dataType = "DbPubFileDto")
	@PostMapping("updDbPubFile")
	public ResultVo updDbPubFile(@RequestBody DbPubFileDto filesDto) {
		return dbPubFileService.updDbPubFile(filesDto);
	}

	@ApiOperation(value = "删除文件发布任务", notes = "根据ID删除文件发布任务")
	@ApiImplicitParam(name = "fid", value = "文件发布ID", required = true, dataType = "String")
	@PostMapping("delDbPubFile")
	public ResultVo delDbPubFile(@RequestBody String fid) {
		return dbPubFileService.delDbPubFile(fid);
	}
	
	@ApiOperation(value = "批量删除文件发布任务", notes = "批量删除文件发布任务")
	@ApiImplicitParam(name = "ids", value = "文件发布ID数组", required = true, dataType = "map")
	@PostMapping("delDbPubFileOfBatch")
	public ResultVo delDbPubFileOfBatch(@RequestBody Map<String, String[]> param) {
		String[] ids = param.get("ids");
		if (null==ids) {
			return ResultVo.fail("参数错误");
		}
		return dbPubFileService.delDbPubFileOfBatch(ids);
	}

	@ApiOperation(value = "启动或停止发布任务", notes = "根据ID启动或停止发布任务")
	@ApiImplicitParam(name = "fid", value = "文件发布ID", required = true, dataType = "String")
	@PostMapping("startDbPubFile")
	public ResultVo startDbPubFile(@RequestBody String fid) {
		return dbPubFileService.startDbPubFile(fid);
	}
	@ApiOperation(value = "批量启动发布任务", notes = "根据ID批量启动发布任务")
	@ApiImplicitParam(name = "ids", value = "文件发布ID数组", required = true, dataType = "map")
	@PostMapping("startDbPubFileOfBatch")
	public ResultVo startDbPubFileOfBatch(@RequestBody Map<String, String[]> param) {
		String[] ids = param.get("ids");
		if (null==ids) {
			return ResultVo.fail("参数错误");
		}
		return dbPubFileService.startDbPubFileOfBatch(ids);
	}
	@ApiOperation(value = "批量停止发布任务", notes = "根据ID批量停止发布任务")
	@ApiImplicitParam(name = "ids", value = "文件发布ID数组", required = true, dataType = "map")
	@PostMapping("stopDbPubFileOfBatch")
	public ResultVo stopDbPubFileOfBatch(@RequestBody Map<String, String[]> param) {
		String[] ids = param.get("ids");
		if (null==ids) {
			return ResultVo.fail("参数错误");
		}
		return dbPubFileService.stopDbPubFileOfBatch(ids);
	}

	@ApiOperation(value = "发布任务", notes = "根据ID发布任务")
	@ApiImplicitParam(name = "taskId", value = "文件发布ID", required = true, dataType = "String")
	@PostMapping("pubDbPubFile")
	public ResultVo pubDbPubFile(@RequestBody DbApproval approval) {
		return dbPubFileService.pubFile(approval.getTaskId());
	}
	
	@ApiOperation(value = "批量发布任务", notes = "批量发布任务")
	@ApiImplicitParam(name = "ids", value = "文件发布ID数组", required = true, dataType = "map")
	@PostMapping("pubDbPubFileOfBatch")
	public ResultVo pubDbPubFileOfBatch(@RequestBody Map<String, String[]> param) {
		String[] ids = param.get("ids");
		if (null==ids) {
			return ResultVo.fail("参数错误");
		}
		return dbPubFileService.pubFileOfBatch(ids);
	}

	@ApiOperation(value = "清除缓存", notes = "根据ID清除缓存")
	@ApiImplicitParam(name = "fid", value = "文件发布ID", required = true, dataType = "String")
	@PostMapping("cleanFileCache")
	public ResultVo cleanFileCache(@RequestBody String fid) {
		return dbPubFileService.cleanFileCache(fid);
	}

	@ApiOperation(value = "获取单个文件发布", notes = "根据ID获取单个文件发布")
	@ApiImplicitParam(name = "fid", value = "文件发布ID", required = true, dataType = "String")
	@GetMapping("getDbPubFile")
	public ResultVo getDbPubFile(@RequestParam String fid) {
		return dbPubFileService.getDbPubFile(fid);
	}

	@ApiOperation(value = "获取文件已发布发布列表", notes = "获取文件已发布发布列表")
	@GetMapping("getDbPubFilelistT")
	public ResultVo getDbPubFilelistT(String orgId, String autoChange, String pubName, String pubPath,
	                                  Integer pageIndex, Integer pageSize) {
		return dbPubFileService.getDbPubFilelistT(orgId, autoChange, pubName, pubPath, pageIndex, pageSize);
	}

	@ApiOperation(value = "获取文件未发布列表", notes = "获取文件未发布列表")
	@GetMapping("getDbPubFilelistO")
	public ResultVo getDbPubFilelistO(String autoChange, String pubName, String pubPath,
	                                  Integer pageIndex, Integer pageSize) {
		return dbPubFileService.getDbPubFilelistO(autoChange, pubName, pubPath, pageIndex, pageSize);
	}

	@GetMapping("getWithdrawOrgList")
	public ResultVo getWithdrawOrgList(@RequestParam String pubId) {
		return dbPubFileService.getWithdrawOrgList(pubId);
	}

	@PostMapping("withdrawPub")
	public ResultVo withdrawPub(@RequestBody WithdrawPubVo vo) {
		return dbPubFileService.withdrawPub(vo);
	}

	@ApiOperation(value = "查看单个文件发布详情", notes = "根据ID获取单个文件发布")
	@ApiImplicitParam(name = "fid", value = "文件发布ID", required = true, dataType = "String")
	@GetMapping("getDbPubFileDetails")
	public ResultVo getDbPubFileDetails(String fid) {
		return dbPubFileService.getDbPubFileDetails(fid);
	}
}
