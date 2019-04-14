package com.microcore.center.service;

import java.util.List;

import com.microcore.center.model.PsmAlarmMode;

public interface AlarmModeService {

	List<PsmAlarmMode> getAlarmMode();

	String getAlarmMode(String id);

	PsmAlarmMode getPsmAlarmMode(String id);

}
