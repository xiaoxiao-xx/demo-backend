package com.microcore.center.service.impl;

import java.util.List;

import com.microcore.api.model.*;
import com.microcore.center.client.exchange.ExchangeTemplate;
import com.microcore.center.client.exchange.ProxyServiceInfo;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.service.DbParamsService;
import com.microcore.common.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.api.vo.DbBaseKitVo;
import com.microcore.center.context.VCodeContext;
import com.microcore.center.mapper.DbBaseKitMapper;
import com.microcore.center.mapper.DbDbKitMapper;
import com.microcore.center.mapper.DbFileKitMapper;
import com.microcore.center.mapper.DbLabelKitMapper;
import com.microcore.center.mapper.DbServiceKitMapper;
import com.microcore.center.model.DbBaseKitExample;
import com.microcore.center.service.DbBaseKitService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.DESUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.PasswordUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author whater
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class DbBaseKitServiceImpl implements DbBaseKitService {

	private static final String DB_TAG_TYPE = "DB";
	private static final String DBS_TAG_TYPE = "DBS";
	private static final String SERVICE_TAG_TYPE = "SERVICE";
	private static final String FILE_TAG_TYPE = "FILE";
	private static final String LABEL_TAG_TYPE = "LABEL";
	private static final String POLICY_TAG_TYPE = "POLICY";
	private static final String MASTER_KEY = "AAAAAA";

	@Autowired
	private DbBaseKitMapper baseKitMapper;
	@Autowired
	private DbDbKitMapper dbDbKitMapper;
	@Autowired
	private DbFileKitMapper dbFileKitMapper;
	@Autowired
	private DbServiceKitMapper dbServiceKitMapper;

	@Autowired
	private DbLabelKitMapper dbLabelKitMapper;

	@Autowired
	private DbOrgService dbOrgService;

	@Autowired
	private ExchangeTemplate exchangeTemplate;

	@Autowired
	private DbParamsService dbParamsService;

	@Override
	public ResultVo<?> add(DbBaseKitVo dbBaseKitVo) {
		String orgId = dbBaseKitVo.getOrgId();
		String tagType = dbBaseKitVo.getTagType();
		String ip = dbBaseKitVo.getTagIp();
		String port = dbBaseKitVo.getTagPort();
		if (StringUtil.isEmpty(orgId) || StringUtil.isEmpty(tagType)
				|| StringUtil.isEmpty(ip) || StringUtil.isEmpty(port)) {
			return ResultVo.fail("参数错误");
		}
		tagType = tagType.toUpperCase();
		DbBaseKitVo vo = this.getKitByOrgAndTagType(orgId, tagType);
		if (null != vo) {
			return ResultVo.fail("该机构套件已存在");
		}
		DbBaseKitVo vo1 = this.getKitByIpAndPort(ip, port);
		if (null != vo1) {
			return ResultVo.fail("该套件已注册");
		}
		DbBaseKit baseKit = new DbBaseKit();
		EntityUtils.setCreateInfo(baseKit);
		baseKit.setId(CommonUtil.getUUID());
		baseKit.setOrgId(orgId);
		baseKit.setRunCmd(dbBaseKitVo.getRunCmd());
		baseKit.setStatusCmd(dbBaseKitVo.getStatusCmd());
		baseKit.setTagIp(dbBaseKitVo.getTagIp());
		baseKit.setTagName(dbBaseKitVo.getTagName());
		baseKit.setTagPort(dbBaseKitVo.getTagPort());
		baseKit.setTagType(tagType);
		baseKit.setRemark(dbBaseKitVo.getRemark());

		// 库表套件DB 库表发布为服务套件DBS 文件套件FILE 服务接口套件SERVICE 标签服务套件LABEL
		if (DB_TAG_TYPE.equals(tagType)) {
			DbDbKit dbDbKit = new DbDbKit();
			dbDbKit.setId(baseKit.getId());
			EntityUtils.setCreateInfo(dbDbKit);
			setDbKitValueByBaseKit(dbBaseKitVo, dbDbKit);
			setValueByBaseKit(dbBaseKitVo, dbDbKit);
			dbDbKitMapper.insert(dbDbKit);
		} else if (DBS_TAG_TYPE.equals(tagType)) {

		} else if (SERVICE_TAG_TYPE.equals(tagType)) {
			DbServiceKit kit = new DbServiceKit();
			kit.setId(baseKit.getId());
			EntityUtils.setCreateInfo(kit);
			kit.setExchangeUrl(dbBaseKitVo.getDbServiceKit().getExchangeUrl());
			setValueByBaseKit(dbBaseKitVo, kit);
			String registerResult = registerService(dbBaseKitVo, kit);
			log.info("交换注册结果[{}]", registerResult);
			dbServiceKitMapper.insert(kit);
			/*if ("ok".equals(registerResult)) {
				dbServiceKitMapper.insert(kit);
			}else{
				return ResultVo.fail(registerResult);
			}*/
		} else if (LABEL_TAG_TYPE.equals(tagType)) {
			DbLabelKit kit = new DbLabelKit();
			kit.setId(baseKit.getId());
			EntityUtils.setCreateInfo(kit);
			setValueByBaseKit(dbBaseKitVo, kit);
			dbLabelKitMapper.insert(kit);
		} else if (FILE_TAG_TYPE.equals(tagType)) {
			DbFileKit kit = new DbFileKit();
			kit.setId(baseKit.getId());
			EntityUtils.setCreateInfo(kit);
			setValueByBaseKit(dbBaseKitVo, kit);
			if (dbBaseKitVo.getDbFileKit() != null) {
				DbFileKit dbFileKitVo = dbBaseKitVo.getDbFileKit();
				kit.setMakeDir(dbFileKitVo.getMakeDir());
				kit.setDistillDir(dbFileKitVo.getDistillDir());
				kit.setExchangeDir(dbFileKitVo.getExchangeDir());
				kit.setNotifyDir(dbFileKitVo.getNotifyDir());
				kit.setBackupDir(dbFileKitVo.getBackupDir());
				kit.setFileTransTime(dbFileKitVo.getFileTransTime());
				kit.setTriggerType(dbFileKitVo.getTriggerType());
			}
			dbFileKitMapper.insert(kit);
		} else if (POLICY_TAG_TYPE.equals(tagType)) {

		}
		baseKitMapper.insert(baseKit);
		return ResultVo.ok();
	}

	private String registerService(DbBaseKitVo kit, DbServiceKit dbServiceKit) {
		ProxyServiceInfo serviceInfo = new ProxyServiceInfo();
		serviceInfo.setAgentId(dbServiceKit.getId());
		serviceInfo.setAgentName(kit.getOrgName());
		serviceInfo.setUrl("http://" + kit.getTagIp() + ":" + kit.getTagPort() + "/proxyService");
		serviceInfo.setProxyUrl(kit.getDbServiceKit().getExchangeUrl());
		log.info("交换注册套件==>套件ID:[{}],[{}],[{}]", dbServiceKit.getId(), kit.getOrgName(), kit.getDbServiceKit().getExchangeUrl());
		ResultVo resultVo ;
		try {
			resultVo = exchangeTemplate.registerService(serviceInfo);
		} catch (Exception e) {
			log.info("交换注册套件失败[{}]",e.getMessage());
			return "失败";
		}
		log.info("交换注册套件返回信息" + ((resultVo == null) ? "null" : resultVo.toString()));
		if (resultVo == null || 200 != resultVo.getStatus()) {
			log.info("交换注册套件失败[{}]", dbServiceKit.getId());
			return ((resultVo == null) ? "失败" : resultVo.getMsg());
		}
		return "ok";
	}

	@Override
	public ResultVo<?> update(DbBaseKitVo dbBaseKitVo) {
		ResultVo vo = getBaseKit(dbBaseKitVo);
		if (vo.getStatus() != 200) {
			return vo;
		}
		String id = vo.getData() + "";
		DbBaseKit baseKit = baseKitMapper.selectByPrimaryKey(id);
		String tagType = baseKit.getTagType();

		baseKit.setRunCmd(dbBaseKitVo.getRunCmd());
		baseKit.setStatusCmd(dbBaseKitVo.getStatusCmd());
		baseKit.setTagIp(dbBaseKitVo.getTagIp());
		baseKit.setTagName(dbBaseKitVo.getTagName());
		baseKit.setTagPort(dbBaseKitVo.getTagPort());
		baseKit.setRemark(dbBaseKitVo.getRemark());

		if (DB_TAG_TYPE.equals(tagType)) {
			DbDbKit kit = dbDbKitMapper.selectByPrimaryKey(id);
			setValueByBaseKit(baseKit, kit);
			EntityUtils.setUpdateInfo(kit);
			setDbKitValueByBaseKit(dbBaseKitVo, kit);
			dbDbKitMapper.updateByPrimaryKey(kit);
		} else if (DBS_TAG_TYPE.equals(tagType)) {

		} else if (FILE_TAG_TYPE.equals(tagType)) {
			DbFileKit kit = dbFileKitMapper.selectByPrimaryKey(id);
			setValueByBaseKit(baseKit, kit);
			EntityUtils.setUpdateInfo(kit);

			DbFileKit dbFileKitVo = dbBaseKitVo.getDbFileKit();
			if (dbFileKitVo != null) {
				kit.setMakeDir(dbFileKitVo.getMakeDir());
				kit.setDistillDir(dbFileKitVo.getDistillDir());
				kit.setExchangeDir(dbFileKitVo.getExchangeDir());
				kit.setNotifyDir(dbFileKitVo.getNotifyDir());
				kit.setBackupDir(dbFileKitVo.getBackupDir());
				kit.setFileTransTime(dbFileKitVo.getFileTransTime());
				kit.setTriggerType(dbFileKitVo.getTriggerType());
			}

			dbFileKitMapper.updateByPrimaryKey(kit);
		} else if (SERVICE_TAG_TYPE.equals(tagType)) {
			DbServiceKit kit = dbServiceKitMapper.selectByPrimaryKey(id);
			DbServiceKit dbServiceKitVo = dbBaseKitVo.getDbServiceKit();
			if (null != dbServiceKitVo) {
				kit.setExchangeUrl(dbServiceKitVo.getExchangeUrl());
			}
			setValueByBaseKit(baseKit, kit);
			EntityUtils.setUpdateInfo(kit);
			dbServiceKitMapper.updateByPrimaryKey(kit);
		} else if (LABEL_TAG_TYPE.equals(tagType)) {
			DbLabelKit kit = dbLabelKitMapper.selectByPrimaryKey(id);
			setValueByBaseKit(baseKit, kit);
			EntityUtils.setUpdateInfo(kit);
			dbLabelKitMapper.updateByPrimaryKey(kit);
		}
		EntityUtils.setUpdateInfo(baseKit);
		baseKitMapper.updateByPrimaryKey(baseKit);
		return ResultVo.ok();
	}

	private ResultVo getBaseKit(DbBaseKitVo dbBaseKitVo) {
		String id = dbBaseKitVo.getId();
		if (StringUtil.isEmpty(id)) {
			return ResultVo.fail("套件id不能为空");
		}
		String ip = dbBaseKitVo.getTagIp();
		String port = dbBaseKitVo.getTagPort();
		if (StringUtil.isEmpty(ip) || StringUtil.isEmpty(port)) {
			return ResultVo.fail("ip及端口不能为空");
		}
		DbBaseKitVo vo = this.getKitByIpAndPort(ip, port);
		if (null != vo && !vo.getId().equals(id)) {
			return ResultVo.fail("套件地址已存在");
		}
		return ResultVo.ok(id);
	}

	@Override
	public ResultVo<?> delete(String id) {
		DbBaseKit dbBaseKit = baseKitMapper.selectByPrimaryKey(id);
		String tagType = dbBaseKit.getTagType();
		baseKitMapper.deleteByPrimaryKey(id);
		if (DB_TAG_TYPE.equals(tagType)) {
			dbDbKitMapper.deleteByPrimaryKey(id);
		} else if (DBS_TAG_TYPE.equals(tagType)) {

		} else if (FILE_TAG_TYPE.equals(tagType)) {
			dbFileKitMapper.deleteByPrimaryKey(id);
		} else if (SERVICE_TAG_TYPE.equals(tagType)) {
			dbServiceKitMapper.deleteByPrimaryKey(id);
		} else if (LABEL_TAG_TYPE.equals(tagType)) {
			dbLabelKitMapper.deleteByPrimaryKey(id);
		}
		return ResultVo.ok();
	}

	@Override
	public ResultVo<?> cleanMAC(String id) {
		DbBaseKit dbBaseKit = baseKitMapper.selectByPrimaryKey(id);
		String tagType = dbBaseKit.getTagType();
		dbBaseKit.setMacAddress(null);
		baseKitMapper.updateByPrimaryKey(dbBaseKit);
		if (DB_TAG_TYPE.equals(tagType)) {
			DbDbKit kit = dbDbKitMapper.selectByPrimaryKey(id);
			kit.setMacAddress(null);
			dbDbKitMapper.updateByPrimaryKey(kit);
		} else if (DBS_TAG_TYPE.equals(tagType)) {

		} else if (FILE_TAG_TYPE.equals(tagType)) {
			DbFileKit kit = dbFileKitMapper.selectByPrimaryKey(id);
			kit.setMacAddress(null);
			dbFileKitMapper.updateByPrimaryKey(kit);
		} else if (SERVICE_TAG_TYPE.equals(tagType)) {
			DbServiceKit kit = dbServiceKitMapper.selectByPrimaryKey(id);
			kit.setMacAddress(null);
			dbServiceKitMapper.updateByPrimaryKey(kit);
		} else if (LABEL_TAG_TYPE.equals(tagType)) {
			DbLabelKit kit = dbLabelKitMapper.selectByPrimaryKey(id);
			kit.setMacAddress(null);
			dbLabelKitMapper.updateByPrimaryKey(kit);
		}
		return ResultVo.ok();
	}

	@Override
	public ResultVo<?> getVCode(String id) {
		DbBaseKit dbBaseKit = baseKitMapper.selectByPrimaryKey(id);
		if (dbBaseKit == null) {
			return ResultVo.fail("数据ID非法！");
		}
		String vCode = VCodeContext.addVCodeInfo(id);
		return ResultVo.ok(vCode);
	}

	@Override
	public ResultVo<?> startKit(DbBaseKitVo dbLabelKitVo) {
		String macAddress = dbLabelKitVo.getMacAddress();
		String tagIp = dbLabelKitVo.getTagIp();
		String tagPort = dbLabelKitVo.getTagPort();
		String vCode = dbLabelKitVo.getVcode();

		DbBaseKitVo dbBaseKitVo = getKitByIpAndPort(tagIp, tagPort);
		if (dbBaseKitVo == null) {
			return ResultVo.fail("请先到平台登记套件信息！");
		}
		DbOrg org = dbOrgService.getDbOrgByOrgId(dbBaseKitVo.getOrgId());
		dbBaseKitVo.setCurrentOrgSort(org.getOrgSort());
		if (StringUtil.isEmpty(dbBaseKitVo.getMacAddress())) {
			String value = dbParamsService.getParamsValueByTypeAndKey("master_key", "master_key");
			if (Constants.YES.equals(value) && MASTER_KEY.equals(vCode)) {
				setMacAddress(dbBaseKitVo.getId(), macAddress);
			} else if (VCodeContext.verifyVCode(dbBaseKitVo.getId(), vCode)) {
				setMacAddress(dbBaseKitVo.getId(), macAddress);
			} else {
				return ResultVo.fail("验证码错误！");
			}
		} else {
			if (!dbBaseKitVo.getMacAddress().equals(macAddress)) {
				return ResultVo.fail("设备已经绑定！");
			}
		}
		return ResultVo.ok(dbBaseKitVo);
	}

	private void setMacAddress(String id, String macAddress) {
		DbBaseKit baseKit = baseKitMapper.selectByPrimaryKey(id);
		String tagType = baseKit.getTagType();
		baseKit.setMacAddress(macAddress);
		if (DB_TAG_TYPE.equals(tagType)) {
			DbDbKit kit = dbDbKitMapper.selectByPrimaryKey(id);
			kit.setMacAddress(macAddress);
			EntityUtils.setUpdateInfo(kit);
			dbDbKitMapper.updateByPrimaryKey(kit);
		} else if (DBS_TAG_TYPE.equals(tagType)) {

		} else if (FILE_TAG_TYPE.equals(tagType)) {
			DbFileKit kit = dbFileKitMapper.selectByPrimaryKey(id);
			EntityUtils.setUpdateInfo(kit);
			kit.setMacAddress(macAddress);
			dbFileKitMapper.updateByPrimaryKey(kit);
		} else if (SERVICE_TAG_TYPE.equals(tagType)) {
			DbServiceKit kit = dbServiceKitMapper.selectByPrimaryKey(id);
			EntityUtils.setUpdateInfo(kit);
			kit.setMacAddress(macAddress);
			dbServiceKitMapper.updateByPrimaryKey(kit);
		} else if (LABEL_TAG_TYPE.equals(tagType)) {
			DbLabelKit kit = dbLabelKitMapper.selectByPrimaryKey(id);
			EntityUtils.setUpdateInfo(kit);
			kit.setMacAddress(macAddress);
			dbLabelKitMapper.updateByPrimaryKey(kit);
		}
		EntityUtils.setUpdateInfo(baseKit);
		baseKitMapper.updateByPrimaryKey(baseKit);
	}

	/**
	 * 根据机构ID和套件类型获取套件信息
	 *
	 * @param orgId   结构ID
	 * @param tagType 套件类型
	 * @return 套件信息
	 */
	@Override
	public DbBaseKitVo getKitByOrgAndTagType(String orgId, String tagType) {
		DbBaseKitExample example = new DbBaseKitExample();
		DbBaseKitExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		criteria.andTagTypeEqualTo(tagType.toUpperCase());
		criteria.andDelStatusEqualTo("NOR");
		List<DbBaseKit> list = baseKitMapper.selectByExample(example);
		if (!CommonUtil.isEmpty(list)) {
			DbBaseKit dbBaseKit = list.get(0);
			return dbBaseKit2Vo(dbBaseKit);
		}
		return null;
	}

	/**
	 * 根据机构IP和端口获取套件信息
	 *
	 * @param ip   IP地址
	 * @param port 端口
	 * @return 套件信息
	 */
	@Override
	public DbBaseKitVo getKitByIpAndPort(String ip, String port) {
		DbBaseKitExample example = new DbBaseKitExample();
		DbBaseKitExample.Criteria criteria = example.createCriteria();
		criteria.andTagIpEqualTo(ip);
		criteria.andTagPortEqualTo(port);
		criteria.andDelStatusEqualTo("NOR");
		List<DbBaseKit> list = baseKitMapper.selectByExample(example);
		if (!CommonUtil.isEmpty(list)) {
			DbBaseKit dbBaseKit = list.get(0);
			return dbBaseKit2Vo(dbBaseKit);
		}
		return null;
	}

	private DbBaseKitVo dbBaseKit2Vo(DbBaseKit dbBaseKit) {
		String id = dbBaseKit.getId();
		String tagType = dbBaseKit.getTagType();
		DbBaseKitVo vo = CommonUtil.po2VO(dbBaseKit, DbBaseKitVo.class);
		if (DB_TAG_TYPE.equals(tagType)) {
			DbDbKit kit = dbDbKitMapper.selectByPrimaryKey(id);
			vo.setDbDbKit(kit);
		} else if (DBS_TAG_TYPE.equals(tagType)) {

		} else if (FILE_TAG_TYPE.equals(tagType)) {
			DbFileKit kit = dbFileKitMapper.selectByPrimaryKey(id);
			vo.setDbFileKit(kit);
		} else if (SERVICE_TAG_TYPE.equals(tagType)) {
			DbServiceKit kit = dbServiceKitMapper.selectByPrimaryKey(id);
			vo.setDbServiceKit(kit);
		} else if (LABEL_TAG_TYPE.equals(tagType)) {
			DbLabelKit kit = dbLabelKitMapper.selectByPrimaryKey(id);
			vo.setDbLabelKit(kit);
		} else if (POLICY_TAG_TYPE.equals(tagType)) {

		}
		return vo;
	}

	private void setDbKitValueByBaseKit(DbBaseKitVo dbBaseKitVo, DbDbKit dbDbKit) {
		DbDbKit dbDbKitVo = dbBaseKitVo.getDbDbKit();
		if (dbDbKitVo != null) {
			dbDbKit.setMakeDbName(dbDbKitVo.getMakeDbName());
			dbDbKit.setMakeDbType(dbDbKitVo.getMakeDbType());
			dbDbKit.setMakeIp(dbDbKitVo.getMakeIp());

			String makePassword = null;
			try {
				makePassword = DESUtil.decryptor(dbDbKitVo.getMakePassword());
				if (!PasswordUtil.isEncrypted(makePassword)) {
					makePassword = PasswordUtil.encrypt(makePassword);
				}
			} catch (Exception e) {
				log.error("更新套件信息打标密码异常[{}]", e.getMessage());
			}

			dbDbKit.setMakePassword(makePassword);
			dbDbKit.setMakePort(dbDbKitVo.getMakePort());
			dbDbKit.setMakeUrl(dbDbKitVo.getMakeUrl());
			dbDbKit.setMakeUserName(dbDbKitVo.getMakeUserName());

			dbDbKit.setDistillDbName(dbDbKitVo.getDistillDbName());
			dbDbKit.setDistillDbType(dbDbKitVo.getDistillDbType());
			dbDbKit.setDistillIp(dbDbKitVo.getDistillIp());

			String distillPassword = null;
			try {
				distillPassword = DESUtil.decryptor(dbDbKitVo.getDistillPassword());
				if (!PasswordUtil.isEncrypted(distillPassword)) {
					distillPassword = PasswordUtil.encrypt(distillPassword);
				}
			} catch (Exception e) {
				log.error("更新套件信息脱标密码异常[{}]", e.getMessage());
			}
			dbDbKit.setDistillPassword(distillPassword);
			dbDbKit.setDistillPort(dbDbKitVo.getDistillPort());
			dbDbKit.setDistillUrl(dbDbKitVo.getDistillUrl());
			dbDbKit.setDistillUserName(dbDbKitVo.getDistillUserName());
		}
	}

	private <T> void setValueByBaseKit(DbBaseKit dbBaseKit, T t) {
		if (t instanceof DbDbKit) {
			DbDbKit kit = (DbDbKit) t;
			kit.setOrgId(dbBaseKit.getOrgId());
			kit.setTagIp(dbBaseKit.getTagIp());
			kit.setTagName(dbBaseKit.getTagName());
			kit.setTagPort(dbBaseKit.getTagPort());
			kit.setMacAddress(dbBaseKit.getMacAddress());
			kit.setTagType(dbBaseKit.getTagType());
			kit.setRemark(dbBaseKit.getRemark());
			kit.setRunCmd(dbBaseKit.getRunCmd());
			kit.setKillCmd(dbBaseKit.getStatusCmd());
		} else if (t instanceof DbFileKit) {
			DbFileKit kit = (DbFileKit) t;
			kit.setOrgId(dbBaseKit.getOrgId());
			kit.setTagIp(dbBaseKit.getTagIp());
			kit.setTagName(dbBaseKit.getTagName());
			kit.setTagPort(dbBaseKit.getTagPort());
			kit.setMacAddress(dbBaseKit.getMacAddress());
			kit.setTagType(dbBaseKit.getTagType());
			kit.setTagDesc(dbBaseKit.getRemark());
			kit.setRunCmd(dbBaseKit.getRunCmd());
			kit.setKillCmd(dbBaseKit.getStatusCmd());
		} else if (t instanceof DbLabelKit) {
			DbLabelKit kit = (DbLabelKit) t;
			kit.setOrgId(dbBaseKit.getOrgId());
			kit.setTagIp(dbBaseKit.getTagIp());
			kit.setTagName(dbBaseKit.getTagName());
			kit.setTagPort(dbBaseKit.getTagPort());
			kit.setMacAddress(dbBaseKit.getMacAddress());
			kit.setTagType(dbBaseKit.getTagType());
			kit.setRemark(dbBaseKit.getRemark());
			kit.setRunCmd(dbBaseKit.getRunCmd());
			kit.setKillCmd(dbBaseKit.getStatusCmd());
		} else if (t instanceof DbServiceKit) {
			DbServiceKit kit = (DbServiceKit) t;
			kit.setOrgId(dbBaseKit.getOrgId());
			kit.setTagIp(dbBaseKit.getTagIp());
			kit.setOrgId(dbBaseKit.getOrgId());
			kit.setStatus("STOP");
			kit.setTagName(dbBaseKit.getTagName());
			kit.setTagPort(dbBaseKit.getTagPort());
			kit.setMacAddress(dbBaseKit.getMacAddress());
			kit.setTagType(dbBaseKit.getTagType());
			kit.setRemark(dbBaseKit.getRemark());
			kit.setRunCmd(dbBaseKit.getRunCmd());
			kit.setKillCmd(dbBaseKit.getStatusCmd());
		}
	}

	@Override
	public DbBaseKitVo getKitByKitId(String kitId) {
		if (StringUtil.isEmpty(kitId)) {
			return null;
		}
		DbBaseKit baseKit = baseKitMapper.selectByPrimaryKey(kitId);
		if (null == baseKit) {
			return null;
		}
		return dbBaseKit2Vo(baseKit);
	}

}
