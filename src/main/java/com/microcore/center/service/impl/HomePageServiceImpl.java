package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.microcore.center.service.HomePageService;
import com.microcore.center.vo.DataUseVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.common.constant.Constants;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.TimeUtil;
import com.microcore.common.util.UserUtil;

@Transactional
@Service
public class HomePageServiceImpl implements HomePageService {

	@Autowired
	private CommonService commonService;

	private Map<String, String> orgMap = new HashMap<>();
	private Map<String, String> addressMap = new HashMap<>();

	private void initOrg() {
		String sql = "SELECT org_id,org_name,address FROM db_org";
		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		list.forEach(org -> {
			String address = org.get("address") + "";
			String[] arr = address.split(",");
			address = arr[arr.length - 1];
			orgMap.put(org.get("org_id") + "", org.get("org_name") + "/" + address);
		});
	}

	private void initAddress() {
		String sql = "SELECT id,name,zip_code,lng,lat FROM sh_area";
		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		list.forEach(map -> {
			addressMap.put(map.get("id") + "", map.get("lng") + "-" + map.get("lat") + "-" + map.get("name") + "-" + map.get("zip_code"));
		});
	}

	/**
	 * 各行业模型数量统计
	 */
	@Override
	public List<Map<String, Object>> getModelStat() {
		String sql = "SELECT a.model_trade model_trade_id , b.cname model_trade, count(*) as count FROM db_model a left join db_name_space b on a.model_trade = b.id WHERE 1 = 1 GROUP BY model_trade ORDER BY count desc";
		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		// 一个行业也没有
		if (CommonUtil.isEmpty(list)) {
			list = new ArrayList<>();
			return list;
		}

		// 行业数小于6个
		if (list.size() < 6) {
			return list;
		}

		// 行业数超过5个
		Integer endIndex = list.size();
		Long sum = 0L;
		for (int i = 4; i < endIndex; i++) {
			sum += (Long) list.get(i).get("count");
		}

		Map<String, Object> m = new HashMap<>();
		m.put("count", sum);
		m.put("model_trade", "其它");
		list.set(4, m);

		list = list.subList(0, 5);
		List<Map<String, Object>> listNew = new ArrayList<>(); 
		list.forEach((e)->listNew.add(e));
		return listNew;
	}

	/**
	 * 模型订阅频次TOP5
	 */
	@Override
	public List<Map<String, Object>> modelSubTop5() {
		String role = CommonUtil.getAdminRole();
		String sql;
		Map<String, Object> params = new HashMap<>();

		if (Constants.ROLE_CENTER_ADMIN.equals(role)) {
			sql = "select id, model_name, count from ( SELECT db_model.*, count(*) count FROM db_sub_table, db_pub_table, db_model \r\n"
					+ "WHERE db_sub_table.pub_id = db_pub_table.id and  db_pub_table.model_id =  db_model.id\r\n"
					+ "GROUP BY db_pub_table.model_id\r\n" + "union \r\n" + "SELECT\r\n"
					+ "db_model.*, count(*) count FROM db_sub_file, db_pub_file, db_model\r\n"
					+ "WHERE db_sub_file.pub_id = db_pub_file.pub_id and  db_pub_file.model_id =  db_model.id\r\n"
					+ "GROUP BY db_pub_file.model_id\r\n" + "union\r\n" + "SELECT db_model.*, count(*) count FROM\r\n"
					+ "db_sub_service, db_pub_service, db_model\r\n"
					+ "WHERE db_sub_service.pub_service_id = db_pub_service.id and  db_pub_service.model_id =  db_model.id\r\n"
					+ "GROUP BY db_pub_service.model_id ) temp order by temp.count desc limit 5";
			params.put("sql", sql);
		} else {
			String orgId = UserUtil.getOrgId();
			sql = "select id, model_name, count from ( \n" +
					"SELECT db_model.*, count(*) count FROM db_pub_table, db_model \n" +
					"WHERE db_pub_table.model_id =  db_model.id AND db_pub_table.pub_org_id=#{orgId} \n" +
					"GROUP BY db_pub_table.model_id \n" +
					"union \n" +
					"SELECT db_model.*, count(*) count FROM db_pub_file, db_model \n" +
					"WHERE db_pub_file.model_id = db_model.id AND db_pub_file.pub_org_id=#{orgId} \n" +
					"GROUP BY db_pub_file.model_id \n" +
					"union \n" +
					"SELECT db_model.*, count(*) count FROM db_pub_service, db_model \n" +
					"WHERE db_pub_service.model_id =  db_model.id AND db_pub_service.crt_org_id=#{orgId} \n" +
					"GROUP BY db_pub_service.model_id ) temp \n" +
					"order by temp.count desc limit 5";
			params.put("sql", sql);
			params.put("orgId", orgId);
		}
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		if (CommonUtil.isEmpty(list)) {
			list = new ArrayList<>();
			return list;
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> orgDataSubTop5() {
		String sql = "SELECT db_distill_record.pub_org_id as org_id, db_org.org_name, sum(db_distill_record.record_count) as count "
				+ "FROM db_distill_record, db_org "
				+ "WHERE pub_org_id is not NULL and db_org.org_id = db_distill_record.pub_org_id "
				+ "GROUP BY pub_org_id ORDER BY count  desc LIMIT 5";

		Map<String, Object> params = new HashMap<>(1);
		params.put("sql", sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		if (CommonUtil.isEmpty(list)) {
			list = new ArrayList<>();
			return list;
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> dbDataSubCount() {
		String sql = "SELECT INSERT(MONTH, 5, 0, '-') as month, " +
				"sum(db_distill_record.record_count) as count " +
				"FROM db_distill_record WHERE MONTH > DATE_FORMAT(DATE_SUB( CURDATE( ), INTERVAL 12 MONTH), '%Y%m' ) " + "AND MONTH <= DATE_FORMAT( CURDATE( ), '%Y%m') " +
				"GROUP BY MONTH ORDER BY MONTH LIMIT 12";

		return getDataCount(sql);
	}

	@Override
	public List<Map<String, Object>> getFileRecord() {
		String sql = "SELECT DATE_FORMAT( make_date, '%Y-%m' ) month, count(1) count FROM db_file_record WHERE"
				+ " DATE_FORMAT( make_date, '%Y-%m' ) > DATE_FORMAT( DATE_SUB( CURDATE(), INTERVAL 12 MONTH ), '%Y-%m' ) and  "
				+ "DATE_FORMAT( make_date, '%Y-%m' ) <= DATE_FORMAT( CURDATE( ), '%Y-%m' ) GROUP BY month";
		return getDataCount(sql);
	}

	public List<Map<String, Object>> getDataCount(String sql) {
		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);

		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		if (list == null) {
			list = new ArrayList<>();
		}

		// 纪录已经有数据的月份至Set
		Set<String> set = list.stream().map(map -> (String) map.get("month")).collect(Collectors.toSet());

		// 为没有数据的月份添加数据
		List<String> months = TimeUtil.getLatest12Months();
		final List<Map<String, Object>> finalList = list;
		months.stream().filter(m -> !set.contains(m)).forEach(m -> {
			Map<String, Object> x = new HashMap<>();
			x.put("month", m);
			x.put("count", 0);
			finalList.add(x);
		});

		// 排序
		finalList.sort((o1, o2) -> {
					Function<String, Integer> getMonthNumber = (o) -> {
						String m = o.replace("-", "");
						return Integer.parseInt(m);
					};

					Integer m1 = getMonthNumber.apply((String) o1.get("month"));
					Integer m2 = getMonthNumber.apply((String) o2.get("month"));

					if (m1 > m2) {
						return 1;
					} else if (m1 < m2) {
						return -1;
					} else {
						return 0;
					}
				}
		);

		return list;
	}

	@Override
	public ResultVo getServiceRecord() {
       /*String sql = "SELECT DATE_FORMAT( invoke_date, '%Y-%m' ) month, count(1) count FROM db_service_record WHERE"
                + " DATE_FORMAT( invoke_date, '%Y-%m' ) > DATE_FORMAT( DATE_SUB( CURDATE(), INTERVAL 12 MONTH ), '%Y-%m' ) and  "
                + "DATE_FORMAT( invoke_date, '%Y-%m' ) <= DATE_FORMAT( CURDATE( ), '%Y-%m' ) GROUP BY month";
        List<Map<String, Object>> list =  getDataCount(sql);*/
		//SELECT count(1),MONTH from db_service_record where month = DATE_FORMAT( DATE_SUB( CURDATE(),INTERVAL 0 MONTH ),'%Y-%m' )
		List<Map<String, Object>> finalList = new ArrayList<>();
		/*for (int i = 11; i >= 0; i--) {
			Map<String, Object> params = new HashMap<>();
			params.put("sql", "SELECT count(1) count ,month  from db_service_record where month = DATE_FORMAT( DATE_SUB( CURDATE(),INTERVAL " + i + " MONTH ),'%Y-%m' )");
			List<Map<String, Object>> list = commonService.executeSelectSQL(params);
			finalList.add(list.get(0));
		}*/
		
		Map<String, Object> params = new HashMap<>();
		params.put("sql", "SELECT count(1) count , month  from db_service_record  where month<=DATE_FORMAT( DATE_SUB( CURDATE(),INTERVAL 0 MONTH ),'%Y-%m' ) and   month>=DATE_FORMAT( DATE_SUB( CURDATE(),INTERVAL 11 MONTH ),'%Y-%m' )  group by month ");
		finalList = commonService.executeSelectSQL(params);
		
		
		return ResultVo.ok(finalList);
	}

	@Override
	public ResultVo getUseOrgs(String orgId,String type) {
		if (StringUtil.isEmpty(orgId)) {
			orgId = CommonUtil.getOrgId();
		}
		String sql = "";
		if ("sub".equals(type)) {
			sql = "SELECT pub_org_id org_id FROM db_sub_file WHERE sub_org_id=#{orgId} AND del_status!='DEL' AND `status`='YPUB'"
					+ " UNION "
					+ "SELECT pub_org_id org_id FROM db_sub_table WHERE sub_org_id=#{orgId} AND del_status!='DEL'"
					+ " UNION "
					+ "SELECT crt_org_id org_id FROM db_sub_service WHERE sub_org_id=#{orgId} AND del_status!='DEL' AND pub_status='PUB'";
		}else {
			sql = "SELECT sub_org_id org_id FROM db_sub_file WHERE pub_org_id=#{orgId} AND del_status!='DEL' AND `status`='YPUB'"
					+ " UNION "
					+ "SELECT sub_org_id org_id FROM db_sub_table WHERE pub_org_id=#{orgId} AND del_status!='DEL'"
					+ " UNION "
					+ "SELECT sub_org_id org_id FROM db_sub_service WHERE crt_org_id=#{orgId} AND del_status!='DEL' AND pub_status='PUB'";
		}
		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);
		params.put("orgId", orgId);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		List<Map<String, Object>> lngList = new ArrayList<Map<String, Object>>();
		if (null == list) {
			return ResultVo.ok(lngList);
		}
		for (Map<String, Object> map : list) {
			if (null==map||map.isEmpty()) {
				continue;
			}
			String id = map.get("org_id") + "";
			ResultVo vo = getLngByOrgId(id);
			if (vo.getStatus() != 200) {
				continue;
			}
			lngList.add((Map<String, Object>) vo.getData());
		}
		return ResultVo.ok(lngList);
	}

	@Override
	public ResultVo getLngByOrgId(String orgId) {
		String addressId = orgMap.get(orgId);
		if (StringUtil.isEmpty(addressId)) {
			orgMap.clear();
			initOrg();
			addressId = orgMap.get(orgId);
		}
		if (StringUtil.isEmpty(addressId)) {
			return ResultVo.fail("机构不存在");
		}
		String[] arr = addressId.split("/");
		String orgName = arr[0];
		addressId = arr[1];
		String address = addressMap.get(addressId);
		if (StringUtil.isEmpty(address)) {
			addressMap.clear();
			initAddress();
			address = addressMap.get(addressId);
		}
		if (StringUtil.isEmpty(address)) {
			return ResultVo.fail("地址不存在");
		}
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("orgName", orgName);
		String[] addressArr = address.split("-");
		resMap.put("lng", addressArr[0]);
		resMap.put("lat", addressArr[1]);
		resMap.put("name", addressArr[2]);
		resMap.put("code", addressArr[3]);

		return ResultVo.ok(resMap);
	}

	@Override
	public ResultVo clearOrgAddressCache() {
		orgMap.clear();
		initOrg();
		addressMap.clear();
		initAddress();
		return ResultVo.ok();
	}

	@Override
	public ResultVo getOrgDataUse() {
		String role = CommonUtil.getAdminRole();
		List<DataUseVo> useList = new ArrayList<>();
		//中心管理员
		if (Constants.ROLE_CENTER_ADMIN.equals(role)) {
			for (String orgId : orgMap.keySet()) {
				DataUseVo useVo = getUseVo(orgId);
				useList.add(useVo);
			}
		} else {
			String orgId = UserUtil.getOrgId();
			DataUseVo useVo = getUseVo(orgId);
			useList.add(useVo);
		}
		return ResultVo.ok(useList);
	}

	private DataUseVo getUseVo(String orgId) {
		Object myObj = null;
		Object pubObj = null;
		Object subObj = null;
		ResultVo myAddressVo = getLngByOrgId(orgId);
		if (myAddressVo.getStatus() == 200) {
			myObj = myAddressVo.getData();
		}
		ResultVo pubAddressVo = getUseOrgs(orgId,"pub");//其他机构订阅我的
		if (pubAddressVo.getStatus() == 200) {
			pubObj = pubAddressVo.getData();
		}
		ResultVo subAddressVo = getUseOrgs(orgId, "sub");//我订阅其他机构的
		if (subAddressVo.getStatus() == 200) {
			subObj = subAddressVo.getData();
		}
		DataUseVo useVo = new DataUseVo();
		useVo.setOrgObj(myObj);
		useVo.setOrgPubObj(pubObj);
		useVo.setOrgSubObj(subObj);
		return useVo;
	}

}

