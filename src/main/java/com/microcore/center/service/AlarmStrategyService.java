package com.microcore.center.service;

import com.microcore.center.vo.PsmAlarmStrategyVo;
import com.microcore.center.vo.ResultVo;

public interface AlarmStrategyService {
	public ResultVo add(PsmAlarmStrategyVo alarmStrategyVo);
	public ResultVo update(PsmAlarmStrategyVo alarmStrategyVo);
	public ResultVo delete(String id);
}
