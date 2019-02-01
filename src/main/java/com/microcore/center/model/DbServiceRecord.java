package com.microcore.center.model;

import java.util.Date;

public class DbServiceRecord {
    /**
     * 主键ID
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
     * 发布人ID
     */
    private String pubUserId;

    /**
     * 申请ID
     */
    private String subId;

    /**
     * 申请机构ID
     */
    private String subOrgId;

    /**
     * 申请人ID
     */
    private String subUserId;

    /**
     * 调用日期
     */
    private Date invokeDate;

    /**
     * 结果(成功：SUCCESS,失败：DEFEAT)
     */
    private String result;

    /**
     * 月份
     */
    private String month;

    /**
     * 代理耗时
     */
    private Long proxyTime;

    /**
     * 数据量(kb)
     */
    private Long dataVolume;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
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
     * 申请ID
     * @return sub_id 申请ID
     */
    public String getSubId() {
        return subId;
    }

    /**
     * 申请ID
     * @param subId 申请ID
     */
    public void setSubId(String subId) {
        this.subId = subId == null ? null : subId.trim();
    }

    /**
     * 申请机构ID
     * @return sub_org_id 申请机构ID
     */
    public String getSubOrgId() {
        return subOrgId;
    }

    /**
     * 申请机构ID
     * @param subOrgId 申请机构ID
     */
    public void setSubOrgId(String subOrgId) {
        this.subOrgId = subOrgId == null ? null : subOrgId.trim();
    }

    /**
     * 申请人ID
     * @return sub_user_id 申请人ID
     */
    public String getSubUserId() {
        return subUserId;
    }

    /**
     * 申请人ID
     * @param subUserId 申请人ID
     */
    public void setSubUserId(String subUserId) {
        this.subUserId = subUserId == null ? null : subUserId.trim();
    }

    /**
     * 调用日期
     * @return invoke_date 调用日期
     */
    public Date getInvokeDate() {
        return invokeDate;
    }

    /**
     * 调用日期
     * @param invokeDate 调用日期
     */
    public void setInvokeDate(Date invokeDate) {
        this.invokeDate = invokeDate;
    }

    /**
     * 结果(成功：SUCCESS,失败：DEFEAT)
     * @return result 结果(成功：SUCCESS,失败：DEFEAT)
     */
    public String getResult() {
        return result;
    }

    /**
     * 结果(成功：SUCCESS,失败：DEFEAT)
     * @param result 结果(成功：SUCCESS,失败：DEFEAT)
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * 月份
     * @return month 月份
     */
    public String getMonth() {
        return month;
    }

    /**
     * 月份
     * @param month 月份
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * 代理耗时
     * @return proxy_time 代理耗时
     */
    public Long getProxyTime() {
        return proxyTime;
    }

    /**
     * 代理耗时
     * @param proxyTime 代理耗时
     */
    public void setProxyTime(Long proxyTime) {
        this.proxyTime = proxyTime;
    }

    /**
     * 数据量(kb)
     * @return data_volume 数据量(kb)
     */
    public Long getDataVolume() {
        return dataVolume;
    }

    /**
     * 数据量(kb)
     * @param dataVolume 数据量(kb)
     */
    public void setDataVolume(Long dataVolume) {
        this.dataVolume = dataVolume;
    }
}