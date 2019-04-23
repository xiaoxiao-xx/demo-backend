package com.microcore.center.controller;

import com.microcore.center.model.Permission;
import com.microcore.center.service.PermissionService;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@GetMapping("getPermissionList")
	public ResultVo getPermissionList(@RequestParam Integer pageIndex,
	                           @RequestParam Integer pageSize) {
		return ResultVo.ok(permissionService.getPermissionList(pageIndex, pageSize));
	}

	@PostMapping("addPermission")
	public ResultVo addPermission(@RequestBody Permission vo) {
		permissionService.addPermission(vo);
		return ResultVo.ok();
	}

	@PostMapping("deletePermissionById")
	public ResultVo deletePermissionById(@RequestParam String id) {
		permissionService.deletePermissionById(id);
		return ResultVo.ok();
	}

	@PostMapping("batchDelete")
	public ResultVo batchDelete(@RequestBody List<String> idList) {
		permissionService.batchDelete(idList);
		return ResultVo.ok();
	}

	@PostMapping("updatePermission")
	public ResultVo updatePermission(@RequestBody Permission vo) {
		permissionService.updatePermission(vo);
		return ResultVo.ok();
	}

}
