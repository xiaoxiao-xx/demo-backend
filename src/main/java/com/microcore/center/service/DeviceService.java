package com.microcore.center.service;

import com.microcore.center.dto.PsmDeviceDto;
import com.microcore.center.vo.PsmDeviceVo;

import java.util.List;

public interface DeviceService {

    List<PsmDeviceDto> getDeviceList(String deviceId, String devtypeVal, String state);

    void add(PsmDeviceVo vo);

    void delete(String deviceId);

    void update(PsmDeviceVo vo);

    void setDeviceState(String deviceId, String state);

}
