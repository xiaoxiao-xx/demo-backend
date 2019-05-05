package com.rainyhon.common.model;

public class AlarmMode {
    /**
     * 
     */
    private String id;

    /**
     * 告警方式
     */
    private String alarmMode;

    /**
     * 状态
     */
    private String state;

    /**
     * 触发动作
     */
    private String action;

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
     * 告警方式
     * @return alarm_mode 告警方式
     */
    public String getAlarmMode() {
        return alarmMode;
    }

    /**
     * 告警方式
     * @param alarmMode 告警方式
     */
    public void setAlarmMode(String alarmMode) {
        this.alarmMode = alarmMode == null ? null : alarmMode.trim();
    }

    /**
     * 状态
     * @return state 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 状态
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 触发动作
     * @return action 触发动作
     */
    public String getAction() {
        return action;
    }

    /**
     * 触发动作
     * @param action 触发动作
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }
}