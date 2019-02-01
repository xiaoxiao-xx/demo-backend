package com.microcore.center.model;

import java.util.ArrayList;
import java.util.List;

public class DbPolicyEncryptExample {
    /**
     * db_policy_encrypt
     */
    protected String orderByClause;

    /**
     * db_policy_encrypt
     */
    protected boolean distinct;

    /**
     * db_policy_encrypt
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbPolicyEncryptExample() {
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
     * db_policy_encrypt null
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

        public Criteria andSecurityLevelIsNull() {
            addCriterion("security_level is null");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelIsNotNull() {
            addCriterion("security_level is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelEqualTo(String value) {
            addCriterion("security_level =", value, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelNotEqualTo(String value) {
            addCriterion("security_level <>", value, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelGreaterThan(String value) {
            addCriterion("security_level >", value, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("security_level >=", value, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelLessThan(String value) {
            addCriterion("security_level <", value, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelLessThanOrEqualTo(String value) {
            addCriterion("security_level <=", value, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelLike(String value) {
            addCriterion("security_level like", value, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelNotLike(String value) {
            addCriterion("security_level not like", value, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelIn(List<String> values) {
            addCriterion("security_level in", values, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelNotIn(List<String> values) {
            addCriterion("security_level not in", values, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelBetween(String value1, String value2) {
            addCriterion("security_level between", value1, value2, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andSecurityLevelNotBetween(String value1, String value2) {
            addCriterion("security_level not between", value1, value2, "securityLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdIsNull() {
            addCriterion("encrypt_type_id is null");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdIsNotNull() {
            addCriterion("encrypt_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdEqualTo(String value) {
            addCriterion("encrypt_type_id =", value, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdNotEqualTo(String value) {
            addCriterion("encrypt_type_id <>", value, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdGreaterThan(String value) {
            addCriterion("encrypt_type_id >", value, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("encrypt_type_id >=", value, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdLessThan(String value) {
            addCriterion("encrypt_type_id <", value, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdLessThanOrEqualTo(String value) {
            addCriterion("encrypt_type_id <=", value, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdLike(String value) {
            addCriterion("encrypt_type_id like", value, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdNotLike(String value) {
            addCriterion("encrypt_type_id not like", value, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdIn(List<String> values) {
            addCriterion("encrypt_type_id in", values, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdNotIn(List<String> values) {
            addCriterion("encrypt_type_id not in", values, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdBetween(String value1, String value2) {
            addCriterion("encrypt_type_id between", value1, value2, "encryptTypeId");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIdNotBetween(String value1, String value2) {
            addCriterion("encrypt_type_id not between", value1, value2, "encryptTypeId");
            return (Criteria) this;
        }
    }

    /**
     * db_policy_encrypt
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_policy_encrypt null
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