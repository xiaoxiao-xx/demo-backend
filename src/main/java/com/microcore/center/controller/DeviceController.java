package com.microcore.center.controller;

import com.microcore.center.constant.Constants;
import com.microcore.center.service.PsmDeviceService;
import com.microcore.center.vo.PsmDeviceVo;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deviceController")
public class DeviceController {

    @Autowired
    private PsmDeviceService psmDeviceService;

    @GetMapping("getDeviceList")
    public ResultVo getDeviceList(@RequestParam String deviceId, @RequestParam String devtypeVal,
                                  @RequestParam String state, @RequestParam String pageIndex,
                                  @RequestParam String pageSize) {
        return ResultVo.ok(psmDeviceService.getDeviceList(deviceId, devtypeVal, state));
    }

    @PostMapping("add")
    public ResultVo addDevice(@RequestBody PsmDeviceVo vo) {
        psmDeviceService.add(vo);
        return ResultVo.ok();
    }

    @PostMapping("delete")
    public ResultVo deleteDevice(@RequestParam String id) {
        psmDeviceService.delete(id);
        return ResultVo.ok();
    }

    @PostMapping("update")
    public ResultVo updateDevice(@RequestBody PsmDeviceVo vo) {
        psmDeviceService.update(vo);
        return ResultVo.ok();
    }

    @PostMapping("enableDevice")
    public ResultVo enableDevice(@RequestParam String id) {
        psmDeviceService.setDeviceState(id, Constants.DEVICE_STATE_ENABLE);
        return ResultVo.ok();
    }

    @PostMapping("disableDevice")
    public ResultVo disableDevice(@RequestParam String id) {
        psmDeviceService.setDeviceState(id, Constants.DEVICE_STATE_DISABLE);
        return ResultVo.ok();
    }

}
