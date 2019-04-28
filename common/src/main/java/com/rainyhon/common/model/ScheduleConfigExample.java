package com.rainyhon.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ScheduleConfigExample {
    /**
     * schedule_config
     */
    protected String orderByClause;

    /**
     * schedule_config
     */
    protected boolean distinct;

    /**
     * schedule_config
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public ScheduleConfigExample() {
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
     * schedule_config null
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andConfigTypeIsNull() {
            addCriterion("config_type is null");
            return (Criteria) this;
        }

        public Criteria andConfigTypeIsNotNull() {
            addCriterion("config_type is not null");
            return (Criteria) this;
        }

        public Criteria andConfigTypeEqualTo(String value) {
            addCriterion("config_type =", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotEqualTo(String value) {
            addCriterion("config_type <>", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeGreaterThan(String value) {
            addCriterion("config_type >", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeGreaterThanOrEqualTo(String value) {
            addCriterion("config_type >=", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeLessThan(String value) {
            addCriterion("config_type <", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeLessThanOrEqualTo(String value) {
            addCriterion("config_type <=", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeLike(String value) {
            addCriterion("config_type like", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotLike(String value) {
            addCriterion("config_type not like", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeIn(List<String> values) {
            addCriterion("config_type in", values, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotIn(List<String> values) {
            addCriterion("config_type not in", values, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeBetween(String value1, String value2) {
            addCriterion("config_type between", value1, value2, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotBetween(String value1, String value2) {
            addCriterion("config_type not between", value1, value2, "configType");
            return (Criteria) this;
        }

        public Criteria andSelectFlagIsNull() {
            addCriterion("select_flag is null");
            return (Criteria) this;
        }

        public Criteria andSelectFlagIsNotNull() {
            addCriterion("select_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSelectFlagEqualTo(String value) {
            addCriterion("select_flag =", value, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagNotEqualTo(String value) {
            addCriterion("select_flag <>", value, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagGreaterThan(String value) {
            addCriterion("select_flag >", value, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagGreaterThanOrEqualTo(String value) {
            addCriterion("select_flag >=", value, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagLessThan(String value) {
            addCriterion("select_flag <", value, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagLessThanOrEqualTo(String value) {
            addCriterion("select_flag <=", value, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagLike(String value) {
            addCriterion("select_flag like", value, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagNotLike(String value) {
            addCriterion("select_flag not like", value, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagIn(List<String> values) {
            addCriterion("select_flag in", values, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagNotIn(List<String> values) {
            addCriterion("select_flag not in", values, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagBetween(String value1, String value2) {
            addCriterion("select_flag between", value1, value2, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andSelectFlagNotBetween(String value1, String value2) {
            addCriterion("select_flag not between", value1, value2, "selectFlag");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(String value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(String value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(String value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(String value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(String value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(String value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLike(String value) {
            addCriterion("team_id like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotLike(String value) {
            addCriterion("team_id not like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<String> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<String> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(String value1, String value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(String value1, String value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNull() {
            addCriterion("object_type is null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNotNull() {
            addCriterion("object_type is not null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeEqualTo(String value) {
            addCriterion("object_type =", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotEqualTo(String value) {
            addCriterion("object_type <>", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThan(String value) {
            addCriterion("object_type >", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("object_type >=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThan(String value) {
            addCriterion("object_type <", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThanOrEqualTo(String value) {
            addCriterion("object_type <=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLike(String value) {
            addCriterion("object_type like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotLike(String value) {
            addCriterion("object_type not like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIn(List<String> values) {
            addCriterion("object_type in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotIn(List<String> values) {
            addCriterion("object_type not in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeBetween(String value1, String value2) {
            addCriterion("object_type between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotBetween(String value1, String value2) {
            addCriterion("object_type not between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNull() {
            addCriterion("object_id is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("object_id is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(String value) {
            addCriterion("object_id =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(String value) {
            addCriterion("object_id <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(String value) {
            addCriterion("object_id >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("object_id >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(String value) {
            addCriterion("object_id <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(String value) {
            addCriterion("object_id <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLike(String value) {
            addCriterion("object_id like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotLike(String value) {
            addCriterion("object_id not like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<String> values) {
            addCriterion("object_id in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<String> values) {
            addCriterion("object_id not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(String value1, String value2) {
            addCriterion("object_id between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(String value1, String value2) {
            addCriterion("object_id not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andSomeDateIsNull() {
            addCriterion("some_date is null");
            return (Criteria) this;
        }

        public Criteria andSomeDateIsNotNull() {
            addCriterion("some_date is not null");
            return (Criteria) this;
        }

        public Criteria andSomeDateEqualTo(Date value) {
            addCriterionForJDBCDate("some_date =", value, "someDate");
            return (Criteria) this;
        }

        public Criteria andSomeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("some_date <>", value, "someDate");
            return (Criteria) this;
        }

        public Criteria andSomeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("some_date >", value, "someDate");
            return (Criteria) this;
        }

        public Criteria andSomeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("some_date >=", value, "someDate");
            return (Criteria) this;
        }

        public Criteria andSomeDateLessThan(Date value) {
            addCriterionForJDBCDate("some_date <", value, "someDate");
            return (Criteria) this;
        }

        public Criteria andSomeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("some_date <=", value, "someDate");
            return (Criteria) this;
        }

        public Criteria andSomeDateIn(List<Date> values) {
            addCriterionForJDBCDate("some_date in", values, "someDate");
            return (Criteria) this;
        }

        public Criteria andSomeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("some_date not in", values, "someDate");
            return (Criteria) this;
        }

        public Criteria andSomeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("some_date between", value1, value2, "someDate");
            return (Criteria) this;
        }

        public Criteria andSomeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("some_date not between", value1, value2, "someDate");
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
            addCriterionForJDBCTime("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("end_time not between", value1, value2, "endTime");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNull() {
            addCriterion("teacher is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNotNull() {
            addCriterion("teacher is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEqualTo(String value) {
            addCriterion("teacher =", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotEqualTo(String value) {
            addCriterion("teacher <>", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThan(String value) {
            addCriterion("teacher >", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("teacher >=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThan(String value) {
            addCriterion("teacher <", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThanOrEqualTo(String value) {
            addCriterion("teacher <=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLike(String value) {
            addCriterion("teacher like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotLike(String value) {
            addCriterion("teacher not like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherIn(List<String> values) {
            addCriterion("teacher in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotIn(List<String> values) {
            addCriterion("teacher not in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherBetween(String value1, String value2) {
            addCriterion("teacher between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotBetween(String value1, String value2) {
            addCriterion("teacher not between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeIsNull() {
            addCriterion("repeat_type is null");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeIsNotNull() {
            addCriterion("repeat_type is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeEqualTo(String value) {
            addCriterion("repeat_type =", value, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeNotEqualTo(String value) {
            addCriterion("repeat_type <>", value, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeGreaterThan(String value) {
            addCriterion("repeat_type >", value, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("repeat_type >=", value, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeLessThan(String value) {
            addCriterion("repeat_type <", value, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeLessThanOrEqualTo(String value) {
            addCriterion("repeat_type <=", value, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeLike(String value) {
            addCriterion("repeat_type like", value, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeNotLike(String value) {
            addCriterion("repeat_type not like", value, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeIn(List<String> values) {
            addCriterion("repeat_type in", values, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeNotIn(List<String> values) {
            addCriterion("repeat_type not in", values, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeBetween(String value1, String value2) {
            addCriterion("repeat_type between", value1, value2, "repeatType");
            return (Criteria) this;
        }

        public Criteria andRepeatTypeNotBetween(String value1, String value2) {
            addCriterion("repeat_type not between", value1, value2, "repeatType");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNull() {
            addCriterion("check_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNotNull() {
            addCriterion("check_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("check_start_time =", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("check_start_time <>", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("check_start_time >", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("check_start_time >=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("check_start_time <", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("check_start_time <=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("check_start_time in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("check_start_time not in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("check_start_time between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("check_start_time not between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNull() {
            addCriterion("check_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNotNull() {
            addCriterion("check_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("check_end_time =", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("check_end_time <>", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("check_end_time >", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("check_end_time >=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("check_end_time <", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("check_end_time <=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("check_end_time in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("check_end_time not in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("check_end_time between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("check_end_time not between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIsNull() {
            addCriterion("check_flag is null");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIsNotNull() {
            addCriterion("check_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCheckFlagEqualTo(String value) {
            addCriterion("check_flag =", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotEqualTo(String value) {
            addCriterion("check_flag <>", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagGreaterThan(String value) {
            addCriterion("check_flag >", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagGreaterThanOrEqualTo(String value) {
            addCriterion("check_flag >=", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLessThan(String value) {
            addCriterion("check_flag <", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLessThanOrEqualTo(String value) {
            addCriterion("check_flag <=", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLike(String value) {
            addCriterion("check_flag like", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotLike(String value) {
            addCriterion("check_flag not like", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIn(List<String> values) {
            addCriterion("check_flag in", values, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotIn(List<String> values) {
            addCriterion("check_flag not in", values, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagBetween(String value1, String value2) {
            addCriterion("check_flag between", value1, value2, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotBetween(String value1, String value2) {
            addCriterion("check_flag not between", value1, value2, "checkFlag");
            return (Criteria) this;
        }
    }

    /**
     * schedule_config
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * schedule_config null
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