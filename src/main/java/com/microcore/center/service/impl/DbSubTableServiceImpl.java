package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.client.DbKitTemplate;
import com.microcore.center.dto.DbSubColumnDto;
import com.microcore.center.dto.DbSubTableDto;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.mapper.DbPubColumnMapper;
import com.microcore.center.mapper.DbPubTableMapper;
import com.microcore.center.mapper.DbSubColumnMapper;
import com.microcore.center.mapper.DbSubTableMapper;
import com.microcore.center.model.*;
import com.microcore.center.model.DbSubTableExample.Criteria;
import com.microcore.center.service.*;
import com.microcore.center.util.CenterUtil;
import com.microcore.center.vo.SubTableVo;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.microcore.common.constant.Constants.*;
import static com.microcore.common.util.CommonUtil.*;

/**
 * 库表订阅管理
 *
 * @author lmh
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class DbSubTableServiceImpl implements DbSubTableService {

	@Autowired
	private DbSubTableMapper dbSubTableMapper;

	@Autowired
	private DbSubColumnMapper dbSubColumnMapper;

	@Autowired
	private DbPubColumnMapper dbPubColumnMapper;

	@Autowired
	private DbConnectionService dbConnectionService;

	@Autowired
	private DbKitTemplate dbKitTemplate;

	@Autowired
	private DbPubTableMapper dbPubTableMapper;

	@Autowired
	private DbOrgService dbOrgService;

	@Autowired
	private UserService userService;

	@Autowired
	private DbApprovalService dbApprovalService;

	@Autowired
	private DbPubTableService dbPubTableService;

	@Autowired
	private DbPubColumnService dbPubColumnService;

	@Autowired
	private BlockChService blockChService;

	@Override
	public ResultVo<String> submitTableSubInfo(SubTableVo subInfo) {
		String pubId = subInfo.getPubId();
		blockChService.dataRequest(pubId);
		blockChService.dataEvaluation(pubId);
		DbPubTable table = dbPubTableService.getDbPubTableById(pubId);
		String autoApp = table.getAutoApp();
		if (autoApp == null || Constants.TRUE.equals(autoApp)) {
			submitSubInfo(subInfo, RUN_STATUS_STOP);
		} else {
			String id = submitSubInfo(subInfo, PUB_STATUS_APPROVING);
			DbApproval approval = CenterUtil.buildApproval(DATA_TYPE_DB, id, table.getPubUserId(), table.getPubDesc());
			dbApprovalService.submitSubApproval(approval);
		}

		return ResultVo.ok();
	}

	public String submitSubInfo(SubTableVo subInfo, String status) {
		DbSubTable dbSubTable = new DbSubTable();
		String id = CommonUtil.getUUID();
		dbSubTable.setId(id);
		dbSubTable.setDistillTableName(subInfo.getDistillTableName());
		dbSubTable.setPubId(subInfo.getPubId());
		dbSubTable.setTaskId(subInfo.getTaskId());
		dbSubTable.setConnId(subInfo.getConId());
		dbSubTable.setStoreTableName(subInfo.getStoreTableName());
		dbSubTable.setTaskName(subInfo.getTaskName());
		dbSubTable.setTaskDesc(subInfo.getTaskDesc());
		dbSubTable.setSubUserId(getUserId());
		dbSubTable.setSubOrgId(getOrgId());

		dbSubTable.setPubUserId(subInfo.getPubUserId());
		dbSubTable.setPubOrgId(subInfo.getPubOrgId());
		dbSubTable.setPubTime(getCurrentTime());

		// 无用字段
		dbSubTable.setPubStatus("--");
		dbSubTable.setStatus(status);

		// 创建组织ID就是订阅表的用户所属的组织的ID
		EntityUtils.setCreateAndUpdateInfo(dbSubTable);
		dbSubTableMapper.insert(dbSubTable);

		List<DbSubColumn> columnList = new ArrayList<>();
		List<Map<String, String>> columns = subInfo.getColumnList();
		for (Map<String, String> map : columns) {
			DbSubColumn dbSubColumn = new DbSubColumn();
			String detailId = CommonUtil.getUUID();
			String policyId = map.get("policyId");
			DbPubColumn dbPubColumn = dbPubColumnService.getDbPubColumnByPolicyId(policyId);
			dbSubColumn.setId(detailId);
			dbSubColumn.setPid(id);
			dbSubColumn.setPolicyId(policyId);
			String comment = map.get("columnComment");
			dbSubColumn.setDistillColumnName(map.get("oldColumnName"));
			dbSubColumn.setDistillType(map.get("oldColumnType"));
			dbSubColumn.setDistillComment(comment);
			dbSubColumn.setStoreColumnName(map.get("newColumnName"));
			dbSubColumn.setStoreType(map.get("newColumnType"));
			dbSubColumn.setStoreComment(comment);
			dbSubColumn.setTraceMake(dbPubColumn.getTraceMark());
			dbSubColumn.setEncryptType(dbPubColumn.getEncryptType());
			dbSubColumnMapper.insert(dbSubColumn);
			columnList.add(dbSubColumn);
		}

		DbSubTableDto dto = po2VO(dbSubTable, DbSubTableDto.class);
		dto.setStoreTableType(subInfo.getStoreTableType());
		List<DbSubColumnDto> columnDtoList = listPo2VO(columnList, DbSubColumnDto.class);
		dto.setSubColumnDto(columnDtoList);

		String pubId = subInfo.getPubId();
		DbPubTable dbPubTable = dbPubTableMapper.selectByPrimaryKey(pubId);
		dto.setPubOrgId(dbPubTable.getPubOrgId());
		dto.setMakeTableName(dbPubTable.getMakeTableName());

		dto.setPubTable(dbPubTable);

		// 订阅时即下发
		// TODO 节点返回的错误信息不能接收到
		dbKitTemplate.saveSub(dto);

		// TODO 添加日志
		return id;
	}

	/**
	 * 获取要订阅的表的列信息
	 * 查db-center/db_pub_column表即可
	 *
	 * @param pubId 发布ID
	 * @return 表字段
	 */
	@Override
	public ResultVo<List<Map<String, String>>> getTableColumns(String pubId) {
		DbPubColumnExample example = new DbPubColumnExample();
		DbPubColumnExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pubId);
		List<DbPubColumn> columnList = dbPubColumnMapper.selectByExample(example);
		if (CommonUtil.isEmpty(columnList)) {
			return ResultVo.fail("查询不到列信息数据");
		}

		List<Map<String, String>> resultList = new ArrayList<>();
		columnList.forEach(column -> {
					String columnName = column.getColumnName();
					String columnType = column.getColumnType();
					String columnComment = column.getColumnComment();
					String policyId = column.getPolId();

					Map<String, String> m = new HashMap<>(6);
					// 左侧字段的信息
					m.put("policyId", policyId);
					m.put("oldColumnName", columnName);
					m.put("oldColumnType", columnType);
					m.put("columnComment", columnComment);
					// 右侧字段的信息
					m.put("newColumnName", columnName);
					m.put("newColumnType", columnType);

					resultList.add(m);
				}
		);

		return ResultVo.ok(resultList);
	}

	@Override
	public void setRunStatus(String id, String status) {
		DbSubTable dbSubTable = new DbSubTable();
		dbSubTable.setId(id);
		dbSubTable.setStatus(status);
		dbSubTableMapper.updateByPrimaryKeySelective(dbSubTable);
	}

	/**
	 * 启动订阅
	 *
	 * @param id 订阅ID
	 * @return 启动结果
	 */
	@Override
	public ResultVo<String> startSub(String id) {
		setRunStatus(id, RUN_STATUS_RUN);

		// 通知节点启动
		dbKitTemplate.startSub(id);

		return ResultVo.ok();
	}

	@Override
	public ResultVo batchStartSub(List<String> idList) {
		idList.forEach(this::startSub);
		return ResultVo.ok();
	}

	/**
	 * 停止订阅
	 *
	 * @param id 订阅ID
	 * @return 停止结果
	 */
	@Override
	public ResultVo<String> stopSub(String id) {
		setRunStatus(id, RUN_STATUS_STOP);

		// 通知节点停止
		dbKitTemplate.stopSub(id);

		return ResultVo.ok();
	}

	@Override
	public ResultVo batchStopSub(List<String> idList) {
		idList.forEach(this::stopSub);
		return ResultVo.ok();
	}

	/**
	 * 更新订阅
	 */
	@Override
	public ResultVo<String> updateSub(SubTableVo subTableVo) {
		// TODO 更新订阅		
		return null;
	}

	@Override
	public void deleteSubByPubIdAndSubOrgId(String pubId, String subOrgId) {
		DbSubTableExample example = new DbSubTableExample();
		Criteria criteria = example.createCriteria();
		criteria.andPubIdEqualTo(pubId);
		criteria.andSubOrgIdEqualTo(subOrgId);
		criteria.andDelStatusEqualTo(DEL_STATUS_NOR);
		List<DbSubTable> dbSubTables = dbSubTableMapper.selectByExample(example);
		dbSubTables.forEach(table -> deleteSub(table.getId()));
	}

	/**
	 * 删除订阅
	 *
	 * @param id 订阅ID
	 * @return 删除结果
	 */
	@Override
	public ResultVo<String> deleteSub(String id) {
		DbSubTable subTable = new DbSubTable();
		subTable.setId(id);
		subTable.setDelStatus("DEL");
		dbSubTableMapper.updateByPrimaryKeySelective(subTable);

		DbSubColumnExample dbSubColumnExample = new DbSubColumnExample();
		DbSubColumnExample.Criteria criteria = dbSubColumnExample.createCriteria();
		criteria.andPidEqualTo(id);
		dbSubColumnMapper.deleteByExample(dbSubColumnExample);

		dbKitTemplate.deleteSub(id);

		return ResultVo.ok();
	}

	@Override
	public ResultVo batchDeleteSub(List<String> idList) {
		idList.forEach(this::deleteSub);
		return ResultVo.ok();
	}

	@Override
	public ResultVo getAllSubs(String taskName, String pubOrgName, Integer pageIndex, Integer pageSize) {
		DbSubTableExample example = new DbSubTableExample();
		example.setOrderByClause("pub_time desc");
		Criteria criteria = example.createCriteria();
		// 只查询当前用户的订阅
		criteria.andSubUserIdEqualTo(UserUtil.getUserId());
		criteria.andDelStatusEqualTo(DEL_STATUS_NOR);
		if (StringUtil.isNotEmpty(taskName)) {
			criteria.andTaskNameLike("%" + taskName.trim() + "%");
		}
		if (StringUtil.isNotEmpty(pubOrgName)) {
			List<String> list = dbOrgService.getOrgIdListByOrgName(pubOrgName);
			criteria.andPubOrgIdIn(list);
		}
		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = 16;
		}
		PageInfo<DbSubTable> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbSubTableMapper.selectByExample(example));
		List<DbSubTable> tableList = pageInfo.getList();

		List<DbSubTableDto> dtoList = listPo2VO(tableList, DbSubTableDto.class);
		andMoreSubTableInfo(dtoList);
		PageInfo<DbSubTableDto> dtoPageInfo = po2VO(pageInfo, PageInfo.class);
		dtoPageInfo.setList(dtoList);

		return ResultVo.ok(dtoPageInfo);
	}

	/**
	 * 获取订阅列表
	 *
	 * @param pageIndex 页码
	 * @param pageSize  每页大小
	 * @return 订阅列表
	 */
	@Override
	public ResultVo<PageInfo<DbSubTableDto>> getSubList(Integer pageIndex, Integer pageSize) {
		DbSubTableExample example = new DbSubTableExample();
		Criteria criteria = example.createCriteria();
		// 只查询当前用户的订阅
		criteria.andSubUserIdEqualTo(UserUtil.getUserId());
		criteria.andDelStatusEqualTo(DEL_STATUS_NOR);
		PageInfo<DbSubTable> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> dbSubTableMapper.selectByExample(example));
		List<DbSubTable> list = pageInfo.getList();
		if (list == null) {
			list = new ArrayList<>();
		}

		List<DbSubTableDto> listDto = listPo2VO(list, DbSubTableDto.class);
		andMoreSubTableInfo(listDto);

		PageInfo<DbSubTableDto> pageInfoDto = po2VO(pageInfo, PageInfo.class);
		pageInfoDto.setList(listDto);

		return ResultVo.ok(pageInfoDto);
	}

	private void andMoreSubTableInfo(List<DbSubTableDto> list) {
		list.forEach(this::andMoreSubTableInfo);
	}

	private void andMoreSubTableInfo(DbSubTableDto table) {
		String pubId = table.getPubId();
		DbPubTable pubTable = dbPubTableService.getDbPubTableById(pubId);
		if (pubTable == null) {
			return;
		}

		String pubOrgId = pubTable.getPubOrgId();
		table.setPubOrgId(pubOrgId);

		table.setDataSourceName(pubTable.getSourceDbName());
		table.setTargetDbName(dbConnectionService.getDatabaseNameById(table.getConnId()));

		table.setPubTaskName(pubTable.getPubName());
		table.setTableName(pubTable.getTableName());

		table.setPubUserName(userService.getUserNameById(pubTable.getPubUserId()));
		table.setPubOrgName(dbOrgService.getOrgNameByOrgId(pubOrgId));
		table.setPubTime(pubTable.getUpdTm());

		table.setSubUserName(userService.getUserNameById(table.getSubUserId()));
		table.setSubOrgName(dbOrgService.getOrgNameByOrgId(table.getSubOrgId()));
	}

	@Override
	public ResultVo<String> setSubTableStatus(String subId, String taskStatus) {
		if (!(taskStatus.equals(RUN_STATUS_RUN) || taskStatus.equals(RUN_STATUS_STOP))) {
			return ResultVo.fail("状态只能是RUN或者STOP");
		}

		if (taskStatus.equals(RUN_STATUS_RUN)) {
			startSub(subId);
		} else {
			stopSub(subId);
		}

		// TODO 添加日志
		return ResultVo.ok();
	}

	@Autowired
	private DbTableCnfService dbTableCnfService;
	@Autowired
	private DbFieldCnfService dbFieldCnfService;

	@Override
	public ResultVo<List<Map<String, String>>> getColumns(String conId, String tableName) {
		DbConnection dbConnection = dbConnectionService.getDbConnectionById(conId);
		if (dbConnection == null) {
			return ResultVo.fail();
		}
		String pid = dbTableCnfService.getIdByPidAndTableName(conId, tableName);

		List<DbFieldCnf> list = dbFieldCnfService.getDbFieldCnfByPid(pid);

		List<Map<String, String>> resultList = new ArrayList<>();
		for (DbFieldCnf dbFieldCnf : list) {
			Map<String, String> m = new HashMap<>(3);
			m.put("columnName", dbFieldCnf.getFieldName());
			m.put("columnType", dbFieldCnf.getFieldType());
			m.put("columnComment", dbFieldCnf.getFieldNote());

			resultList.add(m);
		}

		return ResultVo.ok(resultList);
	}


	/**
	 * 清理缓存
	 */
	@Override
	public void clearCache(String id) {
		dbKitTemplate.clearSubCache(id);
	}

	/**
	 * 根据ID查询库表发布
	 *
	 * @param id 发布ID
	 * @return DbPubTable对象
	 */
	@Override
	public DbSubTable getSubTableById(String id) {
		return dbSubTableMapper.selectByPrimaryKey(id);
	}

	/**
	 * 获取发布详细信息
	 *
	 * @param id 库表发布ID
	 * @return 发布详细信息
	 */
	@Override
	public ResultVo<DbSubTableDto> getDetailedInfo(String id) {
		DbSubTable subTable = getSubTableById(id);
		if (subTable == null) {
			return ResultVo.ok();
		}

		DbSubTableDto dto = po2VO(subTable, DbSubTableDto.class);

		// 添加列信息
		DbSubColumnExample example = new DbSubColumnExample();
		DbSubColumnExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(id);
		List<DbSubColumn> columns = dbSubColumnMapper.selectByExample(example);
		List<DbSubColumnDto> columnDtos = listPo2VO(columns, DbSubColumnDto.class);
		dto.setSubColumnDto(columnDtos);

		// 添加更多有必要返回的信息
		this.andMoreSubTableInfo(dto);

		return ResultVo.ok(dto);
	}

	/**
	 * 根据ID查询库表订阅任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	@Override
	public TaskInfo getTaskInfoById(String id) {
		DbSubTable subTable = getSubTableById(id);
		if (subTable == null) {
			subTable = new DbSubTable();
		}

		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskName(Optional.ofNullable(subTable.getTaskName()).orElse(""));
		taskInfo.setTaskDesc(Optional.ofNullable(subTable.getTaskDesc()).orElse(""));
		return taskInfo;
	}

}
