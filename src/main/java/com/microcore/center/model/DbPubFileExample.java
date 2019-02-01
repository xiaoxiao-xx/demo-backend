package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbPubFileExample {
    /**
     * db_pub_file
     */
    protected String orderByClause;

    /**
     * db_pub_file
     */
    protected boolean distinct;

    /**
     * db_pub_file
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbPubFileExample() {
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
     * db_pub_file null
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

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("model_id like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("model_id not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andPolIdIsNull() {
            addCriterion("pol_id is null");
            return (Criteria) this;
        }

        public Criteria andPolIdIsNotNull() {
            addCriterion("pol_id is not null");
            return (Criteria) this;
        }

        public Criteria andPolIdEqualTo(String value) {
            addCriterion("pol_id =", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdNotEqualTo(String value) {
            addCriterion("pol_id <>", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdGreaterThan(String value) {
            addCriterion("pol_id >", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdGreaterThanOrEqualTo(String value) {
            addCriterion("pol_id >=", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdLessThan(String value) {
            addCriterion("pol_id <", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdLessThanOrEqualTo(String value) {
            addCriterion("pol_id <=", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdLike(String value) {
            addCriterion("pol_id like", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdNotLike(String value) {
            addCriterion("pol_id not like", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdIn(List<String> values) {
            addCriterion("pol_id in", values, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdNotIn(List<String> values) {
            addCriterion("pol_id not in", values, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdBetween(String value1, String value2) {
            addCriterion("pol_id between", value1, value2, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdNotBetween(String value1, String value2) {
            addCriterion("pol_id not between", value1, value2, "polId");
            return (Criteria) this;
        }

        public Criteria andOrigPathIsNull() {
            addCriterion("orig_path is null");
            return (Criteria) this;
        }

        public Criteria andOrigPathIsNotNull() {
            addCriterion("orig_path is not null");
            return (Criteria) this;
        }

        public Criteria andOrigPathEqualTo(String value) {
            addCriterion("orig_path =", value, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathNotEqualTo(String value) {
            addCriterion("orig_path <>", value, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathGreaterThan(String value) {
            addCriterion("orig_path >", value, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathGreaterThanOrEqualTo(String value) {
            addCriterion("orig_path >=", value, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathLessThan(String value) {
            addCriterion("orig_path <", value, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathLessThanOrEqualTo(String value) {
            addCriterion("orig_path <=", value, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathLike(String value) {
            addCriterion("orig_path like", value, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathNotLike(String value) {
            addCriterion("orig_path not like", value, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathIn(List<String> values) {
            addCriterion("orig_path in", values, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathNotIn(List<String> values) {
            addCriterion("orig_path not in", values, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathBetween(String value1, String value2) {
            addCriterion("orig_path between", value1, value2, "origPath");
            return (Criteria) this;
        }

        public Criteria andOrigPathNotBetween(String value1, String value2) {
            addCriterion("orig_path not between", value1, value2, "origPath");
            return (Criteria) this;
        }

        public Criteria andPubPathIsNull() {
            addCriterion("pub_path is null");
            return (Criteria) this;
        }

        public Criteria andPubPathIsNotNull() {
            addCriterion("pub_path is not null");
            return (Criteria) this;
        }

        public Criteria andPubPathEqualTo(String value) {
            addCriterion("pub_path =", value, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathNotEqualTo(String value) {
            addCriterion("pub_path <>", value, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathGreaterThan(String value) {
            addCriterion("pub_path >", value, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathGreaterThanOrEqualTo(String value) {
            addCriterion("pub_path >=", value, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathLessThan(String value) {
            addCriterion("pub_path <", value, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathLessThanOrEqualTo(String value) {
            addCriterion("pub_path <=", value, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathLike(String value) {
            addCriterion("pub_path like", value, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathNotLike(String value) {
            addCriterion("pub_path not like", value, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathIn(List<String> values) {
            addCriterion("pub_path in", values, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathNotIn(List<String> values) {
            addCriterion("pub_path not in", values, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathBetween(String value1, String value2) {
            addCriterion("pub_path between", value1, value2, "pubPath");
            return (Criteria) this;
        }

        public Criteria andPubPathNotBetween(String value1, String value2) {
            addCriterion("pub_path not between", value1, value2, "pubPath");
            return (Criteria) this;
        }

        public Criteria andSenLevelIsNull() {
            addCriterion("sen_level is null");
            return (Criteria) this;
        }

        public Criteria andSenLevelIsNotNull() {
            addCriterion("sen_level is not null");
            return (Criteria) this;
        }

        public Criteria andSenLevelEqualTo(String value) {
            addCriterion("sen_level =", value, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelNotEqualTo(String value) {
            addCriterion("sen_level <>", value, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelGreaterThan(String value) {
            addCriterion("sen_level >", value, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelGreaterThanOrEqualTo(String value) {
            addCriterion("sen_level >=", value, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelLessThan(String value) {
            addCriterion("sen_level <", value, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelLessThanOrEqualTo(String value) {
            addCriterion("sen_level <=", value, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelLike(String value) {
            addCriterion("sen_level like", value, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelNotLike(String value) {
            addCriterion("sen_level not like", value, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelIn(List<String> values) {
            addCriterion("sen_level in", values, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelNotIn(List<String> values) {
            addCriterion("sen_level not in", values, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelBetween(String value1, String value2) {
            addCriterion("sen_level between", value1, value2, "senLevel");
            return (Criteria) this;
        }

        public Criteria andSenLevelNotBetween(String value1, String value2) {
            addCriterion("sen_level not between", value1, value2, "senLevel");
            return (Criteria) this;
        }

        public Criteria andUseScopeIsNull() {
            addCriterion("use_scope is null");
            return (Criteria) this;
        }

        public Criteria andUseScopeIsNotNull() {
            addCriterion("use_scope is not null");
            return (Criteria) this;
        }

        public Criteria andUseScopeEqualTo(String value) {
            addCriterion("use_scope =", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeNotEqualTo(String value) {
            addCriterion("use_scope <>", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeGreaterThan(String value) {
            addCriterion("use_scope >", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeGreaterThanOrEqualTo(String value) {
            addCriterion("use_scope >=", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeLessThan(String value) {
            addCriterion("use_scope <", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeLessThanOrEqualTo(String value) {
            addCriterion("use_scope <=", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeLike(String value) {
            addCriterion("use_scope like", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeNotLike(String value) {
            addCriterion("use_scope not like", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeIn(List<String> values) {
            addCriterion("use_scope in", values, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeNotIn(List<String> values) {
            addCriterion("use_scope not in", values, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeBetween(String value1, String value2) {
            addCriterion("use_scope between", value1, value2, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeNotBetween(String value1, String value2) {
            addCriterion("use_scope not between", value1, value2, "useScope");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(String value) {
            addCriterion("use_type =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(String value) {
            addCriterion("use_type <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(String value) {
            addCriterion("use_type >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("use_type >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(String value) {
            addCriterion("use_type <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(String value) {
            addCriterion("use_type <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLike(String value) {
            addCriterion("use_type like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotLike(String value) {
            addCriterion("use_type not like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<String> values) {
            addCriterion("use_type in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<String> values) {
            addCriterion("use_type not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(String value1, String value2) {
            addCriterion("use_type between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(String value1, String value2) {
            addCriterion("use_type not between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andPubNameIsNull() {
            addCriterion("pub_name is null");
            return (Criteria) this;
        }

        public Criteria andPubNameIsNotNull() {
            addCriterion("pub_name is not null");
            return (Criteria) this;
        }

        public Criteria andPubNameEqualTo(String value) {
            addCriterion("pub_name =", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameNotEqualTo(String value) {
            addCriterion("pub_name <>", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameGreaterThan(String value) {
            addCriterion("pub_name >", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameGreaterThanOrEqualTo(String value) {
            addCriterion("pub_name >=", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameLessThan(String value) {
            addCriterion("pub_name <", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameLessThanOrEqualTo(String value) {
            addCriterion("pub_name <=", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameLike(String value) {
            addCriterion("pub_name like", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameNotLike(String value) {
            addCriterion("pub_name not like", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameIn(List<String> values) {
            addCriterion("pub_name in", values, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameNotIn(List<String> values) {
            addCriterion("pub_name not in", values, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameBetween(String value1, String value2) {
            addCriterion("pub_name between", value1, value2, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameNotBetween(String value1, String value2) {
            addCriterion("pub_name not between", value1, value2, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubDescIsNull() {
            addCriterion("pub_desc is null");
            return (Criteria) this;
        }

        public Criteria andPubDescIsNotNull() {
            addCriterion("pub_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPubDescEqualTo(String value) {
            addCriterion("pub_desc =", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescNotEqualTo(String value) {
            addCriterion("pub_desc <>", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescGreaterThan(String value) {
            addCriterion("pub_desc >", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescGreaterThanOrEqualTo(String value) {
            addCriterion("pub_desc >=", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescLessThan(String value) {
            addCriterion("pub_desc <", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescLessThanOrEqualTo(String value) {
            addCriterion("pub_desc <=", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescLike(String value) {
            addCriterion("pub_desc like", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescNotLike(String value) {
            addCriterion("pub_desc not like", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescIn(List<String> values) {
            addCriterion("pub_desc in", values, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescNotIn(List<String> values) {
            addCriterion("pub_desc not in", values, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescBetween(String value1, String value2) {
            addCriterion("pub_desc between", value1, value2, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescNotBetween(String value1, String value2) {
            addCriterion("pub_desc not between", value1, value2, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNull() {
            addCriterion("run_status is null");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNotNull() {
            addCriterion("run_status is not null");
            return (Criteria) this;
        }

        public Criteria andRunStatusEqualTo(String value) {
            addCriterion("run_status =", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotEqualTo(String value) {
            addCriterion("run_status <>", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThan(String value) {
            addCriterion("run_status >", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThanOrEqualTo(String value) {
            addCriterion("run_status >=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThan(String value) {
            addCriterion("run_status <", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThanOrEqualTo(String value) {
            addCriterion("run_status <=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLike(String value) {
            addCriterion("run_status like", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotLike(String value) {
            addCriterion("run_status not like", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusIn(List<String> values) {
            addCriterion("run_status in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotIn(List<String> values) {
            addCriterion("run_status not in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusBetween(String value1, String value2) {
            addCriterion("run_status between", value1, value2, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotBetween(String value1, String value2) {
            addCriterion("run_status not between", value1, value2, "runStatus");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNull() {
            addCriterion("extract_type is null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNotNull() {
            addCriterion("extract_type is not null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeEqualTo(String value) {
            addCriterion("extract_type =", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotEqualTo(String value) {
            addCriterion("extract_type <>", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThan(String value) {
            addCriterion("extract_type >", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("extract_type >=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThan(String value) {
            addCriterion("extract_type <", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThanOrEqualTo(String value) {
            addCriterion("extract_type <=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLike(String value) {
            addCriterion("extract_type like", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotLike(String value) {
            addCriterion("extract_type not like", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIn(List<String> values) {
            addCriterion("extract_type in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotIn(List<String> values) {
            addCriterion("extract_type not in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeBetween(String value1, String value2) {
            addCriterion("extract_type between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotBetween(String value1, String value2) {
            addCriterion("extract_type not between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andBackupPathIsNull() {
            addCriterion("backup_path is null");
            return (Criteria) this;
        }

        public Criteria andBackupPathIsNotNull() {
            addCriterion("backup_path is not null");
            return (Criteria) this;
        }

        public Criteria andBackupPathEqualTo(String value) {
            addCriterion("backup_path =", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathNotEqualTo(String value) {
            addCriterion("backup_path <>", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathGreaterThan(String value) {
            addCriterion("backup_path >", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathGreaterThanOrEqualTo(String value) {
            addCriterion("backup_path >=", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathLessThan(String value) {
            addCriterion("backup_path <", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathLessThanOrEqualTo(String value) {
            addCriterion("backup_path <=", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathLike(String value) {
            addCriterion("backup_path like", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathNotLike(String value) {
            addCriterion("backup_path not like", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathIn(List<String> values) {
            addCriterion("backup_path in", values, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathNotIn(List<String> values) {
            addCriterion("backup_path not in", values, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathBetween(String value1, String value2) {
            addCriterion("backup_path between", value1, value2, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathNotBetween(String value1, String value2) {
            addCriterion("backup_path not between", value1, value2, "backupPath");
            return (Criteria) this;
        }

        public Criteria andUseFreIsNull() {
            addCriterion("use_fre is null");
            return (Criteria) this;
        }

        public Criteria andUseFreIsNotNull() {
            addCriterion("use_fre is not null");
            return (Criteria) this;
        }

        public Criteria andUseFreEqualTo(Integer value) {
            addCriterion("use_fre =", value, "useFre");
            return (Criteria) this;
        }

        public Criteria andUseFreNotEqualTo(Integer value) {
            addCriterion("use_fre <>", value, "useFre");
            return (Criteria) this;
        }

        public Criteria andUseFreGreaterThan(Integer value) {
            addCriterion("use_fre >", value, "useFre");
            return (Criteria) this;
        }

        public Criteria andUseFreGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_fre >=", value, "useFre");
            return (Criteria) this;
        }

        public Criteria andUseFreLessThan(Integer value) {
            addCriterion("use_fre <", value, "useFre");
            return (Criteria) this;
        }

        public Criteria andUseFreLessThanOrEqualTo(Integer value) {
            addCriterion("use_fre <=", value, "useFre");
            return (Criteria) this;
        }

        public Criteria andUseFreIn(List<Integer> values) {
            addCriterion("use_fre in", values, "useFre");
            return (Criteria) this;
        }

        public Criteria andUseFreNotIn(List<Integer> values) {
            addCriterion("use_fre not in", values, "useFre");
            return (Criteria) this;
        }

        public Criteria andUseFreBetween(Integer value1, Integer value2) {
            addCriterion("use_fre between", value1, value2, "useFre");
            return (Criteria) this;
        }

        public Criteria andUseFreNotBetween(Integer value1, Integer value2) {
            addCriterion("use_fre not between", value1, value2, "useFre");
            return (Criteria) this;
        }

        public Criteria andAgainAccIsNull() {
            addCriterion("again_acc is null");
            return (Criteria) this;
        }

        public Criteria andAgainAccIsNotNull() {
            addCriterion("again_acc is not null");
            return (Criteria) this;
        }

        public Criteria andAgainAccEqualTo(String value) {
            addCriterion("again_acc =", value, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccNotEqualTo(String value) {
            addCriterion("again_acc <>", value, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccGreaterThan(String value) {
            addCriterion("again_acc >", value, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccGreaterThanOrEqualTo(String value) {
            addCriterion("again_acc >=", value, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccLessThan(String value) {
            addCriterion("again_acc <", value, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccLessThanOrEqualTo(String value) {
            addCriterion("again_acc <=", value, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccLike(String value) {
            addCriterion("again_acc like", value, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccNotLike(String value) {
            addCriterion("again_acc not like", value, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccIn(List<String> values) {
            addCriterion("again_acc in", values, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccNotIn(List<String> values) {
            addCriterion("again_acc not in", values, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccBetween(String value1, String value2) {
            addCriterion("again_acc between", value1, value2, "againAcc");
            return (Criteria) this;
        }

        public Criteria andAgainAccNotBetween(String value1, String value2) {
            addCriterion("again_acc not between", value1, value2, "againAcc");
            return (Criteria) this;
        }

        public Criteria andReportCaseIsNull() {
            addCriterion("report_case is null");
            return (Criteria) this;
        }

        public Criteria andReportCaseIsNotNull() {
            addCriterion("report_case is not null");
            return (Criteria) this;
        }

        public Criteria andReportCaseEqualTo(String value) {
            addCriterion("report_case =", value, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseNotEqualTo(String value) {
            addCriterion("report_case <>", value, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseGreaterThan(String value) {
            addCriterion("report_case >", value, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseGreaterThanOrEqualTo(String value) {
            addCriterion("report_case >=", value, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseLessThan(String value) {
            addCriterion("report_case <", value, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseLessThanOrEqualTo(String value) {
            addCriterion("report_case <=", value, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseLike(String value) {
            addCriterion("report_case like", value, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseNotLike(String value) {
            addCriterion("report_case not like", value, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseIn(List<String> values) {
            addCriterion("report_case in", values, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseNotIn(List<String> values) {
            addCriterion("report_case not in", values, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseBetween(String value1, String value2) {
            addCriterion("report_case between", value1, value2, "reportCase");
            return (Criteria) this;
        }

        public Criteria andReportCaseNotBetween(String value1, String value2) {
            addCriterion("report_case not between", value1, value2, "reportCase");
            return (Criteria) this;
        }

        public Criteria andAutoAppIsNull() {
            addCriterion("auto_app is null");
            return (Criteria) this;
        }

        public Criteria andAutoAppIsNotNull() {
            addCriterion("auto_app is not null");
            return (Criteria) this;
        }

        public Criteria andAutoAppEqualTo(String value) {
            addCriterion("auto_app =", value, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppNotEqualTo(String value) {
            addCriterion("auto_app <>", value, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppGreaterThan(String value) {
            addCriterion("auto_app >", value, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppGreaterThanOrEqualTo(String value) {
            addCriterion("auto_app >=", value, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppLessThan(String value) {
            addCriterion("auto_app <", value, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppLessThanOrEqualTo(String value) {
            addCriterion("auto_app <=", value, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppLike(String value) {
            addCriterion("auto_app like", value, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppNotLike(String value) {
            addCriterion("auto_app not like", value, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppIn(List<String> values) {
            addCriterion("auto_app in", values, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppNotIn(List<String> values) {
            addCriterion("auto_app not in", values, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppBetween(String value1, String value2) {
            addCriterion("auto_app between", value1, value2, "autoApp");
            return (Criteria) this;
        }

        public Criteria andAutoAppNotBetween(String value1, String value2) {
            addCriterion("auto_app not between", value1, value2, "autoApp");
            return (Criteria) this;
        }

        public Criteria andTraceMarkIsNull() {
            addCriterion("trace_mark is null");
            return (Criteria) this;
        }

        public Criteria andTraceMarkIsNotNull() {
            addCriterion("trace_mark is not null");
            return (Criteria) this;
        }

        public Criteria andTraceMarkEqualTo(String value) {
            addCriterion("trace_mark =", value, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkNotEqualTo(String value) {
            addCriterion("trace_mark <>", value, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkGreaterThan(String value) {
            addCriterion("trace_mark >", value, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkGreaterThanOrEqualTo(String value) {
            addCriterion("trace_mark >=", value, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkLessThan(String value) {
            addCriterion("trace_mark <", value, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkLessThanOrEqualTo(String value) {
            addCriterion("trace_mark <=", value, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkLike(String value) {
            addCriterion("trace_mark like", value, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkNotLike(String value) {
            addCriterion("trace_mark not like", value, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkIn(List<String> values) {
            addCriterion("trace_mark in", values, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkNotIn(List<String> values) {
            addCriterion("trace_mark not in", values, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkBetween(String value1, String value2) {
            addCriterion("trace_mark between", value1, value2, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTraceMarkNotBetween(String value1, String value2) {
            addCriterion("trace_mark not between", value1, value2, "traceMark");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(String value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(String value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLike(String value) {
            addCriterion("template_id like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            addCriterion("template_id not like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<String> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andAutoChangeIsNull() {
            addCriterion("auto_change is null");
            return (Criteria) this;
        }

        public Criteria andAutoChangeIsNotNull() {
            addCriterion("auto_change is not null");
            return (Criteria) this;
        }

        public Criteria andAutoChangeEqualTo(String value) {
            addCriterion("auto_change =", value, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeNotEqualTo(String value) {
            addCriterion("auto_change <>", value, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeGreaterThan(String value) {
            addCriterion("auto_change >", value, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeGreaterThanOrEqualTo(String value) {
            addCriterion("auto_change >=", value, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeLessThan(String value) {
            addCriterion("auto_change <", value, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeLessThanOrEqualTo(String value) {
            addCriterion("auto_change <=", value, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeLike(String value) {
            addCriterion("auto_change like", value, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeNotLike(String value) {
            addCriterion("auto_change not like", value, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeIn(List<String> values) {
            addCriterion("auto_change in", values, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeNotIn(List<String> values) {
            addCriterion("auto_change not in", values, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeBetween(String value1, String value2) {
            addCriterion("auto_change between", value1, value2, "autoChange");
            return (Criteria) this;
        }

        public Criteria andAutoChangeNotBetween(String value1, String value2) {
            addCriterion("auto_change not between", value1, value2, "autoChange");
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
     * db_pub_file
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_pub_file null
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