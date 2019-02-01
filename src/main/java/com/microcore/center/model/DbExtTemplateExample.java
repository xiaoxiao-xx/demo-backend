package com.microcore.center.model;

import java.util.ArrayList;
import java.util.List;

public class DbExtTemplateExample {
    /**
     * db_ext_template
     */
    protected String orderByClause;

    /**
     * db_ext_template
     */
    protected boolean distinct;

    /**
     * db_ext_template
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbExtTemplateExample() {
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
     * db_ext_template null
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

        public Criteria andExtPolicyCnameIsNull() {
            addCriterion("ext_policy_cname is null");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameIsNotNull() {
            addCriterion("ext_policy_cname is not null");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameEqualTo(String value) {
            addCriterion("ext_policy_cname =", value, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameNotEqualTo(String value) {
            addCriterion("ext_policy_cname <>", value, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameGreaterThan(String value) {
            addCriterion("ext_policy_cname >", value, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameGreaterThanOrEqualTo(String value) {
            addCriterion("ext_policy_cname >=", value, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameLessThan(String value) {
            addCriterion("ext_policy_cname <", value, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameLessThanOrEqualTo(String value) {
            addCriterion("ext_policy_cname <=", value, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameLike(String value) {
            addCriterion("ext_policy_cname like", value, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameNotLike(String value) {
            addCriterion("ext_policy_cname not like", value, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameIn(List<String> values) {
            addCriterion("ext_policy_cname in", values, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameNotIn(List<String> values) {
            addCriterion("ext_policy_cname not in", values, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameBetween(String value1, String value2) {
            addCriterion("ext_policy_cname between", value1, value2, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyCnameNotBetween(String value1, String value2) {
            addCriterion("ext_policy_cname not between", value1, value2, "extPolicyCname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameIsNull() {
            addCriterion("ext_policy_ename is null");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameIsNotNull() {
            addCriterion("ext_policy_ename is not null");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameEqualTo(String value) {
            addCriterion("ext_policy_ename =", value, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameNotEqualTo(String value) {
            addCriterion("ext_policy_ename <>", value, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameGreaterThan(String value) {
            addCriterion("ext_policy_ename >", value, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameGreaterThanOrEqualTo(String value) {
            addCriterion("ext_policy_ename >=", value, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameLessThan(String value) {
            addCriterion("ext_policy_ename <", value, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameLessThanOrEqualTo(String value) {
            addCriterion("ext_policy_ename <=", value, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameLike(String value) {
            addCriterion("ext_policy_ename like", value, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameNotLike(String value) {
            addCriterion("ext_policy_ename not like", value, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameIn(List<String> values) {
            addCriterion("ext_policy_ename in", values, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameNotIn(List<String> values) {
            addCriterion("ext_policy_ename not in", values, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameBetween(String value1, String value2) {
            addCriterion("ext_policy_ename between", value1, value2, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andExtPolicyEnameNotBetween(String value1, String value2) {
            addCriterion("ext_policy_ename not between", value1, value2, "extPolicyEname");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
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

        public Criteria andEnumKeyIsNull() {
            addCriterion("enum_key is null");
            return (Criteria) this;
        }

        public Criteria andEnumKeyIsNotNull() {
            addCriterion("enum_key is not null");
            return (Criteria) this;
        }

        public Criteria andEnumKeyEqualTo(String value) {
            addCriterion("enum_key =", value, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyNotEqualTo(String value) {
            addCriterion("enum_key <>", value, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyGreaterThan(String value) {
            addCriterion("enum_key >", value, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyGreaterThanOrEqualTo(String value) {
            addCriterion("enum_key >=", value, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyLessThan(String value) {
            addCriterion("enum_key <", value, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyLessThanOrEqualTo(String value) {
            addCriterion("enum_key <=", value, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyLike(String value) {
            addCriterion("enum_key like", value, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyNotLike(String value) {
            addCriterion("enum_key not like", value, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyIn(List<String> values) {
            addCriterion("enum_key in", values, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyNotIn(List<String> values) {
            addCriterion("enum_key not in", values, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyBetween(String value1, String value2) {
            addCriterion("enum_key between", value1, value2, "enumKey");
            return (Criteria) this;
        }

        public Criteria andEnumKeyNotBetween(String value1, String value2) {
            addCriterion("enum_key not between", value1, value2, "enumKey");
            return (Criteria) this;
        }

        public Criteria andExtCommentIsNull() {
            addCriterion("ext_comment is null");
            return (Criteria) this;
        }

        public Criteria andExtCommentIsNotNull() {
            addCriterion("ext_comment is not null");
            return (Criteria) this;
        }

        public Criteria andExtCommentEqualTo(String value) {
            addCriterion("ext_comment =", value, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentNotEqualTo(String value) {
            addCriterion("ext_comment <>", value, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentGreaterThan(String value) {
            addCriterion("ext_comment >", value, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentGreaterThanOrEqualTo(String value) {
            addCriterion("ext_comment >=", value, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentLessThan(String value) {
            addCriterion("ext_comment <", value, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentLessThanOrEqualTo(String value) {
            addCriterion("ext_comment <=", value, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentLike(String value) {
            addCriterion("ext_comment like", value, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentNotLike(String value) {
            addCriterion("ext_comment not like", value, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentIn(List<String> values) {
            addCriterion("ext_comment in", values, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentNotIn(List<String> values) {
            addCriterion("ext_comment not in", values, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentBetween(String value1, String value2) {
            addCriterion("ext_comment between", value1, value2, "extComment");
            return (Criteria) this;
        }

        public Criteria andExtCommentNotBetween(String value1, String value2) {
            addCriterion("ext_comment not between", value1, value2, "extComment");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIsNull() {
            addCriterion("template_type is null");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIsNotNull() {
            addCriterion("template_type is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeEqualTo(String value) {
            addCriterion("template_type =", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotEqualTo(String value) {
            addCriterion("template_type <>", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeGreaterThan(String value) {
            addCriterion("template_type >", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("template_type >=", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLessThan(String value) {
            addCriterion("template_type <", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLessThanOrEqualTo(String value) {
            addCriterion("template_type <=", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLike(String value) {
            addCriterion("template_type like", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotLike(String value) {
            addCriterion("template_type not like", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIn(List<String> values) {
            addCriterion("template_type in", values, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotIn(List<String> values) {
            addCriterion("template_type not in", values, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeBetween(String value1, String value2) {
            addCriterion("template_type between", value1, value2, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotBetween(String value1, String value2) {
            addCriterion("template_type not between", value1, value2, "templateType");
            return (Criteria) this;
        }

        public Criteria andVisiableIsNull() {
            addCriterion("visiable is null");
            return (Criteria) this;
        }

        public Criteria andVisiableIsNotNull() {
            addCriterion("visiable is not null");
            return (Criteria) this;
        }

        public Criteria andVisiableEqualTo(String value) {
            addCriterion("visiable =", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableNotEqualTo(String value) {
            addCriterion("visiable <>", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableGreaterThan(String value) {
            addCriterion("visiable >", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableGreaterThanOrEqualTo(String value) {
            addCriterion("visiable >=", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableLessThan(String value) {
            addCriterion("visiable <", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableLessThanOrEqualTo(String value) {
            addCriterion("visiable <=", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableLike(String value) {
            addCriterion("visiable like", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableNotLike(String value) {
            addCriterion("visiable not like", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableIn(List<String> values) {
            addCriterion("visiable in", values, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableNotIn(List<String> values) {
            addCriterion("visiable not in", values, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableBetween(String value1, String value2) {
            addCriterion("visiable between", value1, value2, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableNotBetween(String value1, String value2) {
            addCriterion("visiable not between", value1, value2, "visiable");
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
    }

    /**
     * db_ext_template
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_ext_template null
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