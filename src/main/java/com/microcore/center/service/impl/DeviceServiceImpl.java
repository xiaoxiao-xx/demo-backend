package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.constant.Constants;
import com.microcore.center.dto.PsmDeviceDto;
import com.microcore.center.mapper.PsmDeviceMapper;
import com.microcore.center.model.PsmDevice;
import com.microcore.center.model.PsmDeviceExample;
import com.microcore.center.model.PsmParaDefine;
import com.microcore.center.service.DeviceService;
import com.microcore.center.service.ParaDefineService;
import com.microcore.center.vo.PsmDeviceVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.microcore.center.util.CommonUtil.*;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private PsmDeviceMapper psmDeviceMapper;

    @Autowired
    private ParaDefineService paraDefineService;

    private List<String> locationList = new ArrayList<>();

    {
        locationList.add("教学楼");
        locationList.add("篮球场");
        locationList.add("仓库");
    }

    public PageInfo<PsmDeviceDto> getDeviceList(String deviceId, String devtypeVal,
                                                String state, Integer pageIndex, Integer pageSize) {
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

        List<PsmDeviceDto> deviceDtoList = listPo2VO(pageInfo.getList(), PsmDeviceDto.class);

        int i = 0;
        for (PsmDeviceDto device : deviceDtoList) {
            device.setDeviceLocation(locationList.get(i));
            i = (i + 1) % locationList.size();
        }

        PageInfo<PsmDeviceDto> deviceDtoPageInfo = po2VO(pageInfo, PageInfo.class);
        deviceDtoPageInfo.setList(deviceDtoList);

        return deviceDtoPageInfo;
    }

    @Override
    public void add(PsmDeviceVo vo) {
        vo.setDeviceId(getUUID());
        vo.setState(Constants.DEVICE_STATE_ENABLE);
        psmDeviceMapper.insert(vo);
    }

    @Override
    public void delete(String deviceId) {
        psmDeviceMapper.deleteByPrimaryKey(deviceId);
    }

    @Override
    public void update(PsmDeviceVo vo) {
        psmDeviceMapper.updateByPrimaryKeySelective(vo);
    }

    @Override
    public void setDeviceState(String deviceId, String state) {
        PsmDevice device = new PsmDevice();
        device.setDeviceId(deviceId);
        device.setState(state);
        psmDeviceMapper.updateByPrimaryKeySelective(device);
    }

    @Override
    public List<PsmParaDefine> getDeviceTypes() {
        return paraDefineService.getPsmParaDefineByType(Constants.DEVICE_TYPE);
    }

    @Override
    public ResultVo batchDelete(String idList) {
        idList = idList.trim();
        if (StringUtils.isEmpty(idList)) {
            return ResultVo.ok();
        }

        String[] ids = idList.split(",");
        for (String i : ids) {
            psmDeviceMapper.deleteByPrimaryKey(i);
        }

        return ResultVo.ok();
    }

}

