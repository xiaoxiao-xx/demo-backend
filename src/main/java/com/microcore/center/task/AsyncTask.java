package com.microcore.center.task;

import com.microcore.api.SysApi;
import com.microcore.api.model.DbOrg;
import com.microcore.api.vo.DbBaseKitVo;
import com.microcore.api.vo.DbServiceKitVo;
import com.microcore.center.client.DbKitTemplate;
import com.microcore.center.dto.DbConnectionDto;
import com.microcore.center.mapper.DbOrgMapper;
import com.microcore.center.model.DbOrgExample;
import com.microcore.center.service.DbConnectionService;
import com.microcore.center.service.DbFieldCnfService;
import com.microcore.center.service.DbTableCnfService;
import com.microcore.common.constant.Constants;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lmh
 */
@Component
@Slf4j
public class AsyncTask {

	@Autowired
	private DbConnectionService dbConnectionService;
	@Autowired
	private DbTableCnfService dbTableCnfService;
	@Autowired
	private DbFieldCnfService dbFieldCnfService;
	@Autowired
	private DbKitTemplate dbKitTemplate;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbOrgMapper dbOrgMapper;
	@Autowired
	private SysApi sysApi;
	
	public static Map<String, DbServiceKitVo> serviceMap = new HashMap<String, DbServiceKitVo>();
	public static Map<String, Long> runMap = new HashMap<String, Long>();
	public static Map<String, Object> spaceMap = new HashMap<String, Object>();

	@Async
	public void refreshConnection(String kitId, String id) {
		long start = System.currentTimeMillis();

		// 删除本地已有数据库结构信息
		dbFieldCnfService.deleteByConId(id);
		dbTableCnfService.deleteByPid(id);

		// 通知节点刷新
		// 直接在返回数据中接收数据库结构信息
		ResultVo<DbConnectionDto> vo = dbKitTemplate.refreshDbConnection(kitId, id);

		if (vo == null || vo.getData() == null) {
			log.error("刷新失败");
			return;
		}

		DbConnectionDto dto = vo.getData();
		dbConnectionService.storeTableFieldInfo(dto);

		log.info("数据库表信息刷新成功, 耗时 {} 毫秒", System.currentTimeMillis() - start);
	}

	@Scheduled(fixedRate = 30000)
	public void setServiceKitShowInfo() {
		DbOrgExample example = new DbOrgExample();
		DbOrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		List<DbOrg> orgList = dbOrgMapper.selectByExample(example);
		for(DbOrg org : orgList) {
			String orgId = org.getOrgId();
			String date = CommonUtil.getSystemDateStr();
			date = date.substring(0, date.indexOf(" "));
			String startDate = date + " 00:00:00";
			String endDate = date + " 12:59:59";

			String todayRecordSql = "SELECT\n"
					+ "IFNULL((sum( proxy_time ) / 1024 ) / ( sum( data_volume ) / 1000 ),'0') AS speed,\n"
					+ "count(*) as count " + "FROM\n" + "db_service_record \n" + "WHERE\n"
					+ "pub_org_id = #{orgId} \n" + "AND  invoke_date BETWEEN #{startDate} and #{endDate};";
			String allRecordSql = "SELECT\n"
					+ "IFNULL((sum( proxy_time ) / 1024 ) / ( sum( data_volume ) / 1000 ),'0') AS speed,\n"
					+ "count(*) as count " + "FROM\n" + "db_service_record \n" + "WHERE\n"
					+ "pub_org_id = #{orgId};";

			Map<String, Object> map = new HashMap<>();
			map.put("sql", todayRecordSql);
			map.put("orgId", orgId);
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			Map<String, Object> todayRecord = commonService.findOne(map);
			Map<String, Object> map1 = new HashMap<>();
			map1.put("sql", allRecordSql);
			map1.put("orgId", orgId);
			Map<String, Object> allRecord = commonService.findOne(map1);
			if (todayRecord != null) {
				DbServiceKitVo serviceKitVo = new DbServiceKitVo();
				serviceKitVo.setTodaySpeed(String.valueOf(todayRecord.get("speed")));
				serviceKitVo.setAllSpeed(String.valueOf(allRecord.get("speed")));
				serviceKitVo.setCount(String.valueOf(allRecord.get("count")));
				serviceMap.put(orgId, serviceKitVo);
			}
		}
		
		ResultVo runVo = null;
		try {
			runVo = sysApi.getRunMap();
		} catch (Exception e) {
			log.error("getRunMap异常[{}]", e.getMessage());
			return;
		}
		Map<String, Object> resMap = (null == runVo ? null : (Map<String, Object>) runVo.getData());
		try {
			runMap = (Map<String, Long>) resMap.get("kitMap");
			spaceMap = (Map<String, Object>) resMap.get("spaceMap");
		} catch (Exception e) {
		}
		
		
	}
	
	
}
