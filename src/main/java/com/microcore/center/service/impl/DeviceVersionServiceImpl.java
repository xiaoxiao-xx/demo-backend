package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmDeviceVersionMapper;
import com.microcore.center.model.PsmDeviceVersionExample;
import com.microcore.center.service.CommonService;
import com.microcore.center.service.DeviceVersionService;
import com.microcore.center.vo.DeviceVersionVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.microcore.center.util.CommonUtil.getUUID;

@Service
@Transactional
public class DeviceVersionServiceImpl implements DeviceVersionService {

    @Autowired
    private PsmDeviceVersionMapper deviceVersionMapper;

    @Override
    public ResultVo add(DeviceVersionVo deviceVersionVo) {
        deviceVersionVo.setDevversionId(getUUID());
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
    public ResultVo getDeviceVersionList(String version, String type, Integer pageIndex, Integer pageSize) {
        PsmDeviceVersionExample example = new PsmDeviceVersionExample();
        PsmDeviceVersionExample.Criteria criteria = example.createCriteria();
        // 按型号查
        if (StringUtils.isNotEmpty(version)) {
            criteria.andDeviceVersionEqualTo(version);
        }
        // 按类型中文查
        if (StringUtils.isNotEmpty(type)) {
            criteria.andDevtypeValEqualTo(type);
        }
        PageInfo<Object> pageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> deviceVersionMapper.selectByExample(example));
        return ResultVo.ok(pageInfo);
    }

    @Override
    public ResultVo getDeviceVersion(String id) {
        return ResultVo.ok(deviceVersionMapper.selectByPrimaryKey(id));
    }

    @Autowired
    private CommonService commonService;

    @Override
    public ResultVo getVersion() {
        Map<String, Object> prams = new HashMap<>();
        String sql = "SELECT DISTINCT device_version from psm_device_version_t";
        prams.put("sql", sql);
        List<Map<String, Object>> list = commonService.executeSelectSQL(prams);
        List<String> li = new ArrayList<>();
        for (Map<String, Object> map : list) {
            li.add((String) map.get("device_version"));
        }
        return ResultVo.ok(li);
    }

    @Override
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

}

