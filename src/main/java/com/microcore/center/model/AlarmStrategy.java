package com.microcore.center.model;

import java.util.Date;

public class AlarmStrategy {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String alarmName;

    /**
     * 
     */
    private String alarmNum;

    /**
     * 
     */
    private String alarmType;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String alarmPlace;

    /**
     * 
     */
    private String userRole;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private Date alarmTm;

    /**
     * 停留时间
     */
    private Long stayTm;

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
     * @return alarm_name 
     */
    public String getAlarmName() {
        return alarmName;
    }

    /**
     * 
     * @param alarmName 
     */
    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName == null ? null : alarmName.trim();
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
     * @return alarm_type 
     */
    public String getAlarmType() {
        return alarmType;
    }

    /**
     * 
     * @param alarmType 
     */
    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType == null ? null : alarmType.trim();
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
     * @return alarm_place 
     */
    public String getAlarmPlace() {
        return alarmPlace;
    }

    /**
     * 
     * @param alarmPlace 
     */
    public void setAlarmPlace(String alarmPlace) {
        this.alarmPlace = alarmPlace == null ? null : alarmPlace.trim();
    }

    /**
     * 
     * @return user_role 
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 
     * @param userRole 
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * @return alarm_tm 
     */
    public Date getAlarmTm() {
        return alarmTm;
    }

    /**
     * 
     * @param alarmTm 
     */
    public void setAlarmTm(Date alarmTm) {
        this.alarmTm = alarmTm;
    }

    /**
     * 停留时间
     * @return stay_tm 停留时间
     */
    public Long getStayTm() {
        return stayTm;
    }

    /**
     * 停留时间
     * @param stayTm 停留时间
     */
    public void setStayTm(Long stayTm) {
        this.stayTm = stayTm;
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