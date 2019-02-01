package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.client.exchange.ExchangeTemplate;
import com.microcore.center.client.exchange.ProxyExchangeInfo;
import com.microcore.center.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.api.model.DbOrg;
import com.microcore.api.model.DbServiceKit;
import com.microcore.api.vo.SecurityKeyVo;
import com.microcore.center.client.KeymanagerTemplate;
import com.microcore.center.client.ServiceKitTemplate;
import com.microcore.center.dto.DbPubServiceDto;
import com.microcore.center.dto.DbSubServiceDto;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.mapper.DbAreaMapper;
import com.microcore.center.mapper.DbOrgMapper;
import com.microcore.center.mapper.DbPubServiceMapper;
import com.microcore.center.mapper.DbServiceParamMapper;
import com.microcore.center.mapper.DbSubServiceMapper;
import com.microcore.center.mapper.SysUserMapper;
import com.microcore.center.model.DbArea;
import com.microcore.center.model.DbPubService;
import com.microcore.center.model.DbPubServiceExample;
import com.microcore.center.model.DbServiceParam;
import com.microcore.center.model.DbServiceParamExample;
import com.microcore.center.model.DbSubService;
import com.microcore.center.model.DbSubServiceExample;
import com.microcore.center.model.SysUser;
import com.microcore.center.service.DbOrgAreaService;
import com.microcore.center.service.DbServiceKitService;
import com.microcore.center.service.DbSubServiceService;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.JwtUtil;
import com.microcore.common.util.RSAUtils;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;

/**
 * 服务接口申请
 */
@Service
@Transactional
@Slf4j
public class DbSubServiceServiceImpl implements DbSubServiceService {

	/**
	 * 服务接口发布Mapper
	 */
	@Autowired
	private DbPubServiceMapper dbPubServiceMapper;

	/**
	 * 输入输出参数Mapper
	 */
	@Autowired
	private DbServiceParamMapper dbServiceParamMapper;

	/**
	 * 服务接口申请Mapper
	 */
	@Autowired
	private DbSubServiceMapper dbSubServiceMapper;

	@Autowired
	private ServiceKitTemplate serviceKitTemplate;

	/**
	 * 机构Mapper
	 */
	@Autowired
	private DbOrgMapper dbOrgMapper;

	/**
	 * 域信息Mapper
	 */
	@Autowired
	private DbAreaMapper dbAreaMapper;

	/**
	 * 用户信息Mapper
	 */
	@Autowired
	private SysUserMapper sysUserMapper;

	/**
	 * 机构区域Mapper
	 */
	@Autowired
	private DbOrgAreaService dbOrgAreaService;

	@Autowired
	private KeymanagerTemplate keymanagerTemplate;

	@Autowired
	private ExchangeTemplate exchangeTemplate;

	@Override
	public ResultVo getSubServiceList(String orgId, String name, Integer pageIndex, Integer pageSize) {
//		if (StringUtil.isEmpty(orgId)) {
//			return ResultVo.fail("机构id不能为空");
//		}
		DbPubServiceExample example = new DbPubServiceExample();
		example.setOrderByClause("crt_tm desc");
		DbPubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		criteria.andPubStatusEqualTo("PUB");
		if (StringUtil.isNotEmpty(orgId)) {
			criteria.andCrtOrgIdEqualTo(orgId);
		}
		// TODO 服务接口授权范围验证
		// criteria.andUseScopeLike("%" + UserUtil.getOrgId() + "%");
		criteria.andEndDateGreaterThanOrEqualTo(CommonUtil.getSystemDate());
		if (StringUtil.isNotEmpty(name)) {
			criteria.andNameLike("%" + name.trim() + "%");
		}
		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		PageInfo pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> dbPubServiceMapper.selectByExample(example));
		List<DbPubService> list = pageInfo.getList();
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.ok(pageInfo);
		}
		List<DbPubServiceDto> listDto = new ArrayList<>();
		// TODO 获取发布人、发布机构
		List<DbPubServiceDto> dbPubServiceDtoList = CommonUtil.listPo2VO(list, DbPubServiceDto.class);
		for (DbPubServiceDto dbPubServiceDto : dbPubServiceDtoList) {
			// 判断授权范围是机构还是域
			// 机构
			if ("ORG".equals(dbPubServiceDto.getUseType())) {
				// 不在授权范围内
				if (dbPubServiceDto.getUseScope().indexOf(UserUtil.getOrgId()) == -1) {
					continue;
				}
			} else {
				// 域，一个用户只有一个机构，可能有多个域
				if (!isAreas(dbPubServiceDto.getUseScope(), UserUtil.getOrgId())) {
					continue;
				}
			}
			SysUser sysUser = sysUserMapper.selectByPrimaryKey(dbPubServiceDto.getCrtUserId());
			String pubName = "";
			if (sysUser != null) {
				pubName = sysUser.getUsername();
			}
			dbPubServiceDto.setPubName(pubName);
			DbOrg dbOrg = dbOrgMapper.selectByPrimaryKey(dbPubServiceDto.getCrtOrgId());
			dbPubServiceDto.setPubOrgName(dbOrg.getOrgName());
			DbServiceKit dbServiceKit = dbServiceKitService.getServiceKit(dbPubServiceDto.getCrtOrgId());
			dbPubServiceDto.setProxyIp(dbServiceKit.getTagIp());
			dbPubServiceDto.setProxyPort(Integer.parseInt(dbServiceKit.getTagPort()));
			listDto.add(dbPubServiceDto);
		}
		pageInfo.setList(listDto);
		return ResultVo.ok(pageInfo);
	}

	@Override
	public ResultVo getSubService(String id) {
		DbPubServiceExample example = new DbPubServiceExample();
		DbPubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andDelStatusEqualTo("NOR");
		criteria.andPubStatusEqualTo("PUB");
		// TODO 服务接口授权范围验证
		// criteria.andUseScopeLike("%" + UserUtil.getOrgId() + "%");
		criteria.andEndDateGreaterThanOrEqualTo(CommonUtil.getSystemDate());
		List<DbPubService> list = dbPubServiceMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.fail("未查到该接口详细信息！");
		}
		DbPubService dbPubService = list.get(0);
		String orgId = dbPubService.getCrtOrgId();
		DbServiceKit serviceKit = dbServiceKitService.getServiceKit(orgId);
		dbPubService.setProxyIp(serviceKit.getTagIp());
		dbPubService.setProxyPort(Integer.parseInt(serviceKit.getTagPort()));
		// 服务接口授权范围验证
		if ("ORG".equals(dbPubService.getUseType())) {
			if (dbPubService.getUseScope().indexOf(UserUtil.getOrgId()) == -1) {
				return ResultVo.fail("未查到该接口详细信息！");
			}
		} else {
			if (!isAreas(dbPubService.getUseScope(), UserUtil.getOrgId())) {
				return ResultVo.fail("未查到该接口详细信息！");
			}
		}

		// 获取输入输出参数
		DbPubServiceDto dbPubServiceDto = CommonUtil.po2VO(dbPubService, DbPubServiceDto.class);
		DbServiceParamExample example2 = new DbServiceParamExample();
		com.microcore.center.model.DbServiceParamExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andServiceIdEqualTo(dbPubServiceDto.getId());
		List<DbServiceParam> parameters = dbServiceParamMapper.selectByExample(example2);
		dbPubServiceDto.setParameters(parameters);

		// 获取授权范围
		StringBuilder useScope = new StringBuilder();
		if ("ORG".equals(dbPubServiceDto.getUseType())) {
			List<DbOrg> realm = (List<DbOrg>) getUseScope(dbPubServiceDto.getUseType(), dbPubServiceDto.getUseScope());
			for (DbOrg dbOrg : realm) {
				useScope.append(dbOrg.getOrgName()).append("，");
			}
		} else if ("REGION".equals(dbPubServiceDto.getUseType())) {
			List<DbArea> realm = (List<DbArea>) getUseScope(dbPubServiceDto.getUseType(),
					dbPubServiceDto.getUseScope());
			for (DbArea dbArea : realm) {
				useScope.append(dbArea.getAreaName()).append("，");
			}
		}
		useScope = new StringBuilder(useScope.substring(0, useScope.length() - 1));
		dbPubServiceDto.setUseScope(useScope.toString());
		return ResultVo.ok(dbPubServiceDto);
	}

	@Override
	public DbSubService getSubServiceById(String id) {
		return dbSubServiceMapper.selectByPrimaryKey(id);
	}

	@Override
	public ResultVo applySubService(String id, String pid, String runStatus) {
		DbPubService dbPubService = dbPubServiceMapper.selectByPrimaryKey(pid);
		if (dbPubService == null) {
			return ResultVo.fail("您要申请的服务接口ID错误！请重新选择！");
		}
		if (selectByUserIdAndPid(UserUtil.getUserId(), pid) > 0) {
			return ResultVo.fail("您已申请过该服务接口！请勿重复申请！");
		}

		DbSubService dbSubService = new DbSubService();
		dbSubService.setName(dbPubService.getName());
		dbSubService.setTargetIp(dbPubService.getTargetIp());
		dbSubService.setTargetPort(dbPubService.getTargetPort());
		dbSubService.setInterfaceName(dbPubService.getInterfaceName());
		dbSubService.setInterfaceType(dbPubService.getInterfaceType());
		dbSubService.setRequestMode(dbPubService.getRequestMode());
		dbSubService.setWsdlMethodName(dbPubService.getWsdlMethodName());
		dbSubService.setChineseDescribe(dbPubService.getChineseDescribe());
		dbSubService.setWordExample(dbPubService.getWordExample());
		dbSubService.setStartDate(dbPubService.getStartDate());
		dbSubService.setEndDate(dbPubService.getEndDate());
		dbSubService.setUseType(dbPubService.getUseType());
		dbSubService.setUseScope(dbPubService.getUseScope());
		dbSubService.setProxyIp(dbPubService.getProxyIp());
		dbSubService.setProxyPort(dbPubService.getProxyPort());
		dbSubService.setProxyInterfaceName(dbPubService.getProxyInterfaceName());
		dbSubService.setPubStatus(dbPubService.getPubStatus());
		dbSubService.setRunStatus(runStatus);
		dbSubService.setDelStatus(dbPubService.getDelStatus());
		dbSubService.setCrtUserId(dbPubService.getCrtUserId());
		dbSubService.setCrtOrgId(dbPubService.getCrtOrgId());
		dbSubService.setCrtTm(dbPubService.getCrtTm());
		dbSubService.setInterfaceUrl(dbPubService.getInterfaceUrl());
		dbSubService.setId(id);
		dbSubService.setSubUserId(UserUtil.getUserId());
		dbSubService.setSubOrgId(UserUtil.getOrgId());
		dbSubService.setSubTm(CommonUtil.getSystemDate());
		dbSubService.setPubServiceId(pid);

		// 判断该条服务是否需要签名,未YES则生成签名密钥
		if (Constants.YES.equals(dbPubService.getIsSign())) {
			// 先生成密钥对
			try {
				Map<String, Object> map = RSAUtils.genKeyPair();
				dbSubService.setPublickey(map.get("RSAPublicKey").toString());
				dbSubService.setPrivatekey(map.get("RSAPrivateKey").toString());
			} catch (Exception e) {
				log.error("生成密钥对异常[{}]",e.getMessage());
			}
		}
		String subToken;
		try {
			subToken = JwtUtil.createJwtToken(dbSubService.getId(), dbSubService.getEndDate());
		} catch (Exception e) {
			return ResultVo.fail("token 创建失败!");
		}
		dbSubService.setSubToken(subToken);

		//提交发布方节点审批
		serviceKitTemplate.examineSubService(dbSubService);

		dbSubService.setRequestMode("POST");
		//增加主秘钥公共参数对
		SecurityKeyVo securityKeyVo = new SecurityKeyVo();
		securityKeyVo.setAuthOrgId(UserUtil.getOrgId());
		securityKeyVo.setLabelId(dbSubService.getId());
		securityKeyVo.setPolicyId(dbSubService.getId());
		keymanagerTemplate.addServiceSecurity(securityKeyVo);
		boolean isOk = startExchangeTask(dbSubService);
		/*if (!isOk) {
			return ResultVo.fail("申请失败(交换失败)");
		}*/

		// 审批通过
		// 服务接口下发需求方套件
		DbSubServiceVO dbSubServiceVO = new DbSubServiceVO();
		dbSubServiceVO.setDbPubService(dbPubService);
		dbSubServiceVO.setDbSubService(dbSubService);
		serviceKitTemplate.subService(dbSubServiceVO);

		int i = dbSubServiceMapper.insert(dbSubService);
		if (i == 1) {
			return ResultVo.ok("申请成功！");
		}
		return ResultVo.fail("接口申请信息添加数据库失败!");
	}

	private boolean startExchangeTask(DbSubService dbSubService) {
		ProxyExchangeInfo exchangeInfo = new ProxyExchangeInfo();
		String sourceId = dbServiceKitService.getServiceKit(dbSubService.getSubOrgId()).getId();
		String targetId = dbServiceKitService.getServiceKit(dbSubService.getCrtOrgId()).getId();
		exchangeInfo.setSourceId(sourceId);
		exchangeInfo.setTargetId(targetId);
		log.info("创建交换任务==>源套件ID:[{}]目标套件ID:[{}]", sourceId, targetId);
		ResultVo result;
		try {
			result = exchangeTemplate.createExchangeTask(exchangeInfo);
		} catch (Exception e) {
			log.info("创建交换失败[{}]",e.getMessage());
			return false;
		}
		if (result == null) {
			log.info("创建交换失败");
			return false;
		}else if (result.getStatus() != 200) {
			log.info("创建交换任务失败==>源套件ID:[{}]目标套件ID:[{}],交换返回信息[{}]", sourceId, targetId,result.toString());
			return false;
		}
		String taskId = (String) result.getData();
		dbSubService.setExchangeId(String.valueOf(taskId));
		log.info("启动交换==>交换Id[{}]", taskId);
		ResultVo runResult;
		try {
			runResult = exchangeTemplate.runExchange(String.valueOf(taskId));
		} catch (Exception e) {
			log.info("启动交换失败[{}]",e.getMessage());
			return false;
		}
		if (runResult == null) {
			log.info("启动交换失败");
			return false;
		}else if (runResult.getStatus() != 200) {
			log.info("启动交换失败==>交换Id[{}],启动交换返回信息[{}]", taskId,runResult.toString());
			return false;
		}
		return true;
	}

	@Autowired
	private DbServiceKitService dbServiceKitService;

	@Override
	public ResultVo getAlreadySubServiceList(String name, Integer pageIndex, Integer pageSize) {
		DbSubServiceExample example = new DbSubServiceExample();
		example.setOrderByClause("crt_tm desc");
		com.microcore.center.model.DbSubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andSubUserIdEqualTo(UserUtil.getUserId());
		criteria.andEndDateGreaterThanOrEqualTo(CommonUtil.getSystemDate());
		criteria.andDelStatusEqualTo("NOR");
		if (StringUtil.isNotEmpty(name)) {
			criteria.andNameLike("%" + name.trim() + "%");
		}
		if (pageIndex == null || pageSize == null) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		PageInfo pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> dbSubServiceMapper.selectByExample(example));
		List<DbSubService> list = pageInfo.getList();
		if (CommonUtil.isNotEmpty(list)) {
			// 获取发布人、发布机构
			List<DbSubServiceDto> listDto = new ArrayList<>();
			for (DbSubServiceDto dbSubServiceDto : CommonUtil.listPo2VO(list, DbSubServiceDto.class)) {
				SysUser sysUser = sysUserMapper.selectByPrimaryKey(dbSubServiceDto.getCrtUserId());
				dbSubServiceDto.setPubName(sysUser.getUsername());
				DbOrg dbOrg = dbOrgMapper.selectByPrimaryKey(dbSubServiceDto.getCrtOrgId());
				dbSubServiceDto.setPubOrgName(dbOrg.getOrgName());
				DbServiceKit dbServiceKit = dbServiceKitService.getServiceKit(dbSubServiceDto.getCrtOrgId());
				dbSubServiceDto.setProxyIp(dbServiceKit.getTagIp());
				dbSubServiceDto.setProxyPort(Integer.parseInt(dbServiceKit.getTagPort()));
				listDto.add(dbSubServiceDto);
			}
			pageInfo.setList(listDto);
		}
		return ResultVo.ok(pageInfo);
	}

	@Override
	public ResultVo getSubServiceDetail(String sid) {
		DbSubService dbSubService = dbSubServiceMapper.selectByPrimaryKey(sid);
		if (dbSubService == null) {
			return ResultVo.fail("未查到服务接口申请记录（申请ID：" + sid + ")");
		}
		DbSubServiceDto dbSubServiceDto = CommonUtil.po2VO(dbSubService, DbSubServiceDto.class);
		DbServiceParamExample example = new DbServiceParamExample();
		DbServiceParamExample.Criteria criteria = example.createCriteria();
		criteria.andServiceIdEqualTo(dbSubServiceDto.getPubServiceId());
		List<DbServiceParam> parameters = dbServiceParamMapper.selectByExample(example);
		dbSubServiceDto.setParameters(parameters);

		// 获取授权范围
		StringBuilder useScope = new StringBuilder();
		if ("ORG".equals(dbSubServiceDto.getUseType())) {
			List<DbOrg> realm = (List<DbOrg>) getUseScope(dbSubServiceDto.getUseType(), dbSubServiceDto.getUseScope());
			for (DbOrg dbOrg : realm) {
				useScope.append(dbOrg.getOrgName()).append("，");
			}
		} else if ("REGION".equals(dbSubServiceDto.getUseType())) {
			List<DbArea> realm = (List<DbArea>) getUseScope(dbSubServiceDto.getUseType(),
					dbSubServiceDto.getUseScope());
			for (DbArea dbArea : realm) {
				useScope.append(dbArea.getAreaName()).append("，");
			}
		}
		useScope = new StringBuilder(useScope.substring(0, useScope.length() - 1));
		dbSubServiceDto.setUseScope(useScope.toString());
		DbServiceKit dbServiceKit = dbServiceKitService.getServiceKit(dbSubServiceDto.getCrtOrgId());
		dbSubServiceDto.setProxyIp(dbServiceKit.getTagIp());
		dbSubServiceDto.setProxyPort(Integer.parseInt(dbServiceKit.getTagPort()));
		return ResultVo.ok(dbSubServiceDto);
	}

	/**
	 * 根据ID查询服务订阅任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	@Override
	public TaskInfo getTaskInfoById(String id) {
		DbSubService subService = dbSubServiceMapper.selectByPrimaryKey(id);
		if (subService == null) {
			subService = new DbSubService();
		}

		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskName(Optional.ofNullable(subService.getName()).orElse(""));
		taskInfo.setTaskDesc(Optional.ofNullable(subService.getChineseDescribe()).orElse(""));
		return taskInfo;
	}

	/**
	 * 通过userId:申请用户ID，pid:服务注册ID 查询已申请服务接口
	 *
	 * @param subUserId 申请用户ID
	 * @param pid       服务注册ID
	 * @return
	 */
	public Integer selectByUserIdAndPid(String subUserId, String pid) {
		DbSubServiceExample example = new DbSubServiceExample();
		com.microcore.center.model.DbSubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andPubServiceIdEqualTo(pid);
		criteria.andSubUserIdEqualTo(subUserId);
		criteria.andDelStatusEqualTo("NOR");
		List<DbSubService> list = dbSubServiceMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return 0;
		}
		return list.size();
	}

	/**
	 * DbSubService ID检查
	 */
	public String checkedSubServiceId(String id) {
		DbSubService dbSubService = dbSubServiceMapper.selectByPrimaryKey(id);
		if (dbSubService != null) {
			id = CommonUtil.getUUID();
			return checkedSubServiceId(id);
		}
		return id;
	}

	/**
	 * 根据授权类型获取当前接口的授权范围信息
	 *
	 * @param useType  授权类型
	 * @param useScope 授权范围
	 * @return
	 */
	public List<?> getUseScope(String useType, String useScope) {
		List<?> realm = new ArrayList<>();
		if (StringUtil.isNotEmpty(useScope)) {
			String[] ids = useScope.split(",");
			// 如果类型是机构
			if ("ORG".equals(useType)) {
				List<DbOrg> orgs = new ArrayList<>();
				for (String orgId : ids) {
					DbOrg dbOrg = dbOrgMapper.selectByPrimaryKey(orgId);
					orgs.add(dbOrg);
				}
				realm = orgs;
				// 如果类型是域
			} else if ("REGION".equals(useType)) {
				List<DbArea> areas = new ArrayList<>();
				for (String areaId : ids) {
					DbArea dbArea = dbAreaMapper.selectByPrimaryKey(areaId);
					areas.add(dbArea);
				}
				realm = areas;
			}
		}
		return realm;
	}

	/**
	 * 判断机构的域是否在授权范围内
	 *
	 * @param useScope
	 * @param orgId    机构ID
	 * @return 存在-true，不存在-false
	 */
	private boolean isAreas(String useScope, String orgId) {
		List<DbArea> areas = dbOrgAreaService.getDbAreaByOrgId(orgId);
		if (!CommonUtil.isEmpty(areas)) {
			for (DbArea area : areas) {
				String areaId = area.getId();
				if (useScope.contains(areaId)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 根据ID删除我的订阅服务
	 *
	 * @param ids
	 * @return
	 */
	@Override
	public ResultVo delete(String ids) {
		if (ids == null) {
			return ResultVo.fail("您尚未选择需删除的服务接口！请选择！");
		}
		String[] allId = ids.split(",");
		for (String id : allId) {
			DbSubService dbSubService = dbSubServiceMapper.selectByPrimaryKey(id);
			if (Objects.equals(null, dbSubService)) {
				return ResultVo.fail("删除失败!id:" + id + "不存在");
			}
			EntityUtils.setUpdateInfo(dbSubService);
			dbSubService.setDelStatus("DEL");
			int i = dbSubServiceMapper.updateByPrimaryKey(dbSubService);
			serviceKitTemplate.delService(dbSubService);
			if (i == 0) {
				return ResultVo.fail("删除服务接口（ID：" + id + "）失败！");
			}
		}
		return ResultVo.ok("删除成功!");
	}

	/**
	 * 测试代理服务接口
	 *
	 * @param paramsService
	 * @return
	 */
	@Override
	public ResultVo testService(TestSubService paramsService) {
		ParamsService params = new ParamsService();
		params.setRid(paramsService.getRid());
		params.setSid(paramsService.getSid());
		params.setAppsecret(paramsService.getAppsecret());
		params.setPid(paramsService.getPid());
		UseService useService = new UseService();
		useService.setToken(paramsService.getUseService().getToken());
		List<DbServiceParam> parameters = paramsService.getUseService().getParameters();
		useService.setInputParams(parameters);
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		for (DbServiceParam sParam : parameters) {
			map.put(sParam.getEnglishName(), sParam.getDefaultValue());
			useService.setParameters(map);
		}
		params.setUseService(useService);
		ResultVo vo = serviceKitTemplate.subTestService(params);
		/*if (vo.getData() != null) {
			JSONObject jsonObject = JSONObject.fromObject(vo.getData());
			vo.setData(jsonObject);
		}*/
		return vo;
	}

	@Override
	public void deleteSubByPubIdAndSubOrgId(String pubId, String subOrgId) {
		DbSubServiceExample example = new DbSubServiceExample();
		DbSubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andPubServiceIdEqualTo(pubId);
		criteria.andSubOrgIdEqualTo(subOrgId);
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		List<DbSubService> dbSubServices = dbSubServiceMapper.selectByExample(example);
		dbSubServices.forEach(service -> dbSubServiceMapper.deleteByPrimaryKey(service.getId()));
	}

	@Override
	public void setStatus(String id, String status) {
		DbSubService subService = new DbSubService();
		subService.setId(id);
		subService.setRunStatus(status);
		dbSubServiceMapper.updateByPrimaryKey(subService);
	}

}

