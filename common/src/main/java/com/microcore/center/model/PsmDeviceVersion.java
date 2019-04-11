package com.microcore.center.model;

public class PsmDeviceVersion {
    /**
     * 
     */
    private String devversionId;

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
     * 设备厂商
     */
    private String deviceFirm;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 其他信息
     */
    private String para;

    /**
     * 
     * @return devversion_id 
     */
    public String getDevversionId() {
        return devversionId;
    }

    /**
     * 
     * @param devversionId 
     */
    public void setDevversionId(String devversionId) {
        this.devversionId = devversionId == null ? null : devversionId.trim();
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
     * 设备厂商
     * @return device_firm 设备厂商
     */
    public String getDeviceFirm() {
        return deviceFirm;
    }

    /**
     * 设备厂商
     * @param deviceFirm 设备厂商
     */
    public void setDeviceFirm(String deviceFirm) {
        this.deviceFirm = deviceFirm == null ? null : deviceFirm.trim();
    }

    /**
     * 品牌
     * @return brand 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 品牌
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 其他信息
     * @return para 其他信息
     */
    public String getPara() {
        return para;
    }

    /**
     * 其他信息
     * @param para 其他信息
     */
    public void setPara(String para) {
        this.para = para == null ? null : para.trim();
    }
}