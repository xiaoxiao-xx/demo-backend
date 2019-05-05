package com.rainyhon.common.model;

public class DeptInfo {
    /**
     * 
     */
    private String deptId;

    /**
     * 机构名称
     */
    private String deptName;

    /**
     * 机构全称
     */
    private String deptFullname;

    /**
     * 机构级别:最高级别为1，依次增加
     */
    private Integer deptLev;

    /**
     * 父机构
     */
    private String parentDeptid;

    /**
     * 
     * @return dept_id 
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 
     * @param deptId 
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    /**
     * 机构名称
     * @return dept_name 机构名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 机构名称
     * @param deptName 机构名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * 机构全称
     * @return dept_fullname 机构全称
     */
    public String getDeptFullname() {
        return deptFullname;
    }

    /**
     * 机构全称
     * @param deptFullname 机构全称
     */
    public void setDeptFullname(String deptFullname) {
        this.deptFullname = deptFullname == null ? null : deptFullname.trim();
    }

    /**
     * 机构级别:最高级别为1，依次增加
     * @return dept_lev 机构级别:最高级别为1，依次增加
     */
    public Integer getDeptLev() {
        return deptLev;
    }

    /**
     * 机构级别:最高级别为1，依次增加
     * @param deptLev 机构级别:最高级别为1，依次增加
     */
    public void setDeptLev(Integer deptLev) {
        this.deptLev = deptLev;
    }

    /**
     * 父机构
     * @return parent_deptid 父机构
     */
    public String getParentDeptid() {
        return parentDeptid;
    }

    /**
     * 父机构
     * @param parentDeptid 父机构
     */
    public void setParentDeptid(String parentDeptid) {
        this.parentDeptid = parentDeptid == null ? null : parentDeptid.trim();
    }
}