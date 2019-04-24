package com.microcore.center.model;

import java.util.Date;

public class AlarmPolicy {
    /**
     * ID
     */
    private String id;

    /**
     * 策略名称
     */
    private String policyName;

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
    private String alarmModeId;

    /**
     * 告警类型 (考勤, 值班 ...)
     */
    private String alarmType;

    /**
     * 告警级别 (一级, 二级 ...)
     */
    private String alarmLevel;

    /**
     * 告警对象ID
     */
    private String objectId;

    /**
     * 告警对象类型
     */
    private String objectType;

    /**
     * 归属人
     */
    private String owner;

    /**
     * 删除状态 
     */
    private String delStatus;

    /**
     * 最后修改人ID 
     */
    private String updUserId;

    /**
     * 最后修改机构ID 
     */
    private String updOrgId;

    /**
     * 最后修改时间 
     */
    private Date updTm;

    /**
     * 创建人ID
     */
    private String crtUserId;

    /**
     * 创建机构ID
     */
    private String crtOrgId;

    /**
     * 创建时间
     */
    private Date crtTm;

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
     * 策略名称
     * @return policy_name 策略名称
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * 策略名称
     * @param policyName 策略名称
     */
    public void setPolicyName(String policyName) {
        this.policyName = policyName == null ? null : policyName.trim();
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
     * @return alarm_mode_id 告警方式
     */
    public String getAlarmModeId() {
        return alarmModeId;
    }

    /**
     * 告警方式
     * @param alarmModeId 告警方式
     */
    public void setAlarmModeId(String alarmModeId) {
        this.alarmModeId = alarmModeId == null ? null : alarmModeId.trim();
    }

    /**
     * 告警类型 (考勤, 值班 ...)
     * @return alarm_type 告警类型 (考勤, 值班 ...)
     */
    public String getAlarmType() {
        return alarmType;
    }

    /**
     * 告警类型 (考勤, 值班 ...)
     * @param alarmType 告警类型 (考勤, 值班 ...)
     */
    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType == null ? null : alarmType.trim();
    }

    /**
     * 告警级别 (一级, 二级 ...)
     * @return alarm_level 告警级别 (一级, 二级 ...)
     */
    public String getAlarmLevel() {
        return alarmLevel;
    }

    /**
     * 告警级别 (一级, 二级 ...)
     * @param alarmLevel 告警级别 (一级, 二级 ...)
     */
    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel == null ? null : alarmLevel.trim();
    }

    /**
     * 告警对象ID
     * @return object_id 告警对象ID
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * 告警对象ID
     * @param objectId 告警对象ID
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
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
     * 归属人
     * @return owner 归属人
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 归属人
     * @param owner 归属人
     */
    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
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

    /**
     * 最后修改人ID 
     * @return upd_user_id 最后修改人ID 
     */
    public String getUpdUserId() {
        return updUserId;
    }

    /**
     * 最后修改人ID 
     * @param updUserId 最后修改人ID 
     */
    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId == null ? null : updUserId.trim();
    }

    /**
     * 最后修改机构ID 
     * @return upd_org_id 最后修改机构ID 
     */
    public String getUpdOrgId() {
        return updOrgId;
    }

    /**
     * 最后修改机构ID 
     * @param updOrgId 最后修改机构ID 
     */
    public void setUpdOrgId(String updOrgId) {
        this.updOrgId = updOrgId == null ? null : updOrgId.trim();
    }

    /**
     * 最后修改时间 
     * @return upd_tm 最后修改时间 
     */
    public Date getUpdTm() {
        return updTm;
    }

    /**
     * 最后修改时间 
     * @param updTm 最后修改时间 
     */
    public void setUpdTm(Date updTm) {
        this.updTm = updTm;
    }

    /**
     * 创建人ID
     * @return crt_user_id 创建人ID
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /**
     * 创建人ID
     * @param crtUserId 创建人ID
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId == null ? null : crtUserId.trim();
    }

    /**
     * 创建机构ID
     * @return crt_org_id 创建机构ID
     */
    public String getCrtOrgId() {
        return crtOrgId;
    }

    /**
     * 创建机构ID
     * @param crtOrgId 创建机构ID
     */
    public void setCrtOrgId(String crtOrgId) {
        this.crtOrgId = crtOrgId == null ? null : crtOrgId.trim();
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