package com.microcore.center.controller;

import com.microcore.center.constant.Constants;
import com.microcore.center.service.DeviceService;
import com.microcore.center.vo.PsmDeviceVo;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deviceController")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("getDeviceList")
    public ResultVo getDeviceList(@RequestParam String deviceId, @RequestParam String devtypeVal,
                                  @RequestParam String state, @RequestParam Integer pageIndex,
                                  @RequestParam Integer pageSize) {
        return ResultVo.ok(deviceService.getDeviceList(deviceId, devtypeVal, state, pageIndex, pageSize));
    }

    @PostMapping("addDevice")
    public ResultVo addDevice(@RequestBody PsmDeviceVo vo) {
        deviceService.add(vo);
        return ResultVo.ok();
    }

    @PostMapping("deleteDevice")
    public ResultVo deleteDevice(@RequestParam String id) {
        deviceService.delete(id);
        return ResultVo.ok();
    }

    @PostMapping("updateDevice")
    public ResultVo updateDevice(@RequestBody PsmDeviceVo vo) {
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

}
