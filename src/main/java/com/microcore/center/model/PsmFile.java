package com.microcore.center.model;

import java.util.Date;

public class PsmFile {
    /**
     * 
     */
    private String id;

    /**
     * 原始文件名
     */
    private String oldFileName;

    /**
     * 存储文件名
     */
    private String storeFileName;

    /**
     * 文件后缀，文件类型
     */
    private String suffix;

    /**
     * 文件创建时间
     */
    private Date crtDate;

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
     * 原始文件名
     * @return old_file_name 原始文件名
     */
    public String getOldFileName() {
        return oldFileName;
    }

    /**
     * 原始文件名
     * @param oldFileName 原始文件名
     */
    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName == null ? null : oldFileName.trim();
    }

    /**
     * 存储文件名
     * @return store_file_name 存储文件名
     */
    public String getStoreFileName() {
        return storeFileName;
    }

    /**
     * 存储文件名
     * @param storeFileName 存储文件名
     */
    public void setStoreFileName(String storeFileName) {
        this.storeFileName = storeFileName == null ? null : storeFileName.trim();
    }

    /**
     * 文件后缀，文件类型
     * @return suffix 文件后缀，文件类型
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 文件后缀，文件类型
     * @param suffix 文件后缀，文件类型
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    /**
     * 文件创建时间
     * @return crt_date 文件创建时间
     */
    public Date getCrtDate() {
        return crtDate;
    }

    /**
     * 文件创建时间
     * @param crtDate 文件创建时间
     */
    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }
}