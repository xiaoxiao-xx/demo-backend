package com.rainyhon.common.service;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.WorkAttendanceMapper;
import com.rainyhon.common.mapper.WorkCheckTimeMapper;
import com.rainyhon.common.mapper.WorkExemptionMapper;
import com.rainyhon.common.mapper.WorkHolidayCalendarMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.WorkAttendanceVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.github.pagehelper.page.PageMethod.startPage;
import static com.rainyhon.common.constant.Constants.DELETE_STATUS_NO;
import static com.rainyhon.common.constant.Constants.YES;
import static com.rainyhon.common.util.CommonUtil.*;
import static java.util.Calendar.DAY_OF_WEEK;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkService {

	private static Map<Integer, String> DAY_OF_WEEK_MAP = new HashMap<>();

	static {
		DAY_OF_WEEK_MAP.put(0, "星期日");
		DAY_OF_WEEK_MAP.put(1, "星期一");
		DAY_OF_WEEK_MAP.put(2, "星期二");
		DAY_OF_WEEK_MAP.put(3, "星期三");
		DAY_OF_WEEK_MAP.put(4, "星期四");
		DAY_OF_WEEK_MAP.put(5, "星期五");
		DAY_OF_WEEK_MAP.put(6, "星期六");
	}

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

	@Autowired
	private OrgService orgService;

	@Autowired
	private PersonInfoService personInfoService;

	@Autowired
	private ScheduleDetailService scheduleDetailService;

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

	public boolean isExemptionPerson(String personId) {
		WorkExemptionExample example = new WorkExemptionExample();
		WorkExemptionExample.Criteria criteria = example.createCriteria();
		criteria.andPersonIdEqualTo(personId);
		criteria.andDelStatusEqualTo(DELETE_STATUS_NO);

		List<WorkExemption> exemptionList = workExemptionMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(exemptionList)) {
			return true;
		}

		return false;
	}

	public WorkCheckTime getWorkCheckTime() {
		WorkCheckTimeExample example = new WorkCheckTimeExample();
		WorkCheckTimeExample.Criteria criteria = example.createCriteria();
		List<WorkCheckTime> checkTimeList = workCheckTimeMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(checkTimeList)) {
			return checkTimeList.get(0);
		}

		return null;
	}

	public void addWorkAttendance(WorkAttendance workAttendance) {
		workAttendanceMapper.insert(workAttendance);
	}

	public void updateWorkAttendacne(WorkAttendance workAttendance) {
		workAttendanceMapper.updateByPrimaryKeySelective(workAttendance);
	}

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

	public void updateWorkAttendance(WorkAttendance workAttendance) {
		EntityUtils.setUpdateInfo(workAttendance);
		workAttendanceMapper.updateByPrimaryKeySelective(workAttendance);
	}

	/**
	 * 查询在某一月的考勤记录
	 *
	 * @return
	 */
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

	public ResultVo<PageInfo> getWorkAttendanceList(String personName, String orgId,
	                                                String history,
	                                                Date startDate, Date endDate,
	                                                Integer pageIndex, Integer pageSize) {
		WorkAttendanceExample example = new WorkAttendanceExample();
		example.setOrderByClause("check_date desc");
		example.setOrderByClause("on_work_time desc");

		WorkAttendanceExample.Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(personName)) {
			List<String> personIdList = personInfoService.getPersonListByLike(personName);
			criteria.andPersonIdIn(personIdList);
		}

		if (StringUtils.isNotBlank(orgId)) {
			List<String> personList = personInfoService.getPersonListByOrgLike(orgId);
			criteria.andPersonIdIn(personList);
		}

		// 查询历史考勤记录
		// 默认查询所有历史记录
		if (StringUtils.isNotBlank(history) && YES.equals(history)) {
			if (startDate != null && endDate != null) {
				criteria.andCheckDateBetween(startDate, endDate);
			}
		} else {
			// 默认查询今天的考勤记录
			criteria.andCheckDateEqualTo(new Date());
		}

		PageInfo<WorkAttendance> pageInfo = startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> workAttendanceMapper.selectByExample(example));

		List<WorkAttendance> scheduleDetailList = pageInfo.getList();
		List<WorkAttendanceVo> scheduleDetailVoList = listPo2VO(scheduleDetailList, WorkAttendanceVo.class);
		scheduleDetailVoList.forEach(vo -> {
			vo.setPersonName(personInfoService.getPersonInfoName(vo.getPersonId()));
			vo.setOrgName(orgService.getOrgNameById(personInfoService.getPersonInfo(vo.getPersonId()).getOrgId()));
			vo.setResultName(getResultName(vo.getResult(), vo));
			vo.setDayOfWeek(getDayOfWeekString(vo.getCheckDate()));

			// 如果当前时间还不到下班时间，就不展示下班时间
			LocalTime current = new LocalTime(new Date());
			LocalTime quitTime = new LocalTime(vo.getQuitTime());

			if (quitTime.isBefore(current)) {
				vo.setQuitTime(null);
			}
		});

		PageInfo<WorkAttendanceVo> voPageInfo = po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(scheduleDetailVoList);

		return ResultVo.ok(voPageInfo);
	}

	private String getDayOfWeekString(Date date) {
		int i = getDayOfWeek(date);
		return DAY_OF_WEEK_MAP.get(i);
	}

	private int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(DAY_OF_WEEK);
	}

	private String getResultName(String result, WorkAttendanceVo vo) {
		if (StringUtils.isBlank(result)) {
			return "";
		}

		List<String> res = new ArrayList<>();

		result = result.trim();
		for (int i = 0; i < result.length(); i++) {
			char c = result.charAt(i);

			if ((c + "").equals(Constants.ATTENDANCE_RESULT_LEAVE_EARLY)) {
				// 如果当前时间还不到下班时间，就不展示早退
				LocalTime current = new LocalTime(new Date());
				LocalTime quitTime = new LocalTime(vo.getQuitTime());

				if (quitTime.isBefore(current)) {
					continue;
				}

			}

			String resultString = scheduleDetailService.getAttendanceResultString(c + "");
			res.add(resultString);
		}

		return getCommaString(res);
	}

	public WorkStatInfo getWorkStatInfo(Date checkDate) {
		WorkAttendanceExample example = new WorkAttendanceExample();
		WorkAttendanceExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(DELETE_STATUS_NO);
		if (checkDate == null) {
			checkDate = new Date();
		}
		criteria.andCheckDateEqualTo(checkDate);
		List<WorkAttendance> list = workAttendanceMapper.selectByExample(example);

		Integer totalCount = list.size();
		int absenteeismCount = 0;
		int lateCount = 0;
		int leaveEarlyCount = 0;
		int normalCount = 0;

		for (WorkAttendance workAttendance : list) {
			String result = workAttendance.getResult();
			if (result.contains("0")) {
				absenteeismCount += 1;
			}
			if (result.contains("1")) {
				lateCount += 1;
			}
			if (result.contains("2")) {
				leaveEarlyCount += 1;
			}
			if (result.contains("3")) {
				normalCount += 1;
			}
		}

		return new WorkStatInfo(totalCount, absenteeismCount, lateCount,
				leaveEarlyCount, normalCount);
	}

	@Data
	@AllArgsConstructor
	private static class WorkStatInfo {

		private Integer totalCount;

		private Integer absenteeismCount;

		private Integer lateCount;

		private Integer leaveEarlyCount;

		private Integer normalCount;

	}

}

