package com.microcore.center.model;

public class DbServer {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String ip;

    /**
     * 
     */
    private Integer port;

    /**
     * 
     */
    private String macAddr;

    /**
     * 备注
     */
    private String remark;

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
     * @return ip 
     */
    public String getIp() {
        return ip;
    }

    /**
     * 
     * @param ip 
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 
     * @return port 
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 
     * @param port 
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 
     * @return mac_addr 
     */
    public String getMacAddr() {
        return macAddr;
    }

    /**
     * 
     * @param macAddr 
     */
    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr == null ? null : macAddr.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}