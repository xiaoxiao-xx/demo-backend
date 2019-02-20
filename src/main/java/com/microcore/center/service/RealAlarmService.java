package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.vo.PsmRealAlarmVo;
import com.microcore.center.vo.ResultVo;

public interface RealAlarmService {

   PageInfo<PsmRealAlarmVo> getRealAlarmList(String alarmType, String operator, Integer pageIndex, Integer pageSize);

   ResultVo delete(String id);

   ResultVo update(PsmRealAlarmVo vo);

   ResultVo add(PsmRealAlarmVo vo);

}
