package com.microcore.center.service;

import com.microcore.center.vo.PsmScheduleConfigVo;
import com.microcore.center.vo.ResultVo;

public interface ScheduleConfigService {

    ResultVo add(PsmScheduleConfigVo vo);

    ResultVo update(PsmScheduleConfigVo vo);

    ResultVo delete(String id);

    ResultVo getScheduleConfigList(Integer pageIndex, Integer pageSize);

    void batchDelete(String idList);

}
