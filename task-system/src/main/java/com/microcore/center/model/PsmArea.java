package com.microcore.center.model;

public class PsmArea {
    /**
     *  ID
     */
    private String id;

    /**
     * 区域名
     */
    private String name;

    /**
     * 备注
     */
    private String comment;

    /**
     *  ID
     * @return id  ID
     */
    public String getId() {
        return id;
    }

    /**
     *  ID
     * @param id  ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 区域名
     * @return name 区域名
     */
    public String getName() {
        return name;
    }

    /**
     * 区域名
     * @param name 区域名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 备注
     * @return comment 备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 备注
     * @param comment 备注
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}