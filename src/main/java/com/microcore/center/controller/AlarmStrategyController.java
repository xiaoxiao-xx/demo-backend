package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.microcore.center.service.AlarmStrategyService;
import com.microcore.center.vo.PsmAlarmStrategyVo;
import com.microcore.center.vo.ResultVo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("alarmStrategyController")
public class AlarmStrategyController {

	@Autowired
	private AlarmStrategyService alarmStrategyService;

	@ApiOperation(value = "告警策略查询", notes = "告警策略查询")
	@GetMapping("query")
	public ResultVo<PageInfo<PsmAlarmStrategyVo>> query(@RequestParam(name = "alarmType", required = false) String alarmType,
														@RequestParam(name = "strategy", required = false) String strategy, 
														@RequestParam(name = "pageIndex") Integer pageIndex,
														@RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(alarmStrategyService.query(alarmType, strategy, pageIndex, pageSize));
	}

	@ApiOperation(value = "告警策略新增", notes = "告警策略新增")
	@PostMapping("add")
	public ResultVo add(@RequestBody PsmAlarmStrategyVo alarmStrategyVo) {
		return alarmStrategyService.add(alarmStrategyVo);
	}

	@ApiOperation(value = "告警策略修改", notes = "告警策略修改")
	@PostMapping("update")
	public ResultVo update(@RequestBody PsmAlarmStrategyVo alarmStrategyVo) {
		return alarmStrategyService.update(alarmStrategyVo);
	}

	@ApiOperation(value = "告警策略删除", notes = "告警策略删除")
	@PostMapping("delete")
	public ResultVo delete(@RequestBody String id) {
		return alarmStrategyService.delete(id);
	}
}
