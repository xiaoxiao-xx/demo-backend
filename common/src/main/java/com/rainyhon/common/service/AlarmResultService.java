package com.rainyhon.common.service;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.vo.AlarmResultVo;
import com.rainyhon.common.vo.ResultVo;

/**
 * 告警信息服务
 */
public interface AlarmResultService {

    PageInfo<AlarmResultVo> getRealAlarmList(String alarmType, String operator, String state,
                                             Integer pageIndex, Integer pageSize);

    PageInfo<AlarmResultVo> getRealAlarmList2(String alarmType, String operator, String state,
                                               Integer pageIndex, Integer pageSize);

    ResultVo delete(String id);

    ResultVo update(AlarmResultVo vo);

    ResultVo add(AlarmResultVo vo);

    ResultVo dealRealAlarm(AlarmResultVo vo);

    ResultVo getAlarmCount();

    ResultVo getAlarmStateInfo();

}
