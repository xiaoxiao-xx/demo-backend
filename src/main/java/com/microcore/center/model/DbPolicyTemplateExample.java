package com.microcore.center.model;

import java.util.ArrayList;
import java.util.List;

public class DbPolicyTemplateExample {
    /**
     * db_policy_template
     */
    protected String orderByClause;

    /**
     * db_policy_template
     */
    protected boolean distinct;

    /**
     * db_policy_template
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbPolicyTemplateExample() {
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
     * db_policy_template null
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

        public Criteria andPolicyItemIdIsNull() {
            addCriterion("policy_item_id is null");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdIsNotNull() {
            addCriterion("policy_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdEqualTo(String value) {
            addCriterion("policy_item_id =", value, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdNotEqualTo(String value) {
            addCriterion("policy_item_id <>", value, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdGreaterThan(String value) {
            addCriterion("policy_item_id >", value, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("policy_item_id >=", value, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdLessThan(String value) {
            addCriterion("policy_item_id <", value, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdLessThanOrEqualTo(String value) {
            addCriterion("policy_item_id <=", value, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdLike(String value) {
            addCriterion("policy_item_id like", value, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdNotLike(String value) {
            addCriterion("policy_item_id not like", value, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdIn(List<String> values) {
            addCriterion("policy_item_id in", values, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdNotIn(List<String> values) {
            addCriterion("policy_item_id not in", values, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdBetween(String value1, String value2) {
            addCriterion("policy_item_id between", value1, value2, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andPolicyItemIdNotBetween(String value1, String value2) {
            addCriterion("policy_item_id not between", value1, value2, "policyItemId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdIsNull() {
            addCriterion("ext_template_id is null");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdIsNotNull() {
            addCriterion("ext_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdEqualTo(String value) {
            addCriterion("ext_template_id =", value, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdNotEqualTo(String value) {
            addCriterion("ext_template_id <>", value, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdGreaterThan(String value) {
            addCriterion("ext_template_id >", value, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("ext_template_id >=", value, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdLessThan(String value) {
            addCriterion("ext_template_id <", value, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("ext_template_id <=", value, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdLike(String value) {
            addCriterion("ext_template_id like", value, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdNotLike(String value) {
            addCriterion("ext_template_id not like", value, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdIn(List<String> values) {
            addCriterion("ext_template_id in", values, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdNotIn(List<String> values) {
            addCriterion("ext_template_id not in", values, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdBetween(String value1, String value2) {
            addCriterion("ext_template_id between", value1, value2, "extTemplateId");
            return (Criteria) this;
        }

        public Criteria andExtTemplateIdNotBetween(String value1, String value2) {
            addCriterion("ext_template_id not between", value1, value2, "extTemplateId");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberIsNull() {
		    addCriterion("sequence_number is null");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberIsNotNull() {
		    addCriterion("sequence_number is not null");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberEqualTo(Integer value) {
		    addCriterion("sequence_number =", value, "sequenceNumber");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberNotEqualTo(Integer value) {
		    addCriterion("sequence_number <>", value, "sequenceNumber");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberGreaterThan(Integer value) {
		    addCriterion("sequence_number >", value, "sequenceNumber");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberGreaterThanOrEqualTo(Integer value) {
		    addCriterion("sequence_number >=", value, "sequenceNumber");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberLessThan(Integer value) {
		    addCriterion("sequence_number <", value, "sequenceNumber");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberLessThanOrEqualTo(Integer value) {
		    addCriterion("sequence_number <=", value, "sequenceNumber");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberIn(List<Integer> values) {
		    addCriterion("sequence_number in", values, "sequenceNumber");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberNotIn(List<Integer> values) {
		    addCriterion("sequence_number not in", values, "sequenceNumber");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberBetween(Integer value1, Integer value2) {
		    addCriterion("sequence_number between", value1, value2, "sequenceNumber");
            return (Criteria) this;
        }

	    public Criteria andSequenceNumberNotBetween(Integer value1, Integer value2) {
		    addCriterion("sequence_number not between", value1, value2, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNull() {
            addCriterion("required is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("required is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(String value) {
            addCriterion("required =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(String value) {
            addCriterion("required <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(String value) {
            addCriterion("required >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(String value) {
            addCriterion("required >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(String value) {
            addCriterion("required <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(String value) {
            addCriterion("required <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLike(String value) {
            addCriterion("required like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotLike(String value) {
            addCriterion("required not like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<String> values) {
            addCriterion("required in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<String> values) {
            addCriterion("required not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(String value1, String value2) {
            addCriterion("required between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(String value1, String value2) {
            addCriterion("required not between", value1, value2, "required");
            return (Criteria) this;
        }
    }

    /**
     * db_policy_template
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_policy_template null
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