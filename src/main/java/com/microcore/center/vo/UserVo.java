package com.microcore.center.vo;

import com.microcore.center.model.DbUser;

public class UserVo extends DbUser {

    private String care;
    private String remark;

    public String getCare() {
        return care;
    }

    public void setCare(String care) {
        this.care = care;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "care='" + care + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
