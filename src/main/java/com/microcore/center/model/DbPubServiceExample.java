package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DbPubServiceExample {
    /**
     * db_pub_service_copy
     */
    protected String orderByClause;

    /**
     * db_pub_service_copy
     */
    protected boolean distinct;

    /**
     * db_pub_service_copy
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbPubServiceExample() {
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
     * db_pub_service_copy null
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlIsNull() {
            addCriterion("interface_url is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlIsNotNull() {
            addCriterion("interface_url is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlEqualTo(String value) {
            addCriterion("interface_url =", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotEqualTo(String value) {
            addCriterion("interface_url <>", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlGreaterThan(String value) {
            addCriterion("interface_url >", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("interface_url >=", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlLessThan(String value) {
            addCriterion("interface_url <", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlLessThanOrEqualTo(String value) {
            addCriterion("interface_url <=", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlLike(String value) {
            addCriterion("interface_url like", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotLike(String value) {
            addCriterion("interface_url not like", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlIn(List<String> values) {
            addCriterion("interface_url in", values, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotIn(List<String> values) {
            addCriterion("interface_url not in", values, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlBetween(String value1, String value2) {
            addCriterion("interface_url between", value1, value2, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotBetween(String value1, String value2) {
            addCriterion("interface_url not between", value1, value2, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andTargetIpIsNull() {
            addCriterion("target_ip is null");
            return (Criteria) this;
        }

        public Criteria andTargetIpIsNotNull() {
            addCriterion("target_ip is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIpEqualTo(String value) {
            addCriterion("target_ip =", value, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpNotEqualTo(String value) {
            addCriterion("target_ip <>", value, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpGreaterThan(String value) {
            addCriterion("target_ip >", value, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpGreaterThanOrEqualTo(String value) {
            addCriterion("target_ip >=", value, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpLessThan(String value) {
            addCriterion("target_ip <", value, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpLessThanOrEqualTo(String value) {
            addCriterion("target_ip <=", value, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpLike(String value) {
            addCriterion("target_ip like", value, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpNotLike(String value) {
            addCriterion("target_ip not like", value, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpIn(List<String> values) {
            addCriterion("target_ip in", values, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpNotIn(List<String> values) {
            addCriterion("target_ip not in", values, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpBetween(String value1, String value2) {
            addCriterion("target_ip between", value1, value2, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetIpNotBetween(String value1, String value2) {
            addCriterion("target_ip not between", value1, value2, "targetIp");
            return (Criteria) this;
        }

        public Criteria andTargetPortIsNull() {
            addCriterion("target_port is null");
            return (Criteria) this;
        }

        public Criteria andTargetPortIsNotNull() {
            addCriterion("target_port is not null");
            return (Criteria) this;
        }

        public Criteria andTargetPortEqualTo(Integer value) {
            addCriterion("target_port =", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortNotEqualTo(Integer value) {
            addCriterion("target_port <>", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortGreaterThan(Integer value) {
            addCriterion("target_port >", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_port >=", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortLessThan(Integer value) {
            addCriterion("target_port <", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortLessThanOrEqualTo(Integer value) {
            addCriterion("target_port <=", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortIn(List<Integer> values) {
            addCriterion("target_port in", values, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortNotIn(List<Integer> values) {
            addCriterion("target_port not in", values, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortBetween(Integer value1, Integer value2) {
            addCriterion("target_port between", value1, value2, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortNotBetween(Integer value1, Integer value2) {
            addCriterion("target_port not between", value1, value2, "targetPort");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIsNull() {
            addCriterion("interface_name is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIsNotNull() {
            addCriterion("interface_name is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameEqualTo(String value) {
            addCriterion("interface_name =", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotEqualTo(String value) {
            addCriterion("interface_name <>", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThan(String value) {
            addCriterion("interface_name >", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("interface_name >=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThan(String value) {
            addCriterion("interface_name <", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThanOrEqualTo(String value) {
            addCriterion("interface_name <=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLike(String value) {
            addCriterion("interface_name like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotLike(String value) {
            addCriterion("interface_name not like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIn(List<String> values) {
            addCriterion("interface_name in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotIn(List<String> values) {
            addCriterion("interface_name not in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameBetween(String value1, String value2) {
            addCriterion("interface_name between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotBetween(String value1, String value2) {
            addCriterion("interface_name not between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeIsNull() {
            addCriterion("interface_type is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeIsNotNull() {
            addCriterion("interface_type is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeEqualTo(String value) {
            addCriterion("interface_type =", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotEqualTo(String value) {
            addCriterion("interface_type <>", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeGreaterThan(String value) {
            addCriterion("interface_type >", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("interface_type >=", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeLessThan(String value) {
            addCriterion("interface_type <", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeLessThanOrEqualTo(String value) {
            addCriterion("interface_type <=", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeLike(String value) {
            addCriterion("interface_type like", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotLike(String value) {
            addCriterion("interface_type not like", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeIn(List<String> values) {
            addCriterion("interface_type in", values, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotIn(List<String> values) {
            addCriterion("interface_type not in", values, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeBetween(String value1, String value2) {
            addCriterion("interface_type between", value1, value2, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotBetween(String value1, String value2) {
            addCriterion("interface_type not between", value1, value2, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andRequestModeIsNull() {
            addCriterion("request_mode is null");
            return (Criteria) this;
        }

        public Criteria andRequestModeIsNotNull() {
            addCriterion("request_mode is not null");
            return (Criteria) this;
        }

        public Criteria andRequestModeEqualTo(String value) {
            addCriterion("request_mode =", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeNotEqualTo(String value) {
            addCriterion("request_mode <>", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeGreaterThan(String value) {
            addCriterion("request_mode >", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeGreaterThanOrEqualTo(String value) {
            addCriterion("request_mode >=", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeLessThan(String value) {
            addCriterion("request_mode <", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeLessThanOrEqualTo(String value) {
            addCriterion("request_mode <=", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeLike(String value) {
            addCriterion("request_mode like", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeNotLike(String value) {
            addCriterion("request_mode not like", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeIn(List<String> values) {
            addCriterion("request_mode in", values, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeNotIn(List<String> values) {
            addCriterion("request_mode not in", values, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeBetween(String value1, String value2) {
            addCriterion("request_mode between", value1, value2, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeNotBetween(String value1, String value2) {
            addCriterion("request_mode not between", value1, value2, "requestMode");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameIsNull() {
            addCriterion("wsdl_method_name is null");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameIsNotNull() {
            addCriterion("wsdl_method_name is not null");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameEqualTo(String value) {
            addCriterion("wsdl_method_name =", value, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameNotEqualTo(String value) {
            addCriterion("wsdl_method_name <>", value, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameGreaterThan(String value) {
            addCriterion("wsdl_method_name >", value, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("wsdl_method_name >=", value, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameLessThan(String value) {
            addCriterion("wsdl_method_name <", value, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameLessThanOrEqualTo(String value) {
            addCriterion("wsdl_method_name <=", value, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameLike(String value) {
            addCriterion("wsdl_method_name like", value, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameNotLike(String value) {
            addCriterion("wsdl_method_name not like", value, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameIn(List<String> values) {
            addCriterion("wsdl_method_name in", values, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameNotIn(List<String> values) {
            addCriterion("wsdl_method_name not in", values, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameBetween(String value1, String value2) {
            addCriterion("wsdl_method_name between", value1, value2, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andWsdlMethodNameNotBetween(String value1, String value2) {
            addCriterion("wsdl_method_name not between", value1, value2, "wsdlMethodName");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeIsNull() {
            addCriterion("chinese_describe is null");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeIsNotNull() {
            addCriterion("chinese_describe is not null");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeEqualTo(String value) {
            addCriterion("chinese_describe =", value, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeNotEqualTo(String value) {
            addCriterion("chinese_describe <>", value, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeGreaterThan(String value) {
            addCriterion("chinese_describe >", value, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("chinese_describe >=", value, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeLessThan(String value) {
            addCriterion("chinese_describe <", value, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeLessThanOrEqualTo(String value) {
            addCriterion("chinese_describe <=", value, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeLike(String value) {
            addCriterion("chinese_describe like", value, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeNotLike(String value) {
            addCriterion("chinese_describe not like", value, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeIn(List<String> values) {
            addCriterion("chinese_describe in", values, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeNotIn(List<String> values) {
            addCriterion("chinese_describe not in", values, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeBetween(String value1, String value2) {
            addCriterion("chinese_describe between", value1, value2, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andChineseDescribeNotBetween(String value1, String value2) {
            addCriterion("chinese_describe not between", value1, value2, "chineseDescribe");
            return (Criteria) this;
        }

        public Criteria andWordExampleIsNull() {
            addCriterion("word_example is null");
            return (Criteria) this;
        }

        public Criteria andWordExampleIsNotNull() {
            addCriterion("word_example is not null");
            return (Criteria) this;
        }

        public Criteria andWordExampleEqualTo(String value) {
            addCriterion("word_example =", value, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleNotEqualTo(String value) {
            addCriterion("word_example <>", value, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleGreaterThan(String value) {
            addCriterion("word_example >", value, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleGreaterThanOrEqualTo(String value) {
            addCriterion("word_example >=", value, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleLessThan(String value) {
            addCriterion("word_example <", value, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleLessThanOrEqualTo(String value) {
            addCriterion("word_example <=", value, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleLike(String value) {
            addCriterion("word_example like", value, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleNotLike(String value) {
            addCriterion("word_example not like", value, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleIn(List<String> values) {
            addCriterion("word_example in", values, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleNotIn(List<String> values) {
            addCriterion("word_example not in", values, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleBetween(String value1, String value2) {
            addCriterion("word_example between", value1, value2, "wordExample");
            return (Criteria) this;
        }

        public Criteria andWordExampleNotBetween(String value1, String value2) {
            addCriterion("word_example not between", value1, value2, "wordExample");
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

        public Criteria andUseFrequencyIsNull() {
            addCriterion("use_frequency is null");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyIsNotNull() {
            addCriterion("use_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyEqualTo(Integer value) {
            addCriterion("use_frequency =", value, "useFrequency");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyNotEqualTo(Integer value) {
            addCriterion("use_frequency <>", value, "useFrequency");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyGreaterThan(Integer value) {
            addCriterion("use_frequency >", value, "useFrequency");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_frequency >=", value, "useFrequency");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyLessThan(Integer value) {
            addCriterion("use_frequency <", value, "useFrequency");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("use_frequency <=", value, "useFrequency");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyIn(List<Integer> values) {
            addCriterion("use_frequency in", values, "useFrequency");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyNotIn(List<Integer> values) {
            addCriterion("use_frequency not in", values, "useFrequency");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("use_frequency between", value1, value2, "useFrequency");
            return (Criteria) this;
        }

        public Criteria andUseFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("use_frequency not between", value1, value2, "useFrequency");
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
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
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
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
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

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("data_type like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("data_type not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andSecondAuthIsNull() {
            addCriterion("second_auth is null");
            return (Criteria) this;
        }

        public Criteria andSecondAuthIsNotNull() {
            addCriterion("second_auth is not null");
            return (Criteria) this;
        }

        public Criteria andSecondAuthEqualTo(String value) {
            addCriterion("second_auth =", value, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthNotEqualTo(String value) {
            addCriterion("second_auth <>", value, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthGreaterThan(String value) {
            addCriterion("second_auth >", value, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthGreaterThanOrEqualTo(String value) {
            addCriterion("second_auth >=", value, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthLessThan(String value) {
            addCriterion("second_auth <", value, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthLessThanOrEqualTo(String value) {
            addCriterion("second_auth <=", value, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthLike(String value) {
            addCriterion("second_auth like", value, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthNotLike(String value) {
            addCriterion("second_auth not like", value, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthIn(List<String> values) {
            addCriterion("second_auth in", values, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthNotIn(List<String> values) {
            addCriterion("second_auth not in", values, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthBetween(String value1, String value2) {
            addCriterion("second_auth between", value1, value2, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andSecondAuthNotBetween(String value1, String value2) {
            addCriterion("second_auth not between", value1, value2, "secondAuth");
            return (Criteria) this;
        }

        public Criteria andReportSituationIsNull() {
            addCriterion("report_situation is null");
            return (Criteria) this;
        }

        public Criteria andReportSituationIsNotNull() {
            addCriterion("report_situation is not null");
            return (Criteria) this;
        }

        public Criteria andReportSituationEqualTo(String value) {
            addCriterion("report_situation =", value, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationNotEqualTo(String value) {
            addCriterion("report_situation <>", value, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationGreaterThan(String value) {
            addCriterion("report_situation >", value, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationGreaterThanOrEqualTo(String value) {
            addCriterion("report_situation >=", value, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationLessThan(String value) {
            addCriterion("report_situation <", value, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationLessThanOrEqualTo(String value) {
            addCriterion("report_situation <=", value, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationLike(String value) {
            addCriterion("report_situation like", value, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationNotLike(String value) {
            addCriterion("report_situation not like", value, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationIn(List<String> values) {
            addCriterion("report_situation in", values, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationNotIn(List<String> values) {
            addCriterion("report_situation not in", values, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationBetween(String value1, String value2) {
            addCriterion("report_situation between", value1, value2, "reportSituation");
            return (Criteria) this;
        }

        public Criteria andReportSituationNotBetween(String value1, String value2) {
            addCriterion("report_situation not between", value1, value2, "reportSituation");
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

        public Criteria andCoverTypeIsNull() {
            addCriterion("cover_type is null");
            return (Criteria) this;
        }

        public Criteria andCoverTypeIsNotNull() {
            addCriterion("cover_type is not null");
            return (Criteria) this;
        }

        public Criteria andCoverTypeEqualTo(String value) {
            addCriterion("cover_type =", value, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeNotEqualTo(String value) {
            addCriterion("cover_type <>", value, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeGreaterThan(String value) {
            addCriterion("cover_type >", value, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cover_type >=", value, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeLessThan(String value) {
            addCriterion("cover_type <", value, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeLessThanOrEqualTo(String value) {
            addCriterion("cover_type <=", value, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeLike(String value) {
            addCriterion("cover_type like", value, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeNotLike(String value) {
            addCriterion("cover_type not like", value, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeIn(List<String> values) {
            addCriterion("cover_type in", values, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeNotIn(List<String> values) {
            addCriterion("cover_type not in", values, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeBetween(String value1, String value2) {
            addCriterion("cover_type between", value1, value2, "coverType");
            return (Criteria) this;
        }

        public Criteria andCoverTypeNotBetween(String value1, String value2) {
            addCriterion("cover_type not between", value1, value2, "coverType");
            return (Criteria) this;
        }

        public Criteria andProxyIpIsNull() {
            addCriterion("proxy_ip is null");
            return (Criteria) this;
        }

        public Criteria andProxyIpIsNotNull() {
            addCriterion("proxy_ip is not null");
            return (Criteria) this;
        }

        public Criteria andProxyIpEqualTo(String value) {
            addCriterion("proxy_ip =", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpNotEqualTo(String value) {
            addCriterion("proxy_ip <>", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpGreaterThan(String value) {
            addCriterion("proxy_ip >", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_ip >=", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpLessThan(String value) {
            addCriterion("proxy_ip <", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpLessThanOrEqualTo(String value) {
            addCriterion("proxy_ip <=", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpLike(String value) {
            addCriterion("proxy_ip like", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpNotLike(String value) {
            addCriterion("proxy_ip not like", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpIn(List<String> values) {
            addCriterion("proxy_ip in", values, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpNotIn(List<String> values) {
            addCriterion("proxy_ip not in", values, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpBetween(String value1, String value2) {
            addCriterion("proxy_ip between", value1, value2, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpNotBetween(String value1, String value2) {
            addCriterion("proxy_ip not between", value1, value2, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyPortIsNull() {
            addCriterion("proxy_port is null");
            return (Criteria) this;
        }

        public Criteria andProxyPortIsNotNull() {
            addCriterion("proxy_port is not null");
            return (Criteria) this;
        }

        public Criteria andProxyPortEqualTo(Integer value) {
            addCriterion("proxy_port =", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortNotEqualTo(Integer value) {
            addCriterion("proxy_port <>", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortGreaterThan(Integer value) {
            addCriterion("proxy_port >", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("proxy_port >=", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortLessThan(Integer value) {
            addCriterion("proxy_port <", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortLessThanOrEqualTo(Integer value) {
            addCriterion("proxy_port <=", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortIn(List<Integer> values) {
            addCriterion("proxy_port in", values, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortNotIn(List<Integer> values) {
            addCriterion("proxy_port not in", values, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortBetween(Integer value1, Integer value2) {
            addCriterion("proxy_port between", value1, value2, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortNotBetween(Integer value1, Integer value2) {
            addCriterion("proxy_port not between", value1, value2, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameIsNull() {
            addCriterion("proxy_interface_name is null");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameIsNotNull() {
            addCriterion("proxy_interface_name is not null");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameEqualTo(String value) {
            addCriterion("proxy_interface_name =", value, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameNotEqualTo(String value) {
            addCriterion("proxy_interface_name <>", value, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameGreaterThan(String value) {
            addCriterion("proxy_interface_name >", value, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_interface_name >=", value, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameLessThan(String value) {
            addCriterion("proxy_interface_name <", value, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameLessThanOrEqualTo(String value) {
            addCriterion("proxy_interface_name <=", value, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameLike(String value) {
            addCriterion("proxy_interface_name like", value, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameNotLike(String value) {
            addCriterion("proxy_interface_name not like", value, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameIn(List<String> values) {
            addCriterion("proxy_interface_name in", values, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameNotIn(List<String> values) {
            addCriterion("proxy_interface_name not in", values, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameBetween(String value1, String value2) {
            addCriterion("proxy_interface_name between", value1, value2, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andProxyInterfaceNameNotBetween(String value1, String value2) {
            addCriterion("proxy_interface_name not between", value1, value2, "proxyInterfaceName");
            return (Criteria) this;
        }

        public Criteria andIsSignIsNull() {
            addCriterion("is_sign is null");
            return (Criteria) this;
        }

        public Criteria andIsSignIsNotNull() {
            addCriterion("is_sign is not null");
            return (Criteria) this;
        }

        public Criteria andIsSignEqualTo(String value) {
            addCriterion("is_sign =", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignNotEqualTo(String value) {
            addCriterion("is_sign <>", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignGreaterThan(String value) {
            addCriterion("is_sign >", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignGreaterThanOrEqualTo(String value) {
            addCriterion("is_sign >=", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignLessThan(String value) {
            addCriterion("is_sign <", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignLessThanOrEqualTo(String value) {
            addCriterion("is_sign <=", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignLike(String value) {
            addCriterion("is_sign like", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignNotLike(String value) {
            addCriterion("is_sign not like", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignIn(List<String> values) {
            addCriterion("is_sign in", values, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignNotIn(List<String> values) {
            addCriterion("is_sign not in", values, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignBetween(String value1, String value2) {
            addCriterion("is_sign between", value1, value2, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignNotBetween(String value1, String value2) {
            addCriterion("is_sign not between", value1, value2, "isSign");
            return (Criteria) this;
        }

        public Criteria andPubStatusIsNull() {
            addCriterion("pub_status is null");
            return (Criteria) this;
        }

        public Criteria andPubStatusIsNotNull() {
            addCriterion("pub_status is not null");
            return (Criteria) this;
        }

        public Criteria andPubStatusEqualTo(String value) {
            addCriterion("pub_status =", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusNotEqualTo(String value) {
            addCriterion("pub_status <>", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusGreaterThan(String value) {
            addCriterion("pub_status >", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pub_status >=", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusLessThan(String value) {
            addCriterion("pub_status <", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusLessThanOrEqualTo(String value) {
            addCriterion("pub_status <=", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusLike(String value) {
            addCriterion("pub_status like", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusNotLike(String value) {
            addCriterion("pub_status not like", value, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusIn(List<String> values) {
            addCriterion("pub_status in", values, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusNotIn(List<String> values) {
            addCriterion("pub_status not in", values, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusBetween(String value1, String value2) {
            addCriterion("pub_status between", value1, value2, "pubStatus");
            return (Criteria) this;
        }

        public Criteria andPubStatusNotBetween(String value1, String value2) {
            addCriterion("pub_status not between", value1, value2, "pubStatus");
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
     * db_pub_service_copy
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_pub_service_copy null
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