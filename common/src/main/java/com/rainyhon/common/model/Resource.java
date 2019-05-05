package com.rainyhon.common.model;

import java.util.Date;

public class Resource {
    /**
     * ID
     */
    private String id;

    /**
     * 名称
     */
    private String resourceName;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 描述
     */
    private String description;

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
     * 名称
     * @return resource_name 名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 名称
     * @param resourceName 名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * 资源地址
     * @return url 资源地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 资源地址
     * @param url 资源地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 资源类型
     * @return type 资源类型
     */
    public String getType() {
        return type;
    }

    /**
     * 资源类型
     * @param type 资源类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 图标
     * @return icon 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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