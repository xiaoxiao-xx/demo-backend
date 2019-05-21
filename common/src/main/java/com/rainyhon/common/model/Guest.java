package com.rainyhon.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Guest {
    /**
     * ID
     */
    private String id;

    /**
     * 名字
     */
    private String name;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件编号
     */
    private String cardNumber;

    /**
     * 目的区域ID
     */
    private String targetAreaId;

    /**
     * 访问部门ID
     */
    private String targetOrgId;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 到访原因
     */
    private String visitReason;

    /**
     * 访客照片
     */
    private String guestPhoto;

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
     * 名字
     * @return name 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 名字
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 证件类型
     * @return card_type 证件类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 证件类型
     * @param cardType 证件类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * 证件编号
     * @return card_number 证件编号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 证件编号
     * @param cardNumber 证件编号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    /**
     * 目的区域ID
     * @return target_area_id 目的区域ID
     */
    public String getTargetAreaId() {
        return targetAreaId;
    }

    /**
     * 目的区域ID
     * @param targetAreaId 目的区域ID
     */
    public void setTargetAreaId(String targetAreaId) {
        this.targetAreaId = targetAreaId == null ? null : targetAreaId.trim();
    }

    /**
     * 访问部门ID
     * @return target_org_id 访问部门ID
     */
    public String getTargetOrgId() {
        return targetOrgId;
    }

    /**
     * 访问部门ID
     * @param targetOrgId 访问部门ID
     */
    public void setTargetOrgId(String targetOrgId) {
        this.targetOrgId = targetOrgId == null ? null : targetOrgId.trim();
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 到访原因
     * @return visit_reason 到访原因
     */
    public String getVisitReason() {
        return visitReason;
    }

    /**
     * 到访原因
     * @param visitReason 到访原因
     */
    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason == null ? null : visitReason.trim();
    }

    /**
     * 访客照片
     * @return guest_photo 访客照片
     */
    public String getGuestPhoto() {
        return guestPhoto;
    }

    /**
     * 访客照片
     * @param guestPhoto 访客照片
     */
    public void setGuestPhoto(String guestPhoto) {
        this.guestPhoto = guestPhoto == null ? null : guestPhoto.trim();
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