package com.rainyhon.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.AlarmModeMapper;
import com.microcore.center.model.AlarmMode;
import com.microcore.center.model.AlarmModeExample;
import com.rainyhon.common.service.AlarmModeService;

@Service
@Transactional
public class AlarmModeServiceImpl implements AlarmModeService {

	@Autowired
	private AlarmModeMapper psmAlarmModeMapper;

	@Override
	public List<AlarmMode> getAlarmMode() {
		AlarmModeExample example = new AlarmModeExample();
		AlarmModeExample.Criteria criteria = example.createCriteria();
		return psmAlarmModeMapper.selectByExample(example);
	}

	@Override
	public String getAlarmMode(String id) {
		AlarmMode mode = psmAlarmModeMapper.selectByPrimaryKey(id);
		if (mode != null) {
			return mode.getAlarmMode();
		}
		return null;
	}

	@Override
	public AlarmMode getAlarmModeById(String id) {
		return psmAlarmModeMapper.selectByPrimaryKey(id);
	}

}
