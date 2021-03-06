package com.rainyhon.common.service;

import com.rainyhon.common.mapper.FileMapper;
import com.rainyhon.common.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class FileService {

	@Autowired
	private FileMapper fileMapper;

	public void add(File file) {
		fileMapper.insert(file);
	}

}
