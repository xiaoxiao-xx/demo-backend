package com.rainyhon.common.service;

import com.rainyhon.common.mapper.AlarmModeMapper;
import com.rainyhon.common.model.AlarmMode;
import com.rainyhon.common.model.AlarmModeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlarmModeService {

	@Autowired
	private AlarmModeMapper alarmModeMapper;

	public List<AlarmMode> getAlarmMode() {
		AlarmModeExample example = new AlarmModeExample();
		AlarmModeExample.Criteria criteria = example.createCriteria();
		return alarmModeMapper.selectByExample(example);
	}

	public String getAlarmMode(String id) {
		AlarmMode mode = alarmModeMapper.selectByPrimaryKey(id);
		if (mode != null) {
			return mode.getAlarmMode();
		}
		return null;
	}

	public AlarmMode getAlarmModeById(String id) {
		return alarmModeMapper.selectByPrimaryKey(id);
	}

}

