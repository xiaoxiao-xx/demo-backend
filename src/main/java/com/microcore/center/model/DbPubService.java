package com.microcore.center.model;

import java.util.Date;

public class DbPubService {
    /**
     * 主键
     */
    private String id;

    /**
     * 模型ID
     */
    private String modelId;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 接口完整地址
     */
    private String interfaceUrl;

    /**
     * 目标接口IP
     */
    private String targetIp;

    /**
     * 目标接口端口
     */
    private Integer targetPort;

    /**
     * 目标接口地址
     */
    private String interfaceName;

    /**
     * 接口类型
     */
    private String interfaceType;

    /**
     * 请求方式
     */
    private String requestMode;

    /**
     * WSDL方法名
     */
    private String wsdlMethodName;

    /**
     * 中文描述
     */
    private String chineseDescribe;

    /**
     * 示例代码
     */
    private String wordExample;

    /**
     * 策略id
     */
    private String polId;

    /**
     * 使用频率
     */
    private Integer useFrequency;

    /**
     * 使用开始时间
     */
    private Date startDate;

    /**
     * 使用结束时间
     */
    private Date endDate;

    /**
     * 授权类型
     */
    private String useType;

    /**
     * 授权范围
     */
    private String useScope;

    /**
     * 数据类型 （党政类  ...）
     */
    private String dataType;

    /**
     * 是否允许二次授权（YES,NO）
     */
    private String secondAuth;

    /**
     * 是否需要上报使用情况（YES,NO）
     */
    private String reportSituation;

    /**
     * 安全等级
     */
    private String securityLevel;

    /**
     * 覆盖策略：时间戳/UUID
     */
    private String coverType;

    /**
     * 代理接口IP
     */
    private String proxyIp;

    /**
     * 代理接口端口
     */
    private Integer proxyPort;

    /**
     * 代理接口地址
     */
    private String proxyInterfaceName;

    /**
     * 是否签名(是:YES，否:NO)
     */
    private String isSign;

    /**
     * 发布状态(PUB,NOT,审批中-APPROVING,  被拒绝-REJECTED)
     */
    private String pubStatus;

    /**
     * 是否自动审批
     */
    private String autoApp;

    /**
     * 运行状态(RUN,STOP)
     */
    private String runStatus;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 策略模板ID
     */
    private String templateId;

    /**
     * 删除状态(NOR,DEL)
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
     * 发布人
     */
    private String crtUserId;

    /**
     * 发布机构
     */
    private String crtOrgId;

    /**
     * 发布时间
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
     * 接口名称
     * @return name 接口名称
     */
    public String getName() {
        return name;
    }

    /**
     * 接口名称
     * @param name 接口名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 接口完整地址
     * @return interface_url 接口完整地址
     */
    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    /**
     * 接口完整地址
     * @param interfaceUrl 接口完整地址
     */
    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl == null ? null : interfaceUrl.trim();
    }

    /**
     * 目标接口IP
     * @return target_ip 目标接口IP
     */
    public String getTargetIp() {
        return targetIp;
    }

    /**
     * 目标接口IP
     * @param targetIp 目标接口IP
     */
    public void setTargetIp(String targetIp) {
        this.targetIp = targetIp == null ? null : targetIp.trim();
    }

    /**
     * 目标接口端口
     * @return target_port 目标接口端口
     */
    public Integer getTargetPort() {
        return targetPort;
    }

    /**
     * 目标接口端口
     * @param targetPort 目标接口端口
     */
    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
    }

    /**
     * 目标接口地址
     * @return interface_name 目标接口地址
     */
    public String getInterfaceName() {
        return interfaceName;
    }

    /**
     * 目标接口地址
     * @param interfaceName 目标接口地址
     */
    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    /**
     * 接口类型
     * @return interface_type 接口类型
     */
    public String getInterfaceType() {
        return interfaceType;
    }

    /**
     * 接口类型
     * @param interfaceType 接口类型
     */
    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType == null ? null : interfaceType.trim();
    }

    /**
     * 请求方式
     * @return request_mode 请求方式
     */
    public String getRequestMode() {
        return requestMode;
    }

    /**
     * 请求方式
     * @param requestMode 请求方式
     */
    public void setRequestMode(String requestMode) {
        this.requestMode = requestMode == null ? null : requestMode.trim();
    }

    /**
     * WSDL方法名
     * @return wsdl_method_name WSDL方法名
     */
    public String getWsdlMethodName() {
        return wsdlMethodName;
    }

    /**
     * WSDL方法名
     * @param wsdlMethodName WSDL方法名
     */
    public void setWsdlMethodName(String wsdlMethodName) {
        this.wsdlMethodName = wsdlMethodName == null ? null : wsdlMethodName.trim();
    }

    /**
     * 中文描述
     * @return chinese_describe 中文描述
     */
    public String getChineseDescribe() {
        return chineseDescribe;
    }

    /**
     * 中文描述
     * @param chineseDescribe 中文描述
     */
    public void setChineseDescribe(String chineseDescribe) {
        this.chineseDescribe = chineseDescribe == null ? null : chineseDescribe.trim();
    }

    /**
     * 示例代码
     * @return word_example 示例代码
     */
    public String getWordExample() {
        return wordExample;
    }

    /**
     * 示例代码
     * @param wordExample 示例代码
     */
    public void setWordExample(String wordExample) {
        this.wordExample = wordExample == null ? null : wordExample.trim();
    }

    /**
     * 策略id
     * @return pol_id 策略id
     */
    public String getPolId() {
        return polId;
    }

    /**
     * 策略id
     * @param polId 策略id
     */
    public void setPolId(String polId) {
        this.polId = polId == null ? null : polId.trim();
    }

    /**
     * 使用频率
     * @return use_frequency 使用频率
     */
    public Integer getUseFrequency() {
        return useFrequency;
    }

    /**
     * 使用频率
     * @param useFrequency 使用频率
     */
    public void setUseFrequency(Integer useFrequency) {
        this.useFrequency = useFrequency;
    }

    /**
     * 使用开始时间
     * @return start_date 使用开始时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 使用开始时间
     * @param startDate 使用开始时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 使用结束时间
     * @return end_date 使用结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 使用结束时间
     * @param endDate 使用结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 授权类型
     * @return use_type 授权类型
     */
    public String getUseType() {
        return useType;
    }

    /**
     * 授权类型
     * @param useType 授权类型
     */
    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    /**
     * 授权范围
     * @return use_scope 授权范围
     */
    public String getUseScope() {
        return useScope;
    }

    /**
     * 授权范围
     * @param useScope 授权范围
     */
    public void setUseScope(String useScope) {
        this.useScope = useScope == null ? null : useScope.trim();
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
     * 是否允许二次授权（YES,NO）
     * @return second_auth 是否允许二次授权（YES,NO）
     */
    public String getSecondAuth() {
        return secondAuth;
    }

    /**
     * 是否允许二次授权（YES,NO）
     * @param secondAuth 是否允许二次授权（YES,NO）
     */
    public void setSecondAuth(String secondAuth) {
        this.secondAuth = secondAuth == null ? null : secondAuth.trim();
    }

    /**
     * 是否需要上报使用情况（YES,NO）
     * @return report_situation 是否需要上报使用情况（YES,NO）
     */
    public String getReportSituation() {
        return reportSituation;
    }

    /**
     * 是否需要上报使用情况（YES,NO）
     * @param reportSituation 是否需要上报使用情况（YES,NO）
     */
    public void setReportSituation(String reportSituation) {
        this.reportSituation = reportSituation == null ? null : reportSituation.trim();
    }

    /**
     * 安全等级
     * @return security_level 安全等级
     */
    public String getSecurityLevel() {
        return securityLevel;
    }

    /**
     * 安全等级
     * @param securityLevel 安全等级
     */
    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel == null ? null : securityLevel.trim();
    }

    /**
     * 覆盖策略：时间戳/UUID
     * @return cover_type 覆盖策略：时间戳/UUID
     */
    public String getCoverType() {
        return coverType;
    }

    /**
     * 覆盖策略：时间戳/UUID
     * @param coverType 覆盖策略：时间戳/UUID
     */
    public void setCoverType(String coverType) {
        this.coverType = coverType == null ? null : coverType.trim();
    }

    /**
     * 代理接口IP
     * @return proxy_ip 代理接口IP
     */
    public String getProxyIp() {
        return proxyIp;
    }

    /**
     * 代理接口IP
     * @param proxyIp 代理接口IP
     */
    public void setProxyIp(String proxyIp) {
        this.proxyIp = proxyIp == null ? null : proxyIp.trim();
    }

    /**
     * 代理接口端口
     * @return proxy_port 代理接口端口
     */
    public Integer getProxyPort() {
        return proxyPort;
    }

    /**
     * 代理接口端口
     * @param proxyPort 代理接口端口
     */
    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    /**
     * 代理接口地址
     * @return proxy_interface_name 代理接口地址
     */
    public String getProxyInterfaceName() {
        return proxyInterfaceName;
    }

    /**
     * 代理接口地址
     * @param proxyInterfaceName 代理接口地址
     */
    public void setProxyInterfaceName(String proxyInterfaceName) {
        this.proxyInterfaceName = proxyInterfaceName == null ? null : proxyInterfaceName.trim();
    }

    /**
     * 是否签名(是:YES，否:NO)
     * @return is_sign 是否签名(是:YES，否:NO)
     */
    public String getIsSign() {
        return isSign;
    }

    /**
     * 是否签名(是:YES，否:NO)
     * @param isSign 是否签名(是:YES，否:NO)
     */
    public void setIsSign(String isSign) {
        this.isSign = isSign == null ? null : isSign.trim();
    }

    /**
     * 发布状态(PUB,NOT,审批中-APPROVING,  被拒绝-REJECTED)
     * @return pub_status 发布状态(PUB,NOT,审批中-APPROVING,  被拒绝-REJECTED)
     */
    public String getPubStatus() {
        return pubStatus;
    }

    /**
     * 发布状态(PUB,NOT,审批中-APPROVING,  被拒绝-REJECTED)
     * @param pubStatus 发布状态(PUB,NOT,审批中-APPROVING,  被拒绝-REJECTED)
     */
    public void setPubStatus(String pubStatus) {
        this.pubStatus = pubStatus == null ? null : pubStatus.trim();
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
     * 运行状态(RUN,STOP)
     * @return run_status 运行状态(RUN,STOP)
     */
    public String getRunStatus() {
        return runStatus;
    }

    /**
     * 运行状态(RUN,STOP)
     * @param runStatus 运行状态(RUN,STOP)
     */
    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus == null ? null : runStatus.trim();
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
     * 删除状态(NOR,DEL)
     * @return del_status 删除状态(NOR,DEL)
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 删除状态(NOR,DEL)
     * @param delStatus 删除状态(NOR,DEL)
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
     * 发布人
     * @return crt_user_id 发布人
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /**
     * 发布人
     * @param crtUserId 发布人
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId == null ? null : crtUserId.trim();
    }

    /**
     * 发布机构
     * @return crt_org_id 发布机构
     */
    public String getCrtOrgId() {
        return crtOrgId;
    }

    /**
     * 发布机构
     * @param crtOrgId 发布机构
     */
    public void setCrtOrgId(String crtOrgId) {
        this.crtOrgId = crtOrgId == null ? null : crtOrgId.trim();
    }

    /**
     * 发布时间
     * @return crt_tm 发布时间
     */
    public Date getCrtTm() {
        return crtTm;
    }

    /**
     * 发布时间
     * @param crtTm 发布时间
     */
    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }
}