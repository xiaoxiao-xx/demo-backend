package com.rainyhon.common.model;

import java.util.Date;

public class DynamicQuery {
    /**
     * 序列
     */
    private String id;

    /**
     * 视图名称
     */
    private String viewName;

    /**
     * 视图显示名称
     */
    private String viewDisplayName;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 序列
     * @return id 序列
     */
    public String getId() {
        return id;
    }

    /**
     * 序列
     * @param id 序列
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 视图名称
     * @return view_name 视图名称
     */
    public String getViewName() {
        return viewName;
    }

    /**
     * 视图名称
     * @param viewName 视图名称
     */
    public void setViewName(String viewName) {
        this.viewName = viewName == null ? null : viewName.trim();
    }

    /**
     * 视图显示名称
     * @return view_display_name 视图显示名称
     */
    public String getViewDisplayName() {
        return viewDisplayName;
    }

    /**
     * 视图显示名称
     * @param viewDisplayName 视图显示名称
     */
    public void setViewDisplayName(String viewDisplayName) {
        this.viewDisplayName = viewDisplayName == null ? null : viewDisplayName.trim();
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

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}