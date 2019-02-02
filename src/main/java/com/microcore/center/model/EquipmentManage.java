package com.microcore.center.model;

import java.util.Date;

public class EquipmentManage {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String chargeUser;

    /**
     * 
     */
    private String alarmNum;

    /**
     * 
     */
    private String equiType;

    /**
     * 
     */
    private String equiTypeId;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String equiPlace;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String trouble;

    /**
     * 上线时间
     */
    private Date onlineTm;

    /**
     * 1启用0停用
     */
    private String upStatus;

    /**
     * 是否删除(1删除，0非--)
     */
    private String delStatus;

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
     * 
     * @return charge_user 
     */
    public String getChargeUser() {
        return chargeUser;
    }

    /**
     * 
     * @param chargeUser 
     */
    public void setChargeUser(String chargeUser) {
        this.chargeUser = chargeUser == null ? null : chargeUser.trim();
    }

    /**
     * 
     * @return alarm_num 
     */
    public String getAlarmNum() {
        return alarmNum;
    }

    /**
     * 
     * @param alarmNum 
     */
    public void setAlarmNum(String alarmNum) {
        this.alarmNum = alarmNum == null ? null : alarmNum.trim();
    }

    /**
     * 
     * @return equi_type 
     */
    public String getEquiType() {
        return equiType;
    }

    /**
     * 
     * @param equiType 
     */
    public void setEquiType(String equiType) {
        this.equiType = equiType == null ? null : equiType.trim();
    }

    /**
     * 
     * @return equi_type_id 
     */
    public String getEquiTypeId() {
        return equiTypeId;
    }

    /**
     * 
     * @param equiTypeId 
     */
    public void setEquiTypeId(String equiTypeId) {
        this.equiTypeId = equiTypeId == null ? null : equiTypeId.trim();
    }

    /**
     * 
     * @return user_id 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 
     * @return equi_place 
     */
    public String getEquiPlace() {
        return equiPlace;
    }

    /**
     * 
     * @param equiPlace 
     */
    public void setEquiPlace(String equiPlace) {
        this.equiPlace = equiPlace == null ? null : equiPlace.trim();
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 
     * @return trouble 
     */
    public String getTrouble() {
        return trouble;
    }

    /**
     * 
     * @param trouble 
     */
    public void setTrouble(String trouble) {
        this.trouble = trouble == null ? null : trouble.trim();
    }

    /**
     * 上线时间
     * @return online_tm 上线时间
     */
    public Date getOnlineTm() {
        return onlineTm;
    }

    /**
     * 上线时间
     * @param onlineTm 上线时间
     */
    public void setOnlineTm(Date onlineTm) {
        this.onlineTm = onlineTm;
    }

    /**
     * 1启用0停用
     * @return up_status 1启用0停用
     */
    public String getUpStatus() {
        return upStatus;
    }

    /**
     * 启用停用
     * @param upStatus 启用停用
     */
    public void setUpStatus(String upStatus) {
        this.upStatus = upStatus == null ? null : upStatus.trim();
    }

    /**
     * 是否删除(1删除，0非--)
     * @return del_status 是否删除(1删除，0非--)
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 是否删除(1删除，0非--)
     * @param delStatus 是否删除(1删除，0非--)
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
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