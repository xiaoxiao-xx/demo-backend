package com.microcore.center.model;

import java.util.Date;

public class PsmUser {
    /**
     * 
     */
    private String id;

    /**
     * 登录名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 密码
     */
    private String password;

    /**
     * 暂定为密码错误次数
     */
    private Integer isEnable;

    /**
     * 0 未锁定  1 锁定
     */
    private Integer isLock;

    /**
     * 
     */
    private Date optime;

    /**
     * 
     */
    private String orgId;

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
     * 登录名
     * @return username 登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 登录名
     * @param username 登录名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 真实姓名
     * @return realname 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 真实姓名
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 暂定为密码错误次数
     * @return is_enable 暂定为密码错误次数
     */
    public Integer getIsEnable() {
        return isEnable;
    }

    /**
     * 暂定为密码错误次数
     * @param isEnable 暂定为密码错误次数
     */
    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 0 未锁定  1 锁定
     * @return is_lock 0 未锁定  1 锁定
     */
    public Integer getIsLock() {
        return isLock;
    }

    /**
     * 0 未锁定  1 锁定
     * @param isLock 0 未锁定  1 锁定
     */
    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    /**
     * 
     * @return optime 
     */
    public Date getOptime() {
        return optime;
    }

    /**
     * 
     * @param optime 
     */
    public void setOptime(Date optime) {
        this.optime = optime;
    }

    /**
     * 
     * @return org_id 
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 
     * @param orgId 
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }
}