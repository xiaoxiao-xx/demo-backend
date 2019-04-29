package com.rainyhon.common.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microcore.center.mapper.PsmFileMapper;
import com.microcore.center.model.PsmFile;
import com.rainyhon.common.service.FileService;

@Service
@Transactional(rollbackFor = Exception.class)
public class FileServiceImpl implements FileService {

	@Autowired
	private PsmFileMapper psmFileMapper;

	@Override
	public void add(PsmFile psmFile) {
		psmFileMapper.insert(psmFile);
	}

}