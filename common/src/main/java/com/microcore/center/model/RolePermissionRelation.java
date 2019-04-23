package com.microcore.center.model;

public class RolePermissionRelation {
    /**
     * ID
     */
    private String id;

    /**
     * 权限ID
     */
    private String permissionId;

    /**
     * 资源ID
     */
    private String resourceId;

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
     * 权限ID
     * @return permission_id 权限ID
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * 权限ID
     * @param permissionId 权限ID
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    /**
     * 资源ID
     * @return resource_id 资源ID
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 资源ID
     * @param resourceId 资源ID
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }
}