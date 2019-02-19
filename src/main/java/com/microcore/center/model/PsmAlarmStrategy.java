package com.microcore.center.model;

public class PsmAlarmStrategy {
    /**
     * 
     */
    private String id;

    /**
     * 告警类型
     */
    private String alarmType;

    /**
     * 策略名称
     */
    private String strategy;

    /**
     * 状态
     */
    private String state;

    /**
     * 触发条件
     */
    private String expr;

    /**
     * 告警方式
     */
    private String alarmMode;

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
     * 策略名称
     * @return strategy 策略名称
     */
    public String getStrategy() {
        return strategy;
    }

    /**
     * 策略名称
     * @param strategy 策略名称
     */
    public void setStrategy(String strategy) {
        this.strategy = strategy == null ? null : strategy.trim();
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
     * 触发条件
     * @return expr 触发条件
     */
    public String getExpr() {
        return expr;
    }

    /**
     * 触发条件
     * @param expr 触发条件
     */
    public void setExpr(String expr) {
        this.expr = expr == null ? null : expr.trim();
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
}