package com.microcore.center.service.impl;

import static com.microcore.common.constant.Constants.*;
import static com.microcore.common.util.CommonUtil.getCurrentTime;
import static com.microcore.common.util.CommonUtil.getUserId;

import java.util.List;
import java.util.Optional;

import com.microcore.common.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.api.model.DbDbKit;
import com.microcore.api.model.DbLabelKit;
import com.microcore.api.model.DbOrg;
import com.microcore.center.context.VCodeContext;
import com.microcore.center.dto.DbDbKitDto;
import com.microcore.center.mapper.DbDbKitMapper;
import com.microcore.center.model.DbDbKitExample;
import com.microcore.center.model.DbDbKitExample.Criteria;
import com.microcore.center.service.DbDbKitService;
import com.microcore.center.service.DbLabelKitService;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.service.DbVersionService;
import com.microcore.center.vo.DbKitVo;
import com.microcore.common.constant.Constants;
import com.microcore.common.jdbc.JdbcUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class DbDbKitServiceImpl implements DbDbKitService {

    @Autowired
    private DbDbKitMapper dbKitMapper;

    @Autowired
    private DbVersionService dbVersionService;

    @Autowired
    private DbLabelKitService dbLabelKitService;

    @Autowired
    private DbOrgService dbOrgService;

    /**
     * 添加套件信息
     */
    @Override
    public void addKitInfo(DbKitVo dbKitVo) {
        DbDbKit dbKit = CommonUtil.po2VO(dbKitVo, DbDbKit.class);

        String id = CommonUtil.getUUID();
        dbKit.setId(id);
        String orgId = dbKitVo.getOrgId();
        dbKit.setOrgId(orgId);

        // TODO 获取套件ID

        String labelId = null;
        DbLabelKit labelKit = dbLabelKitService.getDbLabelKitByOrgId(orgId);
        if (labelKit != null) {
            labelId = labelKit.getId();
        }
        dbKit.setLabelId(labelId);
        // dbKit.setTagName(tagName); // TODO 检查一下有重名套件
        dbKit.setTagType("DB");
        dbKit.setMacAddress("");

        dbKit.setDbTransTime(0);
        dbKit.setDbTransType("");

        // 添加套件信息后套件处于停用状态
        dbKit.setStatus(RUN_STATUS_STOP);

        EntityUtils.setCreateAndUpdateInfo(dbKit);

        dbKitMapper.insert(dbKit);
    }

    @Override
    public DbDbKit getDbKitById(String id) {
        DbDbKit dbKit = dbKitMapper.selectByPrimaryKey(id);

        String password = dbKit.getMakePassword();
        if (!StringUtil.isEmpty(password)) {
            String makePassword = PasswordUtil.decrypt(password);
            dbKit.setMakePassword(makePassword);
        }

        String dPassword = dbKit.getDistillPassword();
        if (!StringUtil.isEmpty(dPassword)) {
            String distillPassword = PasswordUtil.decrypt(dPassword);
            dbKit.setDistillPassword(distillPassword);
        }

        return dbKit;
    }

    @Override
    public DbDbKit getCurrentUsersDbKit() {
        String orgId = UserUtil.getOrgId();
        return Optional.ofNullable(getDbKitByOrgId(orgId)).orElse(new DbDbKit());
    }

    @Override
    public String getCurrentUsersDbKitId() {
        DbDbKit dbKit = getCurrentUsersDbKit();
        return Optional.ofNullable(dbKit.getId()).orElse("");
    }

    @Override
    public DbDbKit getDbKitByOrgId(String orgId) {
        DbDbKitExample example = new DbDbKitExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgIdEqualTo(orgId);
        criteria.andDelStatusEqualTo(DEL_STATUS_NOR);
        List<DbDbKit> list = dbKitMapper.selectByExample(example);

        if (CommonUtil.isEmpty(list)) {
            return null;
        }
        for (DbDbKit kit : list) {
            if (kit.getMakePassword() != null) {
                kit.setMakePassword(DESUtil.encrypt(kit.getMakePassword()));
            }
            if (kit.getDistillPassword() != null) {
                kit.setDistillPassword(DESUtil.encrypt(kit.getDistillPassword()));
            }
        }
        // 每个组织仅一个套件
        return list.get(0);
    }


    /**
     * 根据ID删除套件信息
     */
    @Override
    public void deleteKitInfoById(String id) {
        DbDbKit dbKit = new DbDbKit();
        dbKit.setId(id);
        dbKit.setDelStatus(DEL_STATUS_DEL);
        dbKitMapper.updateByPrimaryKeySelective(dbKit);
    }

    /**
     * 更新套件信息
     */
    @Override
    public void updateKitInfo(DbKitVo dbKitVo) {
        DbDbKit dbKit = CommonUtil.po2VO(dbKitVo, DbDbKit.class);

        // 加密密码
        if (dbKit.getMakePassword() != null) {
            String makePassword = null;
            try {
                makePassword = DESUtil.decryptor(dbKit.getMakePassword());
                if (!PasswordUtil.isEncrypted(makePassword)) {
                    makePassword = PasswordUtil.encrypt(makePassword);
                }
            } catch (Exception e) {
                log.error("更新套件密码[{}]", e.getMessage());
            }
            dbKit.setMakePassword(makePassword);
        }

        if (dbKit.getDistillPassword() != null) {
            String distillPassword = null;
            try {
                distillPassword = DESUtil.decryptor(dbKit.getDistillPassword());
                if (!PasswordUtil.isEncrypted(distillPassword)) {
                    distillPassword = PasswordUtil.encrypt(distillPassword);
                }
            } catch (Exception e) {
                log.error("更新套件信息脱标密码操作[{}]", e.getMessage());
            }
            dbKit.setDistillPassword(distillPassword);
        }

        // 设置URL
        if (dbKit.getMakeDbType() != null) {
            String dbMakeVersionId = dbKit.getMakeDbType();
            String makeType = dbVersionService.getDbTypeString(dbMakeVersionId);
            String makeUrl = JdbcUtil.generateUrl(makeType, dbKit.getMakeIp(), dbKit.getMakePort(), dbKit.getMakeDbName());
            dbKit.setMakeUrl(makeUrl);
        }

        if (dbKit.getDistillDbType() != null) {
            String dbDistillVersionId = dbKit.getDistillDbType();
            String distillType = dbVersionService.getDbTypeString(dbDistillVersionId);
            String distillUrl = JdbcUtil.generateUrl(distillType, dbKit.getDistillIp(), dbKit.getDistillPort(),
                    dbKit.getDistillDbName());
            dbKit.setDistillUrl(distillUrl);
        }

        String orgId = UserUtil.getOrgId();
        String userId = getUserId();

        dbKit.setUpdOrgId(orgId);
        dbKit.setUpdTm(getCurrentTime());
        dbKit.setUpdUserId(userId);

        dbKitMapper.updateByPrimaryKeySelective(dbKit);
    }

    /**
     * 启用套件
     */
    @Override
    public void enableDbKit(String id) {
        updateDbKitStatus(id, RUN_STATUS_RUN);
    }

    /**
     * 禁用套件
     * 目前不做这个功能
     */
    @Override
    public void disableDbKit(String id) {
        updateDbKitStatus(id, RUN_STATUS_STOP);
        // TODO 向Kit发送信息，让Kit停止 -- 暂不做
    }

    @Override
    public void updateDbKitStatus(String id, String status) {
        DbDbKit dbKit = new DbDbKit();
        dbKit.setId(id);
        dbKit.setStatus(status);
        dbKitMapper.updateByPrimaryKeySelective(dbKit);
    }

    @Override
    public void unbindMacAddress(String id) {
        // 设置MAC地址为空字符串
        setMacAddress(id, "");
    }

    @Override
    public DbDbKit selectByIpAndPort(String ip, String port) {
        DbDbKitExample example = new DbDbKitExample();
        Criteria criteria = example.createCriteria();
        criteria.andTagIpEqualTo(ip);
        criteria.andTagPortEqualTo(port);
        List<DbDbKit> list = dbKitMapper.selectByExample(example);
        if (CommonUtil.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * 设置MAC地址
     */
    @Override
    public void setMacAddress(String id, String macAddress) {
        DbDbKit dbKit = new DbDbKit();
        dbKit.setId(id);
        dbKit.setMacAddress(macAddress);
        dbKitMapper.updateByPrimaryKeySelective(dbKit);
    }

    /**
     * 库表套件启动时上传信息并验证
     */
    @Override
    public ResultVo<DbDbKitDto> authDbKitInfo(DbKitVo dbKitDto) {
        String kitIp = dbKitDto.getTagIp();
        String kitPort = dbKitDto.getTagPort();
        String macAddress = dbKitDto.getMacAddress();
        String verificationCode = dbKitDto.getVerificationCode();

        // 获取orgSort
        DbDbKit dbDbKit = selectByIpAndPort(kitIp, kitPort);
        if (dbDbKit == null) {
            return ResultVo.fail("请先注册套件信息");
        }
        String orgId = dbDbKit.getOrgId();
        DbOrg org = dbOrgService.getDbOrgByOrgId(orgId);
        Integer orgSort = org.getOrgSort();

        DbDbKitDto dto = CommonUtil.po2VO(dbDbKit, DbDbKitDto.class);
        dto.setCurrentOrgSort(orgSort);

        String id = dbDbKit.getId();
        String macAddressInDb = dbDbKit.getMacAddress();

        // 第一次验证
        if (StringUtil.isEmpty(macAddressInDb)) {
            // 检查验证码是否匹配
            if (VCodeContext.verifyVCode(id, verificationCode)) {
                setMacAddress(id, macAddress);
                return ResultVo.ok(dto);
            } else {
                return ResultVo.fail("验证码不匹配");
            }
        } else {
            // 非第一次验证
            // 检查MAC地址是否匹配
            if (macAddressInDb.equals(macAddress)) {
                return ResultVo.ok(dto);
            } else {
                return ResultVo.fail("MAC地址不匹配");
            }
        }
    }

}
