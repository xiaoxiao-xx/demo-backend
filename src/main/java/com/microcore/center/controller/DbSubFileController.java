package com.microcore.center.controller;

import com.github.pagehelper.Constant;
import com.microcore.center.dto.DbSubFileDto;
import com.microcore.center.model.DbPubFile;
import com.microcore.center.service.DbPubFileService;
import com.microcore.center.service.DbSubFileService;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 */
@RestController
@RequestMapping("subfile")
public class DbSubFileController {

	private final DbSubFileService dbSubFileService;

	@Autowired
	private DbPubFileService dbPubFileService;

	@Autowired
	public DbSubFileController(DbSubFileService dbSubFileService) {
		this.dbSubFileService = dbSubFileService;
	}

	@ApiOperation(value = "新增文件订阅任务", notes = "新增文件订阅任务")
	@ApiImplicitParam(name = "filesDto", value = "文件订阅实体", required = true, dataType = "DbSubFileDto")
	@PostMapping("addDbSubFile")
	public ResultVo addDbSubFile(@RequestBody DbSubFileDto filesDto) {
		DbPubFile pubFile = dbPubFileService.dbPubFile(filesDto.getPubId());
		String autoApp = pubFile.getAutoApp();
		if (autoApp == null || Constants.TRUE.equals(autoApp)) {
			return dbSubFileService.addDbSubFile(filesDto);
		} else {
			return dbSubFileService.addDbSubFileWithApproval(filesDto);
		}
	}

	@ApiOperation(value = "修改文件订阅任务", notes = "修改文件订阅任务")
	@ApiImplicitParam(name = "filesDto", value = "文件订阅实体", required = true, dataType = "DbSubFileDto")
	@PostMapping("updDbSubFile")
	public ResultVo updDbSubFile(@RequestBody DbSubFileDto filesDto) {
		return dbSubFileService.updDbSubFile(filesDto);
	}

	@ApiOperation(value = "删除文件订阅任务", notes = "根据ID删除文件订阅任务")
	@ApiImplicitParam(name = "sid", value = "文件订阅ID", required = true, dataType = "String")
	@PostMapping("delDbSubFile")
	public ResultVo delDbSubFile(@RequestBody String sid) {
		return dbSubFileService.delDbSubFile(sid);
	}

	@ApiOperation(value = "启动订阅", notes = "根据ID启动订阅")
	@ApiImplicitParam(name = "sid", value = "文件订阅ID", required = true, dataType = "String")
	@PostMapping("startSubFile")
	public ResultVo startSubFile(@RequestBody String sid) {
		return dbSubFileService.startSubFile(sid);
	}

	@ApiOperation(value = "获取单个文件订阅", notes = "根据ID获取单个文件订阅")
	@ApiImplicitParam(name = "sid", value = "文件发布ID", required = true, dataType = "String")
	@GetMapping("getDbSubFile")
	public ResultVo getDbSubFile(@RequestParam String sid) {
		return dbSubFileService.getDbSubFile(sid);
	}

	@ApiOperation(value = "发布订阅", notes = "发布订阅")
	@ApiImplicitParam(name = "sid", value = "文件订阅ID", required = true, dataType = "String")
	@PostMapping("pubDbSubFile")
	public ResultVo pubDbSubFile(@RequestBody String sid) {
		return dbSubFileService.pubDbSubFile(sid);
	}

	@ApiOperation(value = "获取已订阅列表", notes = "获取已订阅列表")
	@GetMapping("getDbSubFileListA")
	public ResultVo getDbSubFileListA(String orgName, String subName, String pubUser, Integer pageIndex, Integer pageSize) {
		return dbSubFileService.getDbSubFileListA(orgName, subName, pubUser, pageIndex, pageSize);
	}

	@ApiOperation(value = "获取可订阅列表", notes = "获取可订阅列表")
	@GetMapping("getDbSubFileListC")
	public ResultVo getDbSubFileListC(String orgId, String orgName, String pubName, String pubUserName, Integer pageIndex, Integer pageSize) {
		return dbSubFileService.getDbSubFileListC(orgId, orgName, pubName, pubUserName, pageIndex, pageSize);
	}

	@ApiOperation(value = "批量删除文件订阅任务", notes = "批量删除文件订阅任务")
	@ApiImplicitParam(name = "ids", value = "文件订阅ID数组", required = true, dataType = "map")
	@PostMapping("delSubFileOfBatch")
	public ResultVo delSubFileOfBatch(@RequestBody Map<String, String[]> param) {
		String[] ids = param.get("ids");
		if (null==ids) {
			return ResultVo.fail("参数错误");
		}
		return dbSubFileService.delSubFileOfBatch(ids);
	}
	
	@ApiOperation(value = "批量启动文件订阅任务", notes = "批量启动文件订阅任务")
	@ApiImplicitParam(name = "ids", value = "文件订阅ID数组", required = true, dataType = "map")
	@PostMapping("startSubFileOfBatch")
	public ResultVo startSubFileOfBatch(@RequestBody Map<String, String[]> param) {
		String[] ids = param.get("ids");
		if (null==ids) {
			return ResultVo.fail("参数错误");
		}
		return dbSubFileService.startSubFileOfBatch(ids);
	}
	
	@ApiOperation(value = "批量停止文件订阅任务", notes = "批量停止文件订阅任务")
	@ApiImplicitParam(name = "ids", value = "文件订阅ID数组", required = true, dataType = "map")
	@PostMapping("stopSubFileOfBatch")
	public ResultVo stopSubFileOfBatch(@RequestBody Map<String, String[]> param) {
		String[] ids = param.get("ids");
		if (null==ids) {
			return ResultVo.fail("参数错误");
		}
		return dbSubFileService.stopSubFileOfBatch(ids);
	}
	
	@ApiOperation(value = "批量发布文件订阅任务", notes = "批量发布文件订阅任务")
	@ApiImplicitParam(name = "ids", value = "文件订阅ID数组", required = true, dataType = "map")
	@PostMapping("subFileOfBatch")
	public ResultVo subFileOfBatch(@RequestBody Map<String, String[]> param) {
		String[] ids = param.get("ids");
		if (null==ids) {
			return ResultVo.fail("参数错误");
		}
		return dbSubFileService.subFileOfBatch(ids);
	}
	
	
	
	
}
