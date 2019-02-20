package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.center.service.AlarmModeService;
import com.microcore.center.vo.ResultVo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("alarmModeController")
public class AlarmModeController {
	@Autowired
	private AlarmModeService alarmModeService;

	@ApiOperation(value = "告警方式列表查询", notes = "告警方式列表查询")
	@GetMapping("getAlarmMode")
	public ResultVo getAlarmMode() {
		return ResultVo.ok(alarmModeService.getAlarmMode());
	}
}
