package com.rainyhon.common.model;

public class DynamicQueryUnaryRelation {
    /**
     * 
     */
    private String unaryId;

    /**
     * 后一元的id
     */
    private String aftUnaryId;

    /**
     * 
     */
    private String relation;

    /**
     * 
     */
    private Integer order;

    /**
     * 
     */
    private String viewId;

    /**
     * 
     * @return unary_id 
     */
    public String getUnaryId() {
        return unaryId;
    }

    /**
     * 
     * @param unaryId 
     */
    public void setUnaryId(String unaryId) {
        this.unaryId = unaryId == null ? null : unaryId.trim();
    }

    /**
     * 前一元的id
     * @return pre_unary_id 前一元的id
     */
    public String getAftUnaryId() {
        return aftUnaryId;
    }

    /**
     * 前一元的id
     * @param aftUnaryId 前一元的id
     */
    public void setAftUnaryId(String aftUnaryId) {
        this.aftUnaryId = aftUnaryId == null ? null : aftUnaryId.trim();
    }

    /**
     * 
     * @return relation 
     */
    public String getRelation() {
        return relation;
    }

    /**
     * 
     * @param relation 
     */
    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    /**
     * 
     * @return order 
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 
     * @param order 
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 
     * @return view_id 
     */
    public String getViewId() {
        return viewId;
    }

    /**
     * 
     * @param viewId 
     */
    public void setViewId(String viewId) {
        this.viewId = viewId == null ? null : viewId.trim();
    }
}