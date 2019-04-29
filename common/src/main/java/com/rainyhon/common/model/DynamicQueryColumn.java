package com.rainyhon.common.model;

public class DynamicQueryColumn {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String columnName;

    /**
     * 
     */
    private String columnDisplayName;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String dictionaryId;

    /**
     * 
     */
    private String dqId;

    /**
     * 
     */
    private Integer orderIndex;

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
     * @return column_name 
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 
     * @param columnName 
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 
     * @return column_display_name 
     */
    public String getColumnDisplayName() {
        return columnDisplayName;
    }

    /**
     * 
     * @param columnDisplayName 
     */
    public void setColumnDisplayName(String columnDisplayName) {
        this.columnDisplayName = columnDisplayName == null ? null : columnDisplayName.trim();
    }

    /**
     * 
     * @return type 
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type 
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 
     * @return dictionary_id 
     */
    public String getDictionaryId() {
        return dictionaryId;
    }

    /**
     * 
     * @param dictionaryId 
     */
    public void setDictionaryId(String dictionaryId) {
        this.dictionaryId = dictionaryId == null ? null : dictionaryId.trim();
    }

    /**
     * 
     * @return dq_id 
     */
    public String getDqId() {
        return dqId;
    }

    /**
     * 
     * @param dqId 
     */
    public void setDqId(String dqId) {
        this.dqId = dqId == null ? null : dqId.trim();
    }

    /**
     * 
     * @return order_index 
     */
    public Integer getOrderIndex() {
        return orderIndex;
    }

    /**
     * 
     * @param orderIndex 
     */
    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}