package com.microcore.center.service.impl;

import com.microcore.center.service.CommonService;
import com.microcore.center.service.SummaryService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.DetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class SummaryServiceImpl implements SummaryService {

	private final int summaryTaskInterval = 60000;

	@Autowired
	private CommonService commonService;

	@Override
	public List getSummary() {
		String sql = "SELECT\n" +
				" area_id,\n" +
				" count( 1 ) count \n" +
				" FROM\n" +
				" (SELECT * FROM psm_detail WHERE psm_detail.time > DATE_SUB( NOW( ), INTERVAL #{intervalTime} SECOND ) GROUP BY area_id, user_id ) a \n" +
				" GROUP BY\n" +
				" area_id";
		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);
		params.put("intervalTime", summaryTaskInterval / 1000);

		return commonService.executeSelectSQL(params);
	}

	/**
	 * 返回一个区域的人的列表
	 */
	@Override
	public List<DetailVo> getDetailList(String areaId, Integer pageIndex, Integer pageSize) {
		String sql = "SELECT * FROM\n" +
				" psm_detail \n" +
				" WHERE psm_detail.time > DATE_SUB( NOW( ), INTERVAL #{intervalTime} SECOND ) \n" +
				" AND area_id = #{areaId} \n" +
				" group by user_id";

		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);
		params.put("areaId", areaId);
		params.put("intervalTime", summaryTaskInterval / 1000);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		return CommonUtil.map2PO(list, DetailVo.class);
	}

}
