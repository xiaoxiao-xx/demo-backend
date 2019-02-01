package com.microcore.center.model;

import java.util.Date;

public class DbPubFile {
    /**
     * 主键
     */
    private String pubId;

    /**
     * 模型ID
     */
    private String modelId;

    /**
     * 策略ID
     */
    private String polId;

    /**
     * 原文件目录
     */
    private String origPath;

    /**
     * 发布后目录
     */
    private String pubPath;

    /**
     * 敏感等级
     */
    private String senLevel;

    /**
     * 使用部门范围
     */
    private String useScope;

    /**
     * 使用开始日期
     */
    private Date startDate;

    /**
     * 使用结束日期
     */
    private Date endDate;

    /**
     * 数据类型
     */
    private String fileType;

    /**
     * 自定义策略模板
     */
    private String useType;

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
     * 运行状态 RUN启动 STOP停止 
     */
    private String runStatus;

    /**
     * 抽取方式：抽取后删除/抽取后备份
     */
    private String extractType;

    /**
     * 备份路径
     */
    private String backupPath;

    /**
     * 允许使用频率
     */
    private Integer useFre;

    /**
     * 是否允许二次授权
     */
    private String againAcc;

    /**
     * 是否上报使用情况
     */
    private String reportCase;

    /**
     * 是否自动审批
     */
    private String autoApp;

    /**
     * 是否含溯源标记 (YES-有, NO-无)
     */
    private String traceMark;

    /**
     * 策略模板ID
     */
    private String templateId;

    /**
     * 是否直接交换
     */
    private String autoChange;

    /**
     * YPUB已发布 NPUB未发布  审批中-APPROVING,  被拒绝-REJECTED
     */
    private String status;

    /**
     * NOR 正常 DEL删除
     */
    private String delStatus;

    /**
     * 发布人ID
     */
    private String pubUserId;

    /**
     * 发布机构ID
     */
    private String pubOrgId;

    /**
     * 最后修改人
     */
    private String updUserId;

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
     * @return pub_id 主键
     */
    public String getPubId() {
        return pubId;
    }

    /**
     * 主键
     * @param pubId 主键
     */
    public void setPubId(String pubId) {
        this.pubId = pubId == null ? null : pubId.trim();
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
     * 策略ID
     * @return pol_id 策略ID
     */
    public String getPolId() {
        return polId;
    }

    /**
     * 策略ID
     * @param polId 策略ID
     */
    public void setPolId(String polId) {
        this.polId = polId == null ? null : polId.trim();
    }

    /**
     * 原文件目录
     * @return orig_path 原文件目录
     */
    public String getOrigPath() {
        return origPath;
    }

    /**
     * 原文件目录
     * @param origPath 原文件目录
     */
    public void setOrigPath(String origPath) {
        this.origPath = origPath == null ? null : origPath.trim();
    }

    /**
     * 发布后目录
     * @return pub_path 发布后目录
     */
    public String getPubPath() {
        return pubPath;
    }

    /**
     * 发布后目录
     * @param pubPath 发布后目录
     */
    public void setPubPath(String pubPath) {
        this.pubPath = pubPath == null ? null : pubPath.trim();
    }

    /**
     * 敏感等级
     * @return sen_level 敏感等级
     */
    public String getSenLevel() {
        return senLevel;
    }

    /**
     * 敏感等级
     * @param senLevel 敏感等级
     */
    public void setSenLevel(String senLevel) {
        this.senLevel = senLevel == null ? null : senLevel.trim();
    }

    /**
     * 使用部门范围
     * @return use_scope 使用部门范围
     */
    public String getUseScope() {
        return useScope;
    }

    /**
     * 使用部门范围
     * @param useScope 使用部门范围
     */
    public void setUseScope(String useScope) {
        this.useScope = useScope == null ? null : useScope.trim();
    }

    /**
     * 使用开始日期
     * @return start_date 使用开始日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 使用开始日期
     * @param startDate 使用开始日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 使用结束日期
     * @return end_date 使用结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 使用结束日期
     * @param endDate 使用结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 数据类型
     * @return file_type 数据类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 数据类型
     * @param fileType 数据类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 自定义策略模板
     * @return use_type 自定义策略模板
     */
    public String getUseType() {
        return useType;
    }

    /**
     * 自定义策略模板
     * @param useType 自定义策略模板
     */
    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
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
     * 运行状态 RUN启动 STOP停止 
     * @return run_status 运行状态 RUN启动 STOP停止 
     */
    public String getRunStatus() {
        return runStatus;
    }

    /**
     * 运行状态 RUN启动 STOP停止 
     * @param runStatus 运行状态 RUN启动 STOP停止 
     */
    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus == null ? null : runStatus.trim();
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
     * 备份路径
     * @return backup_path 备份路径
     */
    public String getBackupPath() {
        return backupPath;
    }

    /**
     * 备份路径
     * @param backupPath 备份路径
     */
    public void setBackupPath(String backupPath) {
        this.backupPath = backupPath == null ? null : backupPath.trim();
    }

    /**
     * 允许使用频率
     * @return use_fre 允许使用频率
     */
    public Integer getUseFre() {
        return useFre;
    }

    /**
     * 允许使用频率
     * @param useFre 允许使用频率
     */
    public void setUseFre(Integer useFre) {
        this.useFre = useFre;
    }

    /**
     * 是否允许二次授权
     * @return again_acc 是否允许二次授权
     */
    public String getAgainAcc() {
        return againAcc;
    }

    /**
     * 是否允许二次授权
     * @param againAcc 是否允许二次授权
     */
    public void setAgainAcc(String againAcc) {
        this.againAcc = againAcc == null ? null : againAcc.trim();
    }

    /**
     * 是否上报使用情况
     * @return report_case 是否上报使用情况
     */
    public String getReportCase() {
        return reportCase;
    }

    /**
     * 是否上报使用情况
     * @param reportCase 是否上报使用情况
     */
    public void setReportCase(String reportCase) {
        this.reportCase = reportCase == null ? null : reportCase.trim();
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
     * 是否含溯源标记 (YES-有, NO-无)
     * @return trace_mark 是否含溯源标记 (YES-有, NO-无)
     */
    public String getTraceMark() {
        return traceMark;
    }

    /**
     * 是否含溯源标记 (YES-有, NO-无)
     * @param traceMark 是否含溯源标记 (YES-有, NO-无)
     */
    public void setTraceMark(String traceMark) {
        this.traceMark = traceMark == null ? null : traceMark.trim();
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
     * 是否直接交换
     * @return auto_change 是否直接交换
     */
    public String getAutoChange() {
        return autoChange;
    }

    /**
     * 是否直接交换
     * @param autoChange 是否直接交换
     */
    public void setAutoChange(String autoChange) {
        this.autoChange = autoChange == null ? null : autoChange.trim();
    }

    /**
     * YPUB已发布 NPUB未发布  审批中-APPROVING,  被拒绝-REJECTED
     * @return status YPUB已发布 NPUB未发布  审批中-APPROVING,  被拒绝-REJECTED
     */
    public String getStatus() {
        return status;
    }

    /**
     * YPUB已发布 NPUB未发布  审批中-APPROVING,  被拒绝-REJECTED
     * @param status YPUB已发布 NPUB未发布  审批中-APPROVING,  被拒绝-REJECTED
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * NOR 正常 DEL删除
     * @return del_status NOR 正常 DEL删除
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * NOR 正常 DEL删除
     * @param delStatus NOR 正常 DEL删除
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
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