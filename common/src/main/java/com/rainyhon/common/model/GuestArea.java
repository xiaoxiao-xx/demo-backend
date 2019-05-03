package com.rainyhon.common.model;

public class GuestArea {
    /**
     * ID
     */
    private String id;

    /**
     * 访客ID
     */
    private String guestId;

    /**
     * 可活动区域ID
     */
    private String areaId;

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
     * 访客ID
     * @return guest_id 访客ID
     */
    public String getGuestId() {
        return guestId;
    }

    /**
     * 访客ID
     * @param guestId 访客ID
     */
    public void setGuestId(String guestId) {
        this.guestId = guestId == null ? null : guestId.trim();
    }

    /**
     * 可活动区域ID
     * @return area_id 可活动区域ID
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 可活动区域ID
     * @param areaId 可活动区域ID
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }
}