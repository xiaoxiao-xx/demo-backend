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

import java.util.*;

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

	/**
	 * 获取机构树
	 *
	 * @return
	 */
	public ResultVo<?> getOrgTree() {
		OrgVo rootOrg = getRootOrg();
		if (rootOrg == null) {
			throw new CommonException(CommonExceptionType.GET_ROOT_ORG_FAILED);
		}

		List<OrgVo> children = getChildren(rootOrg.getId());
		rootOrg.setChildren(children);
		return ResultVo.ok(rootOrg);
	}

	/**
	 * 获取一个机构以及它所有子机构的ID列表
	 */
	public List<String> getChildrenOrgList(String orgId) {
		List<String> result = new ArrayList<>();
		result.add(orgId);

		List<OrgVo> children = getChildren(orgId);
		if (children == null) {
			return result;
		}

		List<String> list = getChildOrgList(children);
		if (list != null) {
			result.addAll(list);
		}

		return result;
	}

	private List<String> getChildOrgList(List<OrgVo> children) {
		if (CommonUtil.isEmpty(children)) {
			return null;
		}

		List<String> result = new ArrayList<>();

		children.forEach(child -> {
			List<OrgVo> voList = child.getChildren();
			List<String> t = getChildOrgList(voList);
			if (t != null) {
				result.addAll(t);
			}

			result.add(child.getId());
		});

		return result;
	}

	/**
	 * 递归获取子机构
	 *
	 * @param parentId
	 * @return
	 */
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

	/**
	 * 获取根机构
	 * 注意：在一个系统中只能有一个根机构
	 */
	private OrgVo getRootOrg() {
		OrgExample example = new OrgExample();
		OrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		// 根机构的父ID为空
		criteria.andParentIdIsNull();
		List<Org> orgList = orgMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(orgList)) {
			return CommonUtil.po2VO(orgList.get(0), OrgVo.class);
		}

		return null;
	}

	/**
	 * 获取一个机构的所有父机构ID列表
	 *
	 * @param orgId 机构ID
	 * @return 父机构ID列表
	 */
	public List<String> findAllParents(String orgId) {
		List<OrgVo> allOrgs = getAllOrgs();
		Map<String, String> orgMap = getOrgMap(allOrgs);

		List<String> parentList = new ArrayList<>();
		String parentOrgId = getParentOrgId(orgMap, orgId);
		while (parentOrgId != null) {
			parentList.add(parentOrgId);
			parentOrgId = getParentOrgId(orgMap, parentOrgId);
		}

		Collections.reverse(parentList);
		return parentList;
	}

	/**
	 * 获取 Map<机构ID-父机构ID>
	 */
	private Map<String, String> getOrgMap(List<OrgVo> voList) {
		Map<String, String> map = new HashMap<>();
		voList.forEach(orgVo -> map.put(orgVo.getId(), orgVo.getParentId()));
		return map;
	}

	/**
	 * 获取父机构ID
	 */
	private String getParentOrgId(Map<String, String> orgMap, String id) {
		return orgMap.get(id);
	}

	/**
	 * 根据机构ID获取机构名
	 *
	 * @param orgId 机构ID
	 * @return 机构名
	 */
	public String getOrgNameById(String orgId) {
		Org org = getOrgById(orgId);
		if (org == null) {
			return "";
		}
		return Optional.ofNullable(org.getOrgName()).orElse("");
	}

}

