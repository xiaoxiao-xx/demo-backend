package com.microcore.center.model;

import java.util.Date;

public class PsmPersonInfo {
    /**
     * 
     */
    private String personId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 性别
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
     * 个人照片1
     */
    private String personalPhoto1;

    /**
     * 个人照片2
     */
    private String personalPhoto2;

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
    private String deptId;

    /**
     * 
     * @return person_id 
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * 
     * @param personId 
     */
    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
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
     * 性别 性别
     * @return gender 性别 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性别 性别
     * @param gender 性别 性别
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
     * 个人照片1
     * @return personal_photo1 个人照片1
     */
    public String getPersonalPhoto1() {
        return personalPhoto1;
    }

    /**
     * 个人照片1
     * @param personalPhoto1 个人照片1
     */
    public void setPersonalPhoto1(String personalPhoto1) {
        this.personalPhoto1 = personalPhoto1 == null ? null : personalPhoto1.trim();
    }

    /**
     * 个人照片2
     * @return personal_photo2 个人照片2
     */
    public String getPersonalPhoto2() {
        return personalPhoto2;
    }

    /**
     * 个人照片2
     * @param personalPhoto2 个人照片2
     */
    public void setPersonalPhoto2(String personalPhoto2) {
        this.personalPhoto2 = personalPhoto2 == null ? null : personalPhoto2.trim();
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
     * @return dept_id 组织机构ID
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 组织机构ID
     * @param deptId 组织机构ID
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }
}