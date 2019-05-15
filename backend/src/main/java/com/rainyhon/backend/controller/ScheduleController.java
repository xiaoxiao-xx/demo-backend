package com.rainyhon.backend.controller;

import com.rainyhon.common.model.ScheduleDetail;
import com.rainyhon.common.service.ScheduleConfigService;
import com.rainyhon.common.service.ScheduleDetailService;
import com.rainyhon.common.vo.ScheduleConfigVo;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.ScheduleDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private ScheduleConfigService scheduleConfigService;

    @Autowired
    private ScheduleDetailService scheduleDetailService;

    @PostMapping("addConfig")
    public ResultVo addConfig(@RequestBody ScheduleConfigVo vo) {
        return scheduleConfigService.add(vo);
    }

    @PostMapping("updateConfig")
    public ResultVo updateConfig(@RequestBody ScheduleConfigVo vo) {
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
    public ResultVo getScheduleConfigList(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date someDate,
                                          @RequestParam(required = false) String configType,
                                          @RequestParam(required = false) String objectType,
                                          @RequestParam(required = false) String team,
                                          @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                          @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return scheduleConfigService.getScheduleConfigList(someDate, configType, objectType, team, pageIndex, pageSize);
    }

    @PostMapping("repeat")
    public ResultVo repeat(@RequestParam String id, @RequestParam String repeatType) {
        return scheduleConfigService.setRepeatType(id, repeatType);
    }

    @GetMapping("getScheduleDetailList")
    public ResultVo getScheduleDetailList(@RequestParam String objectType,
                                          @RequestParam(required = false) String teacherName,
                                          @RequestParam(required = false) String crtOrgId,
                                          @RequestParam(required = false) String areaId,
                                          @RequestParam(required = false) String result,
                                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date someDate,
                                          @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                          @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return scheduleDetailService.getScheduleDetailList(objectType, teacherName, crtOrgId,
                areaId, result, someDate, pageIndex, pageSize);
    }

    @PostMapping("addDetail")
    public ResultVo<String> addDetail(@RequestBody ScheduleDetailVo vo) {
        return scheduleDetailService.add(vo);
    }

    @PostMapping("updateDetail")
    public ResultVo<String> updateDetail(@RequestBody ScheduleDetail detail) {
        scheduleDetailService.update(detail);
        return ResultVo.ok();
    }

    @GetMapping("getOnDutyData")
    public ResultVo getOnDutyData() {
        return scheduleDetailService.getOnDutyData();
    }

}
