package com.microcore.center.model;

public class DbEncryptionType {
    /**
     * ID
     */
    private String id;

    /**
     * 保护方式
     */
    private String protectionWay;

    /**
     * 描述
     */
    private String description;

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
     * 保护方式
     * @return protection_way 保护方式
     */
    public String getProtectionWay() {
        return protectionWay;
    }

    /**
     * 保护方式
     * @param protectionWay 保护方式
     */
    public void setProtectionWay(String protectionWay) {
        this.protectionWay = protectionWay == null ? null : protectionWay.trim();
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}