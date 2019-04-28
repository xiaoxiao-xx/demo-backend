package com.rainyhon.common.model;

import java.util.Date;

public class ScheduleDetail {
    /**
     * ID
     */
    private String id;

    /**
     * 日程ID
     */
    private String configId;

    /**
     * 日程类型
     */
    private String type;

    /**
     * 团队或个人
     */
    private String objectType;

    /**
     * 团队或个人ID
     */
    private String objectId;

    /**
     * 人数
     */
    private Integer number;

    /**
     * 日期
     */
    private Date someDate;

    /**
     * 开始时间：完整时间yyyymmddhh24miss
     */
    private Date startTime;

    /**
     * 结束时间：完整时间yyyymmddhh24miss
     */
    private Date endTime;

    /**
     * 实际开始时间
     */
    private Date realStartTime;

    /**
     * 实际结束时间
     */
    private Date realEndTime;

    /**
     * 日程标题
     */
    private String title;

    /**
     * 日程内容
     */
    private String content;

    /**
     * 老师
     */
    private String teacher;

    /**
     * 地点
     */
    private String address;

    /**
     * 更改原因
     */
    private String updateReason;

    /**
     * 结果
     */
    private String result;

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
     * 日程ID
     * @return config_id 日程ID
     */
    public String getConfigId() {
        return configId;
    }

    /**
     * 日程ID
     * @param configId 日程ID
     */
    public void setConfigId(String configId) {
        this.configId = configId == null ? null : configId.trim();
    }

    /**
     * 日程类型
     * @return type 日程类型
     */
    public String getType() {
        return type;
    }

    /**
     * 日程类型
     * @param type 日程类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 团队或个人
     * @return object_type 团队或个人
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * 团队或个人
     * @param objectType 团队或个人
     */
    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    /**
     * 团队或个人ID
     * @return object_id 团队或个人ID
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * 团队或个人ID
     * @param objectId 团队或个人ID
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * 人数
     * @return number 人数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 人数
     * @param number 人数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 日期
     * @return some_date 日期
     */
    public Date getSomeDate() {
        return someDate;
    }

    /**
     * 日期
     * @param someDate 日期
     */
    public void setSomeDate(Date someDate) {
        this.someDate = someDate;
    }

    /**
     * 开始时间：完整时间yyyymmddhh24miss
     * @return start_time 开始时间：完整时间yyyymmddhh24miss
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间：完整时间yyyymmddhh24miss
     * @param startTime 开始时间：完整时间yyyymmddhh24miss
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间：完整时间yyyymmddhh24miss
     * @return end_time 结束时间：完整时间yyyymmddhh24miss
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间：完整时间yyyymmddhh24miss
     * @param endTime 结束时间：完整时间yyyymmddhh24miss
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 实际开始时间
     * @return real_start_time 实际开始时间
     */
    public Date getRealStartTime() {
        return realStartTime;
    }

    /**
     * 实际开始时间
     * @param realStartTime 实际开始时间
     */
    public void setRealStartTime(Date realStartTime) {
        this.realStartTime = realStartTime;
    }

    /**
     * 实际结束时间
     * @return real_end_time 实际结束时间
     */
    public Date getRealEndTime() {
        return realEndTime;
    }

    /**
     * 实际结束时间
     * @param realEndTime 实际结束时间
     */
    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }

    /**
     * 日程标题
     * @return title 日程标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 日程标题
     * @param title 日程标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 日程内容
     * @return content 日程内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 日程内容
     * @param content 日程内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 老师
     * @return teacher 老师
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * 老师
     * @param teacher 老师
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    /**
     * 地点
     * @return address 地点
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地点
     * @param address 地点
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 更改原因
     * @return update_reason 更改原因
     */
    public String getUpdateReason() {
        return updateReason;
    }

    /**
     * 更改原因
     * @param updateReason 更改原因
     */
    public void setUpdateReason(String updateReason) {
        this.updateReason = updateReason == null ? null : updateReason.trim();
    }

    /**
     * 结果
     * @return result 结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 结果
     * @param result 结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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