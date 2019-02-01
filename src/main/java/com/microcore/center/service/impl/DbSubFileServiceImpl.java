package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.auth.security.SecurityUtils;
import com.microcore.center.client.FileKitTemplate;
import com.microcore.center.dto.DbFileKitDto;
import com.microcore.center.dto.DbPubFileDto;
import com.microcore.center.dto.DbSubFileDto;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.mapper.DbOrgAreaRelMapper;
import com.microcore.center.mapper.DbPubFileMapper;
import com.microcore.center.mapper.DbSubFileMapper;
import com.microcore.center.model.DbApproval;
import com.microcore.center.model.DbArea;
import com.microcore.center.model.DbOrgAreaRel;
import com.microcore.center.model.DbOrgAreaRelExample;
import com.microcore.center.model.DbParams;
import com.microcore.center.model.DbPubFile;
import com.microcore.center.model.DbPubFileExample;
import com.microcore.center.model.DbSubFile;
import com.microcore.center.model.DbSubFileExample;
import com.microcore.center.model.SysUser;
import com.microcore.center.service.BlockChService;
import com.microcore.center.service.DbApprovalService;
import com.microcore.center.service.DbFileKitService;
import com.microcore.center.service.DbOrgAreaService;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.service.DbParamsService;
import com.microcore.center.service.DbPubFileService;
import com.microcore.center.service.DbSubFileService;
import com.microcore.center.util.CenterUtil;
import com.microcore.center.util.CheckingUtil;
import com.microcore.common.constant.Constants;
import com.microcore.common.rabbit.MqExchangeVo;
import com.microcore.common.rabbit.RPCRabbitClient;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.SendUtil;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 */
@Service
@Transactional
@Configuration
@Slf4j
public class DbSubFileServiceImpl implements DbSubFileService {

	@Autowired
	private DbSubFileMapper dbSubFileMapper;
	@Autowired
	private DbPubFileMapper dbPubFileMapper;
	@Autowired
	private DbPubFileService dbPubFileService;
	@Autowired
	private DbParamsService dbParamsService;
	@Autowired
	private FileKitTemplate fileKitTemplate;
	@Autowired
	private DbFileKitService dbFileKitService;
	@Autowired
	private DbOrgService dbOrgService;
	@Autowired
	private UserService userService;
	@Autowired
	private DbOrgAreaService dbOrgAreaService;
	@Autowired
	private RPCRabbitClient rabbitClient;
	@Autowired
	private DbApprovalService dbApprovalService;
	@Autowired
	private DbOrgAreaRelMapper dbOrgAreaRelMapper;
	@Autowired
	private BlockChService blockChService;
	@Autowired
	private ExchangeService exchangeService;
	/**
	 * 新增
	 */
	@Override
	public ResultVo addDbSubFile(DbSubFileDto dbSubFileDto) {
		String id = CommonUtil.getUUID();
		return basicAddDbSubFile(id, dbSubFileDto, Constants.RUN_STATUS_STOP);
	}

	public ResultVo basicAddDbSubFile(String id, DbSubFileDto dbSubFileDto, String runStatus) {
		String orgId = UserUtil.getOrgId();
		String userId = UserUtil.getUserId();
		return basicAddDbSubFile(id, dbSubFileDto, orgId, userId, "YPUB", runStatus);
	}
	
	public ResultVo basicAddDbSubFile(String id, DbSubFileDto dbSubFileDto, String subOrgId, String subUserId, String status, String runStatus) {
		String localPath = dbSubFileDto.getLocPath();
		if (StringUtil.isNotEmpty(localPath) && CheckingUtil.checkingPath(localPath)) {
			DbSubFile dbSubFile = new DbSubFile();
			dbSubFile.setSubId(id);
			dbSubFile.setPubId(dbSubFileDto.getPubId());
			dbSubFile.setSubName(dbSubFileDto.getSubName());
			dbSubFile.setSubDesc(dbSubFileDto.getSubDesc());
			dbSubFile.setLocPath(dbSubFileDto.getLocPath());
			dbSubFile.setFileType(dbSubFileDto.getFileType());
			dbSubFile.setExtractType(dbSubFileDto.getExtractType());
			String backPath = dbSubFileDto.getBackupPath();
			if (StringUtil.isNotEmpty(backPath) && !CheckingUtil.checkingPath(backPath)) {
				return ResultVo.fail("备份目录不规范！");
			}
			dbSubFile.setBackupPath(backPath);
			String distillDir = dbFileKitService.getPathDir(subOrgId, "distillDir");
			if (StringUtil.isEmpty(distillDir)) {
				return ResultVo.fail("套件信息错误，获取脱标目录失败！");
			}
			dbSubFile.setSubPath(distillDir+"/"+dbSubFileDto.getPubId());
			dbSubFile.setStatus(status);
			dbSubFile.setDelStatus("NOR");
			dbSubFile.setRunStatus(runStatus);
			dbSubFile.setCrtUserId(subUserId);
			dbSubFile.setCrtOrgId(subOrgId);
			dbSubFile.setCrtTm(CommonUtil.getCurrentTime());
			//创建交换信息
			try {
				createExchangeInfo(dbSubFile, subOrgId);
			} catch (Exception e) {
				log.error("交换信息创建失败", e);
			}
			try {
				fileKitTemplate.fileService("/fileSub/addDbSubFile", dbSubFile);
			} catch (Exception e) {
				log.error("任务添加失败", e);
				return ResultVo.fail("任务添加失败");
			}
			dbSubFileMapper.insert(dbSubFile);
			blockChService.dataRequest(dbSubFileDto.getPubId());
			blockChService.dataEvaluation(dbSubFileDto.getPubId());
			
			return ResultVo.ok("新增发布成功！");
		}
		return ResultVo.fail("订阅目录不规范！");
	}

	@Override
	public ResultVo addDbSubFileWithApproval(DbSubFileDto filesDto) {
		DbPubFile pubFile = dbPubFileService.dbPubFile(filesDto.getPubId());

		String id = CommonUtil.getUUID();
		ResultVo resultVo = basicAddDbSubFile(id, filesDto, Constants.PUB_STATUS_APPROVING);
		if (!Constants.STATUS_OK.equals(resultVo.getStatus())) {
			return resultVo;
		}

		DbApproval dbApproval = CenterUtil.buildApproval(Constants.DATA_TYPE_FILE, id,
				pubFile.getPubUserId(), pubFile.getPubDesc());
		dbApprovalService.submitSubApproval(dbApproval);

		return ResultVo.ok();
	}

	/**
	 * 检查重复
	 */
	public String checkedSub(String sid) {
		DbSubFile dbSubFile = dbSubFile(sid);
		if (dbSubFile != null) {
			sid = CommonUtil.getUUID();
			return checkedSub(sid);
		}
		return sid;
	}

	/**
	 * 修改
	 */
	@Override
	public ResultVo updDbSubFile(DbSubFileDto dbSubFileDto) {
		DbSubFile dbSubFile = dbSubFile(dbSubFileDto.getSubId());
		if (dbSubFile != null) {
			if ("NPUB".equals(dbSubFile.getStatus())) {
				//前台获值
				dbSubFile.setSubName(dbSubFileDto.getSubName());
				dbSubFile.setSubDesc(dbSubFileDto.getSubDesc());
				dbSubFile.setLocPath(dbSubFileDto.getLocPath());
				dbSubFile.setExtractType(dbSubFileDto.getExtractType());
				dbSubFile.setBackupPath(dbSubFileDto.getBackupPath());
				//后台赋值
				dbSubFile.setUpdUserId(UserUtil.getUserId());
				dbSubFile.setUpdTm(CommonUtil.getCurrentTime());
				dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
				return ResultVo.ok("修改成功！");
			}
			return ResultVo.fail("该任务已经发布，不能修改！");
		}
		return ResultVo.fail("没有该订阅任务！");
	}

	/**
	 * 删除
	 */
	@Override
	public ResultVo delDbSubFile(String sid) {
		DbSubFile dbSubFile = dbSubFile(sid);
		if (dbSubFile != null) {
			if ("STOP".equals(dbSubFile.getRunStatus())) {
				//后台赋值
				dbSubFile.setDelStatus("DEL");
				dbSubFile.setUpdUserId(UserUtil.getUserId());
				dbSubFile.setUpdTm(CommonUtil.getCurrentTime());
				dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
				fileKitTemplate.fileService("/fileSub/delDbSubFile", dbSubFile);
				return ResultVo.ok("删除成功！");
			}
			return ResultVo.fail("该任务已经启动，不能删除！");
		}
		return ResultVo.fail("没有该订阅任务！");
	}

	/**
	 * 单查
	 */
	@Override
	public ResultVo getDbSubFile(String sid) {
		DbSubFile dbSubFile = dbSubFile(sid);
		if (dbSubFile != null) {
			DbSubFileDto dbSubFileDto = CommonUtil.po2VO(dbSubFile, DbSubFileDto.class);
			String extractType = dbSubFileDto.getExtractType();
			String extractTypeName = dbParamsService.getParamsValueByTypeAndKey("ext_way", extractType);
			dbSubFileDto.setExtractTypeName(extractTypeName);
			return ResultVo.ok(dbSubFileDto);
		}
		return ResultVo.fail("没有该订阅任务！");
	}

	/**
	 * 查询已经订阅列表
	 * @param orgName
	 * @param subName
	 * @param pubUser
	 * @param pageIndex
	 * @param pageSize
	 */
	@Override
	public ResultVo getDbSubFileListA(String orgName, String subName, String pubUser, Integer pageIndex, Integer pageSize) {
		DbSubFileExample example = new DbSubFileExample();
		example.setOrderByClause("crt_tm desc");
		DbSubFileExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		String orgId = SecurityUtils.getCurrentUserLogin().get().getOrgId();
		String userId = SecurityUtils.getCurrentUserLogin().get().getId();
		criteria.andCrtOrgIdEqualTo(orgId);
		criteria.andCrtUserIdEqualTo(userId);
		if (StringUtil.isNotEmpty(orgName)) {
			List<String> list = dbOrgService.getOrgIdListByOrgName(orgName);
			criteria.andPubOrgIdIn(list);
		}
		if (StringUtil.isNotEmpty(subName)) {
			criteria.andSubNameLike("%" + subName.trim() + "%");
		}
		if (StringUtil.isNotEmpty(pubUser)) {
			List<String> list = userService.getUserListLikeName(pubUser);
			criteria.andPubUserIdIn(list);
		}
		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
//		criteria.andCrtUserIdIn(Arrays.asList(userId,"sys"));
		PageInfo pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> dbSubFileMapper.selectByExample(example));
		List<DbSubFile> list = pageInfo.getList();
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.ok(pageInfo);
		}
		List<DbSubFileDto> listdo = CommonUtil.listPo2VO(list, DbSubFileDto.class);
		for (DbSubFileDto dbSubFileDto : listdo) {
			DbPubFile dbPubFile = dbPubFileMapper.selectByPrimaryKey(dbSubFileDto.getPubId());
			String pubUserId = dbPubFile.getPubUserId();
			if (StringUtil.isNotEmpty(pubUserId)) {
				SysUser userById = userService.getUserById(pubUserId);
				if (userById != null) {
					dbSubFileDto.setPubUser(userById.getUsername());
				}
			}
			dbSubFileDto.setPubName(dbPubFile.getPubName());
			dbSubFileDto.setPubPath(dbPubFile.getPubPath());
			String name = dbOrgService.getOrgNameByOrgId(dbPubFile.getPubOrgId());
			dbSubFileDto.setOrgName(name);
		}
		pageInfo.setList(listdo);
		return ResultVo.ok(pageInfo);
	}

	/**
	 * 查询可以订阅列表
	 */
	@Override
	public ResultVo getDbSubFileListC(String orgId, String orgName, String pubName, String pubUserName, Integer pageIndex, Integer pageSize) {
		DbSubFileExample exampleSub = new DbSubFileExample();
		exampleSub.setOrderByClause("crt_tm desc");
		DbSubFileExample.Criteria criteriaSub = exampleSub.createCriteria();
		criteriaSub.andDelStatusEqualTo("NOR");
		String myOrgId = SecurityUtils.getCurrentUserLogin().get().getOrgId();
		String userId = SecurityUtils.getCurrentUserLogin().get().getId();
		criteriaSub.andCrtOrgIdEqualTo(myOrgId);
		criteriaSub.andCrtUserIdEqualTo(userId);
		if (StringUtil.isNotEmpty(orgId)) {
			criteriaSub.andPubOrgIdEqualTo(orgId);
		}
		List<DbSubFile> dbSubFiles = dbSubFileMapper.selectByExample(exampleSub);
		Boolean blag = CommonUtil.isEmpty(dbSubFiles);
		List<String> pubIds = new ArrayList<>();
		if (!blag) {
			for (DbSubFile dbSubFile : dbSubFiles) {
				pubIds.add(dbSubFile.getPubId());
			}
		}
		DbPubFileExample example = new DbPubFileExample();
		DbPubFileExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		criteria.andStatusNotEqualTo("NPUB");
		criteria.andAutoChangeEqualTo("false");//非直接交换
		if (!StringUtil.isEmpty(orgId)) {
			criteria.andPubOrgIdEqualTo(orgId);
		}
		if (!blag) {
			criteria.andPubIdNotIn(pubIds);
		}
		if (StringUtil.isNotEmpty(orgName)) {
			List<String> list = dbOrgService.getOrgIdListByOrgName(orgName);
			criteria.andPubOrgIdIn(list);
		}
		if (StringUtil.isNotEmpty(pubName)) {
			criteria.andPubNameLike("%" + pubName.trim() + "%");
		}
		if (StringUtil.isNotEmpty(pubUserName)) {
			List<String> list = userService.getUserListLikeName(pubUserName);
			criteria.andPubUserIdIn(list);
		}
		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		PageInfo pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> dbPubFileMapper.selectByExample(example));
		List<DbPubFile> list = pageInfo.getList();
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.ok(pageInfo);
		}
		List<DbPubFileDto> dbPubFileDtos = CommonUtil.listPo2VO(list, DbPubFileDto.class);
		setExtDbSubFile(dbPubFileDtos, myOrgId);
		pageInfo.setList(dbPubFileDtos);
		return ResultVo.ok(pageInfo);
	}

	private List<DbPubFileDto> setExtDbSubFile(List<DbPubFileDto> dbPubFileDtos, String myOrgId) {
		List<DbParams> senGrade = dbParamsService.getTypeOrMode("sen_grade");
		List<DbPubFileDto> list = new ArrayList<>();
		for (DbPubFileDto fileDto : dbPubFileDtos) {
			String useType = fileDto.getUseType();
			String useScope = fileDto.getUseScope();
			if (("ORG".equals(useType) && !useScope.contains(myOrgId)) || ("REGION".equals(useType) && !hasAreas(useScope, myOrgId))) {
				continue;//机构或域不在授权范围内
			}
			String orgName = dbOrgService.getOrgNameByOrgId(fileDto.getCrtOrgId());
			fileDto.setOrgName(orgName);
			String uId = fileDto.getPubUserId();
			if (StringUtil.isNotEmpty(uId)) {
				SysUser userById = userService.getUserById(uId);
				if (userById != null) {
					fileDto.setPubUserName(userById.getUsername());
				}
			}
			fileDto.setSenLevel(dbPubFileService.addParams(fileDto.getSenLevel(), senGrade));
			list.add(fileDto);
		}
		return list;
	}

	/**
	 * 判断机构的域是否在授权范围内
	 *
	 * @param useScope
	 * @param orgId
	 * @return
	 */
	private boolean hasAreas(String useScope, String orgId) {
		List<DbArea> areas = dbOrgAreaService.getDbAreaByOrgId(orgId);
		if (null == areas || areas.isEmpty()) {
			return false;
		}
		for (DbArea area : areas) {
			String areaId = area.getId();
			if (useScope.contains(areaId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @data: 2018/8/10 14:38
	 * @des: 发布订阅
	 */
	@Override
	public ResultVo pubDbSubFile(String sid) {
		DbSubFile dbSubFile = dbSubFile(sid);
		if (dbSubFile != null) {
			if ("NPUB".equals(dbSubFile.getStatus())) {
				String myOrgId = UserUtil.getOrgId();
				try {
					//创建交换信息
					createExchangeInfo(dbSubFile, myOrgId);
					dbSubFile.setStatus("YPUB");
					fileKitTemplate.fileService("/fileSub/addDbSubFile", dbSubFile);
				} catch (Exception e) {
					log.error("任务发布失败", e);
					return ResultVo.fail("任务发布失败：" + e.getMessage());
				}
				dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
				return ResultVo.ok("发布成功！");
			}
			return ResultVo.fail("请勿重复发布！");
		}
		return ResultVo.fail("没有该订阅！");
	}

	/**
	 * 创建交换信息
	 *
	 * @param dbSubFile
	 * @param myOrgId
	 * @return
	 * @throws Exception
	 */
	private void createExchangeInfo(DbSubFile dbSubFile, String myOrgId) {
		String pubId = dbSubFile.getPubId();
		DbPubFile pubFile = dbPubFileMapper.selectByPrimaryKey(pubId);
		String pubOrgId = pubFile.getPubOrgId();
		ResultVo pubKitInfoVo = dbFileKitService.getDbFileKitByOrgId(pubOrgId);
		DbFileKitDto pubKitInfo = (DbFileKitDto) pubKitInfoVo.getData();
		String pubExchangeId = pubKitInfo.getExchangeId();
		ResultVo myKitInfoVo = dbFileKitService.getDbFileKitByOrgId(myOrgId);
		DbFileKitDto myKitInfo = (DbFileKitDto) myKitInfoVo.getData();
		String myExchangeId = myKitInfo.getExchangeId();
		exchangeService.createExchangeInfo(dbSubFile.getSubId(), pubId, pubExchangeId, myExchangeId);
		dbSubFile.setPubUserId(pubFile.getPubUserId());
		dbSubFile.setPubOrgId(pubOrgId);
		dbSubFile.setSubUserId(UserUtil.getUserId());
		dbSubFile.setSubOrgId(myOrgId);
	}


	@Override
	public ResultVo stopSubFile(String sid, String status) {
		DbSubFile dbSubFile = dbSubFile(sid);
		dbSubFile.setRunStatus("STOP");
		dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
		fileKitTemplate.fileService("/fileSub/startSubFile", dbSubFile);
		return ResultVo.ok("已经停止！");
	}

	@Override
	public void setSubFile(String sid, String status) {
		DbSubFile dbSubFile = dbSubFile(sid);
		dbSubFile.setRunStatus(status);
		dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
	}

	/**
	 * 启动/停止订阅任务
	 */
	@Override
	public ResultVo startSubFile(String sid) {
		DbSubFile dbSubFile = dbSubFile(sid);
		if (dbSubFile == null) {
			return ResultVo.fail("没有该订阅任务！");
		}
		if ("RUN".equals(dbSubFile.getRunStatus())) {
			//停止交换
			return stopExchangeAndSubFile(dbSubFile);
		} else {
			//启动交换
			return startExchangeAndSubFile(dbSubFile);
		}
	}

	private ResultVo stopExchangeAndSubFile(DbSubFile dbSubFile) {
		exchangeService.stopExchange(dbSubFile);
		dbSubFile.setRunStatus("STOP");
		dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
		fileKitTemplate.fileService("/fileSub/startSubFile", dbSubFile);
		return ResultVo.ok("已经停止！");
	}

	private ResultVo startExchangeAndSubFile(DbSubFile dbSubFile) {
		exchangeService.runExchange(dbSubFile);
		dbSubFile.setRunStatus("RUN");
		dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
		fileKitTemplate.fileService("/fileSub/startSubFile", dbSubFile);
		return ResultVo.ok("已经启动！");
	}

	public DbSubFile dbSubFile(String sid) {
		return dbSubFileMapper.selectByPrimaryKey(sid);
	}

	/**
	 * 根据ID查询文件订阅任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	@Override
	public TaskInfo getTaskInfoById(String id) {
		DbSubFile subTable = dbSubFile(id);
		if (subTable == null) {
			subTable = new DbSubFile();
		}

		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskName(Optional.ofNullable(subTable.getSubName()).orElse(""));
		taskInfo.setTaskDesc(Optional.ofNullable(subTable.getSubDesc()).orElse(""));
		return taskInfo;
	}

	@Override
	public void deleteSubByPubIdAndSubOrgId(String pubId, String subOrgId) {
		DbSubFileExample example = new DbSubFileExample();
		DbSubFileExample.Criteria criteria = example.createCriteria();
		criteria.andPubIdEqualTo(pubId);
		criteria.andSubOrgIdEqualTo(subOrgId);
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		List<DbSubFile> dbSubTables = dbSubFileMapper.selectByExample(example);
		dbSubTables.forEach(table -> dbSubFileMapper.deleteByPrimaryKey(table.getSubId()));
	}

	@Override
	@Async
	public void autoChangeOfSubFile(DbPubFile dFile) {
		String useScope = dFile.getUseScope();
		if (StringUtil.isEmpty(useScope)) {
			return;
		}
		String[] arr = useScope.split("/");
		String type = "";
		String scope = "";
		try {
			type = arr[0];
			scope = arr[1];
		} catch (Exception e) {
			log.error("授权范围错误", e);
		}
		if (StringUtil.isEmpty(type)||StringUtil.isEmpty(scope)) {
			return;
		}
		String[] scopeArr = scope.split(",");
		switch (type) {
		case "ORG":
			autoSubByOrg(dFile,scopeArr);
			break;
		case "REGION":
			autoSubByRegion(dFile,scopeArr);
			break;
		default:
			log.info("授权范围类型错误");
			break;
		}
	}

	private void autoSubByRegion(DbPubFile dFile, String[] scopeArr) {
		List<String> orgList = new ArrayList<String>();
		for(int i=0;i<scopeArr.length;i++) {
			String areaId = scopeArr[i];
			DbOrgAreaRelExample example = new DbOrgAreaRelExample();
			DbOrgAreaRelExample.Criteria criteria = example.createCriteria();
			criteria.andAreaIdEqualTo(areaId);
			List<DbOrgAreaRel> res = dbOrgAreaRelMapper.selectByExample(example);
			if (null==res||res.size()<1) {
				continue;
			}
			res.forEach(a->{
				String orgId = a.getOrgId();
				orgList.add(orgId);
			});
		}
		String[] orgArr = new String[orgList.size()];
		String[] arr = orgList.toArray(orgArr);
		autoSubByOrg(dFile, arr);
	}

	private void autoSubByOrg(DbPubFile dFile, String[] scopeArr) {
		log.info("-----直接交换开始-----");
		DbSubFileDto dbSubFileDto = new DbSubFileDto();
		dbSubFileDto.setPubId(dFile.getPubId());
		dbSubFileDto.setSubName(dFile.getPubName());
		dbSubFileDto.setSubDesc(dFile.getPubDesc());
		dbSubFileDto.setFileType(dFile.getFileType());
		dbSubFileDto.setExtractType("DELETE");//抽取后删除
		for(int i=0;i<scopeArr.length;i++) {
			String id = CommonUtil.getUUID();
			String orgId = scopeArr[i];
			String notifyDir = dbFileKitService.getPathDir(orgId, "notifyDir");
			dbSubFileDto.setLocPath(notifyDir);//直接交换通知目录
			log.info("交换机构："+orgId+" 交换开始---");
			ResultVo res = basicAddDbSubFile(id, dbSubFileDto, orgId, "sys", "YPUB", "STOP");
			if (res.getStatus()!=200) {
				log.error("添加订阅失败-------"+orgId);
				continue;
			}
			DbSubFile dbSubFile = dbSubFile(id);
			//发布任务,创建交换信息
//			try {
//				fileKitTemplate.fileServiceByOrg("/fileSub/addDbSubFile", dbSubFile, orgId);
//				createExchangeInfo(dbSubFile, orgId);
//			} catch (Exception e) {
//				log.error("任务发布失败，交换信息创建失败"+orgId, e);
//				continue;
//			}
			//启动交换平台
			exchangeService.runExchange(dbSubFile);
			dbSubFile.setRunStatus("RUN");
			dbSubFileMapper.updateByPrimaryKeySelective(dbSubFile);
			fileKitTemplate.fileServiceByOrg("/fileSub/startSubFile", dbSubFile, orgId);
			log.info("交换机构："+orgId+" 交换结束---");
		}
		log.info("-----直接交换完成-----");
	}

	@Override
	public ResultVo startSubFileOfBatch(String[] ids) {
		int successNum = 0;
		int failNum = 0;
		String failMsg = "";
		for(String id : ids) {
			DbSubFile dbSubFile = dbSubFile(id);
			if (dbSubFile == null) {
				continue;
			}
			if ("RUN".equals(dbSubFile.getRunStatus())) {
				successNum += 1;
				continue;
			}
			try {
				ResultVo vo = startExchangeAndSubFile(dbSubFile);
				if (vo.getStatus()==200) {
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
	public ResultVo stopSubFileOfBatch(String[] ids) {
		int successNum = 0;
		int failNum = 0;
		String failMsg = "";
		for(String id : ids) {
			DbSubFile dbSubFile = dbSubFile(id);
			if (dbSubFile == null) {
				continue;
			}
			if ("STOP".equals(dbSubFile.getRunStatus())) {
				successNum += 1;
				continue;
			}
			try {
				ResultVo vo = stopExchangeAndSubFile(dbSubFile);
				if (vo.getStatus()==200) {
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
	public ResultVo delSubFileOfBatch(String[] ids) {
		int successNum = 0;
		int failNum = 0;
		String failMsg = "";
		for(String id : ids) {
			try {
				ResultVo vo = delDbSubFile(id);
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
	public ResultVo subFileOfBatch(String[] ids) {
		int successNum = 0;
		int failNum = 0;
		String failMsg = "";
		for(String id : ids) {
			try {
				ResultVo vo = this.pubDbSubFile(id);
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
	
	
	
}
