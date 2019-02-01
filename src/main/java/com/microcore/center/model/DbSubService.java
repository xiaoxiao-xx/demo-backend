package com.microcore.center.model;

import java.util.Date;

public class DbSubService {
    /**
     * 主键
     */
    private String id;

    /**
     * 接口名称
     */
    private String name;

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
     * 发布状态（PUB，NOT）
     */
    private String pubStatus;

    /**
     * 运行状态（RUN，STOP）
     */
    private String runStatus;

    /**
     * 删除状态（NOR，DEL）
     */
    private String delStatus;

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
     * 申请人
     */
    private String subUserId;

    /**
     * 申请机构
     */
    private String subOrgId;

    /**
     * 申请时间
     */
    private Date subTm;

    /**
     * 服务接口发布ID
     */
    private String pubServiceId;

    /**
     * 使用凭证
     */
    private String subToken;

    /**
     * 签名公钥
     */
    private String publickey;

    /**
     * 签名私钥
     */
    private String privatekey;

    /**
     * 接口完整地址
     */
    private String interfaceUrl;

    /**
     * 交换ID
     */
    private String exchangeId;

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
     * 发布状态（PUB，NOT）
     * @return pub_status 发布状态（PUB，NOT）
     */
    public String getPubStatus() {
        return pubStatus;
    }

    /**
     * 发布状态（PUB，NOT）
     * @param pubStatus 发布状态（PUB，NOT）
     */
    public void setPubStatus(String pubStatus) {
        this.pubStatus = pubStatus == null ? null : pubStatus.trim();
    }

    /**
     * 运行状态（RUN，STOP）
     * @return run_status 运行状态（RUN，STOP）
     */
    public String getRunStatus() {
        return runStatus;
    }

    /**
     * 运行状态（RUN，STOP）
     * @param runStatus 运行状态（RUN，STOP）
     */
    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus == null ? null : runStatus.trim();
    }

    /**
     * 删除状态（NOR，DEL）
     * @return del_status 删除状态（NOR，DEL）
     */
    public String getDelStatus() {
        return delStatus;
    }

    /**
     * 删除状态（NOR，DEL）
     * @param delStatus 删除状态（NOR，DEL）
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
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

    /**
     * 申请人
     * @return sub_user_id 申请人
     */
    public String getSubUserId() {
        return subUserId;
    }

    /**
     * 申请人
     * @param subUserId 申请人
     */
    public void setSubUserId(String subUserId) {
        this.subUserId = subUserId == null ? null : subUserId.trim();
    }

    /**
     * 申请机构
     * @return sub_org_id 申请机构
     */
    public String getSubOrgId() {
        return subOrgId;
    }

    /**
     * 申请机构
     * @param subOrgId 申请机构
     */
    public void setSubOrgId(String subOrgId) {
        this.subOrgId = subOrgId == null ? null : subOrgId.trim();
    }

    /**
     * 申请时间
     * @return sub_tm 申请时间
     */
    public Date getSubTm() {
        return subTm;
    }

    /**
     * 申请时间
     * @param subTm 申请时间
     */
    public void setSubTm(Date subTm) {
        this.subTm = subTm;
    }

    /**
     * 服务接口发布ID
     * @return pub_service_id 服务接口发布ID
     */
    public String getPubServiceId() {
        return pubServiceId;
    }

    /**
     * 服务接口发布ID
     * @param pubServiceId 服务接口发布ID
     */
    public void setPubServiceId(String pubServiceId) {
        this.pubServiceId = pubServiceId == null ? null : pubServiceId.trim();
    }

    /**
     * 使用凭证
     * @return sub_token 使用凭证
     */
    public String getSubToken() {
        return subToken;
    }

    /**
     * 使用凭证
     * @param subToken 使用凭证
     */
    public void setSubToken(String subToken) {
        this.subToken = subToken == null ? null : subToken.trim();
    }

    /**
     * 签名公钥
     * @return publicKey 签名公钥
     */
    public String getPublickey() {
        return publickey;
    }

    /**
     * 签名公钥
     * @param publickey 签名公钥
     */
    public void setPublickey(String publickey) {
        this.publickey = publickey == null ? null : publickey.trim();
    }

    /**
     * 签名私钥
     * @return privateKey 签名私钥
     */
    public String getPrivatekey() {
        return privatekey;
    }

    /**
     * 签名私钥
     * @param privatekey 签名私钥
     */
    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey == null ? null : privatekey.trim();
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
     * 交换ID
     * @return exchange_id 交换ID
     */
    public String getExchangeId() {
        return exchangeId;
    }

    /**
     * 交换ID
     * @param exchangeId 交换ID
     */
    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId == null ? null : exchangeId.trim();
    }
}