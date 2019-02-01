package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbDbKitExample {
    /**
     * db_db_kit
     */
    protected String orderByClause;

    /**
     * db_db_kit
     */
    protected boolean distinct;

    /**
     * db_db_kit
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbDbKitExample() {
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
     * db_db_kit null
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

        public Criteria andLabelIdIsNull() {
            addCriterion("label_id is null");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNotNull() {
            addCriterion("label_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabelIdEqualTo(String value) {
            addCriterion("label_id =", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotEqualTo(String value) {
            addCriterion("label_id <>", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThan(String value) {
            addCriterion("label_id >", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThanOrEqualTo(String value) {
            addCriterion("label_id >=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThan(String value) {
            addCriterion("label_id <", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThanOrEqualTo(String value) {
            addCriterion("label_id <=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLike(String value) {
            addCriterion("label_id like", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotLike(String value) {
            addCriterion("label_id not like", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdIn(List<String> values) {
            addCriterion("label_id in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotIn(List<String> values) {
            addCriterion("label_id not in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdBetween(String value1, String value2) {
            addCriterion("label_id between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotBetween(String value1, String value2) {
            addCriterion("label_id not between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNull() {
            addCriterion("tag_name is null");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNotNull() {
            addCriterion("tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andTagNameEqualTo(String value) {
            addCriterion("tag_name =", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotEqualTo(String value) {
            addCriterion("tag_name <>", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThan(String value) {
            addCriterion("tag_name >", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("tag_name >=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThan(String value) {
            addCriterion("tag_name <", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThanOrEqualTo(String value) {
            addCriterion("tag_name <=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLike(String value) {
            addCriterion("tag_name like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotLike(String value) {
            addCriterion("tag_name not like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameIn(List<String> values) {
            addCriterion("tag_name in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotIn(List<String> values) {
            addCriterion("tag_name not in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameBetween(String value1, String value2) {
            addCriterion("tag_name between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotBetween(String value1, String value2) {
            addCriterion("tag_name not between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagTypeIsNull() {
            addCriterion("tag_type is null");
            return (Criteria) this;
        }

        public Criteria andTagTypeIsNotNull() {
            addCriterion("tag_type is not null");
            return (Criteria) this;
        }

        public Criteria andTagTypeEqualTo(String value) {
            addCriterion("tag_type =", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotEqualTo(String value) {
            addCriterion("tag_type <>", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeGreaterThan(String value) {
            addCriterion("tag_type >", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeGreaterThanOrEqualTo(String value) {
            addCriterion("tag_type >=", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeLessThan(String value) {
            addCriterion("tag_type <", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeLessThanOrEqualTo(String value) {
            addCriterion("tag_type <=", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeLike(String value) {
            addCriterion("tag_type like", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotLike(String value) {
            addCriterion("tag_type not like", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeIn(List<String> values) {
            addCriterion("tag_type in", values, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotIn(List<String> values) {
            addCriterion("tag_type not in", values, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeBetween(String value1, String value2) {
            addCriterion("tag_type between", value1, value2, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotBetween(String value1, String value2) {
            addCriterion("tag_type not between", value1, value2, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagIpIsNull() {
            addCriterion("tag_ip is null");
            return (Criteria) this;
        }

        public Criteria andTagIpIsNotNull() {
            addCriterion("tag_ip is not null");
            return (Criteria) this;
        }

        public Criteria andTagIpEqualTo(String value) {
            addCriterion("tag_ip =", value, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpNotEqualTo(String value) {
            addCriterion("tag_ip <>", value, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpGreaterThan(String value) {
            addCriterion("tag_ip >", value, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpGreaterThanOrEqualTo(String value) {
            addCriterion("tag_ip >=", value, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpLessThan(String value) {
            addCriterion("tag_ip <", value, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpLessThanOrEqualTo(String value) {
            addCriterion("tag_ip <=", value, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpLike(String value) {
            addCriterion("tag_ip like", value, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpNotLike(String value) {
            addCriterion("tag_ip not like", value, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpIn(List<String> values) {
            addCriterion("tag_ip in", values, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpNotIn(List<String> values) {
            addCriterion("tag_ip not in", values, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpBetween(String value1, String value2) {
            addCriterion("tag_ip between", value1, value2, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagIpNotBetween(String value1, String value2) {
            addCriterion("tag_ip not between", value1, value2, "tagIp");
            return (Criteria) this;
        }

        public Criteria andTagPortIsNull() {
            addCriterion("tag_port is null");
            return (Criteria) this;
        }

        public Criteria andTagPortIsNotNull() {
            addCriterion("tag_port is not null");
            return (Criteria) this;
        }

        public Criteria andTagPortEqualTo(String value) {
            addCriterion("tag_port =", value, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortNotEqualTo(String value) {
            addCriterion("tag_port <>", value, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortGreaterThan(String value) {
            addCriterion("tag_port >", value, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortGreaterThanOrEqualTo(String value) {
            addCriterion("tag_port >=", value, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortLessThan(String value) {
            addCriterion("tag_port <", value, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortLessThanOrEqualTo(String value) {
            addCriterion("tag_port <=", value, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortLike(String value) {
            addCriterion("tag_port like", value, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortNotLike(String value) {
            addCriterion("tag_port not like", value, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortIn(List<String> values) {
            addCriterion("tag_port in", values, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortNotIn(List<String> values) {
            addCriterion("tag_port not in", values, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortBetween(String value1, String value2) {
            addCriterion("tag_port between", value1, value2, "tagPort");
            return (Criteria) this;
        }

        public Criteria andTagPortNotBetween(String value1, String value2) {
            addCriterion("tag_port not between", value1, value2, "tagPort");
            return (Criteria) this;
        }

        public Criteria andMacAddressIsNull() {
            addCriterion("mac_address is null");
            return (Criteria) this;
        }

        public Criteria andMacAddressIsNotNull() {
            addCriterion("mac_address is not null");
            return (Criteria) this;
        }

        public Criteria andMacAddressEqualTo(String value) {
            addCriterion("mac_address =", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotEqualTo(String value) {
            addCriterion("mac_address <>", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressGreaterThan(String value) {
            addCriterion("mac_address >", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mac_address >=", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressLessThan(String value) {
            addCriterion("mac_address <", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressLessThanOrEqualTo(String value) {
            addCriterion("mac_address <=", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressLike(String value) {
            addCriterion("mac_address like", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotLike(String value) {
            addCriterion("mac_address not like", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressIn(List<String> values) {
            addCriterion("mac_address in", values, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotIn(List<String> values) {
            addCriterion("mac_address not in", values, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressBetween(String value1, String value2) {
            addCriterion("mac_address between", value1, value2, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotBetween(String value1, String value2) {
            addCriterion("mac_address not between", value1, value2, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMakeIpIsNull() {
            addCriterion("make_ip is null");
            return (Criteria) this;
        }

        public Criteria andMakeIpIsNotNull() {
            addCriterion("make_ip is not null");
            return (Criteria) this;
        }

        public Criteria andMakeIpEqualTo(String value) {
            addCriterion("make_ip =", value, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpNotEqualTo(String value) {
            addCriterion("make_ip <>", value, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpGreaterThan(String value) {
            addCriterion("make_ip >", value, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpGreaterThanOrEqualTo(String value) {
            addCriterion("make_ip >=", value, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpLessThan(String value) {
            addCriterion("make_ip <", value, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpLessThanOrEqualTo(String value) {
            addCriterion("make_ip <=", value, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpLike(String value) {
            addCriterion("make_ip like", value, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpNotLike(String value) {
            addCriterion("make_ip not like", value, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpIn(List<String> values) {
            addCriterion("make_ip in", values, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpNotIn(List<String> values) {
            addCriterion("make_ip not in", values, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpBetween(String value1, String value2) {
            addCriterion("make_ip between", value1, value2, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakeIpNotBetween(String value1, String value2) {
            addCriterion("make_ip not between", value1, value2, "makeIp");
            return (Criteria) this;
        }

        public Criteria andMakePortIsNull() {
            addCriterion("make_port is null");
            return (Criteria) this;
        }

        public Criteria andMakePortIsNotNull() {
            addCriterion("make_port is not null");
            return (Criteria) this;
        }

        public Criteria andMakePortEqualTo(String value) {
            addCriterion("make_port =", value, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortNotEqualTo(String value) {
            addCriterion("make_port <>", value, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortGreaterThan(String value) {
            addCriterion("make_port >", value, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortGreaterThanOrEqualTo(String value) {
            addCriterion("make_port >=", value, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortLessThan(String value) {
            addCriterion("make_port <", value, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortLessThanOrEqualTo(String value) {
            addCriterion("make_port <=", value, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortLike(String value) {
            addCriterion("make_port like", value, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortNotLike(String value) {
            addCriterion("make_port not like", value, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortIn(List<String> values) {
            addCriterion("make_port in", values, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortNotIn(List<String> values) {
            addCriterion("make_port not in", values, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortBetween(String value1, String value2) {
            addCriterion("make_port between", value1, value2, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakePortNotBetween(String value1, String value2) {
            addCriterion("make_port not between", value1, value2, "makePort");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeIsNull() {
            addCriterion("make_db_type is null");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeIsNotNull() {
            addCriterion("make_db_type is not null");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeEqualTo(String value) {
            addCriterion("make_db_type =", value, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeNotEqualTo(String value) {
            addCriterion("make_db_type <>", value, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeGreaterThan(String value) {
            addCriterion("make_db_type >", value, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeGreaterThanOrEqualTo(String value) {
            addCriterion("make_db_type >=", value, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeLessThan(String value) {
            addCriterion("make_db_type <", value, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeLessThanOrEqualTo(String value) {
            addCriterion("make_db_type <=", value, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeLike(String value) {
            addCriterion("make_db_type like", value, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeNotLike(String value) {
            addCriterion("make_db_type not like", value, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeIn(List<String> values) {
            addCriterion("make_db_type in", values, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeNotIn(List<String> values) {
            addCriterion("make_db_type not in", values, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeBetween(String value1, String value2) {
            addCriterion("make_db_type between", value1, value2, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeDbTypeNotBetween(String value1, String value2) {
            addCriterion("make_db_type not between", value1, value2, "makeDbType");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameIsNull() {
            addCriterion("make_user_name is null");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameIsNotNull() {
            addCriterion("make_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameEqualTo(String value) {
            addCriterion("make_user_name =", value, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameNotEqualTo(String value) {
            addCriterion("make_user_name <>", value, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameGreaterThan(String value) {
            addCriterion("make_user_name >", value, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("make_user_name >=", value, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameLessThan(String value) {
            addCriterion("make_user_name <", value, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameLessThanOrEqualTo(String value) {
            addCriterion("make_user_name <=", value, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameLike(String value) {
            addCriterion("make_user_name like", value, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameNotLike(String value) {
            addCriterion("make_user_name not like", value, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameIn(List<String> values) {
            addCriterion("make_user_name in", values, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameNotIn(List<String> values) {
            addCriterion("make_user_name not in", values, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameBetween(String value1, String value2) {
            addCriterion("make_user_name between", value1, value2, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakeUserNameNotBetween(String value1, String value2) {
            addCriterion("make_user_name not between", value1, value2, "makeUserName");
            return (Criteria) this;
        }

        public Criteria andMakePasswordIsNull() {
            addCriterion("make_password is null");
            return (Criteria) this;
        }

        public Criteria andMakePasswordIsNotNull() {
            addCriterion("make_password is not null");
            return (Criteria) this;
        }

        public Criteria andMakePasswordEqualTo(String value) {
            addCriterion("make_password =", value, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordNotEqualTo(String value) {
            addCriterion("make_password <>", value, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordGreaterThan(String value) {
            addCriterion("make_password >", value, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("make_password >=", value, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordLessThan(String value) {
            addCriterion("make_password <", value, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordLessThanOrEqualTo(String value) {
            addCriterion("make_password <=", value, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordLike(String value) {
            addCriterion("make_password like", value, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordNotLike(String value) {
            addCriterion("make_password not like", value, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordIn(List<String> values) {
            addCriterion("make_password in", values, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordNotIn(List<String> values) {
            addCriterion("make_password not in", values, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordBetween(String value1, String value2) {
            addCriterion("make_password between", value1, value2, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakePasswordNotBetween(String value1, String value2) {
            addCriterion("make_password not between", value1, value2, "makePassword");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameIsNull() {
            addCriterion("make_db_name is null");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameIsNotNull() {
            addCriterion("make_db_name is not null");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameEqualTo(String value) {
            addCriterion("make_db_name =", value, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameNotEqualTo(String value) {
            addCriterion("make_db_name <>", value, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameGreaterThan(String value) {
            addCriterion("make_db_name >", value, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameGreaterThanOrEqualTo(String value) {
            addCriterion("make_db_name >=", value, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameLessThan(String value) {
            addCriterion("make_db_name <", value, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameLessThanOrEqualTo(String value) {
            addCriterion("make_db_name <=", value, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameLike(String value) {
            addCriterion("make_db_name like", value, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameNotLike(String value) {
            addCriterion("make_db_name not like", value, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameIn(List<String> values) {
            addCriterion("make_db_name in", values, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameNotIn(List<String> values) {
            addCriterion("make_db_name not in", values, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameBetween(String value1, String value2) {
            addCriterion("make_db_name between", value1, value2, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeDbNameNotBetween(String value1, String value2) {
            addCriterion("make_db_name not between", value1, value2, "makeDbName");
            return (Criteria) this;
        }

        public Criteria andMakeUrlIsNull() {
            addCriterion("make_url is null");
            return (Criteria) this;
        }

        public Criteria andMakeUrlIsNotNull() {
            addCriterion("make_url is not null");
            return (Criteria) this;
        }

        public Criteria andMakeUrlEqualTo(String value) {
            addCriterion("make_url =", value, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlNotEqualTo(String value) {
            addCriterion("make_url <>", value, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlGreaterThan(String value) {
            addCriterion("make_url >", value, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("make_url >=", value, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlLessThan(String value) {
            addCriterion("make_url <", value, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlLessThanOrEqualTo(String value) {
            addCriterion("make_url <=", value, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlLike(String value) {
            addCriterion("make_url like", value, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlNotLike(String value) {
            addCriterion("make_url not like", value, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlIn(List<String> values) {
            addCriterion("make_url in", values, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlNotIn(List<String> values) {
            addCriterion("make_url not in", values, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlBetween(String value1, String value2) {
            addCriterion("make_url between", value1, value2, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andMakeUrlNotBetween(String value1, String value2) {
            addCriterion("make_url not between", value1, value2, "makeUrl");
            return (Criteria) this;
        }

        public Criteria andDistillIpIsNull() {
            addCriterion("distill_ip is null");
            return (Criteria) this;
        }

        public Criteria andDistillIpIsNotNull() {
            addCriterion("distill_ip is not null");
            return (Criteria) this;
        }

        public Criteria andDistillIpEqualTo(String value) {
            addCriterion("distill_ip =", value, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpNotEqualTo(String value) {
            addCriterion("distill_ip <>", value, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpGreaterThan(String value) {
            addCriterion("distill_ip >", value, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpGreaterThanOrEqualTo(String value) {
            addCriterion("distill_ip >=", value, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpLessThan(String value) {
            addCriterion("distill_ip <", value, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpLessThanOrEqualTo(String value) {
            addCriterion("distill_ip <=", value, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpLike(String value) {
            addCriterion("distill_ip like", value, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpNotLike(String value) {
            addCriterion("distill_ip not like", value, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpIn(List<String> values) {
            addCriterion("distill_ip in", values, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpNotIn(List<String> values) {
            addCriterion("distill_ip not in", values, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpBetween(String value1, String value2) {
            addCriterion("distill_ip between", value1, value2, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillIpNotBetween(String value1, String value2) {
            addCriterion("distill_ip not between", value1, value2, "distillIp");
            return (Criteria) this;
        }

        public Criteria andDistillPortIsNull() {
            addCriterion("distill_port is null");
            return (Criteria) this;
        }

        public Criteria andDistillPortIsNotNull() {
            addCriterion("distill_port is not null");
            return (Criteria) this;
        }

        public Criteria andDistillPortEqualTo(String value) {
            addCriterion("distill_port =", value, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortNotEqualTo(String value) {
            addCriterion("distill_port <>", value, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortGreaterThan(String value) {
            addCriterion("distill_port >", value, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortGreaterThanOrEqualTo(String value) {
            addCriterion("distill_port >=", value, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortLessThan(String value) {
            addCriterion("distill_port <", value, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortLessThanOrEqualTo(String value) {
            addCriterion("distill_port <=", value, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortLike(String value) {
            addCriterion("distill_port like", value, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortNotLike(String value) {
            addCriterion("distill_port not like", value, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortIn(List<String> values) {
            addCriterion("distill_port in", values, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortNotIn(List<String> values) {
            addCriterion("distill_port not in", values, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortBetween(String value1, String value2) {
            addCriterion("distill_port between", value1, value2, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillPortNotBetween(String value1, String value2) {
            addCriterion("distill_port not between", value1, value2, "distillPort");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeIsNull() {
            addCriterion("distill_db_type is null");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeIsNotNull() {
            addCriterion("distill_db_type is not null");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeEqualTo(String value) {
            addCriterion("distill_db_type =", value, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeNotEqualTo(String value) {
            addCriterion("distill_db_type <>", value, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeGreaterThan(String value) {
            addCriterion("distill_db_type >", value, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeGreaterThanOrEqualTo(String value) {
            addCriterion("distill_db_type >=", value, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeLessThan(String value) {
            addCriterion("distill_db_type <", value, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeLessThanOrEqualTo(String value) {
            addCriterion("distill_db_type <=", value, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeLike(String value) {
            addCriterion("distill_db_type like", value, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeNotLike(String value) {
            addCriterion("distill_db_type not like", value, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeIn(List<String> values) {
            addCriterion("distill_db_type in", values, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeNotIn(List<String> values) {
            addCriterion("distill_db_type not in", values, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeBetween(String value1, String value2) {
            addCriterion("distill_db_type between", value1, value2, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillDbTypeNotBetween(String value1, String value2) {
            addCriterion("distill_db_type not between", value1, value2, "distillDbType");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameIsNull() {
            addCriterion("distill_user_name is null");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameIsNotNull() {
            addCriterion("distill_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameEqualTo(String value) {
            addCriterion("distill_user_name =", value, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameNotEqualTo(String value) {
            addCriterion("distill_user_name <>", value, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameGreaterThan(String value) {
            addCriterion("distill_user_name >", value, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("distill_user_name >=", value, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameLessThan(String value) {
            addCriterion("distill_user_name <", value, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameLessThanOrEqualTo(String value) {
            addCriterion("distill_user_name <=", value, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameLike(String value) {
            addCriterion("distill_user_name like", value, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameNotLike(String value) {
            addCriterion("distill_user_name not like", value, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameIn(List<String> values) {
            addCriterion("distill_user_name in", values, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameNotIn(List<String> values) {
            addCriterion("distill_user_name not in", values, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameBetween(String value1, String value2) {
            addCriterion("distill_user_name between", value1, value2, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillUserNameNotBetween(String value1, String value2) {
            addCriterion("distill_user_name not between", value1, value2, "distillUserName");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordIsNull() {
            addCriterion("distill_password is null");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordIsNotNull() {
            addCriterion("distill_password is not null");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordEqualTo(String value) {
            addCriterion("distill_password =", value, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordNotEqualTo(String value) {
            addCriterion("distill_password <>", value, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordGreaterThan(String value) {
            addCriterion("distill_password >", value, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("distill_password >=", value, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordLessThan(String value) {
            addCriterion("distill_password <", value, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordLessThanOrEqualTo(String value) {
            addCriterion("distill_password <=", value, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordLike(String value) {
            addCriterion("distill_password like", value, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordNotLike(String value) {
            addCriterion("distill_password not like", value, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordIn(List<String> values) {
            addCriterion("distill_password in", values, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordNotIn(List<String> values) {
            addCriterion("distill_password not in", values, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordBetween(String value1, String value2) {
            addCriterion("distill_password between", value1, value2, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillPasswordNotBetween(String value1, String value2) {
            addCriterion("distill_password not between", value1, value2, "distillPassword");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameIsNull() {
            addCriterion("distill_db_name is null");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameIsNotNull() {
            addCriterion("distill_db_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameEqualTo(String value) {
            addCriterion("distill_db_name =", value, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameNotEqualTo(String value) {
            addCriterion("distill_db_name <>", value, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameGreaterThan(String value) {
            addCriterion("distill_db_name >", value, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameGreaterThanOrEqualTo(String value) {
            addCriterion("distill_db_name >=", value, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameLessThan(String value) {
            addCriterion("distill_db_name <", value, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameLessThanOrEqualTo(String value) {
            addCriterion("distill_db_name <=", value, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameLike(String value) {
            addCriterion("distill_db_name like", value, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameNotLike(String value) {
            addCriterion("distill_db_name not like", value, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameIn(List<String> values) {
            addCriterion("distill_db_name in", values, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameNotIn(List<String> values) {
            addCriterion("distill_db_name not in", values, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameBetween(String value1, String value2) {
            addCriterion("distill_db_name between", value1, value2, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillDbNameNotBetween(String value1, String value2) {
            addCriterion("distill_db_name not between", value1, value2, "distillDbName");
            return (Criteria) this;
        }

        public Criteria andDistillUrlIsNull() {
            addCriterion("distill_url is null");
            return (Criteria) this;
        }

        public Criteria andDistillUrlIsNotNull() {
            addCriterion("distill_url is not null");
            return (Criteria) this;
        }

        public Criteria andDistillUrlEqualTo(String value) {
            addCriterion("distill_url =", value, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlNotEqualTo(String value) {
            addCriterion("distill_url <>", value, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlGreaterThan(String value) {
            addCriterion("distill_url >", value, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlGreaterThanOrEqualTo(String value) {
            addCriterion("distill_url >=", value, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlLessThan(String value) {
            addCriterion("distill_url <", value, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlLessThanOrEqualTo(String value) {
            addCriterion("distill_url <=", value, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlLike(String value) {
            addCriterion("distill_url like", value, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlNotLike(String value) {
            addCriterion("distill_url not like", value, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlIn(List<String> values) {
            addCriterion("distill_url in", values, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlNotIn(List<String> values) {
            addCriterion("distill_url not in", values, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlBetween(String value1, String value2) {
            addCriterion("distill_url between", value1, value2, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDistillUrlNotBetween(String value1, String value2) {
            addCriterion("distill_url not between", value1, value2, "distillUrl");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeIsNull() {
            addCriterion("db_trans_type is null");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeIsNotNull() {
            addCriterion("db_trans_type is not null");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeEqualTo(String value) {
            addCriterion("db_trans_type =", value, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeNotEqualTo(String value) {
            addCriterion("db_trans_type <>", value, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeGreaterThan(String value) {
            addCriterion("db_trans_type >", value, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeGreaterThanOrEqualTo(String value) {
            addCriterion("db_trans_type >=", value, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeLessThan(String value) {
            addCriterion("db_trans_type <", value, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeLessThanOrEqualTo(String value) {
            addCriterion("db_trans_type <=", value, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeLike(String value) {
            addCriterion("db_trans_type like", value, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeNotLike(String value) {
            addCriterion("db_trans_type not like", value, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeIn(List<String> values) {
            addCriterion("db_trans_type in", values, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeNotIn(List<String> values) {
            addCriterion("db_trans_type not in", values, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeBetween(String value1, String value2) {
            addCriterion("db_trans_type between", value1, value2, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTypeNotBetween(String value1, String value2) {
            addCriterion("db_trans_type not between", value1, value2, "dbTransType");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeIsNull() {
            addCriterion("db_trans_time is null");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeIsNotNull() {
            addCriterion("db_trans_time is not null");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeEqualTo(Integer value) {
            addCriterion("db_trans_time =", value, "dbTransTime");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeNotEqualTo(Integer value) {
            addCriterion("db_trans_time <>", value, "dbTransTime");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeGreaterThan(Integer value) {
            addCriterion("db_trans_time >", value, "dbTransTime");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("db_trans_time >=", value, "dbTransTime");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeLessThan(Integer value) {
            addCriterion("db_trans_time <", value, "dbTransTime");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeLessThanOrEqualTo(Integer value) {
            addCriterion("db_trans_time <=", value, "dbTransTime");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeIn(List<Integer> values) {
            addCriterion("db_trans_time in", values, "dbTransTime");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeNotIn(List<Integer> values) {
            addCriterion("db_trans_time not in", values, "dbTransTime");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeBetween(Integer value1, Integer value2) {
            addCriterion("db_trans_time between", value1, value2, "dbTransTime");
            return (Criteria) this;
        }

        public Criteria andDbTransTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("db_trans_time not between", value1, value2, "dbTransTime");
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

        public Criteria andRunCmdIsNull() {
            addCriterion("run_cmd is null");
            return (Criteria) this;
        }

        public Criteria andRunCmdIsNotNull() {
            addCriterion("run_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andRunCmdEqualTo(String value) {
            addCriterion("run_cmd =", value, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdNotEqualTo(String value) {
            addCriterion("run_cmd <>", value, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdGreaterThan(String value) {
            addCriterion("run_cmd >", value, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdGreaterThanOrEqualTo(String value) {
            addCriterion("run_cmd >=", value, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdLessThan(String value) {
            addCriterion("run_cmd <", value, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdLessThanOrEqualTo(String value) {
            addCriterion("run_cmd <=", value, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdLike(String value) {
            addCriterion("run_cmd like", value, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdNotLike(String value) {
            addCriterion("run_cmd not like", value, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdIn(List<String> values) {
            addCriterion("run_cmd in", values, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdNotIn(List<String> values) {
            addCriterion("run_cmd not in", values, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdBetween(String value1, String value2) {
            addCriterion("run_cmd between", value1, value2, "runCmd");
            return (Criteria) this;
        }

        public Criteria andRunCmdNotBetween(String value1, String value2) {
            addCriterion("run_cmd not between", value1, value2, "runCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdIsNull() {
            addCriterion("kill_cmd is null");
            return (Criteria) this;
        }

        public Criteria andKillCmdIsNotNull() {
            addCriterion("kill_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andKillCmdEqualTo(String value) {
            addCriterion("kill_cmd =", value, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdNotEqualTo(String value) {
            addCriterion("kill_cmd <>", value, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdGreaterThan(String value) {
            addCriterion("kill_cmd >", value, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdGreaterThanOrEqualTo(String value) {
            addCriterion("kill_cmd >=", value, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdLessThan(String value) {
            addCriterion("kill_cmd <", value, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdLessThanOrEqualTo(String value) {
            addCriterion("kill_cmd <=", value, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdLike(String value) {
            addCriterion("kill_cmd like", value, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdNotLike(String value) {
            addCriterion("kill_cmd not like", value, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdIn(List<String> values) {
            addCriterion("kill_cmd in", values, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdNotIn(List<String> values) {
            addCriterion("kill_cmd not in", values, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdBetween(String value1, String value2) {
            addCriterion("kill_cmd between", value1, value2, "killCmd");
            return (Criteria) this;
        }

        public Criteria andKillCmdNotBetween(String value1, String value2) {
            addCriterion("kill_cmd not between", value1, value2, "killCmd");
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
     * db_db_kit
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_db_kit null
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