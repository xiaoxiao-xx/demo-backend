package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.WorkCheckTimeMapper;
import com.rainyhon.common.mapper.WorkExemptionMapper;
import com.rainyhon.common.mapper.WorkHolidayCalendarMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SettingService {

	@Autowired
	private WorkCheckTimeMapper checkTimeMapper;

	@Autowired
	private WorkHolidayCalendarMapper holidayCalendarMapper;

	@Autowired
	private WorkExemptionMapper exemptionMapper;

	public void addCheckTime(WorkCheckTime checkTime) {
		WorkCheckTimeExample example = new WorkCheckTimeExample();
		checkTimeMapper.deleteByExample(example);

		checkTime.setId(CommonUtil.getUUID());
		checkTimeMapper.insert(checkTime);
	}

	public void deleteCheckTime(String id) {
		checkTimeMapper.deleteByPrimaryKey(id);
	}

	public void updateCheckTime(WorkCheckTime checkTime) {
		EntityUtils.setUpdateInfo(checkTime);
		checkTimeMapper.updateByPrimaryKeySelective(checkTime);
	}

	public WorkCheckTime getCheckTime() {
		WorkCheckTimeExample example = new WorkCheckTimeExample();
		// WorkCheckTimeExample.Criteria criteria = example.createCriteria();
		List<WorkCheckTime> workCheckTimeList = checkTimeMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(workCheckTimeList)) {
			return workCheckTimeList.get(0);
		}

		return new WorkCheckTime();
	}

	public void addExemptionPerson(WorkExemption exemption) {
		exemption.setId(CommonUtil.getUUID());
		EntityUtils.setCreateAndUpdateInfo(exemption);
		exemptionMapper.insert(exemption);
	}

	public void addExemptionPersonList(List<WorkExemption> exemptionList) {
		if (CommonUtil.isNotEmpty(exemptionList)) {
			exemptionList.forEach(exemption -> {
				exemption.setId(CommonUtil.getUUID());
				EntityUtils.setCreateAndUpdateInfo(exemption);
				exemptionMapper.insert(exemption);
			});
		}
	}

	public void deleteExemptionPerson(String id) {
		WorkExemption exemption = new WorkExemption();
		exemption.setId(id);
		exemption.setDelStatus(Constants.DELETE_STATUS_YES);
		exemptionMapper.updateByPrimaryKeySelective(exemption);
	}

	public void updateExemptionPerson(WorkExemption exemption) {
		EntityUtils.setUpdateInfo(exemption);
		exemptionMapper.updateByPrimaryKeySelective(exemption);
	}

	public PageInfo<WorkExemption> getExemptionPersonList(Integer pageIndex, Integer pageSize) {
		WorkExemptionExample example = new WorkExemptionExample();
		WorkExemptionExample.Criteria criteria = example.createCriteria();
		return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> exemptionMapper.selectByExample(example));
	}

	public List<WorkExemption> getAllExemptionPersons() {
		WorkExemptionExample example = new WorkExemptionExample();
		WorkExemptionExample.Criteria criteria = example.createCriteria();
		List<WorkExemption> workExemptionList = exemptionMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(workExemptionList)) {
			return workExemptionList;
		}

		return new ArrayList<>();
	}

	public void addHolidayCalendar(WorkHolidayCalendar calendar) {
		calendar.setId(CommonUtil.getUUID());
		holidayCalendarMapper.insert(calendar);
	}

	public void deleteHolidayCalendar(String id) {
		holidayCalendarMapper.deleteByPrimaryKey(id);
	}

	public void updateHolidayCalendar(WorkHolidayCalendar calendar) {
		EntityUtils.setUpdateInfo(calendar);
		holidayCalendarMapper.updateByPrimaryKeySelective(calendar);
	}

	public PageInfo<WorkHolidayCalendar> getHolidayCalendarList(Integer pageIndex, Integer pageSize) {
		WorkHolidayCalendarExample example = new WorkHolidayCalendarExample();
		WorkHolidayCalendarExample.Criteria criteria = example.createCriteria();
		return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> holidayCalendarMapper.selectByExample(example));
	}

}

