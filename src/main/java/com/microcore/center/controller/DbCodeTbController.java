package com.microcore.center.controller;

import com.microcore.center.model.DbCodeTb;
import com.microcore.center.service.DbCodeTbService;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dbCodeTb")
public class DbCodeTbController {

	private final DbCodeTbService codeTbService;

	@Autowired
	public DbCodeTbController(DbCodeTbService codeTbService) {
		this.codeTbService = codeTbService;
	}

	@ApiOperation(value = "代码表列表查询", notes = "代码表列表查询")
	@GetMapping("queryByPid")
	public ResultVo<?> queryByPid(String pid, String name, Integer pageIndex, Integer pageSize) {
		return ResultVo.ok(codeTbService.queryPid(pid, name, pageIndex, pageSize));
	}

	@ApiOperation(value = "根据领域ID代码表列表查询", notes = "根据领域ID代码表列表查询")
	@GetMapping("queryNspaceId")
	public ResultVo<?> queryNspaceId(String nspaceId) {
		return ResultVo.ok(codeTbService.queryByNspaceId(nspaceId));
	}

	@ApiOperation(value = "代码表新增", notes = "代码表新增")
	@PostMapping("add")
	public ResultVo<?> add(@RequestBody DbCodeTb dbCodeTb) {
		codeTbService.add(dbCodeTb);
		return ResultVo.ok();
	}

	@ApiOperation(value = "代码表修改", notes = "代码表修改")
	@PostMapping("update")
	public ResultVo<?> update(@RequestBody DbCodeTb dbCodeTb) {
		codeTbService.update(dbCodeTb);
		return ResultVo.ok();
	}

	@ApiOperation(value = "代码表删除", notes = "代码表删除")
	@PostMapping("delete")
	public ResultVo<?> delete(@RequestBody String id) {
		codeTbService.delete(id);
		return ResultVo.ok();
	}

	@ApiOperation(value = "根据ID获取代码信息", notes = "根据ID获取代码信息")
	@GetMapping("getById")
	public ResultVo<?> getById(String id) {
		return ResultVo.ok(codeTbService.get(id));
	}

}
