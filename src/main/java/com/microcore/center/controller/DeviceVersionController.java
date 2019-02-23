package com.microcore.center.controller;

import com.microcore.center.service.DeviceVersionService;
import com.microcore.center.vo.DeviceVersionVo;
import com.microcore.center.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deviceVersionController")
public class DeviceVersionController {

    @Autowired
    private DeviceVersionService deviceVersionService;

    @PostMapping("add")
    public ResultVo add(@RequestBody DeviceVersionVo deviceVersionVo) {
        return deviceVersionService.add(deviceVersionVo);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody DeviceVersionVo deviceVersionVo) {
        return deviceVersionService.update(deviceVersionVo);
    }

    @PostMapping("delete")
    public ResultVo delete(@RequestBody String id) {
        return deviceVersionService.delete(id);
    }

    @PostMapping("batchDelete")
    public ResultVo batchDelete(@RequestParam String idList) {
        return deviceVersionService.batchDelete(idList);
    }

    @GetMapping("getDeviceVersionList")
    public ResultVo getDeviceVersionList(@RequestParam(required = false) String version, @RequestParam(required = false) String type,
                                         @RequestParam(name = "pageIndex") Integer pageIndex,
                                         @RequestParam(name = "pageSize") Integer pageSize) {
        return deviceVersionService.getDeviceVersionList(version, type, pageIndex, pageSize);
    }

    @GetMapping("getDeviceVersion")
    public ResultVo getDeviceVersion(@RequestParam String id) {
        return deviceVersionService.getDeviceVersion(id);
    }

    @ApiOperation(value = "获取设备型号", notes = "根据设备类型获取设备型号")
    @GetMapping("getVersion")
    public ResultVo getVersion(@RequestParam String devTypeCode) {
        return deviceVersionService.getVersion(devTypeCode);
    }

}
