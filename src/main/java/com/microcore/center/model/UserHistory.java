package com.microcore.center.model;

import java.util.Date;

public class UserHistory {
    /**
     * 
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 姓名id
     */
    private String nameId;

    /**
     * 操作人
     */
    private String doMan;

    /**
     * 操作人id
     */
    private String doManId;

    /**
     * 操作类型
     */
    private String doType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 时间
     */
    private Date doTm;

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
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 姓名id
     * @return name_id 姓名id
     */
    public String getNameId() {
        return nameId;
    }

    /**
     * 姓名id
     * @param nameId 姓名id
     */
    public void setNameId(String nameId) {
        this.nameId = nameId == null ? null : nameId.trim();
    }

    /**
     * 操作人
     * @return do_man 操作人
     */
    public String getDoMan() {
        return doMan;
    }

    /**
     * 操作人
     * @param doMan 操作人
     */
    public void setDoMan(String doMan) {
        this.doMan = doMan == null ? null : doMan.trim();
    }

    /**
     * 操作人id
     * @return do_man_id 操作人id
     */
    public String getDoManId() {
        return doManId;
    }

    /**
     * 操作人id
     * @param doManId 操作人id
     */
    public void setDoManId(String doManId) {
        this.doManId = doManId == null ? null : doManId.trim();
    }

    /**
     * 操作类型
     * @return do_type 操作类型
     */
    public String getDoType() {
        return doType;
    }

    /**
     * 操作类型
     * @param doType 操作类型
     */
    public void setDoType(String doType) {
        this.doType = doType == null ? null : doType.trim();
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

    /**
     * 时间
     * @return do_tm 时间
     */
    public Date getDoTm() {
        return doTm;
    }

    /**
     * 时间
     * @param doTm 时间
     */
    public void setDoTm(Date doTm) {
        this.doTm = doTm;
    }
}