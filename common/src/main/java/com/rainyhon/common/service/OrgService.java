package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.OrgMapper;
import com.rainyhon.common.model.Org;
import com.rainyhon.common.model.OrgExample;
import com.rainyhon.common.exception.CommonException;
import com.rainyhon.common.exception.CommonExceptionType;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.OrgVo;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrgService {

	@Autowired
	private OrgMapper orgMapper;

	public void addOrg(Org org) {
		org.setId(CommonUtil.getUUID());
		EntityUtils.setCreateAndUpdateInfo(org);
		orgMapper.insert(org);
	}

	public void deleteOrgById(String id) {
		Org org = new Org();
		org.setId(id);
		org.setDelStatus(Constants.DELETE_STATUS_NO);
		orgMapper.updateByPrimaryKeySelective(org);
	}

	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> {
				orgMapper.deleteByPrimaryKey(id);
			});
		}
	}

	public void updateOrg(Org org) {
		orgMapper.updateByPrimaryKeySelective(org);
	}

	public Org getOrgById(String id) {
		return orgMapper.selectByPrimaryKey(id);
	}

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

	public List<OrgVo> getAllOrgs() {
		OrgExample example = new OrgExample();
		OrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);

		List<Org> list = orgMapper.selectByExample(example);
		List<OrgVo> voList = CommonUtil.listPo2VO(list, OrgVo.class);
		return voList;
	}

	public ResultVo<?> getOrgTree() {
		OrgVo rootOrg = getRootOrg();
		if (rootOrg == null) {
			throw new CommonException(CommonExceptionType.GET_ROOT_ORG_FAILED);
		}

		List<OrgVo> children = getChildren(rootOrg.getId());
		rootOrg.setChildren(children);
		return ResultVo.ok(rootOrg);
	}

	private List<OrgVo> getChildren(String parentId) {
		List<OrgVo> children = getChildrenByParentId(parentId);

		if (CommonUtil.isEmpty(children)) {
			return null;
		}

		children.forEach(child -> child.setChildren(getChildren(child.getId())));

		return children;
	}

	private List<OrgVo> getChildrenByParentId(String parentId) {
		OrgExample example = new OrgExample();
		OrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		criteria.andParentIdEqualTo(parentId);
		List<Org> orgList = orgMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(orgList)) {
			return CommonUtil.listPo2VO(orgList, OrgVo.class);
		}

		return null;
	}

	private OrgVo getRootOrg() {
		OrgExample example = new OrgExample();
		OrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		criteria.andParentIdIsNull();
		List<Org> orgList = orgMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(orgList)) {
			return CommonUtil.po2VO(orgList.get(0), OrgVo.class);
		}

		return null;
	}

	public String getOrgNameById(String orgId) {
		Org org = getOrgById(orgId);
		if (org == null) {
			return "";
		}
		return Optional.ofNullable(org.getOrgName()).orElse("");
	}

}

