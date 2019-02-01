package com.microcore.center.service;

import com.microcore.center.dto.TaskInfo;
import com.microcore.center.model.DbSubService;
import com.microcore.center.vo.TestSubService;
import com.microcore.common.util.ResultVo;

/**
 * 服务接口申请
 */
public interface DbSubServiceService {

	/**
	 * 获取可申请服务接口列表信息
	 *
	 * @return
	 */
	ResultVo getSubServiceList(String orgId, String name, Integer pageIndex, Integer pageSize);

	/**
	 * 获取单个可申请服务接口信息
	 *
	 * @param id 服务接口ID
	 * @return
	 */
	ResultVo getSubService(String id);

	DbSubService getSubServiceById(String id);

	/**
	 * 申请服务接口
	 *
	 * @param pid 服务接口注册ID
	 * @return
	 */

	ResultVo applySubService(String id, String pid, String runStatus);

	/**
	 * 获取已申请服务接口列表信息
	 *
	 * @return
	 * @param name
	 * @param pageIndex
	 * @param pageSize
	 */
	ResultVo getAlreadySubServiceList(String name, Integer pageIndex, Integer pageSize);

	/**
	 * 获取已申请单个服务接口详情
	 *
	 * @param sid 服务接口申请ID
	 * @return
	 */
	ResultVo getSubServiceDetail(String sid);

	/**
	 * 根据ID查询服务订阅任务名
	 *
	 * @param id 发布ID
	 * @return 任务名
	 */
	TaskInfo getTaskInfoById(String id);

	/**
	 * 根据ID删除我的订阅任务
	 *
	 * @param ids
	 * @return
	 */
	ResultVo delete(String ids);

	/**
	 * 测试代理服务接口
	 *
	 * @param params
	 * @return
	 */
	ResultVo testService(TestSubService params);

	void deleteSubByPubIdAndSubOrgId(String pubId, String scope);

	void setStatus(String id, String status);

}
