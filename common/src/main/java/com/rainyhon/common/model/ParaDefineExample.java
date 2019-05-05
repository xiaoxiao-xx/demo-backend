package com.rainyhon.common.model;

import java.util.ArrayList;
import java.util.List;

public class ParaDefineExample {
    /**
     * para_define
     */
    protected String orderByClause;

    /**
     * para_define
     */
    protected boolean distinct;

    /**
     * para_define
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public ParaDefineExample() {
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
     * para_define null
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

        public Criteria andParaTypeIsNull() {
            addCriterion("para_type is null");
            return (Criteria) this;
        }

        public Criteria andParaTypeIsNotNull() {
            addCriterion("para_type is not null");
            return (Criteria) this;
        }

        public Criteria andParaTypeEqualTo(String value) {
            addCriterion("para_type =", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotEqualTo(String value) {
            addCriterion("para_type <>", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeGreaterThan(String value) {
            addCriterion("para_type >", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("para_type >=", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeLessThan(String value) {
            addCriterion("para_type <", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeLessThanOrEqualTo(String value) {
            addCriterion("para_type <=", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeLike(String value) {
            addCriterion("para_type like", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotLike(String value) {
            addCriterion("para_type not like", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeIn(List<String> values) {
            addCriterion("para_type in", values, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotIn(List<String> values) {
            addCriterion("para_type not in", values, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeBetween(String value1, String value2) {
            addCriterion("para_type between", value1, value2, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotBetween(String value1, String value2) {
            addCriterion("para_type not between", value1, value2, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaCodeIsNull() {
            addCriterion("para_code is null");
            return (Criteria) this;
        }

        public Criteria andParaCodeIsNotNull() {
            addCriterion("para_code is not null");
            return (Criteria) this;
        }

        public Criteria andParaCodeEqualTo(String value) {
            addCriterion("para_code =", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeNotEqualTo(String value) {
            addCriterion("para_code <>", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeGreaterThan(String value) {
            addCriterion("para_code >", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("para_code >=", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeLessThan(String value) {
            addCriterion("para_code <", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeLessThanOrEqualTo(String value) {
            addCriterion("para_code <=", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeLike(String value) {
            addCriterion("para_code like", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeNotLike(String value) {
            addCriterion("para_code not like", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeIn(List<String> values) {
            addCriterion("para_code in", values, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeNotIn(List<String> values) {
            addCriterion("para_code not in", values, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeBetween(String value1, String value2) {
            addCriterion("para_code between", value1, value2, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeNotBetween(String value1, String value2) {
            addCriterion("para_code not between", value1, value2, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaValueIsNull() {
            addCriterion("para_value is null");
            return (Criteria) this;
        }

        public Criteria andParaValueIsNotNull() {
            addCriterion("para_value is not null");
            return (Criteria) this;
        }

        public Criteria andParaValueEqualTo(String value) {
            addCriterion("para_value =", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueNotEqualTo(String value) {
            addCriterion("para_value <>", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueGreaterThan(String value) {
            addCriterion("para_value >", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueGreaterThanOrEqualTo(String value) {
            addCriterion("para_value >=", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueLessThan(String value) {
            addCriterion("para_value <", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueLessThanOrEqualTo(String value) {
            addCriterion("para_value <=", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueLike(String value) {
            addCriterion("para_value like", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueNotLike(String value) {
            addCriterion("para_value not like", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueIn(List<String> values) {
            addCriterion("para_value in", values, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueNotIn(List<String> values) {
            addCriterion("para_value not in", values, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueBetween(String value1, String value2) {
            addCriterion("para_value between", value1, value2, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueNotBetween(String value1, String value2) {
            addCriterion("para_value not between", value1, value2, "paraValue");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    /**
     * para_define
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * para_define null
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