package com.microcore.center.model;

import java.util.Date;

public class DbNameSpace {
    /**
     * 
     */
    private String id;

    /**
     * 中文名称
     */
    private String cname;

    /**
     * 英文名称
     */
    private String ename;

    /**
     * 英文缩写
     */
    private String sname;

    /**
     * 说明
     */
    private String remark;

    /**
     * 图片地址
     */
    private String path;

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
     * 中文名称
     * @return cname 中文名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * 中文名称
     * @param cname 中文名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * 英文名称
     * @return ename 英文名称
     */
    public String getEname() {
        return ename;
    }

    /**
     * 英文名称
     * @param ename 英文名称
     */
    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    /**
     * 英文缩写
     * @return sname 英文缩写
     */
    public String getSname() {
        return sname;
    }

    /**
     * 英文缩写
     * @param sname 英文缩写
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * 说明
     * @return remark 说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 说明
     * @param remark 说明
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 图片地址
     * @return path 图片地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 图片地址
     * @param path 图片地址
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
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