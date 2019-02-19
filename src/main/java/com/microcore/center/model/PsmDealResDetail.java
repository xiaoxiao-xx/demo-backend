package com.microcore.center.model;

import java.util.Date;

public class PsmDealResDetail {
    /**
     * 处理结果表ID
     */
    private String resId;

    /**
     * 素材ID
     */
    private String srcId;

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
     * 人物：也可以是车辆，记录某一个对象
     */
    private String character;

    /**
     * 事件
     */
    private String event;

    /**
     * 是否告警
     */
    private String alarmState;

    /**
     * 告警类型
     */
    private String alarmType;

    /**
     * 处理结果表ID
     * @return res_id 处理结果表ID
     */
    public String getResId() {
        return resId;
    }

    /**
     * 处理结果表ID
     * @param resId 处理结果表ID
     */
    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
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
     * 人物：也可以是车辆，记录某一个对象
     * @return character 人物：也可以是车辆，记录某一个对象
     */
    public String getCharacter() {
        return character;
    }

    /**
     * 人物：也可以是车辆，记录某一个对象
     * @param character 人物：也可以是车辆，记录某一个对象
     */
    public void setCharacter(String character) {
        this.character = character == null ? null : character.trim();
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