package com.microcore.center.model;

import java.util.Date;

public class DetectResult {
    /**
     * ID
     */
    private String id;

    /**
     * 素材ID
     */
    private String materialId;

    /**
     * 人脸角度
     */
    private Integer angle;

    /**
     * 中心横坐标
     */
    private Integer centerX;

    /**
     * 中心纵坐标
     */
    private Integer centerY;

    /**
     * 百度人脸库用户组
     */
    private String groupId;

    /**
     * 高度
     */
    private Integer height;

    /**
     * 宽度
     */
    private Integer width;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 人脸字符串
     */
    private String base64;

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
     * 素材ID
     * @return material_id 素材ID
     */
    public String getMaterialId() {
        return materialId;
    }

    /**
     * 素材ID
     * @param materialId 素材ID
     */
    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    /**
     * 人脸角度
     * @return angle 人脸角度
     */
    public Integer getAngle() {
        return angle;
    }

    /**
     * 人脸角度
     * @param angle 人脸角度
     */
    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    /**
     * 中心横坐标
     * @return center_x 中心横坐标
     */
    public Integer getCenterX() {
        return centerX;
    }

    /**
     * 中心横坐标
     * @param centerX 中心横坐标
     */
    public void setCenterX(Integer centerX) {
        this.centerX = centerX;
    }

    /**
     * 中心纵坐标
     * @return center_y 中心纵坐标
     */
    public Integer getCenterY() {
        return centerY;
    }

    /**
     * 中心纵坐标
     * @param centerY 中心纵坐标
     */
    public void setCenterY(Integer centerY) {
        this.centerY = centerY;
    }

    /**
     * 百度人脸库用户组
     * @return group_id 百度人脸库用户组
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 百度人脸库用户组
     * @param groupId 百度人脸库用户组
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * 高度
     * @return height 高度
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 高度
     * @param height 高度
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 宽度
     * @return width 宽度
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 宽度
     * @param width 宽度
     */
    public void setWidth(Integer width) {
        this.width = width;
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

    /**
     * 人脸字符串
     * @return base64 人脸字符串
     */
    public String getBase64() {
        return base64;
    }

    /**
     * 人脸字符串
     * @param base64 人脸字符串
     */
    public void setBase64(String base64) {
        this.base64 = base64 == null ? null : base64.trim();
    }
}