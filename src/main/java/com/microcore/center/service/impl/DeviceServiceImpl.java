package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.PsmDeviceDto;
import com.microcore.center.mapper.PsmDeviceMapper;
import com.microcore.center.model.PsmDevice;
import com.microcore.center.model.PsmDeviceExample;
import com.microcore.center.service.DeviceService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmDeviceVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microcore.center.util.CommonUtil.getUUID;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private PsmDeviceMapper psmDeviceMapper;

    public PageInfo<PsmDeviceDto> getDeviceList(String deviceId, String devtypeVal, String state, Integer pageIndex, Integer pageSize) {
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

        PageInfo<PsmDevice> pageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmDeviceMapper.selectByExample(example));

        List<PsmDeviceDto> deviceDtoList = CommonUtil.listPo2VO(pageInfo.getList(), PsmDeviceDto.class);
        PageInfo<PsmDeviceDto> deviceDtoPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
        deviceDtoPageInfo.setList(deviceDtoList);

        return deviceDtoPageInfo;
    }

    @Override
    public void add(PsmDeviceVo vo) {
        vo.setDeviceId(getUUID());
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

