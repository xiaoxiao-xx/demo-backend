package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.model.PsmDeviceVersion;
import com.microcore.center.model.PsmDeviceVersionExample;
import com.rainyhon.common.mapper.DynamicQueryMapper;
import com.rainyhon.common.model.DynamicQuery;
import com.rainyhon.common.model.DynamicQueryExample;
import com.rainyhon.common.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicQueryService {

	@Autowired
	private DynamicQueryMapper mapper;

	public ResultVo page(String viewDisplayName,Integer pageIndex, Integer pageSize){
		DynamicQueryExample example = new DynamicQueryExample();
		DynamicQueryExample.Criteria criteria = example.createCriteria();
		// 模糊查询视图名称
		if (StringUtils.isNotEmpty(viewDisplayName)) {
			criteria.andViewDisplayNameLike(viewDisplayName);
		}
		example.setOrderByClause("create_time desc");
		PageInfo<PsmDeviceVersion> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> mapper.selectByExample(example));

		return ResultVo.ok(pageInfo);
	}

}