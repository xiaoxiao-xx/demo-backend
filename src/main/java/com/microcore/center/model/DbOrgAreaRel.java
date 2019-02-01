package com.microcore.center.model;

public class DbOrgAreaRel {
    /**
     * 
     */
    private String id;

    /**
     * 机构id
     */
    private String orgId;

    /**
     * 域id
     */
    private String areaId;

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
     * 机构id
     * @return org_id 机构id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 机构id
     * @param orgId 机构id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 域id
     * @return area_id 域id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 域id
     * @param areaId 域id
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }
}