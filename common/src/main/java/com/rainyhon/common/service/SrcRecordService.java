package com.rainyhon.common.service;

import com.microcore.center.mapper.PsmSrcRecordMapper;
import com.microcore.center.model.PsmSrcRecord;
import com.microcore.center.model.PsmSrcRecordExample;
import com.rainyhon.common.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SrcRecordService {

	@Autowired
	private PsmSrcRecordMapper psmSrcRecordMapper;


	public void add(PsmSrcRecord srcRecord) {
		srcRecord.setId(CommonUtil.getUUID());
		srcRecord.setCreateTime(CommonUtil.getSystemDate());
		psmSrcRecordMapper.insert(srcRecord);
	}

	public List<PsmSrcRecord> getPsmSrcRecord(String srcState) {
		PsmSrcRecordExample example = new PsmSrcRecordExample();
		PsmSrcRecordExample.Criteria criteria = example.createCriteria();
		criteria.andSrcStateEqualTo(srcState);
		return psmSrcRecordMapper.selectByExample(example);
	}

	public void update(PsmSrcRecord srcRecord) {
		psmSrcRecordMapper.updateByPrimaryKey(srcRecord);
	}

}

