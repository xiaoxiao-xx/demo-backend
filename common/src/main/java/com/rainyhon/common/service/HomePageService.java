package com.rainyhon.common.service;

import com.rainyhon.common.vo.ResultVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class HomePageService {

	@Autowired
	private PersonInfoService personInfoService;

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private AlarmResultService alarmResultService;

	public ResultVo<?> getHomePageStatInfo() {
		int personCount = personInfoService.getPersonCount();
		int importantCarePersonCount = personInfoService.getImportantCarePersonCount();
		int enabledDeviceCount = deviceService.getEnableDeviceCount();
		int disabledDeviceCount = deviceService.getDisabledDeviceCount();
		int unprocessedAlarmCount = alarmResultService.getUnprocessedAlarmCount();

		HomePageStatInfo info = new HomePageStatInfo();
		info.setPersonCount(personCount);
		info.setImportantCarePersonCount(importantCarePersonCount);
		info.setEnabledDeviceCount(enabledDeviceCount);
		info.setDisabledDeviceCount(disabledDeviceCount);
		info.setUnprocessedAlarmCount(unprocessedAlarmCount);

		return ResultVo.ok(info);
	}

	@Data
	private static class HomePageStatInfo {

		private int personCount;

		private int importantCarePersonCount;

		private int enabledDeviceCount;

		private int disabledDeviceCount;

		private int unprocessedAlarmCount;

	}

}
