package com.rainyhon.backend.controller;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.service.impl.AlarmPolicyService;
import com.rainyhon.common.vo.AlarmPolicyOpt;
import com.rainyhon.common.vo.AlarmPolicyVo;
import com.rainyhon.common.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alarmStrategyController")
public class AlarmPolicyController {

	@Autowired
	private AlarmPolicyService alarmPolicyService;

	@ApiOperation(value = "告警策略查询", notes = "告警策略查询")
	@GetMapping("query")
	public ResultVo<PageInfo<AlarmPolicyVo>> query(@RequestParam(name = "alarmType", required = false) String alarmType,
														@RequestParam(name = "strategy", required = false) String strategy, 
														@RequestParam(name = "pageIndex") Integer pageIndex,
														@RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(alarmPolicyService.query(alarmType, strategy, pageIndex, pageSize));
	}

	@ApiOperation(value = "告警策略新增", notes = "告警策略新增")
	@PostMapping("add")
	public ResultVo add(@RequestBody AlarmPolicyVo alarmPolicyVo) {
		return alarmPolicyService.add(alarmPolicyVo);
	}

	@ApiOperation(value = "告警策略修改", notes = "告警策略修改")
	@PostMapping("update")
	public ResultVo update(@RequestBody AlarmPolicyVo alarmPolicyVo) {
		return alarmPolicyService.update(alarmPolicyVo);
	}

	@ApiOperation(value = "告警策略删除", notes = "告警策略删除")
	@PostMapping("delete")
	public ResultVo delete(@RequestBody String id) {
		return alarmPolicyService.delete(id);
	}
	
	@ApiOperation(value = "告警策略启动/停止", notes = "告警策略启动/停止")
	@PostMapping("startStop")
	public ResultVo startStop(@RequestBody AlarmPolicyOpt alarmPolicyOpt) {
		return alarmPolicyService.startStop(alarmPolicyOpt);
	}

	@GetMapping("getAllEnableAlarmPolicy")
	@ApiOperation(value = "获取全部已启用告警策略", notes = "获取全部已启用告警策略")
	public ResultVo getAllEnableAlarmPolicy(){
		return alarmPolicyService.getAllEnableAlarmPolicy();
	}

}
