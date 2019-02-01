package com.microcore.center.model;

public class DbColumnComment {
    /**
     * ID
     */
    private String id;

    /**
     * 数据库连接ID
     */
    private String conId;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 用户对字段的自定义注释
     */
    private String comment;

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
     * 数据库连接ID
     * @return con_id 数据库连接ID
     */
    public String getConId() {
        return conId;
    }

    /**
     * 数据库连接ID
     * @param conId 数据库连接ID
     */
    public void setConId(String conId) {
        this.conId = conId == null ? null : conId.trim();
    }

    /**
     * 表名
     * @return table_name 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 表名
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 字段名
     * @return column_name 字段名
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 字段名
     * @param columnName 字段名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 用户对字段的自定义注释
     * @return comment 用户对字段的自定义注释
     */
    public String getComment() {
        return comment;
    }

    /**
     * 用户对字段的自定义注释
     * @param comment 用户对字段的自定义注释
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}