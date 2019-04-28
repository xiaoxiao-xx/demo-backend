package com.rainyhon.common.model;

public class DynamicQueryUnary {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String expression;

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
     * 
     * @return expression 
     */
    public String getExpression() {
        return expression;
    }

    /**
     * 
     * @param expression 
     */
    public void setExpression(String expression) {
        this.expression = expression == null ? null : expression.trim();
    }
}