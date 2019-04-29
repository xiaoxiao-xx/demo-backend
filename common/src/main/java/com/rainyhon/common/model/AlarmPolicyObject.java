package com.rainyhon.common.model;

public class AlarmPolicyObject {
    /**
     *  ID
     */
    private String policyId;

    /**
     * 告警对象ID
     */
    private String objectId;

    /**
     *  ID
     * @return policy_id  ID
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     *  ID
     * @param policyId  ID
     */
    public void setPolicyId(String policyId) {
        this.policyId = policyId == null ? null : policyId.trim();
    }

    /**
     * 告警对象ID
     * @return object_id 告警对象ID
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * 告警对象ID
     * @param objectId 告警对象ID
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }
}