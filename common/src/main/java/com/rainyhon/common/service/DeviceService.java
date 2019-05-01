package com.rainyhon.common.service;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.dto.PsmDeviceDto;
import com.microcore.center.model.PsmParaDefine;
import com.rainyhon.common.vo.PsmDeviceVo;
import com.rainyhon.common.vo.ResultVo;

import java.util.List;

public interface DeviceService {

	String getDeviceLocation(Integer x, Integer y);

	PageInfo<PsmDeviceDto> getDeviceList(String deviceId, String devtypeVal, String state,
	                                     Integer pageIndex, Integer pageSize);

	void add(PsmDeviceVo vo);

	void delete(String deviceId);

	void update(PsmDeviceVo vo);

	void setDeviceState(String deviceId, String state);

	List<PsmParaDefine> getDeviceTypes();

	ResultVo batchDelete(String idList);

	String getDevtypeValByTypeCode(String devtypeCode);

	int getEnableDeviceCount();

	int getDisabledDeviceCount();

}
