package com.microcore.center.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.*;
import com.microcore.center.model.*;
import com.microcore.center.service.*;
import com.microcore.common.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.api.SysApi;
import com.microcore.api.model.DbOrg;
import com.microcore.api.vo.PolicyInfo;
import com.microcore.api.vo.PolicyVo;
import com.microcore.api.vo.SecurityKeyVo;
import com.microcore.center.client.FileKitTemplate;
import com.microcore.center.client.KeymanagerTemplate;
import com.microcore.center.client.PolicyTemplate;
import com.microcore.center.dto.DbExtTemplateDto;
import com.microcore.center.dto.DbPubFileDto;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.dto.WithdrawOrgDto;
import com.microcore.center.util.CheckingUtil;
import com.microcore.common.rabbit.SuperviseRabbitServer;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.JGUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;
import com.microcore.common.vo.WithdrawPubVo;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import static com.microcore.common.util.CommonUtil.removeOrgList;

/**
 * 文件发布服务层
 *
 * @auther ZY
 */
@Service
@Transactional
@Slf4j
public class DbPubFileServiceImpl implements DbPubFileService {

	@Autowired
	private DbPubFileMapper dbPubFileMapper;
	@Autowired
	private DbParamsService dbParamsService;
	@Autowired
	private DbSubFileMapper dbSubFileMapper;
	@Autowired
	private FileKitTemplate fileKitTemplate;
	@Autowired
	private PolicyTemplate policyTemplate;
	@Autowired
	private DbFileKitService dbFileKitService;
	@Autowired
	private UserService userService;
	@Autowired
	private SysApi sysApi;
	@Autowired
	private DbModelService dbModelService;
	@Autowired
	private DbPubTableExtMapper dbPubTableExtMapper;
	@Autowired
	private DbOrgService dbOrgService;
	@Autowired
	private KeymanagerTemplate keymanagerTemplate;
	@Autowired
	private DbExtTemplateMapper dbExtTemplateMapper;
	@Autowired
	private DbPolicyTemplateMapper dbPolicyTemplateMapper;
	@Autowired
	private SuperviseRabbitServer superviseRabbitServer;
	@Autowired
	private DbSubFileService dbSubFileService;
	@Autowired
	private DbPolicyItemMapper dbPolicyItemMapper;
	@Autowired
	private DbAreaService dbAreaService;
	@Autowired
	private BlockChService blockChService;
	@Autowired
	private DbNameSpaceService dbNameSpaceService;
	@Autowired
	private DbOrgAreaService dbOrgAreaService;

	private static final String LOG_DESCRIBE = "logDesc";
	private static final String PUB_FILE_TABLE_NAME = "db_pub_file";
	private static final String MESSAGE_TASK_NOT_EXIST = "任务不存在!";

	private static final Map<String, Integer> LEVEL_MAP = new HashMap<>();

	static {
		LEVEL_MAP.put("NSEC", 1);
		LEVEL_MAP.put("ISEC", 2);
		LEVEL_MAP.put("CSEC", 3);
		LEVEL_MAP.put("DSEC", 4);
	}

	/**
	 * 新增文件发布
	 */
	@Override
	public ResultVo addDbPubFile(DbPubFileDto dbPubFileDto) {
		DbPubFile dbPubFile = new DbPubFile();
		String origPath = dbPubFileDto.getOrigPath();
		if (StringUtil.isEmpty(origPath)) {
			return ResultVo.fail("发布目录不能为空！");
		}

		if (!CheckingUtil.checkingPath(origPath)) {
			return ResultVo.fail("发布目录不规范！");
		}

		if (!origPathCheck(origPath)) {
			return ResultVo.fail("发布目录已经存在！");
		}
		//前台传值
		dbPubFile.setPubName(dbPubFileDto.getPubName());
		dbPubFile.setOrigPath(origPath);
		dbPubFile.setPubDesc(dbPubFileDto.getPubDesc());
		dbPubFile.setSenLevel(dbPubFileDto.getSenLevel());
		dbPubFile.setFileType(dbPubFileDto.getFileType());
		//自定义策略模板
		dbPubFile.setUseType(dbPubFileDto.getUseType());
		dbPubFile.setStartDate(dbPubFileDto.getStartDate());
		dbPubFile.setEndDate(dbPubFileDto.getEndDate());
		String extractType = dbPubFileDto.getExtractType();
		dbPubFile.setExtractType(extractType);
		String backPath = dbPubFileDto.getBackupPath();
		if (StringUtil.isNotEmpty(backPath) && !CheckingUtil.checkingPath(backPath)) {
			return ResultVo.fail("备份目录不规范！");
		}
		dbPubFile.setBackupPath(backPath);
		dbPubFile.setKeywords(dbPubFileDto.getKeywords());
		dbPubFile.setUseFre(dbPubFileDto.getUseFre());
		dbPubFile.setAgainAcc(dbPubFileDto.getAgainAcc());
		dbPubFile.setReportCase(dbPubFileDto.getReportCase());
		String orgId = UserUtil.getOrgId();
		String userId = UserUtil.getUserId();
		String autoChange = "false";
		if (StringUtil.isNotEmpty(dbPubFileDto.getAutoChange())) {
			autoChange = dbPubFileDto.getAutoChange().toLowerCase();
		}
		if ("true".equals(autoChange)) {//直接交换授权范围不能为空
			if (!checkUseScope(dbPubFileDto)) {
				return ResultVo.fail("直接交换授权范围不能为空");
			}
			if ("BACKUP".equals(extractType)) {//备份
				String backupDir = dbFileKitService.getPathDir(orgId, "backupDir");
				dbPubFile.setBackupPath(backupDir);
			}
		}
		String useScope = changeUseScope(dbPubFileDto.getUseScope());
		dbPubFile.setUseScope(useScope);
		dbPubFile.setAutoChange(autoChange);
		dbPubFile.setStatus("NPUB");
		dbPubFile.setRunStatus("STOP");
		dbPubFile.setDelStatus("NOR");
		//策略
		Date systemDate = CommonUtil.getSystemDate();
		String pubId = CommonUtil.getUUID();
		String polId = CommonUtil.getUUID();
		PolicyVo policyVo = null;
		try {
			policyVo = addPolicy(dbPubFileDto, dbPubFile, origPath, orgId, userId, systemDate, pubId, polId);
		} catch (Exception e) {
			log.error("策略添加异常", e);
			return ResultVo.fail(e.getMessage());
		}

		//模型
		String modelName = dbPubFileDto.getPubName();
		String dataLevel = dbPubFileDto.getFileType();
		String desc = "";
		if (StringUtil.isNotEmpty(dbPubFileDto.getPubDesc())) {
			desc = modelName + "-" + dbPubFileDto.getPubDesc();
		}

		ResultVo<String> more = dbModelService.addFileModel(modelName, dataLevel, desc);

		if (more.getStatus() != 200) {
			return ResultVo.fail("模型生成失败！");
		}
		String modelId = more.getData();
		dbPubFile.setModelId(modelId);
		// 后台赋值
		dbPubFile.setPubId(pubId);
		dbPubFile.setPolId(polId);
		// makeDir
		String makeDir = dbFileKitService.getPathDir(orgId, "makeDir");
		if (StringUtil.isEmpty(makeDir)) {
			return ResultVo.fail("套件信息错误，获取打标目录失败！");
		}
		dbPubFile.setPubPath(makeDir);
		dbPubFile.setCrtUserId(userId);
		dbPubFile.setCrtOrgId(orgId);
		dbPubFile.setCrtTm(systemDate);
		dbPubFile.setTemplateId(dbPubFileDto.getTemplateId());
		dbPubFileDto.setCrtTm(systemDate);
		dbPubFileMapper.insert(dbPubFile);
		//保存自定义策略扩展字段
		saveExtTemplate(dbPubFileDto, pubId);

		String domain = dbNameSpaceService.getCnameById(dbPubFile.getFileType());
		blockChService.dataPubAndShare(dbPubFile.getPubId(), domain, dbPubFile.getSenLevel(), "text", dbPubFile.getUseScope());

		//推送更新消息
//		sendPubUpdateMsg("", dbPubFileDto, orgId, userId);

		JSONObject obj = JSONObject.fromObject(dbPubFile);
		obj.put(LOG_DESCRIBE, "新增文件发布成功！");
		//添加日志
		sysApi.addLog("add", "发布信息", PUB_FILE_TABLE_NAME, dbPubFile.getPubId(), obj.toString());
		return ResultVo.ok("新增发布成功！");
	}

	/**
	 * 授权范围转换
	 *
	 * @param useScope
	 * @return
	 */
	private String changeUseScope(String useScope) {
		if (StringUtil.isEmpty(useScope)) {
			return useScope;
		}
		String[] arr = useScope.split("/");
		if ("ORG".equals(arr[0])) {//机构
			return useScope;
		}
		String scopeStr = arr[1];//域
		String scope = "ORG/";
		String orgStr = dbOrgAreaService.getOrgIds(scopeStr);
		if (null != orgStr) {
			scope += orgStr;
		}
		return scope;
	}

	private boolean checkUseScope(DbPubFileDto dbPubFileDto) {
		if (StringUtil.isEmpty(dbPubFileDto.getUseScope())) {
			return false;
		} else {
			String[] useScope = dbPubFileDto.getUseScope().split("/");
			if (useScope.length < 2 || StringUtil.isEmpty(useScope[1])) {
				return false;
			}
		}
		return true;
	}

	private PolicyVo addPolicy(DbPubFileDto dbPubFileDto, DbPubFile dbPubFile, String origPath, String orgId, String userId, Date systemDate,
	                           String pubId, String polId) throws Exception {
		PolicyVo policyVo = new PolicyVo();
		policyVo.setPolId(polId);
		policyVo.setLabelId(pubId);
		policyVo.setTableName(origPath);
		policyVo.setPolComment(dbPubFileDto.getPubDesc());
		policyVo.setPolResType("File");
		policyVo.setPolVersion(1);
		policyVo.setPolResId(dbPubFileDto.getPubName());
		policyVo.setPolPublish(userId);
		String useScope = "";
		if (StringUtil.isNotEmpty(dbPubFile.getUseScope())) {
			String[] scope = dbPubFile.getUseScope().split("/");
			if (scope.length > 1) {
				useScope = scope[1];
			}
		}
		policyVo.setPolAuthScope(useScope);
		policyVo.setPolAuthType("ORG");
		policyVo.setPolSecurityLevel(dbPubFileDto.getSenLevel());
		policyVo.setPolAuthStart(dbPubFileDto.getStartDate());
		policyVo.setPolAuthEnd(dbPubFileDto.getEndDate());
		policyVo.setTwice(dbPubFileDto.getAgainAcc());
		policyVo.setFrequency(String.valueOf(dbPubFileDto.getUseFre()));
		policyVo.setStatus("NOR");
		policyVo.setDelStatus("NOR");
		policyVo.setCrtUserId(userId);
		policyVo.setCrtOrgId(orgId);
		policyVo.setCrtTm(systemDate);
		List<PolicyVo> list = new ArrayList<>();
		list.add(policyVo);
		PolicyInfo policyInfo = new PolicyInfo();
		policyInfo.setPolicies(list);
		policyTemplate.addPolicyInfo(policyInfo);

		String scope = policyVo.getPolAuthScope();
		// 产生密钥信息
		if (StringUtil.isNotEmpty(scope)) {
			SecurityKeyVo securityKeyVo = new SecurityKeyVo();
			String[] authOrgs = scope.split(",");
			List<DbOrg> listOrg = new ArrayList<>();
			for (String orgId2 : authOrgs) {
				DbOrg dbOrg = dbOrgService.getDbOrgByOrgId(orgId2);
				listOrg.add(CommonUtil.po2VO(dbOrg, DbOrg.class));
			}
			securityKeyVo.setOrgs(listOrg);
			securityKeyVo.setLabelId(pubId);
			securityKeyVo.setPolicyId(polId);
			keymanagerTemplate.addSecurity(securityKeyVo);
		}

		return policyVo;
	}

	/**
	 * 保存自定义策略扩展字段
	 *
	 * @param dbPubFileDto
	 */
	private void saveExtTemplate(DbPubFileDto dbPubFileDto, String pubId) {
		List<DbExtTemplateDto> template = dbPubFileDto.getTemplate();
		if (null == template || template.isEmpty()) {
			return;
		}
		template.forEach(ext -> {
			DbPubTableExt pubExt = new DbPubTableExt();
			pubExt.setId(pubId);
			pubExt.setExtAttrCname(ext.getExtPolicyCname());
			pubExt.setExtAttrEname(ext.getExtPolicyEname());
			pubExt.setTemplateType(ext.getTemplateType());
			pubExt.setDataType(ext.getDataType());
			pubExt.setExtValue(ext.getExtValue());
			pubExt.setLabelId(pubId);
			dbPubTableExtMapper.insert(pubExt);
		});
	}

	/**
	 * ID检查
	 */
	private String checkFile(String fid) {
		DbPubFile file = dbPubFile(fid);
		if (file != null) {
			fid = CommonUtil.getUUID();
			return checkFile(fid);
		}
		return fid;
	}

	/**
	 * ID检查
	 */
	private String checkedPol(String policyId) {
		ResultVo resultVo = policyTemplate.queryPolicy(policyId);
		PolicyVo policyVo = CommonUtil.map2POx((LinkedHashMap<String, Object>) resultVo.getData(), PolicyVo.class);
		if (policyVo != null && policyVo.getPolId() != null) {
			policyId = CommonUtil.getUUID();
			return checkedPol(policyId);
		}
		return policyId;
	}

	/**
	 * 修改文件发布
	 */
	@Override
	public ResultVo updDbPubFile(DbPubFileDto dbPubFileDto) {
		DbPubFile dbPubFile = dbPubFile(dbPubFileDto.getPubId());
		if (dbPubFile == null) {
			return ResultVo.fail("修改失败！");
		}
		if ("YPUB".equals(dbPubFile.getStatus())) {
			return ResultVo.fail("该任务已经发布出去，不能修改！");
		}
		String orgId = CommonUtil.getOrgId();
		String userId = CommonUtil.getUserId();
		//前台传值
		dbPubFile.setPubName(dbPubFileDto.getPubName());
		dbPubFile.setOrigPath(dbPubFileDto.getOrigPath());
		dbPubFile.setPubDesc(dbPubFileDto.getPubDesc());
		dbPubFile.setSenLevel(dbPubFileDto.getSenLevel());
		dbPubFile.setFileType(dbPubFileDto.getFileType());
		//自定义策略模板
		dbPubFile.setUseType(dbPubFileDto.getUseType());
		dbPubFile.setTemplateId(dbPubFileDto.getTemplateId());
		dbPubFile.setExtractType(dbPubFileDto.getExtractType());
		dbPubFile.setBackupPath(dbPubFileDto.getBackupPath());
		if ("true".equals(dbPubFile.getAutoChange())) {//直接交换授权范围不能为空
			if (!checkUseScope(dbPubFileDto)) {
				return ResultVo.fail("直接交换授权范围不能为空");
			}
			if ("BACKUP".equals(dbPubFileDto.getExtractType())) {//备份
				String backupDir = dbFileKitService.getPathDir(orgId, "backupDir");
				dbPubFile.setBackupPath(backupDir);
			}
		}
		String useScope = changeUseScope(dbPubFileDto.getUseScope());
		dbPubFile.setUseScope(useScope);
		dbPubFile.setStartDate(dbPubFileDto.getStartDate());
		dbPubFile.setEndDate(dbPubFileDto.getEndDate());
		dbPubFile.setUseFre(dbPubFileDto.getUseFre());
		dbPubFile.setAgainAcc(dbPubFileDto.getAgainAcc());
		dbPubFile.setReportCase(dbPubFileDto.getReportCase());
		dbPubFile.setAutoApp(dbPubFileDto.getAutoApp());
		//策略
		ResultVo vo = policyTemplate.queryPolicy(dbPubFile.getPolId());
		if (null==vo||vo.getStatus()!=200) {
			return ResultVo.fail();
		}
		PolicyVo policyVo = CommonUtil.map2POx((LinkedHashMap<String, Object>) vo.getData(), PolicyVo.class);
		policyVo.setPolColumn(dbPubFileDto.getPubDesc());
		policyVo.setPolResId(dbPubFileDto.getPubName());
		String scope = "";
		if (StringUtil.isNotEmpty(useScope)) {
			scope = useScope.split("/")[1];
		}
		policyVo.setPolAuthScope(scope);
		policyVo.setPolSecurityLevel(dbPubFileDto.getSenLevel());
		policyVo.setPolAuthStart(dbPubFileDto.getStartDate());
		policyVo.setPolAuthEnd(dbPubFileDto.getEndDate());
		policyVo.setTwice(dbPubFileDto.getAgainAcc());
		policyVo.setFrequency(String.valueOf(dbPubFileDto.getUseFre()));
		policyVo.setUpdUserId(userId);
		policyVo.setUpdOrgId(orgId);
		policyVo.setUpdTm(CommonUtil.getSystemDate());
		List<PolicyVo> list = new ArrayList<>();
		list.add(policyVo);
		PolicyInfo policyInfo = new PolicyInfo();
		policyInfo.setPolicies(list);
		ResultVo resultVo = policyTemplate.updPolicyInfo(policyInfo);
		if (null==resultVo||!Constants.STATUS_OK.equals(resultVo.getStatus())) {
			return ResultVo.fail("策略修改错误！");
		}
		//后台赋值
		dbPubFile.setUpdUserId(userId);
		dbPubFile.setUpdTm(CommonUtil.getSystemDate());
		int i = dbPubFileMapper.updateByPrimaryKeySelective(dbPubFile);
		if (i == 1) {
			//自定义策略修改
			updateExtTemplate(dbPubFileDto);
//			//推送更新消息
//			sendPubUpdateMsg(orgUseScope, dbPubFileDto, orgId, userId);

			JSONObject obj = JSONObject.fromObject(dbPubFile);
			obj.put(LOG_DESCRIBE, "修改成功！");
			//添加日志
			sysApi.addLog("upd", "发布信息", PUB_FILE_TABLE_NAME, dbPubFile.getPubId(), obj.toString());
			return ResultVo.ok("修改成功！");
		} else {
			return ResultVo.ok("修改失败！");
		}
	}

	/**
	 * 推送更新消息
	 *
	 * @param orgUseScope
	 * @param dbPubFileDto
	 * @param orgId
	 * @param userId
	 */
	private void sendPubUpdateMsg(String orgUseScope, DbPubFileDto dbPubFileDto, String orgId, String userId) {
		Map<String, Object> value = new LinkedHashMap<>();
		value.put("CreateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dbPubFileDto.getCrtTm()));
		value.put("OperaTime", System.currentTimeMillis() + "");
		value.put("OwnerID", userId);
		value.put("OperatType", "pub");
		value.put("DepartmentID", orgId);
		value.put("DataSourceType", "1");
		value.put("DataSourceID", dbPubFileDto.getPubId());
		value.put("DataTargetID", "");
		value.put("DataSourceName", dbPubFileDto.getOrigPath());
		value.put("DataSourceLevel", createDataSourceLevel(dbPubFileDto.getOrigPath(),
				dbPubFileDto.getOrigPath(), dbPubFileDto.getSenLevel()));
		value.put("DataSouceTaxon", "");
		String useScope = "";
		if (StringUtil.isNotEmpty(dbPubFileDto.getUseScope())) {
			useScope = dbPubFileDto.getUseScope().split("/")[1].replace(",", " ");
		}
		value.put("updateUserList", useScope);
		if (StringUtil.isNotEmpty(orgUseScope)) {
			orgUseScope = orgUseScope.split("/")[1].replace(",", " ");
		}
		value.put("UserList", orgUseScope);
		String message = JGUtil.createMQMsg(value, 106);
//			JGUtil.sendMsg("label_labelInfos_update_log", message);
		JGUtil.sendTopic(superviseRabbitServer.getConnection(), message);
	}

	private String createDataSourceLevel(String orgDir, String dir, String senLevel) {
		Integer level = LEVEL_MAP.get(senLevel);
		File fileDir = new File(dir);
		String str = "";
		if (!fileDir.isDirectory()) {
			str = dir.replace(orgDir, "") + ":" + level;
			return str;
		}
		File[] fileList = fileDir.listFiles();
		if (fileList != null) {
			for (File file : fileList) {
				if (!StringUtil.isEmpty(str)) {
					str += ",";
				}
				if (file.isDirectory()) {
					str += createDataSourceLevel(orgDir, file.getPath(), senLevel);
				} else {
					str += file.getPath().replace(orgDir, "") + ":" + level;
				}
			}
		}
		return str;
	}


	/**
	 * 自定义策略修改
	 *
	 * @param dbPubFileDto
	 */
	private void updateExtTemplate(DbPubFileDto dbPubFileDto) {
		String id = dbPubFileDto.getPubId();
		List<DbExtTemplateDto> template = dbPubFileDto.getTemplate();
		if (null == template || template.isEmpty()) {
			return;
		}
		template.forEach(ext -> {
			DbPubTableExt pubExt = new DbPubTableExt();
			pubExt.setExtValue(ext.getExtValue());
			DbPubTableExtExample example = new DbPubTableExtExample();
			DbPubTableExtExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			criteria.andExtAttrCnameEqualTo(ext.getExtPolicyCname());
			criteria.andExtAttrEnameEqualTo(ext.getExtPolicyEname());
			dbPubTableExtMapper.updateByExampleSelective(pubExt, example);
		});
	}

	/**
	 * 自定义策略删除
	 *
	 * @param templateDto
	 * @return
	 */
	private int delExtTemplate(DbExtTemplateDto templateDto) {
		if (null == templateDto || StringUtil.isEmpty(templateDto.getId())
				|| StringUtil.isEmpty(templateDto.getExtPolicyEname())
				|| StringUtil.isEmpty(templateDto.getExtPolicyCname())) {
			return 0;
		}
		DbPubTableExtExample example = new DbPubTableExtExample();
		DbPubTableExtExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(templateDto.getId());
		criteria.andExtAttrCnameEqualTo(templateDto.getExtPolicyCname());
		criteria.andExtAttrEnameEqualTo(templateDto.getExtPolicyEname());
		return dbPubTableExtMapper.deleteByExample(example);
	}

	/**
	 * 删除文件发布
	 */
	@Override
	public ResultVo delDbPubFile(String fid) {
		if (StringUtil.isNotEmpty(fid)) {
			DbPubFile files = dbPubFile(fid);
			if (files != null) {
				if ("STOP".equals(files.getRunStatus())) {
					//删除订阅
					DbSubFileExample example = new DbSubFileExample();
					DbSubFileExample.Criteria criteria = example.createCriteria();
					criteria.andPubIdEqualTo(files.getPubId());
					List<DbSubFile> dbSubFiles = dbSubFileMapper.selectByExample(example);
					if (!CommonUtil.isEmpty(dbSubFiles)) {
						for (DbSubFile dbSubFile : dbSubFiles) {
							dbSubFile.setDelStatus("DEL");
							dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
						}
					}
					//策略删除
					String userId = CommonUtil.getUserId();
					ResultVo result = policyTemplate.queryPolicy(files.getPolId());
					if (null==result||result.getStatus()!=200) {
						return ResultVo.fail("策略查询失败！");
					}
					PolicyVo policyVo = CommonUtil.map2POx((LinkedHashMap<String, Object>) result.getData(), PolicyVo.class);
					if (policyVo == null || policyVo.getPolId() == null) {
						return ResultVo.fail("没有策略！");
					}
					policyVo.setDelStatus("DEL");
					policyVo.setUpdUserId(userId);
					policyVo.setUpdTm(CommonUtil.getSystemDate());
					List<PolicyVo> list = new ArrayList<>();
					list.add(policyVo);
					PolicyInfo policyInfo = new PolicyInfo();
					policyInfo.setPolicies(list);
					ResultVo resultVo = policyTemplate.updPolicyInfo(policyInfo);
					if (resultVo.getStatus() != 200) {
						return ResultVo.fail("策略删除错误！");
					}
					DbPubFile file = new DbPubFile();
					file.setPubId(files.getPubId());
					file.setDelStatus("DEL");
					//删除套件发布
					fileKitTemplate.fileService("/filePub/delDbPubFile", file);
					dbPubFileMapper.updateByPrimaryKeySelective(file);
					JSONObject obj = JSONObject.fromObject(file);
					obj.put(LOG_DESCRIBE, "删除成功！");
					sysApi.addLog("del", "发布信息", PUB_FILE_TABLE_NAME, file.getPubId(), obj.toString());//添加日志
					return ResultVo.ok("删除成功！");
				}
				return ResultVo.fail("该任务已经启动，不能删除！");
			}
			return ResultVo.fail("该发布任务不存在！");
		}
		return ResultVo.fail("删除错误！");
	}

	@Override
	public ResultVo delDbPubFileOfBatch(String[] ids) {
		int successNum = 0;
		int failNum = 0;
		String failMsg = "";
		for(String id : ids) {
			try {
				ResultVo vo = this.delDbPubFile(id);
				if (vo.getStatus()==200) {
					successNum += 1;
				}else {
					failNum += 1;
					failMsg += vo.getMsg() + ";";
				}
			} catch (Exception e) {
				failNum += 1;
				failMsg += e.getMessage() + ";";
			}
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("successNum", successNum);
		resMap.put("failNum", failNum);
		resMap.put("failMsg", failMsg);
		return ResultVo.ok(resMap);
	}

	@Override
	public ResultVo startDbPubFileOfBatch(String[] ids) {
		int successNum = 0;
		int failNum = 0;
		String failMsg = "";
		for(String id : ids) {
			DbPubFile dFile = dbPubFile(id);
			if (null==dFile) {
				continue;
			}
			if ("RUN".equals(dFile.getRunStatus())) {
				successNum += 1;
				continue;
			}
			try {
				boolean flag = startPubFile(dFile);
				if (flag) {
					successNum += 1;
				}else {
					failNum += 1;
				}
			} catch (Exception e) {
				failNum += 1;
				failMsg += e.getMessage() + ";";
			}
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("successNum", successNum);
		resMap.put("failNum", failNum);
		resMap.put("failMsg", failMsg);
		return ResultVo.ok(resMap);
	}
	
	@Override
	public ResultVo stopDbPubFileOfBatch(String[] ids) {
		int successNum = 0;
		int failNum = 0;
		String failMsg = "";
		for(String id : ids) {
			DbPubFile dFile = dbPubFile(id);
			if (null==dFile) {
				continue;
			}
			if ("STOP".equals(dFile.getRunStatus())) {
				successNum += 1;
				continue;
			}
			try {
				stopPubFile(dFile);
				successNum += 1;
			} catch (Exception e) {
				failNum += 1;
				failMsg += e.getMessage() + ";";
			}
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("successNum", successNum);
		resMap.put("failNum", failNum);
		resMap.put("failMsg", failMsg);
		return ResultVo.ok(resMap);
	}
	
	/**
	 * 启动/停止 文件发布
	 */
	@Override
	public ResultVo startDbPubFile(String fid) {
		DbPubFile dFile = dbPubFile(fid);
		if (dFile != null) {
			if ("RUN".equals(dFile.getRunStatus())) {
				stopPubFile(dFile);
				return ResultVo.ok("任务已关闭！");
			} else if ("STOP".equals(dFile.getRunStatus())) {
				boolean flag = startPubFile(dFile);
				if (!flag) {
					return ResultVo.fail("任务启动失败！");
				}
				return ResultVo.ok("任务已启动！");
			}
		}
		return ResultVo.fail(MESSAGE_TASK_NOT_EXIST);
	}

	private boolean startPubFile(DbPubFile dFile) {
		dFile.setRunStatus("RUN");
		ResultVo res = fileKitTemplate.fileServiceRPC("/filePub/startDbPubFile", dFile);
		if (null==res||res.getStatus() != 200) {
			return false;
		}
		Map<String, Object> data = (Map<String, Object>) res.getData();
		dFile.setRunStatus(data.get("runStatus") + "");
		dbPubFileMapper.updateByPrimaryKeySelective(dFile);
		JSONObject obj = JSONObject.fromObject(dFile);
		obj.put(LOG_DESCRIBE, "任务已启动！");
		sysApi.addLog("upd", "启动信息", PUB_FILE_TABLE_NAME, dFile.getPubId(), obj.toString());//添加日志
		if ("true".equals(dFile.getAutoChange())) {//直接交换
			dbSubFileService.autoChangeOfSubFile(dFile);
		}
		return true;
	}

	private void stopPubFile(DbPubFile dFile) {
		dFile.setRunStatus("STOP");
		ResultVo res = fileKitTemplate.fileService("/filePub/startDbPubFile", dFile);
		dbPubFileMapper.updateByPrimaryKeySelective(dFile);
		JSONObject obj = JSONObject.fromObject(dFile);
		obj.put(LOG_DESCRIBE, "任务已关闭！");
		sysApi.addLog("upd", "启动信息", PUB_FILE_TABLE_NAME, dFile.getPubId(), obj.toString());//添加日志
	}

	/**
	 * 发布文件
	 */
	@Override
	public ResultVo pubDbPubFile(String fid, String status) {
		DbPubFile dFile = dbPubFile(fid);
		if (dFile != null) {
			if ("YPUB".equals(dFile.getStatus())) {
				return ResultVo.fail("请勿重复发布！");
			}
			if ("DEL".equals(dFile.getDelStatus())) {
				return ResultVo.fail("已经删除，不能发布");
			}
			if ("NPUB".equals(dFile.getStatus())) {
				String orgId = CommonUtil.getOrgId();
				String userId = CommonUtil.getUserId();
				dFile.setPubUserId(userId);
				dFile.setPubOrgId(orgId);
			}
			dFile.setStatus(status);
			//添加日志
			JSONObject obj = JSONObject.fromObject(dFile);
			String msg = "";
			switch (status) {
				case "APPROVING":
					obj.put(LOG_DESCRIBE, "文件已发布，待审批！");
					msg = "发布申请成功";
					break;
				case "REJECTED":
					obj.put(LOG_DESCRIBE, "文件发布审批不通过");
					break;
				case "YPUB":
					ResultVo res = fileKitTemplate.fileService("/filePub/addDbPubFile", dFile);
					if (null!=res&&res.getStatus() == 200) {
						obj.put(LOG_DESCRIBE, "文件已发布");
						msg = "发布成功";
					} else {
						return ResultVo.fail("发布失败");
					}
					break;
				default:
					break;
			}
			dbPubFileMapper.updateByPrimaryKeySelective(dFile);
			sysApi.addLog("upd", "发布信息", PUB_FILE_TABLE_NAME, dFile.getPubId(), obj.toString());//添加日志
			return ResultVo.ok(msg);
		}
		return ResultVo.fail(MESSAGE_TASK_NOT_EXIST);
	}

	@Override
	public ResultVo pubFileOfBatch(String[] ids) {
		int successNum = 0;
		int failNum = 0;
		String failMsg = "";
		for(String id : ids) {
			try {
				ResultVo vo = this.pubFile(id);
				if (vo.getStatus()==200) {
					successNum += 1;
				}else {
					failNum += 1;
					failMsg += vo.getMsg() + ";";
				}
			} catch (Exception e) {
				failNum += 1;
				failMsg += e.getMessage() + ";";
			}
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("successNum", successNum);
		resMap.put("failNum", failNum);
		resMap.put("failMsg", failMsg);
		return ResultVo.ok(resMap);
	}
	
	@Override
	public ResultVo pubFile(String fid) {
		DbPubFile dFile = dbPubFile(fid);
		if (dFile != null) {
			if ("DEL".equals(dFile.getDelStatus())) {
				return ResultVo.fail("已经删除，不能发布");
			}
			if ("YPUB".equals(dFile.getStatus())) {
				return ResultVo.ok("已发布");
			}
			if ("NPUB".equals(dFile.getStatus())) {
				String orgId = CommonUtil.getOrgId();
				String userId = CommonUtil.getUserId();
				dFile.setPubUserId(userId);
				dFile.setPubOrgId(orgId);
			}
			dFile.setStatus("YPUB");
			ResultVo res = fileKitTemplate.fileService("/filePub/addDbPubFile", dFile);
			if (null==res||res.getStatus() != 200) {
				return ResultVo.fail("发布失败");
			}
			dbPubFileMapper.updateByPrimaryKeySelective(dFile);
			//添加日志
			JSONObject obj = JSONObject.fromObject(dFile);
			obj.put(LOG_DESCRIBE, "文件已审批！");
			sysApi.addLog("upd", "发布信息", PUB_FILE_TABLE_NAME, dFile.getPubId(), obj.toString());//添加日志

			return ResultVo.ok("发布成功");
		}
		return ResultVo.fail(MESSAGE_TASK_NOT_EXIST);
	}

	/**
	 * 清楚缓存文件
	 */
	@Override
	public ResultVo cleanFileCache(String fid) {
		DbPubFile dFile = dbPubFile(fid);
		if (dFile != null) {
			if ("BACKUP".equals(dFile.getExtractType())) {
				if (dFile.getBackupPath() != null) {
					return fileKitTemplate.fileService("/filePub/cleanFileCache", fid);
				}
				return ResultVo.fail("缺少备份路径！");
			}
			return ResultVo.fail("该任务没有备份缓存！");
		}
		return ResultVo.fail(MESSAGE_TASK_NOT_EXIST);
	}

	/**
	 * 单查文件发布
	 */
	@Override
	public ResultVo getDbPubFile(String fid) {
		if (StringUtil.isNotEmpty(fid)) {
			DbPubFileDto filesDto = CommonUtil.po2VO(dbPubFile(fid), DbPubFileDto.class);
			if (filesDto != null) {
				List<DbExtTemplateDto> template = getExtTemplate(fid, filesDto.getUseType());
				filesDto.setTemplate(template);
				return ResultVo.ok(filesDto);
			}
			return ResultVo.fail("该文件发布不存在！");
		}
		return ResultVo.fail("查询错误！");
	}

	/**
	 * 根据ID查询文件发布任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	@Override
	public TaskInfo getTaskInfoById(String id) {
		DbPubFile pubFile = dbPubFile(id);
		if (pubFile == null) {
			pubFile = new DbPubFile();
		}

		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskName(Optional.ofNullable(pubFile.getPubName()).orElse(""));
		taskInfo.setTaskDesc(Optional.ofNullable(pubFile.getPubDesc()).orElse(""));

		return taskInfo;
	}

	/**
	 * 全查文件发布   未发布
	 */
	@Override
	public ResultVo getDbPubFilelistO(String autoChange, String pubName, String pubPath, Integer pageIndex, Integer pageSize) {
		if (StringUtil.isEmpty(autoChange)) {
			autoChange = "false";
		}
		DbPubFileExample example = new DbPubFileExample();
		example.setOrderByClause("crt_tm desc");
		DbPubFileExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		criteria.andStatusNotEqualTo("YPUB");
		criteria.andAutoChangeEqualTo(autoChange);//非直接交换
		String orgId = CommonUtil.getOrgId();
		String userId = CommonUtil.getUserId();
		criteria.andCrtOrgIdEqualTo(orgId);
		criteria.andCrtUserIdEqualTo(userId);
		if (StringUtil.isNotEmpty(pubName)) {
			criteria.andPubNameLike("%" + pubName.trim() + "%");
		}
		if (StringUtil.isNotEmpty(pubPath)) {
			criteria.andPubPathLike("%" + pubPath.trim() + "%");
		}
		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		PageInfo<DbPubFile> dbPubFilePageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbPubFileMapper.selectByExample(example));
		List<DbPubFile> list = dbPubFilePageInfo.getList();
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.ok(dbPubFilePageInfo);
		}
		List<DbPubFileDto> listdb = CommonUtil.listPo2VO(list, DbPubFileDto.class);
		List<DbParams> senGrade = dbParamsService.getTypeOrMode("sen_grade");
		for (DbPubFileDto fileDto : listdb) {
			if (StringUtil.isNotEmpty(fileDto.getSenLevel())) {
				fileDto.setSenLevel(addParams(fileDto.getSenLevel(), senGrade));
			}
			fileDto.setFileType(dbParamsService.getParamsValueByTypeAndKey("data_cate", fileDto.getFileType()));
		}
		PageInfo<DbPubFileDto> data = CommonUtil.po2VO(dbPubFilePageInfo, PageInfo.class);
		data.setList(listdb);
		return ResultVo.ok(data);
	}

	/**
	 * 全查文件发布   已发布
	 */
	@Override
	public ResultVo getDbPubFilelistT(String orgId, String autoChange, String pubName, String pubPath, Integer pageIndex, Integer pageSize) {
		if (StringUtil.isEmpty(autoChange)) {
			autoChange = "false";
		}
		DbPubFileExample example = new DbPubFileExample();
		example.setOrderByClause("crt_tm desc");
		DbPubFileExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		criteria.andStatusEqualTo("YPUB");
		criteria.andAutoChangeEqualTo(autoChange);//非直接交换
		if (StringUtil.isEmpty(orgId)) {
			orgId = CommonUtil.getOrgId();
			String userId = CommonUtil.getUserId();
			criteria.andPubUserIdEqualTo(userId);
		}
		criteria.andPubOrgIdEqualTo(orgId);
		if (StringUtil.isNotEmpty(pubName)) {
			criteria.andPubNameLike("%" + pubName.trim() + "%");
		}
		if (StringUtil.isNotEmpty(pubPath)) {
			criteria.andPubPathLike("%" + pubPath.trim() + "%");
		}

		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		PageInfo dbPubFilePageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbPubFileMapper.selectByExample(example));
		List<DbPubFile> list = dbPubFilePageInfo.getList();
		if (CommonUtil.isNotEmpty(list)) {
			List<DbPubFileDto> listdb = setDbPubFileDto(list);
			dbPubFilePageInfo.setList(listdb);
		}
		return ResultVo.ok(dbPubFilePageInfo);
	}

	private List<DbPubFileDto> setDbPubFileDto(List<DbPubFile> list) {
		List<DbPubFileDto> listdb = CommonUtil.listPo2VO(list, DbPubFileDto.class);
		List<DbParams> senGrade = dbParamsService.getTypeOrMode("sen_grade");
		for (DbPubFileDto fileDto : listdb) {
			if (StringUtil.isNotEmpty(fileDto.getSenLevel())) {
				fileDto.setSenLevel(addParams(fileDto.getSenLevel(), senGrade));
			}
			String crtUserIduId = fileDto.getCrtUserId();
			if (StringUtil.isNotEmpty(crtUserIduId)) {
				SysUser userById = userService.getUserById(crtUserIduId);
				if (userById != null) {
					fileDto.setCrtName(userById.getUsername());
				}
			}
			String pubUserId = fileDto.getPubUserId();
			if (StringUtil.isNotEmpty(pubUserId)) {
				SysUser userById = userService.getUserById(pubUserId);
				if (userById != null) {
					fileDto.setPubUserName(userById.getUsername());
				}
			}

			// 是否可以撤回
			fileDto.setCanBeWithdrawn(StringUtil.isEmpty(fileDto.getUseScope()) ? "NO" : "YES");
		}
		return listdb;
	}

	/**
	 * 转换加密等级
	 */
	@Override
	public String addParams(String dto, List<DbParams> senGrade) {
		for (DbParams dbParams : senGrade) {
			if (dto.equals(dbParams.getParamsKey())) {
				dto = dbParams.getParamsValue();
			}
		}
		return dto;
	}

	/**
	 * 查询发布目录是否重复
	 */
	private Boolean origPathCheck(String opath) {
		DbPubFileExample example = new DbPubFileExample();
		DbPubFileExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		criteria.andOrigPathEqualTo(opath);
		String orgId = CommonUtil.getOrgId();
		criteria.andCrtOrgIdEqualTo(orgId);
		List<DbPubFile> list = dbPubFileMapper.selectByExample(example);
		return CommonUtil.isEmpty(list);
	}

	/**
	 * 查询文件发布
	 */
	@Override
	public DbPubFile dbPubFile(String fid) {
		if (StringUtil.isEmpty(fid)) {
			return null;
		}
		return dbPubFileMapper.selectByPrimaryKey(fid);
	}

	/**
	 * 获取自定义策略扩展字段
	 *
	 * @param fid
	 * @return
	 */
	private List<DbExtTemplateDto> getExtTemplate(String fid, String useType) {
		DbPubTableExtExample example = new DbPubTableExtExample();
		DbPubTableExtExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(fid);
		List<DbPubTableExt> pubExt = dbPubTableExtMapper.selectByExample(example);
		List<DbExtTemplateDto> template = new ArrayList<>();
		if (null == pubExt || pubExt.isEmpty()) {
			return template;
		}

		DbPolicyTemplateExample policyExample = new DbPolicyTemplateExample();
		DbPolicyTemplateExample.Criteria policyCriteria = policyExample.createCriteria();
		policyCriteria.andPolicyItemIdEqualTo(useType);
		List<DbPolicyTemplate> policyTemplates = dbPolicyTemplateMapper.selectByExample(policyExample);
		Map<String, String> policyTemplateMap = new HashMap<>();
		if (null != policyTemplates) {
			policyTemplates.forEach(p -> policyTemplateMap.put(p.getExtTemplateId(), p.getRequired()));
		}

		DbExtTemplateExample templateExample = new DbExtTemplateExample();
		List<DbExtTemplate> templateList = dbExtTemplateMapper.selectByExample(templateExample);
		Map<String, String> templateMap1 = new HashMap<>();
		Map<String, String> templateMap2 = new HashMap<>();
		if (null != templateList) {
			templateList.forEach(t -> {
				templateMap1.put(t.getExtPolicyEname(), t.getEnumKey());
				templateMap2.put(t.getExtPolicyEname(), policyTemplateMap.get(t.getId()));
			});
		}

		pubExt.forEach(ext -> {
			DbExtTemplateDto dto = new DbExtTemplateDto();
			dto.setExtPolicyCname(ext.getExtAttrCname());
			dto.setExtPolicyEname(ext.getExtAttrEname());
			dto.setTemplateType(ext.getTemplateType());
			dto.setDataType(ext.getDataType());
			dto.setExtValue(ext.getExtValue());
			dto.setEnumKey(templateMap1.get(ext.getExtAttrEname()));
			dto.setRequired(templateMap2.get(ext.getExtAttrEname()));
			template.add(dto);
		});
		return template;
	}

	/**
	 * 撤回发布
	 *
	 * @param vo 撤回数据
	 * @return 撤回结果
	 */
	@Override
	public ResultVo withdrawPub(WithdrawPubVo vo) {
		String pubId = vo.getPubId();
		DbPubFile pubFile = dbPubFile(pubId);

		String authType = pubFile.getUseScope().split("/")[0];
		String authScope = pubFile.getUseScope().split("/")[1];
		String newAuthScope = removeOrgList(authScope, vo.getAuthScopes());

		DbPubFile t = new DbPubFile();
		t.setPubId(pubId);
		t.setUseScope(authType + "/" + newAuthScope);
		dbPubFileMapper.updateByPrimaryKeySelective(t);

		// 删除子节点数据
		fileKitTemplate.withdrawPub(vo);

		// 删除订阅方中心数据
		vo.getAuthScopes().forEach(scope -> dbSubFileService.deleteSubByPubIdAndSubOrgId(vo.getPubId(), scope));

		// 删除订阅放节点数据
		vo.getAuthScopes().forEach(scope -> fileKitTemplate.deleteSubByPubIdAndSubOrgId(vo.getPubId(), scope));

		return ResultVo.ok();
	}

	/**
	 * 获取可撤回机构列表
	 *
	 * @param pubId 发布ID
	 * @return 机构列表
	 */
	@Override
	public ResultVo getWithdrawOrgList(String pubId) {
		DbPubFile dbPubFile = dbPubFileMapper.selectByPrimaryKey(pubId);
		String authScope = dbPubFile.getUseScope().split("/")[1];
		List<WithdrawOrgDto> list = Arrays.stream(authScope.split(",")).map(x -> {
			String orgName = dbOrgService.getOrgNameByOrgId(x);
			return new WithdrawOrgDto(x, orgName);
		}).collect(Collectors.toList());

		return ResultVo.ok(list);
	}

	@Override
	public ResultVo getDbPubFileDetails(String fid) {
		ResultVo resultVo = getDbPubFile(fid);
		DbPubFileDto data = (DbPubFileDto) resultVo.getData();
		if (resultVo.getStatus() == 200 && data != null) {
			data.setFileType(getParamValueByKey("data_cate", data.getFileType()));
			data.setExtractType(getParamValueByKey("ext_way", data.getExtractType()));
			String templateId = data.getTemplateId();
			DbPolicyItem dbPolicyItem = dbPolicyItemMapper.selectByPrimaryKey(templateId);
			data.setUseType(dbPolicyItem != null ? dbPolicyItem.getName() : "错误的策略模板id");
			data.setSenLevel(getParamValueByKey("sen_grade", data.getSenLevel()));
			String useScope = data.getUseScope();
			if (StringUtil.isNotEmpty(useScope)) {
				StringBuilder sb = new StringBuilder();
				if (useScope.startsWith("ORG/")) {
					useScope = useScope.replace("ORG/", "");
					String[] orgScopes = useScope.split(",");
					for (String scopeId : orgScopes) {
						sb.append(dbOrgService.getDbOrgByOrgId(scopeId).getOrgName()).append(",");
					}
					sb.insert(0, "ORG/");
				} else if (useScope.startsWith("REGION/")) {
					useScope = useScope.replace("REGION/", "");
					String[] reginScopes = useScope.split(",");
					for (String scopeId : reginScopes) {
						sb.append(dbAreaService.getDbAreaById(scopeId).getAreaName()).append(",");
					}
					sb.insert(0, "REGION/");
				}
				data.setUseScope(sb.substring(0, sb.lastIndexOf(",")));
			}
		}
		return resultVo;
	}

	private String getParamValueByKey(String paramType, String paramKey) {
		return dbParamsService.getParamsValueByTypeAndKey(paramType, paramKey);
	}

	
}

