package com.rainyhon.common.model;

import java.util.Date;

public class Material {
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
     * 设备ID
     */
    private String deviceId;

    /**
     * 区域ID
     */
    private String areaId;

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

    /**
     * 设备ID
     * @return device_id 设备ID
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设备ID
     * @param deviceId 设备ID
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    /**
     * 区域ID
     * @return area_id 区域ID
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 区域ID
     * @param areaId 区域ID
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }
}