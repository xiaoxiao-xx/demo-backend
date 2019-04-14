package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.vo.AlarmStrategyOpt;
import com.microcore.center.vo.PsmAlarmStrategyVo;
import com.microcore.center.vo.ResultVo;

public interface AlarmStrategyService {

	PageInfo<PsmAlarmStrategyVo> query(String alarmType, String strategy,
									   Integer pageIndex, Integer pageSize);

	ResultVo add(PsmAlarmStrategyVo alarmStrategyVo);

	ResultVo update(PsmAlarmStrategyVo alarmStrategyVo);

	ResultVo delete(String id);
	
	ResultVo startStop(AlarmStrategyOpt alarmStrategyOpt);

}
