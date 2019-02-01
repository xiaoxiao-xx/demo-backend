package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbOrg;
import com.microcore.api.model.Policy;
import com.microcore.api.vo.SecurityKeyVo;
import com.microcore.center.client.DbKitTemplate;
import com.microcore.center.client.KeymanagerTemplate;
import com.microcore.center.client.PolicyTemplate;
import com.microcore.center.dto.*;
import com.microcore.common.vo.WithdrawPubVo;
import com.microcore.center.mapper.DbColumnCommentMapper;
import com.microcore.center.mapper.DbPubColumnMapper;
import com.microcore.center.mapper.DbPubTableExtMapper;
import com.microcore.center.mapper.DbPubTableMapper;
import com.microcore.center.mapper.DbPubTableRelMapper;
import com.microcore.center.model.*;
import com.microcore.center.model.DbPubColumnExample.Criteria;
import com.microcore.center.service.*;
import com.microcore.center.vo.DbPubTableVo;
import com.microcore.common.constant.Constants;
import com.microcore.common.dto.DbModelDetailDto;
import com.microcore.common.dto.DbModelDto;
import com.microcore.common.exception.CommonException;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.microcore.common.config.ConstantConfig.convertAuthTypeToChinese;
import static com.microcore.common.config.ConstantConfig.convertSecurityLevelToChinese;
import static com.microcore.common.constant.Constants.*;
import static com.microcore.common.util.CommonUtil.*;
import static com.microcore.common.util.StringUtil.isEmpty;
import static com.microcore.common.util.StringUtil.isNotEmpty;
import static com.microcore.common.util.UserUtil.getOrgId;
import static com.microcore.common.util.UserUtil.getUserId;
import static java.util.Collections.singletonList;

/**
 * 库表发布
 *
 * @author lmh
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class DbPubTableServiceImpl implements DbPubTableService {

	@Autowired
	private CommonService commonService;

	@Autowired
	private UserService userService;

	@Autowired
	private DbPubTableMapper dbPubTableMapper;

	@Autowired
	private DbOrgService dbOrgService;

	@Autowired
	private DbPubColumnMapper dbPubColumnMapper;

	@Autowired
	private IDService idService;

	@Autowired
	private DbKitTemplate dbKitTemplate;

	@Autowired
	private PolicyTemplate policyTemplate;

	@Autowired
	private DbModelService dbModelService;

	@Autowired
	private DbParamsService dbParamsService;

	@Autowired
	private DbPubTableExtMapper dbPubTableExtMapper;

	@Autowired
	private DbColumnCommentMapper dbColumnCommentMapper;

	@Autowired
	private DbColumnCommentService dbColumnCommentService;

	@Autowired
	private KeymanagerTemplate keymanagerTemplate;

	@Autowired
	private DbSubTableService dbSubTableService;

	@Autowired
	private DbPolicyEncryptService dbPolicyEncryptService;

	@Autowired
	private DbPubTableRelMapper dbPubTableRelMapper;

	@Autowired
	private DbOrgAreaService dbOrgAreaService;

	@Autowired
	private BlockChService blockChService;

	@Autowired
	private DbNameSpaceService dbNameSpaceService;

	/**
	 * 提交发布信息
	 */
	@Override
	public ResultVo submitTablePubInfo(DbPubTableVo dbPubTableVo) {
		DbPubTable dbPubTable = po2VO(dbPubTableVo, DbPubTable.class);

		String tableId = getUUID();
		dbPubTable.setId(tableId);

		// 将时间设置为 1970-01-01, 00:00:00，这样保证了最后访问时间不为空
		dbPubTable.setLastFetchTime(new Date(0));
		// 未用字段
		dbPubTable.setTriggerType("--");

		// 设置make_table_name字段
		String makeTableName = "sls_tb_" + getUniqueTableNameSuffix();
		dbPubTable.setMakeTableName(makeTableName);
		if (isEmpty(dbPubTable.getTableName())) {
			dbPubTable.setTableName(makeTableName);
		} else {
			String versionId = dbPubTableVo.getDbVersionId();
			if (DM_TYPE == Integer.parseInt(versionId)) {
				dbPubTable.setTableName(dbPubTable.getSourceDbName().toUpperCase() + "."
						+ dbPubTable.getTableName().toUpperCase());
			}
		}
		dbPubTable.setRunStatus(RUN_STATUS_STOP);
		// 设置发布状态为未发布
		dbPubTable.setPubStatus(PUB_STATUS_NO);

		String currentUserId = getUserId();
		dbPubTable.setPubUserId(currentUserId);
		String currentOrgId = getOrgId();
		dbPubTable.setPubOrgId(currentOrgId);
		// 未定字段
		dbPubTable.setExtractType("--");
		dbPubTable.setTemplateId(dbPubTableVo.getTemplateId());
		Map<String, DbPolicyEncrypt> dbPolicyEncryptMap = null;
		if (isNotEmpty(dbPubTableVo.getTemplateId())) {
			dbPolicyEncryptMap = dbPolicyEncryptService.getDbPolicyEncryptMap(dbPubTableVo.getTemplateId());
		}
		Integer taskId = idService.getTaskId();
		dbPubTable.setTaskId(taskId);

		EntityUtils.setCreateAndUpdateInfo(dbPubTable);

		List<String> authScopes = new ArrayList<>();

		List<DbPubColumnDto> pubColumnDto = dbPubTableVo.getPubColumnDto();
		int index = 1;
		String dSensitivity = "";
		String authType = null;
		Map<String, DbOrg> orgMap = new HashMap<>();
		for (DbPubColumnDto dto : pubColumnDto) {
			dto.setTableName(dbPubTable.getTableName());

			DbPubColumn dbPubColumn = po2VO(dto, DbPubColumn.class);
			dbPubColumn.setId(getUUID());
			dbPubColumn.setPid(tableId);
			dbPubColumn.setEncryptType("--");
			if (dbPolicyEncryptMap != null) {
				DbPolicyEncrypt dbPolicyEncrypt = dbPolicyEncryptMap.get(dbPubColumn.getSecurityLevel());
				if (dbPolicyEncrypt != null) {
					dbPubColumn.setEncryptType(dbPolicyEncrypt.getEncryptTypeId());
				}
			}
			if (AUTH_TYPE_REGION.equals(dbPubColumn.getAuthType())) {
				String authScope = dbOrgAreaService.getOrgIds(dbPubColumn.getAuthScope());
				dbPubColumn.setAuthType(AUTH_TYPE_ORG);
				dbPubColumn.setAuthScope(authScope);
			} else if (isEmpty(dbPubColumn.getAuthScope())) {
				dbPubColumn.setAuthType(PUB);
				authType = PUB;
			}

			if (!PUB.equals(authType)) {
				authType = AUTH_TYPE_ORG;
			}
			dbPubTable.setAuthType(authType);

			authScopes.add(dbPubColumn.getAuthScope());
			dbPubColumn.setSort(index++);

			// 保存扩展信息
			List<DbPubTableExtDto> pubTableExtDtos = dto.getPubTableExtDtos();
			Map<String, DbPubTableExtDto> dbPubTableExtDtoMap = new HashMap<>();
			pubTableExtDtos.forEach(dbPubTableExtDto ->
					dbPubTableExtDtoMap.put(dbPubTableExtDto.getExtAttrEname(), dbPubTableExtDto));
			DbPubTableExtDto dbPubTableExtDto = dbPubTableExtDtoMap.get("sybj");
			String sybj = YES;
			if (dbPubTableExtDto != null) {
				sybj = TRUE.equals(dbPubTableExtDto.getExtValue()) ? YES : NO;
			}
			dbPubColumn.setTraceMark(sybj);
//			dto.setTraceMark(sybj);
//			dto.setEncryptType(dbPubColumn.getEncryptType());
			// 生成策略
			Policy policy = buildPolicy(dbPubTable, dbPubColumn);
			// 向策略服务上传策略
			policyTemplate.addPolicy(policy);

			dbPubColumn.setPolId(policy.getPolId());
			String labelId = dbPubTable.getId();

			// 产生密钥信息
			SecurityKeyVo securityKeyVo = new SecurityKeyVo();
			String[] authOrgs = policy.getPolAuthScope().split(",");
			List<DbOrg> listOrg = new ArrayList<>();
			for (String orgId : authOrgs) {
				DbOrg dbOrg = orgMap.get(orgId);
				if (dbOrg == null) {
					dbOrg = dbOrgService.getDbOrgByOrgId(orgId);
					if (dbOrg == null) {
						continue;
					}
					orgMap.put(orgId, dbOrg);
				}
				if (dbOrg != null && dbOrg.getOrgId() != null) {
					listOrg.add(dbOrg);
				}
			}
			securityKeyVo.setOrgs(listOrg);
			securityKeyVo.setLabelId(labelId);
			securityKeyVo.setPolicyId(policy.getPolId());
			//需要加密的字段，则在秘钥中心产生秘钥
			if (!"2".equals(policy.getPolEncryptType()) || YES.equals(policy.getTraceMark())) {
				if (!CommonUtil.isEmpty(listOrg)) {
					keymanagerTemplate.addSecurity(securityKeyVo);
				} else if (PUB.equals(dbPubColumn.getAuthType())) {
					DbOrg org = new DbOrg();
					org.setOrgId(PUBLIC_ORG_ID);
					org.setKeyValue(PUBLIC_ORG_KEY_VALUE);
					securityKeyVo.setOrgs(singletonList(org));
					keymanagerTemplate.addSecurity(securityKeyVo);
				}
			}

			pubTableExtDtos.forEach(extDto -> {
				extDto.setId(dbPubColumn.getId());
				extDto.setTemplateType(COLUMN);
				extDto.setLabelId(tableId);
			});
			saveExtInfo(pubTableExtDtos);
			dbPubColumnMapper.insert(dbPubColumn);
			dSensitivity = dbPubColumn.getSecurityLevel();
		}

		List<DbPubTableRel> pubTableRels = dbPubTableVo.getPubTableRels();
		if (!CommonUtil.isEmpty(pubTableRels)) {
			pubTableRels.forEach((pubTableRel) -> {
				pubTableRel.setId(getUUID());
				pubTableRel.setPubId(dbPubTable.getId());
				dbPubTableRelMapper.insert(pubTableRel);
			});
		}
		// 保存自定义注释
		saveColumnComment(dbPubTable, pubColumnDto);

		// 构建db_pub_table.auth_scope字段
		// 将List<String>拼接成内部以逗号分隔的字符串
		String authScopeStr = authScopes.stream().map(x -> x.split(","))
				.flatMap(Arrays::stream).distinct()
				.collect(Collectors.joining(","));

		dbPubTable.setAuthScope(authScopeStr);
		dbPubTableMapper.insert(dbPubTable);
		String domain = dbNameSpaceService.getCnameById(dbPubTable.getDataType());
		try {
			blockChService.dataPubAndShare(dbPubTable.getId(), domain, dSensitivity, "table", authScopeStr);
		} catch (Exception e) {
			log.error("对接区块链出错", e);
		}

		// 保存扩展信息
		List<DbPubTableExtDto> pubTableExtDtos = dbPubTableVo.getPubTableExtDtos();
		pubTableExtDtos.forEach(extDto -> {
			extDto.setId(tableId);
			extDto.setTemplateType(Constants.MODEL);
			extDto.setLabelId(tableId);
		});
		saveExtInfo(pubTableExtDtos);
		return ResultVo.ok();
	}

	@Override
	public String getUniqueTableNameSuffix() {
		Integer suffix = idService.getBusinessNumber("table_suffix");
		return new DecimalFormat("00000000").format(suffix);
	}

	@Override
	public DbPubTable getDbPubTableById(String id) {
		return dbPubTableMapper.selectByPrimaryKey(id);
	}

	/**
	 * 保存自定义注释
	 *
	 * @param columnDtoList 字段列表
	 */
	private void saveColumnComment(DbPubTable pubTable, List<DbPubColumnDto> columnDtoList) {
		String conId = pubTable.getSourceDbId();
		columnDtoList.forEach(column -> {
			String columnName = column.getColumnName();
			String currentColumnComment = column.getColumnComment();
			if (currentColumnComment == null) {
				currentColumnComment = "";
			}
			String tableName = column.getTableName();
			DbColumnComment columnComment = dbColumnCommentService.getColumnComment(conId, tableName, columnName);
			if (!currentColumnComment.equals(columnComment.getComment())) {
				columnComment.setComment(columnComment.getComment());
				dbColumnCommentMapper.updateByPrimaryKey(columnComment);
			}
		});
	}

	/**
	 * 保存扩展信息
	 *
	 * @param dbPubTableExtDtoList 扩展信息列表
	 */
	private void saveExtInfo(List<DbPubTableExtDto> dbPubTableExtDtoList) {
		List<DbPubTableExt> dbPubTableExtList = listPo2VO(dbPubTableExtDtoList, DbPubTableExt.class);
		dbPubTableExtList.forEach(dbPubTableExtMapper::insert);
	}

	/**
	 * 构造策略对象
	 *
	 * @param dbPubTable 发布的表
	 * @param dto        列信息
	 * @return 策略对象
	 */
	private Policy buildPolicy(DbPubTable dbPubTable, DbPubColumn dto) {
		String labelId = dbPubTable.getId();
		String tableName = dbPubTable.getTableName();
		Integer taskId = dbPubTable.getTaskId();
		String polId = getUUID();
		String resId = dbPubTable.getSourceDbName() + "-" + tableName;

		Policy policy = new Policy();
		policy.setPolId(polId);
		// labelId is just pub_table.id
		policy.setLabelId(labelId);
		policy.setTaskId(taskId);
		policy.setTableName(tableName);
		// 未用字段
		policy.setTableId(0);
		policy.setPolColumn(dto.getColumnName());
		policy.setPolColumnType(dto.getColumnType());
		policy.setPolColumnId(dto.getSort());
		policy.setPolComment(dto.getColumnComment());
		policy.setPolResType(DATA_TYPE_DB);
		// 暂时定为1
		policy.setPolVersion(1);
		policy.setPolPublish(getUserId());
		policy.setPolResId(resId);
		policy.setPolAuthScope(dto.getAuthScope());
		policy.setPolAuthType(dto.getAuthType());
		policy.setPolSecurityLevel(dto.getSecurityLevel());
		policy.setPolAuthStart(dto.getAuthStartTime());
		policy.setPolAuthEnd(dto.getAuthEndDate());
		// 未用字段
		policy.setTwice("--");
		// 未用字段
		policy.setFrequency("--");
		// 未定字段
		policy.setStatus("--");
		policy.setTraceMark(dto.getTraceMark());
		policy.setDelStatus(DEL_STATUS_NOR);
		policy.setUpdUserId(getUserId());
		policy.setUpdOrgId(getOrgId());
		policy.setUpdTm(getCurrentTime());
		policy.setCrtUserId(getUserId());
		policy.setCrtOrgId(getOrgId());
		policy.setCrtTm(getCurrentTime());
		policy.setPolEncryptType(dto.getEncryptType());
		return policy;
	}

	/**
	 * 分页获取发布列表
	 *
	 * @param pubStatus 发布状态
	 * @param pageIndex 页码
	 * @param pageSize  每页大小
	 * @return 发布列表
	 */
	@Override
	public ResultVo<List<DbPubTableDto>> getPubList(String pubStatus, Integer pageIndex,
	                                                Integer pageSize, String orgId) {
		if (!(pubStatus.equals(PUB_STATUS_YES) || pubStatus.equals(PUB_STATUS_NO))) {
			return ResultVo.fail("发布状态参数只能是YES或者NO");
		}

		if (isEmpty(orgId)) {
			// 只查询当前机构的发布
			orgId = getOrgId();
		}

		// 查询数据
		String sql = "select db_pub_table.*, db_model.model_name from db_pub_table left JOIN db_model on "
				+ "db_pub_table.model_id = db_model.id where db_pub_table.del_status <> 'DEL'";
		if (pubStatus != null) {
			if (YES.equals(pubStatus)) {
				sql += " and pub_status = #{pubStatus}";
			} else {
				// NO, APPROVING两种状态
				sql += " and pub_status <> 'YES'";
			}
		}
		sql += " and pub_org_id = #{pubOrgId}";
		if (pageIndex != null && pageSize != null) {
			sql += getPageSQL(pageIndex * pageSize, pageSize);
		}

		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);
		params.put("pubStatus", pubStatus);
		params.put("pubOrgId", orgId);

		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		if (CommonUtil.isEmpty(list)) {
			return ResultVo.ok(new ArrayList<>());
		}

		List<DbPubTableDto> dtoList = map2PO(list, DbPubTableDto.class);
		andMorePubTableInfo(dtoList);

		return ResultVo.ok(dtoList);
	}

	/**
	 * 分页获取发布列表
	 *
	 * @param pubStatus 发布状态
	 * @param pubName
	 * @param pageIndex 页码
	 * @param pageSize  每页大小
	 */
	@Override
	public ResultVo<PageInfo<DbPubTableDto>> getPubList2(String pubStatus, String pubName, Integer pageIndex,
	                                                     Integer pageSize) {
		DbPubTableExample example = new DbPubTableExample();

		// 如果未发布，按创建时间倒排序
		// 如果已经发布，按发布时间倒排序
		if (isNotEmpty(pubStatus)) {
			if (YES.equals(pubStatus)) {
				example.setOrderByClause("publish_time desc");
			} else {
				example.setOrderByClause("crt_tm desc");
			}
		}

		DbPubTableExample.Criteria criteria = example.createCriteria();
		if (isNotEmpty(pubStatus)) {
			if (YES.equals(pubStatus)) {
				criteria.andPubStatusEqualTo(pubStatus);
			} else {
				criteria.andPubStatusNotEqualTo(YES);
			}
		}

		String orgId = getOrgId();
		if (isNotEmpty(orgId)) {
			criteria.andPubOrgIdEqualTo(orgId);
		}
		criteria.andDelStatusEqualTo(DEL_STATUS_NOR);
		if (isNotEmpty(pubName)) {
			criteria.andPubNameLike("%" + pubName.trim() + "%");
		}
		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		PageInfo<DbPubTable> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbPubTableMapper.selectByExample(example));
		List<DbPubTable> tableList = pageInfo.getList();
		if (tableList == null) {
			tableList = new ArrayList<>();
		}

		List<DbPubTableDto> data = listPo2VO(tableList, DbPubTableDto.class);
		andMorePubTableInfo2(data);
		PageInfo<DbPubTableDto> pageInfoDto = po2VO(pageInfo, PageInfo.class);
		pageInfoDto.setList(data);

		return ResultVo.ok(pageInfoDto);
	}

	/**
	 * 分页获取其它机构发布列表（即本机构可订阅列表）
	 *
	 * @param pageIndex  页码
	 * @param pageSize   每页大小
	 * @param pubName
	 * @param pubOrgName
	 */
	@Override
	public ResultVo<PageInfo<DbPubTableDto>> getOthersPubList(String pubStatus, Integer pageIndex,
	                                                          Integer pageSize, String orgId,
	                                                          String pubName, String pubOrgName) {
		if (!(pubStatus.equals(PUB_STATUS_YES) || pubStatus.equals(PUB_STATUS_NO))) {
			return ResultVo.fail("发布状态参数只能是YES或者NO");
		}
		String currentUserOrgId = getOrgId();

		Map<String, Object> map = new HashMap<>(2);

		StringBuilder sb = new StringBuilder();
		sb.append("from db_pub_table where 1 = 1 ");

		// 其它机构发布了的才能订阅
		sb.append(" and pub_status = 'YES' ");
		sb.append(" and del_status = 'NOR' ");

		// 只查询其它机构的发布
		if (isNotEmpty(orgId)) {
			sb.append("and pub_org_id = #{orgId} ");
			map.put("orgId", orgId);
			sb.append("and ( auth_type = 'PUB' or auth_scope like '%").append(currentUserOrgId).append("%')");
		} else {
			// 如果orgId为空，则一条数据也不查出来
			sb.append("and pub_org_id = '123' ");
		}

		if (isNotEmpty(pubName) && !pubName.equals("undefined")) {
			sb.append(" and pub_name like '%").append(pubName.trim()).append("%'");
		}

		if (isNotEmpty(pubOrgName)) {
			List<String> orgIdList = getPubOrgIdLikeName(pubOrgName);

			if (!(orgIdList.size() == 1 && orgIdList.get(0).equals("NULL"))) {
				sb.append(" and pub_org_id in (").append(CommonUtil.getCommaString(orgIdList)).append(")");
			}
		}
		sb.append(" order by publish_time desc");
		String countSql = sb.toString();
		sb.append(" limit ").append((pageIndex - 1) * pageSize).append(", ").append(pageSize);

		// 查询数据
		String selectSql = "select * " + sb.toString();
		map.put("sql", selectSql);
		List<Map<String, Object>> resultList = commonService.executeSelectSQL(map);

		// 获取总量
		map.put("sql", countSql);
		Long count = commonService.executeGetCount(map);

		PageHelper.startPage(pageIndex, pageSize);
		List<DbPubTable> othersPub = map2PO(resultList, DbPubTable.class, true);
		if (othersPub == null) {
			othersPub = new ArrayList<>();
		}

		PageInfo<DbPubTable> pageInfo = new PageInfo<>(othersPub);

		pageInfo.setTotal(count.intValue());
		int pages = count.intValue() / pageSize;
		if (count % pageSize != 0) {
			pages += 1;
		}
		pageInfo.setPages(pages);

		List<DbPubTable> list = Optional.ofNullable(pageInfo.getList()).orElse(new ArrayList<>());
		List<DbPubTableDto> data = listPo2VO(list, DbPubTableDto.class);
		andMorePubTableInfo(data);
		PageInfo<DbPubTableDto> dtoPageInfo = po2VO(pageInfo, PageInfo.class);
		dtoPageInfo.setList(data);

		return ResultVo.ok(dtoPageInfo);
	}

	private List<String> getPubOrgIdLikeName(String pubOrgName) {
		return dbOrgService.getOrgIdListByOrgName(pubOrgName.trim());
	}

	/**
	 * 为查询结果列表添加更多信息
	 *
	 * @param list DbPubTableDto列表
	 */
	private void andMorePubTableInfo(List<DbPubTableDto> list) {
		list.forEach(this::andMorePubTableInfo);
	}

	private void andMorePubTableInfo2(List<DbPubTableDto> list) {
		list.forEach(this::andMorePubTableInfo2);
	}

	/**
	 * 为查询结果添加更多信息
	 *
	 * @param table DbPubTableDto对象
	 */
	private void andMorePubTableInfo(DbPubTableDto table) {
		table.setModelName(dbModelService.getModelNameById(table.getModelId()));
		table.setPubUserName(userService.getUserNameById(table.getPubUserId()));
		table.setPubOrgName(dbOrgService.getOrgNameByOrgId(table.getPubOrgId()));
		table.setCreateUserName(userService.getUserNameById(table.getCrtUserId()));
		table.setCreateOrgName(dbOrgService.getOrgNameByOrgId(table.getPubOrgId()));
		table.setDataTypeStr(dbParamsService.getParamsValueByTypeAndKey(PARAMS_TYPE_DATA_CATE, table.getDataType()));

		if (canBeWithdrawn(table.getId())) {
			table.setCanBeWithdrawn("YES");
		} else {
			table.setCanBeWithdrawn("NO");
		}

		List<DbPubColumnDto> list = table.getPubColumnDto();

		list.forEach(dto -> {
			// 转敏感等级为中文
			dto.setSecurityLevel(convertSecurityLevelToChinese(dto.getSecurityLevel()));

			// 将授权范围转为机构或域名
			dto.setAuthScope(convertAuthScope(dto));
			dto.setAuthType(convertAuthTypeToChinese(dto.getAuthType()));
		});
	}

	private void andMorePubTableInfo2(DbPubTableDto table) {
		table.setPubUserName(userService.getUserNameById(table.getPubUserId()));
		table.setCreateUserName(userService.getUserNameById(table.getCrtUserId()));
		table.setCreateOrgName(dbOrgService.getOrgNameByOrgId(table.getPubOrgId()));
		table.setDataTypeStr(dbParamsService.getParamsValueByTypeAndKey(PARAMS_TYPE_DATA_CATE, table.getDataType()));

		if (canBeWithdrawn(table.getId())) {
			table.setCanBeWithdrawn("YES");
		} else {
			table.setCanBeWithdrawn("NO");
		}
	}

	/**
	 * 判断一个库表发布是否可以撤回
	 *
	 * @param id 发布ID
	 * @return true-可以撤回, false-不可撤回
	 */
	private boolean canBeWithdrawn(String id) {
		DbPubTableExtExample example = new DbPubTableExtExample();
		DbPubTableExtExample.Criteria criteria = example.createCriteria();
		criteria.andLabelIdEqualTo(id);
		List<DbPubTableExt> tableExtList = dbPubTableExtMapper.selectByExample(example);
		if (tableExtList.size() == 0) {
			return false;
		}

		return tableExtList.stream().anyMatch(x -> "auth_type".equals(x.getExtAttrEname()));
	}

	/**
	 * 设置发布状态
	 *
	 * @param id     发布ID
	 * @param status 发布状态
	 */
	@Override
	public void setPubStatus(String id, String status) {
		DbPubTable dbPubTable = new DbPubTable();
		dbPubTable.setId(id);
		dbPubTable.setPubStatus(status);
		dbPubTableMapper.updateByPrimaryKeySelective(dbPubTable);
	}

	@Override
	public List<DbPubColumnDto> getDbPubColumns(String pid) {
		DbPubColumnExample example = new DbPubColumnExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		List<DbPubColumn> list = dbPubColumnMapper.selectByExample(example);
		return listPo2VO(list, DbPubColumnDto.class);
	}

	public List<DbPubTableRel> getDbPubTableRel(String pubId) {
		DbPubTableRelExample example = new DbPubTableRelExample();
		DbPubTableRelExample.Criteria criteria = example.createCriteria();
		criteria.andPubIdEqualTo(pubId);
		return dbPubTableRelMapper.selectByExample(example);
	}

	/**
	 * 发布库表
	 * 有两种发布方式：
	 * 1. 无审批直接发布
	 * 2. 先审批，审批通过才下发
	 *
	 * @param id 发布ID
	 * @return 发布结果
	 */
	@Override
	public ResultVo pubTable(String id) {
		DbPubTable table = dbPubTableMapper.selectByPrimaryKey(id);

		// 已经删除的不能再发布
		if (Constants.DEL_STATUS_DEL.equals(table.getDelStatus())) {
			return ResultVo.fail("已经删除，不能发布");
		}

		// 已经发布的不能再发布
		String pubStatus = table.getPubStatus();
		if (YES.equals(pubStatus)) {
			return ResultVo.ok();
		}

		// 更改发布状态
		DbPubTable dbPubTable = new DbPubTable();
		dbPubTable.setId(id);
		dbPubTable.setPubStatus(PUB_STATUS_YES);
		dbPubTable.setPublishTime(getCurrentTime());
		dbPubTableMapper.updateByPrimaryKeySelective(dbPubTable);

		// 构造DbPubTableDto对象
		DbPubTable pubTable = dbPubTableMapper.selectByPrimaryKey(id);
		DbPubTableDto tableDto = po2VO(pubTable, DbPubTableDto.class);

		// 查询出所有相关的DbPubColumn对象
		List<DbPubColumnDto> dtoList = getDbPubColumns(id);
		tableDto.setPubColumnDto(dtoList);

		List<DbPubTableRel> listPubTableRel = getDbPubTableRel(id);
		tableDto.setPubTableRel(listPubTableRel);

		if (isEmpty(tableDto.getModelId())) {
			// 添加模型
			addModel(tableDto);
		} else {
			dbModelService.updateModelPubCount(tableDto.getModelId());
		}
		DbModel model = dbModelService.getModelById(tableDto.getModelId());
		DbModelDto modelDto = po2VO(model, DbModelDto.class);
		modelDto.setPubId(id);
		modelDto.setOrgName(dbOrgService.getOrgNameByOrgId(dbPubTable.getPubOrgId()));
		List<DbModelDetail> details = dbModelService.getDbModelDetail(tableDto.getModelId());
		List<com.microcore.common.dto.DbModelDetailDto> detailList = listPo2VO(details,
				com.microcore.common.dto.DbModelDetailDto.class);
		for (DbModelDetailDto dto : detailList) {
			List<com.microcore.common.model.DbPubTableExt> extList = dto.getExtList();

			DbPubTableExtExample extExample = new DbPubTableExtExample();
			DbPubTableExtExample.Criteria criteria = extExample.createCriteria();
			criteria.andIdEqualTo(dto.getId());
			List<DbPubTableExt> pubTableExts = dbPubTableExtMapper.selectByExample(extExample);
			List<com.microcore.common.model.DbPubTableExt> pubTableExtList = listPo2VO(pubTableExts,
					com.microcore.common.model.DbPubTableExt.class);
			extList.addAll(pubTableExtList);
		}

		modelDto.setModelDetailDtoList(detailList);

		List<com.microcore.common.model.DbPubTableExt> extList = modelDto.getExtList();
		DbPubTableExtExample extExample = new DbPubTableExtExample();
		DbPubTableExtExample.Criteria criteria = extExample.createCriteria();
		criteria.andIdEqualTo(modelDto.getId());
		List<DbPubTableExt> pubTableExts = dbPubTableExtMapper.selectByExample(extExample);
		List<com.microcore.common.model.DbPubTableExt> pubTableExtList = listPo2VO(pubTableExts,
				com.microcore.common.model.DbPubTableExt.class);
		extList.addAll(pubTableExtList);

		// 生成标签XML字符串
		ResultVo<?> resultVo = policyTemplate.generateLabelXml(modelDto);
		if (resultVo == null || resultVo.getStatus() != 200) {
			throw new CommonException("XML标签生成失败");
		}

		// 下发发布信息
		// 通知节点改发布状态，节点生成打标表结构
		dbKitTemplate.saveTablePubInfo(tableDto);

		return ResultVo.ok();
	}

	/**
	 * 批量发布库表
	 *
	 * @param idList@return
	 */
	@Override
	public ResultVo pubTableBatch(List<String> idList) {
		idList.forEach(this::pubTable);
		return ResultVo.ok();
	}

	/**
	 * 发布库表时同时生成模型
	 *
	 * @param tableDto 要发布的表信息
	 */
	private void addModel(DbPubTableDto tableDto) {
		List<DbPubColumnDto> list = tableDto.getPubColumnDto();

		String modelName = tableDto.getTableName();
		modelName = modelName.substring(modelName.indexOf(".") + 1);//达梦表名是PERSON.PERSON形式
		String dataLevel = tableDto.getDataType();
		String tableComment = tableDto.getTableComment();
		String suffix = "";
		if (isNotEmpty(tableComment)) {
			suffix = "-" + tableComment;
		}
		String desc = modelName + suffix;
		List<DbModelDetail> detailList = new ArrayList<>();
		for (DbPubColumn column : list) {
			DbModelDetail detail = new DbModelDetail();
			detail.setFieldEname(column.getColumnName());
			detail.setFieldCname(column.getColumnComment());
			detail.setFieldType("自定义");
			detail.setType(column.getColumnType());
			detail.setFieldDesc(column.getColumnComment());
			detailList.add(detail);
		}

		ResultVo<String> resultVo = dbModelService.addDbModel(modelName, dataLevel, desc, detailList);
		String modelId = resultVo.getData();

		// 更改model_id
		DbPubTable table = new DbPubTable();
		table.setId(tableDto.getId());
		String currentUserId = UserUtil.getUserId();
		table.setModelPublisher(currentUserId);
		table.setModelId(modelId);
		dbPubTableMapper.updateByPrimaryKeySelective(table);

		// 下发的数据中也要有model_publisher等数据
		tableDto.setModelPublisher(currentUserId);
		tableDto.setModelId(modelId);
	}

	@Override
	public void setRunStatus(String id, String status) {
		DbPubTable pubTable = new DbPubTable();
		pubTable.setId(id);
		pubTable.setRunStatus(status);
		dbPubTableMapper.updateByPrimaryKeySelective(pubTable);
	}

	/**
	 * 启动发布
	 * 将已经发布的库表发布的状态改成RUN
	 *
	 * @param id 发布ID
	 * @return 启动结果
	 */
	@Override
	public ResultVo<String> startPub(String id) {
		// 更新状态
		setRunStatus(id, RUN_STATUS_RUN);
		// 通知节点启动
		dbKitTemplate.startPub(id);
		return ResultVo.ok();
	}

	@Override
	public ResultVo batchStartPub(List<String> idList) {
		idList.forEach(this::startPub);
		return ResultVo.ok();
	}

	/**
	 * 停止发布
	 * 将已经发布的库表发布的状态改成STOP
	 *
	 * @param id 发布ID
	 * @return 停止结果
	 */
	@Override
	public ResultVo stopPub(String id) {
		// 更新状态
		setRunStatus(id, RUN_STATUS_STOP);
		dbKitTemplate.stopPub(id);
		return ResultVo.ok();
	}

	@Override
	public ResultVo batchStopPub(List<String> idList) {
		idList.forEach(this::stopPub);
		return ResultVo.ok();
	}

	/**
	 * 完成发布
	 * 将已经发布的库表发布的状态改成DONE
	 *
	 * @param id 发布ID
	 * @return 停止结果
	 */
	@Override
	public ResultVo<String> donePub(String id) {
		setRunStatus(id, RUN_STATUS_DONE);
		return ResultVo.ok();
	}

	// TODO 测试

	/**
	 * 更新发布
	 *
	 * @param dbPubTableVo DbPubTableVo对象
	 * @return 更新结果
	 */
	@Override
	public ResultVo updatePub(DbPubTableVo dbPubTableVo) {
		// 已经发布的的不能修改
		String id = dbPubTableVo.getId();
		DbPubTable pubTable = dbPubTableMapper.selectByPrimaryKey(id);
		String pubStatus = pubTable.getPubStatus();

		if (PUB_STATUS_YES.equals(pubStatus)) {
			return ResultVo.fail("已经发布，不能再修改");
		}

		DbPubTable dbPubTable = po2VO(dbPubTableVo, DbPubTable.class);
		EntityUtils.setUpdateInfo(dbPubTable);

		DbPubColumnExample example = new DbPubColumnExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(dbPubTableVo.getId());
		dbPubColumnMapper.deleteByExample(example);

		List<DbPubColumnDto> pubColumnDto = dbPubTableVo.getPubColumnDto();

		List<String> authScopes = new ArrayList<>();
		for (DbPubColumnDto dto : pubColumnDto) {
			DbPubColumn dbPubColumn = po2VO(dto, DbPubColumn.class);
			dbPubColumn.setId(getUUID());
			dbPubColumn.setPid(dbPubTableVo.getId());

			String useScope = dbPubColumn.getAuthScope();
			authScopes.add(useScope);
			// TODO 更新策略
			dbPubColumn.setAuthType(dbPubColumn.getAuthType());
			dbPubColumnMapper.insert(dbPubColumn);
		}

		String authScopeStr = authScopes.stream().map(x -> x.split(",")).flatMap(Arrays::stream)
				.distinct().collect(Collectors.joining(","));
		dbPubTable.setAuthScope(authScopeStr);
		dbPubTableMapper.updateByPrimaryKeySelective(dbPubTable);

		return ResultVo.ok();
	}

	/**
	 * 删除发布
	 *
	 * @param id 发布ID
	 * @return 删除结果
	 */
	@Override
	public ResultVo deletePub(String id) {
		DbPubTable dbPubTable = dbPubTableMapper.selectByPrimaryKey(id);

		// 删除已经发布的
		if (dbPubTable.getPubStatus().equals(PUB_STATUS_YES)) {
			// 通知节点删除
			dbKitTemplate.deletePub(id);
		}

		dbPubTable.setDelStatus(Constants.DEL_STATUS_DEL);
		dbPubTableMapper.updateByPrimaryKeySelective(dbPubTable);

		// 删除db_pub_column表中数据
		DbPubColumnExample example = new DbPubColumnExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(id);
		dbPubColumnMapper.deleteByExample(example);

		// 删除扩展属性
		DbPubTableExtExample dbPubTableExtExample = new DbPubTableExtExample();
		DbPubTableExtExample.Criteria extExampleCriteria = dbPubTableExtExample.createCriteria();
		extExampleCriteria.andLabelIdEqualTo(dbPubTable.getId());
		dbPubTableExtMapper.deleteByExample(dbPubTableExtExample);

		return ResultVo.ok();
	}

	@Override
	public ResultVo batchDeletePub(List<String> idList) {
		idList.forEach(this::deletePub);
		return ResultVo.ok();
	}

	/**
	 * 清理缓存
	 *
	 * @param id 发布ID
	 */
	@Override
	public void clearCache(String id) {
		dbKitTemplate.clearPubCache(id);
	}

	/**
	 * 根据ID查询库表发布
	 *
	 * @param id 发布ID
	 * @return DbPubTable对象
	 */
	@Override
	public DbPubTable getPubTableById(String id) {
		return dbPubTableMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据ID查询库表发布任务信息
	 *
	 * @param id 发布ID
	 * @return 任务名
	 */
	@Override
	public TaskInfo getTaskInfoById(String id) {
		DbPubTable pubTable = getPubTableById(id);
		if (pubTable == null) {
			pubTable = new DbPubTable();
		}

		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskName(Optional.ofNullable(pubTable.getPubName()).orElse(""));
		taskInfo.setTaskDesc(Optional.ofNullable(pubTable.getPubDesc()).orElse(""));

		return taskInfo;
	}

	private List<DbPubTableExtDto> getExtDtos(String id) {
		DbPubTableExtExample extExample = new DbPubTableExtExample();
		DbPubTableExtExample.Criteria criteria1 = extExample.createCriteria();
		criteria1.andIdEqualTo(id);
		List<DbPubTableExt> dbPubTableExtList = dbPubTableExtMapper.selectByExample(extExample);

		// 转敏感等级和授权范围为中文
		dbPubTableExtList.forEach(ext -> {
			if ("security_level".equals(ext.getExtAttrEname())) {
				ext.setExtValue(convertSecurityLevelToChinese(ext.getExtValue()));
			} else if ("auth_type".equals(ext.getExtAttrEname())) {
				String[] strings = ext.getExtValue().split("-");
				String authType = ext.getExtValue().split("-")[0];
				if (strings.length == 1) {
					ext.setExtValue(authType + "-");
				} else {
					Stream<String> orgs = Arrays.stream(ext.getExtValue().split("-")[1].split(","));
					String authScope = dbOrgAreaService.realConvertAuthScope(orgs, authType);
					ext.setExtValue(authType + "-" + authScope);
				}
			}
		});

		return listPo2VO(dbPubTableExtList, DbPubTableExtDto.class);
	}

	/**
	 * 将授权范围转为机构或域名
	 *
	 * @param c
	 * @return
	 */
	private String convertAuthScope(DbPubColumnDto c) {
		return dbOrgAreaService.convertAuthScope(c.getAuthScope(), c.getAuthType());

	}

	/**
	 * 获取发布详细信息
	 *
	 * @param id 库表发布ID
	 * @return 发布详细信息
	 */
	@Override
	public ResultVo<DbPubTableDto> getDetailedInfo(String id) {
		DbPubTable pubTable = getPubTableById(id);
		if (pubTable == null) {
			return ResultVo.ok();
		}

		DbPubTableDto dto = po2VO(pubTable, DbPubTableDto.class);
		String tableName = dto.getTableName();
		dto.setTableName(tableName.substring(tableName.indexOf(".") + 1));
		dto.setPubTableExtDtos(getExtDtos(dto.getId()));

		// 添加列信息
		DbPubColumnExample example = new DbPubColumnExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(id);
		List<DbPubColumn> columns = dbPubColumnMapper.selectByExample(example);
		List<DbPubColumnDto> columnDtos = listPo2VO(columns, DbPubColumnDto.class);

		// 给每列添加扩展信息
		columnDtos.forEach(c -> c.setPubTableExtDtos(getExtDtos(c.getId())));

		dto.setPubColumnDto(columnDtos);

		// 添加更多有必要返回的信息
		this.andMorePubTableInfo(dto);

		return ResultVo.ok(dto);
	}

	/**
	 * 撤回发布
	 *
	 * @param vo 撤回数据
	 * @return 撤回结果
	 */
	@Override
	public ResultVo withdrawPub(WithdrawPubVo vo) {
		// 修改pub_table pub_column
		String pubId = vo.getPubId();
		DbPubTable pubTable = getPubTableById(pubId);
		String authScope = pubTable.getAuthScope();
		String newAuthScope = removeOrgList(authScope, vo.getAuthScopes());

		DbPubTable t = new DbPubTable();
		t.setId(pubId);
		t.setAuthScope(newAuthScope);
		dbPubTableMapper.updateByPrimaryKeySelective(t);

		DbPubColumnExample example = new DbPubColumnExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pubId);
		List<DbPubColumn> dbPubColumns = dbPubColumnMapper.selectByExample(example);
		dbPubColumns.forEach(x -> {
			String s = removeOrgList(x.getAuthScope(), vo.getAuthScopes());
			DbPubColumn dbPubColumn = new DbPubColumn();
			dbPubColumn.setId(x.getId());
			dbPubColumn.setAuthScope(s);
			dbPubColumnMapper.updateByPrimaryKeySelective(dbPubColumn);

			setAuthType(x.getId(), s);
		});

		// 删除子节点数据
		dbKitTemplate.withdrawPub(vo);

		// 删除订阅方中心数据
		vo.getAuthScopes().forEach(scope -> dbSubTableService.deleteSubByPubIdAndSubOrgId(vo.getPubId(), scope));

		// 删除订阅放节点数据
		vo.getAuthScopes().forEach(scope -> dbKitTemplate.deleteSubByPubIdAndSubOrgId(vo.getPubId(), scope));

		return ResultVo.ok();
	}

	private void setAuthType(String columnId, String value) {
		String extAttrEname = "auth_type";
		DbPubTableExt ext = getPubTableExtByIdAndExtAttrEname(columnId, extAttrEname);
		if (ext == null) {
			return;
		}

		String extValue = ext.getExtValue();
		String authType = extValue.split("-")[0];

		DbPubTableExt dbPubTableExt = new DbPubTableExt();
		dbPubTableExt.setExtValue(authType + "-" + value);

		DbPubTableExtExample example = new DbPubTableExtExample();
		DbPubTableExtExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(columnId);
		criteria.andExtAttrEnameEqualTo(extAttrEname);

		dbPubTableExtMapper.updateByExampleSelective(dbPubTableExt, example);
	}

	private DbPubTableExt getPubTableExtByIdAndExtAttrEname(String columnId, String extAttrEname) {
		DbPubTableExtExample example = new DbPubTableExtExample();
		DbPubTableExtExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(columnId);
		criteria.andExtAttrEnameEqualTo(extAttrEname);
		List<DbPubTableExt> pubTableExts = dbPubTableExtMapper.selectByExample(example);
		if (pubTableExts.size() == 0) {
			return null;
		} else {
			return pubTableExts.get(0);
		}
	}

	/**
	 * 获取可撤回机构列表
	 *
	 * @param pubId 发布ID
	 * @return 机构列表
	 */
	@Override
	public ResultVo getWithdrawOrgList(String pubId) {
		DbPubTable dbPubTable = dbPubTableMapper.selectByPrimaryKey(pubId);
		String authScope = dbPubTable.getAuthScope();
		List<WithdrawOrgDto> list = Arrays.stream(authScope.split(",")).map(x -> {
			String orgName = dbOrgService.getOrgNameByOrgId(x);
			return new WithdrawOrgDto(x, orgName);
		}).collect(Collectors.toList());

		return ResultVo.ok(list);
	}

	@Override
	public DbPubTable getDbPubTableByMakeTableName(String makeTableName) {
		DbPubTableExample example = new DbPubTableExample();
		DbPubTableExample.Criteria criteria = example.createCriteria();
		criteria.andMakeTableNameEqualTo(makeTableName);
		List<DbPubTable> list = dbPubTableMapper.selectByExample(example);
		if (!CommonUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

}

