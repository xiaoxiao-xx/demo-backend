package com.microcore.center.model;

import java.util.Date;

public class Face {
    /**
     * id
     */
    private String id;

    /**
     * 图片素材ID
     */
    private String materialId;

    /**
     * 识别结果ID
     */
    private String detectResultId;

    /**
     * 面部识别时间
     */
    private Date createTime;

    /**
     * angle
     */
    private Integer angle;

    /**
     * center_x
     */
    private Integer centerX;

    /**
     * center_y
     */
    private Integer centerY;

    /**
     * user_id
     */
    private String userId;

    /**
     * group_id
     */
    private String groupId;

    /**
     * score
     */
    private String score;

    /**
     * width
     */
    private Integer width;

    /**
     * height
     */
    private Integer height;

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
     * 图片素材ID
     * @return material_id 图片素材ID
     */
    public String getMaterialId() {
        return materialId;
    }

    /**
     * 图片素材ID
     * @param materialId 图片素材ID
     */
    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    /**
     * 识别结果ID
     * @return detect_result_id 识别结果ID
     */
    public String getDetectResultId() {
        return detectResultId;
    }

    /**
     * 识别结果ID
     * @param detectResultId 识别结果ID
     */
    public void setDetectResultId(String detectResultId) {
        this.detectResultId = detectResultId == null ? null : detectResultId.trim();
    }

    /**
     * 面部识别时间
     * @return create_time 面部识别时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 面部识别时间
     * @param createTime 面部识别时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * angle
     * @return angle angle
     */
    public Integer getAngle() {
        return angle;
    }

    /**
     * angle
     * @param angle angle
     */
    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    /**
     * center_x
     * @return center_x center_x
     */
    public Integer getCenterX() {
        return centerX;
    }

    /**
     * center_x
     * @param centerX center_x
     */
    public void setCenterX(Integer centerX) {
        this.centerX = centerX;
    }

    /**
     * center_y
     * @return center_y center_y
     */
    public Integer getCenterY() {
        return centerY;
    }

    /**
     * center_y
     * @param centerY center_y
     */
    public void setCenterY(Integer centerY) {
        this.centerY = centerY;
    }

    /**
     * user_id
     * @return user_id user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * user_id
     * @param userId user_id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * group_id
     * @return group_id group_id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * group_id
     * @param groupId group_id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * score
     * @return score score
     */
    public String getScore() {
        return score;
    }

    /**
     * score
     * @param score score
     */
    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    /**
     * width
     * @return width width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * width
     * @param width width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * height
     * @return height height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * height
     * @param height height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }
}