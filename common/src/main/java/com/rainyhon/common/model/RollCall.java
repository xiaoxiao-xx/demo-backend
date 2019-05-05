package com.rainyhon.common.model;

import java.util.Date;

public class RollCall {
    /**
     * 
     */
    private String id;

    /**
     * 点名时间
     */
    private Date callTime;

    /**
     * 地点
     */
    private String area;

    /**
     * 团队
     */
    private String team;

    /**
     * 团队长
     */
    private String leader;

    /**
     * 点名结果：全勤/有缺席
     */
    private String callRes;

    /**
     * 缺勤人数
     */
    private Integer absentNumber;

    /**
     * 应到人数
     */
    private Integer totalNumber;

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
     * 点名时间
     * @return call_time 点名时间
     */
    public Date getCallTime() {
        return callTime;
    }

    /**
     * 点名时间
     * @param callTime 点名时间
     */
    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    /**
     * 地点
     * @return area 地点
     */
    public String getArea() {
        return area;
    }

    /**
     * 地点
     * @param area 地点
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 团队
     * @return team 团队
     */
    public String getTeam() {
        return team;
    }

    /**
     * 团队
     * @param team 团队
     */
    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }

    /**
     * 团队长
     * @return leader 团队长
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 团队长
     * @param leader 团队长
     */
    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    /**
     * 点名结果：全勤/有缺席
     * @return call_res 点名结果：全勤/有缺席
     */
    public String getCallRes() {
        return callRes;
    }

    /**
     * 点名结果：全勤/有缺席
     * @param callRes 点名结果：全勤/有缺席
     */
    public void setCallRes(String callRes) {
        this.callRes = callRes == null ? null : callRes.trim();
    }

    /**
     * 缺勤人数
     * @return absent_number 缺勤人数
     */
    public Integer getAbsentNumber() {
        return absentNumber;
    }

    /**
     * 缺勤人数
     * @param absentNumber 缺勤人数
     */
    public void setAbsentNumber(Integer absentNumber) {
        this.absentNumber = absentNumber;
    }

    /**
     * 应到人数
     * @return total_number 应到人数
     */
    public Integer getTotalNumber() {
        return totalNumber;
    }

    /**
     * 应到人数
     * @param totalNumber 应到人数
     */
    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }
}