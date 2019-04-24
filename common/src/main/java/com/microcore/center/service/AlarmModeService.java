package com.microcore.center.service;

import java.util.List;

import com.microcore.center.model.AlarmMode;

public interface AlarmModeService {

	List<AlarmMode> getAlarmMode();

	String getAlarmMode(String id);

	AlarmMode getAlarmModeById(String id);
}
