package com.rainyhon.backend.task;

import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.model.PersonInfo;
import com.rainyhon.common.model.ScheduleConfig;
import com.rainyhon.common.model.ScheduleDetail;
import com.rainyhon.common.model.WorkAttendance;
import com.rainyhon.common.service.PersonService;
import com.rainyhon.common.service.ScheduleConfigService;
import com.rainyhon.common.service.ScheduleDetailService;
import com.rainyhon.common.service.WorkService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.rainyhon.common.constant.Constants.SCHEDULE_CONFIG_OBJECT_TYPE_ORG;
import static com.rainyhon.common.constant.Constants.SCHEDULE_CONFIG_OBJECT_TYPE_PERSON;

/**
 * @author
 */
@Component
public class WorkAttendanceTask {

	@Autowired
	private WorkService workService;

	@Autowired
	private PersonService personService;

	@Autowired
	private ScheduleConfigService scheduleConfigService;

	@Autowired
	private ScheduleDetailService scheduleDetailService;

	/**
	 * 每天23:00执行生成考勤记录的任务
	 */
	@Scheduled(cron = "0 0 23 * * *")
	private void generateWorkAttendance() {
		Calendar cal = getTomorrowCalendarInstance();

		// 如果第二天在节假日表，不生成attendance表的记录
		boolean holiday = workService.isHoliday(cal.getTime());
		if (holiday) {
			return;
		}

		// 为每个人员生成考勤记录
		List<PersonInfo> personInfoList = personService.getPersonInfoList(null);
		for (PersonInfo personInfo : personInfoList) {
			String personId = personInfo.getId();
			// 如果是豁免人员，不生成考勤记录
			if (workService.isExemptionPerson(personId)) {
				continue;
			}

			WorkAttendance workAttendance = new WorkAttendance();
			workAttendance.setId(CommonUtil.getUUID());
			workAttendance.setPersonId(personId);
			workAttendance.setCheckDate(cal.getTime());
			// 默认设置成旷工
			workAttendance.setResult(Constants.ATTENDANCE_RESULT_ABSENTEEISM);

			EntityUtils.setCreateAndUpdateInfo(workAttendance);
			workService.addWorkAttendance(workAttendance);
		}
	}

	/**
	 * 每天23:00执行生成日程的任务
	 */
	@Scheduled(cron = "0 0 23 * * *")
	private void generateScheduleDetail() {
		Calendar cal = getTomorrowCalendarInstance();

		List<ScheduleConfig> configList = scheduleConfigService.getScheduleConfigList();
		if (CommonUtil.isEmpty(configList)) {
			return;
		}

		configList.forEach(config -> {
			if (!isRepeatResultDay(config.getSomeDate(), cal.getTime(), config.getRepeatType())) {
				return;
			}

			if (SCHEDULE_CONFIG_OBJECT_TYPE_ORG.equals(config.getObjectType())) {
				List<PersonInfo> personInfoList = personService.getPersonInfoList(config.getObjectId());
				if (CommonUtil.isEmpty(personInfoList)) {
					return;
				}

				personInfoList.forEach(psmPersonInfo -> {
					ScheduleDetail detail = new ScheduleDetail();
					detail.setConfigId(config.getId());
					detail.setObjectType(SCHEDULE_CONFIG_OBJECT_TYPE_PERSON);
					detail.setObjectId(psmPersonInfo.getId());
					detail.setNumber(config.getNumber());
					detail.setSomeDate(cal.getTime());
					detail.setStartTime(config.getStartTime());
					detail.setEndTime(config.getEndTime());
					detail.setTitle(config.getTitle());
					detail.setContent(config.getContent());
					detail.setTeacher(config.getTeacher());
					detail.setAddress(config.getAddress());
					detail.setResult(Constants.ATTENDANCE_RESULT_ABSENTEEISM);
					EntityUtils.setCreateAndUpdateInfo(detail);
					scheduleDetailService.addDetail(detail);
				});
			} else if (SCHEDULE_CONFIG_OBJECT_TYPE_PERSON.equals(config.getObjectType())) {
				ScheduleDetail detail = new ScheduleDetail();
				detail.setConfigId(config.getId());
				detail.setObjectType(config.getObjectType());
				detail.setObjectId(config.getObjectId());
				detail.setNumber(config.getNumber());
				detail.setSomeDate(cal.getTime());
				detail.setStartTime(config.getStartTime());
				detail.setEndTime(config.getEndTime());
				detail.setTitle(config.getTitle());
				detail.setContent(config.getContent());
				detail.setTeacher(config.getTeacher());
				detail.setAddress(config.getAddress());
				detail.setResult(Constants.ATTENDANCE_RESULT_ABSENTEEISM);
				EntityUtils.setCreateAndUpdateInfo(detail);
				scheduleDetailService.addDetail(detail);
			}
		});
	}

	boolean isRepeatResultDay(Date beginDay, Date endDay, String repeatType) {
		// D-day W-week M-month N-no

		if (Constants.REPEAT_TYPE_NO.equals(repeatType)) {
			return false;
		}

		if (Constants.REPEAT_TYPE_DAY.equals(repeatType)) {
			return true;
		}

		Calendar beginCal = Calendar.getInstance();
		beginCal.setTime(endDay);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(beginDay);

		if (Constants.REPEAT_TYPE_WEEK.equals(repeatType)) {
			// TODO 日历天数差问题
			// int daySub = endCal.get(Calendar.DAY_OF_YEAR) - beginCal.get(Calendar.DAY_OF_YEAR);
			int daySub = CommonUtil.getTimeDistance(beginDay, endDay);
			return daySub % 7 == 0;
		}

		// 日期相同即可
		// 若 1-31  则2月不重复 2月无31
		if (Constants.REPEAT_TYPE_MONTH.equals(repeatType)) {
			return endCal.get(Calendar.DAY_OF_MONTH) == beginCal.get(Calendar.DAY_OF_MONTH);
		}

		return true;
	}

	private Calendar getTomorrowCalendarInstance() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal;
	}

}
