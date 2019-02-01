package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbPubTs;
import com.microcore.api.model.DbSubTs;
import com.microcore.api.vo.DbPubTsVo;
import com.microcore.api.vo.DbSubTsVo;
import com.microcore.center.client.DbsKitTemplate;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.mapper.*;
import com.microcore.center.model.*;
import com.microcore.center.model.DbSubTsExample.Criteria;
import com.microcore.center.service.*;
import com.microcore.center.util.CenterUtil;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.JwtUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.microcore.common.config.ConstantConfig.convertInterfaceTypeToChinese;
import static com.microcore.common.constant.Constants.*;
import static com.microcore.common.util.CommonUtil.*;

/**
 * 库表服务订阅
 *
 * @author lmh
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class DbSubTsServiceImpl implements DbSubTsService {

	@Autowired
	private DbSubTsMapper dbSubTsMapper;

	@Autowired
	private DbPubTsService dbPubTsService;

	@Autowired
	private DbApprovalService dbApprovalService;

	@Autowired
	private DbsKitTemplate dbsKitTemplate;

	@Autowired
	private DbOrgService dbOrgService;

	@Autowired
	private UserService userService;

	@Autowired
	private DbConnectionService dbConnectionService;

	@Autowired
	private DbParamsService dbParamsService;

	@Override
	public ResultVo addSub(DbSubTsVo vo) {
		String pubId = vo.getPubId();
		DbPubTs pubTs = dbPubTsService.getPubTsById(pubId);
		String autoApp = pubTs.getAutoApp();

		String id = getUUID();
		vo.setId(id);
		if (autoApp == null || Constants.TRUE.equals(autoApp)) {
			vo.setStatus(RUN_STATUS_STOP);
			addSubCommon(vo);
		} else {
			vo.setStatus(PUB_STATUS_APPROVING);
			addSubCommon(vo);

			DbApproval approval = CenterUtil.buildApproval(DATA_TYPE_DBS, id,
					pubTs.getPubUserId(), pubTs.getPubDesc());
			dbApprovalService.submitSubApproval(approval);
		}

		return ResultVo.ok("申请成功");
	}

	private void addSubCommon(DbSubTsVo vo) {
		EntityUtils.setCreateAndUpdateInfo(vo);

		DbSubTs subTs = po2VO(vo, DbSubTs.class);

		String subToken;
		try {
			DbPubTs ts = dbPubTsService.getPubTsById(vo.getPubId());
			subToken = JwtUtil.createJwtToken(vo.getId(), ts.getAuthEndDate());
			subTs.setToken(subToken);
		} catch (Exception e) {
			e.printStackTrace();
		}

		dbSubTsMapper.insert(subTs);

		dbsKitTemplate.addSub(vo);
	}

	@Override
	public void setStatus(String id, String status) {
		DbSubTs dbSubTs = new DbSubTs();
		dbSubTs.setId(id);
		dbSubTs.setStatus(status);
		dbSubTsMapper.updateByPrimaryKeySelective(dbSubTs);
	}

	/**
	 * 启动订阅
	 *
	 * @param id 订阅ID
	 * @return 启动结果
	 */
	@Override
	public void startSub(String id) {
		setStatus(id, RUN_STATUS_RUN);

		// 通知节点启动
		dbsKitTemplate.startSub(id);
	}

	@Override
	public void batchStartSub(List<String> idList) {
		idList.forEach(this::startSub);
	}

	/**
	 * 停止订阅
	 *
	 * @param id 订阅ID
	 * @return 停止结果
	 */
	@Override
	public void stopSub(String id) {
		setStatus(id, RUN_STATUS_STOP);

		// 通知节点停止
		dbsKitTemplate.stopSub(id);
	}

	@Override
	public void batchStopSub(List<String> idList) {
		idList.forEach(this::stopSub);
	}

	/**
	 * 删除订阅
	 *
	 * @param id 订阅ID
	 * @return 删除结果
	 */
	@Override
	public void deleteSub(String id) {
		DbSubTs subTs = new DbSubTs();
		subTs.setId(id);
		subTs.setDelStatus("DEL");
		dbSubTsMapper.updateByPrimaryKeySelective(subTs);

		dbsKitTemplate.deleteSub(id);
	}

	@Override
	public void batchDeleteSub(List<String> idList) {
		idList.forEach(this::deleteSub);
	}

	/**
	 * 获取订阅列表
	 *
	 * @param pageIndex 页码
	 * @param pageSize  每页大小
	 * @return 订阅列表
	 */
	@Override
	public ResultVo<PageInfo<DbSubTsVo>> getSubList(String taskName, Integer pageIndex, Integer pageSize) {
		DbSubTsExample example = new DbSubTsExample();
		example.setOrderByClause("crt_tm desc");
		Criteria criteria = example.createCriteria();
		// 只查询当前用户的订阅
		criteria.andCrtUserIdEqualTo(UserUtil.getUserId());

		if (StringUtils.isNotBlank(taskName)) {
			criteria.andTaskNameLike("%" + taskName.trim() + "%");
		}
		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		criteria.andDelStatusEqualTo(DEL_STATUS_NOR);
		PageInfo<DbSubTs> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> dbSubTsMapper.selectByExample(example));
		List<DbSubTs> list = pageInfo.getList();
		if (list == null) {
			list = new ArrayList<>();
		}

		List<DbSubTsVo> subTsVoList = listPo2VO(list, DbSubTsVo.class);
		andMoreSubTsInfo(subTsVoList);

		PageInfo<DbSubTsVo> pageInfoDto = po2VO(pageInfo, PageInfo.class);
		pageInfoDto.setList(subTsVoList);

		return ResultVo.ok(pageInfoDto);
	}

	private void andMoreSubTsInfo(List<DbSubTsVo> list) {
		list.forEach(this::andMoreSubTsInfo);
	}

	private void andMoreSubTsInfo(DbSubTsVo subTsVo) {
		String pubId = subTsVo.getPubId();
		DbPubTs pubTs = dbPubTsService.getPubTsById(pubId);
		if (pubTs == null) {
			return;
		}

		String pubOrgId = pubTs.getPubOrgId();
		subTsVo.setPubOrgName(dbOrgService.getOrgNameByOrgId(pubOrgId));
		subTsVo.setPubUserName(userService.getUserNameById(pubTs.getPubUserId()));
		subTsVo.setPubTime(pubTs.getPubTime());
		subTsVo.setPubName(pubTs.getPubName());
		subTsVo.setSourceDbName(dbConnectionService.getDatabaseNameById(pubTs.getSourceDbId()));
		subTsVo.setTableName(pubTs.getTableName());
		subTsVo.setInterfaceType(convertInterfaceTypeToChinese(pubTs.getInterfaceType()));
		subTsVo.setKeywords(pubTs.getKeywords());
		subTsVo.setDataType(dbParamsService.getParamsValueByTypeAndKey("data_cate", pubTs.getDataType()));
	}

	/**
	 * 获取详细信息
	 *
	 * @param id 库表发布ID
	 * @return 发布详细信息
	 */
	@Override
	public ResultVo<DbSubTsVo> getDetailedInfo(String id) {
		DbSubTs subTs = getSubTsById(id);
		if (subTs == null) {
			return ResultVo.ok();
		}

		DbSubTsVo vo = po2VO(subTs, DbSubTsVo.class);

		andMoreSubTsInfo(vo);

		DbPubTsVo pubTsVo = dbPubTsService.getDetailedPubTsInfo(subTs.getPubId());
		if (pubTsVo != null) {
			vo.setPubTsVo(pubTsVo);
		}

		return ResultVo.ok(vo);
	}

	/**
	 * 根据ID查询库表订阅任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	@Override
	public TaskInfo getTaskInfoById(String id) {
		DbSubTs subTs = getSubTsById(id);
		if (subTs == null) {
			subTs = new DbSubTs();
		}

		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskName(Optional.ofNullable(subTs.getTaskName()).orElse(""));
		taskInfo.setTaskDesc(Optional.ofNullable(subTs.getTaskDesc()).orElse(""));
		return taskInfo;
	}

	@Override
	public DbSubTs getSubTsById(String id) {
		return dbSubTsMapper.selectByPrimaryKey(id);
	}

}
