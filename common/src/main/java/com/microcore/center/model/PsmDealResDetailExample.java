package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PsmDealResDetailExample {
    /**
     * psm_deal_res_detail_t
     */
    protected String orderByClause;

    /**
     * psm_deal_res_detail_t
     */
    protected boolean distinct;

    /**
     * psm_deal_res_detail_t
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public PsmDealResDetailExample() {
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
     * psm_deal_res_detail_t null
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

        public Criteria andResIdIsNull() {
            addCriterion("res_id is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("res_id is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(String value) {
            addCriterion("res_id =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(String value) {
            addCriterion("res_id <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(String value) {
            addCriterion("res_id >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(String value) {
            addCriterion("res_id >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(String value) {
            addCriterion("res_id <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(String value) {
            addCriterion("res_id <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLike(String value) {
            addCriterion("res_id like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotLike(String value) {
            addCriterion("res_id not like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<String> values) {
            addCriterion("res_id in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<String> values) {
            addCriterion("res_id not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(String value1, String value2) {
            addCriterion("res_id between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(String value1, String value2) {
            addCriterion("res_id not between", value1, value2, "resId");
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

        public Criteria andCharacterInfoIsNull() {
            addCriterion("character_info is null");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoIsNotNull() {
            addCriterion("character_info is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoEqualTo(String value) {
            addCriterion("character_info =", value, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoNotEqualTo(String value) {
            addCriterion("character_info <>", value, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoGreaterThan(String value) {
            addCriterion("character_info >", value, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoGreaterThanOrEqualTo(String value) {
            addCriterion("character_info >=", value, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoLessThan(String value) {
            addCriterion("character_info <", value, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoLessThanOrEqualTo(String value) {
            addCriterion("character_info <=", value, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoLike(String value) {
            addCriterion("character_info like", value, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoNotLike(String value) {
            addCriterion("character_info not like", value, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoIn(List<String> values) {
            addCriterion("character_info in", values, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoNotIn(List<String> values) {
            addCriterion("character_info not in", values, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoBetween(String value1, String value2) {
            addCriterion("character_info between", value1, value2, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andCharacterInfoNotBetween(String value1, String value2) {
            addCriterion("character_info not between", value1, value2, "characterInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoIsNull() {
            addCriterion("event_info is null");
            return (Criteria) this;
        }

        public Criteria andEventInfoIsNotNull() {
            addCriterion("event_info is not null");
            return (Criteria) this;
        }

        public Criteria andEventInfoEqualTo(String value) {
            addCriterion("event_info =", value, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoNotEqualTo(String value) {
            addCriterion("event_info <>", value, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoGreaterThan(String value) {
            addCriterion("event_info >", value, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoGreaterThanOrEqualTo(String value) {
            addCriterion("event_info >=", value, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoLessThan(String value) {
            addCriterion("event_info <", value, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoLessThanOrEqualTo(String value) {
            addCriterion("event_info <=", value, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoLike(String value) {
            addCriterion("event_info like", value, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoNotLike(String value) {
            addCriterion("event_info not like", value, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoIn(List<String> values) {
            addCriterion("event_info in", values, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoNotIn(List<String> values) {
            addCriterion("event_info not in", values, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoBetween(String value1, String value2) {
            addCriterion("event_info between", value1, value2, "eventInfo");
            return (Criteria) this;
        }

        public Criteria andEventInfoNotBetween(String value1, String value2) {
            addCriterion("event_info not between", value1, value2, "eventInfo");
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
     * psm_deal_res_detail_t
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * psm_deal_res_detail_t null
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