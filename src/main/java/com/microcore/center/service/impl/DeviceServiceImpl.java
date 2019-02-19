package com.microcore.center.service.impl;

import com.microcore.center.dto.PsmDeviceDto;
import com.microcore.center.mapper.PsmDeviceMapper;
import com.microcore.center.mapper.PsmDeviceVersionMapper;
import com.microcore.center.model.PsmDevice;
import com.microcore.center.model.PsmDeviceExample;
import com.microcore.center.service.PsmDeviceService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmDeviceVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeviceServiceImpl implements PsmDeviceService {

    @Autowired
    private PsmDeviceMapper psmDeviceMapper;

    @Autowired
    private PsmDeviceVersionMapper psmDeviceVersionService;

    public List<PsmDeviceDto> getDeviceList(String deviceId, String devtypeVal, String state) {
        PsmDeviceExample example = new PsmDeviceExample();
        PsmDeviceExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(deviceId)) {
            criteria.andDeviceIdEqualTo(deviceId);
        }
        if (StringUtils.isNotEmpty(devtypeVal)) {
            criteria.andDevtypeValLike("%" + devtypeVal.trim() + "%");
        }
        if (StringUtils.isNotEmpty(state)) {
            criteria.andStateEqualTo(state.trim());
        }

        List<PsmDevice> deviceList = psmDeviceMapper.selectByExample(example);
        List<PsmDeviceDto> deviceDtoList = CommonUtil.listPo2VO(deviceList, PsmDeviceDto.class);
        return deviceDtoList;
    }

    @Override
    public void add(PsmDeviceVo vo) {
        psmDeviceMapper.insert(vo);
    }

    @Override
    public void delete(String deviceId) {
        PsmDeviceExample example = new PsmDeviceExample();
        PsmDeviceExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceIdEqualTo(deviceId);
        psmDeviceMapper.deleteByExample(example);
    }

    @Override
    public void update(PsmDeviceVo vo) {
        PsmDeviceExample example = new PsmDeviceExample();
        PsmDeviceExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceIdEqualTo(vo.getDeviceId());
        psmDeviceMapper.updateByExample(vo, example);
    }

    @Override
    public void setDeviceState(String deviceId, String state) {
        PsmDevice psmDevice = new PsmDevice();
        psmDevice.setDeviceId(deviceId);
        psmDevice.setState(state);

        PsmDeviceExample example = new PsmDeviceExample();
        PsmDeviceExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceIdEqualTo(deviceId);

        psmDeviceMapper.updateByExampleSelective(psmDevice, example);
    }

}

