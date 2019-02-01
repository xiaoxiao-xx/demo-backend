package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import com.microcore.api.PolicyApi;
import com.microcore.center.client.DbKitTemplate;
import com.microcore.center.model.*;
import com.microcore.common.vo.SecLabelVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.api.SysApi;
import com.microcore.api.model.DbBaseKit;
import com.microcore.api.model.DbOrg;
import com.microcore.api.vo.DbBaseKitVo;
import com.microcore.center.client.FileKitTemplate;
import com.microcore.center.dto.DbOrgDto;
import com.microcore.center.mapper.DbBaseKitMapper;
import com.microcore.center.mapper.DbOrgMapper;
import com.microcore.center.mapper.ShAreaMapper;
import com.microcore.center.service.BlockChService;
import com.microcore.center.service.DbOrgAreaService;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.service.HomePageService;
import com.microcore.center.task.AsyncTask;
import com.microcore.center.vo.DbOrgVo;
import com.microcore.common.constant.Constants;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;

@Service
@Transactional
@Slf4j
public class DbOrgServiceImpl implements DbOrgService {

	@Autowired
	private DbOrgMapper dbOrgMapper;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbOrgAreaService dbOrgAreaService;
	@Autowired
	private ShAreaMapper shAreaMapper;
	@Autowired
	private HomePageService homePageService;
	@Autowired
	private DbBaseKitMapper dbBaseKitMapper;
	@Autowired
	private BlockChService blockChService;
	@Autowired
	private PolicyApi policyApi;

	private DbKitTemplate dbDbKitTemplate;

	// 套件最大超时时间
	private static final long BIG_OUT_TIME = 40 * 1000L;

	@Override
	public void setDbDbKitTemplate(DbKitTemplate dbDbKitTemplate) {
		this.dbDbKitTemplate = dbDbKitTemplate;
	}

	@Override
	public PageInfo<DbOrgVo> orgList(String orgId, String orgName, Integer pageIndex, Integer pageSize) {
		DbOrgExample example = new DbOrgExample();
		DbOrgExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(orgId)) {
			criteria.andOrgIdEqualTo(orgId);
		}
		if (StringUtil.isNotEmpty(orgName)) {
			criteria.andOrgNameLike("%" + orgName.trim() + "%");
		}
		criteria.andDelStatusEqualTo("NOR");
		PageInfo<DbOrg> dbOrgPageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbOrgMapper.selectByExample(example));
		PageInfo<DbOrgVo> dbOrgVoPageInfo = CommonUtil.po2VO(dbOrgPageInfo, PageInfo.class);
		List<DbOrgVo> listVo = CommonUtil.listPo2VO(dbOrgPageInfo.getList(), DbOrgVo.class);
		if (!CommonUtil.isEmpty(listVo)) {
			for (DbOrgVo dbOrgVo : listVo) {
				DbOrg dbOrg = getDbOrgByOrgSort(dbOrgVo.getOrgPid());
				if (dbOrg != null) {
					dbOrgVo.setPorgName(dbOrg.getOrgName());
				}
				List<DbArea> listDbArea = dbOrgAreaService.getDbAreaByOrgId(dbOrgVo.getOrgId());
				dbOrgVo.setListDbArea(listDbArea);
				ShArea area = shAreaMapper.selectByPrimaryKey(Integer.valueOf(dbOrgVo.getAddress().split(",")[2]));
				dbOrgVo.setAddressName(area.getMergerName().replaceAll(",", "").substring(2));
			}
		}
		dbOrgVoPageInfo.setList(listVo);
		return dbOrgVoPageInfo;
	}

	@Override
	public PageInfo<DbOrgVo> queryDbOrg(String orgId, String orgName, String areaId, Integer pageIndex,
	                                    Integer pageSize) {
		Map<String, Object> params = new HashMap<>();
		String sql = "from db_org_area_rel r left join db_org o on r.org_id = o.org_id where 1=1 ";

		if (StringUtil.isNotEmpty(orgId)) {
			sql += " and o.org_id=#{orgId} ";
			params.put("orgId", orgId);
		}
		if (StringUtil.isNotEmpty(orgName)) {
			sql += " and o.org_name=#{orgName} ";
			params.put("orgName", orgId);
		}
		if (StringUtil.isNotEmpty(areaId)) {
			sql += " and r.area_id=#{areaId} ";
			params.put("areaId", areaId);
		}
		params.put("sql", "select o.* " + sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		List<DbOrgVo> listDbOrgVo = CommonUtil.map2PO(list, DbOrgVo.class);
		if (!CommonUtil.isEmpty(listDbOrgVo)) {
			for (DbOrgVo dbOrgVo : listDbOrgVo) {
				DbOrg dbOrg = getDbOrgByOrgSort(dbOrgVo.getOrgPid());
				if (dbOrg != null) {
					dbOrgVo.setPorgName(dbOrg.getOrgName());
				}
				ShArea area = shAreaMapper.selectByPrimaryKey(Integer.valueOf(dbOrgVo.getAddress().split(",")[2]));
				dbOrgVo.setAddressName(area.getMergerName().replaceAll(",", "").substring(2));
			}
		}
		return new PageInfo(listDbOrgVo);
	}

	@Override
	public synchronized void add(DbOrgVo dbOrgVo) {
		DbOrg dbOrg = CommonUtil.po2VO(dbOrgVo, DbOrg.class);
		dbOrg.setOrgSort(getMaxOrgSort() + 1);
		dbOrg.setOrgId(CommonUtil.getUUID());
		dbOrg.setKeyValue(CommonUtil.getUUID());
		EntityUtils.setCreateInfo(dbOrg);
		dbOrgAreaService.addOrgRel(dbOrg.getOrgId(), dbOrgVo.getAreaIds());

		Map<String, String> map = blockChService.registUser(dbOrg.getOrgId(), dbOrg.getOrgName(), dbOrg.getEmail());
		if (map != null) {
			dbOrg.setPk(map.get("pk"));
			dbOrg.setSk(map.get("sk"));
		}
		dbOrgMapper.insert(dbOrg);
	}

	@Override
	public void update(DbOrgVo dbOrgVo) {
		DbOrg dbOrg = dbOrgMapper.selectByPrimaryKey(dbOrgVo.getOrgId());
		String address = dbOrg.getAddress();
		EntityUtils.setUpdateInfo(dbOrg);
		dbOrg.setAddress(dbOrgVo.getAddress());
		dbOrg.setOrgFullName(dbOrgVo.getOrgFullName());
		dbOrg.setOrgName(dbOrgVo.getOrgName());
		dbOrg.setOrgPid(dbOrgVo.getOrgPid());
		dbOrg.setOrgRemark(dbOrgVo.getOrgRemark());
		dbOrg.setPerson(dbOrgVo.getPerson());
		dbOrg.setPhone(dbOrgVo.getPhone());
		dbOrg.setStatus(dbOrgVo.getStatus());
		dbOrgAreaService.addOrgRel(dbOrgVo.getOrgId(), dbOrgVo.getAreaIds());

		if (StringUtil.isEmpty(dbOrg.getPk())) {
			Map<String, String> map = blockChService.registUser(dbOrg.getOrgId(), dbOrg.getOrgName(), dbOrg.getEmail());
			if (map != null) {
				dbOrg.setPk(map.get("pk"));
				dbOrg.setSk(map.get("sk"));
			}
		}
		dbOrgMapper.updateByPrimaryKey(dbOrg);
		if (!dbOrgVo.getAddress().equals(address)) {
			homePageService.clearOrgAddressCache();
		}
	}

	@Override
	public void delete(String orgId) {
		DbOrg dbOrg = dbOrgMapper.selectByPrimaryKey(orgId);
		EntityUtils.setUpdateInfo(dbOrg);
		dbOrg.setDelStatus("DEL");
		dbOrgMapper.updateByPrimaryKey(dbOrg);
	}

	@Override
	public DbOrg getDbOrgByOrgSort(Integer orgSort) {
		DbOrgExample example = new DbOrgExample();
		DbOrgExample.Criteria criteria = example.createCriteria();
		criteria.andOrgSortEqualTo(orgSort);
		List<DbOrg> list = dbOrgMapper.selectByExample(example);
		if (!CommonUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public DbOrg getDbOrgByOrgSort(String orgId) {
		return dbOrgMapper.selectByPrimaryKey(orgId);
	}

	@Override
	public Integer getMaxOrgSort() {
		Map<String, Object> params = new HashMap<>();
		params.put("sql", "select max(org_sort) orgSort from db_org");
		Map<String, Object> record = commonService.findOne(params);
		if (record != null) {
			return (Integer) record.get("orgSort");
		}

		return 0;
	}

	/**
	 * 查询当前用户可见的所有机构的列表
	 *
	 * @return 机构列表
	 */
	@Override
	public List<DbOrg> list() {
		DbOrgExample example = new DbOrgExample();
		DbOrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		switch (CommonUtil.getAdminRole()) {
			case Constants.ROLE_CENTER_ADMIN:
				return dbOrgMapper.selectByExample(example);
			case Constants.ROLE_ADMIN:
				criteria.andOrgIdEqualTo(CommonUtil.getOrgId());
				return dbOrgMapper.selectByExample(example);
			case Constants.ROLE_COMMON:
				criteria.andOrgIdEqualTo(CommonUtil.getOrgId());
				return dbOrgMapper.selectByExample(example);
			default:
				break;
		}

		return new ArrayList<>();
	}

	@Override
	public List<DbOrg> listOfAll() {
		String sql = "SELECT org.* FROM db_org org RIGHT JOIN(\r\n" + 
				"SELECT pub_org_id pid FROM db_pub_file WHERE del_status='NOR' AND `status`='YPUB' UNION \r\n" + 
				"SELECT crt_org_id pid FROM db_pub_service WHERE del_status='NOR' AND pub_status='PUB' UNION \r\n" + 
				"SELECT pub_org_id pid FROM db_pub_table WHERE del_status='NOR' AND pub_status='YES' ) pub \r\n" + 
				"ON org.org_id = pub.pid AND org.del_status='NOR'";
		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		if (CommonUtil.isEmpty(list)) {
			return new ArrayList<>();
		}
		List<DbOrg> orgList = CommonUtil.map2PO(list, DbOrg.class);
		return orgList;
	}

	/**
	 * 查询当前用户可见的所有其它机构的列表
	 *
	 * @return 机构列表
	 */
	@Override
	public List<DbOrg> otherList() {
		DbOrgExample example = new DbOrgExample();
		DbOrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		criteria.andOrgIdNotEqualTo(CommonUtil.getOrgId());
		return dbOrgMapper.selectByExample(example);

	}

	@Override
	public ResultVo otherListForLabelManage() {
		List<DbOrg> list = otherList();
		SecLabelVo secLabelVo = new SecLabelVo();
		secLabelVo.setOrgList(list);
		ResultVo resultVo = policyApi.getOrgListHaveSecLabels();
		List<DbOrg> orgList = new ArrayList<>();
		List<Map<String, Object>> orgIdList = (List<Map<String, Object>>) resultVo.getData();
		String role = CommonUtil.getAdminRole();
		String orgId = UserUtil.getOrgId();
		Map<String, Object> mp = new HashMap<>();
		mp.put("orgId", orgId);
		if (!Constants.ROLE_CENTER_ADMIN.equals(role) && orgIdList.contains(mp)) {
			DbOrg dbOrg = dbOrgMapper.selectByPrimaryKey(orgId);
			orgList.add(dbOrg);
		} else {
			for (Map<String, Object> map : orgIdList) {
				orgId = (String) map.get("orgId");
				DbOrg dbOrg = dbOrgMapper.selectByPrimaryKey(orgId);
				orgList.add(dbOrg);
			}
		}
		return ResultVo.ok(orgList);
	}

	@Override
	public DbOrg getDbOrgByOrgId(String orgId) {
		if (orgId == null) {
			return new DbOrg();
		}

		DbOrg org = dbOrgMapper.selectByPrimaryKey(orgId);
		return Optional.ofNullable(org).orElse(new DbOrg());
	}

	@Override
	public String getOrgNameByOrgId(String orgId) {
		if (orgId == null) {
			return "";
		}

		DbOrg org = dbOrgMapper.selectByPrimaryKey(orgId);
		org = Optional.ofNullable(org).orElse(new DbOrg());
		return Optional.ofNullable(org.getOrgName()).orElse("");
	}

	@Override
	public List<DbBaseKitVo> getKitInfoByOrgId(String orgId, String type) {
		List<DbOrg> orgList = getDbOrgList(orgId);
		if (null == orgList) {
			orgList = new ArrayList<>();
		}
		if (!"all".equals(orgId)) {
			orgList.add(dbOrgMapper.selectByPrimaryKey(orgId));
		}
		Map<String, String> orgMap = new HashMap<>();
		orgList.forEach(org -> orgMap.put(org.getOrgId(), org.getOrgName()));
		if ("all".equals(orgId)) {
			orgList = null;
		}
		if ("all".equals(type)) {
			type = null;
		}
		return getBaseKitInfo(orgList, type, orgMap);
	}

	/**
	 * 获取套件信息列表
	 *
	 * @param tagType
	 * @return
	 */
	private List<DbBaseKitVo> getBaseKitInfo(List<DbOrg> orgList, String tagType, Map<String, String> orgMap) {
		List<DbBaseKitVo> list = new ArrayList<>();
		if (null == orgList && orgMap.size() > 0) {
			List<DbBaseKit> baseList = getBaseKitList(null, tagType);
			if (null != baseList && !baseList.isEmpty()) {
				list = CommonUtil.listPo2VO(baseList, DbBaseKitVo.class);
				for (DbBaseKitVo b : list) {
					setKitRunInfo(orgMap, b, tagType);
				}
			}
		} else {
			if (orgList != null) {
				for (DbOrg org : orgList) {
					String id = org.getOrgId();
					List<DbBaseKit> baseList = getBaseKitList(id, tagType);
					if (null != baseList && baseList.size() > 0) {
						list.addAll(CommonUtil.listPo2VO(baseList, DbBaseKitVo.class));
					}
				}
			}
			if (list.isEmpty()) {
				return list;
			}
			for (DbBaseKitVo b : list) {
				setKitRunInfo(orgMap, b, tagType);
				setKitShowInfo(b, tagType);
			}
		}
		return list;
	}

	private void setKitShowInfo(DbBaseKitVo b, String tagType) {
		if (Constants.DATA_TYPE_SERVICE.equalsIgnoreCase(tagType)) {
			b.setDbServiceKitVo(AsyncTask.serviceMap.get(b.getOrgId()));
		}
	}

	private void setKitRunInfo(Map<String, String> orgMap, DbBaseKitVo b, String tagType) {
		b.setOrgName(orgMap.get(b.getOrgId()));
		try {
			String runStatus = isTagRun(b.getOrgId(), b.getTagType().toLowerCase());
			b.setRunStatus(runStatus);
			if (!"true".equals(runStatus)) {
				return;
			}
			if (StringUtil.isEmpty(tagType)) {
				return;
			}
			b.setSpaceInfo(getSpaceInfo(b.getOrgId(), b.getTagType().toLowerCase()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object getSpaceInfo(String orgId, String type) {
		String key = orgId + "-" + type;
		if (AsyncTask.spaceMap.containsKey(key)) {
			return AsyncTask.spaceMap.get(key);
		}
		return null;
	}

	private String isTagRun(String orgId, String type) {
		String key = orgId + "-" + type;
		if (AsyncTask.runMap.containsKey(key)) {
			Long oldTime = AsyncTask.runMap.get(key);
			long time = System.currentTimeMillis() - oldTime;
			if (time > BIG_OUT_TIME) {
				return "false";
			}
			return "true";
		}
		return "no";
	}

	private List<DbBaseKit> getBaseKitList(String orgId, String tagType) {
		DbBaseKitExample example = new DbBaseKitExample();
		DbBaseKitExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(orgId)) {
			criteria.andOrgIdEqualTo(orgId);
		}
		if (StringUtil.isNotEmpty(tagType)) {
			criteria.andTagTypeEqualTo(tagType.toUpperCase());
		}
		criteria.andDelStatusEqualTo("NOR");
		return dbBaseKitMapper.selectByExample(example);
	}

	/**
	 * 获取机构信息列表
	 *
	 * @param orgId
	 * @return
	 */
	private List<DbOrg> getDbOrgList(String orgId) {
		if (StringUtil.isEmpty(orgId)) {
			return null;
		}
		DbOrgExample example = new DbOrgExample();
		DbOrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		if ("all".equals(orgId)) {
			return dbOrgMapper.selectByExample(example);
		}
		criteria.andOrgPidEqualTo(orgId);
		List<DbOrg> orgList = dbOrgMapper.selectByExample(example);
		if (null == orgList || orgList.size() < 1) {
			return null;
		}
		LinkedBlockingQueue<DbOrg> queue = new LinkedBlockingQueue<>(orgList);
		List<DbOrg> list = new ArrayList<>();
		DbOrg org;
		while ((org = queue.poll()) != null) {
			String id = org.getOrgId();
			List<DbOrg> oList = getChildList(id);
			if (null != oList && oList.size() > 0) {
				list.addAll(oList);
				queue.addAll(oList);
			}
		}
		orgList.addAll(list);
		return orgList;
	}

	private List<DbOrg> getChildList(String orgId) {
		DbOrgExample example = new DbOrgExample();
		DbOrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		criteria.andOrgPidEqualTo(orgId);
		return dbOrgMapper.selectByExample(example);
	}

	@Override
	public ResultVo<List<DbOrgDto>> getOrgKitInfo() {
		List<DbOrg> orgList = getOrgList();
		if (null == orgList || orgList.size() < 1) {
			return ResultVo.fail("机构信息为空");
		}
		List<DbOrgDto> orgDtoList = new ArrayList<>();
		Set<String> tSet = new HashSet<>();
		DbOrg tOrg = null;
		for (DbOrg org : orgList) {
			if (StringUtil.isEmpty(org.getOrgPid())||"0".equals(org.getOrgPid())) {
				tOrg = org;
				continue;
			}
			Set<String> set = new HashSet<>();
			String id = org.getOrgId();
			DbBaseKitExample example = new DbBaseKitExample();
			DbBaseKitExample.Criteria criteria = example.createCriteria();
			criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
			criteria.andOrgIdEqualTo(id);
			List<DbBaseKit> kitInfo = dbBaseKitMapper.selectByExample(example);
			if (null != kitInfo && kitInfo.size() > 0) {
				kitInfo.forEach(kit -> set.add(kit.getTagType().toLowerCase()));
				kitInfo.forEach(kit -> {
					String type = "";
					try {
						type = kit.getTagType().toLowerCase();
					} catch (Exception e) {
					}
					set.add(type);
					tSet.add(type);
				});
			}
			if (set.size() > 0) {
				DbOrgDto orgDto = CommonUtil.po2VO(org, DbOrgDto.class);
				orgDto.setKitInfo(set);
				orgDtoList.add(orgDto);
			}
		}
		if (null != tOrg) {
			DbOrgDto tOrgDto = CommonUtil.po2VO(tOrg, DbOrgDto.class);
			tOrgDto.setKitInfo(tSet);
			orgDtoList.add(tOrgDto);
		} else {
//			DbOrgDto tOrgDto = new DbOrgDto();
//			tOrgDto.setOrgId(orgDtoList.get(0).getOrgPid());
//			tOrgDto.setOrgName("中心套件管理");
//			tOrgDto.setOrgPid("0");
//			tOrgDto.setKitInfo(tSet);
//			orgDtoList.add(tOrgDto);
		}
		return ResultVo.ok(orgDtoList);
	}

	private List<DbOrg> getOrgList() {
		List<DbOrg> orgList = null;
		DbOrgExample example = new DbOrgExample();
		DbOrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		switch (CommonUtil.getAdminRole()) {
			case Constants.ROLE_CENTER_ADMIN:
				orgList = dbOrgMapper.selectByExample(example);
				break;
			case Constants.ROLE_ADMIN:
				criteria.andOrgIdEqualTo(CommonUtil.getOrgId());
				orgList = dbOrgMapper.selectByExample(example);
				break;
			case Constants.ROLE_COMMON:
				criteria.andOrgIdEqualTo(CommonUtil.getOrgId());
				orgList = dbOrgMapper.selectByExample(example);
				break;
			default:
				break;
		}
		return orgList;
	}

	@Override
	public ResultVo getLabelKitInfo() {
		List<DbOrg> orgList = getOrgList();
		if (null == orgList || orgList.size() < 1) {
			return ResultVo.fail("机构信息为空");
		}
		List<DbOrgDto> orgDtoList = new ArrayList<>();
		orgList.forEach(org -> {
			Set<String> set = new HashSet<>();
			String id = org.getOrgId();
			DbBaseKitExample example = new DbBaseKitExample();
			DbBaseKitExample.Criteria criteria = example.createCriteria();
			criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
			criteria.andOrgIdEqualTo(id);
			criteria.andTagTypeEqualTo("LABEL");
			List<DbBaseKit> labelInfo = dbBaseKitMapper.selectByExample(example);
			if (null != labelInfo) {
				set.add("label");
			}
			if (set.size() > 0 || "0".equals(org.getOrgPid())) {
				DbOrgDto orgDto = CommonUtil.po2VO(org, DbOrgDto.class);
				orgDto.setKitInfo(set);
				orgDtoList.add(orgDto);
			}
		});
		return ResultVo.ok(orgDtoList);
	}

	@Override
	public List<String> getOrgIdListByOrgName(String name) {
		DbOrgExample example = new DbOrgExample();
		DbOrgExample.Criteria criteria = example.createCriteria();
		criteria.andOrgNameLike("%" + name.trim() + "%");
		List<DbOrg> dbOrgList = dbOrgMapper.selectByExample(example);
		List<String> list = new ArrayList<>();
		if (CommonUtil.isNotEmpty(dbOrgList)) {
			for (DbOrg org : dbOrgList) {
				list.add(org.getOrgId());
			}
		} else {
			list.add("NULL");
		}
		return list;
	}

	@Override
	public ResultVo<List<DbOrg>> getOrgListByPub(String type) {
		String sql;
		switch (type.toLowerCase()) {
			case "file":
				sql = "SELECT o.* FROM db_org o RIGHT JOIN db_pub_file f ON o.org_id = f.pub_org_id \n" +
						"WHERE	o.del_status = 'NOR' AND f.del_status = 'NOR' AND f.`status` = 'YPUB' AND auto_change = 'false' \n" +
						"AND f.use_scope LIKE CONCAT('%',#{orgId},'%') GROUP BY f.pub_org_id";
				break;
			case "db":
				sql = "SELECT o.* FROM db_org o RIGHT JOIN db_pub_table t ON o.org_id = t.pub_org_id \n" +
						"WHERE	o.del_status = 'NOR' AND t.del_status = 'NOR' AND t.pub_status = 'YES' \n" +
						"AND (t.auth_type = 'PUB' or t.auth_scope LIKE CONCAT('%',#{orgId},'%')) GROUP BY t.pub_org_id";
				break;
			case "service":
				sql = "SELECT o.* FROM db_org o RIGHT JOIN db_pub_service s ON o.org_id = s.crt_org_id \n" +
						"WHERE	o.del_status = 'NOR' AND s.del_status = 'NOR' AND s.pub_status = 'PUB' \n" +
						"AND s.use_scope LIKE CONCAT('%',#{orgId},'%') GROUP BY s.crt_org_id";
				break;
			case "dbs":
				sql = "SELECT o.* FROM db_org o RIGHT JOIN db_pub_ts s ON o.org_id = s.pub_org_id \n" +
						"WHERE	o.del_status = 'NOR' AND s.del_status = 'NOR' AND s.pub_status = 'YES' \n" +
						"AND s.auth_scope LIKE CONCAT('%',#{orgId},'%') GROUP BY s.pub_org_id";
				break;
			default:
				return ResultVo.fail("参数错误");
		}
		String orgId = UserUtil.getOrgId();
		if (StringUtil.isEmpty(orgId)) {
			return ResultVo.fail("机构信息错误");
		}
		log.info(orgId + "---" + sql);
		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);
		params.put("orgId", orgId);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		if (CommonUtil.isEmpty(list)) {
			List<DbOrg> dbOrgs = new ArrayList<>();
			log.info("---------可订阅机构为空----------" + orgId);
			return ResultVo.ok(dbOrgs);
		}
		List<DbOrg> orgList = CommonUtil.map2PO(list, DbOrg.class);
		return ResultVo.ok(orgList);
	}

}
