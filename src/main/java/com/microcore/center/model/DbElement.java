package com.microcore.center.model;

import java.util.Date;

public class DbElement {
    /**
     * 
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 定义
     */
    private String define;

    /**
     * 必选或可选
     */
    private String cond;

    /**
     * 0:1（表示不出现或出现1次）             0:n（表示不出现或出现n次）             1:1（表示出现且仅出现1次）             1:n（表示出现1次或多次）
     */
    private String showTimes;

    /**
     * “字符”、“数值”、“日期”、“时间”、“日期时间”和“二进制”
     */
    private String dataType;

    /**
     * 与属性应用有关的注释
     */
    private String remark;

    /**
     * 核心:core,扩展:ext
     */
    private String type;

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
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 定义
     * @return define 定义
     */
    public String getDefine() {
        return define;
    }

    /**
     * 定义
     * @param define 定义
     */
    public void setDefine(String define) {
        this.define = define == null ? null : define.trim();
    }

    /**
     * 必选或可选
     * @return cond 必选或可选
     */
    public String getCond() {
        return cond;
    }

    /**
     * 必选或可选
     * @param cond 必选或可选
     */
    public void setCond(String cond) {
        this.cond = cond == null ? null : cond.trim();
    }

    /**
     * 0:1（表示不出现或出现1次）             0:n（表示不出现或出现n次）             1:1（表示出现且仅出现1次）             1:n（表示出现1次或多次）
     * @return show_times 0:1（表示不出现或出现1次）             0:n（表示不出现或出现n次）             1:1（表示出现且仅出现1次）             1:n（表示出现1次或多次）
     */
    public String getShowTimes() {
        return showTimes;
    }

    /**
     * 0:1（表示不出现或出现1次）             0:n（表示不出现或出现n次）             1:1（表示出现且仅出现1次）             1:n（表示出现1次或多次）
     * @param showTimes 0:1（表示不出现或出现1次）             0:n（表示不出现或出现n次）             1:1（表示出现且仅出现1次）             1:n（表示出现1次或多次）
     */
    public void setShowTimes(String showTimes) {
        this.showTimes = showTimes == null ? null : showTimes.trim();
    }

    /**
     * “字符”、“数值”、“日期”、“时间”、“日期时间”和“二进制”
     * @return data_type “字符”、“数值”、“日期”、“时间”、“日期时间”和“二进制”
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * “字符”、“数值”、“日期”、“时间”、“日期时间”和“二进制”
     * @param dataType “字符”、“数值”、“日期”、“时间”、“日期时间”和“二进制”
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 与属性应用有关的注释
     * @return remark 与属性应用有关的注释
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 与属性应用有关的注释
     * @param remark 与属性应用有关的注释
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 核心:core,扩展:ext
     * @return type 核心:core,扩展:ext
     */
    public String getType() {
        return type;
    }

    /**
     * 核心:core,扩展:ext
     * @param type 核心:core,扩展:ext
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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