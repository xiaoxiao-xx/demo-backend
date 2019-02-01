package com.microcore.center.model;

public class DbPubTableRel {
    /**
     * 
     */
    private String id;

    /**
     * 发布ID
     */
    private String pubId;

    /**
     * 
     */
    private String tableName1;

    /**
     * 
     */
    private String columnName1;

    /**
     * 
     */
    private String tableName2;

    /**
     * 
     */
    private String columnName2;

    /**
     * 关联类型
     */
    private String type;

    /**
     * 数据
     */
    private String value;

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
     * 发布ID
     * @return pub_id 发布ID
     */
    public String getPubId() {
        return pubId;
    }

    /**
     * 发布ID
     * @param pubId 发布ID
     */
    public void setPubId(String pubId) {
        this.pubId = pubId == null ? null : pubId.trim();
    }

    /**
     * 
     * @return table_name1 
     */
    public String getTableName1() {
        return tableName1;
    }

    /**
     * 
     * @param tableName1 
     */
    public void setTableName1(String tableName1) {
        this.tableName1 = tableName1 == null ? null : tableName1.trim();
    }

    /**
     * 
     * @return column_name1 
     */
    public String getColumnName1() {
        return columnName1;
    }

    /**
     * 
     * @param columnName1 
     */
    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1 == null ? null : columnName1.trim();
    }

    /**
     * 
     * @return table_name2 
     */
    public String getTableName2() {
        return tableName2;
    }

    /**
     * 
     * @param tableName2 
     */
    public void setTableName2(String tableName2) {
        this.tableName2 = tableName2 == null ? null : tableName2.trim();
    }

    /**
     * 
     * @return column_name2 
     */
    public String getColumnName2() {
        return columnName2;
    }

    /**
     * 
     * @param columnName2 
     */
    public void setColumnName2(String columnName2) {
        this.columnName2 = columnName2 == null ? null : columnName2.trim();
    }

    /**
     * 关联类型
     * @return type 关联类型
     */
    public String getType() {
        return type;
    }

    /**
     * 关联类型
     * @param type 关联类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 数据
     * @return value 数据
     */
    public String getValue() {
        return value;
    }

    /**
     * 数据
     * @param value 数据
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}