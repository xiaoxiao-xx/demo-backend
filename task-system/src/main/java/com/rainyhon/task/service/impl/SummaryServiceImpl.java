package com.rainyhon.task.service.impl;

import com.microcore.center.mapper.PsmDetailMapper;
import com.microcore.center.mapper.PsmSummaryMapper;
import com.microcore.center.model.PsmDetail;
import com.microcore.center.model.PsmSummary;
import com.rainyhon.task.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SummaryServiceImpl implements SummaryService {

	@Autowired
	private PsmSummaryMapper summaryMapper;

	@Autowired
	private PsmDetailMapper detailMapper;

	@Override
	public void addSummary(PsmSummary summary) {
		summaryMapper.insert(summary);
	}

	@Override
	public void addDetail(PsmDetail detail) {
		detailMapper.insert(detail);
	}

}

