package com.rainyhon.common.service;

import com.rainyhon.common.vo.PsmScheduleConfigVo;
import com.rainyhon.common.vo.ResultVo;

public interface ScheduleConfigService {

    ResultVo add(PsmScheduleConfigVo vo);

    ResultVo update(PsmScheduleConfigVo vo);

    ResultVo delete(String id);

    ResultVo getScheduleConfigList(String team, Integer pageIndex, Integer pageSize);

    void batchDelete(String idList);

    ResultVo setRepeatType(String id, String repeatType);

}
