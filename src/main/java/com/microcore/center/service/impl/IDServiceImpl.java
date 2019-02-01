package com.microcore.center.service.impl;

import com.microcore.center.mapper.DbParamsMapper;
import com.microcore.center.model.DbParams;
import com.microcore.center.model.DbParamsExample;
import com.microcore.center.service.IDService;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = Exception.class)
@Service
public class IDServiceImpl implements IDService {

	@Autowired
	private DbParamsMapper dbParamsMapper;

	@Autowired
	private CommonService commonService;

	private static Map<String, Integer> businessNumber = new HashMap<>();

	private static int fetchNumber = 1000;

	@Override
	public Integer getTaskId() {
		return getBusinessNumber("task_id");
	}

	@Override
	public synchronized Integer getBusinessNumber(String business) {
		Integer number = businessNumber.get(business);
		// 初始化ID
		if (number == null) {
			DbParamsExample example = new DbParamsExample();
			DbParamsExample.Criteria criteria = example.createCriteria();
			criteria.andParamsTypeEqualTo(business);
			List<DbParams> dbParams = dbParamsMapper.selectByExample(example);
			if (CommonUtil.isEmpty(dbParams)) {
				DbParams param = new DbParams();
				param.setId(CommonUtil.getUUID());
				param.setParamsType(business);
				param.setParamsKey(fetchNumber + "");
				param.setParamsValue("[" + business + "]ID生成器");
				businessNumber.put(business, 0);
				dbParamsMapper.insert(param);
				number = 0;
			} else {
				increase(business);
				Integer id = Integer.parseInt(dbParams.get(0).getParamsKey()) + fetchNumber;
				businessNumber.put(business, id);
				number = id;
			}
		}
		number++;
		if (number % fetchNumber == 0) {
			increase(business);
		}
		businessNumber.put(business, number);
		return number;
	}

	private void increase(String business) {
		Map<String, Object> params = new HashMap<>(2);
		String sql = "update db_params set params_key = params_key+" + fetchNumber
				+ " where params_type = #{params_type}";
		params.put("sql", sql);
		params.put("params_type", business);
		commonService.executeUpdateSQL(params);
	}

}
