package com.rainyhon.common.model;

import java.util.Date;

public class SrcRecord {
    /**
     * 
     */
    private String id;

    /**
     * 产生时间
     */
    private Date createTime;

    /**
     * 素材来源
     */
    private String srcDevice;

    /**
     * 素材产生方式：自动采集/主动获取
     */
    private String createType;

    /**
     * 获取人
     */
    private String getObject;

    /**
     * 获取事件ID （如为电子点名，记录点名ID）
     */
    private String getEventId;

    /**
     * 素材类型：视频/图像/位置
     */
    private String srcType;

    /**
     * 素材存放位置
     */
    private String srcAddress;

    /**
     * 素材处理状态
     */
    private String srcState;

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
     * 产生时间
     * @return create_time 产生时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 产生时间
     * @param createTime 产生时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 素材来源
     * @return src_device 素材来源
     */
    public String getSrcDevice() {
        return srcDevice;
    }

    /**
     * 素材来源
     * @param srcDevice 素材来源
     */
    public void setSrcDevice(String srcDevice) {
        this.srcDevice = srcDevice == null ? null : srcDevice.trim();
    }

    /**
     * 素材产生方式：自动采集/主动获取
     * @return create_type 素材产生方式：自动采集/主动获取
     */
    public String getCreateType() {
        return createType;
    }

    /**
     * 素材产生方式：自动采集/主动获取
     * @param createType 素材产生方式：自动采集/主动获取
     */
    public void setCreateType(String createType) {
        this.createType = createType == null ? null : createType.trim();
    }

    /**
     * 获取人
     * @return get_object 获取人
     */
    public String getGetObject() {
        return getObject;
    }

    /**
     * 获取人
     * @param getObject 获取人
     */
    public void setGetObject(String getObject) {
        this.getObject = getObject == null ? null : getObject.trim();
    }

    /**
     * 获取事件ID （如为电子点名，记录点名ID）
     * @return get_event_id 获取事件ID （如为电子点名，记录点名ID）
     */
    public String getGetEventId() {
        return getEventId;
    }

    /**
     * 获取事件ID （如为电子点名，记录点名ID）
     * @param getEventId 获取事件ID （如为电子点名，记录点名ID）
     */
    public void setGetEventId(String getEventId) {
        this.getEventId = getEventId == null ? null : getEventId.trim();
    }

    /**
     * 素材类型：视频/图像/位置
     * @return src_type 素材类型：视频/图像/位置
     */
    public String getSrcType() {
        return srcType;
    }

    /**
     * 素材类型：视频/图像/位置
     * @param srcType 素材类型：视频/图像/位置
     */
    public void setSrcType(String srcType) {
        this.srcType = srcType == null ? null : srcType.trim();
    }

    /**
     * 素材存放位置
     * @return src_address 素材存放位置
     */
    public String getSrcAddress() {
        return srcAddress;
    }

    /**
     * 素材存放位置
     * @param srcAddress 素材存放位置
     */
    public void setSrcAddress(String srcAddress) {
        this.srcAddress = srcAddress == null ? null : srcAddress.trim();
    }

    /**
     * 素材处理状态
     * @return src_state 素材处理状态
     */
    public String getSrcState() {
        return srcState;
    }

    /**
     * 素材处理状态
     * @param srcState 素材处理状态
     */
    public void setSrcState(String srcState) {
        this.srcState = srcState == null ? null : srcState.trim();
    }
}