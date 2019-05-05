package com.rainyhon.common.model;

import java.util.Date;

public class DealRes {
    /**
     * 
     */
    private String id;

    /**
     * 素材ID
     */
    private String srcId;

    /**
     * 处理状态：未开始/正在识别/告警比对/完成处理
     */
    private String dealState;

    /**
     * 处理开始时间
     */
    private Date startTime;

    /**
     * 处理完成时间
     */
    private Date completeTime;

    /**
     * 是否有效素材
     */
    private String validState;

    /**
     * 时间
     */
    private Date time;

    /**
     * 地点
     */
    private String address;

    /**
     * 人物：也可以是车辆，把所有识别出来的对象用逗号隔开，记录在该字段
     */
    private String characters;

    /**
     * 事件
     */
    private String dealEvent;

    /**
     * 是否告警
     */
    private String alarmState;

    /**
     * 告警类型
     */
    private String alarmType;

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
     * 素材ID
     * @return src_id 素材ID
     */
    public String getSrcId() {
        return srcId;
    }

    /**
     * 素材ID
     * @param srcId 素材ID
     */
    public void setSrcId(String srcId) {
        this.srcId = srcId == null ? null : srcId.trim();
    }

    /**
     * 处理状态：未开始/正在识别/告警比对/完成处理
     * @return deal_state 处理状态：未开始/正在识别/告警比对/完成处理
     */
    public String getDealState() {
        return dealState;
    }

    /**
     * 处理状态：未开始/正在识别/告警比对/完成处理
     * @param dealState 处理状态：未开始/正在识别/告警比对/完成处理
     */
    public void setDealState(String dealState) {
        this.dealState = dealState == null ? null : dealState.trim();
    }

    /**
     * 处理开始时间
     * @return start_time 处理开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 处理开始时间
     * @param startTime 处理开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 处理完成时间
     * @return complete_time 处理完成时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 处理完成时间
     * @param completeTime 处理完成时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * 是否有效素材
     * @return valid_state 是否有效素材
     */
    public String getValidState() {
        return validState;
    }

    /**
     * 是否有效素材
     * @param validState 是否有效素材
     */
    public void setValidState(String validState) {
        this.validState = validState == null ? null : validState.trim();
    }

    /**
     * 时间
     * @return time 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 时间
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
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
     * 人物：也可以是车辆，把所有识别出来的对象用逗号隔开，记录在该字段
     * @return characters 人物：也可以是车辆，把所有识别出来的对象用逗号隔开，记录在该字段
     */
    public String getCharacters() {
        return characters;
    }

    /**
     * 人物：也可以是车辆，把所有识别出来的对象用逗号隔开，记录在该字段
     * @param characters 人物：也可以是车辆，把所有识别出来的对象用逗号隔开，记录在该字段
     */
    public void setCharacters(String characters) {
        this.characters = characters == null ? null : characters.trim();
    }

    /**
     * 事件
     * @return deal_event 事件
     */
    public String getDealEvent() {
        return dealEvent;
    }

    /**
     * 事件
     * @param dealEvent 事件
     */
    public void setDealEvent(String dealEvent) {
        this.dealEvent = dealEvent == null ? null : dealEvent.trim();
    }

    /**
     * 是否告警
     * @return alarm_state 是否告警
     */
    public String getAlarmState() {
        return alarmState;
    }

    /**
     * 是否告警
     * @param alarmState 是否告警
     */
    public void setAlarmState(String alarmState) {
        this.alarmState = alarmState == null ? null : alarmState.trim();
    }

    /**
     * 告警类型
     * @return alarm_type 告警类型
     */
    public String getAlarmType() {
        return alarmType;
    }

    /**
     * 告警类型
     * @param alarmType 告警类型
     */
    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType == null ? null : alarmType.trim();
    }
}