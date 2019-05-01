package com.rainyhon.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.PsmSrcRecordMapper;
import com.microcore.center.model.PsmSrcRecord;
import com.microcore.center.model.PsmSrcRecordExample;
import com.rainyhon.common.service.SrcRecordService;
import com.rainyhon.common.util.CommonUtil;

@Service
@Transactional(rollbackFor = Exception.class)
public class SrcRecordServiceImpl implements SrcRecordService {

	@Autowired
	private PsmSrcRecordMapper psmSrcRecordMapper;

	@Override
	public void add(PsmSrcRecord srcRecord) {
		srcRecord.setId(CommonUtil.getUUID());
		srcRecord.setCreateTime(CommonUtil.getSystemDate());
		psmSrcRecordMapper.insert(srcRecord);
	}

	@Override
	public List<PsmSrcRecord> getPsmSrcRecord(String srcState) {
		PsmSrcRecordExample example = new PsmSrcRecordExample();
		PsmSrcRecordExample.Criteria criteria = example.createCriteria();
		criteria.andSrcStateEqualTo(srcState);
		return psmSrcRecordMapper.selectByExample(example);
	}

	@Override
	public void update(PsmSrcRecord srcRecord) {
		psmSrcRecordMapper.updateByPrimaryKey(srcRecord);
	}

}
