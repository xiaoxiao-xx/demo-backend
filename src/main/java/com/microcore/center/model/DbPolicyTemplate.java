package com.microcore.center.model;

public class DbPolicyTemplate {
    /**
     * 策略ID
     */
    private String policyItemId;

    /**
     * 规则ID
     */
    private String extTemplateId;

    /**
     * 序号
     */
    private Integer sequenceNumber;

    /**
     * 是否必填
     */
    private String required;

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
     * 规则ID
     * @return ext_template_id 规则ID
     */
    public String getExtTemplateId() {
        return extTemplateId;
    }

    /**
     * 规则ID
     * @param extTemplateId 规则ID
     */
    public void setExtTemplateId(String extTemplateId) {
        this.extTemplateId = extTemplateId == null ? null : extTemplateId.trim();
    }

    /**
     * 序号
     * @return sequence_number 序号
     */
    public Integer getSequenceNumber() {
	    return sequenceNumber;
    }

    /**
     * 序号
     * @param sequenceNumber 序号
     */
    public void setSequenceNumber(Integer sequenceNumber) {
	    this.sequenceNumber = sequenceNumber;
    }

    /**
     * 是否必填
     * @return required 是否必填
     */
    public String getRequired() {
        return required;
    }

    /**
     * 是否必填
     * @param required 是否必填
     */
    public void setRequired(String required) {
        this.required = required == null ? null : required.trim();
    }
}