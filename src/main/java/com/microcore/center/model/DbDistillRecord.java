package com.microcore.center.model;

import java.util.Date;

public class DbDistillRecord {
    /**
     * ID
     */
    private String id;

    /**
     * 发布ID
     */
    private String pubId;

    /**
     * 发布机构ID
     */
    private String pubOrgId;

    /**
     * 订阅ID
     */
    private String subId;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 记录条数
     */
    private Integer recordCount;

    /**
     * 记录大小（字节）
     */
    private Integer recordSize;

    /**
     * 机构ID
     */
    private String orgId;

    /**
     * 状态（脱标中、脱标结束）
     */
    private String status;

    /**
     * 结果（成功、失败）
     */
    private String result;

    /**
     * 脱标日期
     */
    private Date distillDate;

    /**
     * 月份
     */
    private Integer month;

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
     * 订阅ID
     * @return sub_id 订阅ID
     */
    public String getSubId() {
        return subId;
    }

    /**
     * 订阅ID
     * @param subId 订阅ID
     */
    public void setSubId(String subId) {
        this.subId = subId == null ? null : subId.trim();
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
     * 记录条数
     * @return record_count 记录条数
     */
    public Integer getRecordCount() {
        return recordCount;
    }

    /**
     * 记录条数
     * @param recordCount 记录条数
     */
    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    /**
     * 记录大小（字节）
     * @return record_size 记录大小（字节）
     */
    public Integer getRecordSize() {
        return recordSize;
    }

    /**
     * 记录大小（字节）
     * @param recordSize 记录大小（字节）
     */
    public void setRecordSize(Integer recordSize) {
        this.recordSize = recordSize;
    }

    /**
     * 机构ID
     * @return org_id 机构ID
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 机构ID
     * @param orgId 机构ID
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 状态（脱标中、脱标结束）
     * @return status 状态（脱标中、脱标结束）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态（脱标中、脱标结束）
     * @param status 状态（脱标中、脱标结束）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 结果（成功、失败）
     * @return result 结果（成功、失败）
     */
    public String getResult() {
        return result;
    }

    /**
     * 结果（成功、失败）
     * @param result 结果（成功、失败）
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * 脱标日期
     * @return distill_date 脱标日期
     */
    public Date getDistillDate() {
        return distillDate;
    }

    /**
     * 脱标日期
     * @param distillDate 脱标日期
     */
    public void setDistillDate(Date distillDate) {
        this.distillDate = distillDate;
    }

    /**
     * 月份
     * @return month 月份
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 月份
     * @param month 月份
     */
    public void setMonth(Integer month) {
        this.month = month;
    }
}