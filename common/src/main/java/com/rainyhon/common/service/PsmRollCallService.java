package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.mapper.RollCallMapper;
import com.rainyhon.common.model.RollCall;
import com.rainyhon.common.model.RollCallExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.StringUtil;
import com.rainyhon.common.vo.RollCallVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PsmRollCallService {

	@Autowired
	private RollCallMapper rollCallMapper;

	@Autowired
	private ParaDefineService paraDefineService;

	@Autowired
	private PersonService personService;

	@Autowired
	private DepartmentService departmentService;

	public PageInfo<RollCallVo> query(String team, Date callTime, Integer pageIndex, Integer pageSize) {
		RollCallExample example = new RollCallExample();
		RollCallExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(team)) {
			criteria.andTeamEqualTo(team);
		}
		if (callTime != null) {
			criteria.andCallTimeEqualTo(callTime);
		}

		PageInfo<RollCall> page = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> rollCallMapper.selectByExample(example));

		List<RollCallVo> list = CommonUtil.listPo2VO(page.getList(), RollCallVo.class);
		for (RollCallVo rollCallVo : list) {
			rollCallVo.setCallResName(paraDefineService.getValueByTypeAnd("CALL_RES", rollCallVo.getCallRes()));
			rollCallVo.setTeamName(departmentService.getDepartmentName(rollCallVo.getTeam()));
			rollCallVo.setLeaderName(personService.getPersonInfoName(rollCallVo.getLeader()));
		}
		PageInfo<RollCallVo> pageVo = new PageInfo<>(list);
		pageVo.setTotal(page.getTotal());
		return pageVo;
	}

}

