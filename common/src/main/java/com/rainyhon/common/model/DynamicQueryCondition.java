package com.rainyhon.common.model;

public class DynamicQueryCondition {
    /**
     * 
     */
    private String id;

    /**
     * Dynamic_Query_Column的ID
     */
    private String dqcId;

    /**
     * 
     */
    private String value;

    /**
     * 
     */
    private String condition;

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
     * Dynamic_Query_Column的ID
     * @return dqc_id Dynamic_Query_Column的ID
     */
    public String getDqcId() {
        return dqcId;
    }

    /**
     * Dynamic_Query_Column的ID
     * @param dqcId Dynamic_Query_Column的ID
     */
    public void setDqcId(String dqcId) {
        this.dqcId = dqcId == null ? null : dqcId.trim();
    }

    /**
     * 
     * @return value 
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value 
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 
     * @return condition 
     */
    public String getCondition() {
        return condition;
    }

    /**
     * 
     * @param condition 
     */
    public void setCondition(String condition) {
        this.condition = condition == null ? null : condition.trim();
    }
}