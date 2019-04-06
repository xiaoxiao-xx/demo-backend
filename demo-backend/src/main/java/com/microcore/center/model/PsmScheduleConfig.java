package com.microcore.center.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PsmScheduleConfig {
    /**
     * 
     */
    private String id;

    /**
     * 配置类型
     */
    private String configType;

    /**
     * 是否选择个人,是否
     */
    private String selectFlag;

    /**
     * 团队ID
     */
    private String teamId;

    /**
     * 团队或个人标志
     */
    private String objectType;

    /**
     * 团队或个人ID
     */
    private String objectId;

    /**
     * 人数
     */
    private Integer number;

    /**
     * 日期
     */
    private Date someDate;

    /**
     * 开始时间：只有时分秒hh24miss
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 结束时间：只有时分秒hh24miss
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 地点
     */
    private String address;

    /**
     * 事件
     */
    private String event;

    /**
     * 老师
     */
    private String teacher;

    /**
     * 重复标志：每日重复/每周重复/每月重复/不重复
     */
    private String repeatType;

    /**
     * 考核开始时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date checkStartTime;

    /**
     * 考核结束时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date checkEndTime;

    /**
     * 考核标识，是否
     */
    private String checkFlag;

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
     * 配置类型
     * @return config_type 配置类型
     */
    public String getConfigType() {
        return configType;
    }

    /**
     * 配置类型
     * @param configType 配置类型
     */
    public void setConfigType(String configType) {
        this.configType = configType == null ? null : configType.trim();
    }

    /**
     * 是否选择个人,是否
     * @return select_flag 是否选择个人,是否
     */
    public String getSelectFlag() {
        return selectFlag;
    }

    /**
     * 是否选择个人,是否
     * @param selectFlag 是否选择个人,是否
     */
    public void setSelectFlag(String selectFlag) {
        this.selectFlag = selectFlag == null ? null : selectFlag.trim();
    }

    /**
     * 团队ID
     * @return team_id 团队ID
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * 团队ID
     * @param teamId 团队ID
     */
    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    /**
     * 团队或个人标志
     * @return object_type 团队或个人标志
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * 团队或个人标志
     * @param objectType 团队或个人标志
     */
    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    /**
     * 团队或个人ID
     * @return object_id 团队或个人ID
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * 团队或个人ID
     * @param objectId 团队或个人ID
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * 人数
     * @return number 人数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 人数
     * @param number 人数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 日期
     * @return some_date 日期
     */
    public Date getSomeDate() {
        return someDate;
    }

    /**
     * 日期
     * @param someDate 日期
     */
    public void setSomeDate(Date someDate) {
        this.someDate = someDate;
    }

    /**
     * 开始时间：只有时分秒hh24miss
     * @return start_time 开始时间：只有时分秒hh24miss
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间：只有时分秒hh24miss
     * @param startTime 开始时间：只有时分秒hh24miss
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间：只有时分秒hh24miss
     * @return end_time 结束时间：只有时分秒hh24miss
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间：只有时分秒hh24miss
     * @param endTime 结束时间：只有时分秒hh24miss
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 地点
     * @return address 地点
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地点
     * @param address 地点
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 事件
     * @return event 事件
     */
    public String getEvent() {
        return event;
    }

    /**
     * 事件
     * @param event 事件
     */
    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    /**
     * 老师
     * @return teacher 老师
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * 老师
     * @param teacher 老师
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    /**
     * 重复标志：每日重复/每周重复/每月重复/不重复
     * @return repeat_type 重复标志：每日重复/每周重复/每月重复/不重复
     */
    public String getRepeatType() {
        return repeatType;
    }

    /**
     * 重复标志：每日重复/每周重复/每月重复/不重复
     * @param repeatType 重复标志：每日重复/每周重复/每月重复/不重复
     */
    public void setRepeatType(String repeatType) {
        this.repeatType = repeatType == null ? null : repeatType.trim();
    }

    /**
     * 考核开始时间
     * @return check_start_time 考核开始时间
     */
    public Date getCheckStartTime() {
        return checkStartTime;
    }

    /**
     * 考核开始时间
     * @param checkStartTime 考核开始时间
     */
    public void setCheckStartTime(Date checkStartTime) {
        this.checkStartTime = checkStartTime;
    }

    /**
     * 考核结束时间
     * @return check_end_time 考核结束时间
     */
    public Date getCheckEndTime() {
        return checkEndTime;
    }

    /**
     * 考核结束时间
     * @param checkEndTime 考核结束时间
     */
    public void setCheckEndTime(Date checkEndTime) {
        this.checkEndTime = checkEndTime;
    }

    /**
     * 考核标识，是否
     * @return check_flag 考核标识，是否
     */
    public String getCheckFlag() {
        return checkFlag;
    }

    /**
     * 考核标识，是否
     * @param checkFlag 考核标识，是否
     */
    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag == null ? null : checkFlag.trim();
    }
}