package com.microcore.center.service;

import com.microcore.common.util.ResultVo;

import java.util.List;
import java.util.Map;

public interface HomePageService {

	/**
	 * 各行业模型数量统计
	 */
	List<Map<String, Object>> getModelStat();

	/**
	 * 模型订阅频次TOP5
	 */
	List<Map<String, Object>> modelSubTop5();

	/**
	 * 机构数据流转量TOP5
	 */
	List<Map<String, Object>> orgDataSubTop5();

	/**
	 * 库表数据流转量
	 */
	List<Map<String, Object>> dbDataSubCount();

	/**
	 * @data: 2018/8/28 14:47
	 * @des: 文件流转数据量查询
	 */
	List<Map<String, Object>> getFileRecord();

	/**
	 * 获取近一年每月服务接口调用量
	 */
	ResultVo getServiceRecord() throws Exception;
	
	/**
	 * 获取本机构的数据流转
	 * orgId 机构id
	 * type pub/sub
	 * @return
	 */
	ResultVo getUseOrgs(String orgId,String type);
	
	/**
	 * 获取机构地址经纬度
	 * @param orgId
	 * @return
	 */
	ResultVo getLngByOrgId(String orgId);
	
	/**
	 * 清理缓存
	 * @return
	 */
	ResultVo clearOrgAddressCache();
	
	/**
	 * 获取数据流转信息
	 * @return
	 */
	ResultVo getOrgDataUse();

}
