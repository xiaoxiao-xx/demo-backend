package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbSubTableExample {
    /**
     * db_sub_table
     */
    protected String orderByClause;

    /**
     * db_sub_table
     */
    protected boolean distinct;

    /**
     * db_sub_table
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbSubTableExample() {
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
     * db_sub_table null
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

        public Criteria andDistillTableNameIsNull() {
            addCriterion("distill_table_name is null");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameIsNotNull() {
            addCriterion("distill_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameEqualTo(String value) {
            addCriterion("distill_table_name =", value, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameNotEqualTo(String value) {
            addCriterion("distill_table_name <>", value, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameGreaterThan(String value) {
            addCriterion("distill_table_name >", value, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("distill_table_name >=", value, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameLessThan(String value) {
            addCriterion("distill_table_name <", value, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameLessThanOrEqualTo(String value) {
            addCriterion("distill_table_name <=", value, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameLike(String value) {
            addCriterion("distill_table_name like", value, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameNotLike(String value) {
            addCriterion("distill_table_name not like", value, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameIn(List<String> values) {
            addCriterion("distill_table_name in", values, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameNotIn(List<String> values) {
            addCriterion("distill_table_name not in", values, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameBetween(String value1, String value2) {
            addCriterion("distill_table_name between", value1, value2, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andDistillTableNameNotBetween(String value1, String value2) {
            addCriterion("distill_table_name not between", value1, value2, "distillTableName");
            return (Criteria) this;
        }

        public Criteria andPubIdIsNull() {
            addCriterion("pub_id is null");
            return (Criteria) this;
        }

        public Criteria andPubIdIsNotNull() {
            addCriterion("pub_id is not null");
            return (Criteria) this;
        }

        public Criteria andPubIdEqualTo(String value) {
            addCriterion("pub_id =", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdNotEqualTo(String value) {
            addCriterion("pub_id <>", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdGreaterThan(String value) {
            addCriterion("pub_id >", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdGreaterThanOrEqualTo(String value) {
            addCriterion("pub_id >=", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdLessThan(String value) {
            addCriterion("pub_id <", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdLessThanOrEqualTo(String value) {
            addCriterion("pub_id <=", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdLike(String value) {
            addCriterion("pub_id like", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdNotLike(String value) {
            addCriterion("pub_id not like", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdIn(List<String> values) {
            addCriterion("pub_id in", values, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdNotIn(List<String> values) {
            addCriterion("pub_id not in", values, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdBetween(String value1, String value2) {
            addCriterion("pub_id between", value1, value2, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdNotBetween(String value1, String value2) {
            addCriterion("pub_id not between", value1, value2, "pubId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andConnIdIsNull() {
            addCriterion("conn_id is null");
            return (Criteria) this;
        }

        public Criteria andConnIdIsNotNull() {
            addCriterion("conn_id is not null");
            return (Criteria) this;
        }

        public Criteria andConnIdEqualTo(String value) {
            addCriterion("conn_id =", value, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdNotEqualTo(String value) {
            addCriterion("conn_id <>", value, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdGreaterThan(String value) {
            addCriterion("conn_id >", value, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdGreaterThanOrEqualTo(String value) {
            addCriterion("conn_id >=", value, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdLessThan(String value) {
            addCriterion("conn_id <", value, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdLessThanOrEqualTo(String value) {
            addCriterion("conn_id <=", value, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdLike(String value) {
            addCriterion("conn_id like", value, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdNotLike(String value) {
            addCriterion("conn_id not like", value, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdIn(List<String> values) {
            addCriterion("conn_id in", values, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdNotIn(List<String> values) {
            addCriterion("conn_id not in", values, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdBetween(String value1, String value2) {
            addCriterion("conn_id between", value1, value2, "connId");
            return (Criteria) this;
        }

        public Criteria andConnIdNotBetween(String value1, String value2) {
            addCriterion("conn_id not between", value1, value2, "connId");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameIsNull() {
            addCriterion("store_table_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameIsNotNull() {
            addCriterion("store_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameEqualTo(String value) {
            addCriterion("store_table_name =", value, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameNotEqualTo(String value) {
            addCriterion("store_table_name <>", value, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameGreaterThan(String value) {
            addCriterion("store_table_name >", value, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_table_name >=", value, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameLessThan(String value) {
            addCriterion("store_table_name <", value, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameLessThanOrEqualTo(String value) {
            addCriterion("store_table_name <=", value, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameLike(String value) {
            addCriterion("store_table_name like", value, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameNotLike(String value) {
            addCriterion("store_table_name not like", value, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameIn(List<String> values) {
            addCriterion("store_table_name in", values, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameNotIn(List<String> values) {
            addCriterion("store_table_name not in", values, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameBetween(String value1, String value2) {
            addCriterion("store_table_name between", value1, value2, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andStoreTableNameNotBetween(String value1, String value2) {
            addCriterion("store_table_name not between", value1, value2, "storeTableName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskDescIsNull() {
            addCriterion("task_desc is null");
            return (Criteria) this;
        }

        public Criteria andTaskDescIsNotNull() {
            addCriterion("task_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDescEqualTo(String value) {
            addCriterion("task_desc =", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotEqualTo(String value) {
            addCriterion("task_desc <>", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescGreaterThan(String value) {
            addCriterion("task_desc >", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescGreaterThanOrEqualTo(String value) {
            addCriterion("task_desc >=", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescLessThan(String value) {
            addCriterion("task_desc <", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescLessThanOrEqualTo(String value) {
            addCriterion("task_desc <=", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescLike(String value) {
            addCriterion("task_desc like", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotLike(String value) {
            addCriterion("task_desc not like", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescIn(List<String> values) {
            addCriterion("task_desc in", values, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotIn(List<String> values) {
            addCriterion("task_desc not in", values, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescBetween(String value1, String value2) {
            addCriterion("task_desc between", value1, value2, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotBetween(String value1, String value2) {
            addCriterion("task_desc not between", value1, value2, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andSubUserIdIsNull() {
            addCriterion("sub_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSubUserIdIsNotNull() {
            addCriterion("sub_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubUserIdEqualTo(String value) {
            addCriterion("sub_user_id =", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdNotEqualTo(String value) {
            addCriterion("sub_user_id <>", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdGreaterThan(String value) {
            addCriterion("sub_user_id >", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_user_id >=", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdLessThan(String value) {
            addCriterion("sub_user_id <", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdLessThanOrEqualTo(String value) {
            addCriterion("sub_user_id <=", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdLike(String value) {
            addCriterion("sub_user_id like", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdNotLike(String value) {
            addCriterion("sub_user_id not like", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdIn(List<String> values) {
            addCriterion("sub_user_id in", values, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdNotIn(List<String> values) {
            addCriterion("sub_user_id not in", values, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdBetween(String value1, String value2) {
            addCriterion("sub_user_id between", value1, value2, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdNotBetween(String value1, String value2) {
            addCriterion("sub_user_id not between", value1, value2, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdIsNull() {
            addCriterion("sub_org_id is null");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdIsNotNull() {
            addCriterion("sub_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdEqualTo(String value) {
            addCriterion("sub_org_id =", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdNotEqualTo(String value) {
            addCriterion("sub_org_id <>", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdGreaterThan(String value) {
            addCriterion("sub_org_id >", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_org_id >=", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdLessThan(String value) {
            addCriterion("sub_org_id <", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdLessThanOrEqualTo(String value) {
            addCriterion("sub_org_id <=", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdLike(String value) {
            addCriterion("sub_org_id like", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdNotLike(String value) {
            addCriterion("sub_org_id not like", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdIn(List<String> values) {
            addCriterion("sub_org_id in", values, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdNotIn(List<String> values) {
            addCriterion("sub_org_id not in", values, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdBetween(String value1, String value2) {
            addCriterion("sub_org_id between", value1, value2, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdNotBetween(String value1, String value2) {
            addCriterion("sub_org_id not between", value1, value2, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdIsNull() {
            addCriterion("pub_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPubUserIdIsNotNull() {
            addCriterion("pub_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPubUserIdEqualTo(String value) {
            addCriterion("pub_user_id =", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdNotEqualTo(String value) {
            addCriterion("pub_user_id <>", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdGreaterThan(String value) {
            addCriterion("pub_user_id >", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("pub_user_id >=", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdLessThan(String value) {
            addCriterion("pub_user_id <", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdLessThanOrEqualTo(String value) {
            addCriterion("pub_user_id <=", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdLike(String value) {
            addCriterion("pub_user_id like", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdNotLike(String value) {
            addCriterion("pub_user_id not like", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdIn(List<String> values) {
            addCriterion("pub_user_id in", values, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdNotIn(List<String> values) {
            addCriterion("pub_user_id not in", values, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdBetween(String value1, String value2) {
            addCriterion("pub_user_id between", value1, value2, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdNotBetween(String value1, String value2) {
            addCriterion("pub_user_id not between", value1, value2, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdIsNull() {
            addCriterion("pub_org_id is null");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdIsNotNull() {
            addCriterion("pub_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdEqualTo(String value) {
            addCriterion("pub_org_id =", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdNotEqualTo(String value) {
            addCriterion("pub_org_id <>", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdGreaterThan(String value) {
            addCriterion("pub_org_id >", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("pub_org_id >=", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdLessThan(String value) {
            addCriterion("pub_org_id <", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdLessThanOrEqualTo(String value) {
            addCriterion("pub_org_id <=", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdLike(String value) {
            addCriterion("pub_org_id like", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdNotLike(String value) {
            addCriterion("pub_org_id not like", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdIn(List<String> values) {
            addCriterion("pub_org_id in", values, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdNotIn(List<String> values) {
            addCriterion("pub_org_id not in", values, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdBetween(String value1, String value2) {
            addCriterion("pub_org_id between", value1, value2, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdNotBetween(String value1, String value2) {
            addCriterion("pub_org_id not between", value1, value2, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNull() {
            addCriterion("pub_time is null");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNotNull() {
            addCriterion("pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andPubTimeEqualTo(Date value) {
            addCriterion("pub_time =", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotEqualTo(Date value) {
            addCriterion("pub_time <>", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThan(Date value) {
            addCriterion("pub_time >", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pub_time >=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThan(Date value) {
            addCriterion("pub_time <", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThanOrEqualTo(Date value) {
            addCriterion("pub_time <=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeIn(List<Date> values) {
            addCriterion("pub_time in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotIn(List<Date> values) {
            addCriterion("pub_time not in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeBetween(Date value1, Date value2) {
            addCriterion("pub_time between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotBetween(Date value1, Date value2) {
            addCriterion("pub_time not between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubStatusIsNull() {
            addCriterion("pub_status is null");
            return (Criteria) this;
        }

        public Criteria andPubStatusIsNotNull() {
            addCriterion("pub_status is not null");
            return (Criteria) this;
        }

        public Criteria andPubStatusEqualTo(String value) {
            addCriterion("pub_status =", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusNotEqualTo(String value) {
            addCriterion("pub_status <>", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusGreaterThan(String value) {
            addCriterion("pub_status >", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pub_status >=", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusLessThan(String value) {
            addCriterion("pub_status <", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusLessThanOrEqualTo(String value) {
            addCriterion("pub_status <=", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusLike(String value) {
            addCriterion("pub_status like", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusNotLike(String value) {
            addCriterion("pub_status not like", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusIn(List<String> values) {
            addCriterion("pub_status in", values, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusNotIn(List<String> values) {
            addCriterion("pub_status not in", values, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusBetween(String value1, String value2) {
            addCriterion("pub_status between", value1, value2, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusNotBetween(String value1, String value2) {
            addCriterion("pub_status not between", value1, value2, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDelStatusIsNull() {
            addCriterion("del_status is null");
            return (Criteria) this;
        }

        public Criteria andDelStatusIsNotNull() {
            addCriterion("del_status is not null");
            return (Criteria) this;
        }

        public Criteria andDelStatusEqualTo(String value) {
            addCriterion("del_status =", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotEqualTo(String value) {
            addCriterion("del_status <>", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusGreaterThan(String value) {
            addCriterion("del_status >", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusGreaterThanOrEqualTo(String value) {
            addCriterion("del_status >=", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusLessThan(String value) {
            addCriterion("del_status <", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusLessThanOrEqualTo(String value) {
            addCriterion("del_status <=", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusLike(String value) {
            addCriterion("del_status like", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotLike(String value) {
            addCriterion("del_status not like", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusIn(List<String> values) {
            addCriterion("del_status in", values, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotIn(List<String> values) {
            addCriterion("del_status not in", values, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusBetween(String value1, String value2) {
            addCriterion("del_status between", value1, value2, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotBetween(String value1, String value2) {
            addCriterion("del_status not between", value1, value2, "delStatus");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNull() {
            addCriterion("upd_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNotNull() {
            addCriterion("upd_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdEqualTo(String value) {
            addCriterion("upd_user_id =", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotEqualTo(String value) {
            addCriterion("upd_user_id <>", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThan(String value) {
            addCriterion("upd_user_id >", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("upd_user_id >=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThan(String value) {
            addCriterion("upd_user_id <", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThanOrEqualTo(String value) {
            addCriterion("upd_user_id <=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLike(String value) {
            addCriterion("upd_user_id like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotLike(String value) {
            addCriterion("upd_user_id not like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIn(List<String> values) {
            addCriterion("upd_user_id in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotIn(List<String> values) {
            addCriterion("upd_user_id not in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdBetween(String value1, String value2) {
            addCriterion("upd_user_id between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotBetween(String value1, String value2) {
            addCriterion("upd_user_id not between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdIsNull() {
            addCriterion("upd_org_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdIsNotNull() {
            addCriterion("upd_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdEqualTo(String value) {
            addCriterion("upd_org_id =", value, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdNotEqualTo(String value) {
            addCriterion("upd_org_id <>", value, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdGreaterThan(String value) {
            addCriterion("upd_org_id >", value, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("upd_org_id >=", value, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdLessThan(String value) {
            addCriterion("upd_org_id <", value, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdLessThanOrEqualTo(String value) {
            addCriterion("upd_org_id <=", value, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdLike(String value) {
            addCriterion("upd_org_id like", value, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdNotLike(String value) {
            addCriterion("upd_org_id not like", value, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdIn(List<String> values) {
            addCriterion("upd_org_id in", values, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdNotIn(List<String> values) {
            addCriterion("upd_org_id not in", values, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdBetween(String value1, String value2) {
            addCriterion("upd_org_id between", value1, value2, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdOrgIdNotBetween(String value1, String value2) {
            addCriterion("upd_org_id not between", value1, value2, "updOrgId");
            return (Criteria) this;
        }

        public Criteria andUpdTmIsNull() {
            addCriterion("upd_tm is null");
            return (Criteria) this;
        }

        public Criteria andUpdTmIsNotNull() {
            addCriterion("upd_tm is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTmEqualTo(Date value) {
            addCriterion("upd_tm =", value, "updTm");
            return (Criteria) this;
        }

        public Criteria andUpdTmNotEqualTo(Date value) {
            addCriterion("upd_tm <>", value, "updTm");
            return (Criteria) this;
        }

        public Criteria andUpdTmGreaterThan(Date value) {
            addCriterion("upd_tm >", value, "updTm");
            return (Criteria) this;
        }

        public Criteria andUpdTmGreaterThanOrEqualTo(Date value) {
            addCriterion("upd_tm >=", value, "updTm");
            return (Criteria) this;
        }

        public Criteria andUpdTmLessThan(Date value) {
            addCriterion("upd_tm <", value, "updTm");
            return (Criteria) this;
        }

        public Criteria andUpdTmLessThanOrEqualTo(Date value) {
            addCriterion("upd_tm <=", value, "updTm");
            return (Criteria) this;
        }

        public Criteria andUpdTmIn(List<Date> values) {
            addCriterion("upd_tm in", values, "updTm");
            return (Criteria) this;
        }

        public Criteria andUpdTmNotIn(List<Date> values) {
            addCriterion("upd_tm not in", values, "updTm");
            return (Criteria) this;
        }

        public Criteria andUpdTmBetween(Date value1, Date value2) {
            addCriterion("upd_tm between", value1, value2, "updTm");
            return (Criteria) this;
        }

        public Criteria andUpdTmNotBetween(Date value1, Date value2) {
            addCriterion("upd_tm not between", value1, value2, "updTm");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdIsNull() {
            addCriterion("crt_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdIsNotNull() {
            addCriterion("crt_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdEqualTo(String value) {
            addCriterion("crt_user_id =", value, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdNotEqualTo(String value) {
            addCriterion("crt_user_id <>", value, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdGreaterThan(String value) {
            addCriterion("crt_user_id >", value, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("crt_user_id >=", value, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdLessThan(String value) {
            addCriterion("crt_user_id <", value, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdLessThanOrEqualTo(String value) {
            addCriterion("crt_user_id <=", value, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdLike(String value) {
            addCriterion("crt_user_id like", value, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdNotLike(String value) {
            addCriterion("crt_user_id not like", value, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdIn(List<String> values) {
            addCriterion("crt_user_id in", values, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdNotIn(List<String> values) {
            addCriterion("crt_user_id not in", values, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdBetween(String value1, String value2) {
            addCriterion("crt_user_id between", value1, value2, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtUserIdNotBetween(String value1, String value2) {
            addCriterion("crt_user_id not between", value1, value2, "crtUserId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdIsNull() {
            addCriterion("crt_org_id is null");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdIsNotNull() {
            addCriterion("crt_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdEqualTo(String value) {
            addCriterion("crt_org_id =", value, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdNotEqualTo(String value) {
            addCriterion("crt_org_id <>", value, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdGreaterThan(String value) {
            addCriterion("crt_org_id >", value, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("crt_org_id >=", value, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdLessThan(String value) {
            addCriterion("crt_org_id <", value, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdLessThanOrEqualTo(String value) {
            addCriterion("crt_org_id <=", value, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdLike(String value) {
            addCriterion("crt_org_id like", value, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdNotLike(String value) {
            addCriterion("crt_org_id not like", value, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdIn(List<String> values) {
            addCriterion("crt_org_id in", values, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdNotIn(List<String> values) {
            addCriterion("crt_org_id not in", values, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdBetween(String value1, String value2) {
            addCriterion("crt_org_id between", value1, value2, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtOrgIdNotBetween(String value1, String value2) {
            addCriterion("crt_org_id not between", value1, value2, "crtOrgId");
            return (Criteria) this;
        }

        public Criteria andCrtTmIsNull() {
            addCriterion("crt_tm is null");
            return (Criteria) this;
        }

        public Criteria andCrtTmIsNotNull() {
            addCriterion("crt_tm is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTmEqualTo(Date value) {
            addCriterion("crt_tm =", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmNotEqualTo(Date value) {
            addCriterion("crt_tm <>", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmGreaterThan(Date value) {
            addCriterion("crt_tm >", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmGreaterThanOrEqualTo(Date value) {
            addCriterion("crt_tm >=", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmLessThan(Date value) {
            addCriterion("crt_tm <", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmLessThanOrEqualTo(Date value) {
            addCriterion("crt_tm <=", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmIn(List<Date> values) {
            addCriterion("crt_tm in", values, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmNotIn(List<Date> values) {
            addCriterion("crt_tm not in", values, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmBetween(Date value1, Date value2) {
            addCriterion("crt_tm between", value1, value2, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmNotBetween(Date value1, Date value2) {
            addCriterion("crt_tm not between", value1, value2, "crtTm");
            return (Criteria) this;
        }
    }

    /**
     * db_sub_table
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_sub_table null
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