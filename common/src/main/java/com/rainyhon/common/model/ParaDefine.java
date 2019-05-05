package com.rainyhon.common.model;

public class ParaDefine {
    /**
     * 参数类型
     */
    private String paraType;

    /**
     * 参数编码
     */
    private String paraCode;

    /**
     * 参数值
     */
    private String paraValue;

    /**
     * 是否有效
     */
    private String state;

    /**
     * 参数类型
     * @return para_type 参数类型
     */
    public String getParaType() {
        return paraType;
    }

    /**
     * 参数类型
     * @param paraType 参数类型
     */
    public void setParaType(String paraType) {
        this.paraType = paraType == null ? null : paraType.trim();
    }

    /**
     * 参数编码
     * @return para_code 参数编码
     */
    public String getParaCode() {
        return paraCode;
    }

    /**
     * 参数编码
     * @param paraCode 参数编码
     */
    public void setParaCode(String paraCode) {
        this.paraCode = paraCode == null ? null : paraCode.trim();
    }

    /**
     * 参数值
     * @return para_value 参数值
     */
    public String getParaValue() {
        return paraValue;
    }

    /**
     * 参数值
     * @param paraValue 参数值
     */
    public void setParaValue(String paraValue) {
        this.paraValue = paraValue == null ? null : paraValue.trim();
    }

    /**
     * 是否有效
     * @return state 是否有效
     */
    public String getState() {
        return state;
    }

    /**
     * 是否有效
     * @param state 是否有效
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}