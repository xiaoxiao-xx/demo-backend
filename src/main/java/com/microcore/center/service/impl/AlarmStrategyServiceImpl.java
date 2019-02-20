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
import com.microcore.center.service.AlarmModeService;
import com.microcore.center.service.AlarmStrategyService;
import com.microcore.center.service.ParaDefineService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.PsmAlarmStrategyVo;
import com.microcore.center.vo.ResultVo;

@Service
@Transactional
public class AlarmStrategyServiceImpl implements AlarmStrategyService {

	@Autowired
	private PsmAlarmStrategyMapper psmAlarmStrategyMapper;
	@Autowired
	private ParaDefineService paraDefineService;
	@Autowired
	private AlarmModeService alarmModeService ;
	@Override
	public ResultVo add(PsmAlarmStrategyVo alarmStrategyVo) {
		PsmAlarmStrategy p = CommonUtil.po2VO(alarmStrategyVo, PsmAlarmStrategy.class);
		p.setId(CommonUtil.getUUID());
		psmAlarmStrategyMapper.insert(p);
		return ResultVo.ok();
	}

	@Override
	public ResultVo update(PsmAlarmStrategyVo alarmStrategyVo) {
		PsmAlarmStrategy p = CommonUtil.po2VO(alarmStrategyVo, PsmAlarmStrategy.class);
		psmAlarmStrategyMapper.updateByPrimaryKey(p);
		return ResultVo.ok();
	}

	@Override
	public ResultVo delete(String id) {
		String[] ids = id.split(",");
		for (String i : ids) {
			psmAlarmStrategyMapper.deleteByPrimaryKey(i);
		}
		return ResultVo.ok();
	}

	@Override
	public PageInfo<PsmAlarmStrategyVo> query(String alarmType, String strategy, Integer pageIndex, Integer pageSize) {
		PsmAlarmStrategyExample example = new PsmAlarmStrategyExample();
		PsmAlarmStrategyExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(alarmType)) {
			criteria.andAlarmTypeEqualTo(alarmType);
		}
		if (StringUtil.isNotEmpty(strategy)) {
			criteria.andStrategyLike("%" + strategy.trim() + "%");
		}
		PageInfo<PsmAlarmStrategy> psmAlarmStrategyPage = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> psmAlarmStrategyMapper.selectByExample(example));
		List<PsmAlarmStrategyVo> list = new ArrayList<>();
		for (PsmAlarmStrategy psmAlarmStrategy : psmAlarmStrategyPage.getList()) {
			PsmAlarmStrategyVo vo = new PsmAlarmStrategyVo();
			BeanUtils.copyProperties(psmAlarmStrategy, vo);
			vo.setAlarmTypeName(paraDefineService.getValueByTypeAnd("ALARM_MODE", psmAlarmStrategy.getAlarmType()));
			vo.setAlarmModeName(alarmModeService.getAlarmMode(psmAlarmStrategy.getAlarmMode()));
			list.add(vo);
		}
		PageInfo<PsmAlarmStrategyVo> pageInfo = new PageInfo<>();
		pageInfo.setList(list);
		pageInfo.setTotal(psmAlarmStrategyPage.getTotal());
		return pageInfo;
	}

}
