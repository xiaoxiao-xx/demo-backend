package com.microcore.center.model;

public class DbPolicyEncrypt {
    /**
     * ID
     */
    private String id;

    /**
     * 策略ID
     */
    private String policyItemId;

    /**
     * 敏感等级
     */
    private String securityLevel;

    /**
     * 加密类型ID
     */
    private String encryptTypeId;

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
     * 策略ID
     * @return policy_item_id 策略ID
     */
    public String getPolicyItemId() {
        return policyItemId;
    }

    /**
     * 策略ID
     * @param policyItemId 策略ID
     */
    public void setPolicyItemId(String policyItemId) {
        this.policyItemId = policyItemId == null ? null : policyItemId.trim();
    }

    /**
     * 敏感等级
     * @return security_level 敏感等级
     */
    public String getSecurityLevel() {
        return securityLevel;
    }

    /**
     * 敏感等级
     * @param securityLevel 敏感等级
     */
    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel == null ? null : securityLevel.trim();
    }

    /**
     * 加密类型ID
     * @return encrypt_type_id 加密类型ID
     */
    public String getEncryptTypeId() {
        return encryptTypeId;
    }

    /**
     * 加密类型ID
     * @param encryptTypeId 加密类型ID
     */
    public void setEncryptTypeId(String encryptTypeId) {
        this.encryptTypeId = encryptTypeId == null ? null : encryptTypeId.trim();
    }
}