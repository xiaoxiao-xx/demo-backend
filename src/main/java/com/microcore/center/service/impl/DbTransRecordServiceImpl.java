package com.microcore.center.service.impl;

import com.microcore.center.mapper.DbTransRecordMapper;
import com.microcore.center.model.DbTransRecord;
import com.microcore.center.service.DbTransRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DbTransRecordServiceImpl implements DbTransRecordService {

	@Autowired
	private DbTransRecordMapper dbTransRecordMapper;

	@Override
	public void addDbTransRecord(DbTransRecord dbTransRecord) {
		dbTransRecordMapper.insert(dbTransRecord);
	}

}

