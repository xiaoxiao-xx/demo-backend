package com.microcore.center.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbOrg;
import com.microcore.center.mapper.DbAreaMapper;
import com.microcore.center.model.DbArea;
import com.microcore.center.model.DbAreaExample;
import com.microcore.center.service.DbAreaService;
import com.microcore.center.service.DbOrgAreaService;
import com.microcore.center.vo.DbAreaVo;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.StringUtil;

@Transactional
@Service
public class DbAreaServiceImpl implements DbAreaService {

	@Autowired
	private DbOrgAreaService dbOrgAreaService;

	@Autowired
	private DbAreaMapper dbAreaMapper;

	@Override
	public PageInfo<DbAreaVo> areaList(String id, String areaName, Integer pageIndex, Integer pageSize) {
		DbAreaExample example = new DbAreaExample();
		DbAreaExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(id)) {
			criteria.andIdEqualTo(id);
		}
		if (StringUtil.isNotEmpty(areaName)) {
			criteria.andAreaNameLike("%" + areaName.trim() + "%");
		}
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		PageInfo<DbArea> dbAreaPageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbAreaMapper.selectByExample(example));
		PageInfo<DbAreaVo> dbAreaVoPageInfo = CommonUtil.po2VO(dbAreaPageInfo, PageInfo.class);
		List<DbAreaVo> listVo = CommonUtil.listPo2VO(dbAreaPageInfo.getList(), DbAreaVo.class);
		if (!CommonUtil.isEmpty(listVo)) {
			for (DbAreaVo dbAreaVo : listVo) {
				List<DbOrg> listDbOrg = dbOrgAreaService.getDbOrgByAreaId(dbAreaVo.getId());
				dbAreaVo.setListDbOrg(listDbOrg);
			}
		}
		dbAreaVoPageInfo.setList(listVo);
		return dbAreaVoPageInfo;
	}

	@Override
	public void add(DbAreaVo dbAreaVo) {
		DbArea dbArea = CommonUtil.po2VO(dbAreaVo, DbArea.class);
		dbArea.setId(CommonUtil.getUUID());
		dbArea.setKeyValue(CommonUtil.getUUID());
		dbArea.setAreaType("NOR");
		EntityUtils.setCreateInfo(dbArea);
		dbOrgAreaService.addAreaRel(dbArea.getId(), dbAreaVo.getOrgIds());
		dbAreaMapper.insert(dbArea);
	}

	@Override
	public void update(DbAreaVo dbAreaVo) {
		DbArea dbArea = dbAreaMapper.selectByPrimaryKey(dbAreaVo.getId());
		EntityUtils.setUpdateInfo(dbArea);
		dbArea.setAreaName(dbAreaVo.getAreaName());
		dbArea.setRemark(dbAreaVo.getRemark());
		dbArea.setStatus(dbAreaVo.getStatus());
		dbOrgAreaService.addAreaRel(dbAreaVo.getId(), dbAreaVo.getOrgIds());
		dbAreaMapper.updateByPrimaryKey(dbArea);

	}

	@Override
	public void delete(String id) {
		DbArea dbArea = dbAreaMapper.selectByPrimaryKey(id);
		EntityUtils.setUpdateInfo(dbArea);
		dbArea.setDelStatus(Constants.DEL_STATUS_DEL);
		dbAreaMapper.updateByPrimaryKey(dbArea);
	}

	@Override
	public DbArea getDbAreaById(String id) {
		return dbAreaMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DbArea> list() {
		DbAreaExample example = new DbAreaExample();
		DbAreaExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		criteria.andAreaTypeEqualTo("NOR");
		return dbAreaMapper.selectByExample(example);
	}

	@Override
	public String getAreaNameByAreaId(String areaId) {
		DbArea dbArea = Optional.ofNullable(getDbAreaById(areaId)).orElse(new DbArea());
		return Optional.ofNullable(dbArea.getAreaName()).orElse("");
	}
}

