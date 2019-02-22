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
import com.microcore.center.service.DeviceVersionService;
import com.microcore.center.service.ParaDefineService;
import com.microcore.center.vo.PsmDeviceVo;
import com.microcore.center.vo.ResultVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
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

    @Autowired
    private DeviceVersionService deviceVersionService;

    @Data
    @EqualsAndHashCode(callSuper = false)
    @Setter
    private static class Point {

        Point() {
        }

        Point(Integer x, Integer y) {
            setX(x);
            setY(y);
        }

        /**
         * X坐标
         */
        private Integer x;

        /**
         * Y坐标
         */
        private Integer y;
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    private static class Area {

        Area() {
        }

        Area(String name, Point p1, Point p2) {
            setName(name);
            setP1(p1);
            setP2(p2);
        }

        /**
         * 区域名
         */
        private String name;

        /**
         * 左上角坐标
         */
        private Point p1;

        /**
         * 右下角坐标
         */
        private Point p2;
    }

    private List<Area> areaList = new ArrayList<>(3);

    {
        areaList.add(new Area("办公楼", new Point(31, 41), new Point(107, 118)));
        areaList.add(new Area("教师宿舍", new Point(560, 89), new Point(628, 143)));
        areaList.add(new Area("生物园地", new Point(634, 149), new Point(762, 197)));
        areaList.add(new Area("篮球场", new Point(279, 82), new Point(451, 168)));
        areaList.add(new Area("少年宫", new Point(31, 129), new Point(107, 200)));
    }

    private String getDeviceLocation(Point point) {
        Integer x = point.getX();
        Integer y = point.getY();

        for (Area area : areaList) {
            Point p1 = area.getP1();
            Point p2 = area.getP2();

            if (x >= p1.getX() && x <= p2.getX()
                    && y >= p1.getY() && y <= p2.getY()) {
                return area.getName();
            }
        }
        return "";
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
        for (PsmDeviceDto device : deviceDtoList) {
            // 设置DeviceLocation
            String xy = device.getPositionXy();
            String[] xys = xy.split(",");
            Integer x = Integer.parseInt(xys[0]);
            Integer y = Integer.parseInt(xys[1]);
            Point point = new Point(x, y);
            String location = getDeviceLocation(point);
            device.setDeviceLocation(location);

            // 设置DeviceVersion
            device.setDeviceVersion(deviceVersionService.getDeviceVersionStringById(device.getDeviceVersion()));
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

