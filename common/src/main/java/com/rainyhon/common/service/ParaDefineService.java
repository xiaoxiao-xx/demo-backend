package com.rainyhon.common.service;

import com.microcore.center.mapper.PsmParaDefineMapper;
import com.microcore.center.model.PsmParaDefine;
import com.microcore.center.model.PsmParaDefineExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParaDefineService {

	@Autowired
	private PsmParaDefineMapper psmParaDefineMapper;


	public List<PsmParaDefine> getPsmParaDefineByType(String type) {
		PsmParaDefineExample example = new PsmParaDefineExample();
		PsmParaDefineExample.Criteria criteria = example.createCriteria();
		criteria.andParaTypeEqualTo(type);
		return psmParaDefineMapper.selectByExample(example);
	}


	public PsmParaDefine getPsmParaDefineByTypeAnd(String type, String code) {
		PsmParaDefineExample example = new PsmParaDefineExample();
		PsmParaDefineExample.Criteria criteria = example.createCriteria();
		criteria.andParaTypeEqualTo(type);
		criteria.andParaCodeEqualTo(code);
		List<PsmParaDefine> list = psmParaDefineMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}


	public String getValueByTypeAnd(String type, String code) {
		PsmParaDefine psmParaDefine = getPsmParaDefineByTypeAnd(type, code);
		if (psmParaDefine != null) {
			return psmParaDefine.getParaValue();
		}
		return null;
	}

}

