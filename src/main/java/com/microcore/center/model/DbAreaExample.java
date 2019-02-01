package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbAreaExample {
    /**
     * db_area
     */
    protected String orderByClause;

    /**
     * db_area
     */
    protected boolean distinct;

    /**
     * db_area
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbAreaExample() {
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
     * db_area null
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

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaTypeIsNull() {
            addCriterion("area_type is null");
            return (Criteria) this;
        }

        public Criteria andAreaTypeIsNotNull() {
            addCriterion("area_type is not null");
            return (Criteria) this;
        }

        public Criteria andAreaTypeEqualTo(String value) {
            addCriterion("area_type =", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotEqualTo(String value) {
            addCriterion("area_type <>", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeGreaterThan(String value) {
            addCriterion("area_type >", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("area_type >=", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeLessThan(String value) {
            addCriterion("area_type <", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeLessThanOrEqualTo(String value) {
            addCriterion("area_type <=", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeLike(String value) {
            addCriterion("area_type like", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotLike(String value) {
            addCriterion("area_type not like", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeIn(List<String> values) {
            addCriterion("area_type in", values, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotIn(List<String> values) {
            addCriterion("area_type not in", values, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeBetween(String value1, String value2) {
            addCriterion("area_type between", value1, value2, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotBetween(String value1, String value2) {
            addCriterion("area_type not between", value1, value2, "areaType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNull() {
            addCriterion("key_value is null");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNotNull() {
            addCriterion("key_value is not null");
            return (Criteria) this;
        }

        public Criteria andKeyValueEqualTo(String value) {
            addCriterion("key_value =", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotEqualTo(String value) {
            addCriterion("key_value <>", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThan(String value) {
            addCriterion("key_value >", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThanOrEqualTo(String value) {
            addCriterion("key_value >=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThan(String value) {
            addCriterion("key_value <", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThanOrEqualTo(String value) {
            addCriterion("key_value <=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLike(String value) {
            addCriterion("key_value like", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotLike(String value) {
            addCriterion("key_value not like", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueIn(List<String> values) {
            addCriterion("key_value in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotIn(List<String> values) {
            addCriterion("key_value not in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueBetween(String value1, String value2) {
            addCriterion("key_value between", value1, value2, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotBetween(String value1, String value2) {
            addCriterion("key_value not between", value1, value2, "keyValue");
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
     * db_area
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_area null
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