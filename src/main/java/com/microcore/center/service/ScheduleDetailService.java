package com.microcore.center.service;

import com.microcore.center.vo.PsmScheduleDetailVo;
import com.microcore.center.vo.ResultVo;

public interface ScheduleDetailService {

    ResultVo add(PsmScheduleDetailVo vo);

    ResultVo update(PsmScheduleDetailVo vo);

    ResultVo delete(String id);

    ResultVo getScheduleDetailList(String objectType);

}
