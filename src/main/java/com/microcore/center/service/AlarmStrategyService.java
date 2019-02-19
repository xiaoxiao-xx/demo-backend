package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.vo.PsmAlarmStrategyVo;
import com.microcore.center.vo.ResultVo;

public interface AlarmStrategyService {
	public PageInfo<PsmAlarmStrategyVo> query(Integer pageIndex, Integer pageSize);
	public ResultVo add(PsmAlarmStrategyVo alarmStrategyVo);

	public ResultVo update(PsmAlarmStrategyVo alarmStrategyVo);

	public ResultVo delete(String id);
}
