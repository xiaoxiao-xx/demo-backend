package com.rainyhon.backend.controller;

import com.microcore.center.model.Role;
import com.rainyhon.common.service.RoleService;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("getRoleList")
	public ResultVo getRoleList(@RequestParam Integer pageIndex,
	                           @RequestParam Integer pageSize) {
		return ResultVo.ok(roleService.getRoleList(pageIndex, pageSize));
	}

	@PostMapping("addRole")
	public ResultVo addRole(@RequestBody Role vo) {
		roleService.addRole(vo);
		return ResultVo.ok();
	}

	@PostMapping("deleteRoleById")
	public ResultVo deleteRoleById(@RequestParam String id) {
		roleService.deleteRoleById(id);
		return ResultVo.ok();
	}

	@PostMapping("batchDelete")
	public ResultVo batchDelete(@RequestBody List<String> idList) {
		roleService.batchDelete(idList);
		return ResultVo.ok();
	}

	@PostMapping("updateRole")
	public ResultVo updateRole(@RequestBody Role vo) {
		roleService.updateRole(vo);
		return ResultVo.ok();
	}

}
