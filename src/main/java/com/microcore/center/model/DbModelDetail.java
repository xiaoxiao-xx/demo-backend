package com.microcore.center.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel
public class DbModelDetail {
    /**
     * 
     */
    private String id;

    /**
     * 上级ID
     */
    private String pid;

    /**
     * 模型ID
     */
    private String modelId;

    /**
     * 级别
     */
    private String dataLevel;

    /**
     * 字段英文名称
     */
    private String fieldEname;

    /**
     * 字段中文名称
     */
    private String fieldCname;

    /**
     * 字段名称
     */
    private String fieldType;

    /**
     * 定义
     */
    private String fieldDesc;

    /**
     * 关系一对一:1 ，一对多:N;表示格式
     */
    private String relation;

    /**
     * 数据类型
     */
    private String type;

    /**
     * 标识符
     */
    private String ename;

    /**
     * 缩写名
     */
    private String sname;

    /**
     * 备注
     */
    private String remark;

    /**
     * 表示格式（d8,c8,c3-9）
     */
    private String dataType;

    /**
     * 值域
     */
    private String dataList;

    /**
     * 约束/条件（必选、可选）
     */
    private String dataCondition;

    /**
     * 最大出现次数
     */
    private String showTimes;

    /**
     * 状态
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
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 上级ID
     * @return pid 上级ID
     */
    public String getPid() {
        return pid;
    }

    /**
     * 上级ID
     * @param pid 上级ID
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
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
     * 级别
     * @return data_level 级别
     */
    public String getDataLevel() {
        return dataLevel;
    }

    /**
     * 级别
     * @param dataLevel 级别
     */
    public void setDataLevel(String dataLevel) {
        this.dataLevel = dataLevel == null ? null : dataLevel.trim();
    }

    /**
     * 字段英文名称
     * @return field_ename 字段英文名称
     */
    public String getFieldEname() {
        return fieldEname;
    }

    /**
     * 字段英文名称
     * @param fieldEname 字段英文名称
     */
    public void setFieldEname(String fieldEname) {
        this.fieldEname = fieldEname == null ? null : fieldEname.trim();
    }

    /**
     * 字段中文名称
     * @return field_cname 字段中文名称
     */
    public String getFieldCname() {
        return fieldCname;
    }

    /**
     * 字段中文名称
     * @param fieldCname 字段中文名称
     */
    public void setFieldCname(String fieldCname) {
        this.fieldCname = fieldCname == null ? null : fieldCname.trim();
    }

    /**
     * 字段类型:引用：reference
     * @return field_type 字段类型:引用：reference
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * 字段类型:引用：reference
     * @param fieldType 字段类型:引用：reference
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    /**
     * 字段描述
     * @return field_desc 字段描述
     */
    public String getFieldDesc() {
        return fieldDesc;
    }

    /**
     * 字段描述
     * @param fieldDesc 字段描述
     */
    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc == null ? null : fieldDesc.trim();
    }

    /**
     * 关系一对一:1 ，一对多:N;表示格式
     * @return relation 关系一对一:1 ，一对多:N;表示格式
     */
    public String getRelation() {
        return relation;
    }

    /**
     * 关系一对一:1 ，一对多:N;表示格式
     * @param relation 关系一对一:1 ，一对多:N;表示格式
     */
    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    /**
     * 类型
     * @return type 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 类型
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 标识符
     * @return ename 标识符
     */
    public String getEname() {
        return ename;
    }

    /**
     * 标识符
     * @param ename 标识符
     */
    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    /**
     * 缩写名
     * @return sname 缩写名
     */
    public String getSname() {
        return sname;
    }

    /**
     * 缩写名
     * @param sname 缩写名
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * 定义：字段名称
     * @return remark 定义：字段名称
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 定义：字段名称
     * @param remark 定义：字段名称
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 表示格式
     * @return data_type 表示格式
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 表示格式
     * @param dataType 表示格式
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 值域
     * @return data_list 值域
     */
    public String getDataList() {
        return dataList;
    }

    /**
     * 值域
     * @param dataList 值域
     */
    public void setDataList(String dataList) {
        this.dataList = dataList == null ? null : dataList.trim();
    }

    /**
     * 约束/条件（必选、可选）
     * @return data_condition 约束/条件（必选、可选）
     */
    public String getDataCondition() {
        return dataCondition;
    }

    /**
     * 约束/条件（必选、可选）
     * @param dataCondition 约束/条件（必选、可选）
     */
    public void setDataCondition(String dataCondition) {
        this.dataCondition = dataCondition == null ? null : dataCondition.trim();
    }

    /**
     * 最大出现次数
     * @return show_times 最大出现次数
     */
    public String getShowTimes() {
        return showTimes;
    }

    /**
     * 最大出现次数
     * @param showTimes 最大出现次数
     */
    public void setShowTimes(String showTimes) {
        this.showTimes = showTimes == null ? null : showTimes.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
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