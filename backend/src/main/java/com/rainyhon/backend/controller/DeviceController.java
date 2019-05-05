package com.rainyhon.backend.controller;

import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.service.DeviceService;
import com.rainyhon.common.vo.DeviceVo;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deviceController")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("getDeviceList")
    public ResultVo getDeviceList(@RequestParam(required = false) String deviceId,
                                  @RequestParam(required = false) String devtypeVal,
                                  @RequestParam(required = false) String state,
                                  @RequestParam Integer pageIndex,
                                  @RequestParam Integer pageSize) {
        return ResultVo.ok(deviceService.getDeviceList(deviceId, devtypeVal, state, pageIndex, pageSize));
    }

    @PostMapping("add")
    public ResultVo addDevice(@RequestBody DeviceVo vo) {
        deviceService.add(vo);
        return ResultVo.ok();
    }

    @PostMapping("delete")
    public ResultVo deleteDevice(@RequestParam String id) {
        deviceService.delete(id);
        return ResultVo.ok();
    }

    @PostMapping("batchDelete")
    public ResultVo batchDelete(@RequestParam String idList) {
        return deviceService.batchDelete(idList);
    }

    @PostMapping("update")
    public ResultVo updateDevice(@RequestBody DeviceVo vo) {
        deviceService.update(vo);
        return ResultVo.ok();
    }

    @PostMapping("enableDevice")
    public ResultVo enableDevice(@RequestParam String id) {
        deviceService.setDeviceState(id, Constants.DEVICE_STATE_ENABLE);
        return ResultVo.ok();
    }

    @PostMapping("disableDevice")
    public ResultVo disableDevice(@RequestParam String id) {
        deviceService.setDeviceState(id, Constants.DEVICE_STATE_DISABLE);
        return ResultVo.ok();
    }

    @GetMapping("getDeviceTypes")
    public ResultVo getDeviceTypes() {
        return ResultVo.ok(deviceService.getDeviceTypes());
    }

    @GetMapping("getLocationString")
    public ResultVo getDeviceTypes(@RequestParam Integer x, @RequestParam Integer y) {
        return ResultVo.ok(deviceService.getDeviceLocation(x, y));
    }

}
