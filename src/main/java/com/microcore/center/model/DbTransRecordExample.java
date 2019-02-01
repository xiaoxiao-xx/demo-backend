package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DbTransRecordExample {
    /**
     * db_trans_record
     */
    protected String orderByClause;

    /**
     * db_trans_record
     */
    protected boolean distinct;

    /**
     * db_trans_record
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbTransRecordExample() {
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
     * db_trans_record null
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

        public Criteria andTableNameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("table_name =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("table_name >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("table_name <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("table_name like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("table_name not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("table_name in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("table_name not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_name between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_name not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andRecordCountIsNull() {
            addCriterion("record_count is null");
            return (Criteria) this;
        }

        public Criteria andRecordCountIsNotNull() {
            addCriterion("record_count is not null");
            return (Criteria) this;
        }

        public Criteria andRecordCountEqualTo(Integer value) {
            addCriterion("record_count =", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotEqualTo(Integer value) {
            addCriterion("record_count <>", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountGreaterThan(Integer value) {
            addCriterion("record_count >", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_count >=", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountLessThan(Integer value) {
            addCriterion("record_count <", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountLessThanOrEqualTo(Integer value) {
            addCriterion("record_count <=", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountIn(List<Integer> values) {
            addCriterion("record_count in", values, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotIn(List<Integer> values) {
            addCriterion("record_count not in", values, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountBetween(Integer value1, Integer value2) {
            addCriterion("record_count between", value1, value2, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotBetween(Integer value1, Integer value2) {
            addCriterion("record_count not between", value1, value2, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordSizeIsNull() {
            addCriterion("record_size is null");
            return (Criteria) this;
        }

        public Criteria andRecordSizeIsNotNull() {
            addCriterion("record_size is not null");
            return (Criteria) this;
        }

        public Criteria andRecordSizeEqualTo(Integer value) {
            addCriterion("record_size =", value, "recordSize");
            return (Criteria) this;
        }

        public Criteria andRecordSizeNotEqualTo(Integer value) {
            addCriterion("record_size <>", value, "recordSize");
            return (Criteria) this;
        }

        public Criteria andRecordSizeGreaterThan(Integer value) {
            addCriterion("record_size >", value, "recordSize");
            return (Criteria) this;
        }

        public Criteria andRecordSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_size >=", value, "recordSize");
            return (Criteria) this;
        }

        public Criteria andRecordSizeLessThan(Integer value) {
            addCriterion("record_size <", value, "recordSize");
            return (Criteria) this;
        }

        public Criteria andRecordSizeLessThanOrEqualTo(Integer value) {
            addCriterion("record_size <=", value, "recordSize");
            return (Criteria) this;
        }

        public Criteria andRecordSizeIn(List<Integer> values) {
            addCriterion("record_size in", values, "recordSize");
            return (Criteria) this;
        }

        public Criteria andRecordSizeNotIn(List<Integer> values) {
            addCriterion("record_size not in", values, "recordSize");
            return (Criteria) this;
        }

        public Criteria andRecordSizeBetween(Integer value1, Integer value2) {
            addCriterion("record_size between", value1, value2, "recordSize");
            return (Criteria) this;
        }

        public Criteria andRecordSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("record_size not between", value1, value2, "recordSize");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
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

        public Criteria andTransDateIsNull() {
            addCriterion("trans_date is null");
            return (Criteria) this;
        }

        public Criteria andTransDateIsNotNull() {
            addCriterion("trans_date is not null");
            return (Criteria) this;
        }

        public Criteria andTransDateEqualTo(Date value) {
            addCriterionForJDBCDate("trans_date =", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("trans_date <>", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateGreaterThan(Date value) {
            addCriterionForJDBCDate("trans_date >", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("trans_date >=", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateLessThan(Date value) {
            addCriterionForJDBCDate("trans_date <", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("trans_date <=", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateIn(List<Date> values) {
            addCriterionForJDBCDate("trans_date in", values, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("trans_date not in", values, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("trans_date between", value1, value2, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("trans_date not between", value1, value2, "transDate");
            return (Criteria) this;
        }

        public Criteria andStartTmIsNull() {
            addCriterion("start_tm is null");
            return (Criteria) this;
        }

        public Criteria andStartTmIsNotNull() {
            addCriterion("start_tm is not null");
            return (Criteria) this;
        }

        public Criteria andStartTmEqualTo(Date value) {
            addCriterion("start_tm =", value, "startTm");
            return (Criteria) this;
        }

        public Criteria andStartTmNotEqualTo(Date value) {
            addCriterion("start_tm <>", value, "startTm");
            return (Criteria) this;
        }

        public Criteria andStartTmGreaterThan(Date value) {
            addCriterion("start_tm >", value, "startTm");
            return (Criteria) this;
        }

        public Criteria andStartTmGreaterThanOrEqualTo(Date value) {
            addCriterion("start_tm >=", value, "startTm");
            return (Criteria) this;
        }

        public Criteria andStartTmLessThan(Date value) {
            addCriterion("start_tm <", value, "startTm");
            return (Criteria) this;
        }

        public Criteria andStartTmLessThanOrEqualTo(Date value) {
            addCriterion("start_tm <=", value, "startTm");
            return (Criteria) this;
        }

        public Criteria andStartTmIn(List<Date> values) {
            addCriterion("start_tm in", values, "startTm");
            return (Criteria) this;
        }

        public Criteria andStartTmNotIn(List<Date> values) {
            addCriterion("start_tm not in", values, "startTm");
            return (Criteria) this;
        }

        public Criteria andStartTmBetween(Date value1, Date value2) {
            addCriterion("start_tm between", value1, value2, "startTm");
            return (Criteria) this;
        }

        public Criteria andStartTmNotBetween(Date value1, Date value2) {
            addCriterion("start_tm not between", value1, value2, "startTm");
            return (Criteria) this;
        }

        public Criteria andEndTmIsNull() {
            addCriterion("end_tm is null");
            return (Criteria) this;
        }

        public Criteria andEndTmIsNotNull() {
            addCriterion("end_tm is not null");
            return (Criteria) this;
        }

        public Criteria andEndTmEqualTo(Date value) {
            addCriterion("end_tm =", value, "endTm");
            return (Criteria) this;
        }

        public Criteria andEndTmNotEqualTo(Date value) {
            addCriterion("end_tm <>", value, "endTm");
            return (Criteria) this;
        }

        public Criteria andEndTmGreaterThan(Date value) {
            addCriterion("end_tm >", value, "endTm");
            return (Criteria) this;
        }

        public Criteria andEndTmGreaterThanOrEqualTo(Date value) {
            addCriterion("end_tm >=", value, "endTm");
            return (Criteria) this;
        }

        public Criteria andEndTmLessThan(Date value) {
            addCriterion("end_tm <", value, "endTm");
            return (Criteria) this;
        }

        public Criteria andEndTmLessThanOrEqualTo(Date value) {
            addCriterion("end_tm <=", value, "endTm");
            return (Criteria) this;
        }

        public Criteria andEndTmIn(List<Date> values) {
            addCriterion("end_tm in", values, "endTm");
            return (Criteria) this;
        }

        public Criteria andEndTmNotIn(List<Date> values) {
            addCriterion("end_tm not in", values, "endTm");
            return (Criteria) this;
        }

        public Criteria andEndTmBetween(Date value1, Date value2) {
            addCriterion("end_tm between", value1, value2, "endTm");
            return (Criteria) this;
        }

        public Criteria andEndTmNotBetween(Date value1, Date value2) {
            addCriterion("end_tm not between", value1, value2, "endTm");
            return (Criteria) this;
        }
    }

    /**
     * db_trans_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_trans_record null
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