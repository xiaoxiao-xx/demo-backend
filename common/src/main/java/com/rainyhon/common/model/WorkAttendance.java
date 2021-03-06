package com.rainyhon.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WorkAttendance {
    /**
     * ID
     */
    private String id;

    /**
     * 人员ID
     */
    private String personId;

    /**
     * 日期
     */
    private Date checkDate;

    /**
     * 上班时间
     */
    @JsonFormat(pattern = "HH:mm:ss")
    private Date onWorkTime;

    /**
     * 下班时间
     */
    @JsonFormat(pattern = "HH:mm:ss")
    private Date quitTime;

    /**
     * 考勤结果
     */
    private String result;

    /**
     * 更改原因
     */
    private String updateReason;

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
     * 日期
     * @return check_date 日期
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 日期
     * @param checkDate 日期
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 上班时间
     * @return on_work_time 上班时间
     */
    public Date getOnWorkTime() {
        return onWorkTime;
    }

    /**
     * 上班时间
     * @param onWorkTime 上班时间
     */
    public void setOnWorkTime(Date onWorkTime) {
        this.onWorkTime = onWorkTime;
    }

    /**
     * 下班时间
     * @return quit_time 下班时间
     */
    public Date getQuitTime() {
        return quitTime;
    }

    /**
     * 下班时间
     * @param quitTime 下班时间
     */
    public void setQuitTime(Date quitTime) {
        this.quitTime = quitTime;
    }

    /**
     * 考勤结果
     * @return result 考勤结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 考勤结果
     * @param result 考勤结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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