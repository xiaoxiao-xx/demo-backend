package com.rainyhon.common.service;

import com.microcore.center.model.PsmScheduleDetail;
import com.rainyhon.common.vo.PsmScheduleDetailVo;
import com.rainyhon.common.vo.ResultVo;

public interface ScheduleDetailService {

    ResultVo add(PsmScheduleDetailVo vo);

    void addDetail(PsmScheduleDetail detail);

    ResultVo update(PsmScheduleDetailVo vo);

    ResultVo delete(String id);

    ResultVo getScheduleDetailList(String objectType);

    ResultVo getOnDutyData();

}
