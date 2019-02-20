package com.microcore.center.controller;

import com.microcore.center.service.ScheduleConfigService;
import com.microcore.center.vo.PsmScheduleConfigVo;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private ScheduleConfigService scheduleConfigService;

    @PostMapping("addConfig")
    public ResultVo addConfig(PsmScheduleConfigVo vo) {
        return scheduleConfigService.add(vo);
    }

    @PostMapping("updateConfig")
    public ResultVo updateConfig(PsmScheduleConfigVo vo) {
        return scheduleConfigService.update(vo);
    }

    @PostMapping("deleteConfig")
    public ResultVo deleteConfig(String id) {
        scheduleConfigService.delete(id);
        return ResultVo.ok();
    }

    @PostMapping("getScheduleConfigList")
    public ResultVo getScheduleConfigList() {
        return scheduleConfigService.getScheduleConfigList();
    }

}
