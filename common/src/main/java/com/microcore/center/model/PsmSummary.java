package com.microcore.center.model;

import java.util.Date;

public class PsmSummary {
    /**
     * ID
     */
    private String id;

    /**
     * 时间段起始
     */
    private Date periodHead;

    /**
     * 时间段结尾
     */
    private Date periodEnd;

    /**
     * 区域ID
     */
    private String areaId;

    /**
     * 人数
     */
    private Integer peopleNumber;

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
     * 时间段起始
     * @return period_head 时间段起始
     */
    public Date getPeriodHead() {
        return periodHead;
    }

    /**
     * 时间段起始
     * @param periodHead 时间段起始
     */
    public void setPeriodHead(Date periodHead) {
        this.periodHead = periodHead;
    }

    /**
     * 时间段结尾
     * @return period_end 时间段结尾
     */
    public Date getPeriodEnd() {
        return periodEnd;
    }

    /**
     * 时间段结尾
     * @param periodEnd 时间段结尾
     */
    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    /**
     * 区域ID
     * @return area_id 区域ID
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 区域ID
     * @param areaId 区域ID
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**
     * 人数
     * @return people_number 人数
     */
    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    /**
     * 人数
     * @param peopleNumber 人数
     */
    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }
}