package com.microcore.center.model;

import java.util.Date;

public class DbTransRecord {
    /**
     * id
     */
    private String id;

    /**
     * 发布ID
     */
    private String pubId;

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
     * 状态（抓取中、抓取结束）
     */
    private String status;

    /**
     * 结果（成功、失败）
     */
    private String result;

    /**
     * 打标日期
     */
    private Date transDate;

    /**
     * 打标开始时间
     */
    private Date startTm;

    /**
     * 打标结束时间
     */
    private Date endTm;

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
     * 状态（抓取中、抓取结束）
     * @return status 状态（抓取中、抓取结束）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态（抓取中、抓取结束）
     * @param status 状态（抓取中、抓取结束）
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
     * 打标日期
     * @return trans_date 打标日期
     */
    public Date getTransDate() {
        return transDate;
    }

    /**
     * 打标日期
     * @param transDate 打标日期
     */
    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    /**
     * 打标开始时间
     * @return start_tm 打标开始时间
     */
    public Date getStartTm() {
        return startTm;
    }

    /**
     * 打标开始时间
     * @param startTm 打标开始时间
     */
    public void setStartTm(Date startTm) {
        this.startTm = startTm;
    }

    /**
     * 打标结束时间
     * @return end_tm 打标结束时间
     */
    public Date getEndTm() {
        return endTm;
    }

    /**
     * 打标结束时间
     * @param endTm 打标结束时间
     */
    public void setEndTm(Date endTm) {
        this.endTm = endTm;
    }
}