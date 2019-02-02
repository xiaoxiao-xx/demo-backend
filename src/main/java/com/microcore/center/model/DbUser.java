package com.microcore.center.model;

import java.util.Date;

public class DbUser {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String account;

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
    private String sex;

    /**
     * 
     */
    private String orgName;

    /**
     * 
     */
    private String tel;

    /**
     * 
     */
    private Date birthday;

    /**
     * 职位
     */
    private String job;

    /**
     * 入职时间
     */
    private Date jobinTm;

    /**
     * 证件照片
     */
    private String photo;

    /**
     * 是否删除(1删除，0非--)
     */
    private String delStatus;

    /**
     * 重点关注(1重点关注，0非--)
     */
    private String moreCare;

    /**
     * 创建时间
     */
    private Date crtTm;

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
     * @return sex 
     */
    public String getSex() {
        return sex;
    }

    /**
     * 
     * @param sex 
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 
     * @return org_name 
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 
     * @param orgName 
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
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
     * @return birthday 
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 
     * @param birthday 
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 职位
     * @return job 职位
     */
    public String getJob() {
        return job;
    }

    /**
     * 职位
     * @param job 职位
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     * 入职时间
     * @return jobin_tm 入职时间
     */
    public Date getJobinTm() {
        return jobinTm;
    }

    /**
     * 入职时间
     * @param jobinTm 入职时间
     */
    public void setJobinTm(Date jobinTm) {
        this.jobinTm = jobinTm;
    }

    /**
     * 证件照片
     * @return photo 证件照片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 证件照片
     * @param photo 证件照片
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 是否删除(1删除，0非--)
     * @return del_status 是否删除(1删除，0非--)
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 是否删除(1删除，0非--)
     * @param delStatus 是否删除(1删除，0非--)
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
    }

    /**
     * 重点关注(1重点关注，0非--)
     * @return more_care 重点关注(1重点关注，0非--)
     */
    public String getMoreCare() {
        return moreCare;
    }

    /**
     * 重点关注(1重点关注，0非--)
     * @param moreCare 重点关注(1重点关注，0非--)
     */
    public void setMoreCare(String moreCare) {
        this.moreCare = moreCare == null ? null : moreCare.trim();
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