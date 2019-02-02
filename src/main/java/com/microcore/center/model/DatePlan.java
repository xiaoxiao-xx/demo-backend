package com.microcore.center.model;

import java.util.Date;

public class DatePlan {
    /**
     * 
     */
    private String id;

    /**
     * 日期
     */
    private Date doTm;

    /**
     * 时间段
     */
    private String tmSlot;

    /**
     * 日程安排
     */
    private String plan;

    /**
     * 团队
     */
    private String team;

    /**
     * 地点
     */
    private String place;

    /**
     * 教官
     */
    private String teacher;

    /**
     * 创建时间
     */
    private Date crtTm;

    /**
     * 删除状态
     */
    private String delStatus;

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
     * 日期
     * @return do_tm 日期
     */
    public Date getDoTm() {
        return doTm;
    }

    /**
     * 日期
     * @param doTm 日期
     */
    public void setDoTm(Date doTm) {
        this.doTm = doTm;
    }

    /**
     * 时间段
     * @return tm_slot 时间段
     */
    public String getTmSlot() {
        return tmSlot;
    }

    /**
     * 时间段
     * @param tmSlot 时间段
     */
    public void setTmSlot(String tmSlot) {
        this.tmSlot = tmSlot == null ? null : tmSlot.trim();
    }

    /**
     * 日程安排
     * @return plan 日程安排
     */
    public String getPlan() {
        return plan;
    }

    /**
     * 日程安排
     * @param plan 日程安排
     */
    public void setPlan(String plan) {
        this.plan = plan == null ? null : plan.trim();
    }

    /**
     * 团队
     * @return team 团队
     */
    public String getTeam() {
        return team;
    }

    /**
     * 团队
     * @param team 团队
     */
    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }

    /**
     * 地点
     * @return place 地点
     */
    public String getPlace() {
        return place;
    }

    /**
     * 地点
     * @param place 地点
     */
    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    /**
     * 教官
     * @return teacher 教官
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * 教官
     * @param teacher 教官
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
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
}