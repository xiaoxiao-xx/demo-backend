package com.rainyhon.common.service.impl;

import com.microcore.center.model.PsmPersonInfo;
import com.rainyhon.common.service.CommonService;
import com.rainyhon.common.service.PersonService;
import com.rainyhon.common.service.SummaryService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.JedisPoolUtil;
import com.rainyhon.common.vo.DetailVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(value = "commonSummary")
@Transactional(rollbackFor = Exception.class)
public class SummaryServiceImpl implements SummaryService {

	@Value("${summary.task.interval}")
	private int summaryTaskInterval;

	@Autowired
	private CommonService commonService;

	@Autowired
	private PersonService personService;

	@Autowired
	private JedisPoolUtil redisUtil;

	@Override
	public List getSummary() {
		String sql = "SELECT area_id, count(1) count \n" +
				" FROM\n" +
				" (SELECT * FROM psm_detail " +
				"      WHERE psm_detail.time > DATE_SUB(NOW(), INTERVAL #{intervalTime} SECOND) " +
				"      GROUP BY area_id, user_id) a \n" +
				" GROUP BY area_id";
		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);
		params.put("intervalTime", summaryTaskInterval / 1000);

		List<Map<String, Object>> maps = commonService.executeSelectSQL(params);
		List<AreaCount> counts = CommonUtil.map2PO(maps, AreaCount.class);

		for (int i = 1; i < 6; i++) {
			if (!check(i + "", counts)) {
				AreaCount c = new AreaCount();
				c.setAreaId(i + "");
				c.setCount(0L);
				counts.add(c);
			}
		}

		return counts;
	}

	@Override
	public List<AreaCount> getSummaryRedis() {
		List<AreaCount> counts = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			String areaKey = "area:" + i;
			Long userCount = redisUtil.scard(areaKey);

			AreaCount count = new AreaCount("" + i, userCount);
			counts.add(count);
		}

		return counts;
	}

	private boolean check(String areaId, List<AreaCount> counts) {
		for (AreaCount count : counts) {
			if (count.getAreaId().equals(areaId)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 返回一个区域的人的列表
	 */
	@Override
	public List<DetailVo> getDetailList(String areaId) {
		String sql = "SELECT * FROM psm_detail \n" +
				" WHERE psm_detail.time > DATE_SUB(NOW( ), INTERVAL #{intervalTime} SECOND) \n" +
				" AND area_id = #{areaId} \n" +
				" group by user_id";

		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);
		params.put("areaId", areaId);
		params.put("intervalTime", summaryTaskInterval / 1000);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		List<DetailVo> detailVos = CommonUtil.map2PO(list, DetailVo.class);
		detailVos.forEach(detailVo -> {
			PsmPersonInfo info = personService.getPsmPersonInfo(detailVo.getUserId());
			detailVo.setUserId(info.getPersonalPhoto1());
		});

		return CommonUtil.map2PO(list, DetailVo.class);
	}

	@Override
	public List<DetailVo> getDetailListRedis(String areaId) {
		List<DetailVo> voList = new ArrayList<>();

		String areaKey = "area:" + areaId;
		Set<String> userIdSet = redisUtil.smemebers(areaKey);
		for (String userId : userIdSet) {
			PsmPersonInfo psmPersonInfo = personService.getPsmPersonInfo(userId);

			DetailVo vo = new DetailVo();
			vo.setId("");
			vo.setSummaryId(psmPersonInfo.getPersonalPhoto1());
			vo.setAreaId(areaId);
			vo.setUserId(userId);
			vo.setUserName(psmPersonInfo.getName());
			vo.setTime(new Date());

			voList.add(vo);
		}

		return voList;
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	public static class AreaCount {

		private String areaId;

		private Long count;

		public AreaCount() {

		}

		public AreaCount(String areaId, Long count) {
			setAreaId(areaId);
			setCount(count);
		}

	}

}
