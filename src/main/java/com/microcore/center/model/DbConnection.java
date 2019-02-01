package com.microcore.center.model;

import java.util.Date;

public class DbConnection {
    /**
     * 主键
     */
    private String id;

    /**
     * jdbc连接IP地址。ex: jdbc:oracle:thin:@127.0.0.1/xe
     */
    private String url;

    /**
     * 数据源类型：订阅:sub，发布:pub
     */
    private String type;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库版本ID
     */
    private String dbVersionId;

    /**
     * 数据库名称
     */
    private String versionName;

    /**
     * 驱动名称
     */
    private String driverClass;

    /**
     * 连接配置名称
     */
    private String connectionName;

    /**
     * ip
     */
    private String ip;

    /**
     * 端口
     */
    private String port;

    /**
     * 数据库名称
     */
    private String dataBaseName;

    /**
     * 配置说明
     */
    private String remark;

    /**
     * 连接所属机构ID
     */
    private String orgId;

    /**
     * 发布状态 (YES, NO)
     */
    private String status;

    /**
     * 是否删除
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
     * 创建人
     */
    private String crtUserId;

    /**
     * 创建机构id
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
     * jdbc连接IP地址。ex: jdbc:oracle:thin:@127.0.0.1/xe
     * @return url jdbc连接IP地址。ex: jdbc:oracle:thin:@127.0.0.1/xe
     */
    public String getUrl() {
        return url;
    }

    /**
     * jdbc连接IP地址。ex: jdbc:oracle:thin:@127.0.0.1/xe
     * @param url jdbc连接IP地址。ex: jdbc:oracle:thin:@127.0.0.1/xe
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 数据源类型：订阅:sub，发布:pub
     * @return type 数据源类型：订阅:sub，发布:pub
     */
    public String getType() {
        return type;
    }

    /**
     * 数据源类型：订阅:sub，发布:pub
     * @param type 数据源类型：订阅:sub，发布:pub
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 用户名
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 数据库版本ID
     * @return db_version_id 数据库版本ID
     */
    public String getDbVersionId() {
        return dbVersionId;
    }

    /**
     * 数据库版本ID
     * @param dbVersionId 数据库版本ID
     */
    public void setDbVersionId(String dbVersionId) {
        this.dbVersionId = dbVersionId == null ? null : dbVersionId.trim();
    }

    /**
     * 数据库名称
     * @return version_name 数据库名称
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * 数据库名称
     * @param versionName 数据库名称
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    /**
     * 驱动名称
     * @return driver_class 驱动名称
     */
    public String getDriverClass() {
        return driverClass;
    }

    /**
     * 驱动名称
     * @param driverClass 驱动名称
     */
    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass == null ? null : driverClass.trim();
    }

    /**
     * 连接配置名称
     * @return connection_name 连接配置名称
     */
    public String getConnectionName() {
        return connectionName;
    }

    /**
     * 连接配置名称
     * @param connectionName 连接配置名称
     */
    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName == null ? null : connectionName.trim();
    }

    /**
     * ip
     * @return ip ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 端口
     * @return port 端口
     */
    public String getPort() {
        return port;
    }

    /**
     * 端口
     * @param port 端口
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * 数据库名称
     * @return data_base_name 数据库名称
     */
    public String getDataBaseName() {
        return dataBaseName;
    }

    /**
     * 数据库名称
     * @param dataBaseName 数据库名称
     */
    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName == null ? null : dataBaseName.trim();
    }

    /**
     * 配置说明
     * @return remark 配置说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 配置说明
     * @param remark 配置说明
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 连接所属机构ID
     * @return org_id 连接所属机构ID
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 连接所属机构ID
     * @param orgId 连接所属机构ID
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 发布状态 (YES, NO)
     * @return status 发布状态 (YES, NO)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 发布状态 (YES, NO)
     * @param status 发布状态 (YES, NO)
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
     * 创建机构id
     * @return crt_org_id 创建机构id
     */
    public String getCrtOrgId() {
        return crtOrgId;
    }

    /**
     * 创建机构id
     * @param crtOrgId 创建机构id
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