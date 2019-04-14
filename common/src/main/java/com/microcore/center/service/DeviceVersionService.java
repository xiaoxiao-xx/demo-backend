package com.microcore.center.service;

import com.microcore.center.model.PsmDeviceVersion;
import com.microcore.center.vo.DeviceVersionVo;
import com.microcore.center.vo.ResultVo;

public interface DeviceVersionService {
    ResultVo add(DeviceVersionVo deviceVersionVo);

    ResultVo update(DeviceVersionVo deviceVersionVo);

    ResultVo delete(String id);

    ResultVo getDeviceVersionList(String version, String type, Integer pageIndex, Integer pageSize);

    ResultVo getDeviceVersion(String id);

    PsmDeviceVersion getDeviceVersionById(String id);

    ResultVo getVersion(String devTypeCode);

    ResultVo batchDelete(String idList);

    String getDeviceVersionStringById(String id);

}
