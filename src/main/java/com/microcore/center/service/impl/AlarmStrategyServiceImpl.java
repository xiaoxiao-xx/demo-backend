package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmAlarmStrategyMapper;
import com.microcore.center.model.PsmAlarmStrategy;
import com.microcore.center.model.PsmAlarmStrategyExample;
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

	@Override
	public PageInfo<PsmAlarmStrategyVo> query(Integer pageIndex, Integer pageSize) {
		PsmAlarmStrategyExample example = new PsmAlarmStrategyExample ();
		PsmAlarmStrategyExample.Criteria criteria = example.createCriteria() ;
		psmAlarmStrategyMapper.selectByExample(example);
		PageInfo<PsmAlarmStrategy> psmAlarmStrategyPage = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> psmAlarmStrategyMapper.selectByExample(example));
		List<PsmAlarmStrategyVo> list = new ArrayList<>();
		for (PsmAlarmStrategy psmAlarmStrategy : psmAlarmStrategyPage.getList()) {
			PsmAlarmStrategyVo vo = new PsmAlarmStrategyVo();
			BeanUtils.copyProperties(psmAlarmStrategy, vo);
			list.add(vo);
		}
		return new PageInfo<>(list);
	}

}
