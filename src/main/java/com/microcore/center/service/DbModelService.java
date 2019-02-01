package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbModelDto;
import com.microcore.center.model.DbModel;
import com.microcore.center.model.DbModelDetail;
import com.microcore.common.util.ResultVo;

import java.util.List;
import java.util.Map;

public interface DbModelService {

	DbModel getModelById(String id);

//	ResultVo getModels(Integer pageIndex, Integer pageSize);

	ResultVo<PageInfo<DbModel>> getModels(String dataLevel, Integer pageIndex, Integer pageSize);

	ResultVo<String> addDbModel(String modelName, String dataLevel, String desc,
	                            List<DbModelDetail> detailList);

	ResultVo<String> addFileModel(String modelName, String dataLevel, String desc);

	ResultVo<String> addServiceModel(String modelName, String dataLevel, String desc);

	ResultVo<String> addModel(String modelName, String modelType, String dataLevel, String desc,
	                          List<DbModelDetail> detailList);

	ResultVo<String> addModel(DbModelDto modelDto);
	
	ResultVo<String> addModelByExcel(DbModelDto modelDto);
	
	String getModelFile(String type);

	ResultVo<String> deleteModelById(String id);

	ResultVo<String> updateModel(DbModelDto modelDto);

	Long getModelCount();

	List<DbModel> listModel();

	Long getModelCountByDataLevel(String dataLevel);

	ResultVo searchModels(String modelType, String modelName, String dataLevel, Integer pageIndex, Integer pageSize);

	ResultVo getModelDataLevels();

	/**
	 * 获取模型详情
	 *
	 * @param id 模型ID
	 * @return 模型详情
	 */
	ResultVo getModelDetailedInfo(String id);

	/**
	 * 根据ID获取模型名
	 *
	 * @param id 模型ID
	 * @return 模型名
	 */
	String getModelNameById(String id);

	List<DbModelDto> queryModels(String modelName, String modelTrade);

	List<DbModelDetail> getDbModelDetail(String modelId);

	void updateModelPubCount(String modelId);

	PageInfo getModelsByOrgId(String orgId, String modelName, String modelType, Integer pageIndex, Integer pageSize);

	PageInfo getModelsByTradeId(String tradeId, String modelName, String modelType, Integer pageIndex, Integer pageSize);
	
	List<Map<String, Object>> getOrgListByModel();
	
	List<Map<String, Object>> getTradeListByModel();
	
	
	
}

