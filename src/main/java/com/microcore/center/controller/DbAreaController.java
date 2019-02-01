package com.microcore.center.controller;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.DbArea;
import com.microcore.center.service.DbAreaService;
import com.microcore.center.vo.DbAreaVo;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dbArea")
public class DbAreaController {

	private final DbAreaService dbAreaService;

	@Autowired
	public DbAreaController(DbAreaService dbAreaService) {
		this.dbAreaService = dbAreaService;
	}

	@GetMapping("areaList")
	public ResultVo<PageInfo<DbAreaVo>> areaList(@RequestParam(name = "areaName") String areaName,
	                                             @RequestParam(name = "pageIndex") Integer pageIndex,
	                                             @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(dbAreaService.areaList(null, areaName, pageIndex, pageSize));
	}

	@GetMapping("list")
	public ResultVo<List<DbArea>> list() {
		return ResultVo.ok(dbAreaService.list());
	}

	@PostMapping("add")
	public ResultVo<String> add(@RequestBody DbAreaVo dbAreaVo) {
		dbAreaService.add(dbAreaVo);
		return ResultVo.ok();
	}

	@PostMapping("update")
	public ResultVo<String> update(@RequestBody DbAreaVo dbAreaVo) {
		dbAreaService.update(dbAreaVo);
		return ResultVo.ok();
	}

	@PostMapping("delete")
	public ResultVo<String> delete(@RequestBody String id) {
		dbAreaService.delete(id);
		return ResultVo.ok();
	}

	@GetMapping("getDbAreaVo")
	public ResultVo getDbAreaVo(@RequestParam(name = "id") String id) {
		PageInfo<DbAreaVo> page = dbAreaService.areaList(id, null, 1, 10);
		if (CommonUtil.isEmpty(page.getList())) {
			return ResultVo.ok();
		}
		return ResultVo.ok(page.getList().get(0));
	}

}

