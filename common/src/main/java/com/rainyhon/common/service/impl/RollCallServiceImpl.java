package com.rainyhon.common.service.impl;

import com.rainyhon.common.mapper.RollCallResultMapper;
import com.rainyhon.common.model.RollCallResult;
import com.rainyhon.common.model.RollCallResultExample;
import com.rainyhon.common.service.RollCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RollCallServiceImpl implements RollCallService {

	@Autowired
	private RollCallResultMapper rollCallResultMapper;

	@Override
	public List<RollCallResult> getRollCallResultList(String detailId, String personId) {
		RollCallResultExample example = new RollCallResultExample();
		RollCallResultExample.Criteria criteria = example.createCriteria();
		criteria.andDetailIdEqualTo(detailId);
		criteria.andPersonIdEqualTo(personId);
		return rollCallResultMapper.selectByExample(example);
	}

	@Override
	public void updateRollCall(RollCallResult result) {
		rollCallResultMapper.updateByPrimaryKeySelective(result);
	}

}
