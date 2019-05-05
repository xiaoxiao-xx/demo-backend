package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.ResourceMapper;
import com.rainyhon.common.model.Resource;
import com.rainyhon.common.model.ResourceExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
		PageInfo<ResourceVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return voPageInfo;
	}

	public List<ResourceVo> getAllResources() {
		ResourceExample example = new ResourceExample();
		ResourceExample.Criteria criteria = example.createCriteria();
		List<Resource> list = resourceMapper.selectByExample(example);

		List<ResourceVo> voList = CommonUtil.listPo2VO(list, ResourceVo.class);
		return voList;
	}

}
