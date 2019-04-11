package com.microcore.center.service.impl;

import com.microcore.center.service.CommonService;
import com.microcore.center.service.SummaryService;
import com.microcore.center.vo.DetailVo;
import com.microcore.center.vo.SummaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SummaryServiceImpl implements SummaryService {

	@Autowired
	private CommonService commonService;

	@Override
	public List<SummaryVo> getSummary(Integer pageIndex, Integer pageSize) {
//		commonService.executeSelectSQL();


		return null;
	}

	@Override
	public List<DetailVo> getDetailList(Integer pageIndex, Integer pageSize) {
		return null;
	}

}
