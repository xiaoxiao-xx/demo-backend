package com.microcore.center.model;

import java.util.Date;

public class DbPubTable {
    /**
     * 主键
     */
    private String id;

    /**
     * 模型ID
     */
    private String modelId;

    /**
     * 数据源ID ( DbConnection.id )
     */
    private String sourceDbId;

    /**
     * 数据源名称
     */
    private String sourceDbName;

    /**
     * 触发器
     */
    private String triggerType;

    /**
     * 发布名称
     */
    private String pubName;

    /**
     * 发布描述
     */
    private String pubDesc;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 数据类型 （党政类  ...）
     */
    private String dataType;

    /**
     * 模型发布人
     */
    private String modelPublisher;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 打标库中表名
     */
    private String makeTableName;

    /**
     * 表的注释
     */
    private String tableComment;

    /**
     * 运行状态 （RUN, STOP）
     */
    private String runStatus;

    /**
     * 任务发布状态 （未发布-YES、已发布-NO 审批中-APPROVING,  被拒绝-REJECTED）
     */
    private String pubStatus;

    /**
     * 发布人ID
     */
    private String pubUserId;

    /**
     * 发布机构ID
     */
    private String pubOrgId;

    /**
     * 数据抓取方式 (全量-ALL，增量-INC)
     */
    private String fetchType;

    /**
     * 数据最后抓取时间
     */
    private Date lastFetchTime;

    /**
     * 增量字段名
     */
    private String incrementColumn;

    /**
     * 打标方式 （对象模型-OBJECT，库表模型-TABLE）
     */
    private String makeType;

    /**
     * 抽取方式：抽取后删除/抽取后备份
     */
    private String extractType;

    /**
     * 任务ID
     */
    private Integer taskId;

    /**
     * 授权类型
     */
    private String authType;

    /**
     * 授权范围
     */
    private String authScope;

    /**
     * 是否自动审批
     */
    private String autoApp;

    /**
     * 策略模板ID
     */
    private String templateId;

    /**
     * 删除状态 （DEL, NOR）
     */
    private String delStatus;

    /**
     * 最后修改人
     */
    private String updUserId;

    /**
     * 修改机构
     */
    private String updOrgId;

    /**
     * 修改时间
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
     * 主键
     * @return id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 模型ID
     * @return model_id 模型ID
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * 模型ID
     * @param modelId 模型ID
     */
    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    /**
     * 数据源ID ( DbConnection.id )
     * @return source_db_id 数据源ID ( DbConnection.id )
     */
    public String getSourceDbId() {
        return sourceDbId;
    }

    /**
     * 数据源ID ( DbConnection.id )
     * @param sourceDbId 数据源ID ( DbConnection.id )
     */
    public void setSourceDbId(String sourceDbId) {
        this.sourceDbId = sourceDbId == null ? null : sourceDbId.trim();
    }

    /**
     * 数据源名称
     * @return source_db_name 数据源名称
     */
    public String getSourceDbName() {
        return sourceDbName;
    }

    /**
     * 数据源名称
     * @param sourceDbName 数据源名称
     */
    public void setSourceDbName(String sourceDbName) {
        this.sourceDbName = sourceDbName == null ? null : sourceDbName.trim();
    }

    /**
     * 触发器
     * @return trigger_type 触发器
     */
    public String getTriggerType() {
        return triggerType;
    }

    /**
     * 触发器
     * @param triggerType 触发器
     */
    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType == null ? null : triggerType.trim();
    }

    /**
     * 发布名称
     * @return pub_name 发布名称
     */
    public String getPubName() {
        return pubName;
    }

    /**
     * 发布名称
     * @param pubName 发布名称
     */
    public void setPubName(String pubName) {
        this.pubName = pubName == null ? null : pubName.trim();
    }

    /**
     * 发布描述
     * @return pub_desc 发布描述
     */
    public String getPubDesc() {
        return pubDesc;
    }

    /**
     * 发布描述
     * @param pubDesc 发布描述
     */
    public void setPubDesc(String pubDesc) {
        this.pubDesc = pubDesc == null ? null : pubDesc.trim();
    }

    /**
     * 关键字
     * @return keywords 关键字
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 关键字
     * @param keywords 关键字
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * 数据类型 （党政类  ...）
     * @return data_type 数据类型 （党政类  ...）
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 数据类型 （党政类  ...）
     * @param dataType 数据类型 （党政类  ...）
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 模型发布人
     * @return model_publisher 模型发布人
     */
    public String getModelPublisher() {
        return modelPublisher;
    }

    /**
     * 模型发布人
     * @param modelPublisher 模型发布人
     */
    public void setModelPublisher(String modelPublisher) {
        this.modelPublisher = modelPublisher == null ? null : modelPublisher.trim();
    }

    /**
     * 发布时间
     * @return publish_time 发布时间
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 发布时间
     * @param publishTime 发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 表名
     * @return table_name 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 表名
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 打标库中表名
     * @return make_table_name 打标库中表名
     */
    public String getMakeTableName() {
        return makeTableName;
    }

    /**
     * 打标库中表名
     * @param makeTableName 打标库中表名
     */
    public void setMakeTableName(String makeTableName) {
        this.makeTableName = makeTableName == null ? null : makeTableName.trim();
    }

    /**
     * 表的注释
     * @return table_comment 表的注释
     */
    public String getTableComment() {
        return tableComment;
    }

    /**
     * 表的注释
     * @param tableComment 表的注释
     */
    public void setTableComment(String tableComment) {
        this.tableComment = tableComment == null ? null : tableComment.trim();
    }

    /**
     * 运行状态 （RUN, STOP）
     * @return run_status 运行状态 （RUN, STOP）
     */
    public String getRunStatus() {
        return runStatus;
    }

    /**
     * 运行状态 （RUN, STOP）
     * @param runStatus 运行状态 （RUN, STOP）
     */
    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus == null ? null : runStatus.trim();
    }

    /**
     * 任务发布状态 （未发布-YES、已发布-NO 审批中-APPROVING,  被拒绝-REJECTED）
     * @return pub_status 任务发布状态 （未发布-YES、已发布-NO 审批中-APPROVING,  被拒绝-REJECTED）
     */
    public String getPubStatus() {
        return pubStatus;
    }

    /**
     * 任务发布状态 （未发布-YES、已发布-NO 审批中-APPROVING,  被拒绝-REJECTED）
     * @param pubStatus 任务发布状态 （未发布-YES、已发布-NO 审批中-APPROVING,  被拒绝-REJECTED）
     */
    public void setPubStatus(String pubStatus) {
        this.pubStatus = pubStatus == null ? null : pubStatus.trim();
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
     * 数据抓取方式 (全量-ALL，增量-INC)
     * @return fetch_type 数据抓取方式 (全量-ALL，增量-INC)
     */
    public String getFetchType() {
        return fetchType;
    }

    /**
     * 数据抓取方式 (全量-ALL，增量-INC)
     * @param fetchType 数据抓取方式 (全量-ALL，增量-INC)
     */
    public void setFetchType(String fetchType) {
        this.fetchType = fetchType == null ? null : fetchType.trim();
    }

    /**
     * 数据最后抓取时间
     * @return last_fetch_time 数据最后抓取时间
     */
    public Date getLastFetchTime() {
        return lastFetchTime;
    }

    /**
     * 数据最后抓取时间
     * @param lastFetchTime 数据最后抓取时间
     */
    public void setLastFetchTime(Date lastFetchTime) {
        this.lastFetchTime = lastFetchTime;
    }

    /**
     * 增量字段名
     * @return increment_column 增量字段名
     */
    public String getIncrementColumn() {
        return incrementColumn;
    }

    /**
     * 增量字段名
     * @param incrementColumn 增量字段名
     */
    public void setIncrementColumn(String incrementColumn) {
        this.incrementColumn = incrementColumn == null ? null : incrementColumn.trim();
    }

    /**
     * 打标方式 （对象模型-OBJECT，库表模型-TABLE）
     * @return make_type 打标方式 （对象模型-OBJECT，库表模型-TABLE）
     */
    public String getMakeType() {
        return makeType;
    }

    /**
     * 打标方式 （对象模型-OBJECT，库表模型-TABLE）
     * @param makeType 打标方式 （对象模型-OBJECT，库表模型-TABLE）
     */
    public void setMakeType(String makeType) {
        this.makeType = makeType == null ? null : makeType.trim();
    }

    /**
     * 抽取方式：抽取后删除/抽取后备份
     * @return extract_type 抽取方式：抽取后删除/抽取后备份
     */
    public String getExtractType() {
        return extractType;
    }

    /**
     * 抽取方式：抽取后删除/抽取后备份
     * @param extractType 抽取方式：抽取后删除/抽取后备份
     */
    public void setExtractType(String extractType) {
        this.extractType = extractType == null ? null : extractType.trim();
    }

    /**
     * 任务ID
     * @return task_id 任务ID
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * 任务ID
     * @param taskId 任务ID
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * 授权类型
     * @return auth_type 授权类型
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * 授权类型
     * @param authType 授权类型
     */
    public void setAuthType(String authType) {
        this.authType = authType == null ? null : authType.trim();
    }

    /**
     * 授权范围
     * @return auth_scope 授权范围
     */
    public String getAuthScope() {
        return authScope;
    }

    /**
     * 授权范围
     * @param authScope 授权范围
     */
    public void setAuthScope(String authScope) {
        this.authScope = authScope == null ? null : authScope.trim();
    }

    /**
     * 是否自动审批
     * @return auto_app 是否自动审批
     */
    public String getAutoApp() {
        return autoApp;
    }

    /**
     * 是否自动审批
     * @param autoApp 是否自动审批
     */
    public void setAutoApp(String autoApp) {
        this.autoApp = autoApp == null ? null : autoApp.trim();
    }

    /**
     * 策略模板ID
     * @return template_id 策略模板ID
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 策略模板ID
     * @param templateId 策略模板ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    /**
     * 删除状态 （DEL, NOR）
     * @return del_status 删除状态 （DEL, NOR）
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 删除状态 （DEL, NOR）
     * @param delStatus 删除状态 （DEL, NOR）
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
     * 修改机构
     * @return upd_org_id 修改机构
     */
    public String getUpdOrgId() {
        return updOrgId;
    }

    /**
     * 修改机构
     * @param updOrgId 修改机构
     */
    public void setUpdOrgId(String updOrgId) {
        this.updOrgId = updOrgId == null ? null : updOrgId.trim();
    }

    /**
     * 修改时间
     * @return upd_tm 修改时间
     */
    public Date getUpdTm() {
        return updTm;
    }

    /**
     * 修改时间
     * @param updTm 修改时间
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