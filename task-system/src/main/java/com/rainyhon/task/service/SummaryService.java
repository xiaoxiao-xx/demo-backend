package com.rainyhon.task.service;

import com.rainyhon.common.mapper.DetailMapper;
import com.rainyhon.common.mapper.SummaryMapper;
import com.rainyhon.common.model.Detail;
import com.rainyhon.common.model.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SummaryService {

	@Autowired
	private SummaryMapper summaryMapper;

	@Autowired
	private DetailMapper detailMapper;

	public void addSummary(Summary summary) {
		summaryMapper.insert(summary);
	}

	public void addDetail(Detail detail) {
		detailMapper.insert(detail);
	}

}

