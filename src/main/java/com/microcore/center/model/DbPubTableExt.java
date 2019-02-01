package com.microcore.center.model;

public class DbPubTableExt {
    /**
     * 字段/模型ID
     */
    private String id;

    /**
     * 扩展属性中文名
     */
    private String extAttrCname;

    /**
     * 扩展属性英文名
     */
    private String extAttrEname;

    /**
     * 扩展数据
     */
    private String extValue;

    /**
     * 模板类型（模型，字段）
     */
    private String templateType;

    /**
     * 标签ID
     */
    private String labelId;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 字段/模型ID
     * @return id 字段/模型ID
     */
    public String getId() {
        return id;
    }

    /**
     * 字段/模型ID
     * @param id 字段/模型ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 扩展属性中文名
     * @return ext_attr_cname 扩展属性中文名
     */
    public String getExtAttrCname() {
        return extAttrCname;
    }

    /**
     * 扩展属性中文名
     * @param extAttrCname 扩展属性中文名
     */
    public void setExtAttrCname(String extAttrCname) {
        this.extAttrCname = extAttrCname == null ? null : extAttrCname.trim();
    }

    /**
     * 扩展属性英文名
     * @return ext_attr_ename 扩展属性英文名
     */
    public String getExtAttrEname() {
        return extAttrEname;
    }

    /**
     * 扩展属性英文名
     * @param extAttrEname 扩展属性英文名
     */
    public void setExtAttrEname(String extAttrEname) {
        this.extAttrEname = extAttrEname == null ? null : extAttrEname.trim();
    }

    /**
     * 扩展数据
     * @return ext_value 扩展数据
     */
    public String getExtValue() {
        return extValue;
    }

    /**
     * 扩展数据
     * @param extValue 扩展数据
     */
    public void setExtValue(String extValue) {
        this.extValue = extValue == null ? null : extValue.trim();
    }

    /**
     * 模板类型（模型，字段）
     * @return template_type 模板类型（模型，字段）
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 模板类型（模型，字段）
     * @param templateType 模板类型（模型，字段）
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType == null ? null : templateType.trim();
    }

    /**
     * 标签ID
     * @return label_id 标签ID
     */
    public String getLabelId() {
        return labelId;
    }

    /**
     * 标签ID
     * @param labelId 标签ID
     */
    public void setLabelId(String labelId) {
        this.labelId = labelId == null ? null : labelId.trim();
    }

    /**
     * 数据类型
     * @return data_type 数据类型
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 数据类型
     * @param dataType 数据类型
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }
}