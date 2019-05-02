package com.rainyhon.common.service;

import com.microcore.center.mapper.PsmFileMapper;
import com.microcore.center.model.PsmFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class FileService {

	@Autowired
	private PsmFileMapper psmFileMapper;

	public void add(PsmFile psmFile) {
		psmFileMapper.insert(psmFile);
	}

}
