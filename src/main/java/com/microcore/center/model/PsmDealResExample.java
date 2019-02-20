package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PsmDealResExample {
    /**
     * psm_deal_res_t
     */
    protected String orderByClause;

    /**
     * psm_deal_res_t
     */
    protected boolean distinct;

    /**
     * psm_deal_res_t
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public PsmDealResExample() {
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
     * psm_deal_res_t null
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

        public Criteria andSrcIdIsNull() {
            addCriterion("src_id is null");
            return (Criteria) this;
        }

        public Criteria andSrcIdIsNotNull() {
            addCriterion("src_id is not null");
            return (Criteria) this;
        }

        public Criteria andSrcIdEqualTo(String value) {
            addCriterion("src_id =", value, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdNotEqualTo(String value) {
            addCriterion("src_id <>", value, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdGreaterThan(String value) {
            addCriterion("src_id >", value, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdGreaterThanOrEqualTo(String value) {
            addCriterion("src_id >=", value, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdLessThan(String value) {
            addCriterion("src_id <", value, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdLessThanOrEqualTo(String value) {
            addCriterion("src_id <=", value, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdLike(String value) {
            addCriterion("src_id like", value, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdNotLike(String value) {
            addCriterion("src_id not like", value, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdIn(List<String> values) {
            addCriterion("src_id in", values, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdNotIn(List<String> values) {
            addCriterion("src_id not in", values, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdBetween(String value1, String value2) {
            addCriterion("src_id between", value1, value2, "srcId");
            return (Criteria) this;
        }

        public Criteria andSrcIdNotBetween(String value1, String value2) {
            addCriterion("src_id not between", value1, value2, "srcId");
            return (Criteria) this;
        }

        public Criteria andDealStateIsNull() {
            addCriterion("deal_state is null");
            return (Criteria) this;
        }

        public Criteria andDealStateIsNotNull() {
            addCriterion("deal_state is not null");
            return (Criteria) this;
        }

        public Criteria andDealStateEqualTo(String value) {
            addCriterion("deal_state =", value, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateNotEqualTo(String value) {
            addCriterion("deal_state <>", value, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateGreaterThan(String value) {
            addCriterion("deal_state >", value, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateGreaterThanOrEqualTo(String value) {
            addCriterion("deal_state >=", value, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateLessThan(String value) {
            addCriterion("deal_state <", value, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateLessThanOrEqualTo(String value) {
            addCriterion("deal_state <=", value, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateLike(String value) {
            addCriterion("deal_state like", value, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateNotLike(String value) {
            addCriterion("deal_state not like", value, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateIn(List<String> values) {
            addCriterion("deal_state in", values, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateNotIn(List<String> values) {
            addCriterion("deal_state not in", values, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateBetween(String value1, String value2) {
            addCriterion("deal_state between", value1, value2, "dealState");
            return (Criteria) this;
        }

        public Criteria andDealStateNotBetween(String value1, String value2) {
            addCriterion("deal_state not between", value1, value2, "dealState");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNull() {
            addCriterion("complete_time is null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNotNull() {
            addCriterion("complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeEqualTo(Date value) {
            addCriterionForJDBCDate("complete_time =", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("complete_time <>", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("complete_time >", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("complete_time >=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThan(Date value) {
            addCriterionForJDBCDate("complete_time <", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("complete_time <=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIn(List<Date> values) {
            addCriterionForJDBCDate("complete_time in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("complete_time not in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("complete_time between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("complete_time not between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andValidStateIsNull() {
            addCriterion("valid_state is null");
            return (Criteria) this;
        }

        public Criteria andValidStateIsNotNull() {
            addCriterion("valid_state is not null");
            return (Criteria) this;
        }

        public Criteria andValidStateEqualTo(String value) {
            addCriterion("valid_state =", value, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateNotEqualTo(String value) {
            addCriterion("valid_state <>", value, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateGreaterThan(String value) {
            addCriterion("valid_state >", value, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateGreaterThanOrEqualTo(String value) {
            addCriterion("valid_state >=", value, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateLessThan(String value) {
            addCriterion("valid_state <", value, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateLessThanOrEqualTo(String value) {
            addCriterion("valid_state <=", value, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateLike(String value) {
            addCriterion("valid_state like", value, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateNotLike(String value) {
            addCriterion("valid_state not like", value, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateIn(List<String> values) {
            addCriterion("valid_state in", values, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateNotIn(List<String> values) {
            addCriterion("valid_state not in", values, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateBetween(String value1, String value2) {
            addCriterion("valid_state between", value1, value2, "validState");
            return (Criteria) this;
        }

        public Criteria andValidStateNotBetween(String value1, String value2) {
            addCriterion("valid_state not between", value1, value2, "validState");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterionForJDBCDate("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterionForJDBCDate("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterionForJDBCDate("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCharactersIsNull() {
            addCriterion("characters is null");
            return (Criteria) this;
        }

        public Criteria andCharactersIsNotNull() {
            addCriterion("characters is not null");
            return (Criteria) this;
        }

        public Criteria andCharactersEqualTo(String value) {
            addCriterion("characters =", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersNotEqualTo(String value) {
            addCriterion("characters <>", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersGreaterThan(String value) {
            addCriterion("characters >", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersGreaterThanOrEqualTo(String value) {
            addCriterion("characters >=", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersLessThan(String value) {
            addCriterion("characters <", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersLessThanOrEqualTo(String value) {
            addCriterion("characters <=", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersLike(String value) {
            addCriterion("characters like", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersNotLike(String value) {
            addCriterion("characters not like", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersIn(List<String> values) {
            addCriterion("characters in", values, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersNotIn(List<String> values) {
            addCriterion("characters not in", values, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersBetween(String value1, String value2) {
            addCriterion("characters between", value1, value2, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersNotBetween(String value1, String value2) {
            addCriterion("characters not between", value1, value2, "characters");
            return (Criteria) this;
        }

        public Criteria andDealEventIsNull() {
            addCriterion("deal_event is null");
            return (Criteria) this;
        }

        public Criteria andDealEventIsNotNull() {
            addCriterion("deal_event is not null");
            return (Criteria) this;
        }

        public Criteria andDealEventEqualTo(String value) {
            addCriterion("deal_event =", value, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventNotEqualTo(String value) {
            addCriterion("deal_event <>", value, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventGreaterThan(String value) {
            addCriterion("deal_event >", value, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventGreaterThanOrEqualTo(String value) {
            addCriterion("deal_event >=", value, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventLessThan(String value) {
            addCriterion("deal_event <", value, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventLessThanOrEqualTo(String value) {
            addCriterion("deal_event <=", value, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventLike(String value) {
            addCriterion("deal_event like", value, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventNotLike(String value) {
            addCriterion("deal_event not like", value, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventIn(List<String> values) {
            addCriterion("deal_event in", values, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventNotIn(List<String> values) {
            addCriterion("deal_event not in", values, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventBetween(String value1, String value2) {
            addCriterion("deal_event between", value1, value2, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andDealEventNotBetween(String value1, String value2) {
            addCriterion("deal_event not between", value1, value2, "dealEvent");
            return (Criteria) this;
        }

        public Criteria andAlarmStateIsNull() {
            addCriterion("alarm_state is null");
            return (Criteria) this;
        }

        public Criteria andAlarmStateIsNotNull() {
            addCriterion("alarm_state is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmStateEqualTo(String value) {
            addCriterion("alarm_state =", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateNotEqualTo(String value) {
            addCriterion("alarm_state <>", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateGreaterThan(String value) {
            addCriterion("alarm_state >", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_state >=", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateLessThan(String value) {
            addCriterion("alarm_state <", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateLessThanOrEqualTo(String value) {
            addCriterion("alarm_state <=", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateLike(String value) {
            addCriterion("alarm_state like", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateNotLike(String value) {
            addCriterion("alarm_state not like", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateIn(List<String> values) {
            addCriterion("alarm_state in", values, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateNotIn(List<String> values) {
            addCriterion("alarm_state not in", values, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateBetween(String value1, String value2) {
            addCriterion("alarm_state between", value1, value2, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateNotBetween(String value1, String value2) {
            addCriterion("alarm_state not between", value1, value2, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNull() {
            addCriterion("alarm_type is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNotNull() {
            addCriterion("alarm_type is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeEqualTo(String value) {
            addCriterion("alarm_type =", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotEqualTo(String value) {
            addCriterion("alarm_type <>", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThan(String value) {
            addCriterion("alarm_type >", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_type >=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThan(String value) {
            addCriterion("alarm_type <", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThanOrEqualTo(String value) {
            addCriterion("alarm_type <=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLike(String value) {
            addCriterion("alarm_type like", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotLike(String value) {
            addCriterion("alarm_type not like", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIn(List<String> values) {
            addCriterion("alarm_type in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotIn(List<String> values) {
            addCriterion("alarm_type not in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeBetween(String value1, String value2) {
            addCriterion("alarm_type between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotBetween(String value1, String value2) {
            addCriterion("alarm_type not between", value1, value2, "alarmType");
            return (Criteria) this;
        }
    }

    /**
     * psm_deal_res_t
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * psm_deal_res_t null
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