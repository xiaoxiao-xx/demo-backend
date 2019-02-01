package com.microcore.center.model;

import java.util.ArrayList;
import java.util.List;

public class DbFieldCnfExample {
    /**
     * db_field_cnf
     */
    protected String orderByClause;

    /**
     * db_field_cnf
     */
    protected boolean distinct;

    /**
     * db_field_cnf
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbFieldCnfExample() {
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
     * db_field_cnf null
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andConIdIsNull() {
            addCriterion("con_id is null");
            return (Criteria) this;
        }

        public Criteria andConIdIsNotNull() {
            addCriterion("con_id is not null");
            return (Criteria) this;
        }

        public Criteria andConIdEqualTo(String value) {
            addCriterion("con_id =", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotEqualTo(String value) {
            addCriterion("con_id <>", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdGreaterThan(String value) {
            addCriterion("con_id >", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdGreaterThanOrEqualTo(String value) {
            addCriterion("con_id >=", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLessThan(String value) {
            addCriterion("con_id <", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLessThanOrEqualTo(String value) {
            addCriterion("con_id <=", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLike(String value) {
            addCriterion("con_id like", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotLike(String value) {
            addCriterion("con_id not like", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdIn(List<String> values) {
            addCriterion("con_id in", values, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotIn(List<String> values) {
            addCriterion("con_id not in", values, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdBetween(String value1, String value2) {
            addCriterion("con_id between", value1, value2, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotBetween(String value1, String value2) {
            addCriterion("con_id not between", value1, value2, "conId");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNoteIsNull() {
            addCriterion("field_note is null");
            return (Criteria) this;
        }

        public Criteria andFieldNoteIsNotNull() {
            addCriterion("field_note is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNoteEqualTo(String value) {
            addCriterion("field_note =", value, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteNotEqualTo(String value) {
            addCriterion("field_note <>", value, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteGreaterThan(String value) {
            addCriterion("field_note >", value, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteGreaterThanOrEqualTo(String value) {
            addCriterion("field_note >=", value, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteLessThan(String value) {
            addCriterion("field_note <", value, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteLessThanOrEqualTo(String value) {
            addCriterion("field_note <=", value, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteLike(String value) {
            addCriterion("field_note like", value, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteNotLike(String value) {
            addCriterion("field_note not like", value, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteIn(List<String> values) {
            addCriterion("field_note in", values, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteNotIn(List<String> values) {
            addCriterion("field_note not in", values, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteBetween(String value1, String value2) {
            addCriterion("field_note between", value1, value2, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldNoteNotBetween(String value1, String value2) {
            addCriterion("field_note not between", value1, value2, "fieldNote");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNull() {
            addCriterion("field_type is null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNotNull() {
            addCriterion("field_type is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeEqualTo(String value) {
            addCriterion("field_type =", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotEqualTo(String value) {
            addCriterion("field_type <>", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThan(String value) {
            addCriterion("field_type >", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThanOrEqualTo(String value) {
            addCriterion("field_type >=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThan(String value) {
            addCriterion("field_type <", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThanOrEqualTo(String value) {
            addCriterion("field_type <=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLike(String value) {
            addCriterion("field_type like", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotLike(String value) {
            addCriterion("field_type not like", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIn(List<String> values) {
            addCriterion("field_type in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotIn(List<String> values) {
            addCriterion("field_type not in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeBetween(String value1, String value2) {
            addCriterion("field_type between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotBetween(String value1, String value2) {
            addCriterion("field_type not between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andNullAbledIsNull() {
            addCriterion("null_abled is null");
            return (Criteria) this;
        }

        public Criteria andNullAbledIsNotNull() {
            addCriterion("null_abled is not null");
            return (Criteria) this;
        }

        public Criteria andNullAbledEqualTo(String value) {
            addCriterion("null_abled =", value, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledNotEqualTo(String value) {
            addCriterion("null_abled <>", value, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledGreaterThan(String value) {
            addCriterion("null_abled >", value, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledGreaterThanOrEqualTo(String value) {
            addCriterion("null_abled >=", value, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledLessThan(String value) {
            addCriterion("null_abled <", value, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledLessThanOrEqualTo(String value) {
            addCriterion("null_abled <=", value, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledLike(String value) {
            addCriterion("null_abled like", value, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledNotLike(String value) {
            addCriterion("null_abled not like", value, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledIn(List<String> values) {
            addCriterion("null_abled in", values, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledNotIn(List<String> values) {
            addCriterion("null_abled not in", values, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledBetween(String value1, String value2) {
            addCriterion("null_abled between", value1, value2, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andNullAbledNotBetween(String value1, String value2) {
            addCriterion("null_abled not between", value1, value2, "nullAbled");
            return (Criteria) this;
        }

        public Criteria andFieldLengthIsNull() {
            addCriterion("field_length is null");
            return (Criteria) this;
        }

        public Criteria andFieldLengthIsNotNull() {
            addCriterion("field_length is not null");
            return (Criteria) this;
        }

        public Criteria andFieldLengthEqualTo(Integer value) {
            addCriterion("field_length =", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotEqualTo(Integer value) {
            addCriterion("field_length <>", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthGreaterThan(Integer value) {
            addCriterion("field_length >", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_length >=", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthLessThan(Integer value) {
            addCriterion("field_length <", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthLessThanOrEqualTo(Integer value) {
            addCriterion("field_length <=", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthIn(List<Integer> values) {
            addCriterion("field_length in", values, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotIn(List<Integer> values) {
            addCriterion("field_length not in", values, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthBetween(Integer value1, Integer value2) {
            addCriterion("field_length between", value1, value2, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("field_length not between", value1, value2, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }
    }

    /**
     * db_field_cnf
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_field_cnf null
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