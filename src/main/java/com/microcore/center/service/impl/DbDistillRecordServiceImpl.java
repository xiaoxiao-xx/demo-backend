package com.microcore.center.service.impl;

import com.microcore.center.mapper.DbDistillRecordMapper;
import com.microcore.center.model.DbDistillRecord;
import com.microcore.center.service.DbDistillRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DbDistillRecordServiceImpl implements DbDistillRecordService {

	@Autowired
	private DbDistillRecordMapper dbDistillRecordMapper;

	@Override
	public void addDbDistillRecord(DbDistillRecord dbDistillRecord) {
		dbDistillRecordMapper.insert(dbDistillRecord);
	}

}

