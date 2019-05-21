package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.AreaDef;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.GuestAreaMapper;
import com.rainyhon.common.mapper.GuestMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.DeleteVo;
import com.rainyhon.common.vo.GuestAreaVo;
import com.rainyhon.common.vo.GuestVo;
import com.rainyhon.common.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.github.pagehelper.page.PageMethod.startPage;
import static com.rainyhon.common.constant.AreaDef.getAreaNameById;
import static com.rainyhon.common.constant.Constants.CERTIFICATE_TYPE;
import static com.rainyhon.common.constant.Constants.DELETE_STATUS_YES;
import static com.rainyhon.common.util.CommonUtil.listPo2VO;

@Service
@Transactional(rollbackFor = Exception.class)
public class GuestService {

	@Autowired
	private GuestMapper guestMapper;

	@Autowired
	private GuestAreaMapper guestAreaMapper;

	@Autowired
	private ParaDefineService paraDefineService;
	@Autowired
	private OrgService orgService;

	public ResultVo addGuest(GuestVo vo) {
		String id = CommonUtil.getUUID();
		vo.setId(id);
		EntityUtils.setCreateAndUpdateInfo(vo);
		guestMapper.insert(vo);

		addGuestAreaList(vo);

		return ResultVo.ok();
	}

	private void addGuestAreaList(GuestVo vo) {
		List<String> areaList = vo.getAreaList();
		if (CommonUtil.isNotEmpty(areaList)) {
			areaList.forEach(areaId -> addGuestArea(vo.getId(), areaId));
		}
	}

	private void addGuestArea(String guestId, String areaId) {
		GuestArea guestArea = new GuestArea();
		guestArea.setId(CommonUtil.getUUID());
		guestArea.setGuestId(guestId);
		guestArea.setAreaId(areaId);
		guestAreaMapper.insert(guestArea);
	}

	public ResultVo batchDelete(DeleteVo vo) {
		batchDelete(vo.getIdList());
		return ResultVo.ok();
	}

	private ResultVo delete(String id) {
		Guest guest = new Guest();
		guest.setId(id);
		guest.setDelStatus(DELETE_STATUS_YES);
		guestMapper.updateByPrimaryKeySelective(guest);

		deleteGuestAreaByGuestId(id);

		return ResultVo.ok();
	}

	private void batchDelete(List<String> idList) {
		if (CommonUtil.isEmpty(idList)) {
			return;
		}

		idList.forEach(this::delete);
	}

	private void deleteGuestAreaByGuestId(String guestId) {
		GuestAreaExample example = new GuestAreaExample();
		GuestAreaExample.Criteria criteria = example.createCriteria();
		criteria.andGuestIdEqualTo(guestId);
		guestAreaMapper.deleteByExample(example);
	}

	public ResultVo<?> getCardTypes() {
		List<ParaDefine> paraDefineList = paraDefineService.getParaDefineByType(CERTIFICATE_TYPE);
		return ResultVo.ok(paraDefineList);
	}

	public void update(GuestVo vo) {
		String id = vo.getId();
		EntityUtils.setUpdateInfo(vo);
		guestMapper.updateByPrimaryKeySelective(vo);

		deleteGuestAreaByGuestId(id);
		addGuestAreaList(vo);
	}

	public ResultVo<PageInfo> getGuestList(String name, String cardType, String targetAreaId,
	                                       String targetOrgId, Date startTime, Date endTime,
	                                       Integer pageIndex, Integer pageSize) {

		GuestExample example = new GuestExample();
		GuestExample.Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(name)) {
			criteria.andCardTypeEqualTo(name);
		}

		if (StringUtils.isNotBlank(cardType)) {
			criteria.andCardTypeEqualTo(cardType);
		}

		if (StringUtils.isNotBlank(targetAreaId)) {
			criteria.andIdIn(getIdListByAreaId(targetAreaId));
		}

		if (StringUtils.isNotBlank(targetOrgId)) {
			criteria.andCardTypeEqualTo(targetOrgId);
		}

		// 必须选一个时间段，起始时间都不可以为空
		if (startTime != null && endTime != null) {
			criteria.andStartTimeLessThanOrEqualTo(startTime);
			criteria.andEndTimeGreaterThanOrEqualTo(endTime);
		}

		PageInfo<Guest> pageInfo = startPage(pageIndex, pageSize).doSelectPageInfo(() -> {
			guestMapper.selectByExample(example);
		});

		List<Guest> list = pageInfo.getList();
		List<GuestVo> voList = listPo2VO(list, GuestVo.class);
		if (CommonUtil.isNotEmpty(voList)) {
			voList.forEach(vo -> {
				vo.setCardTypeName(paraDefineService.getValueByTypeAnd(CERTIFICATE_TYPE, vo.getCardType()));
				vo.setTargetOrgName(orgService.getOrgNameById(vo.getTargetOrgId()));
				vo.setAreaVoList(getGuestAreaVoList(vo.getId()));
			});
		}

		PageInfo<GuestVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);

		return ResultVo.ok(voPageInfo);
	}

	private List<String> getIdListByAreaId(String areaId) {
		GuestAreaExample example = new GuestAreaExample();
		GuestAreaExample.Criteria criteria = example.createCriteria();
		criteria.andAreaIdEqualTo(areaId);
		List<GuestArea> guestAreaList = guestAreaMapper.selectByExample(example);
		return guestAreaList.stream().map(GuestArea::getGuestId).filter(Objects::nonNull).collect(Collectors.toList());
	}

	private List<GuestAreaVo> getGuestAreaVoList(String guestId) {
		GuestAreaExample example = new GuestAreaExample();
		GuestAreaExample.Criteria criteria = example.createCriteria();
		criteria.andGuestIdEqualTo(guestId);
		List<GuestArea> guestAreaList = guestAreaMapper.selectByExample(example);
		List<GuestAreaVo> guestAreaVoList = listPo2VO(guestAreaList, GuestAreaVo.class);
		guestAreaVoList.forEach(vo -> {
			vo.setAreaName(getAreaNameById(vo.getAreaId()));
		});

		return guestAreaVoList;
	}

}
