package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.PsmDeviceDto;
import com.microcore.center.vo.PsmDeviceVo;

public interface DeviceService {

    PageInfo<PsmDeviceDto> getDeviceList(String deviceId, String devtypeVal, String state, Integer pageIndex, Integer pageSize);

    void add(PsmDeviceVo vo);

    void delete(String deviceId);

    void update(PsmDeviceVo vo);

    void setDeviceState(String deviceId, String state);

}
