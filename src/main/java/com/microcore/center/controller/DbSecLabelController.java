package com.microcore.center.controller;

import com.microcore.center.service.DbSecLabelService;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 安全标签管理
 *
 * @author lmh
 */
@RestController
@RequestMapping("secLabel")
public class DbSecLabelController {

	private final DbSecLabelService dbSecLabelService;

	@Autowired
	public DbSecLabelController(DbSecLabelService dbSecLabelService) {
		this.dbSecLabelService = dbSecLabelService;
	}

	@ApiOperation(value = "分页获取安全标签列表", notes = "分页获取安全标签列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "orgId", value = "机构ID", required = true, dataType = "String"),
			@ApiImplicitParam(name = "pageIndex", value = "页码（从1开始）", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "Integer")
	})
	@PostMapping("getSecLabelList")
	public ResultVo<?> getSecLabelList(@RequestParam String orgId,
	                                   @RequestParam Integer pageIndex,
	                                   @RequestParam Integer pageSize) {
		return dbSecLabelService.getSecLabelList(orgId, pageIndex, pageSize);
	}

	@ApiOperation(value = "获取标签详情", notes = "获取标签详情")
	@ApiImplicitParam(name = "labelId", value = "标签ID", required = true, dataType = "String")
	@GetMapping("getSecLabelDetailedInfo")
	public ResultVo getSecLabelDetailedInfo(@RequestParam String labelId) {
		return dbSecLabelService.getSecLabelDetailedInfo(labelId);
	}

}

