package com.microcore.center.model;

import java.util.Date;

public class InOutRecord {
    /**
     * ID
     */
    private String id;

    /**
     * 类型(进入-IN, 离开-OUT)
     */
    private String type;

    /**
     * 时间
     */
    private Date time;

    /**
     * 识别结果ID
     */
    private String recId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 区域
     */
    private String areaId;

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
     * 类型(进入-IN, 离开-OUT)
     * @return type 类型(进入-IN, 离开-OUT)
     */
    public String getType() {
        return type;
    }

    /**
     * 类型(进入-IN, 离开-OUT)
     * @param type 类型(进入-IN, 离开-OUT)
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 时间
     * @return time 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 时间
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 识别结果ID
     * @return rec_id 识别结果ID
     */
    public String getRecId() {
        return recId;
    }

    /**
     * 识别结果ID
     * @param recId 识别结果ID
     */
    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 区域
     * @return area_id 区域
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 区域
     * @param areaId 区域
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }
}