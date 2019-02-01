package com.microcore.center.model;

import java.util.ArrayList;
import java.util.List;

public class DbParamsExample {
    /**
     * db_params
     */
    protected String orderByClause;

    /**
     * db_params
     */
    protected boolean distinct;

    /**
     * db_params
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbParamsExample() {
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
     * db_params null
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

        public Criteria andParamsTypeIsNull() {
            addCriterion("params_type is null");
            return (Criteria) this;
        }

        public Criteria andParamsTypeIsNotNull() {
            addCriterion("params_type is not null");
            return (Criteria) this;
        }

        public Criteria andParamsTypeEqualTo(String value) {
            addCriterion("params_type =", value, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeNotEqualTo(String value) {
            addCriterion("params_type <>", value, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeGreaterThan(String value) {
            addCriterion("params_type >", value, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("params_type >=", value, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeLessThan(String value) {
            addCriterion("params_type <", value, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeLessThanOrEqualTo(String value) {
            addCriterion("params_type <=", value, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeLike(String value) {
            addCriterion("params_type like", value, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeNotLike(String value) {
            addCriterion("params_type not like", value, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeIn(List<String> values) {
            addCriterion("params_type in", values, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeNotIn(List<String> values) {
            addCriterion("params_type not in", values, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeBetween(String value1, String value2) {
            addCriterion("params_type between", value1, value2, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsTypeNotBetween(String value1, String value2) {
            addCriterion("params_type not between", value1, value2, "paramsType");
            return (Criteria) this;
        }

        public Criteria andParamsKeyIsNull() {
            addCriterion("params_key is null");
            return (Criteria) this;
        }

        public Criteria andParamsKeyIsNotNull() {
            addCriterion("params_key is not null");
            return (Criteria) this;
        }

        public Criteria andParamsKeyEqualTo(String value) {
            addCriterion("params_key =", value, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyNotEqualTo(String value) {
            addCriterion("params_key <>", value, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyGreaterThan(String value) {
            addCriterion("params_key >", value, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyGreaterThanOrEqualTo(String value) {
            addCriterion("params_key >=", value, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyLessThan(String value) {
            addCriterion("params_key <", value, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyLessThanOrEqualTo(String value) {
            addCriterion("params_key <=", value, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyLike(String value) {
            addCriterion("params_key like", value, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyNotLike(String value) {
            addCriterion("params_key not like", value, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyIn(List<String> values) {
            addCriterion("params_key in", values, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyNotIn(List<String> values) {
            addCriterion("params_key not in", values, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyBetween(String value1, String value2) {
            addCriterion("params_key between", value1, value2, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsKeyNotBetween(String value1, String value2) {
            addCriterion("params_key not between", value1, value2, "paramsKey");
            return (Criteria) this;
        }

        public Criteria andParamsValueIsNull() {
            addCriterion("params_value is null");
            return (Criteria) this;
        }

        public Criteria andParamsValueIsNotNull() {
            addCriterion("params_value is not null");
            return (Criteria) this;
        }

        public Criteria andParamsValueEqualTo(String value) {
            addCriterion("params_value =", value, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueNotEqualTo(String value) {
            addCriterion("params_value <>", value, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueGreaterThan(String value) {
            addCriterion("params_value >", value, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueGreaterThanOrEqualTo(String value) {
            addCriterion("params_value >=", value, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueLessThan(String value) {
            addCriterion("params_value <", value, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueLessThanOrEqualTo(String value) {
            addCriterion("params_value <=", value, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueLike(String value) {
            addCriterion("params_value like", value, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueNotLike(String value) {
            addCriterion("params_value not like", value, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueIn(List<String> values) {
            addCriterion("params_value in", values, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueNotIn(List<String> values) {
            addCriterion("params_value not in", values, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueBetween(String value1, String value2) {
            addCriterion("params_value between", value1, value2, "paramsValue");
            return (Criteria) this;
        }

        public Criteria andParamsValueNotBetween(String value1, String value2) {
            addCriterion("params_value not between", value1, value2, "paramsValue");
            return (Criteria) this;
        }
    }

    /**
     * db_params
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_params null
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