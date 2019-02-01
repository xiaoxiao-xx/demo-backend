package com.microcore.center.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.api.SysApi;
import com.microcore.api.model.DbFileKit;
import com.microcore.api.model.DbLabelKit;
import com.microcore.center.client.FileKitTemplate;
import com.microcore.center.context.VCodeContext;
import com.microcore.center.dto.DbFileKitDto;
import com.microcore.center.mapper.DbFileKitMapper;
import com.microcore.center.model.DbFileKitExample;
import com.microcore.center.service.DbFileKitService;
import com.microcore.center.service.DbLabelKitService;
import com.microcore.center.util.CheckingUtil;
import com.microcore.center.vo.DbFileKitVo;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;

import lombok.extern.slf4j.Slf4j;

/**
 */
@Service
@Transactional
@Slf4j
public class DbFileKitServiceImpl implements DbFileKitService {

	@Autowired
	private DbFileKitMapper dbFileKitMapper;

	@Autowired
	private DbLabelKitService dbLabelKitService;

	/**
	 * 新增套件
	 */
	@Override
	public ResultVo addDbFileKit(DbFileKitDto dbFileKitDto) {
		if (dbFileKitDto == null) {
			return ResultVo.fail("新增不能为空！");
		}
		String tagIp = dbFileKitDto.getTagIp();
		String tagPort = dbFileKitDto.getTagPort();
		String makkeDir = dbFileKitDto.getMakeDir();
		String distillDir = dbFileKitDto.getDistillDir();
		if (StringUtil.isEmpty(tagIp) || !CheckingUtil.checkingIp(tagIp)) {
			return ResultVo.fail("IP错误！");
		}
		if (StringUtil.isEmpty(tagPort) || !CheckingUtil.checkingPort(tagPort)) {
			return ResultVo.fail("端口错误！");
		}
		if (StringUtil.isEmpty(makkeDir) || !CheckingUtil.checkingPath(makkeDir)) {
			return ResultVo.fail("打标路径不规范！");
		}
		if (StringUtil.isNotEmpty(distillDir) && CheckingUtil.checkingPath(distillDir)) {
			DbFileKit dbFileKit = new DbFileKit();
			// 前台赋值
			dbFileKit.setOrgId(dbFileKitDto.getOrgId());
			dbFileKit.setTagName(dbFileKitDto.getTagName());
			dbFileKit.setMakeDir(makkeDir);
			dbFileKit.setTagIp(dbFileKitDto.getTagIp());
			dbFileKit.setTagPort(dbFileKitDto.getTagPort());
			dbFileKit.setDistillDir(distillDir);
			dbFileKit.setExchangeDir(dbFileKitDto.getExchangeDir());
			dbFileKit.setNotifyDir(dbFileKitDto.getNotifyDir());
			dbFileKit.setBackupDir(dbFileKitDto.getBackupDir());
			dbFileKit.setTriggerType(dbFileKitDto.getTriggerType());
			dbFileKit.setFileTransTime(dbFileKitDto.getFileTransTime());
			dbFileKit.setTagDesc(dbFileKitDto.getTagDesc());
			dbFileKit.setStatus(dbFileKitDto.getStatus());
			// 后台赋值
			DbLabelKit dbLabelKit = dbLabelKitService.getDbLabelKitByOrgId(dbFileKitDto.getOrgId());
			if (dbLabelKit == null) {
				return ResultVo.fail("标签套件错误！");
			}
			dbFileKit.setLabelId(dbLabelKit.getId());
			dbFileKit.setTagType("FILE");
			dbFileKit.setId(checkId(CommonUtil.getUUID()));
			dbFileKit.setDelStatus("NOR");
			dbFileKit.setCrtUserId(UserUtil.getUserId());
			dbFileKit.setCrtOrgId(UserUtil.getOrgId());
			dbFileKit.setCrtTm(CommonUtil.getSystemDate());
			dbFileKitMapper.insert(dbFileKit);
			return ResultVo.ok("新增成功！");
		} else {
			return ResultVo.fail("脱标路径不规范！");
		}
	}

	public String checkId(String kid) {
		DbFileKit dbFileKit = dbFileKit(kid);
		if (dbFileKit != null) {
			kid = CommonUtil.getUUID();
			return checkId(kid);
		}
		return kid;
	}

	/**
	 * 修改套件
	 */
	@Override
	public ResultVo updDbFileKit(DbFileKitDto dbFileKitDto) {
		String tagIp = dbFileKitDto.getTagIp();
		String tagPort = dbFileKitDto.getTagPort();
		String makkeDir = dbFileKitDto.getMakeDir();
		String distillDir = dbFileKitDto.getDistillDir();
		if (dbFileKitDto.getId() == null) {
			return ResultVo.fail("套件ID为空！");
		}
		DbFileKit dbFileKit = dbFileKit(dbFileKitDto.getId());
		if (StringUtil.isEmpty(tagIp)) {// || !CheckingUtil.checkingIp(tagIp)
			return ResultVo.fail("IP错误！");
		}
		if (StringUtil.isEmpty(tagPort) || !CheckingUtil.checkingPort(tagPort)) {
			return ResultVo.fail("端口错误！");
		}
		if (StringUtil.isEmpty(makkeDir) || !CheckingUtil.checkingPath(makkeDir)) {
			return ResultVo.fail("打标路径不规范！");
		}
		if (StringUtil.isEmpty(distillDir) || !CheckingUtil.checkingPath(distillDir)) {
			return ResultVo.fail("脱标路径不规范！");
		}
		if (dbFileKit == null) {
			return ResultVo.fail("该套件不存在！");
		}
		if ("RUN".equals(dbFileKit.getStatus())) {
			return ResultVo.fail("启用状态不能修改！");
		} else {
			// 前台赋值
			dbFileKit.setTagName(dbFileKitDto.getTagName());
			dbFileKit.setTagType(dbFileKitDto.getTagType());
			dbFileKit.setTagIp(dbFileKitDto.getTagIp());
			dbFileKit.setTagPort(dbFileKitDto.getTagPort());
			dbFileKit.setMacAddress(dbFileKitDto.getMacAddress());
			dbFileKit.setMakeDir(makkeDir);
			dbFileKit.setDistillDir(distillDir);
			dbFileKit.setExchangeDir(dbFileKitDto.getExchangeDir());
			dbFileKit.setNotifyDir(dbFileKitDto.getNotifyDir());
			dbFileKit.setBackupDir(dbFileKitDto.getBackupDir());
			dbFileKit.setTriggerType(dbFileKitDto.getTriggerType());
			dbFileKit.setFileTransTime(dbFileKitDto.getFileTransTime());
			dbFileKit.setTagDesc(dbFileKitDto.getTagDesc());
			if (StringUtil.isNotEmpty(dbFileKitDto.getExchangeId())) {
				dbFileKit.setExchangeId(dbFileKitDto.getExchangeId());
			}
			// 后台赋值
			dbFileKit.setUpdUserId(UserUtil.getUserId());
			dbFileKit.setUpdOrgId(UserUtil.getOrgId());
			dbFileKit.setUpdTm(CommonUtil.getSystemDate());
			dbFileKitMapper.updateByPrimaryKeySelective(dbFileKit);
			return ResultVo.ok("修改成功！");
		}
	}

	/**
	 */
	@Override
	public ResultVo clearMAC(DbFileKitDto dbFileKitDto) {
		if (dbFileKitDto.getId() == null) {
			return ResultVo.fail("套件ID为空！");
		}

		DbFileKit dbFileKit = dbFileKit(dbFileKitDto.getId());
		if (dbFileKit == null) {
			return ResultVo.fail("该套件不存在！");
		} else {
			dbFileKit.setMacAddress("");
			dbFileKitMapper.updateByPrimaryKeySelective(dbFileKit);
			return ResultVo.ok("清除成功！");
		}
	}

	/**
	 * 删除套件
	 */
	@Override
	public ResultVo delDbFileKit(String kid) {
		if (kid == null) {
			return ResultVo.fail("套件ID为空！");
		}

		DbFileKit dbFileKit = dbFileKit(kid);
		if (dbFileKit == null) {
			return ResultVo.fail("该套件不存在！");
		}

		if (!"RUN".equals(dbFileKit.getStatus())) {
			dbFileKit.setDelStatus("DEL");
			dbFileKitMapper.updateByPrimaryKeySelective(dbFileKit);
			return ResultVo.ok("删除成功！");
		} else {
			return ResultVo.fail("启用状态不能删除！");
		}
	}

	@Override
	public ResultVo startDbFileKit(String kid) {
		if (kid == null) {
			return ResultVo.fail("套件ID为空！");
		}
		DbFileKit dbFileKit = dbFileKit(kid);
		if (dbFileKit == null) {
			return ResultVo.fail("该套件不存在！");
		}
		if ("RUN".equals(dbFileKit.getStatus())) {
			dbFileKit.setStatus("STOP");
			dbFileKitMapper.updateByPrimaryKeySelective(dbFileKit);
			return ResultVo.ok("禁用成功！");
		} else if ("STOP".equals(dbFileKit.getStatus())) {
			dbFileKit.setStatus("RUN");
			dbFileKitMapper.updateByPrimaryKeySelective(dbFileKit);
			return ResultVo.ok("启动成功！");
		} else {
			return ResultVo.fail("该套件处于异常状态,操作失败！");
		}
	}

	@Autowired
	private FileKitTemplate fileKitTemplate;
	@Autowired
	private SysApi sysApi ;
	
	@Override
	public ResultVo getDbFileKitByOrgId(String orgId) {
		DbFileKitExample example = new DbFileKitExample();
		DbFileKitExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		criteria.andDelStatusNotEqualTo("DEL");
		List<DbFileKit> dbFileKits = null;
		dbFileKits = dbFileKitMapper.selectByExample(example);
		if (CommonUtil.isEmpty(dbFileKits)) {
			return ResultVo.ok(dbFileKits);
		}
		DbFileKitDto dbFileKitDto = CommonUtil.po2VO(dbFileKits.get(0), DbFileKitDto.class);
		if (dbFileKitDto != null && StringUtil.isNotEmpty(dbFileKitDto.getId())) {
			ResultVo resultVo = sysApi.isTagRun(orgId, "file");
			if(resultVo.getStatus() == 200) {
				if("true".equals(resultVo.getData()+"")) {
					ResultVo vo = fileKitTemplate.fileServiceRPC("/kit/getFileSpace", null, dbFileKitDto.getId());
					if (vo != null && vo.getStatus() == 200) {
						dbFileKitDto.setSpaceInfo(vo.getData());
					}
				}
			}
		}
		return ResultVo.ok(dbFileKitDto);
	}

	@Override
	public DbFileKit getDbFileKitByOrg() {
		String orgId = UserUtil.getOrgId();
		DbFileKitExample example = new DbFileKitExample();
		DbFileKitExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		criteria.andDelStatusNotEqualTo("DEL");
		List<DbFileKit> dbFileKits = dbFileKitMapper.selectByExample(example);
		if (CommonUtil.isEmpty(dbFileKits)) {
			return null;
		}
		return dbFileKits.get(0);
	}
	
	/**
	 * 获取验证码
	 */
	@Override
	public ResultVo getVCode(String fid) {
		return ResultVo.ok(VCodeContext.addVCodeInfo(fid));
	}

	/**
	 * 验证套件信息
	 */
	@Override
	public ResultVo contrast(DbFileKitVo dbFileKitVo) {
		String kitIp = dbFileKitVo.getTagIp();
		String kitPort = dbFileKitVo.getTagPort();
		String macAddr = dbFileKitVo.getMacAddress();
		String verificationCode = dbFileKitVo.getVerificationCode();

		DbFileKit dbFileKit = getByIp(kitIp, kitPort);
		if (dbFileKit == null) {
			return ResultVo.fail("请先注册套件信息");
		}

		String id = dbFileKit.getId();
		String macAddrInService = dbFileKit.getMacAddress();
		// 第一次验证
		if (StringUtil.isEmpty(macAddrInService)) {
			// 验证码
			// TODO 删除下面一行
			VCodeContext.addVCodeInfo(id, verificationCode);

			if (VCodeContext.verifyVCode(id, verificationCode)) {
				dbFileKit.setMacAddress(macAddr);
				try {
					dbFileKitMapper.updateByPrimaryKeySelective(dbFileKit);
				} catch (Exception e) {
					log.warn(e.getMessage());
					return ResultVo.fail("MAC地址新增失败！");
				}
				return ResultVo.ok(dbFileKit);
			} else {
				return ResultVo.fail("验证码不匹配");
			}
		} else {
			if (macAddrInService.equals(macAddr)) {
				return ResultVo.ok(CommonUtil.po2VO(dbFileKit, DbFileKitDto.class));
			} else {
				return ResultVo.fail("MAC地址不匹配");
			}
		}
	}

	@Override
	public String getPathDir(String orgId, String pathType) {
		DbFileKitExample example = new DbFileKitExample();
		DbFileKitExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		criteria.andDelStatusNotEqualTo("DEL");
		List<DbFileKit> dbFileKits = dbFileKitMapper.selectByExample(example);
		if (CommonUtil.isEmpty(dbFileKits)) {
			return null;
		}
		DbFileKit dbFileKit = dbFileKits.get(0);
		String dir = "";
		switch (pathType) {
			case "makeDir":
				dir = dbFileKit.getMakeDir();
				break;
			case "distillDir":
				dir = dbFileKit.getDistillDir();
				break;
			case "exchangeDir":
				dir = dbFileKit.getExchangeDir();
				break;
			case "notifyDir":
				dir = dbFileKit.getNotifyDir();
				break;
			case "backupDir":
				dir = dbFileKit.getBackupDir();
				break;
			default:
				break;
		}
		return dir;
	}

	public DbFileKit getByIp(String ip, String port) {
		DbFileKitExample example = new DbFileKitExample();
		DbFileKitExample.Criteria criteria = example.createCriteria();
		criteria.andTagIpEqualTo(ip);
		criteria.andTagPortEqualTo(port);
		criteria.andTagTypeEqualTo("FILE");
		criteria.andDelStatusNotEqualTo("DEL");
		List<DbFileKit> dbFileKits = dbFileKitMapper.selectByExample(example);
		if (CommonUtil.isEmpty(dbFileKits)) {
			return null;
		} else {
			return dbFileKits.get(0);
		}
	}

	public DbFileKit dbFileKit(String kid) {
		return dbFileKitMapper.selectByPrimaryKey(kid);
	}

	@Override
	public ResultVo getDbFileKitById(String id) {
		if (StringUtil.isEmpty(id)) {
			return ResultVo.fail("id不能为空");
		}
		DbFileKit fileKit = dbFileKit(id);
		if (null==fileKit) {
			return ResultVo.fail("套件不存在");
		}
		DbFileKitDto dbFileKitDto = CommonUtil.po2VO(fileKit, DbFileKitDto.class);
//		if (dbFileKitDto != null && StringUtil.isNotEmpty(dbFileKitDto.getId())) {
//			ResultVo resultVo = sysApi.isTagRun(dbFileKitDto.getOrgId(), "file");
//			if(resultVo.getStatus() == 200) {
//				if("true".equals(resultVo.getData()+"")) {
//					ResultVo vo = fileKitTemplate.fileServiceRPC("/kit/getFileSpace", null, dbFileKitDto.getId());
//					if (vo != null && vo.getStatus() == 200) {
//						dbFileKitDto.setSpaceInfo(vo.getData());
//					}
//				}
//			}
//		}
		return ResultVo.ok(dbFileKitDto);
	}

	
}
