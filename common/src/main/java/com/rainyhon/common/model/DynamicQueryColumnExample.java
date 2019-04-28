package com.rainyhon.common.model;

import java.util.ArrayList;
import java.util.List;

public class DynamicQueryColumnExample {
    /**
     * dynamic_query_column
     */
    protected String orderByClause;

    /**
     * dynamic_query_column
     */
    protected boolean distinct;

    /**
     * dynamic_query_column
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DynamicQueryColumnExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * dynamic_query_column null
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andColumnIsNull() {
            addCriterion("column is null");
            return (Criteria) this;
        }

        public Criteria andColumnIsNotNull() {
            addCriterion("column is not null");
            return (Criteria) this;
        }

        public Criteria andColumnEqualTo(String value) {
            addCriterion("column =", value, "column");
            return (Criteria) this;
        }

        public Criteria andColumnNotEqualTo(String value) {
            addCriterion("column <>", value, "column");
            return (Criteria) this;
        }

        public Criteria andColumnGreaterThan(String value) {
            addCriterion("column >", value, "column");
            return (Criteria) this;
        }

        public Criteria andColumnGreaterThanOrEqualTo(String value) {
            addCriterion("column >=", value, "column");
            return (Criteria) this;
        }

        public Criteria andColumnLessThan(String value) {
            addCriterion("column <", value, "column");
            return (Criteria) this;
        }

        public Criteria andColumnLessThanOrEqualTo(String value) {
            addCriterion("column <=", value, "column");
            return (Criteria) this;
        }

        public Criteria andColumnLike(String value) {
            addCriterion("column like", value, "column");
            return (Criteria) this;
        }

        public Criteria andColumnNotLike(String value) {
            addCriterion("column not like", value, "column");
            return (Criteria) this;
        }

        public Criteria andColumnIn(List<String> values) {
            addCriterion("column in", values, "column");
            return (Criteria) this;
        }

        public Criteria andColumnNotIn(List<String> values) {
            addCriterion("column not in", values, "column");
            return (Criteria) this;
        }

        public Criteria andColumnBetween(String value1, String value2) {
            addCriterion("column between", value1, value2, "column");
            return (Criteria) this;
        }

        public Criteria andColumnNotBetween(String value1, String value2) {
            addCriterion("column not between", value1, value2, "column");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameIsNull() {
            addCriterion("column_display_name is null");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameIsNotNull() {
            addCriterion("column_display_name is not null");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameEqualTo(String value) {
            addCriterion("column_display_name =", value, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameNotEqualTo(String value) {
            addCriterion("column_display_name <>", value, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameGreaterThan(String value) {
            addCriterion("column_display_name >", value, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("column_display_name >=", value, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameLessThan(String value) {
            addCriterion("column_display_name <", value, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("column_display_name <=", value, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameLike(String value) {
            addCriterion("column_display_name like", value, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameNotLike(String value) {
            addCriterion("column_display_name not like", value, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameIn(List<String> values) {
            addCriterion("column_display_name in", values, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameNotIn(List<String> values) {
            addCriterion("column_display_name not in", values, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameBetween(String value1, String value2) {
            addCriterion("column_display_name between", value1, value2, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andColumnDisplayNameNotBetween(String value1, String value2) {
            addCriterion("column_display_name not between", value1, value2, "columnDisplayName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdIsNull() {
            addCriterion("dictionary_id is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdIsNotNull() {
            addCriterion("dictionary_id is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdEqualTo(String value) {
            addCriterion("dictionary_id =", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotEqualTo(String value) {
            addCriterion("dictionary_id <>", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdGreaterThan(String value) {
            addCriterion("dictionary_id >", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_id >=", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdLessThan(String value) {
            addCriterion("dictionary_id <", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdLessThanOrEqualTo(String value) {
            addCriterion("dictionary_id <=", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdLike(String value) {
            addCriterion("dictionary_id like", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotLike(String value) {
            addCriterion("dictionary_id not like", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdIn(List<String> values) {
            addCriterion("dictionary_id in", values, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotIn(List<String> values) {
            addCriterion("dictionary_id not in", values, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdBetween(String value1, String value2) {
            addCriterion("dictionary_id between", value1, value2, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotBetween(String value1, String value2) {
            addCriterion("dictionary_id not between", value1, value2, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andViewIdIsNull() {
            addCriterion("view_id is null");
            return (Criteria) this;
        }

        public Criteria andViewIdIsNotNull() {
            addCriterion("view_id is not null");
            return (Criteria) this;
        }

        public Criteria andViewIdEqualTo(String value) {
            addCriterion("view_id =", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdNotEqualTo(String value) {
            addCriterion("view_id <>", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdGreaterThan(String value) {
            addCriterion("view_id >", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdGreaterThanOrEqualTo(String value) {
            addCriterion("view_id >=", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdLessThan(String value) {
            addCriterion("view_id <", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdLessThanOrEqualTo(String value) {
            addCriterion("view_id <=", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdLike(String value) {
            addCriterion("view_id like", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdNotLike(String value) {
            addCriterion("view_id not like", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdIn(List<String> values) {
            addCriterion("view_id in", values, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdNotIn(List<String> values) {
            addCriterion("view_id not in", values, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdBetween(String value1, String value2) {
            addCriterion("view_id between", value1, value2, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdNotBetween(String value1, String value2) {
            addCriterion("view_id not between", value1, value2, "viewId");
            return (Criteria) this;
        }

        public Criteria andHiddenIsNull() {
            addCriterion("hidden is null");
            return (Criteria) this;
        }

        public Criteria andHiddenIsNotNull() {
            addCriterion("hidden is not null");
            return (Criteria) this;
        }

        public Criteria andHiddenEqualTo(String value) {
            addCriterion("hidden =", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotEqualTo(String value) {
            addCriterion("hidden <>", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThan(String value) {
            addCriterion("hidden >", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThanOrEqualTo(String value) {
            addCriterion("hidden >=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThan(String value) {
            addCriterion("hidden <", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThanOrEqualTo(String value) {
            addCriterion("hidden <=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLike(String value) {
            addCriterion("hidden like", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotLike(String value) {
            addCriterion("hidden not like", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenIn(List<String> values) {
            addCriterion("hidden in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotIn(List<String> values) {
            addCriterion("hidden not in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenBetween(String value1, String value2) {
            addCriterion("hidden between", value1, value2, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotBetween(String value1, String value2) {
            addCriterion("hidden not between", value1, value2, "hidden");
            return (Criteria) this;
        }
    }

    /**
     * dynamic_query_column
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * dynamic_query_column null
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}