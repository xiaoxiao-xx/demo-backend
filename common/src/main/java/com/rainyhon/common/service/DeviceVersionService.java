package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.mapper.DeviceVersionMapper;
import com.rainyhon.common.model.DeviceVersion;
import com.rainyhon.common.model.DeviceVersionExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.DeviceVersionVo;
import com.rainyhon.common.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rainyhon.common.util.CommonUtil.getUUID;

@Service
@Transactional
public class DeviceVersionService {

	@Autowired
	private DeviceVersionMapper deviceVersionMapper;

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private CommonService commonService;

	public ResultVo add(DeviceVersionVo deviceVersionVo) {
		deviceVersionVo.setDevversionId(getUUID());
		deviceVersionMapper.insert(deviceVersionVo);
		return ResultVo.ok();
	}

	public ResultVo update(DeviceVersionVo deviceVersionVo) {
		deviceVersionMapper.updateByPrimaryKeySelective(deviceVersionVo);
		return ResultVo.ok();
	}

	public ResultVo delete(String id) {
		deviceVersionMapper.deleteByPrimaryKey(id);
		return ResultVo.ok();
	}

	public ResultVo getDeviceVersionList(String version, String type, Integer pageIndex, Integer pageSize) {
		DeviceVersionExample example = new DeviceVersionExample();
		DeviceVersionExample.Criteria criteria = example.createCriteria();
		// 按类型查
		if (StringUtils.isNotEmpty(type) && !"x".equals(type)) {
			criteria.andDevtypeCodeEqualTo(type);
		}
		// 按型号的ID查
		if (StringUtils.isNotEmpty(version) && !"xt".equals(version)) {
			criteria.andDevversionIdEqualTo(version);
		}

		PageInfo<DeviceVersion> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> deviceVersionMapper.selectByExample(example));

		List<DeviceVersion> list = pageInfo.getList();
		if (CommonUtil.isNotEmpty(list)) {
			list.forEach(device -> {
				// 转设备类型为中文
				device.setDevtypeVal(deviceService.getDevtypeValByTypeCode(device.getDevtypeCode()));
			});
		}

		return ResultVo.ok(pageInfo);
	}

	public ResultVo getDeviceVersion(String id) {
		return ResultVo.ok(getDeviceVersionById(id));
	}

	public DeviceVersion getDeviceVersionById(String id) {
		return deviceVersionMapper.selectByPrimaryKey(id);
	}

	public ResultVo getVersion(String devTypeCode) {
		Map<String, Object> prams = new HashMap<>();
		String sql = "select * from device_version "
				+ "where devtype_code = #{devTypeCode} "
				+ "group by device_version";
		prams.put("sql", sql);
		prams.put("devTypeCode", devTypeCode);
		List<Map<String, Object>> list = commonService.executeSelectSQL(prams);
		return ResultVo.ok(list);
	}

	public ResultVo batchDelete(String idList) {
		idList = idList.trim();
		if (StringUtils.isEmpty(idList)) {
			return ResultVo.ok();
		}

		String[] ids = idList.split(",");
		for (String i : ids) {
			deviceVersionMapper.deleteByPrimaryKey(i);
		}

		return ResultVo.ok();
	}

	public String getDeviceVersionStringById(String id) {
		DeviceVersion deviceVersion = getDeviceVersionById(id);
		if (deviceVersion == null) {
			return "";
		}
		return deviceVersion.getDeviceVersion();
	}

}

