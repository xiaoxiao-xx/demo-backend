package com.rainyhon.common.model;

public class DynamicQueryCondition {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String columnId;

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
     * 
     * @return column_id 
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * 
     * @param columnId 
     */
    public void setColumnId(String columnId) {
        this.columnId = columnId == null ? null : columnId.trim();
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