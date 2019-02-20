package com.microcore.center.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.microcore.center.service.PsmRollCallService;
import com.microcore.center.vo.PsmRollCallVo;
import com.microcore.center.vo.ResultVo;

import io.swagger.annotations.ApiOperation;

/**
 * 电子点名
 * @author Administrator
 *
 */
@RestController
@RequestMapping("rollCall")
public class RollCallController {
	@Autowired
	private PsmRollCallService psmRollCallService ;
	
	@ApiOperation(value = "电子点名查询", notes = "电子点名查询")
	@GetMapping("query")
	public ResultVo<PageInfo<PsmRollCallVo>> query(@RequestParam(name = "team", required = false) String team, 
												 @RequestParam(name = "callTime", required = false) Date callTime, 
												 @RequestParam(name = "pageIndex") Integer pageIndex,
												 @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(psmRollCallService.query(team, callTime, pageIndex, pageSize));
	}
}
