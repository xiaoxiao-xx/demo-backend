package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.microcore.api.model.DbPubTs;
import com.microcore.center.mapper.*;
import com.microcore.center.model.*;
import com.microcore.center.service.*;
import com.microcore.common.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbModelDto;
import com.microcore.center.model.DbModelDetailExample.Criteria;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;

@Transactional
@Service
public class DbModelServiceImpl implements DbModelService {

	@Autowired
	private DbModelMapper dbModelMapper;

	@Autowired
	private DbModelDetailMapper dbModelDetailMapper;

	@Autowired
	private CommonService commonService;

	@Autowired
	private DbOrgService dbOrgService;

	@Autowired
	private UserService userService;

	@Autowired
	private IDService idService;

	@Autowired
	private DbNameSpaceService dbNameSpaceService;
	
	@Autowired
	private DbParamsService dbParamsService;

	@Autowired
	private DbPubTableMapper dbPubTableMapper;

	@Autowired
	private DbPubTsMapper dbPubTsMapper;

	@Autowired
	private DbPubFileMapper dbPubFileMapper;

	@Autowired
	private DbPubServiceMapper dbPubServiceMapper;

	private static Map<String, String> tradeMap = null;
	
	private void initTradeMap() {
		String sql = "SELECT * from db_name_space";
		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		if (CommonUtil.isEmpty(list)) {
			return;
		}
		tradeMap = new HashMap<>();
		list.forEach(x->{
			String id = x.get("id")+"";
			String cname = x.get("cname")+"";
			tradeMap.put(cname,id);
		});
	}

	/**
	 * 根据ID获取模型
	 */
	@Override
	public DbModel getModelById(String id) {
		return dbModelMapper.selectByPrimaryKey(id);
	}

	// TODO 删除
	/**
	 * 获取模型总数
	 */
	@Override
	public Long getModelCount() {
		// 查询数据总数
		String countSql = "from db_model where 1 = 1 and del_status <> 'DEL'";
		Map<String, Object> params = new HashMap<>();
		params.put("sql", countSql);
		return commonService.executeGetCount(params);
	}

	// TODO DEL
	// 根据模型数据类别查询数据总数
	@Override
	public Long getModelCountByDataLevel(String dataLevel) {
		String countSql = "from db_model where 1 = 1 and model_data_level = #{dataLevel} and del_status <> 'DEL'";
		Map<String, Object> params = new HashMap<>();
		params.put("sql", countSql);
		params.put("dataLevel", dataLevel);
		return commonService.executeGetCount(params);
	}

	/**
	 * 根据模型类别分页获取模型
	 */
	@Override
	public ResultVo<PageInfo<DbModel>> getModels(String dataLevel, Integer pageIndex, Integer pageSize) {
		DbModelExample example = new DbModelExample();
		DbModelExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		criteria.andModelDataLevelEqualTo(dataLevel);
		PageInfo<DbModel> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbModelMapper.selectByExample(example));
//		List<DbModel> list = pageInfo.getList();
		/*
		 * String dataLevelString =
		 * dbParamsService.getParamsValueByTypeAndKey("data_cate", dataLevel);
		 * list.forEach(model -> model.setModelDataLevel(dataLevelString));
		 */
		return ResultVo.ok(pageInfo);
	}

	/**
	 * 添加库表模型
	 *
	 * @param modelName
	 *            模型名。一般为表名，文件名等
	 * @param dataLevel
	 *            模型级别。如 党政类
	 * @param desc
	 *            模型描述。一般是 表名+表注释，文件名+文件注释
	 * @param detailList
	 *            DbModelDetail列表
	 */
	@Override
	public ResultVo<String> addDbModel(String modelName, String dataLevel, String desc,
			List<DbModelDetail> detailList) {
		String modelType = "DB";
		return addModel(modelName, modelType, dataLevel, desc, detailList);
	}

	/**
	 * 添加文件模型
	 *
	 * @param modelName
	 *            模型名。一般为表名，文件名等
	 * @param dataLevel
	 *            模型级别。如 党政类
	 * @param desc
	 *            模型描述。一般是 表名+表注释，文件名+文件注释
	 */
	@Override
	public ResultVo<String> addFileModel(String modelName, String dataLevel, String desc) {
		String modelType = "FILE";
		return addModel(modelName, modelType, dataLevel, desc, null);
	}

	/**
	 * 添加服务模型
	 *
	 * @param modelName
	 *            模型名。一般为表名，文件名等
	 * @param dataLevel
	 *            模型级别。如 党政类
	 * @param desc
	 *            模型描述。一般是 表名+表注释，文件名+文件注释
	 */
	@Override
	public ResultVo<String> addServiceModel(String modelName, String dataLevel, String desc) {
		String modelType = "SERVICE";
		return addModel(modelName, modelType, dataLevel, desc, null);
	}

	/**
	 * 添加模型
	 *
	 * @param modelName
	 *            模型名。一般为表名，文件名等
	 * @param modelType
	 *            模型类别。库表-DB, 文件-FILE, 服务接口-SERVICE
	 * @param dataLevel
	 *            模型级别。如 党政类
	 * @param desc
	 *            模型描述。一般是 表名+表注释，文件名+文件注释
	 * @param detailList
	 *            DbModelDetail列表
	 */
	@Override
	public ResultVo<String> addModel(String modelName, String modelType, String dataLevel, String desc,
			List<DbModelDetail> detailList) {
		DbModelDto dto = new DbModelDto();
		dto.setModelName(modelName);
		dto.setModelDisplayName(modelName);
		dto.setModelType(modelType);
		dto.setModelDataLevel(dataLevel);
		dto.setModelDesc(desc);
		dto.setModelTrade(dataLevel);
		dto.setModelDetailDto(detailList);
		dto.setStatus("YES");
		dto.setPubCount(1);//发布时新增模型初始发布次数为1
		return addModel(dto);
	}

	/**
	 * 添加模型
	 */
	@Override
	public ResultVo<String> addModel(DbModelDto modelDto) {
		DbModel dbModel = CommonUtil.po2VO(modelDto, DbModel.class);
		String id = CommonUtil.getUUID();
		dbModel.setId(id);
		// 暂留空
		dbModel.setPid("");
		String modelType = modelDto.getModelType();
		if (!("DB".equals(modelType) || "FILE".equals(modelType) || "SERVICE".equals(modelType))) {
			return ResultVo.fail("模型类型不正确");
		}

		dbModel.setModelVersion(1);

		String orgName = dbOrgService.getOrgNameByOrgId(UserUtil.getOrgId());
		dbModel.setCopyrightNotice(orgName + "版权所有");

		// TODO BUG 有审批发布时，获取到的是审批人的信息
		String orgId = UserUtil.getOrgId();
		String userId = UserUtil.getUserId();

		dbModel.setOrgId(orgId);
		// 发布状态
		if(!StringUtil.isEmpty(modelDto.getStatus())) {
			dbModel.setStatus(modelDto.getStatus());
		}else {
			dbModel.setStatus("NO");
		}
		
		dbModel.setDelStatus("NOR");

		dbModel.setUpdOrgId(orgId);
		dbModel.setUpdTm(CommonUtil.getCurrentTime());
		dbModel.setUpdUserId(userId);

		dbModel.setCrtOrgId(orgId);
		dbModel.setCrtTm(CommonUtil.getCurrentTime());
		dbModel.setCrtUserId(userId);
		if (dbModel.getModelTrade() != null) {
			dbModel.setModelDataLevel(dbModel.getModelTrade());
		}
		dbModelMapper.insert(dbModel);

		if ("DB".equals(modelType)) {
			List<DbModelDetail> list = modelDto.getModelDetailDto();
			if (list != null) {
				list.forEach(detailVo -> {
					DbModelDetail detail = new DbModelDetail();
					EntityUtils.setCreateInfo(detail);
//					detail.setEname("enname");
					detail.setId(CommonUtil.getUUID());
					detail.setPid(id);
					detail.setModelId(id);
					detail.setFieldCname(detailVo.getFieldCname());// 中文名称
					detail.setFieldType(detailVo.getFieldType());// 字段名称
					detail.setFieldDesc(detailVo.getFieldDesc());// 定义
					detail.setType(detailVo.getType());// 数据类型
					detail.setRemark(detailVo.getRemark());// 备注
					detail.setDataType(detailVo.getDataType());// 表示格式（d8,c8,c3-9）
					detail.setDataList(detailVo.getDataList());// 值域
					detail.setFieldEname(detailVo.getFieldEname());
					detail.setEname(CommonUtil.formatNumber(idService.getBusinessNumber("MODEL_FIELD")));
					dbModelDetailMapper.insert(detail);
				});
			}
		}

		return ResultVo.ok(id);
	}

	/**
	 * 根据ID删除模型
	 */
	@Override
	public ResultVo<String> deleteModelById(String id) {
		DbModelDetailExample example = new DbModelDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(id);
		dbModelDetailMapper.deleteByExample(example);

		DbModel model = new DbModel();
		model.setId(id);
		model.setDelStatus("DEL");
		dbModelMapper.updateByPrimaryKeySelective(model);

		return ResultVo.ok();
	}

	/**
	 * 更新模型
	 */
	@Override
	public ResultVo<String> updateModel(DbModelDto modelDto) {
		// 更新db_model_detail表
		DbModelDetailExample example = new DbModelDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(modelDto.getId());
		dbModelDetailMapper.deleteByExample(example);

		List<DbModelDetail> list = modelDto.getModelDetailDto();
		if (list != null) {
			list.forEach(detail -> dbModelDetailMapper.insert(detail));
		}

		// 更新db_model表
		DbModel model = CommonUtil.po2VO(modelDto, DbModel.class);
		dbModelMapper.updateByPrimaryKeySelective(model);

		return ResultVo.ok();
	}

	/**
	 * 搜索模型
	 */
	@Override
	public ResultVo searchModels(String modelType, String modelName, String dataLevel, Integer pageIndex,
			Integer pageSize) {
		DbModelExample example = new DbModelExample();
		com.microcore.center.model.DbModelExample.Criteria criteria = example.createCriteria();

		if (modelType != null && "".equals(modelType.trim())) {
			modelType = null;
		}
		if (dataLevel != null && "".equals(dataLevel.trim())) {
			dataLevel = null;
		}
		if (modelName != null && "".equals(modelName.trim())) {
			modelName = null;
		}

		if (modelType != null) {
			criteria.andModelTypeEqualTo(modelType);
		}
		if (dataLevel != null) {
			criteria.andModelTradeEqualTo(dataLevel);
		}
		if (modelName != null) {
			criteria.andModelNameLike("%" + modelName.trim() + "%");
		}
		criteria.andDelStatusEqualTo("NOR");

		String role = CommonUtil.getAdminRole();
		if (!Constants.ROLE_CENTER_ADMIN.equals(role)) {
			criteria.andOrgIdEqualTo(UserUtil.getOrgId());
		}
		example.setOrderByClause("crt_tm desc");

		PageInfo<DbModel> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> dbModelMapper.selectByExample(example));
		// List<DbModel> dbModelList = pageInfo.getList();
		/*
		 * dbModelList.forEach(model -> { String dataType =
		 * dbParamsService.getParamsValueByTypeAndKey("data_cate",
		 * model.getModelDataLevel()); model.setModelDataLevel(dataType); });
		 */

		return ResultVo.ok(pageInfo);
	}

	/**
	 * 获取模型级别
	 *
	 * @return 模型级别列表
	 */
	@Override
	public ResultVo getModelDataLevels() {
		String sql = "SELECT * from db_name_space";
		Map<String, Object> params = new HashMap<>();
		params.put("sql", sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		List<Map<String, Object>> levelList = new ArrayList<>();
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.ok(levelList);
		}
		list.forEach(x -> {
			String dataLevel = (String) x.get("id");
			String cname = (String) x.get("cname");
			String path = (String) x.get("path");
			Map<String, Object> m = new HashMap<>();
			m.put("dataLevel", dataLevel);
			m.put("dataLevelString", cname);
			m.put("path", path);
			levelList.add(m);
		});
		return ResultVo.ok(levelList);
	}

	/**
	 * 根据ID获取模型名
	 *
	 * @param id
	 *            模型ID
	 * @return 模型名
	 */
	@Override
	public String getModelNameById(String id) {
		DbModel model = getModelById(id);
		if (model == null) {
			return "";
		}

		return Optional.ofNullable(model.getModelName()).orElse("");
	}

	/**
	 * 获取模型详情
	 *
	 * @param id
	 *            库表发布ID
	 * @return 发布详细信息
	 */
	@Override
	public ResultVo getModelDetailedInfo(String id) {
		DbModel model = getModelById(id);
		if (model == null) {
			return ResultVo.ok();
		}

		DbModelDto dto = CommonUtil.po2VO(model, DbModelDto.class);

		dto.setOrgName(dbOrgService.getOrgNameByOrgId(dto.getOrgId()));
		dto.setCreateUserName(userService.getUserNameById(dto.getCrtUserId()));
		dto.setCreateOrgName(dbOrgService.getOrgNameByOrgId(dto.getCrtOrgId()));

		List<DbModelDetail> list = getDbModelDetail(id);
		for (DbModelDetail dbModelDetail : list) {
			if (StringUtil.isNotEmpty(dbModelDetail.getDataList())) {
				DbCodeTb dbCodeTb = CommonUtil.getBean(DbCodeTbMapper.class)
						.selectByPrimaryKey(dbModelDetail.getDataList());
				if (dbCodeTb != null) {
					dbModelDetail.setDataList(dbCodeTb.getName());
				}
			}
		}
		dto.setModelDetailDto(list);
		if (StringUtil.isNotEmpty(dto.getModelTrade())) {
			DbNameSpace nameSpace = dbNameSpaceService.get(dto.getModelTrade());
			if (nameSpace != null) {
				dto.setModelTrade(nameSpace.getCname());
			}
		}
		return ResultVo.ok(dto);
	}

	@Override
	public List<DbModel> listModel() {
		DbModelExample example = new DbModelExample();
		DbModelExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		return dbModelMapper.selectByExample(example);
	}

	@Override
	public List<DbModelDetail> getDbModelDetail(String modelId) {
		DbModelDetailExample example = new DbModelDetailExample();
		DbModelDetailExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		criteria.andModelIdEqualTo(modelId);
		return dbModelDetailMapper.selectByExample(example);
	}

	@Override
	public List<DbModelDto> queryModels(String modelName, String modelTrade) {
		DbModelExample example = new DbModelExample();
		DbModelExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(modelName)) {
			criteria.andModelNameLike("%" + modelName.trim() + "%");
		}
		if (StringUtil.isNotEmpty(modelTrade)) {
			criteria.andModelTradeEqualTo(modelTrade);
		}
		List<DbModel> list = dbModelMapper.selectByExample(example);
		List<DbModelDto> listDto = new ArrayList<DbModelDto>();
		for (DbModel dbModel : list) {
			DbModelDto dto = CommonUtil.po2VO(dbModel, DbModelDto.class);
			List<DbModelDetail> listDetail = getDbModelDetail(dto.getId());
			dto.setModelDetailDto(listDetail);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public ResultVo<String> addModelByExcel(DbModelDto modelDto) {
		if(tradeMap==null) {
			initTradeMap();
		}
		String modelTrade = modelDto.getModelTrade();
		modelDto.setModelTrade(tradeMap.get(modelTrade));
		return addModel(modelDto);
	}

	@Override
	public String getModelFile(String type) {
		if (StringUtil.isEmpty(type)) {
			type = "data_model";
		}
		return dbParamsService.getParamsValueByTypeAndKey("model_file", type);
	}

	@Override
	public void updateModelPubCount(String modelId) {
		DbModel dbModel = getModelById(modelId);
		if (dbModel != null) {
			Integer pubCount = dbModel.getPubCount();
			pubCount = (pubCount == null) ? 1 : pubCount + 1;
			dbModel.setPubCount(pubCount);
			dbModel.setStatus(Constants.YES);
			dbModelMapper.updateByPrimaryKeySelective(dbModel);
		}
	}

	@Override
	public PageInfo getModelsByOrgId(String orgId, String modelName, String modelType, Integer pageIndex, Integer pageSize) {
		DbModelExample example = new DbModelExample();
		example.setOrderByClause("crt_tm desc");
		DbModelExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		if (StringUtil.isNotEmpty(modelName)) {
			criteria.andModelNameLike("%" + modelName.trim() + "%");
		}
		if (StringUtil.isNotEmpty(modelType)) {
			criteria.andModelTypeLike("%" + modelType.trim() + "%");
		}
		if (CommonUtil.checkPageIsNull(pageIndex, pageSize)) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> dbModelMapper.selectByExample(example));
	}

	@Override
	public PageInfo getModelsByTradeId(String tradeId, String modelName, String modelType, Integer pageIndex, Integer pageSize) {
		DbModelExample example = new DbModelExample();
		example.setOrderByClause("crt_tm desc");
		DbModelExample.Criteria criteria = example.createCriteria();
		criteria.andModelTradeEqualTo(tradeId);
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		if (StringUtil.isNotEmpty(modelName)) {
			criteria.andModelNameLike("%" + modelName.trim() + "%");
		}
		if (StringUtil.isNotEmpty(modelType)) {
			criteria.andModelTypeLike("%" + modelType.trim() + "%");
		}
		if (CommonUtil.checkPageIsNull(pageIndex, pageSize)) {
			pageIndex = 1;
			pageSize = Integer.MAX_VALUE;
		}
		return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> dbModelMapper.selectByExample(example));
	}

	@Override
	public List<Map<String, Object>> getOrgListByModel() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM db_org WHERE del_status='NOR' AND org_id IN(\r\n" + 
				"SELECT org_id FROM db_model WHERE del_status='NOR' GROUP BY org_id)";
		params.put("sql", sql);
		List<Map<String, Object>> paramList = commonService.executeSelectSQL(params);
		return paramList;
	}

	@Override
	public List<Map<String, Object>> getTradeListByModel() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM db_params WHERE params_type='data_cate' AND params_key IN(\r\n" + 
				"SELECT model_trade FROM db_model WHERE del_status='NOR' GROUP BY model_trade)";
		params.put("sql", sql);
		List<Map<String, Object>> paramList = commonService.executeSelectSQL(params);
		return paramList;
	}
}
