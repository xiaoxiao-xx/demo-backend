package com.rainyhon.backend.controller;

import java.util.Date;

import com.rainyhon.common.model.RollCallResult;
import com.rainyhon.common.service.RollCallService;
import com.rainyhon.common.vo.RollCallResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.service.PsmRollCallService;
import com.rainyhon.common.vo.RollCallVo;
import com.rainyhon.common.vo.ResultVo;

import io.swagger.annotations.ApiOperation;

/**
 * 电子点名
 *
 * @author Administrator
 */
@RestController
@RequestMapping("rollCall")
public class RollCallController {

	@Autowired
	private PsmRollCallService psmRollCallService;

	@Autowired
	private RollCallService rollCallService;

	@ApiOperation(value = "电子点名查询", notes = "电子点名查询")
	@GetMapping("query")
	public ResultVo<PageInfo<RollCallVo>> query(@RequestParam(name = "team", required = false) String team,
	                                            @RequestParam(name = "callTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date callTime,
	                                            @RequestParam(name = "pageIndex") Integer pageIndex,
	                                            @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(psmRollCallService.query(team, callTime, pageIndex, pageSize));
	}

	@ApiOperation(value = "电子点名查询", notes = "电子点名查询")
	@GetMapping("getRollCallResultList")
	public ResultVo<PageInfo<RollCallResultVo>> getRollCallResultList(@RequestParam(name = "orgId", required = false) String orgId,
	                                                                  @RequestParam(name = "personId", required = false) String personId,
	                                                                  @RequestParam(name = "pageIndex") Integer pageIndex,
	                                                                  @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(rollCallService.getRollCallResultList(orgId, personId, pageIndex, pageSize));
	}

	@GetMapping("getRollCall")
	public ResultVo<PageInfo<?>> getRollCall(@RequestParam(name = "pageIndex") Integer pageIndex,
	                                         @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(rollCallService.getRollCall(pageIndex, pageSize));
	}

	@GetMapping("getRollCallDetailById")
	public ResultVo<?> getRollCallDetailById(@RequestParam(name = "id") String id) {
		return ResultVo.ok(rollCallService.getRollCallDetailById(id));
	}

	@PostMapping("editRollCallResult")
	public ResultVo<?> editRollCallResult(@RequestBody RollCallResult result) {
		rollCallService.editRollCallResult(result);
		return ResultVo.ok();
	}

}
