package com.microcore.center.service.impl;

import static com.microcore.common.util.CommonUtil.po2VO;
import static com.microcore.common.util.CommonUtil.removeOrgList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbServiceKit;
import com.microcore.center.mapper.*;
import com.microcore.center.model.*;
import com.microcore.center.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.microcore.api.SysApi;
import com.microcore.api.model.DbOrg;
import com.microcore.center.client.ServiceKitTemplate;
import com.microcore.center.dto.DbExtTemplateDto;
import com.microcore.center.dto.DbPubServiceDto;
import com.microcore.center.dto.TaskInfo;
import com.microcore.center.dto.WithdrawOrgDto;
import com.microcore.center.vo.AddAuthPolicyVo;
import com.microcore.center.vo.AddPubServiceVo;
import com.microcore.center.vo.AddServiceParamVo;
import com.microcore.center.vo.TestService;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;
import com.microcore.common.util.WSDlUtil;
import com.microcore.common.vo.WithdrawPubVo;

import net.sf.json.JSONObject;

/**
 * 服务接口发布
 *
 * @author 何语非
 */
@Service
@Transactional
@Slf4j
public class DbPubServiceServiceImpl implements DbPubServiceService {

	/**
	 * 服务接口发布信息Mapper
	 */
	@Autowired
	private DbPubServiceMapper dbPubServiceMapper;

	/**
	 * 服务接口申请信息Mapper
	 */
	@Autowired
	private DbSubServiceMapper dbSubServiceMapper;

	/**
	 * 服务接口输入、输出参数Mapper
	 */
	@Autowired
	private DbServiceParamMapper dbServiceParamMapper;

	/**
	 * 通用参数Mapper
	 */
	@Autowired
	private DbParamsMapper dbParamsMapper;

	/**
	 * 机构信息Mapper
	 */
	@Autowired
	private DbOrgMapper dbOrgMapper;

	/**
	 * 域信息Mapper
	 */
	@Autowired
	private DbAreaMapper dbAreaMapper;

	/**
	 * client方式下发信息到服务接口节点
	 */
	@Autowired
	private ServiceKitTemplate serviceKitTemplate;

	@Autowired
	private SysApi sysApi;

	@Autowired
	private DbPubTableExtMapper dbPubTableExtMapper;

	@Autowired
	private DbOrgService dbOrgService;

	@Autowired
	private DbSubServiceService dbSubServiceService;

	@Autowired
	private DbPolicyItemMapper dbPolicyItemMapper;

	@Autowired
	private DbModelService dbModelService;

	@Autowired
	private DbParamsService dbParamsService;

	@Autowired
	private DbServiceKitService dbServiceKitService;

	@Autowired
	private DbOrgAreaService dbOrgAreaService;

	@Override
	public ResultVo addService(AddPubServiceVo addPubServiceVo) {
		if (addPubServiceVo.getName().isEmpty()) {
			return ResultVo.fail("接口名称不能为空！");
		}
		if (addPubServiceVo.getInterfaceType().isEmpty()) {
			return ResultVo.fail("接口类型不能为空！");
		}
		if (addPubServiceVo.getInterfaceUrl().isEmpty()) {
			return ResultVo.fail("目标完整接口地址不能为空！");
		}
		if (checkedPubServiceName(addPubServiceVo.getName()) != 0) {
			return ResultVo.fail("接口名称不能重复！");
		}

		String interfaceUrl = addPubServiceVo.getInterfaceUrl();
		//没有http://或https://开头
		if (!(interfaceUrl.contains("http://") || interfaceUrl.contains("https://"))) {
			addPubServiceVo.setInterfaceUrl("http://" + interfaceUrl);
		}

		//服务接口信息配置
		String pubServiceId = checkedPubServiceId(CommonUtil.getUUID());
		addPubServiceVo.setId(pubServiceId);
		addPubServiceVo.setPubStatus("NOT");
		addPubServiceVo.setRunStatus("STOP");
		addPubServiceVo.setDelStatus("NOR");
		addPubServiceVo.setUpdUserId(UserUtil.getUserId());
		addPubServiceVo.setUpdOrgId(UserUtil.getOrgId());
		addPubServiceVo.setUpdTm(CommonUtil.getSystemDate());
		addPubServiceVo.setCrtUserId(UserUtil.getUserId());
		addPubServiceVo.setCrtOrgId(UserUtil.getOrgId());
		addPubServiceVo.setCrtTm(CommonUtil.getSystemDate());

		String authScope = null;
		String authType = null;
		Date authStart = null;
		Date authEnd = null;
		String securtyLevel = null;
		//输入/输出参数落地
		List<AddServiceParamVo> parameters = parseListMapParameter(addPubServiceVo.getParameters());
		if (parameters != null) {
			for (AddServiceParamVo parameter : parameters) {
				DbServiceParam serviceParam = po2VO(parameter, DbServiceParam.class);
				serviceParam.setServiceId(pubServiceId);
				serviceParam.setId(checkedServiceParamId(CommonUtil.getUUID()));
				AddAuthPolicyVo authPolicy = parameter.getAuthPolicy();
				if (authPolicy != null) {
					region2Org(authPolicy);
					serviceParam.setAuthType(authPolicy.getAuthType());
					serviceParam.setAuthScope(authPolicy.getAuthScope());
					serviceParam.setAuthStartTime(authPolicy.getAuthStartTime());
					serviceParam.setAuthEndDate(authPolicy.getAuthEndDate());
					serviceParam.setSecurityLevel(authPolicy.getSecurityLevel());

					authScope = authPolicy.getAuthScope();
					authType = authPolicy.getAuthType();
					authStart = authPolicy.getAuthStartTime();
					authEnd = authPolicy.getAuthEndDate();
					securtyLevel = authPolicy.getSecurityLevel();
				}
				//serviceParam.setEncryptType(parameter.getAddAuthPolicy().getEncryptType());
				dbServiceParamMapper.insert(serviceParam);
			}
		}

		DbPubService dbPubService = po2VO(addPubServiceVo, DbPubService.class);
		dbPubService.setUseScope(authScope);
		dbPubService.setUseType(authType);
		dbPubService.setStartDate(authStart);
		dbPubService.setEndDate(authEnd);
		dbPubService.setSecurityLevel(securtyLevel);
		dbPubService.setPolId(addPubServiceVo.getTemplateId());
		DbServiceKit serviceKit = dbServiceKitService.getCurrentUsersDbKit();
		dbPubService.setProxyIp(serviceKit.getTagIp());
		dbPubService.setProxyPort(Integer.valueOf(serviceKit.getTagPort()));
		setDbPubServiceByTemplate(dbPubService, addPubServiceVo.getTemplate());
		int i = dbPubServiceMapper.insert(dbPubService);
		if (i > 0) {
			//保存自定义策略扩展字段
			saveExtTemplate(addPubServiceVo, pubServiceId);
			//添加日志
			sysApi.addLog("add", "发布信息", "db_pub_service", dbPubService.getId(), "新增接口发布成功!");

			return ResultVo.ok("新增成功！");
		}
		return ResultVo.fail("新增失败！");
	}

	private void region2Org(AddAuthPolicyVo authPolicy) {
		if ("REGION".equals(authPolicy.getAuthType())) {
			String authScope = dbOrgAreaService.getOrgIds(authPolicy.getAuthScope());
			authPolicy.setAuthType("ORG");
			authPolicy.setAuthScope(authScope);
		}
	}

	private void region2Org(DbPubService dbPubService) {
		if ("REGION".equals(dbPubService.getUseType())) {
			String authScope = dbOrgAreaService.getOrgIds(dbPubService.getUseScope());
			dbPubService.setUseType("ORG");
			dbPubService.setUseScope(authScope);
		}
	}

	private void setDbPubServiceByTemplate(DbPubService dbPubService, List<Map<String, Object>> template) {
		if (template == null) {
			return;
		}
		template.forEach((valueMap) -> {
			String field = (String) valueMap.get("extPolicyEname");
			if ("security_level".equals(field)) {//敏感等级
				dbPubService.setSecurityLevel(valueMap.get("extValue") + "");
			} else if ("auth_type".equals(field)) {//授权范围
				dbPubService.setUseType(valueMap.get("extValue") + "");
				dbPubService.setUseScope(valueMap.get("useScope") + "");
				region2Org(dbPubService);
			} else if ("auth_date".equals(field)) {//授权日期
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					dbPubService.setStartDate(sdf.parse(valueMap.get("extValue") + ""));
					dbPubService.setEndDate(sdf.parse(valueMap.get("extValueEnd") + ""));
				} catch (ParseException e) {
					log.error("日期解析异常[{}]", e.getMessage());
				}
			} else if ("shared".equals(field)) {//无条件共享
//				authPolicy.set
			} else if ("sybj".equals(field)) {//溯源标记

			} else if ("useFrequency".equals(field)) {//使用频率
				dbPubService.setUseFrequency(Integer.parseInt(valueMap.get("extValue") + ""));
			} else if ("isSign".equals(field)) {//是否签名
				if ("TRUE".equals(valueMap.get("extValue"))) {
					dbPubService.setIsSign("YES");
				} else {
					dbPubService.setIsSign("false");
				}
			} else {
				//扩展信息
			}
		});
	}


	private List<AddServiceParamVo> parseListMapParameter(List<Map<String, Object>> parametersList) {
		if (CommonUtil.isEmpty(parametersList)) {
			return new ArrayList<>();
		}
		List<AddServiceParamVo> parameters = new ArrayList<>();
		for (Map<String, Object> map : parametersList) {
			AddServiceParamVo vo = new AddServiceParamVo();

			vo.setChineseName(map.get("chineseName") + "");
			vo.setDefaultValue(map.get("defaultValue") + "");
			vo.setEnglishName(map.get("englishName") + "");
			vo.setKind(map.get("kind") + "");
			vo.setMustFill(map.get("mustFill") + "");
			vo.setType(map.get("type") + "");
			if ("OUTPUT".equals(map.get("kind") + "")) {
				List<Map<String, Object>> auths = (List<Map<String, Object>>) map.get("authPolicy");
				Map<String, Map<String, Object>> mapAuths = new HashMap<>();
				for (Map<String, Object> map2 : auths) {
					mapAuths.put(map2.get("extPolicyEname") + "", map2);
				}
				AddAuthPolicyVo authPolicy = new AddAuthPolicyVo();

				for (String field : mapAuths.keySet()) {
					Map<String, Object> valueMap = mapAuths.get(field);
					if (valueMap == null) {
						continue;
					}
					if ("security_level".equals(field)) {//敏感等级
						authPolicy.setSecurityLevel(valueMap.get("extValue") + "");
					} else if ("auth_type".equals(field)) {//授权范围
						authPolicy.setAuthType(valueMap.get("extValue") + "");
						authPolicy.setAuthScope(valueMap.get("eachUseScope") + "");
					} else if ("auth_date".equals(field)) {//授权日期
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							authPolicy.setAuthStartTime(sdf.parse(valueMap.get("extValue") + ""));
							authPolicy.setAuthEndDate(sdf.parse(valueMap.get("extValueEnd") + ""));
						} catch (ParseException e) {
							log.error("日期解析异常[{}]", e.getMessage());
						}
					} else if ("shared".equals(field)) {//无条件共享
//						authPolicy.set
					} else if ("sybj".equals(field)) {//溯源标记

					} else {
						//扩展信息
					}
				}

				Map<String, Object> valueMap = mapAuths.get("security_level");
				if (valueMap != null) {

				}
				valueMap = mapAuths.get("security_level");
				if (valueMap != null) {
					authPolicy.setSecurityLevel(valueMap.get("extValue") + "");
				}
				vo.setAuthPolicy(authPolicy);
			}

			parameters.add(vo);
		}
		return parameters;
	}

	private List<DbExtTemplateDto> parseListMapTemplate(List<Map<String, Object>> template) {
		return new ArrayList<>();
	}

	@Override
	public ResultVo getPubServiceList(String pubStatus, String orgId, String name, Integer pageIndex, Integer pageSize) {
		if (!(pubStatus.equals(Constants.PUB_STATUS_YES) || pubStatus.equals(Constants.PUB_STATUS_NO))) {
			return ResultVo.fail("发布状态参数只能是YES或者NO");
		}
		DbPubServiceExample example = new DbPubServiceExample();
		example.setOrderByClause("crt_tm desc");
		DbPubServiceExample.Criteria criteria = example.createCriteria();

		if ("YES".equals(pubStatus)) {//审核通过已发布
			criteria.andPubStatusEqualTo("PUB");
		} else {//未发布、待审核、审核失败
			criteria.andPubStatusNotEqualTo("PUB");
		}
		criteria.andDelStatusEqualTo("NOR");
		if (StringUtil.isEmpty(orgId)) {
			criteria.andCrtUserIdEqualTo(UserUtil.getUserId());
			criteria.andCrtOrgIdEqualTo(UserUtil.getOrgId());
		} else {
			criteria.andCrtOrgIdEqualTo(orgId);
		}
		if (StringUtil.isNotEmpty(name)) {
			criteria.andNameLike("%" + name.trim() + "%");
		}
		if (pageIndex == null || pageSize == null){
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		PageInfo dbPubServicePageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbPubServiceMapper.selectByExample(example));
		List<DbPubService> list = dbPubServicePageInfo.getList();
		if (CommonUtil.isNotEmpty(list)) {
			//根据授权类型获取当前接口的授权范围信息
			List<DbPubServiceDto> list1 = new ArrayList<>();
			for (DbPubService dbPubService : list) {
				//获取授权范围
				String useScope = getUseScopeName(dbPubService);

				DbPubServiceDto dto = po2VO(dbPubService, DbPubServiceDto.class);
				dto.setUseScope(useScope);

				// 设置是否可以撤回
				dto.setCanBeWithdrawn(dto.getUseType() == null ? "NO" : "YES");

				list1.add(dto);
			}
			dbPubServicePageInfo.setList(list1);
		}
		return ResultVo.ok(dbPubServicePageInfo);
	}

	@Override
	public ResultVo getPubService(String id) {
		//获取接口信息
		DbPubServiceExample example = new DbPubServiceExample();
		DbPubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		//criteria.andPubStatusEqualTo("NOT");
		criteria.andDelStatusEqualTo("NOR");
//		criteria.andCrtUserIdEqualTo(UserUtil.getUserId());
//		criteria.andCrtOrgIdEqualTo(UserUtil.getOrgId());
		List<DbPubService> list = dbPubServiceMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.fail("未查到该接口信息！请检查服务接口id是否正确！");
		}
		DbPubService dbPubService = list.get(0);
		DbPubServiceDto dbPubServiceDto = po2VO(dbPubService, DbPubServiceDto.class);
		String dataType = dbPubServiceDto.getDataType();
		dataType = dbParamsService.getParamsValueByTypeAndKey("data_cate", dataType);
		dbPubServiceDto.setDataType(dataType);
		//获取当前服务接口输入/输出参数信息
		DbServiceParamExample paramExample = new DbServiceParamExample();
		DbServiceParamExample.Criteria paramCriteria = paramExample.createCriteria();
		paramCriteria.andServiceIdEqualTo(id);
		List<DbServiceParam> parameters = dbServiceParamMapper.selectByExample(paramExample);

		//根据授权类型获取当前接口的授权范围信息
		List<?> realm = getUseScope(dbPubServiceDto.getUseType(), dbPubServiceDto.getUseScope());
		dbPubServiceDto.setRealm(realm);

		//获取授权范围
		String useScope = getUseScopeName(dbPubService);
		dbPubServiceDto.setUseScope(useScope);

		AddPubServiceVo pubServiceVo = po2VO(dbPubServiceDto, AddPubServiceVo.class);
		String templateId = pubServiceVo.getTemplateId();
		if (StringUtil.isNotEmpty(templateId)) {
			DbPolicyItem dbPolicyItem = dbPolicyItemMapper.selectByPrimaryKey(templateId);
			pubServiceVo.setDbPolicyItem(dbPolicyItem);
		}
		if (!CommonUtil.isEmpty(parameters)) {
			List<AddServiceParamVo> listparam = new ArrayList<>();
			for (DbServiceParam param : parameters) {
				AddServiceParamVo paramvo = po2VO(param, AddServiceParamVo.class);
				//获取授权范围
				StringBuilder useScopeName = new StringBuilder();
				if ("ORG".equals(dbPubServiceDto.getUseType())) {
					List<DbOrg> realmDbOrg = (List<DbOrg>) getUseScope(param.getAuthType(), param.getAuthScope());
					if (!CommonUtil.isEmpty(realmDbOrg)) {
						for (DbOrg dbOrg : realmDbOrg) {
							useScopeName.append(dbOrg.getOrgName()).append("，");
						}
					}
				} else if ("REGION".equals(dbPubServiceDto.getUseType())) {
					List<DbArea> realmDbOrg = (List<DbArea>) getUseScope(param.getAuthType(), param.getAuthScope());
					if (!CommonUtil.isEmpty(realmDbOrg)) {
						for (DbArea dbArea : realmDbOrg) {
							useScopeName.append(dbArea.getAreaName()).append("，");
						}
					}
				}
				if (StringUtil.isNotEmpty(useScopeName.toString())) {
					useScopeName = new StringBuilder(useScopeName.substring(0, useScopeName.length() - 1));
				}

				AddAuthPolicyVo authPolicyVo = new AddAuthPolicyVo();
				authPolicyVo.setAuthScope(useScopeName.toString());
				authPolicyVo.setAuthScopeInfo(getUseScope(param.getAuthType(), param.getAuthScope()));

				authPolicyVo.setAuthType(param.getAuthType());
				authPolicyVo.setAuthStartTime(param.getAuthStartTime());
				authPolicyVo.setAuthEndDate(param.getAuthEndDate());
				authPolicyVo.setEncryptType(param.getEncryptType());
				authPolicyVo.setSecurityLevel(param.getSecurityLevel());

				paramvo.setAuthPolicy(authPolicyVo);
				listparam.add(paramvo);
			}
			pubServiceVo.setParameters(list2Map(listparam));
			pubServiceVo.setTemplate(list2Map(getExtTemplate(id)));
		}
		return ResultVo.ok(pubServiceVo);
	}


	@SuppressWarnings("unchecked")
	private <T> List<Map<String, Object>> list2Map(List<T> listparam) {
		Gson gson = new Gson();
		List<Map<String, Object>> list = new ArrayList<>();
		listparam.forEach((vo) -> list.add(gson.fromJson(gson.toJson(vo), Map.class)));
		return list;
	}

	@Override
	public ResultVo getApprovingPubService(String id) {
		//获取接口信息
		DbPubServiceExample example = new DbPubServiceExample();
		DbPubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		//criteria.andPubStatusEqualTo("APPROVING");
		//criteria.andDelStatusEqualTo("NOR");
		//criteria.andCrtUserIdEqualTo(UserUtil.getUserId());
		//criteria.andCrtOrgIdEqualTo(UserUtil.getOrgId());
		List<DbPubService> list = dbPubServiceMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.fail("未查到该接口信息！请检查服务接口id是否正确！");
		}
		AddPubServiceVo pubServiceVo = po2VO(list.get(0), AddPubServiceVo.class);

		//获取当前服务接口输入/输出参数信息
		DbServiceParamExample paramExample = new DbServiceParamExample();
		DbServiceParamExample.Criteria paramCriteria = paramExample.createCriteria();
		paramCriteria.andServiceIdEqualTo(id);
		List<DbServiceParam> parameters = dbServiceParamMapper.selectByExample(paramExample);
		//dbPubServiceDto.setParameters(parameters);

		if (!CommonUtil.isEmpty(parameters)) {
			List<AddServiceParamVo> listparam = new ArrayList<>();
			for (DbServiceParam param : parameters) {
				AddServiceParamVo paramvo = po2VO(param, AddServiceParamVo.class);
				//获取授权范围
				StringBuilder useScopeName = new StringBuilder();
				if ("ORG".equals(pubServiceVo.getUseType())) {
					List<DbOrg> realmDbOrg = (List<DbOrg>) getUseScope(param.getAuthType(), param.getAuthScope());
					if (!CommonUtil.isEmpty(realmDbOrg)) {
						for (DbOrg dbOrg : realmDbOrg) {
							useScopeName.append(dbOrg.getOrgName()).append("，");
						}
					}
				} else if ("REGION".equals(pubServiceVo.getUseType())) {
					List<DbArea> realmDbOrg = (List<DbArea>) getUseScope(param.getAuthType(), param.getAuthScope());
					if (!CommonUtil.isEmpty(realmDbOrg)) {
						for (DbArea dbArea : realmDbOrg) {
							useScopeName.append(dbArea.getAreaName()).append("，");
						}
					}
				}
				if (StringUtil.isNotEmpty(useScopeName.toString())) {
					useScopeName = new StringBuilder(useScopeName.substring(0, useScopeName.length() - 1));
				}
				//安全策略
				AddAuthPolicyVo authPolicyVo = new AddAuthPolicyVo();
				authPolicyVo.setAuthScope(useScopeName.toString());
				authPolicyVo.setAuthScopeInfo(getUseScope(param.getAuthType(), param.getAuthScope()));

				authPolicyVo.setAuthType(param.getAuthType());
				authPolicyVo.setAuthStartTime(param.getAuthStartTime());
				authPolicyVo.setAuthEndDate(param.getAuthEndDate());
				authPolicyVo.setEncryptType(param.getEncryptType());
				authPolicyVo.setSecurityLevel(param.getSecurityLevel());

				paramvo.setAuthPolicy(authPolicyVo);
				listparam.add(paramvo);
			}
			pubServiceVo.setParameters(list2Map(listparam));

			pubServiceVo.setTemplate(list2Map(getExtTemplate(id)));
		}

		//根据授权类型获取当前接口的授权范围信息
		List<?> realms = getUseScope(pubServiceVo.getUseType(), pubServiceVo.getUseScope());
		pubServiceVo.setRealm(realms);

		//获取授权范围
		String useScope = getUseScopeName(pubServiceVo);
		pubServiceVo.setUseScope(useScope);

		return ResultVo.ok(pubServiceVo);
	}

	@Override
	public ResultVo updatePubService(AddPubServiceVo addPubServiceVo) {
		//服务接口配置修改前，服务接口状态验证
		if (dbPubServiceMapper.selectByPrimaryKey(addPubServiceVo.getId()) == null) {
			return ResultVo.fail("未查到该接口信息！请检查服务接口ID是否正确！");
		}
		DbPubServiceExample example = new DbPubServiceExample();
		DbPubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(addPubServiceVo.getId());
		criteria.andDelStatusNotEqualTo("DEL");
		List<DbPubService> list1 = dbPubServiceMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list1)) {
			return ResultVo.fail("该服务接口已删除！无法修改！");
		}
		criteria.andPubStatusNotEqualTo("PUB");
		List<DbPubService> list2 = dbPubServiceMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list2)) {
			return ResultVo.fail("该服务接口已发布！无法修改！");
		}
		//删除修改前的参数信息
		DbServiceParamExample example2 = new DbServiceParamExample();
		DbServiceParamExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andServiceIdEqualTo(addPubServiceVo.getId());
		dbServiceParamMapper.deleteByExample(example2);
		//服务接口参数信息修改
		List<AddServiceParamVo> parameters = CommonUtil.map2PO(addPubServiceVo.getParameters(), AddServiceParamVo.class);
		if (!(CommonUtil.isEmpty(parameters))) {
			for (AddServiceParamVo parameter : parameters) {
				DbServiceParam dbServiceParam = po2VO(parameter, DbServiceParam.class);
				if (dbServiceParam.getId() == null) {
					dbServiceParam.setServiceId(addPubServiceVo.getId());
					dbServiceParam.setId(checkedServiceParamId(CommonUtil.getUUID()));

					dbServiceParam.setAuthType(parameter.getAuthPolicy().getAuthType());
					dbServiceParam.setAuthScope(parameter.getAuthPolicy().getAuthScope());
					dbServiceParam.setAuthStartTime(parameter.getAuthPolicy().getAuthStartTime());
					dbServiceParam.setAuthEndDate(parameter.getAuthPolicy().getAuthEndDate());
					dbServiceParam.setSecurityLevel(parameter.getAuthPolicy().getSecurityLevel());
					//dbServiceParam.setEncryptType(parameter.getAddAuthPolicy().getEncryptType());
				}
				dbServiceParamMapper.insert(dbServiceParam);
			}
		}

		//服务接口信息修改
		DbPubService dbPubService = po2VO(addPubServiceVo, DbPubService.class);
		dbPubService.setUpdUserId(UserUtil.getUserId());
		dbPubService.setUpdOrgId(UserUtil.getOrgId());
		dbPubService.setUpdTm(CommonUtil.getSystemDate());

		int s = dbPubServiceMapper.updateByPrimaryKeySelective(dbPubService);
		if (s == 1) {
			updateExtTemplate(addPubServiceVo);

			JSONObject obj = JSONObject.fromObject(dbPubService);
			obj.put("logDesc", "修改成功！");
			sysApi.addLog("upd", "发布信息", "db_pub_service", dbPubService.getId(), obj.toString());//添加日志
			return ResultVo.ok("修改成功！");
		}
		return ResultVo.fail("修改失败！");
	}

	@Override
	public ResultVo volumeDeletePubService(String ids) {
		if (ids == null) {
			return ResultVo.fail("您尚未选择需删除的服务接口！请选择！");
		}
		String[] ids1 = ids.split(",");
		for (String id : ids1) {
			if (dbPubServiceMapper.selectByPrimaryKey(id) == null) {
				return ResultVo.fail("未查到该接口信息！请检查服务接口（ID：" + id + "）是否正确！");
			}
			DbPubService dbPubService = new DbPubService();
			dbPubService.setId(id);
			dbPubService.setDelStatus("DEL");
			int i = dbPubServiceMapper.updateByPrimaryKeySelective(dbPubService);
			if (i == 0) {
				return ResultVo.fail("删除服务接口（ID：" + id + "）失败！");
			}
		}
		return ResultVo.ok("删除成功！");
	}

	/**
	 * 发布待审批或审批拒绝
	 *
	 * @param id     服务接口ID
	 * @param status 状态：审批中和拒绝
	 * @return
	 */
	@Override
	public ResultVo pubStatus(String id, String status) {
		DbPubService dbPubService = dbPubServiceMapper.selectByPrimaryKey(id);
		//判断该接口是否存在且未发布
		if (dbPubService == null) {
			return ResultVo.fail("您需要发布的服务接口（ID：" + id + "）不存在！");
		}
		if ("DEL".equals(dbPubService.getDelStatus())) {
			return ResultVo.fail("您需要发布的服务接口（ID：" + id + "）已删除！");
		}
		if ("PUB".equals(dbPubService.getPubStatus())) {
			return ResultVo.fail("您需要发布的服务接口（ID：" + id + "）已发布！无需重新发布！");
		}

		//更新发布状态，发布待审批
		dbPubService.setPubStatus(status);

		int update = dbPubServiceMapper.updateByPrimaryKeySelective(dbPubService);
		if (update != 1) {
			return ResultVo.fail("发布失败！");
		}
//		JSONObject obj = JSONObject.fromObject(dbPubService);
		sysApi.addLog("upd", "发布待审批或审批拒绝", "db_pub_service", id, "发布待审批或审批拒绝");//日志添加
		return ResultVo.ok();
	}

	/**
	 * 发布服务，审批通过或无审批发布
	 *
	 * @param id
	 * @return
	 */
	@Override
	public ResultVo publishService(String id) {
		DbPubService dbPubService = dbPubServiceMapper.selectByPrimaryKey(id);
		//判断该接口是否存在且未发布
		if (dbPubService == null) {
			return ResultVo.fail("您需要发布的服务接口（ID：" + id + "）不存在！");
		}
		if ("DEL".equals(dbPubService.getDelStatus())) {
			return ResultVo.fail("您需要发布的服务接口（ID：" + id + "）已删除！");
		}
		if ("PUB".equals(dbPubService.getPubStatus())) {
			return ResultVo.fail("您需要发布的服务接口（ID：" + id + "）已发布！无需重新发布！");
		}
		//更新发布状态，发布待审批
		dbPubService.setPubStatus("PUB");
		//设置代理服务接口名称
		dbPubService.setProxyInterfaceName("/proxyService/" + dbPubService.getId());
		//将发布的服务接口信息下发到节点服务器
		DbPubServiceDto dbPubServiceDto = po2VO(dbPubService, DbPubServiceDto.class);
		DbServiceParamExample paramExample = new DbServiceParamExample();
		DbServiceParamExample.Criteria paramCriteria = paramExample.createCriteria();
		paramCriteria.andServiceIdEqualTo(dbPubServiceDto.getId());
		List<DbServiceParam> parameters = dbServiceParamMapper.selectByExample(paramExample);
		dbPubServiceDto.setParameters(parameters);
		String modelId = dbPubService.getModelId();
		// 添加模型
		if (StringUtil.isEmpty(modelId)) {
			addModel(dbPubServiceDto);
		}else {
			dbModelService.updateModelPubCount(modelId);
		}
		ResultVo<?> jointPubService = serviceKitTemplate.addService(dbPubServiceDto);

		//下发节点成功
		if (jointPubService.getStatus() == 200) {
			dbPubService.setModelId(dbPubServiceDto.getModelId());
			int update = dbPubServiceMapper.updateByPrimaryKeySelective(dbPubService);
			if (update != 1) {
				return ResultVo.fail("发布失败！");
			}
			return ResultVo.ok();
		}
		return jointPubService;
	}

	private void addModel(DbPubServiceDto dbPubServiceDto) {
		String modelName = dbPubServiceDto.getName();
		String dataLevel = dbPubServiceDto.getDataType();
		String chineseDescribe = dbPubServiceDto.getChineseDescribe();
		String desc = modelName + (StringUtil.isEmpty(chineseDescribe) ? "" : "-" + chineseDescribe);
		ResultVo<String> resultVo = dbModelService.addServiceModel(modelName, dataLevel, desc);
		String modelId = resultVo.getData();
		dbPubServiceDto.setModelId(modelId);
	}

	@Override
	public ResultVo updateServiceRunStatus(String id, String runStatus) {
		//判断该服务接口是否存在
		if (dbPubServiceMapper.selectByPrimaryKey(id) == null) {
			return ResultVo.fail("您准备启动的服务接口（ID：" + id + "）不存在！");
		}
		if (!("RUN".equals(runStatus) || "STOP".equals(runStatus))) {
			return ResultVo.fail("服务接口运行状态值错误！");
		}
		//服务接口节点运行状态更改
		ResultVo<?> updateResult = serviceKitTemplate.updateRunStatus(id, runStatus);
		if (updateResult.getStatus() != 200) {
			return updateResult;
		}
		//更新已申请记录的运行状态
		DbSubServiceExample example = new DbSubServiceExample();
		DbSubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andPubServiceIdEqualTo(id);
		DbSubService dbSubService = new DbSubService();
		dbSubService.setRunStatus(runStatus);
		dbSubServiceMapper.updateByExampleSelective(dbSubService, example);
		//更新发布记录的运行状态
		DbPubService dbPubService = new DbPubService();
		dbPubService.setId(id);
		dbPubService.setRunStatus(runStatus);
		int i = dbPubServiceMapper.updateByPrimaryKeySelective(dbPubService);
		if (i == 1) {
			if ("RUN".equals(runStatus)) {
				return ResultVo.ok("启动成功！");
			} else {
				return ResultVo.ok("停止成功！");
			}
		} else {
			if ("RUN".equals(runStatus)) {
				return ResultVo.fail("启动失败！");
			} else {
				return ResultVo.fail("停止失败！");
			}
		}
	}

	@Override
	public ResultVo getTypeOrMode(String typeOrMode) {
		if (!("inter_type".equals(typeOrMode) || "reque_mode".equals(typeOrMode))) {
			return ResultVo.fail("接口类型值或者请求方式值错误！");
		}
		DbParamsExample example = new DbParamsExample();
		DbParamsExample.Criteria criteria = example.createCriteria();
		criteria.andParamsTypeEqualTo(typeOrMode);
		List<DbParams> list = dbParamsMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.fail("查询接口类型或者请求方式失败！");
		}
		return ResultVo.ok(list);
	}

	@Override
	public ResultVo testService(TestService testService) {
		return serviceKitTemplate.testService(testService);
	}

	/**
	 * 根据ID查询服务发布任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	@Override
	public TaskInfo getTaskInfoById(String id) {
		DbPubService pubService = dbPubServiceMapper.selectByPrimaryKey(id);
		if (pubService == null) {
			pubService = new DbPubService();
		}
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskName(Optional.ofNullable(pubService.getName()).orElse(""));
		taskInfo.setTaskDesc(Optional.ofNullable(pubService.getChineseDescribe()).orElse(""));

		return taskInfo;
	}

	/**
	 * 根据userid, interfaceUrl查询服务接口
	 *
	 * @param userId       当前用户ID
	 * @param interfaceUrl 接口完整地址
	 * @return
	 */
	public Integer getDbServiceByUrl(String userId, String interfaceUrl) {
		DbPubServiceExample example = new DbPubServiceExample();
		DbPubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andCrtUserIdEqualTo(userId);
		criteria.andInterfaceUrlEqualTo(interfaceUrl);
		criteria.andDelStatusNotEqualTo("DEL");
		List<DbPubService> list = dbPubServiceMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return 0;
		}
		return list.size();
	}

	/**
	 * 根据userid,ip，port，interfaceName查询服务接口
	 *
	 * @param userId        当前用户ID
	 * @param ip            接口IP
	 * @param port          接口端口
	 * @param interfaceName 接口地址
	 * @return
	 */
	public Integer getDbServiceByIpAndPort(String userId, String ip, Integer port, String interfaceName) {
		DbPubServiceExample example = new DbPubServiceExample();
		DbPubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andCrtUserIdEqualTo(userId);
		criteria.andTargetIpEqualTo(ip);
		criteria.andTargetPortEqualTo(port);
		criteria.andInterfaceNameEqualTo(interfaceName);
		criteria.andDelStatusNotEqualTo("DEL");
		List<DbPubService> list = dbPubServiceMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return 0;
		}
		return list.size();
	}

	/**
	 * DbPubService name服务接口名称检查
	 */
	private Integer checkedPubServiceName(String name) {
		DbPubServiceExample example = new DbPubServiceExample();
		DbPubServiceExample.Criteria criteria = example.createCriteria();
		criteria.andCrtUserIdEqualTo(UserUtil.getUserId());
		criteria.andNameEqualTo(name);
		List<DbPubService> list = dbPubServiceMapper.selectByExample(example);
		return list.size();
	}

	/**
	 * DbPubService ID检查
	 */
	private String checkedPubServiceId(String id) {
		DbPubService dbPubService = dbPubServiceMapper.selectByPrimaryKey(id);
		if (dbPubService != null) {
			id = CommonUtil.getUUID();
			return checkedPubServiceId(id);
		}
		return id;
	}

	/**
	 * DbServiceParam ID检查
	 */
	private String checkedServiceParamId(String id) {
		DbServiceParam dbServiceParam = dbServiceParamMapper.selectByPrimaryKey(id);
		if (dbServiceParam != null) {
			id = CommonUtil.getUUID();
			return checkedServiceParamId(id);
		}
		return id;
	}

	/**
	 * 授权范围名称
	 *
	 * @param dbPubService
	 * @return
	 */
	private String getUseScopeName(DbPubService dbPubService) {
		//获取授权范围
		StringBuilder useScope = new StringBuilder();
		if (dbPubService.getUseType() != null && "ORG".equals(dbPubService.getUseType())) {
			List<DbOrg> realm = (List<DbOrg>) getUseScope(dbPubService.getUseType(), dbPubService.getUseScope());
			if (!CommonUtil.isEmpty(realm)) {
				for (DbOrg dbOrg : realm) {
					useScope.append(dbOrg.getOrgName()).append("，");
				}
			}
		} else if (dbPubService.getUseType() != null && "REGION".equals(dbPubService.getUseType())) {
			List<DbArea> realm = (List<DbArea>) getUseScope(dbPubService.getUseType(), dbPubService.getUseScope());
			if (!CommonUtil.isEmpty(realm)) {
				for (DbArea dbArea : realm) {
					useScope.append(dbArea.getAreaName()).append("，");
				}
			}
		}
		if (StringUtil.isNotEmpty(useScope.toString())) {
			useScope = new StringBuilder(useScope.substring(0, useScope.length() - 1));
		}
		return useScope.toString();
	}

	/**
	 * 根据授权类型获取当前接口的授权范围信息
	 *
	 * @param useType  授权类型
	 * @param useScope 授权范围
	 * @return
	 */
	private List<?> getUseScope(String useType, String useScope) {
		List<?> realm = new ArrayList<>();
		if (StringUtil.isNotEmpty(useScope)) {
			String[] ids = useScope.split(",");
			//如果类型是机构
			if ("ORG".equals(useType)) {
				List<DbOrg> orgs = new ArrayList<>();
				for (String orgId : ids) {
					DbOrg dbOrg = dbOrgMapper.selectByPrimaryKey(orgId);
					if (!Objects.isNull(dbOrg)) {
						orgs.add(dbOrg);
					}
				}
				realm = orgs;
				//如果类型是域
			} else if ("REGION".equals(useType)) {
				List<DbArea> areas = new ArrayList<>();
				for (String areaId : ids) {
					DbArea dbArea = dbAreaMapper.selectByPrimaryKey(areaId);
					if (!Objects.isNull(dbArea)) {
						areas.add(dbArea);
					}
				}
				realm = areas;
			}
		}
		return realm;
	}

	/**
	 * 保存自定义策略扩展字段
	 *
	 * @param addPubServiceVo
	 */
	private void saveExtTemplate(AddPubServiceVo addPubServiceVo, String pubServiceId) {
		List<DbExtTemplateDto> template = CommonUtil.map2PO(addPubServiceVo.getTemplate(), DbExtTemplateDto.class);
		if (null == template || template.isEmpty()) {
			return;
		}
		template.forEach(ext -> {
			DbPubTableExt pubExt = new DbPubTableExt();
			pubExt.setId(pubServiceId);
			pubExt.setExtAttrCname(ext.getExtPolicyCname());
			pubExt.setExtAttrEname(ext.getExtPolicyEname());
			pubExt.setTemplateType(ext.getTemplateType());
			pubExt.setDataType(ext.getDataType());
			pubExt.setExtValue(ext.getExtValue());
			//pubExt.setLabelId(null);
			dbPubTableExtMapper.insert(pubExt);
		});
	}

	/**
	 * 自定义策略修改
	 *
	 * @param addPubServiceVo
	 */
	private void updateExtTemplate(AddPubServiceVo addPubServiceVo) {
		String psid = addPubServiceVo.getId();
		List<DbExtTemplateDto> template = CommonUtil.map2PO(addPubServiceVo.getTemplate(), DbExtTemplateDto.class);
		if (null == template || template.isEmpty()) {
			return;
		}
		template.forEach(ext -> {
			DbPubTableExt pubExt = new DbPubTableExt();
			pubExt.setExtValue(ext.getExtValue());
			DbPubTableExtExample example = new DbPubTableExtExample();
			DbPubTableExtExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(psid);
			criteria.andExtAttrCnameEqualTo(ext.getExtPolicyCname());
			criteria.andExtAttrEnameEqualTo(ext.getExtPolicyEname());
			dbPubTableExtMapper.updateByExampleSelective(pubExt, example);
		});
	}

	/**
	 * 获取自定义策略扩展字段
	 *
	 * @param fid
	 * @return
	 */
	private List<DbExtTemplateDto> getExtTemplate(String fid) {
		DbPubTableExtExample example = new DbPubTableExtExample();
		DbPubTableExtExample.Criteria criteria = example.createCriteria();
		criteria.andLabelIdEqualTo(fid);
		List<DbPubTableExt> pubExt = dbPubTableExtMapper.selectByExample(example);
		List<DbExtTemplateDto> template = new ArrayList<>();
		if (null == pubExt || pubExt.isEmpty()) {
			return template;
		}
		pubExt.forEach(ext -> {
			DbExtTemplateDto dto = new DbExtTemplateDto();
			dto.setExtPolicyCname(ext.getExtAttrCname());
			dto.setExtPolicyEname(ext.getExtAttrEname());
			dto.setTemplateType(ext.getTemplateType());
			dto.setDataType(ext.getDataType());
			dto.setExtValue(ext.getExtValue());
			template.add(dto);
		});
		return template;
	}

	@Override
	public ResultVo getMethodName(String url) {
		List<WSDlUtil.MethodInfo> list = new ArrayList<>();
		try {
			list = WSDlUtil.getMethodInfoList(url + "?wsdl");
		} catch (Exception e) {
			ResultVo.fail("失败" + e.getMessage());
		}
		return ResultVo.ok(list);
	}

	private List<DbServiceParam> getServiceParamsByServiceId(String serivceId) {
		DbServiceParamExample example = new DbServiceParamExample();
		DbServiceParamExample.Criteria criteria = example.createCriteria();
		criteria.andServiceIdEqualTo(serivceId);
		return dbServiceParamMapper.selectByExample(example);
	}

	/**
	 * 撤回发布
	 *
	 * @param vo 撤回信息
	 * @return 撤回结果
	 */
	@Override
	public ResultVo withdrawPub(WithdrawPubVo vo) {
		String pubId = vo.getPubId();
		DbPubService pubService = dbPubServiceMapper.selectByPrimaryKey(pubId);
		String authScope = pubService.getUseScope();
		String newAuthScope;
		if (StringUtil.isEmpty(authScope)) {
			newAuthScope = "";
		} else {
			newAuthScope = CommonUtil.removeOrgList(authScope, vo.getAuthScopes());
		}

		List<DbServiceParam> serviceParams = getServiceParamsByServiceId(pubId);
		serviceParams.forEach(param -> {
			DbServiceParam dbServiceParam = new DbServiceParam();
			dbServiceParam.setId(param.getId());
			String paramAuthScope;
			if (StringUtil.isEmpty(param.getAuthScope())) {
				paramAuthScope = "";
			} else {
				paramAuthScope = removeOrgList(param.getAuthScope(), vo.getAuthScopes());
			}
			dbServiceParam.setAuthScope(paramAuthScope);
			dbServiceParamMapper.updateByPrimaryKeySelective(dbServiceParam);
		});

		DbPubService t = new DbPubService();
		t.setId(pubId);
		t.setUseScope(newAuthScope);
		dbPubServiceMapper.updateByPrimaryKeySelective(t);

		// 删除子节点数据
		serviceKitTemplate.withdrawPub(vo);

		// 删除订阅方中心数据
		vo.getAuthScopes().forEach(scope -> dbSubServiceService.deleteSubByPubIdAndSubOrgId(vo.getPubId(), scope));

		// 删除订阅方节点数据
		vo.getAuthScopes().forEach(scope -> serviceKitTemplate.deleteSubByPubIdAndSubOrgId(vo.getPubId(), scope));

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
		DbPubService dbPubService = dbPubServiceMapper.selectByPrimaryKey(pubId);
		String authScope = dbPubService.getUseScope();
		List<WithdrawOrgDto> list = Arrays.stream(authScope.split(",")).map(x -> {
			String orgName = dbOrgService.getOrgNameByOrgId(x);
			return new WithdrawOrgDto(x, orgName);
		}).collect(Collectors.toList());

		return ResultVo.ok(list);
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
	public ResultVo updateServiceRunStatusBatch(List<String> ids, String runStatus) {
		for (String id : ids) {
			ResultVo resultVo = updateServiceRunStatus(id, runStatus);
			if (resultVo.getStatus()!=200) {
				return resultVo;
			}
		}
		return ResultVo.ok();
	}

	@Override
	public ResultVo publishServiceBatch(List<String> ids) {
		for (String id : ids) {
			ResultVo resultVo = publishService(id);
			if (resultVo.getStatus() != 200) {
				return resultVo;
			}
		}
		return ResultVo.ok();
	}
}
