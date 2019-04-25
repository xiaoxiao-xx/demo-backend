package com.rainyhon.backend.controller;

import com.rainyhon.common.service.ScheduleConfigService;
import com.rainyhon.common.service.ScheduleDetailService;
import com.rainyhon.common.vo.PsmScheduleConfigVo;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private ScheduleConfigService scheduleConfigService;

    @Autowired
    private ScheduleDetailService scheduleDetailService;

    @PostMapping("addConfig")
    public ResultVo addConfig(@RequestBody PsmScheduleConfigVo vo) {
        return scheduleConfigService.add(vo);
    }

    @PostMapping("updateConfig")
    public ResultVo updateConfig(@RequestBody PsmScheduleConfigVo vo) {
        return scheduleConfigService.update(vo);
    }

    @PostMapping("deleteConfig")
    public ResultVo deleteConfig(@RequestParam String id) {
        scheduleConfigService.delete(id);
        return ResultVo.ok();
    }

    @PostMapping("batchDelete")
    public ResultVo batchDeleteConfig(@RequestParam String idList) {
        scheduleConfigService.batchDelete(idList);
        return ResultVo.ok();
    }

    @GetMapping("getScheduleConfigList")
    public ResultVo getScheduleConfigList(@RequestParam(required = false) String team,
                                          @RequestParam Integer pageIndex,
                                          @RequestParam Integer pageSize) {
        return scheduleConfigService.getScheduleConfigList(team, pageIndex, pageSize);
    }

    @PostMapping("repeat")
    public ResultVo repeat(@RequestParam String id, @RequestParam String repeatType) {
        return scheduleConfigService.setRepeatType(id, repeatType);
    }

    @GetMapping("getScheduleDetailList")
    public ResultVo getScheduleDetailList(@RequestParam String objectType) {
        return scheduleDetailService.getScheduleDetailList(objectType);
    }

    @GetMapping("getOnDutyData")
    public ResultVo getOnDutyData() {
        return scheduleDetailService.getOnDutyData();
    }

}
