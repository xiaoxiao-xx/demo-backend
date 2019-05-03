package com.rainyhon.common.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WorkHolidayCalendar {
    /**
     * ID
     */
    private String id;

    /**
     * 节假日日期
     */
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date holidayDate;

    /**
     * 备注
     */
    private String remark;

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
     * 节假日日期
     * @return holiday_date 节假日日期
     */
    public Date getHolidayDate() {
        return holidayDate;
    }

    /**
     * 节假日日期
     * @param holidayDate 节假日日期
     */
    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}