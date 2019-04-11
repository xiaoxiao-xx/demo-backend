package com.microcore.center.model;

import java.util.Date;

public class PsmRealAlarm {
    /**
     * 
     */
    private String id;

    /**
     * 告警类型
     */
    private String alarmType;

    /**
     * 告警对象类型
     */
    private String objectType;

    /**
     * 告警对象标识
     */
    private String objectId;

    /**
     * 告警原因
     */
    private String alarmReason;

    /**
     * 触发时间
     */
    private Date triggerTime;

    /**
     * 状态：初始/已确认/错误告警/超时
     */
    private String state;

    /**
     * 处理人
     */
    private String operator;

    /**
     * 处理意见
     */
    private String remark;

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

    /**
     * 告警对象类型
     * @return object_type 告警对象类型
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * 告警对象类型
     * @param objectType 告警对象类型
     */
    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    /**
     * 告警对象标识
     * @return object_id 告警对象标识
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * 告警对象标识
     * @param objectId 告警对象标识
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * 告警原因
     * @return alarm_reason 告警原因
     */
    public String getAlarmReason() {
        return alarmReason;
    }

    /**
     * 告警原因
     * @param alarmReason 告警原因
     */
    public void setAlarmReason(String alarmReason) {
        this.alarmReason = alarmReason == null ? null : alarmReason.trim();
    }

    /**
     * 触发时间
     * @return trigger_time 触发时间
     */
    public Date getTriggerTime() {
        return triggerTime;
    }

    /**
     * 触发时间
     * @param triggerTime 触发时间
     */
    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }

    /**
     * 状态：初始/已确认/错误告警/超时
     * @return state 状态：初始/已确认/错误告警/超时
     */
    public String getState() {
        return state;
    }

    /**
     * 状态：初始/已确认/错误告警/超时
     * @param state 状态：初始/已确认/错误告警/超时
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 处理人
     * @return operator 处理人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 处理人
     * @param operator 处理人
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 处理意见
     * @return remark 处理意见
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 处理意见
     * @param remark 处理意见
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}