package com.rainyhon.common.service;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.model.WorkCheckTime;
import com.rainyhon.common.model.WorkExemption;
import com.rainyhon.common.model.WorkHolidayCalendar;

public interface SettingService {

	void addCheckTime(WorkCheckTime checkTime);

	void deleteCheckTime(String id);

	void updateCheckTime(WorkCheckTime checkTime);

	WorkCheckTime getCheckTime();

	void addExemptionPerson(WorkExemption exemption);

	void deleteExemptionPerson(String id);

	void updateExemptionPerson(WorkExemption exemption);

	PageInfo<WorkExemption> getExemptionPersonList(Integer pageIndex, Integer pageSize);

	void addHolidayCalendar(WorkHolidayCalendar calendar);

	void deleteHolidayCalendar(String id);

	void updateHolidayCalendar(WorkHolidayCalendar calendar);

	PageInfo<WorkHolidayCalendar> getHolidayCalendarList(Integer pageIndex, Integer pageSize);

}
