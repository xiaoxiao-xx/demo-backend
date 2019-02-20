package com.microcore.center.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmRollCallMapper;
import com.microcore.center.model.PsmRollCall;
import com.microcore.center.model.PsmRollCallExample;
import com.microcore.center.service.PsmRollCallService;
import com.microcore.center.util.StringUtil;

@Service
@Transactional
public class PsmRollCallServiceImpl implements PsmRollCallService {

	@Autowired
	private PsmRollCallMapper psmRollCallMapper;

	@Override
	public PageInfo<PsmRollCall> query(String team, Date callTime, Integer pageIndex, Integer pageSize) {

		PsmRollCallExample example = new PsmRollCallExample();
		PsmRollCallExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(team)) {
			criteria.andTeamEqualTo(team);
		}
		if (callTime != null) {
			criteria.andCallTimeEqualTo(callTime);
		}
		return PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> psmRollCallMapper.selectByExample(example));
	}

}
