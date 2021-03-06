package com.rainyhon.backend.controller;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.service.AlarmResultService;
import com.rainyhon.common.vo.AlarmResultVo;
import com.rainyhon.common.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("AlarmResultController")
public class AlarmResultController {

    @Autowired
    private AlarmResultService alarmResultService;

    @ApiOperation(value = "查询告警信息", notes = "查询告警信息")
    @GetMapping("page")
    public ResultVo<PageInfo<AlarmResultVo>> page(@RequestParam(name = "alarmType", required = false) String alarmType,
                                                  @RequestParam(name = "operator", required = false) String operator,
                                                  @RequestParam(name = "state", required = false) String state,
                                                  @RequestParam(name = "pageIndex") Integer pageIndex,
                                                  @RequestParam(name = "pageSize") Integer pageSize) {
        return ResultVo.ok(alarmResultService.page(alarmType, operator,state, pageIndex, pageSize));
    }

    @ApiOperation(value = "告警信息修改", notes = "告警信息修改")
    @PostMapping("update")
    public ResultVo update(@RequestBody AlarmResultVo vo) {
        return alarmResultService.update(vo);
    }

    @ApiOperation(value = "告警信息删除", notes = "告警信息删除")
    @PostMapping("delete")
    public ResultVo delete(@RequestBody String id) {
        return alarmResultService.delete(id);
    }

    @ApiOperation(value = "告警信息处理", notes = "告警信息处理")
    @PostMapping("dealRealAlarm")
    public ResultVo dealRealAlarm(@RequestBody AlarmResultVo vo) {
        return alarmResultService.dealRealAlarm(vo);
    }

    @ApiOperation(value = "获取告警信息数量", notes = "获取告警信息数量")
    @GetMapping("getAlarmCount")
    public ResultVo getRealAlarmCount() {
        return alarmResultService.getAlarmCount();
    }

    @GetMapping("getAlarmStateInfo")
    public ResultVo<?> getAlarmStateInfo() {
        return alarmResultService.getAlarmStateInfo();
    }

}
