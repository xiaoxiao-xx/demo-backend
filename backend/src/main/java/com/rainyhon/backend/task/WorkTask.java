package com.rainyhon.backend.task;

import com.rainyhon.common.model.PersonInfo;
import com.rainyhon.common.model.WorkAttendance;
import com.rainyhon.common.service.PersonInfoService;
import com.rainyhon.common.service.WorkService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

import static com.rainyhon.common.constant.Constants.ATTENDANCE_RESULT_ABSENTEEISM;
import static com.rainyhon.common.util.CommonUtil.getTomorrowCalendarInstance;

/**
 * 考勤记录生成任务
 * TODO 多个节点可能重复生成
 */
@Component
public class WorkTask {

	@Autowired
	private WorkService workService;

	@Autowired
	private PersonInfoService personInfoService;

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
		List<PersonInfo> personInfoList = personInfoService.getPersonInfoListByOrgId(null);
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
			workAttendance.setResult(ATTENDANCE_RESULT_ABSENTEEISM);

			EntityUtils.setCreateAndUpdateInfo(workAttendance);
			workService.addWorkAttendance(workAttendance);
		}
	}

}
