package com.microcore.center.model;

import java.util.Date;

public class DbSubTable {
    /**
     * id
     */
    private String id;

    /**
     * 脱表库表名
     */
    private String distillTableName;

    /**
     * 发布ID
     */
    private String pubId;

    /**
     * 发布任务ID
     */
    private Integer taskId;

    /**
     * 数据源连接ID
     */
    private String connId;

    /**
     * 存储库表名
     */
    private String storeTableName;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务描述
     */
    private String taskDesc;

    /**
     * 订阅人ID
     */
    private String subUserId;

    /**
     * 订阅机构ID
     */
    private String subOrgId;

    /**
     * 发布人ID
     */
    private String pubUserId;

    /**
     * 发布机构ID
     */
    private String pubOrgId;

    /**
     * 发布时间
     */
    private Date pubTime;

    /**
     * 发布（下发）状态
     */
    private String pubStatus;

    /**
     * 状态 (RUN, STOP)
     */
    private String status;

    /**
     * 是否删除
     */
    private String delStatus;

    /**
     * 最新修改人
     */
    private String updUserId;

    /**
     * 最新修改组织
     */
    private String updOrgId;

    /**
     * 最新修改时间
     */
    private Date updTm;

    /**
     * 创建人
     */
    private String crtUserId;

    /**
     * 创建机构
     */
    private String crtOrgId;

    /**
     * 创建时间
     */
    private Date crtTm;

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 脱表库表名
     * @return distill_table_name 脱表库表名
     */
    public String getDistillTableName() {
        return distillTableName;
    }

    /**
     * 脱表库表名
     * @param distillTableName 脱表库表名
     */
    public void setDistillTableName(String distillTableName) {
        this.distillTableName = distillTableName == null ? null : distillTableName.trim();
    }

    /**
     * 发布ID
     * @return pub_id 发布ID
     */
    public String getPubId() {
        return pubId;
    }

    /**
     * 发布ID
     * @param pubId 发布ID
     */
    public void setPubId(String pubId) {
        this.pubId = pubId == null ? null : pubId.trim();
    }

    /**
     * 发布任务ID
     * @return task_id 发布任务ID
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * 发布任务ID
     * @param taskId 发布任务ID
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * 数据源连接ID
     * @return conn_id 数据源连接ID
     */
    public String getConnId() {
        return connId;
    }

    /**
     * 数据源连接ID
     * @param connId 数据源连接ID
     */
    public void setConnId(String connId) {
        this.connId = connId == null ? null : connId.trim();
    }

    /**
     * 存储库表名
     * @return store_table_name 存储库表名
     */
    public String getStoreTableName() {
        return storeTableName;
    }

    /**
     * 存储库表名
     * @param storeTableName 存储库表名
     */
    public void setStoreTableName(String storeTableName) {
        this.storeTableName = storeTableName == null ? null : storeTableName.trim();
    }

    /**
     * 任务名称
     * @return task_name 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 任务名称
     * @param taskName 任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 任务描述
     * @return task_desc 任务描述
     */
    public String getTaskDesc() {
        return taskDesc;
    }

    /**
     * 任务描述
     * @param taskDesc 任务描述
     */
    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc == null ? null : taskDesc.trim();
    }

    /**
     * 订阅人ID
     * @return sub_user_id 订阅人ID
     */
    public String getSubUserId() {
        return subUserId;
    }

    /**
     * 订阅人ID
     * @param subUserId 订阅人ID
     */
    public void setSubUserId(String subUserId) {
        this.subUserId = subUserId == null ? null : subUserId.trim();
    }

    /**
     * 订阅机构ID
     * @return sub_org_id 订阅机构ID
     */
    public String getSubOrgId() {
        return subOrgId;
    }

    /**
     * 订阅机构ID
     * @param subOrgId 订阅机构ID
     */
    public void setSubOrgId(String subOrgId) {
        this.subOrgId = subOrgId == null ? null : subOrgId.trim();
    }

    /**
     * 发布人ID
     * @return pub_user_id 发布人ID
     */
    public String getPubUserId() {
        return pubUserId;
    }

    /**
     * 发布人ID
     * @param pubUserId 发布人ID
     */
    public void setPubUserId(String pubUserId) {
        this.pubUserId = pubUserId == null ? null : pubUserId.trim();
    }

    /**
     * 发布机构ID
     * @return pub_org_id 发布机构ID
     */
    public String getPubOrgId() {
        return pubOrgId;
    }

    /**
     * 发布机构ID
     * @param pubOrgId 发布机构ID
     */
    public void setPubOrgId(String pubOrgId) {
        this.pubOrgId = pubOrgId == null ? null : pubOrgId.trim();
    }

    /**
     * 发布时间
     * @return pub_time 发布时间
     */
    public Date getPubTime() {
        return pubTime;
    }

    /**
     * 发布时间
     * @param pubTime 发布时间
     */
    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    /**
     * 发布（下发）状态
     * @return pub_status 发布（下发）状态
     */
    public String getPubStatus() {
        return pubStatus;
    }

    /**
     * 发布（下发）状态
     * @param pubStatus 发布（下发）状态
     */
    public void setPubStatus(String pubStatus) {
        this.pubStatus = pubStatus == null ? null : pubStatus.trim();
    }

    /**
     * 状态 (RUN, STOP)
     * @return status 状态 (RUN, STOP)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 (RUN, STOP)
     * @param status 状态 (RUN, STOP)
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 是否删除
     * @return del_status 是否删除
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 是否删除
     * @param delStatus 是否删除
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
    }

    /**
     * 最新修改人
     * @return upd_user_id 最新修改人
     */
    public String getUpdUserId() {
        return updUserId;
    }

    /**
     * 最新修改人
     * @param updUserId 最新修改人
     */
    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId == null ? null : updUserId.trim();
    }

    /**
     * 最新修改组织
     * @return upd_org_id 最新修改组织
     */
    public String getUpdOrgId() {
        return updOrgId;
    }

    /**
     * 最新修改组织
     * @param updOrgId 最新修改组织
     */
    public void setUpdOrgId(String updOrgId) {
        this.updOrgId = updOrgId == null ? null : updOrgId.trim();
    }

    /**
     * 最新修改时间
     * @return upd_tm 最新修改时间
     */
    public Date getUpdTm() {
        return updTm;
    }

    /**
     * 最新修改时间
     * @param updTm 最新修改时间
     */
    public void setUpdTm(Date updTm) {
        this.updTm = updTm;
    }

    /**
     * 创建人
     * @return crt_user_id 创建人
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /**
     * 创建人
     * @param crtUserId 创建人
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId == null ? null : crtUserId.trim();
    }

    /**
     * 创建机构
     * @return crt_org_id 创建机构
     */
    public String getCrtOrgId() {
        return crtOrgId;
    }

    /**
     * 创建机构
     * @param crtOrgId 创建机构
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