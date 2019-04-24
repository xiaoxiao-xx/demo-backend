package com.microcore.center.task.summary;

import com.microcore.center.model.PsmDetail;
import com.microcore.center.model.PsmSummary;
import com.microcore.center.model.PsmUser;
import com.microcore.center.service.CommonService;
import com.microcore.center.service.SummaryService;
import com.microcore.center.service.PsmUserService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.JedisPoolUtil;
import com.microcore.center.vo.FaceSummaryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 汇总任务
 */
@Component
@Slf4j
public class SummaryTask {

	private final SummaryService summaryService;

	private final CommonService commonService;

	private final PsmUserService psmUserService;

	/**
	 * 定期汇总时间间隔，单位为milisecond
	 */
	@Value("${summary.task.interval}")
	private final int summaryTaskInterval = 5000;

	private final JedisPoolUtil redisUtil;


	@Autowired
	public SummaryTask(SummaryService summaryService, CommonService commonService,
	                   PsmUserService psmUserService, JedisPoolUtil redisUtil) {
		this.summaryService = summaryService;
		this.commonService = commonService;
		this.psmUserService = psmUserService;
		this.redisUtil = redisUtil;
	}

	/**
	 *
	 */
	// @Scheduled(fixedRate = summaryTaskInterval)
	public void generateSummary() {
		Date now = new Date();

		String sql = "SELECT f.*, m.create_time AS capture_time, m.area_id area_id \n" +
				"FROM psm_face f \n" +
				"LEFT JOIN psm_material m ON f.material_id = m.id \n" +
				"WHERE m.create_time > DATE_SUB(NOW(), INTERVAL #{intervalTime} SECOND) \n" +
				"ORDER BY m.create_time DESC";

		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);
		params.put("intervalTime", summaryTaskInterval / 1000);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		List<FaceSummaryVo> faceSummaryVoList = CommonUtil.map2PO(list, FaceSummaryVo.class);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - summaryTaskInterval / 1000);
		Date head = calendar.getTime();

		String summaryId = CommonUtil.getUUID();
		String areaId = "--";
		PsmSummary summary = new PsmSummary();
		summary.setId(summaryId);
		summary.setPeriodHead(head);
		summary.setPeriodEnd(now);
		summary.setAreaId(areaId);
		summary.setPeopleNumber(faceSummaryVoList.size());
		summaryService.addSummary(summary);

		faceSummaryVoList.forEach(faceSummaryVo -> {
			PsmDetail detail = new PsmDetail();
			String id = CommonUtil.getUUID();
			detail.setId(id);
			detail.setSummaryId(summaryId);
			detail.setAreaId(faceSummaryVo.getAreaId());
			detail.setTime(faceSummaryVo.getCaptureTime());
			detail.setUserId(faceSummaryVo.getUserId());

			PsmUser user = psmUserService.getPsmUserById(faceSummaryVo.getUserId());
			String username = "";
			if (user != null) {
				username = user.getUsername();
			}
			detail.setUserName(username);

			summaryService.addDetail(detail);
		});
	}

	private final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));

	/**
	 * Remove expired value of the set
	 */
	private final long EXPIRE_TIME = 300000L;

	@Scheduled(fixedRate = EXPIRE_TIME)
	public void cleanExpiredSetValue() {
		String keyPrefix = "u";
		Set<String> keys = redisUtil.keys(keyPrefix + "*");
		for (String key : keys) {
			List<String> result = redisUtil.hmget(key, "captureTime", "areaId");
			String timeString = result.get(0);
			String areaId = result.get(1);

			Date captureTime = new Date();
			try {
				captureTime = dateFormat.get().parse(timeString);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Date now = new Date();
			if (now.getTime() - captureTime.getTime() > EXPIRE_TIME) {
				redisUtil.srem("area:" + areaId, key);
				log.info("Removed expired set value: {}", key);
			}
		}
	}

}

