package com.microcore.center.service;

import com.microcore.api.model.DbServiceKit;
import com.microcore.center.dto.DbServiceKitDto;
import com.microcore.center.vo.ServiceKitVo;
import com.microcore.common.util.ResultVo;

/**
 * 服务接口套件管理
 *
 * @author 何语非
 */
public interface DbServiceKitService {

	/**
	 * 新增服务接口套件
	 *
	 * @param dbServiceKitDto 服务接口套件Dto对象
	 * @return
	 */
	ResultVo addServiceKit(DbServiceKitDto dbServiceKitDto);

	/**
	 * 修改服务接口套件信息
	 *
	 * @param dbServiceKitDto 服务接口套件Dto对象
	 * @return
	 */
	ResultVo updateServiceKit(DbServiceKitDto dbServiceKitDto);

	/**
	 * 获取服务接口套件机构ID列表
	 *
	 * @return
	 */
	ResultVo getServiceKitOrgs();

	/**
	 * 根据机构ID获取该机构服务接口套件信息
	 *
	 * @param id 机构ID
	 * @return
	 */
	DbServiceKit getServiceKit(String id);

	/**
	 * 根据服务接口套件ID获取验证码
	 *
	 * @param id 服务接口套件ID
	 * @return
	 */
	ResultVo getVcode(String id);

	/**
	 * 根据服务接口套件ID解绑Mac地址
	 *
	 * @param id 服务接口套件ID
	 * @return
	 */
	ResultVo unbindMacAddress(String id);

	/**
	 * 设置macAddress
	 *
	 * @param id         服务接口套件ID
	 * @param macAddress mac地址
	 */
	void setMacAddress(String id, String macAddress);

	/**
	 * 服务接口套件启动时上传信息并验证
	 *
	 * @param dbServiceKitVo 服务接口套件vo对象
	 * @return
	 */
	ResultVo authDbServiceInfo(ServiceKitVo dbServiceKitVo);

	/**
	 * 根据服务接口套件IP和端口查询套件信息
	 *
	 * @param ip   服务接口套件IP
	 * @param port 服务接口套件端口
	 * @return
	 */
	DbServiceKit selectByIpAndPort(String ip, String port);

	/**
	 * 获取当前用户所在机构的对应的套件ID
	 *
	 * @return
	 */
	String getCurrentUsersServiceKitId();

	/**
	 * 获取当前用户所在机构的对应的套件信息
	 *
	 * @return
	 */
	DbServiceKit getCurrentUsersDbKit();

}
