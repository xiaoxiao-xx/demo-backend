package com.rainyhon.common.model;

public class DynamicQueryWeb {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String dqId;

    /**
     * 
     */
    private String data;

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
     * 
     * @return dq_id 
     */
    public String getDqId() {
        return dqId;
    }

    /**
     * 
     * @param dqId 
     */
    public void setDqId(String dqId) {
        this.dqId = dqId == null ? null : dqId.trim();
    }

    /**
     * 
     * @return data 
     */
    public String getData() {
        return data;
    }

    /**
     * 
     * @param data 
     */
    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}