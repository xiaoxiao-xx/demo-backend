package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.constant.Constants;
import com.microcore.center.mapper.OrgMapper;
import com.microcore.center.model.Org;
import com.microcore.center.model.OrgExample;
import com.microcore.center.service.OrgService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.EntityUtils;
import com.microcore.center.vo.OrgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgMapper orgMapper;

	@Override
	public void addOrg(Org org) {
		org.setId(CommonUtil.getUUID());
		EntityUtils.setCreateAndUpdateInfo(org);
		orgMapper.insert(org);
	}

	@Override
	public void deleteOrgById(String id) {
		Org org = new Org();
		org.setId(id);
		org.setDelStatus(Constants.DELETE_STATUS_NO);
		orgMapper.updateByPrimaryKeySelective(org);
	}

	@Override
	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> {
				orgMapper.deleteByPrimaryKey(id);
			});
		}
	}

	@Override
	public void updateOrg(Org org) {
		orgMapper.updateByPrimaryKeySelective(org);
	}

	@Override
	public Org getOrgById(String id) {
		return orgMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<OrgVo> getOrgList(Integer pageIndex, Integer pageSize) {
		OrgExample example = new OrgExample();
		OrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);

		PageInfo<Org> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> orgMapper.selectByExample(example));

		List<OrgVo> voList = CommonUtil.listPo2VO(pageInfo.getList(), OrgVo.class);
		PageInfo<OrgVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return voPageInfo;
	}

}
