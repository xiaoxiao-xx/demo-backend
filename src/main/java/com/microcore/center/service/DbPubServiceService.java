package com.microcore.center.service;

import com.microcore.center.dto.TaskInfo;
import com.microcore.center.vo.AddPubServiceVo;
import com.microcore.common.util.ResultVo;
import com.microcore.center.vo.TestService;
import com.microcore.common.vo.WithdrawPubVo;

import java.util.List;

/**
 * 服务接口发布
 */
public interface DbPubServiceService {

	/**
	 * 新增服务接口发布任务
	 * @param addPubServiceVo 服务接口vo对象
	 * @return
	 */
	ResultVo addService(AddPubServiceVo addPubServiceVo);

	/**
	 * 根据服务接口发布状态获取服务接口列表信息
	 * @param pubStatus 服务接口发布状态
	 * @param name
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ResultVo getPubServiceList(String pubStatus, String orgId, String name, Integer pageIndex, Integer pageSize);

	/**
	 * 根据id获取单个服务接口信息
	 * @param id 服务接口id
	 * @return
	 */
	ResultVo getPubService(String id);

	/**
	 * 根据id获取单个待审批服务接口信息
	 * @param id 服务接口id
	 * @return
	 */
	ResultVo getApprovingPubService(String id);

	/**
	 * 修改服务接口配置信息
	 * @param addPubServiceVo 服务接口vo对象
	 * @return
	 */
	ResultVo updatePubService(AddPubServiceVo addPubServiceVo);

	/**
	 * 批量软删除为发布服务接口
	 * @param ids 多个服务接口id的list集合
	 * @return
	 */
	ResultVo volumeDeletePubService(String ids);

	/**
	 * 发布待审批或审批拒绝
	 * @param id 服务接口ID
	 * @param status 状态：审批中和拒绝
	 * @return
	 */
	ResultVo pubStatus(String id, String status);

	/**
	 * 审核通过，发布服务接口
	 * @param id 服务接口ID
	 * @return
	 */
	ResultVo publishService(String id);

	/**
	 * 启动/停用已发布服务接口
	 * @param id 服务接口ID
	 * @param runStatus 服务接口运行状态
	 * @return
	 */
	ResultVo updateServiceRunStatus(String id, String runStatus);

	/**
	 * 获取接口类型/请求方式
	 * @param typeOrMode 接口类型:interType/请求方式:requeMode
	 * @return
	 */
	ResultVo getTypeOrMode(String typeOrMode);

	/**
	 * 服务接口测试
	 * @param testService 服务接口测试对象
	 * @return
	 */
	ResultVo testService(TestService testService);

	/**
	 * 根据ID查询服务发布任务信息
	 *
	 * @param id 发布ID
	 * @return 任务信息
	 */
	TaskInfo getTaskInfoById(String id);

	ResultVo getMethodName(String url);

	/**
	 * 撤回发布
	 *
	 * @param vo 撤回信息
	 * @return 撤回结果
	 */
	ResultVo withdrawPub(WithdrawPubVo vo);

	/**
	 * 获取可撤回机构列表
	 *
	 * @param pubId 发布ID
	 * @return 机构列表
	 */
	ResultVo getWithdrawOrgList(String pubId);

	void deleteSubByPubIdAndSubOrgId(String pubId, String subOrgId);

	ResultVo updateServiceRunStatusBatch(List<String> ids, String runStatus);

	ResultVo publishServiceBatch(List<String> ids);
}
