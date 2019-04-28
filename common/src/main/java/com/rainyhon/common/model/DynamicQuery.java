package com.rainyhon.common.model;

import java.util.Date;

public class DynamicQuery {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String view;

    /**
     * 
     */
    private String viewDisplayName;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private Date createTime;

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
     * @return view 
     */
    public String getView() {
        return view;
    }

    /**
     * 
     * @param view 
     */
    public void setView(String view) {
        this.view = view == null ? null : view.trim();
    }

    /**
     * 
     * @return view_display_name 
     */
    public String getViewDisplayName() {
        return viewDisplayName;
    }

    /**
     * 
     * @param viewDisplayName 
     */
    public void setViewDisplayName(String viewDisplayName) {
        this.viewDisplayName = viewDisplayName == null ? null : viewDisplayName.trim();
    }

    /**
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}