package com.microcore.center.model;

import java.util.Date;

public class DbSubFile {
    /**
     * 主键 订阅id
     */
    private String subId;

    /**
     * 发布ＩＤ
     */
    private String pubId;

    /**
     * 订阅名称
     */
    private String subName;

    /**
     * 订阅描述
     */
    private String subDesc;

    /**
     * 订阅路径
     */
    private String subPath;

    /**
     * 脱标后本地目录
     */
    private String locPath;

    /**
     * 数据类型
     */
    private String fileType;

    /**
     * 抽取方式：抽取后删除/抽取后备份
     */
    private String extractType;

    /**
     * 备份路径
     */
    private String backupPath;

    /**
     * 交换信息id
     */
    private String exchangeInfoId;

    /**
     * 状态 (RUN, STOP)
     */
    private String status;

    /**
     * 运行状态
     */
    private String runStatus;

    /**
     * 删除状态
     */
    private String delStatus;

    /**
     * 发布人ID
     */
    private String pubUserId;

    /**
     * 发布机构ID
     */
    private String pubOrgId;

    /**
     * 订阅人id
     */
    private String subUserId;

    /**
     * 订阅机构id
     */
    private String subOrgId;

    /**
     * 最后修改人
     */
    private String updUserId;

    /**
     * 修改时间
     */
    private Date updTm;

    /**
     * 创建人
     */
    private String crtUserId;

    /**
     * 创建机构
     */
    private String crtOrgId;

    /**
     * 创建时间
     */
    private Date crtTm;

    /**
     * 主键 订阅id
     * @return sub_id 主键 订阅id
     */
    public String getSubId() {
        return subId;
    }

    /**
     * 主键 订阅id
     * @param subId 主键 订阅id
     */
    public void setSubId(String subId) {
        this.subId = subId == null ? null : subId.trim();
    }

    /**
     * 发布ＩＤ
     * @return pub_id 发布ＩＤ
     */
    public String getPubId() {
        return pubId;
    }

    /**
     * 发布ＩＤ
     * @param pubId 发布ＩＤ
     */
    public void setPubId(String pubId) {
        this.pubId = pubId == null ? null : pubId.trim();
    }

    /**
     * 订阅名称
     * @return sub_name 订阅名称
     */
    public String getSubName() {
        return subName;
    }

    /**
     * 订阅名称
     * @param subName 订阅名称
     */
    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    /**
     * 订阅描述
     * @return sub_desc 订阅描述
     */
    public String getSubDesc() {
        return subDesc;
    }

    /**
     * 订阅描述
     * @param subDesc 订阅描述
     */
    public void setSubDesc(String subDesc) {
        this.subDesc = subDesc == null ? null : subDesc.trim();
    }

    /**
     * 订阅路径
     * @return sub_path 订阅路径
     */
    public String getSubPath() {
        return subPath;
    }

    /**
     * 订阅路径
     * @param subPath 订阅路径
     */
    public void setSubPath(String subPath) {
        this.subPath = subPath == null ? null : subPath.trim();
    }

    /**
     * 脱标后本地目录
     * @return loc_path 脱标后本地目录
     */
    public String getLocPath() {
        return locPath;
    }

    /**
     * 脱标后本地目录
     * @param locPath 脱标后本地目录
     */
    public void setLocPath(String locPath) {
        this.locPath = locPath == null ? null : locPath.trim();
    }

    /**
     * 数据类型
     * @return file_type 数据类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 数据类型
     * @param fileType 数据类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 抽取方式：抽取后删除/抽取后备份
     * @return extract_type 抽取方式：抽取后删除/抽取后备份
     */
    public String getExtractType() {
        return extractType;
    }

    /**
     * 抽取方式：抽取后删除/抽取后备份
     * @param extractType 抽取方式：抽取后删除/抽取后备份
     */
    public void setExtractType(String extractType) {
        this.extractType = extractType == null ? null : extractType.trim();
    }

    /**
     * 备份路径
     * @return backup_path 备份路径
     */
    public String getBackupPath() {
        return backupPath;
    }

    /**
     * 备份路径
     * @param backupPath 备份路径
     */
    public void setBackupPath(String backupPath) {
        this.backupPath = backupPath == null ? null : backupPath.trim();
    }

    /**
     * 交换信息id
     * @return exchange_info_id 交换信息id
     */
    public String getExchangeInfoId() {
        return exchangeInfoId;
    }

    /**
     * 交换信息id
     * @param exchangeInfoId 交换信息id
     */
    public void setExchangeInfoId(String exchangeInfoId) {
        this.exchangeInfoId = exchangeInfoId == null ? null : exchangeInfoId.trim();
    }

    /**
     * 状态 (RUN, STOP)
     * @return status 状态 (RUN, STOP)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 (RUN, STOP)
     * @param status 状态 (RUN, STOP)
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 运行状态
     * @return run_status 运行状态
     */
    public String getRunStatus() {
        return runStatus;
    }

    /**
     * 运行状态
     * @param runStatus 运行状态
     */
    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus == null ? null : runStatus.trim();
    }

    /**
     * 删除状态
     * @return del_status 删除状态
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 删除状态
     * @param delStatus 删除状态
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
    }

    /**
     * 发布人ID
     * @return pub_user_id 发布人ID
     */
    public String getPubUserId() {
        return pubUserId;
    }

    /**
     * 发布人ID
     * @param pubUserId 发布人ID
     */
    public void setPubUserId(String pubUserId) {
        this.pubUserId = pubUserId == null ? null : pubUserId.trim();
    }

    /**
     * 发布机构ID
     * @return pub_org_id 发布机构ID
     */
    public String getPubOrgId() {
        return pubOrgId;
    }

    /**
     * 发布机构ID
     * @param pubOrgId 发布机构ID
     */
    public void setPubOrgId(String pubOrgId) {
        this.pubOrgId = pubOrgId == null ? null : pubOrgId.trim();
    }

    /**
     * 订阅人id
     * @return sub_user_id 订阅人id
     */
    public String getSubUserId() {
        return subUserId;
    }

    /**
     * 订阅人id
     * @param subUserId 订阅人id
     */
    public void setSubUserId(String subUserId) {
        this.subUserId = subUserId == null ? null : subUserId.trim();
    }

    /**
     * 订阅机构id
     * @return sub_org_id 订阅机构id
     */
    public String getSubOrgId() {
        return subOrgId;
    }

    /**
     * 订阅机构id
     * @param subOrgId 订阅机构id
     */
    public void setSubOrgId(String subOrgId) {
        this.subOrgId = subOrgId == null ? null : subOrgId.trim();
    }

    /**
     * 最后修改人
     * @return upd_user_id 最后修改人
     */
    public String getUpdUserId() {
        return updUserId;
    }

    /**
     * 最后修改人
     * @param updUserId 最后修改人
     */
    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId == null ? null : updUserId.trim();
    }

    /**
     * 修改时间
     * @return upd_tm 修改时间
     */
    public Date getUpdTm() {
        return updTm;
    }

    /**
     * 修改时间
     * @param updTm 修改时间
     */
    public void setUpdTm(Date updTm) {
        this.updTm = updTm;
    }

    /**
     * 创建人
     * @return crt_user_id 创建人
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /**
     * 创建人
     * @param crtUserId 创建人
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId == null ? null : crtUserId.trim();
    }

    /**
     * 创建机构
     * @return crt_org_id 创建机构
     */
    public String getCrtOrgId() {
        return crtOrgId;
    }

    /**
     * 创建机构
     * @param crtOrgId 创建机构
     */
    public void setCrtOrgId(String crtOrgId) {
        this.crtOrgId = crtOrgId == null ? null : crtOrgId.trim();
    }

    /**
     * 创建时间
     * @return crt_tm 创建时间
     */
    public Date getCrtTm() {
        return crtTm;
    }

    /**
     * 创建时间
     * @param crtTm 创建时间
     */
    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }
}