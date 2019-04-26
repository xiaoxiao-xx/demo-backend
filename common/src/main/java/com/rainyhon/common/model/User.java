package com.rainyhon.common.model;

import java.util.Date;

public class User {
    /**
     * ID
     */
    private String id;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 密码 
     */
    private String password;

    /**
     * 真实人员信息ID
     */
    private String realPersonId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 最近登录错误次数 
     */
    private Integer loginErrorCount;

    /**
     * 是否锁定该用户的账户 （1-锁定，0-未锁定） 
     */
    private Integer locked;

    /**
     * 最近登录时间
     */
    private Date lastLoginTime;

    /**
     * 总登录次数 
     */
    private Integer totalLoginCount;

    /**
     * 删除状态 
     */
    private String delStatus;

    /**
     * 最后修改人ID 
     */
    private String updUserId;

    /**
     * 最后修改机构ID 
     */
    private String updOrgId;

    /**
     * 最后修改时间 
     */
    private Date updTm;

    /**
     * 创建人ID
     */
    private String crtUserId;

    /**
     * 创建机构ID
     */
    private String crtOrgId;

    /**
     * 创建时间
     */
    private Date crtTm;

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
     * 登录用户名
     * @return username 登录用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 登录用户名
     * @param username 登录用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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
     * 真实人员信息ID
     * @return real_person_id 真实人员信息ID
     */
    public String getRealPersonId() {
        return realPersonId;
    }

    /**
     * 真实人员信息ID
     * @param realPersonId 真实人员信息ID
     */
    public void setRealPersonId(String realPersonId) {
        this.realPersonId = realPersonId == null ? null : realPersonId.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 手机号
     * @return phone_number 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 手机号
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 最近登录错误次数 
     * @return login_error_count 最近登录错误次数 
     */
    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    /**
     * 最近登录错误次数 
     * @param loginErrorCount 最近登录错误次数 
     */
    public void setLoginErrorCount(Integer loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    /**
     * 是否锁定该用户的账户 （1-锁定，0-未锁定） 
     * @return locked 是否锁定该用户的账户 （1-锁定，0-未锁定） 
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * 是否锁定该用户的账户 （1-锁定，0-未锁定） 
     * @param locked 是否锁定该用户的账户 （1-锁定，0-未锁定） 
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * 最近登录时间
     * @return last_login_time 最近登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最近登录时间
     * @param lastLoginTime 最近登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 总登录次数 
     * @return total_login_count 总登录次数 
     */
    public Integer getTotalLoginCount() {
        return totalLoginCount;
    }

    /**
     * 总登录次数 
     * @param totalLoginCount 总登录次数 
     */
    public void setTotalLoginCount(Integer totalLoginCount) {
        this.totalLoginCount = totalLoginCount;
    }

    /**
     * 删除状态 
     * @return del_status 删除状态 
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 删除状态 
     * @param delStatus 删除状态 
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
    }

    /**
     * 最后修改人ID 
     * @return upd_user_id 最后修改人ID 
     */
    public String getUpdUserId() {
        return updUserId;
    }

    /**
     * 最后修改人ID 
     * @param updUserId 最后修改人ID 
     */
    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId == null ? null : updUserId.trim();
    }

    /**
     * 最后修改机构ID 
     * @return upd_org_id 最后修改机构ID 
     */
    public String getUpdOrgId() {
        return updOrgId;
    }

    /**
     * 最后修改机构ID 
     * @param updOrgId 最后修改机构ID 
     */
    public void setUpdOrgId(String updOrgId) {
        this.updOrgId = updOrgId == null ? null : updOrgId.trim();
    }

    /**
     * 最后修改时间 
     * @return upd_tm 最后修改时间 
     */
    public Date getUpdTm() {
        return updTm;
    }

    /**
     * 最后修改时间 
     * @param updTm 最后修改时间 
     */
    public void setUpdTm(Date updTm) {
        this.updTm = updTm;
    }

    /**
     * 创建人ID
     * @return crt_user_id 创建人ID
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /**
     * 创建人ID
     * @param crtUserId 创建人ID
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId == null ? null : crtUserId.trim();
    }

    /**
     * 创建机构ID
     * @return crt_org_id 创建机构ID
     */
    public String getCrtOrgId() {
        return crtOrgId;
    }

    /**
     * 创建机构ID
     * @param crtOrgId 创建机构ID
     */
    public void setCrtOrgId(String crtOrgId) {
        this.crtOrgId = crtOrgId == null ? null : crtOrgId.trim();
    }

    /**
     * 创建时间
     * @return crt_tm 创建时间
     */
    public Date getCrtTm() {
        return crtTm;
    }

    /**
     * 创建时间
     * @param crtTm 创建时间
     */
    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }
}