package com.rainyhon.common.model;

import java.util.Date;

public class RollCallResult {
    /**
     * ID
     */
    private String id;

    /**
     * 团队ID
     */
    private String orgId;

    /**
     * 人员ID
     */
    private String personId;

    /**
     * 点名事件ID
     */
    private String detailId;

    /**
     * 更改原因
     */
    private String updateReason;

    /**
     * 结果
     */
    private String result;

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
     * 团队ID
     * @return org_id 团队ID
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 团队ID
     * @param orgId 团队ID
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 人员ID
     * @return person_id 人员ID
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * 人员ID
     * @param personId 人员ID
     */
    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    /**
     * 点名事件ID
     * @return detail_id 点名事件ID
     */
    public String getDetailId() {
        return detailId;
    }

    /**
     * 点名事件ID
     * @param detailId 点名事件ID
     */
    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    /**
     * 更改原因
     * @return update_reason 更改原因
     */
    public String getUpdateReason() {
        return updateReason;
    }

    /**
     * 更改原因
     * @param updateReason 更改原因
     */
    public void setUpdateReason(String updateReason) {
        this.updateReason = updateReason == null ? null : updateReason.trim();
    }

    /**
     * 结果
     * @return result 结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 结果
     * @param result 结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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