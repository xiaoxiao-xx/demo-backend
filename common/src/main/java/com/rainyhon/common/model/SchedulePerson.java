package com.rainyhon.common.model;

public class SchedulePerson {
    /**
     * ID
     */
    private String id;

    /**
     * schedule_config.object_id
     */
    private String objectId;

    /**
     * 人员ID
     */
    private String personId;

    /**
     * 是否领导
     */
    private String leader;

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
     * schedule_config.object_id
     * @return object_id schedule_config.object_id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * schedule_config.object_id
     * @param objectId schedule_config.object_id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * 人员ID
     * @return person_id 人员ID
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * 人员ID
     * @param personId 人员ID
     */
    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    /**
     * 是否领导
     * @return leader 是否领导
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 是否领导
     * @param leader 是否领导
     */
    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }
}