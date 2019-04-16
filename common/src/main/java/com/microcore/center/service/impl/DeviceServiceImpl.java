package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.PsmDeviceDto;
import com.microcore.center.mapper.PsmDeviceMapper;
import com.microcore.center.model.PsmDevice;
import com.microcore.center.model.PsmDeviceExample;
import com.microcore.center.model.PsmParaDefine;
import com.microcore.center.service.DeviceService;
import com.microcore.center.service.DeviceVersionService;
import com.microcore.center.service.OperHisService;
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

import static com.microcore.center.constant.Constants.*;
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

    @Autowired
    private OperHisService operHisService;

    @Data
    @EqualsAndHashCode(callSuper = false)
    @Setter
    public static class Point {

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
    public static class Area {

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
        areaList.add(new Area("工作区", new Point(31, 41), new Point(107, 118)));
        areaList.add(new Area("会议室", new Point(560, 89), new Point(628, 143)));
        areaList.add(new Area("卫生间", new Point(634, 149), new Point(762, 197)));
        areaList.add(new Area("办公室入口", new Point(279, 82), new Point(451, 168)));
        areaList.add(new Area("总经理室", new Point(31, 129), new Point(107, 200)));
    }

    private List<Area> indexPageAreaList = new ArrayList<>(3);

    {
        indexPageAreaList.add(new Area("办公楼", new Point(58, 79), new Point(192, 230)));
        indexPageAreaList.add(new Area("少年宫", new Point(58, 250), new Point(194, 379)));
        indexPageAreaList.add(new Area("食堂", new Point(83, 16), new Point(455, 64)));
        indexPageAreaList.add(new Area("教学楼", new Point(467, 12), new Point(928, 58)));
        indexPageAreaList.add(new Area("厕所", new Point(1255, 71), new Point(1350, 131)));
        indexPageAreaList.add(new Area("教师宿舍", new Point(1062, 174), new Point(1190, 274)));
        indexPageAreaList.add(new Area("仓库", new Point(1270, 223), new Point(1400, 265)));
        indexPageAreaList.add(new Area("生物园地", new Point(1202, 287), new Point(1445, 372)));
        indexPageAreaList.add(new Area("篮球场", new Point(529, 155), new Point(852, 321)));
    }

    public String getDeviceLocation(Point point, List<Area> list) {
        Integer x = point.getX();
        Integer y = point.getY();

        for (Area area : list) {
            Point p1 = area.getP1();
            Point p2 = area.getP2();

            if (x >= p1.getX() && x <= p2.getX()
                    && y >= p1.getY() && y <= p2.getY()) {
                return area.getName();
            }
        }
        return "";
    }

    @Override
    public String getDeviceLocation(Integer x, Integer y) {
        Point point = new Point(x, y);
        return getDeviceLocation(point, indexPageAreaList);
    }

    public PageInfo<PsmDeviceDto> getDeviceList(String deviceId, String devtypeVal,
                                                String state, Integer pageIndex, Integer pageSize) {
        PsmDeviceExample example = new PsmDeviceExample();
        PsmDeviceExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(devtypeVal) && !"x".equals(devtypeVal)) {
            criteria.andDevtypeCodeEqualTo(devtypeVal.trim());
        }
        if (StringUtils.isNotEmpty(state) && !"a".equals(state)) {
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
            String location = getDeviceLocation(point, areaList);
            device.setDeviceLocation(location);

            // 设置DeviceVersion
            device.setDeviceVersion(deviceVersionService.getDeviceVersionStringById(device.getDeviceVersion()));

            // 转设备类型为中文
            device.setDevtypeVal(getDevtypeValByTypeCode(device.getDevtypeCode()));
        }

        PageInfo<PsmDeviceDto> deviceDtoPageInfo = po2VO(pageInfo, PageInfo.class);
        deviceDtoPageInfo.setList(deviceDtoList);

        return deviceDtoPageInfo;
    }

    @Override
    public String getDevtypeValByTypeCode(String typeCode) {
        return paraDefineService.getValueByTypeAnd(DEVICE_TYPE, typeCode);
    }

    @Override
    public void add(PsmDeviceVo vo) {
        vo.setDeviceId(getUUID());
        vo.setState(DEVICE_STATE_ENABLE);
        psmDeviceMapper.insert(vo);

        operHisService.add(vo.getDeviceId(), OPER_HIS_ADD);
    }

    @Override
    public void delete(String deviceId) {
        psmDeviceMapper.deleteByPrimaryKey(deviceId);
    }

    @Override
    public void update(PsmDeviceVo vo) {
        psmDeviceMapper.updateByPrimaryKeySelective(vo);
        operHisService.add(vo.getDeviceId(), OPER_HIS_UPD);
    }

    @Override
    public void setDeviceState(String deviceId, String state) {
        PsmDevice device = new PsmDevice();
        device.setDeviceId(deviceId);
        device.setState(state);
        psmDeviceMapper.updateByPrimaryKeySelective(device);

        String operType = "";
        if ("E".equals(state)) {
            operType = OPER_HIS_ENABLE;
        } else if ("D".equals(state)) {
            operType = OPER_HIS_DISABLE;
        }
        operHisService.add(device.getDeviceId(), operType);
    }

    @Override
    public List<PsmParaDefine> getDeviceTypes() {
        return paraDefineService.getPsmParaDefineByType(DEVICE_TYPE);
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
