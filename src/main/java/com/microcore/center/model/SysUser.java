package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUser {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String account;

    /**
     * 
     */
    private String company;

    /**
     * 
     */
    private String tel;

    /**
     * 
     */
    private Integer isEnable;

    /**
     * 
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
     * 
     * @return username 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     * @return account 
     */
    public String getAccount() {
        return account;
    }

    /**
     * 
     * @param account 
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 
     * @return company 
     */
    public String getCompany() {
        return company;
    }

    /**
     * 
     * @param company 
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 
     * @return tel 
     */
    public String getTel() {
        return tel;
    }

    /**
     * 
     * @param tel 
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 
     * @return is_enable 
     */
    public Integer getIsEnable() {
        return isEnable;
    }

    /**
     * 
     * @param isEnable 
     */
    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 
     * @return is_lock 
     */
    public Integer getIsLock() {
        return isLock;
    }

    /**
     * 
     * @param isLock 
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


    public List<SysRole> getRoles(){
        return new ArrayList<>();
    }
}