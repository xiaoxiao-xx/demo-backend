package com.rainyhon.common.model;

public class DynamicQueryDictionary {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String key;

    /**
     * 
     */
    private String value;

    /**
     * 
     */
    private String dictionaryId;

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
     * @return key 
     */
    public String getKey() {
        return key;
    }

    /**
     * 
     * @param key 
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * 
     * @return value 
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value 
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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
}