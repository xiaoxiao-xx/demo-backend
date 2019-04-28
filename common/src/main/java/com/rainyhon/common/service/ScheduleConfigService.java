package com.rainyhon.common.service;

import com.rainyhon.common.model.ScheduleConfig;
import com.rainyhon.common.vo.ScheduleConfigVo;
import com.rainyhon.common.vo.ResultVo;

import java.util.List;

public interface ScheduleConfigService {

    ResultVo add(ScheduleConfigVo vo);

    ResultVo update(ScheduleConfigVo vo);

    ResultVo delete(String id);

    ResultVo getScheduleConfigList(String team, Integer pageIndex, Integer pageSize);

    List<ScheduleConfig> getScheduleConfigList();

    void batchDelete(String idList);

    ResultVo setRepeatType(String id, String repeatType);

}
