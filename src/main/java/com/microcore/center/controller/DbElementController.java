package com.microcore.center.controller;

import com.microcore.center.service.DbElementService;
import com.microcore.center.vo.DbElementVo;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 元数据模板管理
 */
@RestController
@RequestMapping("dbElement")
public class DbElementController {

	private final DbElementService dbElementService;

	@Autowired
	public DbElementController(DbElementService dbElementService) {
		this.dbElementService = dbElementService;
	}

	@ApiOperation(value = "核心元数据列表查询", notes = "核心元数据列表查询")
	@GetMapping("queryCoreElement")
	public ResultVo<?> queryCoreElement(String name) {
		return dbElementService.queryCoreElement(name);
	}

	@ApiOperation(value = "扩展元数据列表查询", notes = "扩展元数据列表查询")
	@GetMapping("queryDefineElement")
	public ResultVo<?> queryDefineElement(String name) {
		return dbElementService.queryDefineElement(name);
	}

	@ApiOperation(value = "元数据列表查询", notes = "元数据列表查询")
	@GetMapping("queryDbElement")
	public ResultVo<?> queryDbElement(String name, String type,Integer pageIndex, Integer pageSize) {
		return ResultVo.ok(dbElementService.queryDbElementVo(name, type, pageIndex, pageSize));
	}

	@ApiOperation(value = "获取元数据信息", notes = "获取元数据信息")
	@GetMapping("getDbElements")
	public ResultVo getDbElements() {
		return dbElementService.getDbElements();
	}

	@ApiOperation(value = "扩展元数据新增", notes = "扩展元数据新增")
	@PostMapping("addElement")
	public ResultVo<?> addElement(@RequestBody DbElementVo dbElementVo) {
		return dbElementService.addElement(dbElementVo);
	}

	@ApiOperation(value = "扩展元数据修改", notes = "扩展元数据修改")
	@PostMapping("updateElement")
	public ResultVo<?> updateElement(@RequestBody DbElementVo dbElementVo) {
		return dbElementService.updateElement(dbElementVo);
	}

	@ApiOperation(value = "扩展元数据删除", notes = "扩展元数据删除")
	@PostMapping("delElement")
	public ResultVo<?> delElement(String id) {
		return dbElementService.delElement(id);
	}

	@ApiOperation(value = "元数据详情", notes = "元数据详情")
	@GetMapping("element")
	public ResultVo<?> element(String id) {
		return ResultVo.ok(dbElementService.getElement(id));
	}

}

