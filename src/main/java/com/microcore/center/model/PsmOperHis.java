package com.microcore.center.model;

import java.util.Date;

public class PsmOperHis {
    /**
     * 
     */
    private String id;

    /**
     * 操作时间
     */
    private Date operTime;

    /**
     * 操作类型
     */
    private String operType;

    /**
     * 操作对象
     */
    private String operTarget;

    /**
     * 操作内容
     */
    private String operContent;

    /**
     * 操作员
     */
    private String operator;

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
     * 操作时间
     * @return oper_time 操作时间
     */
    public Date getOperTime() {
        return operTime;
    }

    /**
     * 操作时间
     * @param operTime 操作时间
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    /**
     * 操作类型
     * @return oper_type 操作类型
     */
    public String getOperType() {
        return operType;
    }

    /**
     * 操作类型
     * @param operType 操作类型
     */
    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    /**
     * 操作对象
     * @return oper_target 操作对象
     */
    public String getOperTarget() {
        return operTarget;
    }

    /**
     * 操作对象
     * @param operTarget 操作对象
     */
    public void setOperTarget(String operTarget) {
        this.operTarget = operTarget == null ? null : operTarget.trim();
    }

    /**
     * 操作内容
     * @return oper_content 操作内容
     */
    public String getOperContent() {
        return operContent;
    }

    /**
     * 操作内容
     * @param operContent 操作内容
     */
    public void setOperContent(String operContent) {
        this.operContent = operContent == null ? null : operContent.trim();
    }

    /**
     * 操作员
     * @return operator 操作员
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 操作员
     * @param operator 操作员
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}