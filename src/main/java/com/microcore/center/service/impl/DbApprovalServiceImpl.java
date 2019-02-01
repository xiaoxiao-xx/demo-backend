package com.microcore.center.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microcore.center.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.api.SysApi;
import com.microcore.api.model.DbMsg;
import com.microcore.api.model.DbOrg;
import com.microcore.center.dto.DbApprovalDto;
import com.microcore.center.dto.DbPubFileDto;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.mapper.DbApprovalMapper;
import com.microcore.center.model.DbApproval;
import com.microcore.center.model.DbApprovalExample;
import com.microcore.center.model.DbPubFile;
import com.microcore.center.vo.DbApprovalVo;
import com.microcore.common.constant.Constants;
import com.microcore.common.exception.CommonException;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;

import static com.microcore.common.util.CommonUtil.po2VO;

/**
 * 审批管理服务
 */
@Transactional
@Service
public class DbApprovalServiceImpl implements DbApprovalService {


	private static final String APPROVAL_STATUS_PASSED_MSG = "审批通过，已经发布" + "\n发布任务名: %s\n发布描述: %s\n审批备注: %s";
	private static final String APPROVAL_STATUS_REJECTED_MSG = "审批未通过，不能发布\n发布任务名: %s\n发布描述: %s\n审批备注: %s";
	private static final String FAIL_MSG = "消息发送失败";
	private static final String NOT_APPROVE_MSG = "没有该审批";

	private static final String PUB_TASK_MSG = "发布任务名: %s\n发布描述: %s\n申请人备注: %s";
	private static final String SUB_TASK_MSG = "订阅任务名: %s\n订阅描述: %s\n申请人备注: %s";

	private static Map<String, String> orgMap = new HashMap<>();

	@Autowired
	private DbApprovalMapper dbApprovalMapper;

	@Autowired
	private DbOrgService dbOrgService;

	@Autowired
	private UserService userService;

	@Autowired
	private DbPubSubInfoService dbPubSubInfoService;

	@Autowired
	private DbPubTableService dbPubTableService;

	@Autowired
	private DbPubTsService dbPubTsService;

	@Autowired
	private DbPubFileService dbPubFileService;

	@Autowired
	private DbPubServiceService dbPubServiceService;

	@Autowired
	private SysApi sysApi;

	@Autowired
	private DbParamsService dbParamsService;

	/**
	 * 根据ID获取DbApproval对象
	 *
	 * @param id 审批ID
	 * @return DbApproval对象
	 */
	@Override
	public DbApprovalDto getDbApprovalById(String id) {
		DbApproval dbApproval = dbApprovalMapper.selectByPrimaryKey(id);
		if (dbApproval == null) {
			throw new CommonException("查询不到这个审批");
		}
		DbApprovalDto dto = po2VO(dbApproval, DbApprovalDto.class);
		addMoreInfo(dto);
		addTaskInfo(dto);
		return dto;
	}

	/**
	 * 根据发布ID获取审批
	 *
	 * @param pubId 发布ID
	 * @return DbApprovalDto对象
	 */
	@Override
	public DbApprovalDto getDbApprovalByPubId(String pubId) {
		DbApprovalExample example = new DbApprovalExample();
		DbApprovalExample.Criteria criteria = example.createCriteria();
		criteria.andTaskIdEqualTo(pubId);
		List<DbApproval> dbApprovalList = dbApprovalMapper.selectByExample(example);
		if (CommonUtil.isEmpty(dbApprovalList)) {
			return new DbApprovalDto();
		}

		DbApprovalDto dto = po2VO(dbApprovalList.get(0), DbApprovalDto.class);
		addMoreInfo(dto);
		addTaskInfo(dto);
		return dto;
	}

	/**
	 * 为对象添加任务详情信息
	 *
	 * @param dto DbApprovalDto对象
	 */
	private void addTaskInfo(DbApprovalDto dto) {
		if (null == dto) {
			return;
		}
		String dataType = dto.getDataType();
		String taskId = dto.getTaskId();
		if (StringUtil.isEmpty(dataType) || StringUtil.isEmpty(taskId)) {
			return;
		}

		ResultVo res;
		switch (dataType) {
			case "DB":
				res = dbPubTableService.getDetailedInfo(taskId);
				dto.setTaskInfo(res.getData());
				break;
			case "DBS":
				res = dbPubTsService.getDetailedInfo(taskId);
				dto.setTaskInfo(res.getData());
				break;
			case "FILE":
				res = dbPubFileService.getDbPubFile(taskId);
				DbPubFileDto pubFile = (DbPubFileDto) res.getData();
				changeParams(pubFile);
				dto.setTaskInfo(pubFile);
				break;
			case "SERVICE":
				res = dbPubServiceService.getApprovingPubService(taskId);
				dto.setTaskInfo(res.getData());
				break;
			default:
				break;
		}
	}

	/**
	 * 为对象列表添加更多信息
	 *
	 * @param dtoList 对象列表
	 */
	private void addMoreInfo(List<DbApprovalDto> dtoList) {
		dtoList.forEach(this::addMoreInfo);
	}

	/**
	 * 为对象添加更多信息
	 *
	 * @param dto 对象
	 */
	private void addMoreInfo(DbApprovalDto dto) {
		TaskInfo taskInfo = dbPubSubInfoService.getTaskInfo(dto.getTaskType(), dto.getDataType(), dto.getTaskId());
		dto.setTaskName(taskInfo.getTaskName());
		dto.setTaskDesc(taskInfo.getTaskDesc());

		dto.setApproverUserName(userService.getUserNameById(dto.getAppUserId()));
		dto.setApproverOrgName(userService.getUserNameById(dto.getAppOrgId()));
		dto.setApplicantName(userService.getUserNameById(dto.getCrtUserId()));
		dto.setApplicantOrgName(dbOrgService.getOrgNameByOrgId(dto.getCrtOrgId()));
	}

	/**
	 * 分页查询由我处理的审批或由我发起的审批
	 *
	 * @param type      审批类型 (CreatedByMe-由我发起的审批, ApprovedByMe-由我处理的审批)
	 * @param status    审批状态 (REJECTED, PASSED)
	 * @param pageIndex 页码
	 * @param pageSize  每页大小
	 * @return DbApprovalDto对象列表
	 */
	@Override
	public PageInfo<DbApprovalDto> getDbApprovalList(String type, String status, Integer pageIndex, Integer pageSize) {
		DbApprovalExample example = new DbApprovalExample();
		DbApprovalExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		criteria.andStatusEqualTo(status);
		// 待我处理的审批
		if ("ApprovedByMe".equals(type)) {
			criteria.andAppUserIdEqualTo(UserUtil.getUserId());
			criteria.andAppOrgIdEqualTo(UserUtil.getOrgId());
		}
		// 由我发起，待别人处理的审批
		if ("CreatedByMe".equals(type)) {
			criteria.andCrtUserIdEqualTo(UserUtil.getUserId());
			criteria.andCrtOrgIdEqualTo(UserUtil.getOrgId());
		}

		PageInfo<DbApproval> pageInfo = PageHelper.startPage(pageIndex,
				pageSize).doSelectPageInfo(() -> dbApprovalMapper.selectByExample(example));
		List<DbApproval> list = pageInfo.getList();

		List<DbApprovalDto> dtoList = CommonUtil.listPo2VO(list, DbApprovalDto.class);
		addMoreInfo(dtoList);
		PageInfo<DbApprovalDto> dtoPageInfo = po2VO(pageInfo, PageInfo.class);
		dtoPageInfo.setList(dtoList);

		return dtoPageInfo;
	}

	/**
	 * 添加审批
	 *
	 * @param dbApproval 审批对象
	 */
	@Override
	public DbApproval addApproval(DbApproval dbApproval) {
		dbApproval.setId(CommonUtil.getUUID());
		dbApproval.setStatus(Constants.APPROVAL_STATUS_TODO);
		dbApproval.setAppDesc("");

		EntityUtils.setCreateAndUpdateInfo(dbApproval);
		dbApprovalMapper.insert(dbApproval);

		return dbApproval;
	}

	/**
	 * 根据ID删除审批
	 *
	 * @param id 审批ID
	 */
	@Override
	public ResultVo deleteApprovalById(String id) {
		DbApproval dbApproval = dbApprovalMapper.selectByPrimaryKey(id);
		if (dbApproval == null) {
			return ResultVo.ok();
		}

		if (Constants.APPROVAL_STATUS_TODO.equals(dbApproval.getStatus())) {
			return ResultVo.fail("没有处理的申请不能删除");
		}

		dbApproval.setId(id);
		dbApproval.setDelStatus(Constants.DEL_STATUS_DEL);
		dbApprovalMapper.updateByPrimaryKey(dbApproval);

		return ResultVo.ok();
	}

	/**
	 * 更新审批
	 *
	 * @param dbApproval 审批对象
	 */
	@Override
	public void handleApproval(DbApprovalVo dbApproval) {
		// 添加审批人ID和审批机构ID
		dbApproval.setAppUserId(UserUtil.getUserId());
		dbApproval.setAppOrgId(UserUtil.getOrgId());
		dbApproval.setAppTm(CommonUtil.getCurrentTime());

		EntityUtils.setUpdateInfo(dbApproval);
		dbApprovalMapper.updateByPrimaryKeySelective(dbApproval);

		String taskType = dbApproval.getTaskType();
		TaskInfo taskInfo = dbPubSubInfoService.getTaskInfo(taskType, dbApproval.getDataType(),
				dbApproval.getTaskId());

		DbApproval approval = dbApprovalMapper.selectByPrimaryKey(dbApproval.getId());
		if (approval == null) {
			throw new CommonException(NOT_APPROVE_MSG);
		}

		// 发送消息通知用户审批结果
		String status = approval.getStatus();
		DbMsg dbMsg = new DbMsg();
		// 申请人
		dbMsg.setUserId(approval.getCrtUserId());
		// 提示
		dbMsg.setMsgType("TS");
		// 业务ID就是审批的ID
		dbMsg.setBusiId(approval.getId());
		dbMsg.setBusiType(approval.getTaskType() + "-" + approval.getDataType());
		dbMsg.setResId("");
		String taskId = approval.getTaskId();

		// 发布审批
		if (Constants.PUB.equals(taskType)) {
			if (Constants.APPROVAL_STATUS_PASSED.equals(status)) {
				// 申请通过
				dbMsg.setMsgContent(String.format(APPROVAL_STATUS_PASSED_MSG, taskInfo.getTaskName(), taskInfo.getTaskDesc(), approval.getAppDesc()));
				dealResultVo(sysApi.addNewMsg(dbMsg));
				// 审批通过后启动发布流程
				dealResultVo(dbPubSubInfoService.pub(approval.getTaskType(), approval.getDataType(), taskId));
			} else if (Constants.APPROVAL_STATUS_REJECTED.equals(status)) {
				// 申请被拒绝
				// 设置状态为拒绝
				dbPubSubInfoService.setPubStatus(approval.getDataType(), taskId, "REJECTED");
				dbMsg.setMsgContent(String.format(APPROVAL_STATUS_REJECTED_MSG, taskInfo.getTaskName(), taskInfo.getTaskDesc(), approval.getAppDesc()));
				dealResultVo(sysApi.addNewMsg(dbMsg));
			}
		} else { // 订阅审批
			// 申请通过
			if (Constants.APPROVAL_STATUS_PASSED.equals(status)) {
				dbMsg.setMsgContent(String.format(APPROVAL_STATUS_PASSED_MSG, taskInfo.getTaskName(), taskInfo.getTaskDesc(), approval.getAppDesc()));
				dealResultVo(sysApi.addNewMsg(dbMsg));
				// 审批通过后设置订阅任务状态为停止
				dbPubSubInfoService.setSubStatus(approval.getDataType(), taskId);
			} else if (Constants.APPROVAL_STATUS_REJECTED.equals(status)) {
				// 申请被拒绝
				dbPubSubInfoService.rejectSubStatus(approval.getDataType(), taskId);
				dbMsg.setMsgContent(String.format(APPROVAL_STATUS_REJECTED_MSG, taskInfo.getTaskName(), taskInfo.getTaskDesc(), approval.getAppDesc()));
				dealResultVo(sysApi.addNewMsg(dbMsg));
			}
		}

		// 设置消息状态为已处理
		DbMsg msg = new DbMsg();
		msg.setId(dbApproval.getMsgId());
		msg.setDoStatus("Y");
		msg.setNotRemind("Y");
		sysApi.doMsg(msg);
	}

	private void dealResultVo(ResultVo vo) {
		if (vo == null || vo.getStatus() == 500) {
			throw new CommonException(FAIL_MSG);
		}
	}

	private DbMsg buildDbMsg(String appUserId, String msgContent, String msgType,
	                         String busiId, String busiType, String resId) {
		DbMsg dbMsg = new DbMsg();
		// 用户指定审批人
		dbMsg.setUserId(appUserId);
		dbMsg.setMsgContent(msgContent);
		dbMsg.setMsgType(msgType);
		// 业务ID就是审批的ID
		dbMsg.setBusiId(busiId);
		dbMsg.setBusiType(busiType);
		dbMsg.setResId(resId);
		return dbMsg;
	}

	/**
	 * 提交发布审批
	 *
	 * @param dbApproval 审批对象
	 * @return 结果
	 */
	@Override
	public ResultVo submitPubApproval(DbApproval dbApproval) {
		DbApproval approval = addApproval(dbApproval);

		// 添加消息
		String taskId = dbApproval.getTaskId();
		String taskType = dbApproval.getTaskType();
		String dataType = dbApproval.getDataType();
		TaskInfo taskInfo = dbPubSubInfoService.getTaskInfo(taskType, dataType, taskId);
		String msgContent = String.format(PUB_TASK_MSG, taskInfo.getTaskName(), taskInfo.getTaskDesc(), dbApproval.getAppComment());
		DbMsg dbMsg = buildDbMsg(dbApproval.getAppUserId(), msgContent,
				"DCL", approval.getId(), taskType + "-" + dataType, "");

		ResultVo vo = sysApi.addNewMsg(dbMsg);
		if (vo == null || vo.getStatus() == 500) {
			throw new CommonException(FAIL_MSG);
		}

		// 设置状态为审批中
		dbPubSubInfoService.setPubStatus(dataType, taskId, Constants.PUB_STATUS_APPROVING);

		return ResultVo.ok("已经提请审批");
	}

	/**
	 * 批量提交发布审批
	 *
	 * @param list 审批对象列表
	 * @return 发布结果
	 */
	@Override
	public ResultVo submitPubApprovalBatch(List<DbApproval> list) {
		if (CommonUtil.isNotEmpty(list)) {
			list.forEach(this::submitPubApproval);
		}

		return ResultVo.ok("已经提请审批");
	}

	/**
	 * 提交订阅审批
	 *
	 * @param dbApproval 审批对象
	 * @return 结果
	 */
	@Override
	public ResultVo submitSubApproval(DbApproval dbApproval) {
		DbApproval approval = addApproval(dbApproval);

		// 添加消息
		// 发布或者订阅的ID
		String taskId = dbApproval.getTaskId();
		String taskType = dbApproval.getTaskType();
		String dataType = dbApproval.getDataType();
		TaskInfo taskInfo = dbPubSubInfoService.getTaskInfo(taskType, dataType, taskId);

		String msgContent = String.format(SUB_TASK_MSG, taskInfo.getTaskName(), taskInfo.getTaskDesc(), dbApproval.getAppComment());
		DbMsg dbMsg = buildDbMsg(dbApproval.getAppUserId(), msgContent,
				"DCL", approval.getId(), taskType + "-" + dataType, "");

		ResultVo vo = sysApi.addNewMsg(dbMsg);
		if (vo == null || vo.getStatus() == 500) {
			throw new CommonException(FAIL_MSG);
		}

		// 设置状态为审批中
		dbPubSubInfoService.setPubStatus(dataType, taskId, Constants.PUB_STATUS_APPROVING);

		return ResultVo.ok("已经提请审批");
	}

	/**
	 * 重新提请审批
	 *
	 * @param dbApproval 审批对象
	 * @return 结果
	 */
	@Override
	public ResultVo resubmitPubApproval(DbApproval dbApproval) {
		String id = dbApproval.getId();

		DbApprovalDto approval = getDbApprovalById(id);
		approval.setAppComment(dbApproval.getAppComment());
		approval.setStatus(Constants.APPROVAL_STATUS_TODO);
		approval.setTaskDesc("");
		EntityUtils.setUpdateInfo(approval);
		dbApprovalMapper.updateByPrimaryKeySelective(approval);

		// 添加消息
		String taskId = approval.getTaskId();
		String taskType = approval.getTaskType();
		String dataType = approval.getDataType();
		TaskInfo taskInfo = dbPubSubInfoService.getTaskInfo(taskType, dataType, taskId);

		String msgContent = String.format(PUB_TASK_MSG, taskInfo.getTaskName(), taskInfo.getTaskDesc(), dbApproval.getAppComment());
		DbMsg dbMsg = buildDbMsg(dbApproval.getAppUserId(), msgContent,
				"DCL", id, taskType + "-" + dataType, "");

		ResultVo vo = sysApi.addNewMsg(dbMsg);
		if (vo == null || vo.getStatus() == 500) {
			throw new CommonException(FAIL_MSG);
		}

		// 设置状态为审批中
		dbPubSubInfoService.setPubStatus(dataType, taskId, Constants.PUB_STATUS_APPROVING);

		return ResultVo.ok("已经重新提请审批");
	}

	/**
	 * 查询库表发布为无审批发布还是有审批发布
	 *
	 * @return YES-有审批发布，NO-无审批发布
	 */
	@Override
	public ResultVo pubWithApproval() {
		String value = dbParamsService.getParamsValueByTypeAndKey("approval", "pub_table");
		return ResultVo.ok(value);
	}

	/**
	 * 码值转换
	 *
	 * @param info DbPubFile对象
	 */
	private void changeParams(DbPubFile info) {
		info.setSenLevel(dbParamsService.getParamsValueByTypeAndKey("sen_grade", info.getSenLevel()));
		info.setFileType(dbParamsService.getParamsValueByTypeAndKey("data_cate", info.getFileType()));
		info.setExtractType(dbParamsService.getParamsValueByTypeAndKey("ext_way", info.getExtractType()));
		info.setUseType(dbParamsService.getParamsValueByTypeAndKey("use_type", info.getUseType()));
		String useScope = info.getUseScope();
		if (orgMap.isEmpty()) {
			List<DbOrg> orgList = dbOrgService.list();
			for (DbOrg dbOrg : orgList) {
				orgMap.put(dbOrg.getOrgId(), dbOrg.getOrgName());
			}
		}
		if (StringUtil.isNotEmpty(useScope)) {
			StringBuilder orgs = new StringBuilder();
			String[] orgIds = useScope.split(",");
			for (String orgId : orgIds) {
				String orgName = orgMap.get(orgId);
				if (StringUtil.isEmpty(orgName)) {
					continue;
				}
				orgs.append(orgName).append(",");
			}
			if (StringUtil.isNotEmpty(orgs.toString())) {
				orgs = new StringBuilder(orgs.substring(0, orgs.lastIndexOf(",")));
			}
			info.setUseScope(orgs.toString());
		}
	}
}

