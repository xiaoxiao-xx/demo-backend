package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.Resource;
import com.microcore.center.vo.ResourceVo;

import java.util.List;

public interface ResourceService {

	void addResource(Resource resource);

	void deleteResourceById(String id);

	void batchDelete(List<String> idList);

	void updateResource(Resource resource);

	Resource getResourceById(String id);

	PageInfo<ResourceVo> getResourceList(Integer pageIndex, Integer pageSize);

}
