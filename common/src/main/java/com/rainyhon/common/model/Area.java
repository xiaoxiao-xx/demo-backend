package com.rainyhon.common.model;

import java.util.Date;

public class Area {
    /**
     * ID
     */
    private String id;

    /**
     * 区域名
     */
    private String name;

    /**
     * 父区域ID
     */
    private String parentId;

    /**
     * 区域编码
     */
    private String code;

    /**
     * 备注
     */
    private String comment;

    /**
     * 删除状态 
     */
    private String delStatus;

    /**
     * 最后修改人ID 
     */
    private String updUserId;

    /**
     * 最后修改机构ID 
     */
    private String updOrgId;

    /**
     * 最后修改时间 
     */
    private Date updTm;

    /**
     * 创建人ID
     */
    private String crtUserId;

    /**
     * 创建机构ID
     */
    private String crtOrgId;

    /**
     * 创建时间
     */
    private Date crtTm;

    /**
     * ID
     * @return id ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 区域名
     * @return name 区域名
     */
    public String getName() {
        return name;
    }

    /**
     * 区域名
     * @param name 区域名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 父区域ID
     * @return parent_id 父区域ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 父区域ID
     * @param parentId 父区域ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 区域编码
     * @return code 区域编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 区域编码
     * @param code 区域编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 备注
     * @return comment 备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 备注
     * @param comment 备注
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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
     * 最后修改人ID 
     * @return upd_user_id 最后修改人ID 
     */
    public String getUpdUserId() {
        return updUserId;
    }

    /**
     * 最后修改人ID 
     * @param updUserId 最后修改人ID 
     */
    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId == null ? null : updUserId.trim();
    }

    /**
     * 最后修改机构ID 
     * @return upd_org_id 最后修改机构ID 
     */
    public String getUpdOrgId() {
        return updOrgId;
    }

    /**
     * 最后修改机构ID 
     * @param updOrgId 最后修改机构ID 
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
     * 创建人ID
     * @return crt_user_id 创建人ID
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /**
     * 创建人ID
     * @param crtUserId 创建人ID
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId == null ? null : crtUserId.trim();
    }

    /**
     * 创建机构ID
     * @return crt_org_id 创建机构ID
     */
    public String getCrtOrgId() {
        return crtOrgId;
    }

    /**
     * 创建机构ID
     * @param crtOrgId 创建机构ID
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