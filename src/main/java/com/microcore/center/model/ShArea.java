package com.microcore.center.model;

public class ShArea {
    /**
     * ID
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 简称
     */
    private String shortname;

    /**
     * 名称
     */
    private String name;

    /**
     * 全称
     */
    private String mergerName;

    /**
     * 层级 0 1 2 省市区县
     */
    private Byte level;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 长途区号
     */
    private String code;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 首字母
     */
    private String first;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * ID
     * @return id ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 父id
     * @return pid 父id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 父id
     * @param pid 父id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 简称
     * @return shortname 简称
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * 简称
     * @param shortname 简称
     */
    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 全称
     * @return merger_name 全称
     */
    public String getMergerName() {
        return mergerName;
    }

    /**
     * 全称
     * @param mergerName 全称
     */
    public void setMergerName(String mergerName) {
        this.mergerName = mergerName == null ? null : mergerName.trim();
    }

    /**
     * 层级 0 1 2 省市区县
     * @return level 层级 0 1 2 省市区县
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * 层级 0 1 2 省市区县
     * @param level 层级 0 1 2 省市区县
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * 拼音
     * @return pinyin 拼音
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * 拼音
     * @param pinyin 拼音
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    /**
     * 长途区号
     * @return code 长途区号
     */
    public String getCode() {
        return code;
    }

    /**
     * 长途区号
     * @param code 长途区号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 邮编
     * @return zip_code 邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 邮编
     * @param zipCode 邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * 首字母
     * @return first 首字母
     */
    public String getFirst() {
        return first;
    }

    /**
     * 首字母
     * @param first 首字母
     */
    public void setFirst(String first) {
        this.first = first == null ? null : first.trim();
    }

    /**
     * 经度
     * @return lng 经度
     */
    public String getLng() {
        return lng;
    }

    /**
     * 经度
     * @param lng 经度
     */
    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    /**
     * 纬度
     * @return lat 纬度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 纬度
     * @param lat 纬度
     */
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }
}