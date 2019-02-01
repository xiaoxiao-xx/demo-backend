package com.microcore.center.vo;
/**
 * 新增或修改接口服务输入输出参数VO类
 */
public class AddServiceParamVo {
    /**
     * 参数ID
     */
    private String id;

    /**
     * 服务接口ID
     */
    private String serviceId;

    /**
     * 参数中文名
     */
    private String chineseName;

    /**
     * 参数英文名
     */
    private String englishName;

    /**
     * 参数类型
     */
    private String type;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 是否必填(是:YES，否:NO)
     */
    private String mustFill;

    /**
     * 输入参数or输出参数(INPUT,OUTPUT)
     */
    private String kind;

    /**
     * 安全权限策略
     */
    private AddAuthPolicyVo authPolicy;


    /**
     * 参数ID
     * @return id 参数ID
     */
    public String getId() {
        return id;
    }

    /**
     * 参数ID
     * @param id 参数ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 服务接口ID
     * @return service_id 服务接口ID
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * 服务接口ID
     * @param serviceId 服务接口ID
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    /**
     * 参数中文名
     * @return chinese_name 参数中文名
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * 参数中文名
     * @param chineseName 参数中文名
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    /**
     * 参数英文名
     * @return english_name 参数英文名
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * 参数英文名
     * @param englishName 参数英文名
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    /**
     * 参数类型
     * @return type 参数类型
     */
    public String getType() {
        return type;
    }

    /**
     * 参数类型
     * @param type 参数类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 默认值
     * @return default_value 默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 默认值
     * @param defaultValue 默认值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    /**
     * 是否必填(是:YES，否:NO)
     * @return must_fill 是否必填(是:YES，否:NO)
     */
    public String getMustFill() {
        return mustFill;
    }

    /**
     * 是否必填(是:YES，否:NO)
     * @param mustFill 是否必填(是:YES，否:NO)
     */
    public void setMustFill(String mustFill) {
        this.mustFill = mustFill == null ? null : mustFill.trim();
    }

    /**
     * 输入参数or输出参数(INPUT,OUTPUT)
     * @return kind 输入参数or输出参数(INPUT,OUTPUT)
     */
    public String getKind() {
        return kind;
    }

    /**
     * 输入参数or输出参数(INPUT,OUTPUT)
     * @param kind 输入参数or输出参数(INPUT,OUTPUT)
     */
    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public AddAuthPolicyVo getAuthPolicy() {
        return authPolicy;
    }

    public void setAuthPolicy(AddAuthPolicyVo authPolicy) {
        this.authPolicy = authPolicy;
    }
}