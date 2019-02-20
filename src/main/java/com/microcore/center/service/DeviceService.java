package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.PsmDeviceDto;
import com.microcore.center.model.PsmParaDefine;
import com.microcore.center.vo.PsmDeviceVo;
import com.microcore.center.vo.ResultVo;

import java.util.List;

public interface DeviceService {

    PageInfo<PsmDeviceDto> getDeviceList(String deviceId, String devtypeVal, String state, Integer pageIndex, Integer pageSize);

    void add(PsmDeviceVo vo);

    void delete(String deviceId);

    void update(PsmDeviceVo vo);

    void setDeviceState(String deviceId, String state);

    List<PsmParaDefine> getDeviceTypes();

    ResultVo batchDelete(String idList);

}
