package com.rainyhon.common.model;

import java.util.Date;

public class PersonInfo {
    /**
     * 
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件编号
     */
    private String cardNo;

    /**
     * 入伍日期
     */
    private Date joinDate;

    /**
     * 职级
     */
    private String rank;

    /**
     * 个人照片
     */
    private String photo;

    /**
     * 是否关注
     */
    private String careStatus;

    /**
     * 重点关注
     */
    private String imptCareStatus;

    /**
     * 重点关注原因
     */
    private String imptCareReason;

    /**
     * 其他信息
     */
    private String para;

    /**
     * 组织机构ID
     */
    private String orgId;

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
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别
     * @return gender 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性别
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 出生日期
     * @return birth_date 出生日期
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 出生日期
     * @param birthDate 出生日期
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
     * @return card_no 证件编号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 证件编号
     * @param cardNo 证件编号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 入伍日期
     * @return join_date 入伍日期
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * 入伍日期
     * @param joinDate 入伍日期
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * 职级
     * @return rank 职级
     */
    public String getRank() {
        return rank;
    }

    /**
     * 职级
     * @param rank 职级
     */
    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    /**
     * 个人照片
     * @return photo 个人照片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 个人照片
     * @param photo 个人照片
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 是否关注
     * @return care_status 是否关注
     */
    public String getCareStatus() {
        return careStatus;
    }

    /**
     * 是否关注
     * @param careStatus 是否关注
     */
    public void setCareStatus(String careStatus) {
        this.careStatus = careStatus == null ? null : careStatus.trim();
    }

    /**
     * 重点关注
     * @return impt_care_status 重点关注
     */
    public String getImptCareStatus() {
        return imptCareStatus;
    }

    /**
     * 重点关注
     * @param imptCareStatus 重点关注
     */
    public void setImptCareStatus(String imptCareStatus) {
        this.imptCareStatus = imptCareStatus == null ? null : imptCareStatus.trim();
    }

    /**
     * 重点关注原因
     * @return impt_care_reason 重点关注原因
     */
    public String getImptCareReason() {
        return imptCareReason;
    }

    /**
     * 重点关注原因
     * @param imptCareReason 重点关注原因
     */
    public void setImptCareReason(String imptCareReason) {
        this.imptCareReason = imptCareReason == null ? null : imptCareReason.trim();
    }

    /**
     * 其他信息
     * @return para 其他信息
     */
    public String getPara() {
        return para;
    }

    /**
     * 其他信息
     * @param para 其他信息
     */
    public void setPara(String para) {
        this.para = para == null ? null : para.trim();
    }

    /**
     * 组织机构ID
     * @return org_id 组织机构ID
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 组织机构ID
     * @param orgId 组织机构ID
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
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