package com.microcore.center.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.PsmAlarmModeMapper;
import com.microcore.center.model.PsmAlarmMode;
import com.microcore.center.model.PsmAlarmModeExample;
import com.microcore.center.service.AlarmModeService;
@Service
@Transactional
public class AlarmModeServiceImpl implements AlarmModeService {
	@Autowired
	private PsmAlarmModeMapper psmAlarmModeMapper ;
	
	@Override
	public List<PsmAlarmMode> getAlarmMode() {
		PsmAlarmModeExample example = new PsmAlarmModeExample() ;
		PsmAlarmModeExample.Criteria criteria = example.createCriteria();
		return psmAlarmModeMapper.selectByExample(example);
	}

}
