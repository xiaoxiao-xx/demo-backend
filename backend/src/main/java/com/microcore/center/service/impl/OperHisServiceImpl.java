package com.microcore.center.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.PsmOperHisMapper;
import com.microcore.center.model.PsmOperHis;
import com.microcore.center.model.PsmOperHisExample;
import com.microcore.center.service.OperHisService;
import com.microcore.center.service.ParaDefineService;
import com.microcore.center.service.UserService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmOperHisVo;

@Service
@Transactional
public class OperHisServiceImpl implements OperHisService {

	@Autowired
	private PsmOperHisMapper psmOperHisMapper;

	@Autowired
	private ParaDefineService paraDefineService;

	@Autowired
	private UserService userService;

	@Override
	public void add(String operTarget, String operType) {
		PsmOperHis operHis = new PsmOperHis();
		operHis.setId(CommonUtil.getUUID());
		operHis.setOperator(CommonUtil.getCurrentUserId());
		operHis.setOperTarget(operTarget);
		operHis.setOperType(operType);
		operHis.setOperTime(CommonUtil.getCurrentTime());
		psmOperHisMapper.insert(operHis);
	}

	@Override
	public void add(PsmOperHis psmOperHis) {
		add(psmOperHis.getOperTarget(), psmOperHis.getOperType());
	}

	@Override
	public List<PsmOperHisVo> getPsmOperHis(String operTarget) {
		PsmOperHisExample example = new PsmOperHisExample();
		PsmOperHisExample.Criteria criteria = example.createCriteria();
		criteria.andOperTargetEqualTo(operTarget);
		List<PsmOperHisVo> listVo = CommonUtil.listPo2VO(psmOperHisMapper.selectByExample(example), PsmOperHisVo.class);
		for (PsmOperHisVo psmOperHisVo : listVo) {
			psmOperHisVo.setOperTypeName(paraDefineService.getValueByTypeAnd("OPER_TYPE", psmOperHisVo.getOperType()));
			psmOperHisVo.setOperatorName(userService.getPsmUserRealName(psmOperHisVo.getOperator()));
		}
		return listVo;
	}

}
