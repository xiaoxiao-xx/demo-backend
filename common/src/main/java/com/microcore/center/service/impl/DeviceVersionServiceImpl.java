package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmDeviceVersionMapper;
import com.microcore.center.model.PsmDeviceVersion;
import com.microcore.center.model.PsmDeviceVersionExample;
import com.microcore.center.service.CommonService;
import com.microcore.center.service.DeviceService;
import com.microcore.center.service.DeviceVersionService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.DeviceVersionVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.microcore.center.util.CommonUtil.getUUID;

@Service
@Transactional
public class DeviceVersionServiceImpl implements DeviceVersionService {

    @Autowired
    private PsmDeviceVersionMapper deviceVersionMapper;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private CommonService commonService;

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
        // 按类型查
        if (StringUtils.isNotEmpty(type) && !"x".equals(type)) {
            criteria.andDevtypeCodeEqualTo(type);
        }
        // 按型号的ID查
        if (StringUtils.isNotEmpty(version) && !"xt".equals(version)) {
            criteria.andDevversionIdEqualTo(version);
        }

        PageInfo<PsmDeviceVersion> pageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> deviceVersionMapper.selectByExample(example));

        List<PsmDeviceVersion> list = pageInfo.getList();
        if (CommonUtil.isNotEmpty(list)) {
            list.forEach(device -> {
                // 转设备类型为中文
                device.setDevtypeVal(deviceService.getDevtypeValByTypeCode(device.getDevtypeCode()));
            });
        }

        return ResultVo.ok(pageInfo);
    }

    @Override
    public ResultVo getDeviceVersion(String id) {
        return ResultVo.ok(getDeviceVersionById(id));
    }

    @Override
    public PsmDeviceVersion getDeviceVersionById(String id) {
        return deviceVersionMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultVo getVersion(String devTypeCode) {
        Map<String, Object> prams = new HashMap<>();
        String sql = "select * from psm_device_version_t "
                + "where devtype_code = #{devTypeCode} "
                + "group by device_version";
        prams.put("sql", sql);
        prams.put("devTypeCode", devTypeCode);
        List<Map<String, Object>> list = commonService.executeSelectSQL(prams);
        return ResultVo.ok(list);
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

    @Override
    public String getDeviceVersionStringById(String id) {
        PsmDeviceVersion deviceVersion = getDeviceVersionById(id);
        if (deviceVersion == null) {
            return "";
        }
        return deviceVersion.getDeviceVersion();
    }

}

