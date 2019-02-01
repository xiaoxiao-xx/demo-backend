package com.microcore.center.service;

import com.microcore.api.vo.DbBaseKitVo;
import com.microcore.common.util.ResultVo;

/**
 * @author whater
 */
public interface DbBaseKitService {

	ResultVo<?> add(DbBaseKitVo dbLabelKit);

	ResultVo<?> update(DbBaseKitVo dbLabelKit);

	ResultVo<?> delete(String id);

	ResultVo<?> cleanMAC(String id);

	ResultVo<?> getVCode(String id);

	ResultVo<?> startKit(DbBaseKitVo dbLabelKitVo);

	/**
	 * 根据机构ID和套件类型获取套件信息
	 *
	 * @param orgId   结构ID
	 * @param tagType 套件类型
	 * @return 套件信息
	 */
	DbBaseKitVo getKitByOrgAndTagType(String orgId, String tagType);

	/**
	 * 根据机构IP和端口获取套件信息
	 *
	 * @param ip   IP地址
	 * @param port 端口
	 * @return 套件信息
	 */
	DbBaseKitVo getKitByIpAndPort(String ip, String port);

	DbBaseKitVo getKitByKitId(String kitId);

}
