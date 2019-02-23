package com.microcore.center.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmRollCallMapper;
import com.microcore.center.model.PsmRollCall;
import com.microcore.center.model.PsmRollCallExample;
import com.microcore.center.service.DepartmentService;
import com.microcore.center.service.ParaDefineService;
import com.microcore.center.service.PersonService;
import com.microcore.center.service.PsmRollCallService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.PsmRollCallVo;

@Service
@Transactional
public class PsmRollCallServiceImpl implements PsmRollCallService {

	@Autowired
	private PsmRollCallMapper psmRollCallMapper;
	@Autowired
	private ParaDefineService paraDefineService;
	@Autowired
	private PersonService personService ;
	@Autowired
	private DepartmentService departmentService ;
	
	@Override
	public PageInfo<PsmRollCallVo> query(String team, Date callTime, Integer pageIndex, Integer pageSize) {

		PsmRollCallExample example = new PsmRollCallExample();
		PsmRollCallExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(team)) {
			criteria.andTeamEqualTo(team);
		}
		if (callTime != null) {
			criteria.andCallTimeEqualTo(callTime);
		}
		
		PageInfo<PsmRollCall> page = PageHelper.startPage(pageIndex, pageSize)
		.doSelectPageInfo(() -> psmRollCallMapper.selectByExample(example)) ;
		
		List<PsmRollCallVo> list = CommonUtil.listPo2VO(page.getList(), PsmRollCallVo.class);
		for (PsmRollCallVo psmRollCallVo : list) {
			psmRollCallVo.setCallResName(paraDefineService.getValueByTypeAnd("CALL_RES", psmRollCallVo.getCallRes()));
			psmRollCallVo.setTeamName(departmentService.getDepartmentName(psmRollCallVo.getTeam()));
			psmRollCallVo.setLeaderName(personService.getPsmPersonInfoName(psmRollCallVo.getLeader()));
		}
		PageInfo<PsmRollCallVo> pageVo = new PageInfo<>(list);
		pageVo.setTotal(page.getTotal());
		return pageVo;
	}

}
