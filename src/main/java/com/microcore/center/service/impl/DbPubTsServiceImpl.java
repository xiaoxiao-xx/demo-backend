package com.microcore.center.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.microcore.api.model.DbPubTs;
import com.microcore.api.vo.DbBaseKitVo;
import com.microcore.center.client.DbsKitTemplate;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.mapper.*;
import com.microcore.center.model.*;
import com.microcore.center.service.*;
import com.microcore.common.config.ConstantConfig;
import com.microcore.common.constant.Constants;
import com.microcore.center.model.DbPubTableExt;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbPubTsColumn;
import com.microcore.api.vo.DbPubTsColumnVo;
import com.microcore.api.vo.DbPubTsVo;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

import static com.microcore.common.config.ConstantConfig.convertAuthTypeToChinese;
import static com.microcore.common.config.ConstantConfig.convertInterfaceTypeToChinese;
import static com.microcore.common.constant.Constants.*;
import static com.microcore.common.service.WebServiceUtil.SHARED_DATA;
import static com.microcore.common.service.WebServiceUtil.STATISTICS;
import static com.microcore.common.service.WebServiceUtil.VERIFY_DATA;
import static com.microcore.common.util.CommonUtil.*;

/**
 * @author whater
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DbPubTsServiceImpl implements DbPubTsService {

	@Autowired
	private DbPubTsMapper dbPubTsMapper;

	@Autowired
	private DbPubTsColumnMapper dbPubTsColumnMapper;

	@Autowired
	private DbTableCnfMapper dbTableCnfMapper;

	@Autowired
	private DbFieldCnfMapper dbFieldCnfMapper;

	@Autowired
	private DbsKitTemplate dbsKitTemplate;

	@Autowired
	private DbPubTableExtMapper dbPubTableExtMapper;

	@Autowired
	private DbOrgAreaService dbOrgAreaService;

	@Autowired
	private DbOrgService dbOrgService;

	@Autowired
	private DbConnectionService dbConnectionService;

	@Autowired
	private DbParamsService dbParamsService;

	@Autowired
	private UserService userService;

	@Autowired
	private DbPolicyItemService dbPolicyItemService;

	@Autowired
	private DbBaseKitService dbBaseKitService;

	private final List<Map<String, String>> interfaceTypeList = Arrays.asList(
			newInterfaceTypeMap(INTERFACE_TYPE_SHARE, INTERFACE_TYPE_SHARE_CN),
			newInterfaceTypeMap(INTERFACE_TYPE_VERIFY, INTERFACE_TYPE_VERIFY_CN),
			newInterfaceTypeMap(INTERFACE_TYPE_STATISTICS, INTERFACE_TYPE_STATISTICS_CN)
	);

	private Map<String, String> newInterfaceTypeMap(String type, String typeName) {
		HashMap<String, String> map = new HashMap<>(1);
		map.put("type", type);
		map.put("typeName", typeName);
		return map;
	}

	@Override
	public ResultVo<?> add(DbPubTsVo dbPubTsVo) {
		String pubId = getUUID();
		dbPubTsVo.setId(pubId);
		dbPubTsVo.setPubUserId(getUserId());
		dbPubTsVo.setPubOrgId(getOrgId());

		String tableId = dbPubTsVo.getTableId();
		DbTableCnf dbTableCnf = dbTableCnfMapper.selectByPrimaryKey(tableId);

		String dbId = dbPubTsVo.getSourceDbId();
		DbConnection connection = dbConnectionService.getDbConnectionById(dbId);
		String versionId = connection.getDbVersionId();
		if (Constants.DM_TYPE == Integer.parseInt(versionId)) {
			dbPubTsVo.setTableName(connection.getDataBaseName().toUpperCase() + "."
					+ dbTableCnf.getTableName().toUpperCase());
		}else {
			dbPubTsVo.setTableName(dbTableCnf.getTableName());
		}

		dbPubTsVo.setTableComment(dbTableCnf.getTableNote());

		dbPubTsVo.setPubStatus(Constants.PUB_STATUS_NO);

		// 未发布
		dbPubTsVo.setStatus(RUN_STATUS_STOP);
		EntityUtils.setCreateInfo(dbPubTsVo);
		EntityUtils.setUpdateInfo(dbPubTsVo);

		// 生成URL
		dbPubTsVo.setRestUrl(getRestUrl(dbPubTsVo));
		dbPubTsVo.setWebUrl(getWebServiceUrl(dbPubTsVo));

		List<DbPubTsColumnVo> pubTsColumns = dbPubTsVo.getPubTsColumns();

		List<String> authScopeList = new ArrayList<>();
		for (DbPubTsColumnVo vo : pubTsColumns) {
			String fieldId = vo.getFieldId();
			DbFieldCnf dbFieldCnf = dbFieldCnfMapper.selectByPrimaryKey(fieldId);

			vo.setPid(dbPubTsVo.getId());
			vo.setId(getUUID());

			vo.setColumnComment(dbFieldCnf.getFieldNote());
			vo.setColumnName(dbFieldCnf.getFieldName());
			vo.setColumnType(dbFieldCnf.getFieldType());

			DbPubTsColumn dbPubTsColumn = po2VO(vo, DbPubTsColumn.class);
			dbPubTsColumnMapper.insert(dbPubTsColumn);

			authScopeList.add(vo.getAuthScope());

			// 保存扩展信息
			List<DbPubTableExt> pubTableExtDtos = listPo2VO(vo.getExtList(), DbPubTableExt.class);
			pubTableExtDtos.forEach(extDto -> {
				extDto.setId(dbPubTsVo.getId());
				extDto.setTemplateType("COLUMN");
				extDto.setLabelId(tableId);
			});
			vo.setExtList(listPo2VO(pubTableExtDtos, com.microcore.common.model.DbPubTableExt.class));

			saveExtInfo(pubTableExtDtos);
		}

		String authScope = authScopeList.stream()
				.filter(Objects::nonNull)
				.map(x -> x.split(","))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.joining(","));
		dbPubTsVo.setAuthScope(authScope);

		// 保存扩展信息
		List<DbPubTableExt> pubTableExtDtos = listPo2VO(dbPubTsVo.getExtList(), DbPubTableExt.class);
		pubTableExtDtos.forEach(extDto -> {
			extDto.setId(tableId);
			extDto.setTemplateType("MODEL");
			extDto.setLabelId(tableId);
		});
		dbPubTsVo.setExtList(listPo2VO(pubTableExtDtos, com.microcore.common.model.DbPubTableExt.class));
		saveExtInfo(pubTableExtDtos);

		DbPubTs dbPubTs = po2VO(dbPubTsVo, DbPubTs.class);
		dbPubTsMapper.insert(dbPubTs);

		dbsKitTemplate.addPubTs(dbPubTsVo);

		return ResultVo.ok("添加成功");
	}

	private String getRestUrl(DbPubTsVo dbPubTsVo) {
		DbBaseKitVo kit = dbBaseKitService.getKitByOrgAndTagType(getOrgId(), TAG_TYPE_DBS);
		if (kit == null) {
			return "";
		}
		String kitIp = kit.getTagIp();
		String kitPort = kit.getTagPort();
		return "http://" + kitIp + ":" + kitPort + "/" + getRestUrlPrefix(dbPubTsVo.getInterfaceType())
				+ "/" + dbPubTsVo.getId();
	}

	private String getWebServiceUrl(DbPubTsVo dbPubTsVo) {
		DbBaseKitVo kit = dbBaseKitService.getKitByOrgAndTagType(getOrgId(), TAG_TYPE_DBS);
		if (kit == null) {
			return "";
		}
		String kitIp = kit.getTagIp();
		String kitPort = kit.getTagPort();
		return "http://" + kitIp + ":" + kitPort + getWebServiceUrlPrefix(dbPubTsVo.getInterfaceType())
				+ dbPubTsVo.getId() + "?wsdl";
	}

	private String getRestUrlPrefix(String interfaceType) {
		switch (interfaceType) {
			case INTERFACE_TYPE_SHARE:
				return "getshareddata";
			case INTERFACE_TYPE_VERIFY:
				return "verifydata";
			case INTERFACE_TYPE_STATISTICS:
				return "statistics";
			default:
				return "";
		}
	}

	private String getWebServiceUrlPrefix(String interfaceType) {
		switch (interfaceType) {
			case INTERFACE_TYPE_SHARE:
				return SHARED_DATA;
			case INTERFACE_TYPE_VERIFY:
				return VERIFY_DATA;
			case INTERFACE_TYPE_STATISTICS:
				return STATISTICS;
			default:
				return "";
		}
	}

	@Override
	public void pubTs(String id) {
		setPubStatus(id, PUB_STATUS_YES);
		dbsKitTemplate.pub(id);
	}

	/**
	 * 设置发布状态
	 *
	 * @param id     发布ID
	 * @param status 发布状态
	 */
	@Override
	public void setPubStatus(String id, String status) {
		DbPubTs pubTs = new DbPubTs();
		pubTs.setId(id);
		pubTs.setPubStatus(status);
		pubTs.setPubTime(getCurrentTime());
		dbPubTsMapper.updateByPrimaryKeySelective(pubTs);
	}

	/**
	 * 保存扩展信息
	 *
	 * @param dbPubTableExtList 扩展信息列表
	 */
	private void saveExtInfo(List<DbPubTableExt> dbPubTableExtList) {
		dbPubTableExtList.forEach(dbPubTableExtMapper::insert);
	}

	@Override
	public ResultVo<?> del(String id) {
		dbPubTsMapper.deleteByPrimaryKey(id);

		DbPubTsColumnExample example = new DbPubTsColumnExample();
		DbPubTsColumnExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(id);
		dbPubTsColumnMapper.deleteByExample(example);

		dbsKitTemplate.delPubTs(id);

		return ResultVo.ok("删除成功");
	}

	@Override
	public void setRunStatus(String id, String status) {
		DbPubTs pubTs = new DbPubTs();
		pubTs.setId(id);
		pubTs.setStatus(status);
		dbPubTsMapper.updateByPrimaryKeySelective(pubTs);
	}

	@Override
	public void startPub(String id) {
		setRunStatus(id, RUN_STATUS_RUN);
		dbsKitTemplate.startPub(id);
	}

	@Override
	public void stopPub(String id) {
		setRunStatus(id, RUN_STATUS_STOP);
		dbsKitTemplate.stopPub(id);
	}

	@Override
	public PageInfo<DbPubTsVo> getPubList(String pubName, String status, String pubStatus,
	                                      String orgId, Integer pageIndex, Integer pageSize) {
		return getPubList(pubName, status, pubStatus, orgId, false, pageIndex, pageSize);
	}

	@Override
	public PageInfo<DbPubTsVo> getOthersPubList(String pubName, String status, String orgId,
	                                            String pubStatus, Integer pageIndex, Integer pageSize) {
		return getPubList(pubName, status, pubStatus, orgId, true, pageIndex, pageSize);
	}

	public PageInfo<DbPubTsVo> getPubList(String pubName, String status, String pubStatus,
	                                      String orgId, boolean othersPub,
	                                      Integer pageIndex, Integer pageSize) {
		DbPubTsExample example = new DbPubTsExample();
		example.setOrderByClause("crt_tm desc");
		DbPubTsExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(pubName)) {
			criteria.andPubNameLike("%" + pubName.trim() + "%");
		}

		// 查询其它机构的所有发布
		if (othersPub) {
			if (StringUtils.isBlank(orgId)) {
				criteria.andPubOrgIdNotEqualTo(getOrgId());
			} else {
				criteria.andPubOrgIdEqualTo(orgId);
				// 至查询别人已经发布的
				criteria.andPubStatusEqualTo(YES);
			}
		} else {
			// orgId为空表示查本机构的发布
			// 否则查询指定机构的发布
			if (StringUtil.isEmpty(orgId)) {
				criteria.andPubOrgIdEqualTo(getOrgId());
			} else {
				criteria.andPubOrgIdEqualTo(orgId);
			}
		}

		if (StringUtil.isNotEmpty(status)) {
			if (YES.equals(status)) {
				criteria.andStatusEqualTo(status);
			} else {
				criteria.andStatusNotEqualTo(YES);
			}
		}

		if (StringUtils.isNotBlank(pubStatus)) {
			if (YES.equals(pubStatus)) {
				criteria.andPubStatusEqualTo(pubStatus);
			} else {
				criteria.andPubStatusNotEqualTo(YES);
			}
		}

		criteria.andDelStatusEqualTo(DEL_STATUS_NOR);

		PageInfo<com.microcore.api.model.DbPubTs> page = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbPubTsMapper.selectByExample(example));
		PageInfo<DbPubTsVo> pageVo = po2VO(page, PageInfo.class);
		List<DbPubTsVo> listVo = listPo2VO(page.getList(), DbPubTsVo.class);

		listVo.forEach(vo -> {
			// 将授权范围转为机构或域名
			vo.setAuthScope(dbOrgAreaService.convertAuthScope(vo.getAuthScope(), vo.getAuthType()));
			vo.setAuthType(convertAuthTypeToChinese(vo.getAuthType()));
			vo.setSourceDbId(dbConnectionService.getDatabaseNameById(vo.getSourceDbId()));
			vo.setDataType(dbParamsService.getParamsValueByTypeAndKey("data_cate", vo.getDataType()));
			vo.setPubUserId(userService.getUserNameById(vo.getPubUserId()));
			vo.setPubOrgId(dbOrgService.getOrgNameByOrgId(vo.getPubOrgId()));
		});

		pageVo.setList(listVo);
		return pageVo;
	}

	@Override
	public ResultVo getDetailedInfo(String id) {
		return ResultVo.ok(getDetailedPubTsInfo(id));
	}

	@Override
	public DbPubTsVo getDetailedPubTsInfo(String id) {
		DbPubTs pubTs = getPubTsById(id);
		if (pubTs == null) {
			return null;
		}

		DbPubTsVo dto = po2VO(pubTs, DbPubTsVo.class);
		String tableName = dto.getTableName();
		dto.setTableName(tableName.substring(tableName.indexOf(".") + 1));
		dto.setAuthScope(dbOrgAreaService.convertAuthScope(dto.getAuthScope(), dto.getAuthType()));
		dto.setCrtOrgId(dbOrgService.getOrgNameByOrgId(dto.getCrtOrgId()));
		dto.setCrtUserId(userService.getUserNameById(dto.getCrtUserId()));
		dto.setDataType(dbParamsService.getParamsValueByTypeAndKey("data_cate", dto.getDataType()));
		dto.setPubUserId(userService.getUserNameById(dto.getPubUserId()));
		dto.setPubOrgId(dbOrgService.getOrgNameByOrgId(dto.getPubOrgId()));
		dto.setSourceDbId(dbConnectionService.getDatabaseNameById(dto.getSourceDbId()));
		dto.setTemplateId(dbPolicyItemService.getPolicyItemNameById(dto.getTemplateId()));
		dto.setInterfaceType(convertInterfaceTypeToChinese(dto.getInterfaceType()));

		// dto.setExtList(getExDtos(dto.getId()));

		// 添加列信息
		DbPubTsColumnExample example = new DbPubTsColumnExample();
		DbPubTsColumnExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(id);
		List<DbPubTsColumn> columns = dbPubTsColumnMapper.selectByExample(example);
		List<DbPubTsColumnVo> columnDtos = listPo2VO(columns, DbPubTsColumnVo.class);

		// 给每列添加扩展信息
		columnDtos.forEach(c -> {
			if (StringUtils.isNotBlank(c.getAuthScope())) {
				c.setAuthScope(dbOrgAreaService.convertAuthScope(c.getAuthScope(), c.getAuthType()));
			}
			if (StringUtils.isNotBlank(c.getSecurityLevel())) {
				c.setSecurityLevel(ConstantConfig.convertSecurityLevelToChinese(c.getSecurityLevel()));
			}
			// c.setExtList(getExtDtos(c.getId()));
		});

		dto.setPubTsColumns(columnDtos);

		// 添加更多有必要返回的信息
		// this.andMorePubTableInfo(dto);

		return dto;
	}

	@Override
	public DbPubTs getPubTsById(String id) {
		return dbPubTsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据ID查询发布任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	@Override
	public TaskInfo getTaskInfoById(String id) {
		DbPubTs pubTs = getPubTsById(id);
		if (pubTs == null) {
			pubTs = new DbPubTs();
		}

		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskName(Optional.ofNullable(pubTs.getPubName()).orElse(""));
		taskInfo.setTaskDesc(Optional.ofNullable(pubTs.getPubDesc()).orElse(""));

		return taskInfo;
	}

	@Override
	public List<Map<String, String>> getInterfaceType() {
		return interfaceTypeList;
	}

	@Override
	public ResultVo batchDeletePub(List<String> idList) {
		idList.forEach(this::del);
		return ResultVo.ok();
	}

	@Override
	public ResultVo pubBatch(List<String> idList) {
		idList.forEach(this::pubTs);
		return ResultVo.ok();
	}

	@Override
	public ResultVo batchStartPub(List<String> idList) {
		idList.forEach(this::startPub);
		return ResultVo.ok();
	}

	@Override
	public ResultVo batchStopPub(List<String> idList) {
		idList.forEach(this::stopPub);
		return ResultVo.ok();
	}

}
