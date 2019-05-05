package com.rainyhon.common.service;

import com.rainyhon.common.mapper.SrcRecordMapper;
import com.rainyhon.common.model.SrcRecord;
import com.rainyhon.common.model.SrcRecordExample;
import com.rainyhon.common.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SrcRecordService {

	@Autowired
	private SrcRecordMapper srcRecordMapper;


	public void add(SrcRecord srcRecord) {
		srcRecord.setId(CommonUtil.getUUID());
		srcRecord.setCreateTime(CommonUtil.getSystemDate());
		srcRecordMapper.insert(srcRecord);
	}

	public List<SrcRecord> getSrcRecord(String srcState) {
		SrcRecordExample example = new SrcRecordExample();
		SrcRecordExample.Criteria criteria = example.createCriteria();
		criteria.andSrcStateEqualTo(srcState);
		return srcRecordMapper.selectByExample(example);
	}

	public void update(SrcRecord srcRecord) {
		srcRecordMapper.updateByPrimaryKey(srcRecord);
	}

}

