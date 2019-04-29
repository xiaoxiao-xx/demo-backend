package com.rainyhon.backend.controller;

import java.util.Date;

import com.rainyhon.common.service.RollCallService;
import com.rainyhon.common.vo.RollCallResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.service.PsmRollCallService;
import com.rainyhon.common.vo.PsmRollCallVo;
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
	public ResultVo<PageInfo<PsmRollCallVo>> query(@RequestParam(name = "team", required = false) String team,
	                                               @RequestParam(name = "callTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date callTime,
	                                               @RequestParam(name = "pageIndex") Integer pageIndex,
	                                               @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(psmRollCallService.query(team, callTime, pageIndex, pageSize));
	}

	@ApiOperation(value = "电子点名查询", notes = "电子点名查询")
	@GetMapping("getRollCallResultList")
	public ResultVo<PageInfo<RollCallResultVo>> getRollCallResultList(@RequestParam(name = "team", required = false) String orgId,
	                                                                  @RequestParam(name = "team", required = false) String personId,
	                                                                  @RequestParam(name = "pageIndex") Integer pageIndex,
	                                                                  @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(rollCallService.getRollCallResultList(orgId, personId, pageIndex, pageSize));
	}

}