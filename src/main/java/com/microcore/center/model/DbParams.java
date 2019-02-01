package com.microcore.center.model;

public class DbParams {
    /**
     * ID
     */
    private String id;

    /**
     * 类型
     */
    private String paramsType;

    /**
     * 值
     */
    private String paramsKey;

    /**
     * 描述
     */
    private String paramsValue;

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
     * 类型
     * @return params_type 类型
     */
    public String getParamsType() {
        return paramsType;
    }

    /**
     * 类型
     * @param paramsType 类型
     */
    public void setParamsType(String paramsType) {
        this.paramsType = paramsType == null ? null : paramsType.trim();
    }

    /**
     * 值
     * @return params_key 值
     */
    public String getParamsKey() {
        return paramsKey;
    }

    /**
     * 值
     * @param paramsKey 值
     */
    public void setParamsKey(String paramsKey) {
        this.paramsKey = paramsKey == null ? null : paramsKey.trim();
    }

    /**
     * 描述
     * @return params_value 描述
     */
    public String getParamsValue() {
        return paramsValue;
    }

    /**
     * 描述
     * @param paramsValue 描述
     */
    public void setParamsValue(String paramsValue) {
        this.paramsValue = paramsValue == null ? null : paramsValue.trim();
    }
}