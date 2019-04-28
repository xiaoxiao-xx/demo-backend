package com.rainyhon.common.model;

import java.util.ArrayList;
import java.util.List;

public class DynamicQueryUnaryRelationExample {
    /**
     * dynamic_query_unary_relation
     */
    protected String orderByClause;

    /**
     * dynamic_query_unary_relation
     */
    protected boolean distinct;

    /**
     * dynamic_query_unary_relation
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DynamicQueryUnaryRelationExample() {
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
     * dynamic_query_unary_relation null
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

        public Criteria andUnaryIdIsNull() {
            addCriterion("unary_id is null");
            return (Criteria) this;
        }

        public Criteria andUnaryIdIsNotNull() {
            addCriterion("unary_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnaryIdEqualTo(String value) {
            addCriterion("unary_id =", value, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdNotEqualTo(String value) {
            addCriterion("unary_id <>", value, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdGreaterThan(String value) {
            addCriterion("unary_id >", value, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("unary_id >=", value, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdLessThan(String value) {
            addCriterion("unary_id <", value, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdLessThanOrEqualTo(String value) {
            addCriterion("unary_id <=", value, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdLike(String value) {
            addCriterion("unary_id like", value, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdNotLike(String value) {
            addCriterion("unary_id not like", value, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdIn(List<String> values) {
            addCriterion("unary_id in", values, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdNotIn(List<String> values) {
            addCriterion("unary_id not in", values, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdBetween(String value1, String value2) {
            addCriterion("unary_id between", value1, value2, "unaryId");
            return (Criteria) this;
        }

        public Criteria andUnaryIdNotBetween(String value1, String value2) {
            addCriterion("unary_id not between", value1, value2, "unaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdIsNull() {
            addCriterion("aft_unary_id is null");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdIsNotNull() {
            addCriterion("aft_unary_id is not null");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdEqualTo(String value) {
            addCriterion("aft_unary_id =", value, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdNotEqualTo(String value) {
            addCriterion("aft_unary_id <>", value, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdGreaterThan(String value) {
            addCriterion("aft_unary_id >", value, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("aft_unary_id >=", value, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdLessThan(String value) {
            addCriterion("aft_unary_id <", value, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdLessThanOrEqualTo(String value) {
            addCriterion("aft_unary_id <=", value, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdLike(String value) {
            addCriterion("aft_unary_id like", value, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdNotLike(String value) {
            addCriterion("aft_unary_id not like", value, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdIn(List<String> values) {
            addCriterion("aft_unary_id in", values, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdNotIn(List<String> values) {
            addCriterion("aft_unary_id not in", values, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdBetween(String value1, String value2) {
            addCriterion("aft_unary_id between", value1, value2, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andAftUnaryIdNotBetween(String value1, String value2) {
            addCriterion("aft_unary_id not between", value1, value2, "preUnaryId");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("relation is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("relation is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(String value) {
            addCriterion("relation =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(String value) {
            addCriterion("relation <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(String value) {
            addCriterion("relation >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(String value) {
            addCriterion("relation >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(String value) {
            addCriterion("relation <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(String value) {
            addCriterion("relation <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLike(String value) {
            addCriterion("relation like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotLike(String value) {
            addCriterion("relation not like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<String> values) {
            addCriterion("relation in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<String> values) {
            addCriterion("relation not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(String value1, String value2) {
            addCriterion("relation between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(String value1, String value2) {
            addCriterion("relation not between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andOrderIsNull() {
            addCriterion("order is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsNotNull() {
            addCriterion("order is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEqualTo(Integer value) {
            addCriterion("order =", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotEqualTo(Integer value) {
            addCriterion("order <>", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThan(Integer value) {
            addCriterion("order >", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("order >=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThan(Integer value) {
            addCriterion("order <", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThanOrEqualTo(Integer value) {
            addCriterion("order <=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderIn(List<Integer> values) {
            addCriterion("order in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotIn(List<Integer> values) {
            addCriterion("order not in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderBetween(Integer value1, Integer value2) {
            addCriterion("order between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("order not between", value1, value2, "order");
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
    }

    /**
     * dynamic_query_unary_relation
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * dynamic_query_unary_relation null
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