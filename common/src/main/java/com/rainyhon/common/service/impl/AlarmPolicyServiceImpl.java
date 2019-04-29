package com.rainyhon.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.rainyhon.common.mapper.AlarmPolicyMapper;
import com.rainyhon.common.model.AlarmPolicy;
import com.rainyhon.common.model.AlarmPolicyExample;
import com.rainyhon.common.service.AlarmPolicyService;
import com.rainyhon.common.vo.AlarmPolicyOpt;
import com.rainyhon.common.vo.AlarmPolicyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.service.AlarmModeService;
import com.rainyhon.common.service.ParaDefineService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.StringUtil;
import com.rainyhon.common.vo.ResultVo;

@Service
@Transactional
public class AlarmPolicyServiceImpl implements AlarmPolicyService {

	@Autowired
	private AlarmPolicyMapper psmAlarmPolicyMapper;

	@Autowired
	private ParaDefineService paraDefineService;

	@Autowired
	private AlarmModeService alarmModeService;

	@Override
	public ResultVo add(AlarmPolicyVo alarmPolicyVo) {
		AlarmPolicy p = CommonUtil.po2VO(alarmPolicyVo, AlarmPolicy.class);
		p.setId(CommonUtil.getUUID());
		psmAlarmPolicyMapper.insert(p);
		return ResultVo.ok();
	}

	@Override
	public ResultVo update(AlarmPolicyVo alarmPolicyVo) {
		AlarmPolicy p = CommonUtil.po2VO(alarmPolicyVo, AlarmPolicy.class);
		psmAlarmPolicyMapper.updateByPrimaryKey(p);
		return ResultVo.ok();
	}

	@Override
	public ResultVo delete(String id) {
		String[] ids = id.split(",");
		for (String i : ids) {
			psmAlarmPolicyMapper.deleteByPrimaryKey(i);
		}
		return ResultVo.ok();
	}

	@Override
	public PageInfo<AlarmPolicyVo> query(String alarmType, String strategy, Integer pageIndex, Integer pageSize) {
		AlarmPolicyExample example = new AlarmPolicyExample();
		AlarmPolicyExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(alarmType)) {
			criteria.andAlarmTypeEqualTo(alarmType);
		}
		if (StringUtil.isNotEmpty(strategy)) {
			criteria.andPolicyNameLike("%" + strategy.trim() + "%");
		}
		PageInfo<AlarmPolicy> psmAlarmPolicyPage = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> psmAlarmPolicyMapper.selectByExample(example));
		List<AlarmPolicyVo> list = new ArrayList<>();
		for (AlarmPolicy psmAlarmPolicy : psmAlarmPolicyPage.getList()) {
			AlarmPolicyVo vo = new AlarmPolicyVo();
			BeanUtils.copyProperties(psmAlarmPolicy, vo);
			vo.setAlarmTypeName(paraDefineService.getValueByTypeAnd("ALARM_MODE", psmAlarmPolicy.getAlarmType()));
			vo.setAlarmModeName(alarmModeService.getAlarmMode(psmAlarmPolicy.getAlarmModeId()));
			list.add(vo);
		}
		PageInfo<AlarmPolicyVo> pageInfo = new PageInfo<>();
		pageInfo.setList(list);
		pageInfo.setTotal(psmAlarmPolicyPage.getTotal());
		return pageInfo;
	}

	@Override
	public ResultVo startStop(AlarmPolicyOpt alarmPolicyOpt) {
		AlarmPolicy p = psmAlarmPolicyMapper.selectByPrimaryKey(alarmPolicyOpt.getId());
		p.setState(alarmPolicyOpt.getOpt());
		psmAlarmPolicyMapper.updateByPrimaryKey(p);
		return ResultVo.ok();
	}

}
