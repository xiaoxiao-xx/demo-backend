package com.microcore.center.model;

public class DbFieldCnf {
    /**
     * 
     */
    private String id;

    /**
     * 表id
     */
    private String pid;

    /**
     * 数据源链接ID
     */
    private String conId;

    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 字段注释
     */
    private String fieldNote;

    /**
     * 字段类型
     */
    private String fieldType;

    /**
     * 是否必填
     */
    private String nullAbled;

    /**
     * 字段长度
     */
    private Integer fieldLength;

    /**
     * 序号
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
     * 表id
     * @return pid 表id
     */
    public String getPid() {
        return pid;
    }

    /**
     * 表id
     * @param pid 表id
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 数据源链接ID
     * @return con_id 数据源链接ID
     */
    public String getConId() {
        return conId;
    }

    /**
     * 数据源链接ID
     * @param conId 数据源链接ID
     */
    public void setConId(String conId) {
        this.conId = conId == null ? null : conId.trim();
    }

    /**
     * 字段名
     * @return field_name 字段名
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 字段名
     * @param fieldName 字段名
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    /**
     * 字段注释
     * @return field_note 字段注释
     */
    public String getFieldNote() {
        return fieldNote;
    }

    /**
     * 字段注释
     * @param fieldNote 字段注释
     */
    public void setFieldNote(String fieldNote) {
        this.fieldNote = fieldNote == null ? null : fieldNote.trim();
    }

    /**
     * 字段类型
     * @return field_type 字段类型
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * 字段类型
     * @param fieldType 字段类型
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    /**
     * 是否必填
     * @return null_abled 是否必填
     */
    public String getNullAbled() {
        return nullAbled;
    }

    /**
     * 是否必填
     * @param nullAbled 是否必填
     */
    public void setNullAbled(String nullAbled) {
        this.nullAbled = nullAbled == null ? null : nullAbled.trim();
    }

    /**
     * 字段长度
     * @return field_length 字段长度
     */
    public Integer getFieldLength() {
        return fieldLength;
    }

    /**
     * 字段长度
     * @param fieldLength 字段长度
     */
    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    /**
     * 序号
     * @return sort 序号
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 序号
     * @param sort 序号
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}