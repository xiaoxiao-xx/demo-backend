package com.microcore.center.model;

import java.util.Date;

public class PsmScheduleDetail {
    /**
     * 
     */
    private String id;

    /**
     * 团队或个人
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
     * 开始时间：完整时间yyyymmddhh24miss
     */
    private Date startTime;

    /**
     * 结束时间：完整时间yyyymmddhh24miss
     */
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
     * 团队或个人
     * @return object_type 团队或个人
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * 团队或个人
     * @param objectType 团队或个人
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
     * 开始时间：完整时间yyyymmddhh24miss
     * @return start_time 开始时间：完整时间yyyymmddhh24miss
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间：完整时间yyyymmddhh24miss
     * @param startTime 开始时间：完整时间yyyymmddhh24miss
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间：完整时间yyyymmddhh24miss
     * @return end_time 结束时间：完整时间yyyymmddhh24miss
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间：完整时间yyyymmddhh24miss
     * @param endTime 结束时间：完整时间yyyymmddhh24miss
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
}