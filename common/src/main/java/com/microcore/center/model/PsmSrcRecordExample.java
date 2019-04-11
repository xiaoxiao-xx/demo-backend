package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PsmSrcRecordExample {
    /**
     * psm_src_record_t
     */
    protected String orderByClause;

    /**
     * psm_src_record_t
     */
    protected boolean distinct;

    /**
     * psm_src_record_t
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public PsmSrcRecordExample() {
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
     * psm_src_record_t null
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceIsNull() {
            addCriterion("src_device is null");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceIsNotNull() {
            addCriterion("src_device is not null");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceEqualTo(String value) {
            addCriterion("src_device =", value, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceNotEqualTo(String value) {
            addCriterion("src_device <>", value, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceGreaterThan(String value) {
            addCriterion("src_device >", value, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("src_device >=", value, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceLessThan(String value) {
            addCriterion("src_device <", value, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceLessThanOrEqualTo(String value) {
            addCriterion("src_device <=", value, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceLike(String value) {
            addCriterion("src_device like", value, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceNotLike(String value) {
            addCriterion("src_device not like", value, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceIn(List<String> values) {
            addCriterion("src_device in", values, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceNotIn(List<String> values) {
            addCriterion("src_device not in", values, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceBetween(String value1, String value2) {
            addCriterion("src_device between", value1, value2, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andSrcDeviceNotBetween(String value1, String value2) {
            addCriterion("src_device not between", value1, value2, "srcDevice");
            return (Criteria) this;
        }

        public Criteria andCreateTypeIsNull() {
            addCriterion("create_type is null");
            return (Criteria) this;
        }

        public Criteria andCreateTypeIsNotNull() {
            addCriterion("create_type is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTypeEqualTo(String value) {
            addCriterion("create_type =", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeNotEqualTo(String value) {
            addCriterion("create_type <>", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeGreaterThan(String value) {
            addCriterion("create_type >", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("create_type >=", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeLessThan(String value) {
            addCriterion("create_type <", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeLessThanOrEqualTo(String value) {
            addCriterion("create_type <=", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeLike(String value) {
            addCriterion("create_type like", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeNotLike(String value) {
            addCriterion("create_type not like", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeIn(List<String> values) {
            addCriterion("create_type in", values, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeNotIn(List<String> values) {
            addCriterion("create_type not in", values, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeBetween(String value1, String value2) {
            addCriterion("create_type between", value1, value2, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeNotBetween(String value1, String value2) {
            addCriterion("create_type not between", value1, value2, "createType");
            return (Criteria) this;
        }

        public Criteria andGetObjectIsNull() {
            addCriterion("get_object is null");
            return (Criteria) this;
        }

        public Criteria andGetObjectIsNotNull() {
            addCriterion("get_object is not null");
            return (Criteria) this;
        }

        public Criteria andGetObjectEqualTo(String value) {
            addCriterion("get_object =", value, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectNotEqualTo(String value) {
            addCriterion("get_object <>", value, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectGreaterThan(String value) {
            addCriterion("get_object >", value, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectGreaterThanOrEqualTo(String value) {
            addCriterion("get_object >=", value, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectLessThan(String value) {
            addCriterion("get_object <", value, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectLessThanOrEqualTo(String value) {
            addCriterion("get_object <=", value, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectLike(String value) {
            addCriterion("get_object like", value, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectNotLike(String value) {
            addCriterion("get_object not like", value, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectIn(List<String> values) {
            addCriterion("get_object in", values, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectNotIn(List<String> values) {
            addCriterion("get_object not in", values, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectBetween(String value1, String value2) {
            addCriterion("get_object between", value1, value2, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetObjectNotBetween(String value1, String value2) {
            addCriterion("get_object not between", value1, value2, "getObject");
            return (Criteria) this;
        }

        public Criteria andGetEventIdIsNull() {
            addCriterion("get_event_id is null");
            return (Criteria) this;
        }

        public Criteria andGetEventIdIsNotNull() {
            addCriterion("get_event_id is not null");
            return (Criteria) this;
        }

        public Criteria andGetEventIdEqualTo(String value) {
            addCriterion("get_event_id =", value, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdNotEqualTo(String value) {
            addCriterion("get_event_id <>", value, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdGreaterThan(String value) {
            addCriterion("get_event_id >", value, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdGreaterThanOrEqualTo(String value) {
            addCriterion("get_event_id >=", value, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdLessThan(String value) {
            addCriterion("get_event_id <", value, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdLessThanOrEqualTo(String value) {
            addCriterion("get_event_id <=", value, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdLike(String value) {
            addCriterion("get_event_id like", value, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdNotLike(String value) {
            addCriterion("get_event_id not like", value, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdIn(List<String> values) {
            addCriterion("get_event_id in", values, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdNotIn(List<String> values) {
            addCriterion("get_event_id not in", values, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdBetween(String value1, String value2) {
            addCriterion("get_event_id between", value1, value2, "getEventId");
            return (Criteria) this;
        }

        public Criteria andGetEventIdNotBetween(String value1, String value2) {
            addCriterion("get_event_id not between", value1, value2, "getEventId");
            return (Criteria) this;
        }

        public Criteria andSrcTypeIsNull() {
            addCriterion("src_type is null");
            return (Criteria) this;
        }

        public Criteria andSrcTypeIsNotNull() {
            addCriterion("src_type is not null");
            return (Criteria) this;
        }

        public Criteria andSrcTypeEqualTo(String value) {
            addCriterion("src_type =", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeNotEqualTo(String value) {
            addCriterion("src_type <>", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeGreaterThan(String value) {
            addCriterion("src_type >", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("src_type >=", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeLessThan(String value) {
            addCriterion("src_type <", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeLessThanOrEqualTo(String value) {
            addCriterion("src_type <=", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeLike(String value) {
            addCriterion("src_type like", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeNotLike(String value) {
            addCriterion("src_type not like", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeIn(List<String> values) {
            addCriterion("src_type in", values, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeNotIn(List<String> values) {
            addCriterion("src_type not in", values, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeBetween(String value1, String value2) {
            addCriterion("src_type between", value1, value2, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeNotBetween(String value1, String value2) {
            addCriterion("src_type not between", value1, value2, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcAddressIsNull() {
            addCriterion("src_address is null");
            return (Criteria) this;
        }

        public Criteria andSrcAddressIsNotNull() {
            addCriterion("src_address is not null");
            return (Criteria) this;
        }

        public Criteria andSrcAddressEqualTo(String value) {
            addCriterion("src_address =", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressNotEqualTo(String value) {
            addCriterion("src_address <>", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressGreaterThan(String value) {
            addCriterion("src_address >", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressGreaterThanOrEqualTo(String value) {
            addCriterion("src_address >=", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressLessThan(String value) {
            addCriterion("src_address <", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressLessThanOrEqualTo(String value) {
            addCriterion("src_address <=", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressLike(String value) {
            addCriterion("src_address like", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressNotLike(String value) {
            addCriterion("src_address not like", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressIn(List<String> values) {
            addCriterion("src_address in", values, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressNotIn(List<String> values) {
            addCriterion("src_address not in", values, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressBetween(String value1, String value2) {
            addCriterion("src_address between", value1, value2, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressNotBetween(String value1, String value2) {
            addCriterion("src_address not between", value1, value2, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcStateIsNull() {
            addCriterion("src_state is null");
            return (Criteria) this;
        }

        public Criteria andSrcStateIsNotNull() {
            addCriterion("src_state is not null");
            return (Criteria) this;
        }

        public Criteria andSrcStateEqualTo(String value) {
            addCriterion("src_state =", value, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateNotEqualTo(String value) {
            addCriterion("src_state <>", value, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateGreaterThan(String value) {
            addCriterion("src_state >", value, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateGreaterThanOrEqualTo(String value) {
            addCriterion("src_state >=", value, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateLessThan(String value) {
            addCriterion("src_state <", value, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateLessThanOrEqualTo(String value) {
            addCriterion("src_state <=", value, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateLike(String value) {
            addCriterion("src_state like", value, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateNotLike(String value) {
            addCriterion("src_state not like", value, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateIn(List<String> values) {
            addCriterion("src_state in", values, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateNotIn(List<String> values) {
            addCriterion("src_state not in", values, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateBetween(String value1, String value2) {
            addCriterion("src_state between", value1, value2, "srcState");
            return (Criteria) this;
        }

        public Criteria andSrcStateNotBetween(String value1, String value2) {
            addCriterion("src_state not between", value1, value2, "srcState");
            return (Criteria) this;
        }
    }

    /**
     * psm_src_record_t
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * psm_src_record_t null
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