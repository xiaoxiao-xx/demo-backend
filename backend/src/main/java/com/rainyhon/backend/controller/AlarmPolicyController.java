package com.rainyhon.backend.controller;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.model.AlarmPolicy;
import com.rainyhon.common.service.impl.AlarmPolicyService;
import com.rainyhon.common.vo.AlarmPolicyOpt;
import com.rainyhon.common.vo.AlarmPolicyVo;
import com.rainyhon.common.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("AlarmPolicyController")
public class AlarmPolicyController {

    @Autowired
    private AlarmPolicyService alarmPolicyService;

    @ApiOperation(value = "告警策略查询", notes = "告警策略查询")
    @GetMapping("page")
    public ResultVo<PageInfo<AlarmPolicy>> page(String alarmModel, String alarmType, String alarmLevel, String objectType, String alarmAddress, String policyName, Integer pageIndex, Integer pageSize) {
        return ResultVo.ok(alarmPolicyService.page(alarmModel, alarmType, alarmLevel, objectType, alarmAddress, policyName, pageIndex, pageSize));
    }

    @ApiOperation(value = "告警策略新增", notes = "告警策略新增")
    @PostMapping("add")
    public ResultVo add(@RequestBody AlarmPolicy alarmPolicy) throws ParseException {
        return alarmPolicyService.add(alarmPolicy);
    }

    @ApiOperation(value = "告警策略修改", notes = "告警策略修改")
    @PostMapping("update")
    public ResultVo update(@RequestBody AlarmPolicyVo alarmPolicyVo) {
        return alarmPolicyService.update(alarmPolicyVo);
    }

    @ApiOperation(value = "告警策略删除", notes = "告警策略删除")
    @PostMapping("delete")
    public ResultVo delete(@RequestBody String[] ids) {
        for (String id : ids) {
            alarmPolicyService.delete(id);
        }
        return ResultVo.ok();
    }

    @ApiOperation(value = "告警策略启动/停止", notes = "告警策略启动/停止")
    @PostMapping("state")
    public ResultVo startStop(@RequestBody AlarmPolicyOpt alarmPolicyOpt) {
        return alarmPolicyService.startStop(alarmPolicyOpt);
    }

    @GetMapping("getAllEnableAlarmPolicy")
    @ApiOperation(value = "获取全部已启用告警策略", notes = "获取全部已启用告警策略")
    public ResultVo getAllEnableAlarmPolicy() {
        return alarmPolicyService.getAllEnableAlarmPolicy();
    }

    @GetMapping("getState")
    @ApiOperation(value = "获取状态", notes = "获取状态")
    public ResultVo getState() {
        return alarmPolicyService.getState();
    }

    @GetMapping("getDelStatus")
    @ApiOperation(value = "获取逻辑删除状态", notes = "获取逻辑删除状态")
    public ResultVo getDelStatus() {
        return alarmPolicyService.getDelStatus();
    }

    @GetMapping("getObjectType")
    @ApiOperation(value = "获取对象类型", notes = "获取对象类型")
    public ResultVo getObjectType() {
        return alarmPolicyService.getObjectType();
    }

    @GetMapping("getAlarmModel")
    @ApiOperation(value = "获取告警类型", notes = "获取告警类型")
    public ResultVo getAlarmModel() {
        return alarmPolicyService.getAlarmModel();
    }

    @GetMapping("getAlarmType")
    @ApiOperation(value = "获取告警类型", notes = "获取告警类型")
    public ResultVo getAlarmType() {
        return alarmPolicyService.getAlarmType();
    }

    @GetMapping("getAlarmLevel")
    @ApiOperation(value = "获取告警级别", notes = "获取告警级别")
    public ResultVo getAlarmLevel() {
        return alarmPolicyService.getAlarmLevel();
    }

    @GetMapping("getAlarmAddress")
    @ApiOperation(value = "获取告警区域", notes = "获取告警区域")
    public ResultVo getAlarmAddress() {
        return alarmPolicyService.getAlarmAddress();
    }
}
