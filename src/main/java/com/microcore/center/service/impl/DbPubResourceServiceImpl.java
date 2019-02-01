package com.microcore.center.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbOrg;
import com.microcore.center.dto.DbPubDto;
import com.microcore.center.mapper.DbOrgMapper;
import com.microcore.center.service.DbParamsService;
import com.microcore.center.service.DbPubResourceService;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.StringUtil;

@Service
@Transactional
public class DbPubResourceServiceImpl implements DbPubResourceService {

	@Autowired
	private DbOrgMapper dbOrgMapper;
	@Autowired
	private DbParamsService dbParamsService;
	@Autowired
	private CommonService commonService;

	@Override
	public PageInfo<DbPubDto> getPubResourceByOrg(String orgId, String keywords, Integer pageIndex, Integer pageSize) {
		if (StringUtil.isEmpty(orgId)) {
			return new PageInfo<>();
		}
		Map<String, Object> params = new HashMap<>();
		params.put("orgId", orgId);
		String sqlFile = "SELECT pub_id id,pub_name pubName,pub_desc pubDesc,keywords keywords,file_type type,'file' dataType FROM db_pub_file WHERE pub_org_id=#{orgId} AND del_status='NOR' AND `status`='YPUB'";
		if (StringUtil.isNotEmpty(keywords)) {
			sqlFile += " AND keywords LIKE CONCAT('%',#{keywords},'%')";
			params.put("keywords", keywords);
		}
		String sqlService = "SELECT id,name pubName,chinese_describe pubDesc,keywords keywords,data_type type,'service' dataType FROM db_pub_service WHERE crt_org_id=#{orgId} AND del_status='NOR' AND pub_status='PUB'";
		if (StringUtil.isNotEmpty(keywords)) {
			sqlService += " AND keywords LIKE CONCAT('%',#{keywords},'%')";
		}
		String sqlDb = "SELECT id,pub_name pubName,pub_desc pubDesc,keywords keywords,data_type type,'db' dataType FROM db_pub_table WHERE pub_org_id=#{orgId} AND del_status='NOR' AND pub_status='YES'";
		if (StringUtil.isNotEmpty(keywords)) {
			sqlDb += " AND keywords LIKE CONCAT('%',#{keywords},'%')";
		}
		String sql = sqlFile + " UNION " + sqlService + " UNION " + sqlDb;
		String countSql = "SELECT COUNT(id) count FROM (" + sql + ") a";
		params.put("sql", countSql);
		List<Map<String, Object>> countList = commonService.executeSelectSQL(params);
		long count = (long) countList.get(0).get("count");
		String limit = " LIMIT #{index},#{size}";
		sql += limit;
		if (null == pageIndex) {
			pageIndex = 1;
		}
		if (null == pageSize) {
			pageSize = 10;
		}
		int index = (pageIndex - 1) * pageSize;
		params.put("index", index);
		params.put("size", pageSize);
		params.put("sql", sql);

		List<Map<String, Object>> res = commonService.executeSelectSQL(params);
		List<DbPubDto> list;
		PageInfo page;
		if (null != res && res.size() > 0) {
			res.forEach(r -> {
				String type = r.get("type") + "";
				String val = dbParamsService.getParamsValueByTypeAndKey("data_cate", type);
				r.put("type", val);
			});
			list = CommonUtil.map2PO(res, DbPubDto.class, false);
			page = new PageInfo<>(list);
			page.setTotal(count);
		} else {
			page = new PageInfo<>();
		}
		return page;
	}

	@Override
	public PageInfo<DbPubDto> getPubResourceByTrade(String paramsKey, String keywords, Integer pageIndex,
	                                                Integer pageSize) {
		if (StringUtil.isEmpty(paramsKey)) {
			return new PageInfo<>();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", paramsKey);
		String sqlFile = "SELECT pub_id id,pub_name pubName,pub_desc pubDesc,keywords keywords,pub_org_id org,'file' dataType FROM db_pub_file WHERE file_type=#{type} AND del_status='NOR' AND `status`='YPUB'";
		if (StringUtil.isNotEmpty(keywords)) {
			sqlFile += " AND keywords LIKE CONCAT('%',#{keywords},'%')";
			params.put("keywords", keywords);
		}
		String sqlService = "SELECT id,name pubName,chinese_describe pubDesc,keywords keywords,crt_org_id org,'service' dataType FROM db_pub_service WHERE data_type=#{type} AND del_status='NOR' AND pub_status='PUB'";
		if (StringUtil.isNotEmpty(keywords)) {
			sqlService += " AND keywords LIKE CONCAT('%',#{keywords},'%')";
		}
		String sqlDb = "SELECT id,pub_name pubName,pub_desc pubDesc,keywords keywords,pub_org_id org,'db' dataType FROM db_pub_table WHERE data_type=#{type} AND del_status='NOR' AND pub_status='YES'";
		if (StringUtil.isNotEmpty(keywords)) {
			sqlDb += " AND keywords LIKE CONCAT('%',#{keywords},'%')";
		}
		String sql = sqlFile + " UNION " + sqlService + " UNION " + sqlDb;
		String countSql = "SELECT COUNT(id) count FROM (" + sql + ") a";
		params.put("sql", countSql);
		List<Map<String, Object>> countList = commonService.executeSelectSQL(params);
		long count = (long) countList.get(0).get("count");
		String limit = " LIMIT #{index},#{size}";
		sql += limit;
		if (null == pageIndex) {
			pageIndex = 1;
		}
		if (null == pageSize) {
			pageSize = 10;
		}
		int index = (pageIndex - 1) * pageSize;
		params.put("index", index);
		params.put("size", pageSize);
		params.put("sql", sql);

		List<Map<String, Object>> res = commonService.executeSelectSQL(params);
		List<DbPubDto> list;
		PageInfo page;
		if (null != res && res.size() > 0) {
			res.forEach(r -> {
				String org = r.get("org") + "";
				DbOrg orgInfo = dbOrgMapper.selectByPrimaryKey(org);
				String val = "";
				if (null != orgInfo) {
					val = orgInfo.getOrgName();
				}
				r.put("org", val);
			});
			list = CommonUtil.map2PO(res, DbPubDto.class, false);
			page = new PageInfo<>(list);
			page.setTotal(count);
		} else {
			page = new PageInfo<>();
		}
		return page;
	}

	@Override
	public List<Map<String, Object>> getTradeList() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM db_params WHERE params_type='data_cate' AND params_key IN(\r\n" + 
				"SELECT file_type type FROM db_pub_file WHERE del_status='NOR' AND `status`='YPUB' UNION \r\n" + 
				"SELECT data_type type FROM db_pub_service WHERE del_status='NOR' AND pub_status='PUB' UNION \r\n" + 
				"SELECT data_type type FROM db_pub_table WHERE del_status='NOR' AND pub_status='YES')";
		params.put("sql", sql);
		List<Map<String, Object>> paramList = commonService.executeSelectSQL(params);
		return paramList;
	}

}
