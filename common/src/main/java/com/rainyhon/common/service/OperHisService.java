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

import static com.rainyhon.common.util.CommonUtil.listPo2VO;

@Service
@Transactional
public class OperHisService {

	@Autowired
	private OperationHistoryMapper operationHistoryMapper;

	@Autowired
	private ParaDefineService paraDefineService;

	@Autowired
	private UserService userService;

	public void add(String operTarget, String operType) {
		OperationHistory operHis = new OperationHistory();
		operHis.setId(CommonUtil.getUUID());
		operHis.setOperator(CommonUtil.getCurrentUserId());
		operHis.setOperTarget(operTarget);
		operHis.setOperType(operType);
		operHis.setOperTime(CommonUtil.getCurrentTime());
		operationHistoryMapper.insert(operHis);
	}

	public void add(OperationHistory operationHistory) {
		add(operationHistory.getOperTarget(), operationHistory.getOperType());
	}

	public List<OperationHistoryVo> getOperationHistory(String operTarget) {
		OperationHistoryExample example = new OperationHistoryExample();
		OperationHistoryExample.Criteria criteria = example.createCriteria();
		criteria.andOperTargetEqualTo(operTarget);
		List<OperationHistoryVo> listVo = listPo2VO(operationHistoryMapper.selectByExample(example), OperationHistoryVo.class);
		for (OperationHistoryVo operationHistoryVo : listVo) {
			operationHistoryVo.setOperTypeName(paraDefineService.getValueByTypeAnd("OPER_TYPE", operationHistoryVo.getOperType()));
			operationHistoryVo.setOperatorName(userService.getUserNameById(operationHistoryVo.getOperator()));

		}

		return listVo;
	}

}


