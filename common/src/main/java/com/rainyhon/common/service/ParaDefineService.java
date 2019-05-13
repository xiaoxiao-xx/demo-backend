package com.rainyhon.common.service;

import com.rainyhon.common.mapper.ParaDefineMapper;
import com.rainyhon.common.model.ParaDefine;
import com.rainyhon.common.model.ParaDefineExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParaDefineService {

	@Autowired
	private ParaDefineMapper paraDefineMapper;

	public List<ParaDefine> getParaDefineByType(String type) {
		ParaDefineExample example = new ParaDefineExample();
		ParaDefineExample.Criteria criteria = example.createCriteria();
		criteria.andParaTypeEqualTo(type);
		return paraDefineMapper.selectByExample(example);
	}

	public ParaDefine getParaDefineByTypeAnd(String type, String code) {
		ParaDefineExample example = new ParaDefineExample();
		ParaDefineExample.Criteria criteria = example.createCriteria();
		criteria.andParaTypeEqualTo(type);
		criteria.andParaCodeEqualTo(code);
		List<ParaDefine> list = paraDefineMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public String getValueByTypeAnd(String type, String code) {
		ParaDefine paraDefine = getParaDefineByTypeAnd(type, code);
		if (paraDefine != null) {
			return paraDefine.getParaValue();
		}
		return null;
	}

}

