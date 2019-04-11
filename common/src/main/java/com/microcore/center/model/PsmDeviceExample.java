package com.microcore.center.model;

import java.util.ArrayList;
import java.util.List;

public class PsmDeviceExample {
    /**
     * psm_device_t
     */
    protected String orderByClause;

    /**
     * psm_device_t
     */
    protected boolean distinct;

    /**
     * psm_device_t
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public PsmDeviceExample() {
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
     * psm_device_t null
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeIsNull() {
            addCriterion("devtype_code is null");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeIsNotNull() {
            addCriterion("devtype_code is not null");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeEqualTo(String value) {
            addCriterion("devtype_code =", value, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeNotEqualTo(String value) {
            addCriterion("devtype_code <>", value, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeGreaterThan(String value) {
            addCriterion("devtype_code >", value, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("devtype_code >=", value, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeLessThan(String value) {
            addCriterion("devtype_code <", value, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeLessThanOrEqualTo(String value) {
            addCriterion("devtype_code <=", value, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeLike(String value) {
            addCriterion("devtype_code like", value, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeNotLike(String value) {
            addCriterion("devtype_code not like", value, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeIn(List<String> values) {
            addCriterion("devtype_code in", values, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeNotIn(List<String> values) {
            addCriterion("devtype_code not in", values, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeBetween(String value1, String value2) {
            addCriterion("devtype_code between", value1, value2, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeCodeNotBetween(String value1, String value2) {
            addCriterion("devtype_code not between", value1, value2, "devtypeCode");
            return (Criteria) this;
        }

        public Criteria andDevtypeValIsNull() {
            addCriterion("devtype_val is null");
            return (Criteria) this;
        }

        public Criteria andDevtypeValIsNotNull() {
            addCriterion("devtype_val is not null");
            return (Criteria) this;
        }

        public Criteria andDevtypeValEqualTo(String value) {
            addCriterion("devtype_val =", value, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValNotEqualTo(String value) {
            addCriterion("devtype_val <>", value, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValGreaterThan(String value) {
            addCriterion("devtype_val >", value, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValGreaterThanOrEqualTo(String value) {
            addCriterion("devtype_val >=", value, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValLessThan(String value) {
            addCriterion("devtype_val <", value, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValLessThanOrEqualTo(String value) {
            addCriterion("devtype_val <=", value, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValLike(String value) {
            addCriterion("devtype_val like", value, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValNotLike(String value) {
            addCriterion("devtype_val not like", value, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValIn(List<String> values) {
            addCriterion("devtype_val in", values, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValNotIn(List<String> values) {
            addCriterion("devtype_val not in", values, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValBetween(String value1, String value2) {
            addCriterion("devtype_val between", value1, value2, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDevtypeValNotBetween(String value1, String value2) {
            addCriterion("devtype_val not between", value1, value2, "devtypeVal");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionIsNull() {
            addCriterion("device_version is null");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionIsNotNull() {
            addCriterion("device_version is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionEqualTo(String value) {
            addCriterion("device_version =", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionNotEqualTo(String value) {
            addCriterion("device_version <>", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionGreaterThan(String value) {
            addCriterion("device_version >", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionGreaterThanOrEqualTo(String value) {
            addCriterion("device_version >=", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionLessThan(String value) {
            addCriterion("device_version <", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionLessThanOrEqualTo(String value) {
            addCriterion("device_version <=", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionLike(String value) {
            addCriterion("device_version like", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionNotLike(String value) {
            addCriterion("device_version not like", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionIn(List<String> values) {
            addCriterion("device_version in", values, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionNotIn(List<String> values) {
            addCriterion("device_version not in", values, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionBetween(String value1, String value2) {
            addCriterion("device_version between", value1, value2, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionNotBetween(String value1, String value2) {
            addCriterion("device_version not between", value1, value2, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andPositionXyIsNull() {
            addCriterion("position_xy is null");
            return (Criteria) this;
        }

        public Criteria andPositionXyIsNotNull() {
            addCriterion("position_xy is not null");
            return (Criteria) this;
        }

        public Criteria andPositionXyEqualTo(String value) {
            addCriterion("position_xy =", value, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyNotEqualTo(String value) {
            addCriterion("position_xy <>", value, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyGreaterThan(String value) {
            addCriterion("position_xy >", value, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyGreaterThanOrEqualTo(String value) {
            addCriterion("position_xy >=", value, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyLessThan(String value) {
            addCriterion("position_xy <", value, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyLessThanOrEqualTo(String value) {
            addCriterion("position_xy <=", value, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyLike(String value) {
            addCriterion("position_xy like", value, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyNotLike(String value) {
            addCriterion("position_xy not like", value, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyIn(List<String> values) {
            addCriterion("position_xy in", values, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyNotIn(List<String> values) {
            addCriterion("position_xy not in", values, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyBetween(String value1, String value2) {
            addCriterion("position_xy between", value1, value2, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionXyNotBetween(String value1, String value2) {
            addCriterion("position_xy not between", value1, value2, "positionXy");
            return (Criteria) this;
        }

        public Criteria andPositionAreaIsNull() {
            addCriterion("position_area is null");
            return (Criteria) this;
        }

        public Criteria andPositionAreaIsNotNull() {
            addCriterion("position_area is not null");
            return (Criteria) this;
        }

        public Criteria andPositionAreaEqualTo(String value) {
            addCriterion("position_area =", value, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaNotEqualTo(String value) {
            addCriterion("position_area <>", value, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaGreaterThan(String value) {
            addCriterion("position_area >", value, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaGreaterThanOrEqualTo(String value) {
            addCriterion("position_area >=", value, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaLessThan(String value) {
            addCriterion("position_area <", value, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaLessThanOrEqualTo(String value) {
            addCriterion("position_area <=", value, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaLike(String value) {
            addCriterion("position_area like", value, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaNotLike(String value) {
            addCriterion("position_area not like", value, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaIn(List<String> values) {
            addCriterion("position_area in", values, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaNotIn(List<String> values) {
            addCriterion("position_area not in", values, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaBetween(String value1, String value2) {
            addCriterion("position_area between", value1, value2, "positionArea");
            return (Criteria) this;
        }

        public Criteria andPositionAreaNotBetween(String value1, String value2) {
            addCriterion("position_area not between", value1, value2, "positionArea");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNull() {
            addCriterion("identifier is null");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNotNull() {
            addCriterion("identifier is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifierEqualTo(String value) {
            addCriterion("identifier =", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotEqualTo(String value) {
            addCriterion("identifier <>", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThan(String value) {
            addCriterion("identifier >", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThanOrEqualTo(String value) {
            addCriterion("identifier >=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThan(String value) {
            addCriterion("identifier <", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThanOrEqualTo(String value) {
            addCriterion("identifier <=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLike(String value) {
            addCriterion("identifier like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotLike(String value) {
            addCriterion("identifier not like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierIn(List<String> values) {
            addCriterion("identifier in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotIn(List<String> values) {
            addCriterion("identifier not in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierBetween(String value1, String value2) {
            addCriterion("identifier between", value1, value2, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotBetween(String value1, String value2) {
            addCriterion("identifier not between", value1, value2, "identifier");
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
    }

    /**
     * psm_device_t
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * psm_device_t null
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