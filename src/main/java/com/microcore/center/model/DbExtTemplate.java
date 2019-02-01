package com.microcore.center.model;

public class DbExtTemplate {
    /**
     * ID
     */
    private String id;

    /**
     * 自定义策略中文名
     */
    private String extPolicyCname;

    /**
     * 自定义策略英文名
     */
    private String extPolicyEname;

    /**
     * 版本号
     */
    private String version;

    /**
     * 数据类型（字符，日期，枚举 ...）
     */
    private String dataType;

    /**
     * 枚举取值的查询键
     */
    private String enumKey;

    /**
     * 备注
     */
    private String extComment;

    /**
     * 模板类型（模型，字段）
     */
    private String templateType;

    /**
     * 是否显示
     */
    private String visiable;

    /**
     * 删除状态
     */
    private String delStatus;

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
     * 自定义策略中文名
     * @return ext_policy_cname 自定义策略中文名
     */
    public String getExtPolicyCname() {
        return extPolicyCname;
    }

    /**
     * 自定义策略中文名
     * @param extPolicyCname 自定义策略中文名
     */
    public void setExtPolicyCname(String extPolicyCname) {
        this.extPolicyCname = extPolicyCname == null ? null : extPolicyCname.trim();
    }

    /**
     * 自定义策略英文名
     * @return ext_policy_ename 自定义策略英文名
     */
    public String getExtPolicyEname() {
        return extPolicyEname;
    }

    /**
     * 自定义策略英文名
     * @param extPolicyEname 自定义策略英文名
     */
    public void setExtPolicyEname(String extPolicyEname) {
        this.extPolicyEname = extPolicyEname == null ? null : extPolicyEname.trim();
    }

    /**
     * 版本号
     * @return version 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 版本号
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 数据类型（字符，日期，枚举 ...）
     * @return data_type 数据类型（字符，日期，枚举 ...）
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 数据类型（字符，日期，枚举 ...）
     * @param dataType 数据类型（字符，日期，枚举 ...）
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 枚举取值的查询键
     * @return enum_key 枚举取值的查询键
     */
    public String getEnumKey() {
        return enumKey;
    }

    /**
     * 枚举取值的查询键
     * @param enumKey 枚举取值的查询键
     */
    public void setEnumKey(String enumKey) {
        this.enumKey = enumKey == null ? null : enumKey.trim();
    }

    /**
     * 备注
     * @return ext_comment 备注
     */
    public String getExtComment() {
        return extComment;
    }

    /**
     * 备注
     * @param extComment 备注
     */
    public void setExtComment(String extComment) {
        this.extComment = extComment == null ? null : extComment.trim();
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
     * 是否显示
     * @return visiable 是否显示
     */
    public String getVisiable() {
        return visiable;
    }

    /**
     * 是否显示
     * @param visiable 是否显示
     */
    public void setVisiable(String visiable) {
        this.visiable = visiable == null ? null : visiable.trim();
    }

    /**
     * 删除状态
     * @return del_status 删除状态
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 删除状态
     * @param delStatus 删除状态
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
    }
}