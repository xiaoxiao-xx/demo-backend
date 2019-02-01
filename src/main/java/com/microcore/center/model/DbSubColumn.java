package com.microcore.center.model;

public class DbSubColumn {
    /**
     * 
     */
    private String id;

    /**
     * 主记录ID
     */
    private String pid;

    /**
     * 策略ID
     */
    private String policyId;

    /**
     * 脱表字段名
     */
    private String distillColumnName;

    /**
     * 字段类型
     */
    private String distillType;

    /**
     * 注释
     */
    private String distillComment;

    /**
     * 存储字段名
     */
    private String storeColumnName;

    /**
     * 字段类型
     */
    private String storeType;

    /**
     * 溯源标记
     */
    private String traceMake;

    /**
     * 加密方式
     */
    private String encryptType;

    /**
     * 注释
     */
    private String storeComment;

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
     * 主记录ID
     * @return pid 主记录ID
     */
    public String getPid() {
        return pid;
    }

    /**
     * 主记录ID
     * @param pid 主记录ID
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 策略ID
     * @return policy_id 策略ID
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     * 策略ID
     * @param policyId 策略ID
     */
    public void setPolicyId(String policyId) {
        this.policyId = policyId == null ? null : policyId.trim();
    }

    /**
     * 脱表字段名
     * @return distill_column_name 脱表字段名
     */
    public String getDistillColumnName() {
        return distillColumnName;
    }

    /**
     * 脱表字段名
     * @param distillColumnName 脱表字段名
     */
    public void setDistillColumnName(String distillColumnName) {
        this.distillColumnName = distillColumnName == null ? null : distillColumnName.trim();
    }

    /**
     * 字段类型
     * @return distill_type 字段类型
     */
    public String getDistillType() {
        return distillType;
    }

    /**
     * 字段类型
     * @param distillType 字段类型
     */
    public void setDistillType(String distillType) {
        this.distillType = distillType == null ? null : distillType.trim();
    }

    /**
     * 注释
     * @return distill_comment 注释
     */
    public String getDistillComment() {
        return distillComment;
    }

    /**
     * 注释
     * @param distillComment 注释
     */
    public void setDistillComment(String distillComment) {
        this.distillComment = distillComment == null ? null : distillComment.trim();
    }

    /**
     * 存储字段名
     * @return store_column_name 存储字段名
     */
    public String getStoreColumnName() {
        return storeColumnName;
    }

    /**
     * 存储字段名
     * @param storeColumnName 存储字段名
     */
    public void setStoreColumnName(String storeColumnName) {
        this.storeColumnName = storeColumnName == null ? null : storeColumnName.trim();
    }

    /**
     * 字段类型
     * @return store_type 字段类型
     */
    public String getStoreType() {
        return storeType;
    }

    /**
     * 字段类型
     * @param storeType 字段类型
     */
    public void setStoreType(String storeType) {
        this.storeType = storeType == null ? null : storeType.trim();
    }

    /**
     * 溯源标记
     * @return trace_make 溯源标记
     */
    public String getTraceMake() {
        return traceMake;
    }

    /**
     * 溯源标记
     * @param traceMake 溯源标记
     */
    public void setTraceMake(String traceMake) {
        this.traceMake = traceMake == null ? null : traceMake.trim();
    }

    /**
     * 加密方式
     * @return encrypt_type 加密方式
     */
    public String getEncryptType() {
        return encryptType;
    }

    /**
     * 加密方式
     * @param encryptType 加密方式
     */
    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType == null ? null : encryptType.trim();
    }

    /**
     * 注释
     * @return store_comment 注释
     */
    public String getStoreComment() {
        return storeComment;
    }

    /**
     * 注释
     * @param storeComment 注释
     */
    public void setStoreComment(String storeComment) {
        this.storeComment = storeComment == null ? null : storeComment.trim();
    }
}