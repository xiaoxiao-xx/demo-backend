package com.rainyhon.common.model;

import java.util.ArrayList;
import java.util.List;

public class DeviceVersionExample {
    /**
     * device_version
     */
    protected String orderByClause;

    /**
     * device_version
     */
    protected boolean distinct;

    /**
     * device_version
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DeviceVersionExample() {
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
     * device_version null
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

        public Criteria andDevversionIdIsNull() {
            addCriterion("devversion_id is null");
            return (Criteria) this;
        }

        public Criteria andDevversionIdIsNotNull() {
            addCriterion("devversion_id is not null");
            return (Criteria) this;
        }

        public Criteria andDevversionIdEqualTo(String value) {
            addCriterion("devversion_id =", value, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdNotEqualTo(String value) {
            addCriterion("devversion_id <>", value, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdGreaterThan(String value) {
            addCriterion("devversion_id >", value, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdGreaterThanOrEqualTo(String value) {
            addCriterion("devversion_id >=", value, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdLessThan(String value) {
            addCriterion("devversion_id <", value, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdLessThanOrEqualTo(String value) {
            addCriterion("devversion_id <=", value, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdLike(String value) {
            addCriterion("devversion_id like", value, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdNotLike(String value) {
            addCriterion("devversion_id not like", value, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdIn(List<String> values) {
            addCriterion("devversion_id in", values, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdNotIn(List<String> values) {
            addCriterion("devversion_id not in", values, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdBetween(String value1, String value2) {
            addCriterion("devversion_id between", value1, value2, "devversionId");
            return (Criteria) this;
        }

        public Criteria andDevversionIdNotBetween(String value1, String value2) {
            addCriterion("devversion_id not between", value1, value2, "devversionId");
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

        public Criteria andDeviceFirmIsNull() {
            addCriterion("device_firm is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmIsNotNull() {
            addCriterion("device_firm is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmEqualTo(String value) {
            addCriterion("device_firm =", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmNotEqualTo(String value) {
            addCriterion("device_firm <>", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmGreaterThan(String value) {
            addCriterion("device_firm >", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmGreaterThanOrEqualTo(String value) {
            addCriterion("device_firm >=", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmLessThan(String value) {
            addCriterion("device_firm <", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmLessThanOrEqualTo(String value) {
            addCriterion("device_firm <=", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmLike(String value) {
            addCriterion("device_firm like", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmNotLike(String value) {
            addCriterion("device_firm not like", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmIn(List<String> values) {
            addCriterion("device_firm in", values, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmNotIn(List<String> values) {
            addCriterion("device_firm not in", values, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmBetween(String value1, String value2) {
            addCriterion("device_firm between", value1, value2, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmNotBetween(String value1, String value2) {
            addCriterion("device_firm not between", value1, value2, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andParaIsNull() {
            addCriterion("para is null");
            return (Criteria) this;
        }

        public Criteria andParaIsNotNull() {
            addCriterion("para is not null");
            return (Criteria) this;
        }

        public Criteria andParaEqualTo(String value) {
            addCriterion("para =", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotEqualTo(String value) {
            addCriterion("para <>", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaGreaterThan(String value) {
            addCriterion("para >", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaGreaterThanOrEqualTo(String value) {
            addCriterion("para >=", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaLessThan(String value) {
            addCriterion("para <", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaLessThanOrEqualTo(String value) {
            addCriterion("para <=", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaLike(String value) {
            addCriterion("para like", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotLike(String value) {
            addCriterion("para not like", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaIn(List<String> values) {
            addCriterion("para in", values, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotIn(List<String> values) {
            addCriterion("para not in", values, "para");
            return (Criteria) this;
        }

        public Criteria andParaBetween(String value1, String value2) {
            addCriterion("para between", value1, value2, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotBetween(String value1, String value2) {
            addCriterion("para not between", value1, value2, "para");
            return (Criteria) this;
        }
    }

    /**
     * device_version
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * device_version null
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