package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmRollCallMapper;
import com.microcore.center.model.PsmRollCall;
import com.microcore.center.model.PsmRollCallExample;
import com.rainyhon.common.mapper.RollCallResultMapper;
import com.rainyhon.common.model.RollCallResult;
import com.rainyhon.common.model.RollCallResultExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.RollCallResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RollCallService {

	@Autowired
	private RollCallResultMapper rollCallResultMapper;

	public PageInfo<RollCallResultVo> getRollCallResultList(String orgId, String personId,
	                                                        Integer pageIndex, Integer pageSize) {

		RollCallResultExample example = new RollCallResultExample();
		RollCallResultExample.Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(orgId)) {
			criteria.andOrgIdEqualTo(orgId.trim());
		}

		if (StringUtils.isNotBlank(personId)) {
			criteria.andPersonIdEqualTo(personId.trim());
		}

		PageInfo<RollCallResult> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> rollCallResultMapper.selectByExample(example));

		PageInfo<RollCallResultVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		List<RollCallResultVo> voList = CommonUtil.listPo2VO(pageInfo.getList(), RollCallResultVo.class);
		voPageInfo.setList(voList);

		return voPageInfo;
	}

	public List<RollCallResult> getRollCallResultList(String detailId, String personId) {
		RollCallResultExample example = new RollCallResultExample();
		RollCallResultExample.Criteria criteria = example.createCriteria();
		criteria.andDetailIdEqualTo(detailId);
		criteria.andPersonIdEqualTo(personId);
		return rollCallResultMapper.selectByExample(example);
	}

	@Autowired
	private PsmRollCallMapper rollCallMapper;

	public PageInfo<PsmRollCall> getRollCall(Integer pageIndex, Integer pageSize) {
		PsmRollCallExample example = new PsmRollCallExample();
		PsmRollCallExample.Criteria criteria = example.createCriteria();
		PageInfo<PsmRollCall> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> rollCallMapper.selectByExample(example));
		return pageInfo;
	}

	public void updateRollCall(RollCallResult result) {
		rollCallResultMapper.updateByPrimaryKeySelective(result);
	}

}

