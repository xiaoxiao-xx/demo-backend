package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DbPubTsColumnExample {
    /**
     * db_pub_ts_column
     */
    protected String orderByClause;

    /**
     * db_pub_ts_column
     */
    protected boolean distinct;

    /**
     * db_pub_ts_column
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbPubTsColumnExample() {
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
     * db_pub_ts_column null
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andColumnNameIsNull() {
            addCriterion("column_name is null");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNotNull() {
            addCriterion("column_name is not null");
            return (Criteria) this;
        }

        public Criteria andColumnNameEqualTo(String value) {
            addCriterion("column_name =", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotEqualTo(String value) {
            addCriterion("column_name <>", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThan(String value) {
            addCriterion("column_name >", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("column_name >=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThan(String value) {
            addCriterion("column_name <", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThanOrEqualTo(String value) {
            addCriterion("column_name <=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLike(String value) {
            addCriterion("column_name like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotLike(String value) {
            addCriterion("column_name not like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameIn(List<String> values) {
            addCriterion("column_name in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotIn(List<String> values) {
            addCriterion("column_name not in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameBetween(String value1, String value2) {
            addCriterion("column_name between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotBetween(String value1, String value2) {
            addCriterion("column_name not between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNull() {
            addCriterion("column_type is null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNotNull() {
            addCriterion("column_type is not null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeEqualTo(String value) {
            addCriterion("column_type =", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotEqualTo(String value) {
            addCriterion("column_type <>", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThan(String value) {
            addCriterion("column_type >", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("column_type >=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThan(String value) {
            addCriterion("column_type <", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThanOrEqualTo(String value) {
            addCriterion("column_type <=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLike(String value) {
            addCriterion("column_type like", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotLike(String value) {
            addCriterion("column_type not like", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIn(List<String> values) {
            addCriterion("column_type in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotIn(List<String> values) {
            addCriterion("column_type not in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeBetween(String value1, String value2) {
            addCriterion("column_type between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotBetween(String value1, String value2) {
            addCriterion("column_type not between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnCommentIsNull() {
            addCriterion("column_comment is null");
            return (Criteria) this;
        }

        public Criteria andColumnCommentIsNotNull() {
            addCriterion("column_comment is not null");
            return (Criteria) this;
        }

        public Criteria andColumnCommentEqualTo(String value) {
            addCriterion("column_comment =", value, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentNotEqualTo(String value) {
            addCriterion("column_comment <>", value, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentGreaterThan(String value) {
            addCriterion("column_comment >", value, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentGreaterThanOrEqualTo(String value) {
            addCriterion("column_comment >=", value, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentLessThan(String value) {
            addCriterion("column_comment <", value, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentLessThanOrEqualTo(String value) {
            addCriterion("column_comment <=", value, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentLike(String value) {
            addCriterion("column_comment like", value, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentNotLike(String value) {
            addCriterion("column_comment not like", value, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentIn(List<String> values) {
            addCriterion("column_comment in", values, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentNotIn(List<String> values) {
            addCriterion("column_comment not in", values, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentBetween(String value1, String value2) {
            addCriterion("column_comment between", value1, value2, "columnComment");
            return (Criteria) this;
        }

        public Criteria andColumnCommentNotBetween(String value1, String value2) {
            addCriterion("column_comment not between", value1, value2, "columnComment");
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

        public Criteria andAuthTypeIsNull() {
            addCriterion("auth_type is null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNotNull() {
            addCriterion("auth_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeEqualTo(String value) {
            addCriterion("auth_type =", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotEqualTo(String value) {
            addCriterion("auth_type <>", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThan(String value) {
            addCriterion("auth_type >", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThanOrEqualTo(String value) {
            addCriterion("auth_type >=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThan(String value) {
            addCriterion("auth_type <", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThanOrEqualTo(String value) {
            addCriterion("auth_type <=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLike(String value) {
            addCriterion("auth_type like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotLike(String value) {
            addCriterion("auth_type not like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIn(List<String> values) {
            addCriterion("auth_type in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotIn(List<String> values) {
            addCriterion("auth_type not in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeBetween(String value1, String value2) {
            addCriterion("auth_type between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotBetween(String value1, String value2) {
            addCriterion("auth_type not between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthScopeIsNull() {
            addCriterion("auth_scope is null");
            return (Criteria) this;
        }

        public Criteria andAuthScopeIsNotNull() {
            addCriterion("auth_scope is not null");
            return (Criteria) this;
        }

        public Criteria andAuthScopeEqualTo(String value) {
            addCriterion("auth_scope =", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeNotEqualTo(String value) {
            addCriterion("auth_scope <>", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeGreaterThan(String value) {
            addCriterion("auth_scope >", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeGreaterThanOrEqualTo(String value) {
            addCriterion("auth_scope >=", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeLessThan(String value) {
            addCriterion("auth_scope <", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeLessThanOrEqualTo(String value) {
            addCriterion("auth_scope <=", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeLike(String value) {
            addCriterion("auth_scope like", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeNotLike(String value) {
            addCriterion("auth_scope not like", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeIn(List<String> values) {
            addCriterion("auth_scope in", values, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeNotIn(List<String> values) {
            addCriterion("auth_scope not in", values, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeBetween(String value1, String value2) {
            addCriterion("auth_scope between", value1, value2, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeNotBetween(String value1, String value2) {
            addCriterion("auth_scope not between", value1, value2, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeIsNull() {
            addCriterion("auth_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeIsNotNull() {
            addCriterion("auth_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("auth_start_time =", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("auth_start_time <>", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("auth_start_time >", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auth_start_time >=", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("auth_start_time <", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auth_start_time <=", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("auth_start_time in", values, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("auth_start_time not in", values, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auth_start_time between", value1, value2, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auth_start_time not between", value1, value2, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateIsNull() {
            addCriterion("auth_end_date is null");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateIsNotNull() {
            addCriterion("auth_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("auth_end_date =", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("auth_end_date <>", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("auth_end_date >", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auth_end_date >=", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateLessThan(Date value) {
            addCriterionForJDBCDate("auth_end_date <", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auth_end_date <=", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("auth_end_date in", values, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("auth_end_date not in", values, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auth_end_date between", value1, value2, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auth_end_date not between", value1, value2, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNull() {
            addCriterion("default_value is null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNotNull() {
            addCriterion("default_value is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueEqualTo(String value) {
            addCriterion("default_value =", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotEqualTo(String value) {
            addCriterion("default_value <>", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThan(String value) {
            addCriterion("default_value >", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("default_value >=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThan(String value) {
            addCriterion("default_value <", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("default_value <=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLike(String value) {
            addCriterion("default_value like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotLike(String value) {
            addCriterion("default_value not like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIn(List<String> values) {
            addCriterion("default_value in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotIn(List<String> values) {
            addCriterion("default_value not in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueBetween(String value1, String value2) {
            addCriterion("default_value between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotBetween(String value1, String value2) {
            addCriterion("default_value not between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andMustFillIsNull() {
            addCriterion("must_fill is null");
            return (Criteria) this;
        }

        public Criteria andMustFillIsNotNull() {
            addCriterion("must_fill is not null");
            return (Criteria) this;
        }

        public Criteria andMustFillEqualTo(String value) {
            addCriterion("must_fill =", value, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillNotEqualTo(String value) {
            addCriterion("must_fill <>", value, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillGreaterThan(String value) {
            addCriterion("must_fill >", value, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillGreaterThanOrEqualTo(String value) {
            addCriterion("must_fill >=", value, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillLessThan(String value) {
            addCriterion("must_fill <", value, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillLessThanOrEqualTo(String value) {
            addCriterion("must_fill <=", value, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillLike(String value) {
            addCriterion("must_fill like", value, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillNotLike(String value) {
            addCriterion("must_fill not like", value, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillIn(List<String> values) {
            addCriterion("must_fill in", values, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillNotIn(List<String> values) {
            addCriterion("must_fill not in", values, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillBetween(String value1, String value2) {
            addCriterion("must_fill between", value1, value2, "mustFill");
            return (Criteria) this;
        }

        public Criteria andMustFillNotBetween(String value1, String value2) {
            addCriterion("must_fill not between", value1, value2, "mustFill");
            return (Criteria) this;
        }

        public Criteria andKindIsNull() {
            addCriterion("kind is null");
            return (Criteria) this;
        }

        public Criteria andKindIsNotNull() {
            addCriterion("kind is not null");
            return (Criteria) this;
        }

        public Criteria andKindEqualTo(String value) {
            addCriterion("kind =", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotEqualTo(String value) {
            addCriterion("kind <>", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThan(String value) {
            addCriterion("kind >", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThanOrEqualTo(String value) {
            addCriterion("kind >=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThan(String value) {
            addCriterion("kind <", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThanOrEqualTo(String value) {
            addCriterion("kind <=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLike(String value) {
            addCriterion("kind like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotLike(String value) {
            addCriterion("kind not like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindIn(List<String> values) {
            addCriterion("kind in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotIn(List<String> values) {
            addCriterion("kind not in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindBetween(String value1, String value2) {
            addCriterion("kind between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotBetween(String value1, String value2) {
            addCriterion("kind not between", value1, value2, "kind");
            return (Criteria) this;
        }
    }

    /**
     * db_pub_ts_column
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_pub_ts_column null
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