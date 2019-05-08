package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.PermissionResourceRelationMapper;
import com.rainyhon.common.mapper.ResourceMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.rainyhon.common.util.CommonUtil.po2VO;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	public void addResource(Resource resource) {
		resource.setId(CommonUtil.getUUID());
		EntityUtils.setCreateAndUpdateInfo(resource);
		resourceMapper.insert(resource);
	}

	public void deleteResourceById(String id) {
		Resource resource = new Resource();
		resource.setId(id);
		resource.setDelStatus(Constants.DELETE_STATUS_NO);
		resourceMapper.updateByPrimaryKeySelective(resource);
	}

	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> {
				resourceMapper.deleteByPrimaryKey(id);
			});
		}
	}

	public void updateResource(Resource resource) {
		resourceMapper.updateByPrimaryKeySelective(resource);
	}

	public Resource getResourceById(String id) {
		return resourceMapper.selectByPrimaryKey(id);
	}

	public PageInfo<ResourceVo> getResourceList(Integer pageIndex, Integer pageSize) {
		ResourceExample example = new ResourceExample();
		ResourceExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);

		PageInfo<Resource> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> resourceMapper.selectByExample(example));

		List<ResourceVo> voList = CommonUtil.listPo2VO(pageInfo.getList(), ResourceVo.class);
		PageInfo<ResourceVo> voPageInfo = po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return voPageInfo;
	}

	public ResourceVo getResourceVoById(String id) {
		Resource resource = resourceMapper.selectByPrimaryKey(id);
		return CommonUtil.po2VO(resource, ResourceVo.class);
	}

	public List<ResourceVo> getAllResources() {
		ResourceExample example = new ResourceExample();
		ResourceExample.Criteria criteria = example.createCriteria();
		List<Resource> list = resourceMapper.selectByExample(example);

		List<ResourceVo> voList = CommonUtil.listPo2VO(list, ResourceVo.class);
		return voList;
	}

	@Autowired
	private PermissionResourceRelationMapper permissionResourceRelationMapper;

	public List<ResourceVo> getResourcesByPermissionId(String id) {
		PermissionResourceRelationExample example = new PermissionResourceRelationExample();
		PermissionResourceRelationExample.Criteria criteria = example.createCriteria();
		criteria.andPermissionIdEqualTo(id);
		List<PermissionResourceRelation> list = permissionResourceRelationMapper.selectByExample(example);
		List<ResourceVo> voList = new ArrayList<>();
		list.forEach(relation -> {
			Resource permission = getResourceById(relation.getResourceId());
			ResourceVo permissionVo = po2VO(permission, ResourceVo.class);
			voList.add(permissionVo);
		});

		return voList;
	}

}
