package com.rainyhon.common.service;

import com.rainyhon.common.model.ScheduleDetail;
import com.rainyhon.common.vo.ScheduleDetailVo;
import com.rainyhon.common.vo.ResultVo;

import java.util.Date;
import java.util.List;

public interface ScheduleDetailService {

	ResultVo add(ScheduleDetailVo vo);

	void addDetail(ScheduleDetail detail);

	ResultVo update(ScheduleDetailVo vo);

	void update(ScheduleDetail detail);

	ResultVo delete(String id);

	ResultVo getScheduleDetailList(String objectType);

	ResultVo getOnDutyData();

	List<ScheduleDetail> getScheduleDetailByTimeAndArea(String userId, Date time, String areaId);

	List<ScheduleDetail> getScheduleDetailByTimeForRollCall(String orgId, Date time, String areaId);

}
