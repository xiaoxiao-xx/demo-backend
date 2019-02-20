package com.microcore.center.service;

import java.util.List;

import com.microcore.center.model.PsmAlarmMode;

public interface AlarmModeService {
	public List<PsmAlarmMode> getAlarmMode();
	
	public String getAlarmMode(String id);
	
	
	public PsmAlarmMode getPsmAlarmMode(String id);
}
