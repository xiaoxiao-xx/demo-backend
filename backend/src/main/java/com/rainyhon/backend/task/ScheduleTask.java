package com.rainyhon.backend.task;

import com.rainyhon.common.mapper.SchedulePersonMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.service.PersonInfoService;
import com.rainyhon.common.service.ScheduleConfigService;
import com.rainyhon.common.service.ScheduleDetailService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.rainyhon.common.constant.Constants.*;
import static com.rainyhon.common.util.CommonUtil.getTomorrowCalendarInstance;

/**
 * 日程生成任务
 * TODO 多个节点可能重复生成日程
 *
 * @author
 */
@Component
public class ScheduleTask {

	@Autowired
	private PersonInfoService personInfoService;

	@Autowired
	private ScheduleConfigService scheduleConfigService;

	@Autowired
	private ScheduleDetailService scheduleDetailService;

	@Autowired
	private SchedulePersonMapper schedulePersonMapper;

	/**
	 * 每天23:00执行生成日程的任务
	 */
	// TODO 测试
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

			// 生成团队日程
			if (SCHEDULE_CONFIG_OBJECT_TYPE_ORG.equals(config.getObjectType())) {
				List<PersonInfo> personInfoList = personInfoService.getPersonInfoListByOrgId(config.getObjectId());
				if (CommonUtil.isEmpty(personInfoList)) {
					return;
				}

				personInfoList.forEach(personInfo -> {
					ScheduleDetail detail = new ScheduleDetail();
					detail.setId(CommonUtil.getUUID());
					detail.setConfigId(config.getId());
					detail.setType(config.getConfigType());
					detail.setObjectType(SCHEDULE_CONFIG_OBJECT_TYPE_ORG);
					detail.setObjectId(personInfo.getId());
					detail.setNumber(config.getNumber());
					detail.setSomeDate(cal.getTime());
					detail.setStartTime(config.getStartTime());
					detail.setEndTime(config.getEndTime());
					detail.setTitle(config.getTitle());
					detail.setContent(config.getContent());
					detail.setTeacher(config.getTeacher());
					detail.setAddress(config.getAddress());
					detail.setResult(ATTENDANCE_RESULT_ABSENTEEISM);
					EntityUtils.setCreateAndUpdateInfo(detail);
					scheduleDetailService.addDetail(detail);
				});
			} else if (SCHEDULE_CONFIG_OBJECT_TYPE_PERSON.equals(config.getObjectType())) {
				// 查询个人列表
				String objectId = config.getObjectId();
				List<SchedulePerson> schedulePersonList = getSchedulePersonList(objectId);
				if (CommonUtil.isNotEmpty(schedulePersonList)) {
					schedulePersonList.forEach(schedulePerson -> {
						// 生成个人日程
						ScheduleDetail detail = new ScheduleDetail();
						detail.setId(CommonUtil.getUUID());
						detail.setConfigId(config.getId());
						detail.setType(config.getConfigType());
						detail.setObjectType(config.getObjectType());
						// 个人ID
						detail.setObjectId(schedulePerson.getPersonId());
						detail.setNumber(config.getNumber());
						detail.setSomeDate(cal.getTime());
						detail.setStartTime(config.getStartTime());
						detail.setEndTime(config.getEndTime());
						detail.setTitle(config.getTitle());
						detail.setContent(config.getContent());
						detail.setTeacher(config.getTeacher());
						detail.setAddress(config.getAddress());
						detail.setResult(ATTENDANCE_RESULT_ABSENTEEISM);
						EntityUtils.setCreateAndUpdateInfo(detail);
						scheduleDetailService.addDetail(detail);
					});
				}
			}
		});
	}

	private List<SchedulePerson> getSchedulePersonList(String objectId) {
		SchedulePersonExample example = new SchedulePersonExample();
		SchedulePersonExample.Criteria criteria = example.createCriteria();
		criteria.andObjectIdEqualTo(objectId);
		return schedulePersonMapper.selectByExample(example);
	}

	boolean isRepeatResultDay(Date beginDay, Date endDay, String repeatType) {
		// D-day W-week M-month N-no

		if (REPEAT_TYPE_NO.equals(repeatType)) {
			return false;
		}

		if (REPEAT_TYPE_DAY.equals(repeatType)) {
			return true;
		}

		Calendar beginCal = Calendar.getInstance();
		beginCal.setTime(beginDay);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDay);

		if (REPEAT_TYPE_WEEK.equals(repeatType)) {
			// TODO 日历天数差问题
			// int daySub = endCal.get(Calendar.DAY_OF_YEAR) - beginCal.get(Calendar.DAY_OF_YEAR);
			int daySub = CommonUtil.getTimeDistance(beginDay, endDay);
			return daySub % 7 == 0;
		}

		// 日期相同即可
		// 若 1-31  则2月不重复 2月无31
		if (REPEAT_TYPE_MONTH.equals(repeatType)) {
			return endCal.get(Calendar.DAY_OF_MONTH) == beginCal.get(Calendar.DAY_OF_MONTH);
		}

		return true;
	}

}
