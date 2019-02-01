package com.microcore.center.model;

import java.util.Date;

public class DbModel {
    /**
     * id
     */
    private String id;

    /**
     * pid
     */
    private String pid;

    /**
     * 级别
     */
    private String modelDataLevel;

    /**
     * 展示名称
     */
    private String modelDisplayName;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * 模型英文名称
     */
    private String modelEname;

    /**
     * 库表DB
             文件FILE
             服务接口SERVICE
     */
    private String modelType;

    /**
     * 模型描述
     */
    private String modelDesc;

    /**
     * 模型行业
     */
    private String modelTrade;

    /**
     * 版本号
     */
    private Integer modelVersion;

    /**
     * 发布次数
     */
    private Integer pubCount;

    /**
     * 版权声明
     */
    private String copyrightNotice;

    /**
     * 机构id
     */
    private String orgId;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否删除
     */
    private String delStatus;

    /**
     * 最后修改人
     */
    private String updUserId;

    /**
     * 最后修改机构
     */
    private String updOrgId;

    /**
     * 最后修改时间
     */
    private Date updTm;

    /**
     * 创建人
     */
    private String crtUserId;

    /**
     * 创建机构id
     */
    private String crtOrgId;

    /**
     * 创建时间
     */
    private Date crtTm;

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * pid
     * @return pid pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * pid
     * @param pid pid
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 级别
     * @return model_data_level 级别
     */
    public String getModelDataLevel() {
        return modelDataLevel;
    }

    /**
     * 级别
     * @param modelDataLevel 级别
     */
    public void setModelDataLevel(String modelDataLevel) {
        this.modelDataLevel = modelDataLevel == null ? null : modelDataLevel.trim();
    }

    /**
     * 展示名称
     * @return model_display_name 展示名称
     */
    public String getModelDisplayName() {
        return modelDisplayName;
    }

    /**
     * 展示名称
     * @param modelDisplayName 展示名称
     */
    public void setModelDisplayName(String modelDisplayName) {
        this.modelDisplayName = modelDisplayName == null ? null : modelDisplayName.trim();
    }

    /**
     * 模型名称
     * @return model_name 模型名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 模型名称
     * @param modelName 模型名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    /**
     * 模型英文名称
     * @return model_ename 模型英文名称
     */
    public String getModelEname() {
        return modelEname;
    }

    /**
     * 模型英文名称
     * @param modelEname 模型英文名称
     */
    public void setModelEname(String modelEname) {
        this.modelEname = modelEname == null ? null : modelEname.trim();
    }

    /**
     * 库表DB
             文件FILE
             服务接口SERVICE
     * @return model_type 库表DB
             文件FILE
             服务接口SERVICE
     */
    public String getModelType() {
        return modelType;
    }

    /**
     * 库表DB
             文件FILE
             服务接口SERVICE
     * @param modelType 库表DB
             文件FILE
             服务接口SERVICE
     */
    public void setModelType(String modelType) {
        this.modelType = modelType == null ? null : modelType.trim();
    }

    /**
     * 模型描述
     * @return model_desc 模型描述
     */
    public String getModelDesc() {
        return modelDesc;
    }

    /**
     * 模型描述
     * @param modelDesc 模型描述
     */
    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc == null ? null : modelDesc.trim();
    }

    /**
     * 模型行业
     * @return model_trade 模型行业
     */
    public String getModelTrade() {
        return modelTrade;
    }

    /**
     * 模型行业
     * @param modelTrade 模型行业
     */
    public void setModelTrade(String modelTrade) {
        this.modelTrade = modelTrade == null ? null : modelTrade.trim();
    }

    /**
     * 版本号
     * @return model_version 版本号
     */
    public Integer getModelVersion() {
        return modelVersion;
    }

    /**
     * 版本号
     * @param modelVersion 版本号
     */
    public void setModelVersion(Integer modelVersion) {
        this.modelVersion = modelVersion;
    }

    /**
     * 发布次数
     * @return pub_count 发布次数
     */
    public Integer getPubCount() {
        return pubCount;
    }

    /**
     * 发布次数
     * @param pubCount 发布次数
     */
    public void setPubCount(Integer pubCount) {
        this.pubCount = pubCount;
    }

    /**
     * 版权声明
     * @return copyright_notice 版权声明
     */
    public String getCopyrightNotice() {
        return copyrightNotice;
    }

    /**
     * 版权声明
     * @param copyrightNotice 版权声明
     */
    public void setCopyrightNotice(String copyrightNotice) {
        this.copyrightNotice = copyrightNotice == null ? null : copyrightNotice.trim();
    }

    /**
     * 机构id
     * @return org_id 机构id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 机构id
     * @param orgId 机构id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 是否删除
     * @return del_status 是否删除
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 是否删除
     * @param delStatus 是否删除
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
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
     * 最后修改机构
     * @return upd_org_id 最后修改机构
     */
    public String getUpdOrgId() {
        return updOrgId;
    }

    /**
     * 最后修改机构
     * @param updOrgId 最后修改机构
     */
    public void setUpdOrgId(String updOrgId) {
        this.updOrgId = updOrgId == null ? null : updOrgId.trim();
    }

    /**
     * 最后修改时间
     * @return upd_tm 最后修改时间
     */
    public Date getUpdTm() {
        return updTm;
    }

    /**
     * 最后修改时间
     * @param updTm 最后修改时间
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
     * 创建机构id
     * @return crt_org_id 创建机构id
     */
    public String getCrtOrgId() {
        return crtOrgId;
    }

    /**
     * 创建机构id
     * @param crtOrgId 创建机构id
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