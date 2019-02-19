package com.microcore.center.service.impl;

import com.microcore.center.mapper.PsmDeviceVersionMapper;
import com.microcore.center.model.PsmDeviceVersion;
import com.microcore.center.model.PsmDeviceVersionExample;
import com.microcore.center.service.DeviceVersionService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.DeviceVersionVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeviceVersionServiceImpl implements DeviceVersionService {

    @Autowired
    private PsmDeviceVersionMapper deviceVersionMapper;

    @Override
    public ResultVo add(DeviceVersionVo deviceVersionVo) {
        deviceVersionVo.setDevversionId(CommonUtil.getUUID());
        deviceVersionMapper.insert(deviceVersionVo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo update(DeviceVersionVo deviceVersionVo) {
        deviceVersionMapper.updateByPrimaryKeySelective(deviceVersionVo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo delete(String id) {
        deviceVersionMapper.deleteByPrimaryKey(id);
        return ResultVo.ok();
    }

    @Override
    public ResultVo getDeviceVersionList(String version, String type) {
        PsmDeviceVersionExample example = new PsmDeviceVersionExample();
        PsmDeviceVersionExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(version)) {
            criteria.andDeviceVersionEqualTo(version);
        }
        if (StringUtils.isNotEmpty(type)) {
            criteria.andDevtypeValEqualTo(type);
        }
        List<PsmDeviceVersion> list = deviceVersionMapper.selectByExample(example);
        return ResultVo.ok(list.isEmpty() ? new ArrayList<>() : list);
    }

    @Override
    public ResultVo getDeviceVersion(String id) {
        return ResultVo.ok(deviceVersionMapper.selectByPrimaryKey(id));
    }
}