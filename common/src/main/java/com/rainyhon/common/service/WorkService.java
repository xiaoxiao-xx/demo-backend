package com.rainyhon.common.service;

import com.rainyhon.common.model.WorkAttendance;
import com.rainyhon.common.model.WorkCheckTime;
import com.rainyhon.common.vo.WorkAttendanceVo;

import java.util.Date;
import java.util.List;

public interface WorkService {

	boolean isHoliday(Date date);

	/**
	 * 是否豁免人员
	 *
	 * @return
	 */
	boolean isExemptionPerson(String personId);

	WorkCheckTime getWorkCheckTime();

	void addWorkAttendance(WorkAttendance workAttendance);

	WorkAttendance getWorkAttendanceByPersonIdAndCheckDate(String personId, Date checkDate);

	void updateWorkAttendance(WorkAttendance workAttendance);

	List<WorkAttendanceVo> getWorkAttendanceListByMonth(String personId, Integer year, Integer month);

}
