package com.rainyhon.common.model;

import java.util.Date;

public class Detail {
    /**
     * ID
     */
    private String id;

    /**
     * 汇总结果ID
     */
    private String summaryId;

    /**
     * 区域ID
     */
    private String areaId;

    /**
     * 人员ID
     */
    private String userId;

    /**
     * 人员姓名
     */
    private String userName;

    /**
     * 人员出现时间
     */
    private Date time;

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
     * 汇总结果ID
     * @return summary_id 汇总结果ID
     */
    public String getSummaryId() {
        return summaryId;
    }

    /**
     * 汇总结果ID
     * @param summaryId 汇总结果ID
     */
    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
    }

    /**
     * 区域ID
     * @return area_id 区域ID
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 区域ID
     * @param areaId 区域ID
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**
     * 人员ID
     * @return user_id 人员ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 人员ID
     * @param userId 人员ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 人员姓名
     * @return user_name 人员姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 人员姓名
     * @param userName 人员姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 人员出现时间
     * @return time 人员出现时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 人员出现时间
     * @param time 人员出现时间
     */
    public void setTime(Date time) {
        this.time = time;
    }
}