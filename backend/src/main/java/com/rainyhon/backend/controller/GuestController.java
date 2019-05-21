package com.rainyhon.backend.controller;

import com.rainyhon.common.service.GuestService;
import com.rainyhon.common.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("guest")
public class GuestController {

	@Autowired
	private GuestService guestService;

	@PostMapping("add")
	public ResultVo add(@RequestBody GuestVo vo) {
		return guestService.addGuest(vo);
	}

	@ApiOperation(value = "获取证件类型", notes = "获取访客的证件类型")
	@GetMapping("getCardTypes")
	public ResultVo<?> getCardType() {
		return guestService.getCardTypes();
	}

	@PostMapping("batchDelete")
	public ResultVo delete(@RequestBody DeleteVo vo) {
		return guestService.batchDelete(vo);
	}

	@PostMapping("update")
	public ResultVo update(@RequestBody GuestVo vo) {
		guestService.update(vo);
		return ResultVo.ok();
	}

	@GetMapping("getGuestList")
	public ResultVo getPersonList(@RequestParam(name = "name", required = false) String name,
	                              @RequestParam(name = "cardType", required = false) String cardType,
	                              @RequestParam(name = "targetAreaId", required = false) String targetAreaId,
	                              @RequestParam(name = "targetOrgId", required = false) String targetOrgId,
	                              @RequestParam(name = "startTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
	                              @RequestParam(name = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,
	                              @RequestParam(name = "pageIndex") Integer pageIndex,
	                              @RequestParam(name = "pageSize") Integer pageSize) {

		return guestService.getGuestList(name, cardType, targetAreaId, targetOrgId, startTime, endTime, pageIndex, pageSize);
	}

}
