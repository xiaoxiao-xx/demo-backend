package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.constant.Constants;
import com.microcore.center.mapper.ResourceMapper;
import com.microcore.center.model.Resource;
import com.microcore.center.model.ResourceExample;
import com.microcore.center.service.ResourceService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.EntityUtils;
import com.microcore.center.vo.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public void addResource(Resource resource) {
		resource.setId(CommonUtil.getUUID());
		EntityUtils.setCreateAndUpdateInfo(resource);
		resourceMapper.insert(resource);
	}

	@Override
	public void deleteResourceById(String id) {
		Resource resource = new Resource();
		resource.setId(id);
		resource.setDelStatus(Constants.DELETE_STATUS_NO);
		resourceMapper.updateByPrimaryKeySelective(resource);
	}

	@Override
	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> {
				resourceMapper.deleteByPrimaryKey(id);
			});
		}
	}

	@Override
	public void updateResource(Resource resource) {
		resourceMapper.updateByPrimaryKeySelective(resource);
	}

	@Override
	public Resource getResourceById(String id) {
		return resourceMapper.selectByPrimaryKey(id);
	}

	@Override
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

}
