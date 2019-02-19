package com.microcore.center.model;

public class PsmDevice {
    /**
     * 
     */
    private String deviceId;

    /**
     * 设备类型编码
     */
    private String devtypeCode;

    /**
     * 设备类型值
     */
    private String devtypeVal;

    /**
     * 设备型号
     */
    private String deviceVersion;

    /**
     * 位置坐标
     */
    private String positionXy;

    /**
     * 位置区域
     */
    private String positionArea;

    /**
     * 状态
     */
    private String state;

    /**
     * 
     * @return device_id 
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * @param deviceId 
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    /**
     * 设备类型编码
     * @return devtype_code 设备类型编码
     */
    public String getDevtypeCode() {
        return devtypeCode;
    }

    /**
     * 设备类型编码
     * @param devtypeCode 设备类型编码
     */
    public void setDevtypeCode(String devtypeCode) {
        this.devtypeCode = devtypeCode == null ? null : devtypeCode.trim();
    }

    /**
     * 设备类型值
     * @return devtype_val 设备类型值
     */
    public String getDevtypeVal() {
        return devtypeVal;
    }

    /**
     * 设备类型值
     * @param devtypeVal 设备类型值
     */
    public void setDevtypeVal(String devtypeVal) {
        this.devtypeVal = devtypeVal == null ? null : devtypeVal.trim();
    }

    /**
     * 设备型号
     * @return device_version 设备型号
     */
    public String getDeviceVersion() {
        return deviceVersion;
    }

    /**
     * 设备型号
     * @param deviceVersion 设备型号
     */
    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion == null ? null : deviceVersion.trim();
    }

    /**
     * 位置坐标
     * @return position_xy 位置坐标
     */
    public String getPositionXy() {
        return positionXy;
    }

    /**
     * 位置坐标
     * @param positionXy 位置坐标
     */
    public void setPositionXy(String positionXy) {
        this.positionXy = positionXy == null ? null : positionXy.trim();
    }

    /**
     * 位置区域
     * @return position_area 位置区域
     */
    public String getPositionArea() {
        return positionArea;
    }

    /**
     * 位置区域
     * @param positionArea 位置区域
     */
    public void setPositionArea(String positionArea) {
        this.positionArea = positionArea == null ? null : positionArea.trim();
    }

    /**
     * 状态
     * @return state 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 状态
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}