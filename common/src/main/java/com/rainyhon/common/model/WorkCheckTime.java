package com.rainyhon.common.model;

import java.util.Date;

public class WorkCheckTime {
    /**
     *  ID
     */
    private String id;

    /**
     * 上班考核时间
     */
    private Date inTime;

    /**
     * 下班考核时间
     */
    private Date outTime;

    /**
     * 加班考核起算时间
     */
    private Date overTime;

    /**
     *  ID
     * @return id  ID
     */
    public String getId() {
        return id;
    }

    /**
     *  ID
     * @param id  ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 上班考核时间
     * @return in_time 上班考核时间
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * 上班考核时间
     * @param inTime 上班考核时间
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * 下班考核时间
     * @return out_time 下班考核时间
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * 下班考核时间
     * @param outTime 下班考核时间
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * 加班考核起算时间
     * @return over_time 加班考核起算时间
     */
    public Date getOverTime() {
        return overTime;
    }

    /**
     * 加班考核起算时间
     * @param overTime 加班考核起算时间
     */
    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }
}