package com.microcore.center.model;

import java.util.Date;

public class DbPubColumn {
    /**
     * ID
     */
    private String id;

    /**
     * db_pub_table.id
     */
    private String pid;

    /**
     * 策略ID
     */
    private String polId;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段类型
     */
    private String columnType;

    /**
     * 字段注释
     */
    private String columnComment;

    /**
     * 敏感等级
     */
    private String securityLevel;

    /**
     * 加密类型
     */
    private String encryptType;

    /**
     * 授权类型
     */
    private String authType;

    /**
     * 授权范围，使用部门范围
     */
    private String authScope;

    /**
     * 使用开始日期
     */
    private Date authStartTime;

    /**
     * 使用结束日期
     */
    private Date authEndDate;

    /**
     * 字段ID
     */
    private Integer sort;

    /**
     * 是否含溯源标记 (YES-有, NO-无)
     */
    private String traceMark;

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
     * db_pub_table.id
     * @return pid db_pub_table.id
     */
    public String getPid() {
        return pid;
    }

    /**
     * db_pub_table.id
     * @param pid db_pub_table.id
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
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
     * 字段名
     * @return column_name 字段名
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 字段名
     * @param columnName 字段名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 字段类型
     * @return column_type 字段类型
     */
    public String getColumnType() {
        return columnType;
    }

    /**
     * 字段类型
     * @param columnType 字段类型
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType == null ? null : columnType.trim();
    }

    /**
     * 字段注释
     * @return column_comment 字段注释
     */
    public String getColumnComment() {
        return columnComment;
    }

    /**
     * 字段注释
     * @param columnComment 字段注释
     */
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment == null ? null : columnComment.trim();
    }

    /**
     * 敏感等级
     * @return security_level 敏感等级
     */
    public String getSecurityLevel() {
        return securityLevel;
    }

    /**
     * 敏感等级
     * @param securityLevel 敏感等级
     */
    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel == null ? null : securityLevel.trim();
    }

    /**
     * 加密类型
     * @return encrypt_type 加密类型
     */
    public String getEncryptType() {
        return encryptType;
    }

    /**
     * 加密类型
     * @param encryptType 加密类型
     */
    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType == null ? null : encryptType.trim();
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
     * 授权范围，使用部门范围
     * @return auth_scope 授权范围，使用部门范围
     */
    public String getAuthScope() {
        return authScope;
    }

    /**
     * 授权范围，使用部门范围
     * @param authScope 授权范围，使用部门范围
     */
    public void setAuthScope(String authScope) {
        this.authScope = authScope == null ? null : authScope.trim();
    }

    /**
     * 使用开始日期
     * @return auth_start_time 使用开始日期
     */
    public Date getAuthStartTime() {
        return authStartTime;
    }

    /**
     * 使用开始日期
     * @param authStartTime 使用开始日期
     */
    public void setAuthStartTime(Date authStartTime) {
        this.authStartTime = authStartTime;
    }

    /**
     * 使用结束日期
     * @return auth_end_date 使用结束日期
     */
    public Date getAuthEndDate() {
        return authEndDate;
    }

    /**
     * 使用结束日期
     * @param authEndDate 使用结束日期
     */
    public void setAuthEndDate(Date authEndDate) {
        this.authEndDate = authEndDate;
    }

    /**
     * 字段ID
     * @return sort 字段ID
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 字段ID
     * @param sort 字段ID
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
}