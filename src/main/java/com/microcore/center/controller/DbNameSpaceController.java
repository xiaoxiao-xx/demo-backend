package com.microcore.center.controller;

import com.microcore.center.model.DbNameSpace;
import com.microcore.center.service.DbNameSpaceService;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dbNameSpace")
public class DbNameSpaceController {

	private final DbNameSpaceService dbNameSpaceService;

	@Autowired
	public DbNameSpaceController(DbNameSpaceService dbNameSpaceService) {
		this.dbNameSpaceService = dbNameSpaceService;
	}

	@ApiOperation(value = "领域列表查询", notes = "领域列表查询")
	@GetMapping("queryNameSpacePage")
	public ResultVo<?> queryNameSpace(String cname, Integer pageIndex, Integer pageSize) {
		return ResultVo.ok(dbNameSpaceService.queryNameSpace(cname, pageIndex, pageSize));
	}

	@ApiOperation(value = "领域列表查询", notes = "领域列表查询不分页")
	@GetMapping("queryNameSpace")
	public ResultVo<?> queryNameSpace() {
		return ResultVo.ok(dbNameSpaceService.queryNameSpace());
	}

	@ApiOperation(value = "领域新增", notes = "领域新增")
	@PostMapping("add")
	public ResultVo<?> add(@RequestBody DbNameSpace dbNameSpace) {
		dbNameSpaceService.add(dbNameSpace);
		return ResultVo.ok();
	}

	@ApiOperation(value = "领域修改", notes = "领域修改")
	@PostMapping("update")
	public ResultVo<?> update(@RequestBody DbNameSpace dbNameSpace) {
		dbNameSpaceService.update(dbNameSpace);
		return ResultVo.ok();
	}

	@ApiOperation(value = "领域删除", notes = "领域删除")
	@PostMapping("delete")
	public ResultVo<?> delete(@RequestBody String id) {
		dbNameSpaceService.delete(id);
		return ResultVo.ok();
	}

	@ApiOperation(value = "根据ID获取领域", notes = "根据ID获取领域")
	@GetMapping("getById")
	public ResultVo<?> getById(@RequestParam(name = "id") String id) {
		return ResultVo.ok(dbNameSpaceService.get(id));
	}

}
