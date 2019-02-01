package com.microcore.center.model;

import java.util.Date;

public class DbApproval {
    /**
     * ID
     */
    private String id;

    /**
     * 任务ID
     */
    private String taskId;

    /**
     * 任务类型,发布 PUB / 订阅SUB
     */
    private String taskType;

    /**
     * 数据类型DB  /  SERVICE /  FILE
     */
    private String dataType;

    /**
     * 申请人备注
     */
    private String appComment;

    /**
     * 审批描述 （审批人审批意见）
     */
    private String appDesc;

    /**
     * 审批人ID
     */
    private String appUserId;

    /**
     * 审批人机构ID
     */
    private String appOrgId;

    /**
     * 审批时间
     */
    private Date appTm;

    /**
     * 审批状态 （未处理，通过，未通过）
     */
    private String status;

    /**
     * 删除状态
     */
    private String delStatus;

    /**
     * 最后修改人
     */
    private String updUserId;

    /**
     * 最后修改机构
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
     * 任务ID
     * @return task_id 任务ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 任务ID
     * @param taskId 任务ID
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * 任务类型,发布 PUB / 订阅SUB
     * @return task_type 任务类型,发布 PUB / 订阅SUB
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * 任务类型,发布 PUB / 订阅SUB
     * @param taskType 任务类型,发布 PUB / 订阅SUB
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    /**
     * 数据类型DB  /  SERVICE /  FILE
     * @return data_type 数据类型DB  /  SERVICE /  FILE
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 数据类型DB  /  SERVICE /  FILE
     * @param dataType 数据类型DB  /  SERVICE /  FILE
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 申请人备注
     * @return app_comment 申请人备注
     */
    public String getAppComment() {
        return appComment;
    }

    /**
     * 申请人备注
     * @param appComment 申请人备注
     */
    public void setAppComment(String appComment) {
        this.appComment = appComment == null ? null : appComment.trim();
    }

    /**
     * 审批描述 （审批人审批意见）
     * @return app_desc 审批描述 （审批人审批意见）
     */
    public String getAppDesc() {
        return appDesc;
    }

    /**
     * 审批描述 （审批人审批意见）
     * @param appDesc 审批描述 （审批人审批意见）
     */
    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc == null ? null : appDesc.trim();
    }

    /**
     * 审批人ID
     * @return app_user_id 审批人ID
     */
    public String getAppUserId() {
        return appUserId;
    }

    /**
     * 审批人ID
     * @param appUserId 审批人ID
     */
    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId == null ? null : appUserId.trim();
    }

    /**
     * 审批人机构ID
     * @return app_org_id 审批人机构ID
     */
    public String getAppOrgId() {
        return appOrgId;
    }

    /**
     * 审批人机构ID
     * @param appOrgId 审批人机构ID
     */
    public void setAppOrgId(String appOrgId) {
        this.appOrgId = appOrgId == null ? null : appOrgId.trim();
    }

    /**
     * 审批时间
     * @return app_tm 审批时间
     */
    public Date getAppTm() {
        return appTm;
    }

    /**
     * 审批时间
     * @param appTm 审批时间
     */
    public void setAppTm(Date appTm) {
        this.appTm = appTm;
    }

    /**
     * 审批状态 （未处理，通过，未通过）
     * @return status 审批状态 （未处理，通过，未通过）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 审批状态 （未处理，通过，未通过）
     * @param status 审批状态 （未处理，通过，未通过）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 最后修改人
     * @return upd_user_id 最后修改人
     */
    public String getUpdUserId() {
        return updUserId;
    }

    /**
     * 最后修改人
     * @param updUserId 最后修改人
     */
    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId == null ? null : updUserId.trim();
    }

    /**
     * 最后修改机构
     * @return upd_org_id 最后修改机构
     */
    public String getUpdOrgId() {
        return updOrgId;
    }

    /**
     * 最后修改机构
     * @param updOrgId 最后修改机构
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