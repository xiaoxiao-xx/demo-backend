package com.microcore.center.model;

public class DbVersion {
    /**
     * 主键
     */
    private String id;

    /**
     * 数据库版本号。如 orc_10g, mysql_5.7
     */
    private String version;

    /**
     * jar包存放路径
     */
    private String jarPath;

    /**
     * 驱动类名
     */
    private String driverType;

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
     * 数据库版本号。如 orc_10g, mysql_5.7
     * @return version 数据库版本号。如 orc_10g, mysql_5.7
     */
    public String getVersion() {
        return version;
    }

    /**
     * 数据库版本号。如 orc_10g, mysql_5.7
     * @param version 数据库版本号。如 orc_10g, mysql_5.7
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * jar包存放路径
     * @return jar_path jar包存放路径
     */
    public String getJarPath() {
        return jarPath;
    }

    /**
     * jar包存放路径
     * @param jarPath jar包存放路径
     */
    public void setJarPath(String jarPath) {
        this.jarPath = jarPath == null ? null : jarPath.trim();
    }

    /**
     * 驱动类名
     * @return driver_type 驱动类名
     */
    public String getDriverType() {
        return driverType;
    }

    /**
     * 驱动类名
     * @param driverType 驱动类名
     */
    public void setDriverType(String driverType) {
        this.driverType = driverType == null ? null : driverType.trim();
    }
}