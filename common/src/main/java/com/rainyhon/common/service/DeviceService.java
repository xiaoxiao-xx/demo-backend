package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.dto.DeviceDto;
import com.rainyhon.common.mapper.DeviceMapper;
import com.rainyhon.common.model.Device;
import com.rainyhon.common.model.DeviceExample;
import com.rainyhon.common.model.ParaDefine;
import com.rainyhon.common.vo.DeviceVo;
import com.rainyhon.common.vo.ResultVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rainyhon.common.constant.Constants.*;
import static com.rainyhon.common.util.CommonUtil.*;

@Service
@Transactional
public class DeviceService {

	@Autowired
	private DeviceMapper deviceMapper;

	@Autowired
	private ParaDefineService paraDefineService;

	@Autowired
	private DeviceVersionService deviceVersionService;

	@Autowired
	private OperHisService operHisService;

	@Autowired
	private CommonService commonService;

	@Data
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

	// TODO 在加入区域后彻底重写
	public String getDeviceLocation(Integer x, Integer y) {
		Point point = new Point(x, y);
		return getDeviceLocation(point, indexPageAreaList);
	}

	public PageInfo<DeviceDto> getDeviceList(String deviceId, String devtypeVal,
	                                         String state, Integer pageIndex, Integer pageSize) {
		DeviceExample example = new DeviceExample();
		DeviceExample.Criteria criteria = example.createCriteria();

		if (StringUtils.isNotEmpty(devtypeVal) && !"x".equals(devtypeVal)) {
			criteria.andDevtypeCodeEqualTo(devtypeVal.trim());
		}
		if (StringUtils.isNotEmpty(state) && !"a".equals(state)) {
			criteria.andStateEqualTo(state.trim());
		}

		PageInfo<Device> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> deviceMapper.selectByExample(example));

		List<DeviceDto> deviceDtoList = listPo2VO(pageInfo.getList(), DeviceDto.class);
		for (DeviceDto device : deviceDtoList) {
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

		PageInfo<DeviceDto> deviceDtoPageInfo = po2VO(pageInfo, PageInfo.class);
		deviceDtoPageInfo.setList(deviceDtoList);

		return deviceDtoPageInfo;
	}

	public String getDevtypeValByTypeCode(String typeCode) {
		return paraDefineService.getValueByTypeAnd(DEVICE_TYPE, typeCode);
	}

	public int getEnableDeviceCount() {
		Map<String, Object> params = new HashMap<>(3);
		String sql = "from device where state = 'E'";
		params.put("sql", sql);
		Long count = commonService.executeGetCount(params);
		return count.intValue();
	}

	public int getDisabledDeviceCount() {
		Map<String, Object> params = new HashMap<>(3);
		String sql = "from device where state = 'D'";
		params.put("sql", sql);
		Long count = commonService.executeGetCount(params);
		return count.intValue();
	}

	public void add(DeviceVo vo) {
		vo.setDeviceId(getUUID());
		vo.setState(DEVICE_STATE_ENABLE);
		deviceMapper.insert(vo);

		operHisService.add(vo.getDeviceId(), OPER_HIS_ADD);
	}

	public void delete(String deviceId) {
		deviceMapper.deleteByPrimaryKey(deviceId);
	}

	public void update(DeviceVo vo) {
		deviceMapper.updateByPrimaryKeySelective(vo);
		operHisService.add(vo.getDeviceId(), OPER_HIS_UPD);
	}

	public void setDeviceState(String deviceId, String state) {
		Device device = new Device();
		device.setDeviceId(deviceId);
		device.setState(state);
		deviceMapper.updateByPrimaryKeySelective(device);

		String operType = "";
		if ("E".equals(state)) {
			operType = OPER_HIS_ENABLE;
		} else if ("D".equals(state)) {
			operType = OPER_HIS_DISABLE;
		}
		operHisService.add(device.getDeviceId(), operType);
	}

	public List<ParaDefine> getDeviceTypes() {
		return paraDefineService.getParaDefineByType(DEVICE_TYPE);
	}

	public ResultVo batchDelete(String idList) {
		idList = idList.trim();
		if (StringUtils.isEmpty(idList)) {
			return ResultVo.ok();
		}

		String[] ids = idList.split(",");
		for (String i : ids) {
			deviceMapper.deleteByPrimaryKey(i);
		}

		return ResultVo.ok();
	}

}

