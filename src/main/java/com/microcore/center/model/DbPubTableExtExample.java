package com.microcore.center.model;

import java.util.ArrayList;
import java.util.List;

public class DbPubTableExtExample {
    /**
     * db_pub_table_ext
     */
    protected String orderByClause;

    /**
     * db_pub_table_ext
     */
    protected boolean distinct;

    /**
     * db_pub_table_ext
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbPubTableExtExample() {
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
     * db_pub_table_ext null
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

        public Criteria andExtAttrCnameIsNull() {
            addCriterion("ext_attr_cname is null");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameIsNotNull() {
            addCriterion("ext_attr_cname is not null");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameEqualTo(String value) {
            addCriterion("ext_attr_cname =", value, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameNotEqualTo(String value) {
            addCriterion("ext_attr_cname <>", value, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameGreaterThan(String value) {
            addCriterion("ext_attr_cname >", value, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameGreaterThanOrEqualTo(String value) {
            addCriterion("ext_attr_cname >=", value, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameLessThan(String value) {
            addCriterion("ext_attr_cname <", value, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameLessThanOrEqualTo(String value) {
            addCriterion("ext_attr_cname <=", value, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameLike(String value) {
            addCriterion("ext_attr_cname like", value, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameNotLike(String value) {
            addCriterion("ext_attr_cname not like", value, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameIn(List<String> values) {
            addCriterion("ext_attr_cname in", values, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameNotIn(List<String> values) {
            addCriterion("ext_attr_cname not in", values, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameBetween(String value1, String value2) {
            addCriterion("ext_attr_cname between", value1, value2, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrCnameNotBetween(String value1, String value2) {
            addCriterion("ext_attr_cname not between", value1, value2, "extAttrCname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameIsNull() {
            addCriterion("ext_attr_ename is null");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameIsNotNull() {
            addCriterion("ext_attr_ename is not null");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameEqualTo(String value) {
            addCriterion("ext_attr_ename =", value, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameNotEqualTo(String value) {
            addCriterion("ext_attr_ename <>", value, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameGreaterThan(String value) {
            addCriterion("ext_attr_ename >", value, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameGreaterThanOrEqualTo(String value) {
            addCriterion("ext_attr_ename >=", value, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameLessThan(String value) {
            addCriterion("ext_attr_ename <", value, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameLessThanOrEqualTo(String value) {
            addCriterion("ext_attr_ename <=", value, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameLike(String value) {
            addCriterion("ext_attr_ename like", value, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameNotLike(String value) {
            addCriterion("ext_attr_ename not like", value, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameIn(List<String> values) {
            addCriterion("ext_attr_ename in", values, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameNotIn(List<String> values) {
            addCriterion("ext_attr_ename not in", values, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameBetween(String value1, String value2) {
            addCriterion("ext_attr_ename between", value1, value2, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtAttrEnameNotBetween(String value1, String value2) {
            addCriterion("ext_attr_ename not between", value1, value2, "extAttrEname");
            return (Criteria) this;
        }

        public Criteria andExtValueIsNull() {
            addCriterion("ext_value is null");
            return (Criteria) this;
        }

        public Criteria andExtValueIsNotNull() {
            addCriterion("ext_value is not null");
            return (Criteria) this;
        }

        public Criteria andExtValueEqualTo(String value) {
            addCriterion("ext_value =", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueNotEqualTo(String value) {
            addCriterion("ext_value <>", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueGreaterThan(String value) {
            addCriterion("ext_value >", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueGreaterThanOrEqualTo(String value) {
            addCriterion("ext_value >=", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueLessThan(String value) {
            addCriterion("ext_value <", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueLessThanOrEqualTo(String value) {
            addCriterion("ext_value <=", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueLike(String value) {
            addCriterion("ext_value like", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueNotLike(String value) {
            addCriterion("ext_value not like", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueIn(List<String> values) {
            addCriterion("ext_value in", values, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueNotIn(List<String> values) {
            addCriterion("ext_value not in", values, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueBetween(String value1, String value2) {
            addCriterion("ext_value between", value1, value2, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueNotBetween(String value1, String value2) {
            addCriterion("ext_value not between", value1, value2, "extValue");
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
    }

    /**
     * db_pub_table_ext
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_pub_table_ext null
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