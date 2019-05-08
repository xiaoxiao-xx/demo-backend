package com.rainyhon.backend.controller;

import com.rainyhon.common.model.Guest;
import com.rainyhon.common.service.GuestService;
import com.rainyhon.common.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("guest")
public class GuestController {

	// 添加 guest 及 guest area
	// del
	// update getGuestPage getGuestDetaail

	@Autowired
	private GuestService guestService;

	@PostMapping("add")
	public ResultVo add(@RequestBody Guest guest) {
		return guestService.addGuest(guest);
	}

//	@PostMapping("update")
//	public ResultVo update(@RequestBody PersonInfoVo personInfoVo) {
//		return guestService.update(personInfoVo);
//	}
//
	@PostMapping("delete")
	public ResultVo delete(@RequestBody String id) {
		return guestService.delete(id);
	}
//
//	@GetMapping("getPersonList")
//	public ResultVo getPersonList(@RequestParam(name = "name", required = false) String name,
//	                              @RequestParam(name = "deptId", required = false) String deptId,
//	                              @RequestParam(name = "pageIndex") Integer pageIndex,
//	                              @RequestParam(name = "pageSize") Integer pageSize) {
//		return guestService.getPersonList(name, deptId, pageIndex, pageSize);
//	}
//
//	@GetMapping("getPersonListByOrgId")
//	public ResultVo getPersonListByOrgId(@RequestParam(name = "orgId", required = false) String orgId) {
//		return guestService.getPersonListByOrgId(orgId);
//	}
//
//	@GetMapping("list")
//	public ResultVo list() {
//		return guestService.list();
//	}
//
//	@PostMapping("importantCare")
//	public ResultVo importantCare(@RequestBody PersonInfoVo personInfoVo) {
//		return guestService.importantCare(personInfoVo);
//	}
//
//	@PostMapping("imageAcquisition")
//	public ResultVo imageAcquisition(@RequestBody PersonInfoVo personInfoVo) {
//		return guestService.imageAcquisition(personInfoVo);
//	}
//
//	@ApiOperation(value = "首页人员搜索", notes = "首页人员搜索")
//	@PostMapping("getPersonInfoByName")
//	public ResultVo getPersonInfoByName(@RequestBody SearchVo vo) {
//		return guestService.getPersonInfoByName(vo);
//	}
//
//	@GetMapping("getPersonInfoById")
//	public ResultVo<?> getPersonInfoById(@RequestParam String id) {
//		return guestService.getPersonInfoById(id);
//	}
//
}
