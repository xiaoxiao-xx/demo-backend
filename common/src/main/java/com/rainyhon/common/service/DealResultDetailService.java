package com.rainyhon.common.service;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.mapper.DealResDetailMapper;
import com.rainyhon.common.model.DealResDetail;
import com.rainyhon.common.model.DealResDetailExample;
import com.rainyhon.common.vo.DealResDetailVo;
import com.rainyhon.common.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.rainyhon.common.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 素材处理结果明细服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DealResultDetailService {

	@Autowired
	private DealResDetailMapper dealResDetailMapper;

	public PageInfo<DealResDetailVo> getDealResultDetailList(String alarmType, Integer pageIndex, Integer pageSize) {
		DealResDetailExample example = new DealResDetailExample();
		DealResDetailExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(alarmType)) {
			criteria.andAlarmTypeEqualTo(alarmType);
		}

		PageInfo<DealResDetail> dealResDetailPageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dealResDetailMapper.selectByExample(example));

		List<DealResDetailVo> resVoList = CommonUtil.listPo2VO(dealResDetailPageInfo.getList(), DealResDetailVo.class);
		PageInfo<DealResDetailVo> resVoPageInfo = CommonUtil.po2VO(dealResDetailPageInfo, PageInfo.class);
		resVoPageInfo.setList(resVoList);
		return resVoPageInfo;
	}

	public ResultVo add(DealResDetailVo vo) {
		dealResDetailMapper.insert(vo);
		return ResultVo.ok();
	}

	public ResultVo delete(String id) {
		String[] ids = id.split(",");
		for (String i : ids) {
			dealResDetailMapper.deleteByPrimaryKey(i);
		}
		return ResultVo.ok();
	}

	public ResultVo update(DealResDetailVo vo) {
		dealResDetailMapper.updateByPrimaryKeySelective(vo);
		return ResultVo.ok();
	}

}


