package com.microcore.center.controller;

import com.microcore.center.service.DeviceVersionService;
import com.microcore.center.service.ParaDefineService;
import com.microcore.center.vo.DeviceVersionVo;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deviceVersionController")
public class DeviceVersionController {

    @Autowired
    private DeviceVersionService deviceVersionService;

    @Autowired
    private ParaDefineService paraDefineService;

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

    @GetMapping("getDeviceVersionList")
    public ResultVo getDeviceVersionList(@RequestParam String version, @RequestParam String type ){
        return deviceVersionService.getDeviceVersionList(version, type);
    }

    @GetMapping("getDeviceVersion")
    public ResultVo getDeviceVersion(@RequestParam String id){
        return deviceVersionService.getDeviceVersion(id);
    }

    @GetMapping("getDeviceTypes")
    public ResultVo getDeviceTypes(){
        return ResultVo.ok(paraDefineService.getPsmParaDefineByType("DEVICE_TYPE"));
    }

    @GetMapping("getVersion")
    public ResultVo getVersion(){
        return deviceVersionService.getVersion();
    }



}
