package com.microcore.center.client;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microcore.api.model.DbServiceKit;
import com.microcore.center.dto.DbPubServiceDto;
import com.microcore.center.model.DbSubService;
import com.microcore.center.service.DbServiceKitService;
import com.microcore.center.vo.DbSubServiceVO;
import com.microcore.center.vo.ParamsService;
import com.microcore.center.vo.RunStatusVo;
import com.microcore.center.vo.TestService;
import com.microcore.common.dto.SubDelDto;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.SendUtil;
import com.microcore.common.vo.WithdrawPubVo;

/**
 * @author
 */
@Component
public class ServiceKitTemplate {

	private final SendUtil sendUtil;

	private final DbServiceKitService dbServiceKitService;

	@Autowired
	public ServiceKitTemplate(SendUtil sendUtil, DbServiceKitService dbServiceKitService) {
		this.sendUtil = sendUtil;
		this.dbServiceKitService = dbServiceKitService;
	}

	private ResultVo callKitService(String serviceUrl, Object param) {
		String kitId = dbServiceKitService.getCurrentUsersServiceKitId();
		return sendUtil.sendKitService(kitId, serviceUrl, param);
	}

	/**
	 * 服务接口测试
	 *
	 * @param testService
	 * @return
	 */
	public ResultVo testService(TestService testService) {
		return callKitService("/useService/testService", testService);
	}

	/**
	 * 服务接口发布信息下发至当前节点服务器
	 *
	 * @param dbPubServiceDto
	 * @return
	 */
	public ResultVo addService(DbPubServiceDto dbPubServiceDto) {
		return callKitService("/dbPubService/addService", dbPubServiceDto);
	}

	/**
	 * 服务接口运行状态更改下发当前节点服务器
	 *
	 * @param id        服务接口发布ID
	 * @param runStatus 服务接口运行状态
	 * @return
	 */
	public ResultVo updateRunStatus(String id, String runStatus) {
		RunStatusVo runStatusVo = new RunStatusVo(id, runStatus);
		return callKitService("/dbPubService/updateRunStatus", runStatusVo);
	}

	/**
	 * 服务接口申请下发发布方节点
	 *
	 * @param dbSubService 服务接口申请对象
	 * @return
	 */
	public ResultVo examineSubService(DbSubService dbSubService) {
		/*return restTemplate
				.postForEntity("http://" + dbSubService.getProxyIp() + ":" + dbSubService.getProxyPort() + "/jointSubService/examineSubService",
						dbSubService, ResultVo.class).getBody();*/
		//获取发布方套件信息
//		DbServiceKit dbServiceKit = dbServiceKitService.selectByIpAndPort(dbSubService.getProxyIp(), dbSubService.getProxyPort().toString());
		DbServiceKit dbServiceKit = dbServiceKitService.getServiceKit(dbSubService.getCrtOrgId());
		if (Objects.isNull(dbServiceKit)) {
			return ResultVo.fail("发布方套件信息未找到");
		}
		sendUtil.send(dbServiceKit.getId(), "/dbSubService/examineSubService", dbSubService);
		return ResultVo.ok();
	}

	/**
	 * 服务接口申请下发需求方节点
	 *
	 * @param dbSubServiceVO 服务接口申请对象
	 * @return
	 */
	public void subService(DbSubServiceVO dbSubServiceVO) {
		//获取需求方套件信息
		DbServiceKit dbServiceKit = dbServiceKitService.getServiceKit(CommonUtil.getOrgId());
		if (Objects.isNull(dbServiceKit)) {
			throw new RuntimeException("需求方套件信息未找到");
		}
		sendUtil.send(dbServiceKit.getId(), "/dbSubService/subService", dbSubServiceVO);
	}

	/**
	 * delService:(发布方需求方删除订阅信息). <br/>
	 *
	 * @param dbSubService
	 * @author whater
	 * @since JDK 1.8
	 */
	public void delService(DbSubService dbSubService) {
		//获取发布方套件信息
		DbServiceKit pubServiceKit = dbServiceKitService.getServiceKit(CommonUtil.getOrgId());
		if (Objects.isNull(pubServiceKit)) {
			throw new RuntimeException("需求方套件信息未找到");
		}
		DbServiceKit subServiceKit = dbServiceKitService.getServiceKit(dbSubService.getCrtOrgId());
		if (Objects.isNull(subServiceKit)) {
			throw new RuntimeException("发布方套件信息未找到");
		}
		sendUtil.send(pubServiceKit.getId(), "/dbSubService/deleteSubService", dbSubService.getId());

		sendUtil.send(subServiceKit.getId(), "/dbSubService/deleteSubService", dbSubService.getId());

	}

	private String getKitId() {
		return dbServiceKitService.getServiceKit(CommonUtil.getOrgId()).getId();
	}

	/**
	 * 订阅服务接口测试
	 *
	 * @param paramsService
	 * @return
	 */
	public ResultVo subTestService(ParamsService paramsService) {
		return callKitService("/proxyService", paramsService);
	}

	public void withdrawPub(WithdrawPubVo vo) {
		callKitService("/dbPubService/withdrawPub", vo);
	}

	public void deleteSubByPubIdAndSubOrgId(String pubId, String subOrgId) {
		sendUtil.send(subOrgId, "/dbSubService/deleteSubByPubIdAndSubOrgId", new SubDelDto(pubId, subOrgId));
	}

//	/**
//	 * 下发到当前节点服务器POST请求
//	 * @param serviceURL
//	 * @param param
//	 * @param t
//	 * @return
//	 */
//	private <T> T servicePost(String serviceURL, Object param, Class<T> t) {
//		return restTemplate
//				.postForEntity("http://" + serviceKitIp + ":" + serviceKitPort + serviceURL, param, t)
//				.getBody();
//	}

//	 /**
//	 * 下发到当前节点服务器GET请求
//	 * @param serviceURL
//	 * @param t
//	 * @return
//	 */
//	private <T> T serviceGet(String serviceURL, Class<T> t) {
//		return restTemplate
//				.getForEntity("http://" + serviceKitIp + ":" + serviceKitPort + serviceURL, t)
//				.getBody();
//	}

}
