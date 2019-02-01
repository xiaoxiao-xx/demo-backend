package com.microcore.center.model;

import java.util.ArrayList;
import java.util.List;

public class DbSubColumnExample {
    /**
     * db_sub_column
     */
    protected String orderByClause;

    /**
     * db_sub_column
     */
    protected boolean distinct;

    /**
     * db_sub_column
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbSubColumnExample() {
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
     * db_sub_column null
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

        public Criteria andPolicyIdIsNull() {
            addCriterion("policy_id is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNotNull() {
            addCriterion("policy_id is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdEqualTo(String value) {
            addCriterion("policy_id =", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotEqualTo(String value) {
            addCriterion("policy_id <>", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThan(String value) {
            addCriterion("policy_id >", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThanOrEqualTo(String value) {
            addCriterion("policy_id >=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThan(String value) {
            addCriterion("policy_id <", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThanOrEqualTo(String value) {
            addCriterion("policy_id <=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLike(String value) {
            addCriterion("policy_id like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotLike(String value) {
            addCriterion("policy_id not like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIn(List<String> values) {
            addCriterion("policy_id in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotIn(List<String> values) {
            addCriterion("policy_id not in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdBetween(String value1, String value2) {
            addCriterion("policy_id between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotBetween(String value1, String value2) {
            addCriterion("policy_id not between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameIsNull() {
            addCriterion("distill_column_name is null");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameIsNotNull() {
            addCriterion("distill_column_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameEqualTo(String value) {
            addCriterion("distill_column_name =", value, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameNotEqualTo(String value) {
            addCriterion("distill_column_name <>", value, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameGreaterThan(String value) {
            addCriterion("distill_column_name >", value, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("distill_column_name >=", value, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameLessThan(String value) {
            addCriterion("distill_column_name <", value, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameLessThanOrEqualTo(String value) {
            addCriterion("distill_column_name <=", value, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameLike(String value) {
            addCriterion("distill_column_name like", value, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameNotLike(String value) {
            addCriterion("distill_column_name not like", value, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameIn(List<String> values) {
            addCriterion("distill_column_name in", values, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameNotIn(List<String> values) {
            addCriterion("distill_column_name not in", values, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameBetween(String value1, String value2) {
            addCriterion("distill_column_name between", value1, value2, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillColumnNameNotBetween(String value1, String value2) {
            addCriterion("distill_column_name not between", value1, value2, "distillColumnName");
            return (Criteria) this;
        }

        public Criteria andDistillTypeIsNull() {
            addCriterion("distill_type is null");
            return (Criteria) this;
        }

        public Criteria andDistillTypeIsNotNull() {
            addCriterion("distill_type is not null");
            return (Criteria) this;
        }

        public Criteria andDistillTypeEqualTo(String value) {
            addCriterion("distill_type =", value, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeNotEqualTo(String value) {
            addCriterion("distill_type <>", value, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeGreaterThan(String value) {
            addCriterion("distill_type >", value, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("distill_type >=", value, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeLessThan(String value) {
            addCriterion("distill_type <", value, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeLessThanOrEqualTo(String value) {
            addCriterion("distill_type <=", value, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeLike(String value) {
            addCriterion("distill_type like", value, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeNotLike(String value) {
            addCriterion("distill_type not like", value, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeIn(List<String> values) {
            addCriterion("distill_type in", values, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeNotIn(List<String> values) {
            addCriterion("distill_type not in", values, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeBetween(String value1, String value2) {
            addCriterion("distill_type between", value1, value2, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillTypeNotBetween(String value1, String value2) {
            addCriterion("distill_type not between", value1, value2, "distillType");
            return (Criteria) this;
        }

        public Criteria andDistillCommentIsNull() {
            addCriterion("distill_comment is null");
            return (Criteria) this;
        }

        public Criteria andDistillCommentIsNotNull() {
            addCriterion("distill_comment is not null");
            return (Criteria) this;
        }

        public Criteria andDistillCommentEqualTo(String value) {
            addCriterion("distill_comment =", value, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentNotEqualTo(String value) {
            addCriterion("distill_comment <>", value, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentGreaterThan(String value) {
            addCriterion("distill_comment >", value, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentGreaterThanOrEqualTo(String value) {
            addCriterion("distill_comment >=", value, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentLessThan(String value) {
            addCriterion("distill_comment <", value, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentLessThanOrEqualTo(String value) {
            addCriterion("distill_comment <=", value, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentLike(String value) {
            addCriterion("distill_comment like", value, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentNotLike(String value) {
            addCriterion("distill_comment not like", value, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentIn(List<String> values) {
            addCriterion("distill_comment in", values, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentNotIn(List<String> values) {
            addCriterion("distill_comment not in", values, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentBetween(String value1, String value2) {
            addCriterion("distill_comment between", value1, value2, "distillComment");
            return (Criteria) this;
        }

        public Criteria andDistillCommentNotBetween(String value1, String value2) {
            addCriterion("distill_comment not between", value1, value2, "distillComment");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameIsNull() {
            addCriterion("store_column_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameIsNotNull() {
            addCriterion("store_column_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameEqualTo(String value) {
            addCriterion("store_column_name =", value, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameNotEqualTo(String value) {
            addCriterion("store_column_name <>", value, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameGreaterThan(String value) {
            addCriterion("store_column_name >", value, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_column_name >=", value, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameLessThan(String value) {
            addCriterion("store_column_name <", value, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameLessThanOrEqualTo(String value) {
            addCriterion("store_column_name <=", value, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameLike(String value) {
            addCriterion("store_column_name like", value, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameNotLike(String value) {
            addCriterion("store_column_name not like", value, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameIn(List<String> values) {
            addCriterion("store_column_name in", values, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameNotIn(List<String> values) {
            addCriterion("store_column_name not in", values, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameBetween(String value1, String value2) {
            addCriterion("store_column_name between", value1, value2, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreColumnNameNotBetween(String value1, String value2) {
            addCriterion("store_column_name not between", value1, value2, "storeColumnName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNull() {
            addCriterion("store_type is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNotNull() {
            addCriterion("store_type is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeEqualTo(String value) {
            addCriterion("store_type =", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotEqualTo(String value) {
            addCriterion("store_type <>", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThan(String value) {
            addCriterion("store_type >", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThanOrEqualTo(String value) {
            addCriterion("store_type >=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThan(String value) {
            addCriterion("store_type <", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThanOrEqualTo(String value) {
            addCriterion("store_type <=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLike(String value) {
            addCriterion("store_type like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotLike(String value) {
            addCriterion("store_type not like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIn(List<String> values) {
            addCriterion("store_type in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotIn(List<String> values) {
            addCriterion("store_type not in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeBetween(String value1, String value2) {
            addCriterion("store_type between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotBetween(String value1, String value2) {
            addCriterion("store_type not between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andTraceMakeIsNull() {
            addCriterion("trace_make is null");
            return (Criteria) this;
        }

        public Criteria andTraceMakeIsNotNull() {
            addCriterion("trace_make is not null");
            return (Criteria) this;
        }

        public Criteria andTraceMakeEqualTo(String value) {
            addCriterion("trace_make =", value, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeNotEqualTo(String value) {
            addCriterion("trace_make <>", value, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeGreaterThan(String value) {
            addCriterion("trace_make >", value, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeGreaterThanOrEqualTo(String value) {
            addCriterion("trace_make >=", value, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeLessThan(String value) {
            addCriterion("trace_make <", value, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeLessThanOrEqualTo(String value) {
            addCriterion("trace_make <=", value, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeLike(String value) {
            addCriterion("trace_make like", value, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeNotLike(String value) {
            addCriterion("trace_make not like", value, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeIn(List<String> values) {
            addCriterion("trace_make in", values, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeNotIn(List<String> values) {
            addCriterion("trace_make not in", values, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeBetween(String value1, String value2) {
            addCriterion("trace_make between", value1, value2, "traceMake");
            return (Criteria) this;
        }

        public Criteria andTraceMakeNotBetween(String value1, String value2) {
            addCriterion("trace_make not between", value1, value2, "traceMake");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIsNull() {
            addCriterion("encrypt_type is null");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIsNotNull() {
            addCriterion("encrypt_type is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeEqualTo(String value) {
            addCriterion("encrypt_type =", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeNotEqualTo(String value) {
            addCriterion("encrypt_type <>", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeGreaterThan(String value) {
            addCriterion("encrypt_type >", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("encrypt_type >=", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeLessThan(String value) {
            addCriterion("encrypt_type <", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeLessThanOrEqualTo(String value) {
            addCriterion("encrypt_type <=", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeLike(String value) {
            addCriterion("encrypt_type like", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeNotLike(String value) {
            addCriterion("encrypt_type not like", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIn(List<String> values) {
            addCriterion("encrypt_type in", values, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeNotIn(List<String> values) {
            addCriterion("encrypt_type not in", values, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeBetween(String value1, String value2) {
            addCriterion("encrypt_type between", value1, value2, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeNotBetween(String value1, String value2) {
            addCriterion("encrypt_type not between", value1, value2, "encryptType");
            return (Criteria) this;
        }

        public Criteria andStoreCommentIsNull() {
            addCriterion("store_comment is null");
            return (Criteria) this;
        }

        public Criteria andStoreCommentIsNotNull() {
            addCriterion("store_comment is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCommentEqualTo(String value) {
            addCriterion("store_comment =", value, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentNotEqualTo(String value) {
            addCriterion("store_comment <>", value, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentGreaterThan(String value) {
            addCriterion("store_comment >", value, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentGreaterThanOrEqualTo(String value) {
            addCriterion("store_comment >=", value, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentLessThan(String value) {
            addCriterion("store_comment <", value, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentLessThanOrEqualTo(String value) {
            addCriterion("store_comment <=", value, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentLike(String value) {
            addCriterion("store_comment like", value, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentNotLike(String value) {
            addCriterion("store_comment not like", value, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentIn(List<String> values) {
            addCriterion("store_comment in", values, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentNotIn(List<String> values) {
            addCriterion("store_comment not in", values, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentBetween(String value1, String value2) {
            addCriterion("store_comment between", value1, value2, "storeComment");
            return (Criteria) this;
        }

        public Criteria andStoreCommentNotBetween(String value1, String value2) {
            addCriterion("store_comment not between", value1, value2, "storeComment");
            return (Criteria) this;
        }
    }

    /**
     * db_sub_column
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_sub_column null
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