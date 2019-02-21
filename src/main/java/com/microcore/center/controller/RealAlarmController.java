package com.microcore.center.controller;

import com.github.pagehelper.PageInfo;
import com.microcore.center.service.RealAlarmService;
import com.microcore.center.vo.PsmRealAlarmVo;
import com.microcore.center.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("realAlarmController")
public class RealAlarmController {

    @Autowired
    private RealAlarmService realAlarmService;

    @ApiOperation(value = "查询告警信息", notes = "查询告警信息")
    @GetMapping("getRealAlarmList")
    public ResultVo<PageInfo<PsmRealAlarmVo>> query(@RequestParam(name = "alarmType", required = false) String alarmType,
                                                    @RequestParam(name = "operator", required = false) String operator,
                                                    @RequestParam(name = "state", required = false) String state,
                                                    @RequestParam(name = "pageIndex") Integer pageIndex,
                                                    @RequestParam(name = "pageSize") Integer pageSize) {
        return ResultVo.ok(realAlarmService.getRealAlarmList(alarmType, operator,state, pageIndex, pageSize));
    }

    @ApiOperation(value = "告警信息新增", notes = "告警信息新增")
    @PostMapping("add")
    public ResultVo add(@RequestBody PsmRealAlarmVo vo) {
        return realAlarmService.add(vo);
    }

    @ApiOperation(value = "告警信息修改", notes = "告警信息修改")
    @PostMapping("update")
    public ResultVo update(@RequestBody PsmRealAlarmVo vo) {
        return realAlarmService.update(vo);
    }

    @ApiOperation(value = "告警信息删除", notes = "告警信息删除")
    @PostMapping("delete")
    public ResultVo delete(@RequestBody String id) {
        return realAlarmService.delete(id);
    }
    
    
    @ApiOperation(value = "告警信息处理", notes = "告警信息处理")
    @PostMapping("dealRealAlarm")
    public ResultVo dealRealAlarm(@RequestBody PsmRealAlarmVo vo) {
        return realAlarmService.dealRealAlarm(vo);
    }

}
