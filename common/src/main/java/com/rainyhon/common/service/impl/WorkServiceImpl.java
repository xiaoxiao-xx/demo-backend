package com.rainyhon.common.service.impl;

import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.WorkAttendanceMapper;
import com.rainyhon.common.mapper.WorkCheckTimeMapper;
import com.rainyhon.common.mapper.WorkExemptionMapper;
import com.rainyhon.common.mapper.WorkHolidayCalendarMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.service.CommonService;
import com.rainyhon.common.service.WorkService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.WorkAttendanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkHolidayCalendarMapper workHolidayCalendarMapper;

	@Autowired
	private WorkExemptionMapper workExemptionMapper;

	@Autowired
	private WorkCheckTimeMapper workCheckTimeMapper;

	@Autowired
	private WorkAttendanceMapper workAttendanceMapper;

	@Autowired
	private CommonService commonService;

	@Override
	public boolean isHoliday(Date date) {
		WorkHolidayCalendarExample example = new WorkHolidayCalendarExample();
		WorkHolidayCalendarExample.Criteria criteria = example.createCriteria();
		criteria.andHolidayDateEqualTo(date);

		List<WorkHolidayCalendar> calendarList = workHolidayCalendarMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(calendarList)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isExemptionPerson(String personId) {
		WorkExemptionExample example = new WorkExemptionExample();
		WorkExemptionExample.Criteria criteria = example.createCriteria();
		criteria.andPersonIdEqualTo(personId);
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);

		List<WorkExemption> exemptionList = workExemptionMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(exemptionList)) {
			return true;
		}

		return false;
	}

	@Override
	public WorkCheckTime getWorkCheckTime() {
		WorkCheckTimeExample example = new WorkCheckTimeExample();
		WorkCheckTimeExample.Criteria criteria = example.createCriteria();
		List<WorkCheckTime> checkTimeList = workCheckTimeMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(checkTimeList)) {
			return checkTimeList.get(0);
		}

		return null;
	}

	@Override
	public void addWorkAttendance(WorkAttendance workAttendance) {
		workAttendanceMapper.insert(workAttendance);
	}

	@Override
	public WorkAttendance getWorkAttendanceByPersonIdAndCheckDate(String personId, Date checkDate) {
		WorkAttendanceExample example = new WorkAttendanceExample();
		WorkAttendanceExample.Criteria criteria = example.createCriteria();
		criteria.andPersonIdEqualTo(personId);
		criteria.andCheckDateEqualTo(checkDate);
		List<WorkAttendance> attendanceList = workAttendanceMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(attendanceList)) {
			return attendanceList.get(0);
		}

		return null;
	}

	@Override
	public void updateWorkAttendance(WorkAttendance workAttendance) {
		workAttendanceMapper.updateByPrimaryKeySelective(workAttendance);
	}

	/**
	 * 查询在某一月的考勤记录
	 *
	 * @return
	 */
	@Override
	public List<WorkAttendanceVo> getWorkAttendanceListByMonth(String personId, Integer year, Integer month) {
		String sql = "SELECT * FROM work_attendance \n" +
				"WHERE DATE_FORMAT( work_attendance.check_date, '%Y-%m' ) = '2019-04' \n" +
				"AND work_attendance.del_status = 'NO' \n" +
				"ORDER BY check_date ASC";

		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);

		List<Map<String, Object>> maps = commonService.executeSelectSQL(params);

		List<WorkAttendanceVo> list = CommonUtil.map2PO(maps, WorkAttendanceVo.class);

		return list;
	}

}
