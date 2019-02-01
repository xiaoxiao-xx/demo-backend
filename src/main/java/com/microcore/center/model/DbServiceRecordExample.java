package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbServiceRecordExample {
    /**
     * db_service_record
     */
    protected String orderByClause;

    /**
     * db_service_record
     */
    protected boolean distinct;

    /**
     * db_service_record
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbServiceRecordExample() {
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
     * db_service_record null
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

        public Criteria andSubIdIsNull() {
            addCriterion("sub_id is null");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNotNull() {
            addCriterion("sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubIdEqualTo(String value) {
            addCriterion("sub_id =", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotEqualTo(String value) {
            addCriterion("sub_id <>", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThan(String value) {
            addCriterion("sub_id >", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_id >=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThan(String value) {
            addCriterion("sub_id <", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThanOrEqualTo(String value) {
            addCriterion("sub_id <=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLike(String value) {
            addCriterion("sub_id like", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotLike(String value) {
            addCriterion("sub_id not like", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdIn(List<String> values) {
            addCriterion("sub_id in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotIn(List<String> values) {
            addCriterion("sub_id not in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdBetween(String value1, String value2) {
            addCriterion("sub_id between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotBetween(String value1, String value2) {
            addCriterion("sub_id not between", value1, value2, "subId");
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

        public Criteria andInvokeDateIsNull() {
            addCriterion("invoke_date is null");
            return (Criteria) this;
        }

        public Criteria andInvokeDateIsNotNull() {
            addCriterion("invoke_date is not null");
            return (Criteria) this;
        }

        public Criteria andInvokeDateEqualTo(Date value) {
            addCriterion("invoke_date =", value, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andInvokeDateNotEqualTo(Date value) {
            addCriterion("invoke_date <>", value, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andInvokeDateGreaterThan(Date value) {
            addCriterion("invoke_date >", value, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andInvokeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("invoke_date >=", value, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andInvokeDateLessThan(Date value) {
            addCriterion("invoke_date <", value, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andInvokeDateLessThanOrEqualTo(Date value) {
            addCriterion("invoke_date <=", value, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andInvokeDateIn(List<Date> values) {
            addCriterion("invoke_date in", values, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andInvokeDateNotIn(List<Date> values) {
            addCriterion("invoke_date not in", values, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andInvokeDateBetween(Date value1, Date value2) {
            addCriterion("invoke_date between", value1, value2, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andInvokeDateNotBetween(Date value1, Date value2) {
            addCriterion("invoke_date not between", value1, value2, "invokeDate");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(String value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(String value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(String value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(String value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(String value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(String value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLike(String value) {
            addCriterion("month like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotLike(String value) {
            addCriterion("month not like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<String> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<String> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(String value1, String value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(String value1, String value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andProxyTimeIsNull() {
            addCriterion("proxy_time is null");
            return (Criteria) this;
        }

        public Criteria andProxyTimeIsNotNull() {
            addCriterion("proxy_time is not null");
            return (Criteria) this;
        }

        public Criteria andProxyTimeEqualTo(Long value) {
            addCriterion("proxy_time =", value, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andProxyTimeNotEqualTo(Long value) {
            addCriterion("proxy_time <>", value, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andProxyTimeGreaterThan(Long value) {
            addCriterion("proxy_time >", value, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andProxyTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("proxy_time >=", value, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andProxyTimeLessThan(Long value) {
            addCriterion("proxy_time <", value, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andProxyTimeLessThanOrEqualTo(Long value) {
            addCriterion("proxy_time <=", value, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andProxyTimeIn(List<Long> values) {
            addCriterion("proxy_time in", values, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andProxyTimeNotIn(List<Long> values) {
            addCriterion("proxy_time not in", values, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andProxyTimeBetween(Long value1, Long value2) {
            addCriterion("proxy_time between", value1, value2, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andProxyTimeNotBetween(Long value1, Long value2) {
            addCriterion("proxy_time not between", value1, value2, "proxyTime");
            return (Criteria) this;
        }

        public Criteria andDataVolumeIsNull() {
            addCriterion("data_volume is null");
            return (Criteria) this;
        }

        public Criteria andDataVolumeIsNotNull() {
            addCriterion("data_volume is not null");
            return (Criteria) this;
        }

        public Criteria andDataVolumeEqualTo(Long value) {
            addCriterion("data_volume =", value, "dataVolume");
            return (Criteria) this;
        }

        public Criteria andDataVolumeNotEqualTo(Long value) {
            addCriterion("data_volume <>", value, "dataVolume");
            return (Criteria) this;
        }

        public Criteria andDataVolumeGreaterThan(Long value) {
            addCriterion("data_volume >", value, "dataVolume");
            return (Criteria) this;
        }

        public Criteria andDataVolumeGreaterThanOrEqualTo(Long value) {
            addCriterion("data_volume >=", value, "dataVolume");
            return (Criteria) this;
        }

        public Criteria andDataVolumeLessThan(Long value) {
            addCriterion("data_volume <", value, "dataVolume");
            return (Criteria) this;
        }

        public Criteria andDataVolumeLessThanOrEqualTo(Long value) {
            addCriterion("data_volume <=", value, "dataVolume");
            return (Criteria) this;
        }

        public Criteria andDataVolumeIn(List<Long> values) {
            addCriterion("data_volume in", values, "dataVolume");
            return (Criteria) this;
        }

        public Criteria andDataVolumeNotIn(List<Long> values) {
            addCriterion("data_volume not in", values, "dataVolume");
            return (Criteria) this;
        }

        public Criteria andDataVolumeBetween(Long value1, Long value2) {
            addCriterion("data_volume between", value1, value2, "dataVolume");
            return (Criteria) this;
        }

        public Criteria andDataVolumeNotBetween(Long value1, Long value2) {
            addCriterion("data_volume not between", value1, value2, "dataVolume");
            return (Criteria) this;
        }
    }

    /**
     * db_service_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_service_record null
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