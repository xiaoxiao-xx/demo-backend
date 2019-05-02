package com.rainyhon.backend.controller;

import com.microcore.center.model.Permission;
import com.rainyhon.common.service.PermissionService;
import com.rainyhon.common.vo.PermissionVo;
import com.rainyhon.common.vo.ResultVo;
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

	@GetMapping("getAllPermissions")
	public ResultVo getAllPermissions() {
		return ResultVo.ok(permissionService.getAllPermissions());
	}

	@PostMapping("addPermission")
	public ResultVo addPermission(@RequestBody PermissionVo vo) {
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
