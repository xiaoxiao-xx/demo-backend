package com.rainyhon.common.model;

public class DynamicQueryColumn {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String column;

    /**
     * 
     */
    private String columnDisplayName;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String dictionaryId;

    /**
     * 
     */
    private String viewId;

    /**
     * 
     */
    private String hidden;

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
     * @return column 
     */
    public String getColumn() {
        return column;
    }

    /**
     * 
     * @param column 
     */
    public void setColumn(String column) {
        this.column = column == null ? null : column.trim();
    }

    /**
     * 
     * @return column_display_name 
     */
    public String getColumnDisplayName() {
        return columnDisplayName;
    }

    /**
     * 
     * @param columnDisplayName 
     */
    public void setColumnDisplayName(String columnDisplayName) {
        this.columnDisplayName = columnDisplayName == null ? null : columnDisplayName.trim();
    }

    /**
     * 
     * @return type 
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type 
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 
     * @return dictionary_id 
     */
    public String getDictionaryId() {
        return dictionaryId;
    }

    /**
     * 
     * @param dictionaryId 
     */
    public void setDictionaryId(String dictionaryId) {
        this.dictionaryId = dictionaryId == null ? null : dictionaryId.trim();
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

    /**
     * 
     * @return hidden 
     */
    public String getHidden() {
        return hidden;
    }

    /**
     * 
     * @param hidden 
     */
    public void setHidden(String hidden) {
        this.hidden = hidden == null ? null : hidden.trim();
    }
}