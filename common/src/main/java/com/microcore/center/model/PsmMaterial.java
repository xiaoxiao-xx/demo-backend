package com.microcore.center.model;

import java.util.Date;

public class PsmMaterial {
    /**
     * id
     */
    private String id;

    /**
     * 素材创建时间
     */
    private Date createTime;

    /**
     * 素材图片文件名
     */
    private String imageName;

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 素材创建时间
     * @return create_time 素材创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 素材创建时间
     * @param createTime 素材创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 素材图片文件名
     * @return image_name 素材图片文件名
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * 素材图片文件名
     * @param imageName 素材图片文件名
     */
    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }
}