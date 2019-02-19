package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.center.service.AlarmStrategyService;
import com.microcore.center.vo.PsmAlarmStrategyVo;
import com.microcore.center.vo.ResultVo;

@RestController
@RequestMapping("alarmStrategyController")
public class AlarmStrategyController {
	
	@Autowired
	private AlarmStrategyService alarmStrategyService ;
	
	@PostMapping("add")
	public ResultVo add(@RequestBody PsmAlarmStrategyVo alarmStrategyVo) {
		return alarmStrategyService.add(alarmStrategyVo);
	}
	
	
	@PostMapping("update")
	public ResultVo update(@RequestBody PsmAlarmStrategyVo alarmStrategyVo) {
		return alarmStrategyService.update(alarmStrategyVo);
	}
	
	
	@PostMapping("delete")
	public ResultVo delete(@RequestBody String id) {
		return alarmStrategyService.delete(id);
	}
}
