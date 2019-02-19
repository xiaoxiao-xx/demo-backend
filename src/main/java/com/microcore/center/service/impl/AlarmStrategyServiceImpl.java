package com.microcore.center.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.PsmAlarmStrategyMapper;
import com.microcore.center.service.AlarmStrategyService;
import com.microcore.center.vo.PsmAlarmStrategyVo;
import com.microcore.center.vo.ResultVo;

@Service
@Transactional
public class AlarmStrategyServiceImpl implements AlarmStrategyService {
	
	@Autowired
	private PsmAlarmStrategyMapper psmAlarmStrategyMapper;

	@Override
	public ResultVo add(PsmAlarmStrategyVo alarmStrategyVo) {
		return null;
	}

	@Override
	public ResultVo update(PsmAlarmStrategyVo alarmStrategyVo) {
		return null;
	}

	@Override
	public ResultVo delete(String id) {
		return null;
	}

}
