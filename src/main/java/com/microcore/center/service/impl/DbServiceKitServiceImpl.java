package com.microcore.center.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.api.model.DbOrg;
import com.microcore.api.model.DbServiceKit;
import com.microcore.center.context.VCodeContext;
import com.microcore.center.dto.DbServiceKitDto;
import com.microcore.center.mapper.DbOrgMapper;
import com.microcore.center.mapper.DbServiceKitMapper;
import com.microcore.center.model.DbOrgExample;
import com.microcore.center.model.DbServiceKitExample;
import com.microcore.center.model.DbServiceKitExample.Criteria;
import com.microcore.center.service.DbServiceKitService;
import com.microcore.center.util.CheckingUtil;
import com.microcore.center.vo.ServiceKitVo;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;

/**
 * 服务接口套件管理
 *
 * @author
 */
@Service
@Transactional
public class DbServiceKitServiceImpl implements DbServiceKitService {

	/**
	 * 服务接口套件信息Mapper
	 */
	@Autowired
	private DbServiceKitMapper dbServiceKitMapper;

	/**
	 * 机构信息Mapper
	 */
	@Autowired
	private DbOrgMapper dbOrgMapper;

	@Override
	public ResultVo addServiceKit(DbServiceKitDto dbServiceKitDto) {
		if (!CheckingUtil.checkingIsEmpty(dbServiceKitDto.getId())) {
			return ResultVo.fail("新增服务接口套件，套件ID必须为空！");
		}
		if (CheckingUtil.checkingIsEmpty(dbServiceKitDto.getOrgId())) {
			return ResultVo.fail("机构ID不能为空！");
		}
		if (CheckingUtil.checkingIsEmpty(dbServiceKitDto.getTagName())) {
			return ResultVo.fail("套件名称不能为空！");
		}
		if (!CheckingUtil.checkingIp(dbServiceKitDto.getTagIp())) {
			return ResultVo.fail("IP格式不正确！");
		}
		if (!CheckingUtil.checkingPort(dbServiceKitDto.getTagPort())) {
			return ResultVo.fail("端口格式不正确！");
		}
		//服务接口套件信息配置
		dbServiceKitDto.setId(checkedServiceKitId(CommonUtil.getUUID()));
		dbServiceKitDto.setTagType("SERVICE");
		dbServiceKitDto.setMacAddress("");
		dbServiceKitDto.setStatus("STOP");
		dbServiceKitDto.setDelStatus("NOR");
		dbServiceKitDto.setUpdUserId(UserUtil.getUserId());
		dbServiceKitDto.setUpdOrgId(UserUtil.getOrgId());
		dbServiceKitDto.setUpdTm(CommonUtil.getSystemDate());
		dbServiceKitDto.setCrtUserId(UserUtil.getUserId());
		dbServiceKitDto.setCrtOrgId(UserUtil.getOrgId());
		dbServiceKitDto.setCrtTm(CommonUtil.getSystemDate());
		DbServiceKit dbServiceKit = CommonUtil.po2VO(dbServiceKitDto, DbServiceKit.class);
		int insert = dbServiceKitMapper.insert(dbServiceKit);
		if (insert != 1) {
			return ResultVo.fail("新增服务接口套件失败！");
		}
		return ResultVo.ok("新增成功！");
	}

	@Override
	public ResultVo updateServiceKit(DbServiceKitDto dbServiceKitDto) {
		if (CheckingUtil.checkingIsEmpty(dbServiceKitDto.getId())) {
			return ResultVo.fail("修改服务接口套件，套件ID不能为空！");
		}
		if (CheckingUtil.checkingIsEmpty(dbServiceKitDto.getOrgId())) {
			return ResultVo.fail("机构ID不能为空！");
		}
		if (CheckingUtil.checkingIsEmpty(dbServiceKitDto.getTagName())) {
			return ResultVo.fail("套件名称不能为空！");
		}
		if (!CheckingUtil.checkingIp(dbServiceKitDto.getTagIp())) {
			return ResultVo.fail("IP格式不正确！");
		}
		if (!CheckingUtil.checkingPort(dbServiceKitDto.getTagPort())) {
			return ResultVo.fail("端口格式不正确！");
		}
		dbServiceKitDto.setUpdUserId(UserUtil.getUserId());
		dbServiceKitDto.setUpdOrgId(UserUtil.getOrgId());
		dbServiceKitDto.setUpdTm(CommonUtil.getCurrentTime());
		DbServiceKit dbServiceKit = CommonUtil.po2VO(dbServiceKitDto, DbServiceKit.class);
		int i = dbServiceKitMapper.updateByPrimaryKeySelective(dbServiceKit);
		if (i != 1) {
			return ResultVo.fail("修改失败！");
		}
		return ResultVo.ok("修改成功！");
	}

	@Override
	public ResultVo getServiceKitOrgs() {
		DbOrgExample example = new DbOrgExample();
		com.microcore.center.model.DbOrgExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo("NOR");
		List<DbOrg> list = dbOrgMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return ResultVo.fail("无相关数据！");
		}
		return ResultVo.ok(list);
	}

	@Override
	public DbServiceKit getServiceKit(String id) {
		DbServiceKitExample example = new DbServiceKitExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(id);
		List<DbServiceKit> list = dbServiceKitMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public ResultVo getVcode(String id) {
		if (CheckingUtil.checkingIsEmpty(id)) {
			return ResultVo.fail("服务接口套件ID不能为空！");
		}
		String vcodeInfo = VCodeContext.addVCodeInfo(id);
		if (CheckingUtil.checkingIsEmpty(vcodeInfo)) {
			return ResultVo.fail("生成验证码失败！");
		}
		return ResultVo.ok(vcodeInfo);
	}

	@Override
	public ResultVo unbindMacAddress(String id) {
		setMacAddress(id, "");
		return ResultVo.ok("解绑成功！");
	}

	@Override
	public void setMacAddress(String id, String macAddress) {
		DbServiceKit dbServiceKit = new DbServiceKit();
		dbServiceKit.setId(id);
		dbServiceKit.setMacAddress(macAddress);
		dbServiceKitMapper.updateByPrimaryKeySelective(dbServiceKit);
	}

	@Override
	public ResultVo authDbServiceInfo(ServiceKitVo dbServiceKitVo) {
		String kitIp = dbServiceKitVo.getTagIp();
		String kitPort = dbServiceKitVo.getTagPort();
		String macAddr = dbServiceKitVo.getMacAddress();
		String verificationCode = dbServiceKitVo.getVerificationCode();

		DbServiceKit dbServiceKit = selectByIpAndPort(kitIp, kitPort);
		if (dbServiceKit == null) {
			return ResultVo.fail("请先注册套件信息");
		}

		String id = dbServiceKit.getId();
		String macAddrInService = dbServiceKit.getMacAddress();
		// 第一次验证
		if (StringUtil.isEmpty(macAddrInService)) {
			// 验证码		
			// TODO 删除下面一行
			VCodeContext.addVCodeInfo(id, verificationCode);

			if (VCodeContext.verifyVCode(id, verificationCode)) {
				setMacAddress(id, macAddr);
				return ResultVo.ok(dbServiceKit);
			} else {
				return ResultVo.fail("验证码不匹配");
			}
		} else {
			if (macAddrInService.equals(macAddr)) {
				return ResultVo.ok(dbServiceKit);
			} else {
				return ResultVo.fail("MAC地址不匹配");
			}
		}
	}

	@Override
	public DbServiceKit selectByIpAndPort(String ip, String port) {
		DbServiceKitExample example = new DbServiceKitExample();
		Criteria criteria = example.createCriteria();
		criteria.andTagIpEqualTo(ip);
		criteria.andTagPortEqualTo(port);
		List<DbServiceKit> list = dbServiceKitMapper.selectByExample(example);
		if (CommonUtil.isEmpty(list)) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public String getCurrentUsersServiceKitId() {
		DbServiceKit dbServiceKit = getCurrentUsersDbKit();
		return Optional.ofNullable(dbServiceKit.getId()).orElse("");
	}

	@Override
	public DbServiceKit getCurrentUsersDbKit() {
		String orgId = UserUtil.getOrgId();
		return Optional.ofNullable(getServiceKit(orgId)).orElse(new DbServiceKit());
	}

	/**
	 * DbServiceKit ID检查
	 */
	public String checkedServiceKitId(String id) {
		DbServiceKit dbServiceKit = dbServiceKitMapper.selectByPrimaryKey(id);
		if (dbServiceKit != null) {
			id = CommonUtil.getUUID();
			return checkedServiceKitId(id);
		}
		return id;
	}

}
