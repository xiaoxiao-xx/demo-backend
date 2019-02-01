package com.microcore.center.model;

import java.util.Date;

public class RealTime {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String userId;

    /**
     * 开始时间
     */
    private Date startTm;

    /**
     * 结束时间
     */
    private Date endTm;

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
     * 开始时间
     * @return start_tm 开始时间
     */
    public Date getStartTm() {
        return startTm;
    }

    /**
     * 开始时间
     * @param startTm 开始时间
     */
    public void setStartTm(Date startTm) {
        this.startTm = startTm;
    }

    /**
     * 结束时间
     * @return end_tm 结束时间
     */
    public Date getEndTm() {
        return endTm;
    }

    /**
     * 结束时间
     * @param endTm 结束时间
     */
    public void setEndTm(Date endTm) {
        this.endTm = endTm;
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