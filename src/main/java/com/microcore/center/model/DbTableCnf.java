package com.microcore.center.model;

public class DbTableCnf {
    /**
     * 
     */
    private String id;

    /**
     * 数据源链接id
     */
    private String pid;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表注释
     */
    private String tableNote;

    /**
     * 排序
     */
    private Integer sort;

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
     * 数据源链接id
     * @return pid 数据源链接id
     */
    public String getPid() {
        return pid;
    }

    /**
     * 数据源链接id
     * @param pid 数据源链接id
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
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
     * 表注释
     * @return table_note 表注释
     */
    public String getTableNote() {
        return tableNote;
    }

    /**
     * 表注释
     * @param tableNote 表注释
     */
    public void setTableNote(String tableNote) {
        this.tableNote = tableNote == null ? null : tableNote.trim();
    }

    /**
     * 排序
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}