package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbFileKitExample {
    /**
     * db_file_kit
     */
    protected String orderByClause;

    /**
     * db_file_kit
     */
    protected boolean distinct;

    /**
     * db_file_kit
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbFileKitExample() {
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
     * db_file_kit null
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

        public Criteria andTagDescIsNull() {
            addCriterion("tag_desc is null");
            return (Criteria) this;
        }

        public Criteria andTagDescIsNotNull() {
            addCriterion("tag_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTagDescEqualTo(String value) {
            addCriterion("tag_desc =", value, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescNotEqualTo(String value) {
            addCriterion("tag_desc <>", value, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescGreaterThan(String value) {
            addCriterion("tag_desc >", value, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescGreaterThanOrEqualTo(String value) {
            addCriterion("tag_desc >=", value, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescLessThan(String value) {
            addCriterion("tag_desc <", value, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescLessThanOrEqualTo(String value) {
            addCriterion("tag_desc <=", value, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescLike(String value) {
            addCriterion("tag_desc like", value, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescNotLike(String value) {
            addCriterion("tag_desc not like", value, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescIn(List<String> values) {
            addCriterion("tag_desc in", values, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescNotIn(List<String> values) {
            addCriterion("tag_desc not in", values, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescBetween(String value1, String value2) {
            addCriterion("tag_desc between", value1, value2, "tagDesc");
            return (Criteria) this;
        }

        public Criteria andTagDescNotBetween(String value1, String value2) {
            addCriterion("tag_desc not between", value1, value2, "tagDesc");
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

        public Criteria andDistillDirIsNull() {
            addCriterion("distill_dir is null");
            return (Criteria) this;
        }

        public Criteria andDistillDirIsNotNull() {
            addCriterion("distill_dir is not null");
            return (Criteria) this;
        }

        public Criteria andDistillDirEqualTo(String value) {
            addCriterion("distill_dir =", value, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirNotEqualTo(String value) {
            addCriterion("distill_dir <>", value, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirGreaterThan(String value) {
            addCriterion("distill_dir >", value, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirGreaterThanOrEqualTo(String value) {
            addCriterion("distill_dir >=", value, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirLessThan(String value) {
            addCriterion("distill_dir <", value, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirLessThanOrEqualTo(String value) {
            addCriterion("distill_dir <=", value, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirLike(String value) {
            addCriterion("distill_dir like", value, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirNotLike(String value) {
            addCriterion("distill_dir not like", value, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirIn(List<String> values) {
            addCriterion("distill_dir in", values, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirNotIn(List<String> values) {
            addCriterion("distill_dir not in", values, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirBetween(String value1, String value2) {
            addCriterion("distill_dir between", value1, value2, "distillDir");
            return (Criteria) this;
        }

        public Criteria andDistillDirNotBetween(String value1, String value2) {
            addCriterion("distill_dir not between", value1, value2, "distillDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirIsNull() {
            addCriterion("make_dir is null");
            return (Criteria) this;
        }

        public Criteria andMakeDirIsNotNull() {
            addCriterion("make_dir is not null");
            return (Criteria) this;
        }

        public Criteria andMakeDirEqualTo(String value) {
            addCriterion("make_dir =", value, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirNotEqualTo(String value) {
            addCriterion("make_dir <>", value, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirGreaterThan(String value) {
            addCriterion("make_dir >", value, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirGreaterThanOrEqualTo(String value) {
            addCriterion("make_dir >=", value, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirLessThan(String value) {
            addCriterion("make_dir <", value, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirLessThanOrEqualTo(String value) {
            addCriterion("make_dir <=", value, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirLike(String value) {
            addCriterion("make_dir like", value, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirNotLike(String value) {
            addCriterion("make_dir not like", value, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirIn(List<String> values) {
            addCriterion("make_dir in", values, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirNotIn(List<String> values) {
            addCriterion("make_dir not in", values, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirBetween(String value1, String value2) {
            addCriterion("make_dir between", value1, value2, "makeDir");
            return (Criteria) this;
        }

        public Criteria andMakeDirNotBetween(String value1, String value2) {
            addCriterion("make_dir not between", value1, value2, "makeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirIsNull() {
            addCriterion("exchange_dir is null");
            return (Criteria) this;
        }

        public Criteria andExchangeDirIsNotNull() {
            addCriterion("exchange_dir is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeDirEqualTo(String value) {
            addCriterion("exchange_dir =", value, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirNotEqualTo(String value) {
            addCriterion("exchange_dir <>", value, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirGreaterThan(String value) {
            addCriterion("exchange_dir >", value, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_dir >=", value, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirLessThan(String value) {
            addCriterion("exchange_dir <", value, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirLessThanOrEqualTo(String value) {
            addCriterion("exchange_dir <=", value, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirLike(String value) {
            addCriterion("exchange_dir like", value, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirNotLike(String value) {
            addCriterion("exchange_dir not like", value, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirIn(List<String> values) {
            addCriterion("exchange_dir in", values, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirNotIn(List<String> values) {
            addCriterion("exchange_dir not in", values, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirBetween(String value1, String value2) {
            addCriterion("exchange_dir between", value1, value2, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andExchangeDirNotBetween(String value1, String value2) {
            addCriterion("exchange_dir not between", value1, value2, "exchangeDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirIsNull() {
            addCriterion("notify_dir is null");
            return (Criteria) this;
        }

        public Criteria andNotifyDirIsNotNull() {
            addCriterion("notify_dir is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyDirEqualTo(String value) {
            addCriterion("notify_dir =", value, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirNotEqualTo(String value) {
            addCriterion("notify_dir <>", value, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirGreaterThan(String value) {
            addCriterion("notify_dir >", value, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirGreaterThanOrEqualTo(String value) {
            addCriterion("notify_dir >=", value, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirLessThan(String value) {
            addCriterion("notify_dir <", value, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirLessThanOrEqualTo(String value) {
            addCriterion("notify_dir <=", value, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirLike(String value) {
            addCriterion("notify_dir like", value, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirNotLike(String value) {
            addCriterion("notify_dir not like", value, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirIn(List<String> values) {
            addCriterion("notify_dir in", values, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirNotIn(List<String> values) {
            addCriterion("notify_dir not in", values, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirBetween(String value1, String value2) {
            addCriterion("notify_dir between", value1, value2, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andNotifyDirNotBetween(String value1, String value2) {
            addCriterion("notify_dir not between", value1, value2, "notifyDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirIsNull() {
            addCriterion("backup_dir is null");
            return (Criteria) this;
        }

        public Criteria andBackupDirIsNotNull() {
            addCriterion("backup_dir is not null");
            return (Criteria) this;
        }

        public Criteria andBackupDirEqualTo(String value) {
            addCriterion("backup_dir =", value, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirNotEqualTo(String value) {
            addCriterion("backup_dir <>", value, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirGreaterThan(String value) {
            addCriterion("backup_dir >", value, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirGreaterThanOrEqualTo(String value) {
            addCriterion("backup_dir >=", value, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirLessThan(String value) {
            addCriterion("backup_dir <", value, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirLessThanOrEqualTo(String value) {
            addCriterion("backup_dir <=", value, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirLike(String value) {
            addCriterion("backup_dir like", value, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirNotLike(String value) {
            addCriterion("backup_dir not like", value, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirIn(List<String> values) {
            addCriterion("backup_dir in", values, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirNotIn(List<String> values) {
            addCriterion("backup_dir not in", values, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirBetween(String value1, String value2) {
            addCriterion("backup_dir between", value1, value2, "backupDir");
            return (Criteria) this;
        }

        public Criteria andBackupDirNotBetween(String value1, String value2) {
            addCriterion("backup_dir not between", value1, value2, "backupDir");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNull() {
            addCriterion("trigger_type is null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNotNull() {
            addCriterion("trigger_type is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeEqualTo(String value) {
            addCriterion("trigger_type =", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotEqualTo(String value) {
            addCriterion("trigger_type <>", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThan(String value) {
            addCriterion("trigger_type >", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trigger_type >=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThan(String value) {
            addCriterion("trigger_type <", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThanOrEqualTo(String value) {
            addCriterion("trigger_type <=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLike(String value) {
            addCriterion("trigger_type like", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotLike(String value) {
            addCriterion("trigger_type not like", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIn(List<String> values) {
            addCriterion("trigger_type in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotIn(List<String> values) {
            addCriterion("trigger_type not in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeBetween(String value1, String value2) {
            addCriterion("trigger_type between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotBetween(String value1, String value2) {
            addCriterion("trigger_type not between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeIsNull() {
            addCriterion("file_trans_time is null");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeIsNotNull() {
            addCriterion("file_trans_time is not null");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeEqualTo(Integer value) {
            addCriterion("file_trans_time =", value, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeNotEqualTo(Integer value) {
            addCriterion("file_trans_time <>", value, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeGreaterThan(Integer value) {
            addCriterion("file_trans_time >", value, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_trans_time >=", value, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeLessThan(Integer value) {
            addCriterion("file_trans_time <", value, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeLessThanOrEqualTo(Integer value) {
            addCriterion("file_trans_time <=", value, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeIn(List<Integer> values) {
            addCriterion("file_trans_time in", values, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeNotIn(List<Integer> values) {
            addCriterion("file_trans_time not in", values, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeBetween(Integer value1, Integer value2) {
            addCriterion("file_trans_time between", value1, value2, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andFileTransTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("file_trans_time not between", value1, value2, "fileTransTime");
            return (Criteria) this;
        }

        public Criteria andExchangeIdIsNull() {
            addCriterion("exchange_id is null");
            return (Criteria) this;
        }

        public Criteria andExchangeIdIsNotNull() {
            addCriterion("exchange_id is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeIdEqualTo(String value) {
            addCriterion("exchange_id =", value, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdNotEqualTo(String value) {
            addCriterion("exchange_id <>", value, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdGreaterThan(String value) {
            addCriterion("exchange_id >", value, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_id >=", value, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdLessThan(String value) {
            addCriterion("exchange_id <", value, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdLessThanOrEqualTo(String value) {
            addCriterion("exchange_id <=", value, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdLike(String value) {
            addCriterion("exchange_id like", value, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdNotLike(String value) {
            addCriterion("exchange_id not like", value, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdIn(List<String> values) {
            addCriterion("exchange_id in", values, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdNotIn(List<String> values) {
            addCriterion("exchange_id not in", values, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdBetween(String value1, String value2) {
            addCriterion("exchange_id between", value1, value2, "exchangeId");
            return (Criteria) this;
        }

        public Criteria andExchangeIdNotBetween(String value1, String value2) {
            addCriterion("exchange_id not between", value1, value2, "exchangeId");
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
     * db_file_kit
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_file_kit null
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