package com.rainyhon.common.service;

import com.rainyhon.common.mapper.OperationHistoryMapper;
import com.rainyhon.common.model.OperationHistory;
import com.rainyhon.common.model.OperationHistoryExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.OperationHistoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperHisService {

	@Autowired
	private OperationHistoryMapper psmOperHisMapper;

	@Autowired
	private ParaDefineService paraDefineService;

	@Autowired
	private PsmUserService psmUserService;

	public void add(String operTarget, String operType) {
		OperationHistory operHis = new OperationHistory();
		operHis.setId(CommonUtil.getUUID());
		operHis.setOperator(CommonUtil.getCurrentUserId());
		operHis.setOperTarget(operTarget);
		operHis.setOperType(operType);
		operHis.setOperTime(CommonUtil.getCurrentTime());
		psmOperHisMapper.insert(operHis);
	}

	public void add(OperationHistory psmOperHis) {
		add(psmOperHis.getOperTarget(), psmOperHis.getOperType());
	}

	public List<OperationHistoryVo> getOperationHistory(String operTarget) {
		OperationHistoryExample example = new OperationHistoryExample();
		OperationHistoryExample.Criteria criteria = example.createCriteria();
		criteria.andOperTargetEqualTo(operTarget);
		List<OperationHistoryVo> listVo = CommonUtil.listPo2VO(psmOperHisMapper.selectByExample(example), OperationHistoryVo.class);
		for (OperationHistoryVo operationHistoryVo : listVo) {
			operationHistoryVo.setOperTypeName(paraDefineService.getValueByTypeAnd("OPER_TYPE", operationHistoryVo.getOperType()));
			operationHistoryVo.setOperatorName(psmUserService.getPsmUserRealName(operationHistoryVo.getOperator()));
		}
		return listVo;
	}

}


