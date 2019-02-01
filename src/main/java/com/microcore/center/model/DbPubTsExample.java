package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DbPubTsExample {
    /**
     * db_pub_ts
     */
    protected String orderByClause;

    /**
     * db_pub_ts
     */
    protected boolean distinct;

    /**
     * db_pub_ts
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbPubTsExample() {
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
     * db_pub_ts null
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

        public Criteria andPubNameIsNull() {
            addCriterion("pub_name is null");
            return (Criteria) this;
        }

        public Criteria andPubNameIsNotNull() {
            addCriterion("pub_name is not null");
            return (Criteria) this;
        }

        public Criteria andPubNameEqualTo(String value) {
            addCriterion("pub_name =", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameNotEqualTo(String value) {
            addCriterion("pub_name <>", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameGreaterThan(String value) {
            addCriterion("pub_name >", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameGreaterThanOrEqualTo(String value) {
            addCriterion("pub_name >=", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameLessThan(String value) {
            addCriterion("pub_name <", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameLessThanOrEqualTo(String value) {
            addCriterion("pub_name <=", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameLike(String value) {
            addCriterion("pub_name like", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameNotLike(String value) {
            addCriterion("pub_name not like", value, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameIn(List<String> values) {
            addCriterion("pub_name in", values, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameNotIn(List<String> values) {
            addCriterion("pub_name not in", values, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameBetween(String value1, String value2) {
            addCriterion("pub_name between", value1, value2, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubNameNotBetween(String value1, String value2) {
            addCriterion("pub_name not between", value1, value2, "pubName");
            return (Criteria) this;
        }

        public Criteria andPubDescIsNull() {
            addCriterion("pub_desc is null");
            return (Criteria) this;
        }

        public Criteria andPubDescIsNotNull() {
            addCriterion("pub_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPubDescEqualTo(String value) {
            addCriterion("pub_desc =", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescNotEqualTo(String value) {
            addCriterion("pub_desc <>", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescGreaterThan(String value) {
            addCriterion("pub_desc >", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescGreaterThanOrEqualTo(String value) {
            addCriterion("pub_desc >=", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescLessThan(String value) {
            addCriterion("pub_desc <", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescLessThanOrEqualTo(String value) {
            addCriterion("pub_desc <=", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescLike(String value) {
            addCriterion("pub_desc like", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescNotLike(String value) {
            addCriterion("pub_desc not like", value, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescIn(List<String> values) {
            addCriterion("pub_desc in", values, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescNotIn(List<String> values) {
            addCriterion("pub_desc not in", values, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescBetween(String value1, String value2) {
            addCriterion("pub_desc between", value1, value2, "pubDesc");
            return (Criteria) this;
        }

        public Criteria andPubDescNotBetween(String value1, String value2) {
            addCriterion("pub_desc not between", value1, value2, "pubDesc");
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

        public Criteria andPubUserIdIsNull() {
            addCriterion("pub_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPubUserIdIsNotNull() {
            addCriterion("pub_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPubUserIdEqualTo(String value) {
            addCriterion("pub_user_id =", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdNotEqualTo(String value) {
            addCriterion("pub_user_id <>", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdGreaterThan(String value) {
            addCriterion("pub_user_id >", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("pub_user_id >=", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdLessThan(String value) {
            addCriterion("pub_user_id <", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdLessThanOrEqualTo(String value) {
            addCriterion("pub_user_id <=", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdLike(String value) {
            addCriterion("pub_user_id like", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdNotLike(String value) {
            addCriterion("pub_user_id not like", value, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdIn(List<String> values) {
            addCriterion("pub_user_id in", values, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdNotIn(List<String> values) {
            addCriterion("pub_user_id not in", values, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdBetween(String value1, String value2) {
            addCriterion("pub_user_id between", value1, value2, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubUserIdNotBetween(String value1, String value2) {
            addCriterion("pub_user_id not between", value1, value2, "pubUserId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdIsNull() {
            addCriterion("pub_org_id is null");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdIsNotNull() {
            addCriterion("pub_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdEqualTo(String value) {
            addCriterion("pub_org_id =", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdNotEqualTo(String value) {
            addCriterion("pub_org_id <>", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdGreaterThan(String value) {
            addCriterion("pub_org_id >", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("pub_org_id >=", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdLessThan(String value) {
            addCriterion("pub_org_id <", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdLessThanOrEqualTo(String value) {
            addCriterion("pub_org_id <=", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdLike(String value) {
            addCriterion("pub_org_id like", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdNotLike(String value) {
            addCriterion("pub_org_id not like", value, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdIn(List<String> values) {
            addCriterion("pub_org_id in", values, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdNotIn(List<String> values) {
            addCriterion("pub_org_id not in", values, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdBetween(String value1, String value2) {
            addCriterion("pub_org_id between", value1, value2, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubOrgIdNotBetween(String value1, String value2) {
            addCriterion("pub_org_id not between", value1, value2, "pubOrgId");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNull() {
            addCriterion("pub_time is null");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNotNull() {
            addCriterion("pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andPubTimeEqualTo(Date value) {
            addCriterion("pub_time =", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotEqualTo(Date value) {
            addCriterion("pub_time <>", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThan(Date value) {
            addCriterion("pub_time >", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pub_time >=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThan(Date value) {
            addCriterion("pub_time <", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThanOrEqualTo(Date value) {
            addCriterion("pub_time <=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeIn(List<Date> values) {
            addCriterion("pub_time in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotIn(List<Date> values) {
            addCriterion("pub_time not in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeBetween(Date value1, Date value2) {
            addCriterion("pub_time between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotBetween(Date value1, Date value2) {
            addCriterion("pub_time not between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdIsNull() {
            addCriterion("source_db_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdIsNotNull() {
            addCriterion("source_db_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdEqualTo(String value) {
            addCriterion("source_db_id =", value, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdNotEqualTo(String value) {
            addCriterion("source_db_id <>", value, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdGreaterThan(String value) {
            addCriterion("source_db_id >", value, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdGreaterThanOrEqualTo(String value) {
            addCriterion("source_db_id >=", value, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdLessThan(String value) {
            addCriterion("source_db_id <", value, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdLessThanOrEqualTo(String value) {
            addCriterion("source_db_id <=", value, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdLike(String value) {
            addCriterion("source_db_id like", value, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdNotLike(String value) {
            addCriterion("source_db_id not like", value, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdIn(List<String> values) {
            addCriterion("source_db_id in", values, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdNotIn(List<String> values) {
            addCriterion("source_db_id not in", values, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdBetween(String value1, String value2) {
            addCriterion("source_db_id between", value1, value2, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andSourceDbIdNotBetween(String value1, String value2) {
            addCriterion("source_db_id not between", value1, value2, "sourceDbId");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("table_name =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("table_name >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("table_name <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("table_name like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("table_name not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("table_name in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("table_name not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_name between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_name not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableCommentIsNull() {
            addCriterion("table_comment is null");
            return (Criteria) this;
        }

        public Criteria andTableCommentIsNotNull() {
            addCriterion("table_comment is not null");
            return (Criteria) this;
        }

        public Criteria andTableCommentEqualTo(String value) {
            addCriterion("table_comment =", value, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentNotEqualTo(String value) {
            addCriterion("table_comment <>", value, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentGreaterThan(String value) {
            addCriterion("table_comment >", value, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentGreaterThanOrEqualTo(String value) {
            addCriterion("table_comment >=", value, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentLessThan(String value) {
            addCriterion("table_comment <", value, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentLessThanOrEqualTo(String value) {
            addCriterion("table_comment <=", value, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentLike(String value) {
            addCriterion("table_comment like", value, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentNotLike(String value) {
            addCriterion("table_comment not like", value, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentIn(List<String> values) {
            addCriterion("table_comment in", values, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentNotIn(List<String> values) {
            addCriterion("table_comment not in", values, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentBetween(String value1, String value2) {
            addCriterion("table_comment between", value1, value2, "tableComment");
            return (Criteria) this;
        }

        public Criteria andTableCommentNotBetween(String value1, String value2) {
            addCriterion("table_comment not between", value1, value2, "tableComment");
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

        public Criteria andRestUrlIsNull() {
            addCriterion("rest_url is null");
            return (Criteria) this;
        }

        public Criteria andRestUrlIsNotNull() {
            addCriterion("rest_url is not null");
            return (Criteria) this;
        }

        public Criteria andRestUrlEqualTo(String value) {
            addCriterion("rest_url =", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlNotEqualTo(String value) {
            addCriterion("rest_url <>", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlGreaterThan(String value) {
            addCriterion("rest_url >", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlGreaterThanOrEqualTo(String value) {
            addCriterion("rest_url >=", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlLessThan(String value) {
            addCriterion("rest_url <", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlLessThanOrEqualTo(String value) {
            addCriterion("rest_url <=", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlLike(String value) {
            addCriterion("rest_url like", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlNotLike(String value) {
            addCriterion("rest_url not like", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlIn(List<String> values) {
            addCriterion("rest_url in", values, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlNotIn(List<String> values) {
            addCriterion("rest_url not in", values, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlBetween(String value1, String value2) {
            addCriterion("rest_url between", value1, value2, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlNotBetween(String value1, String value2) {
            addCriterion("rest_url not between", value1, value2, "restUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNull() {
            addCriterion("web_url is null");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNotNull() {
            addCriterion("web_url is not null");
            return (Criteria) this;
        }

        public Criteria andWebUrlEqualTo(String value) {
            addCriterion("web_url =", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotEqualTo(String value) {
            addCriterion("web_url <>", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThan(String value) {
            addCriterion("web_url >", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThanOrEqualTo(String value) {
            addCriterion("web_url >=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThan(String value) {
            addCriterion("web_url <", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThanOrEqualTo(String value) {
            addCriterion("web_url <=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLike(String value) {
            addCriterion("web_url like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotLike(String value) {
            addCriterion("web_url not like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlIn(List<String> values) {
            addCriterion("web_url in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotIn(List<String> values) {
            addCriterion("web_url not in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlBetween(String value1, String value2) {
            addCriterion("web_url between", value1, value2, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotBetween(String value1, String value2) {
            addCriterion("web_url not between", value1, value2, "webUrl");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNull() {
            addCriterion("auth_type is null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNotNull() {
            addCriterion("auth_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeEqualTo(String value) {
            addCriterion("auth_type =", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotEqualTo(String value) {
            addCriterion("auth_type <>", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThan(String value) {
            addCriterion("auth_type >", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThanOrEqualTo(String value) {
            addCriterion("auth_type >=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThan(String value) {
            addCriterion("auth_type <", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThanOrEqualTo(String value) {
            addCriterion("auth_type <=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLike(String value) {
            addCriterion("auth_type like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotLike(String value) {
            addCriterion("auth_type not like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIn(List<String> values) {
            addCriterion("auth_type in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotIn(List<String> values) {
            addCriterion("auth_type not in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeBetween(String value1, String value2) {
            addCriterion("auth_type between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotBetween(String value1, String value2) {
            addCriterion("auth_type not between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthScopeIsNull() {
            addCriterion("auth_scope is null");
            return (Criteria) this;
        }

        public Criteria andAuthScopeIsNotNull() {
            addCriterion("auth_scope is not null");
            return (Criteria) this;
        }

        public Criteria andAuthScopeEqualTo(String value) {
            addCriterion("auth_scope =", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeNotEqualTo(String value) {
            addCriterion("auth_scope <>", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeGreaterThan(String value) {
            addCriterion("auth_scope >", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeGreaterThanOrEqualTo(String value) {
            addCriterion("auth_scope >=", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeLessThan(String value) {
            addCriterion("auth_scope <", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeLessThanOrEqualTo(String value) {
            addCriterion("auth_scope <=", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeLike(String value) {
            addCriterion("auth_scope like", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeNotLike(String value) {
            addCriterion("auth_scope not like", value, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeIn(List<String> values) {
            addCriterion("auth_scope in", values, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeNotIn(List<String> values) {
            addCriterion("auth_scope not in", values, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeBetween(String value1, String value2) {
            addCriterion("auth_scope between", value1, value2, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthScopeNotBetween(String value1, String value2) {
            addCriterion("auth_scope not between", value1, value2, "authScope");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeIsNull() {
            addCriterion("auth_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeIsNotNull() {
            addCriterion("auth_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("auth_start_time =", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("auth_start_time <>", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("auth_start_time >", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auth_start_time >=", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("auth_start_time <", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auth_start_time <=", value, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("auth_start_time in", values, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("auth_start_time not in", values, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auth_start_time between", value1, value2, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auth_start_time not between", value1, value2, "authStartTime");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateIsNull() {
            addCriterion("auth_end_date is null");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateIsNotNull() {
            addCriterion("auth_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("auth_end_date =", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("auth_end_date <>", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("auth_end_date >", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auth_end_date >=", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateLessThan(Date value) {
            addCriterionForJDBCDate("auth_end_date <", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auth_end_date <=", value, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("auth_end_date in", values, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("auth_end_date not in", values, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auth_end_date between", value1, value2, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andAuthEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auth_end_date not between", value1, value2, "authEndDate");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyIsNull() {
            addCriterion("usefrequency is null");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyIsNotNull() {
            addCriterion("usefrequency is not null");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyEqualTo(Integer value) {
            addCriterion("usefrequency =", value, "usefrequency");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyNotEqualTo(Integer value) {
            addCriterion("usefrequency <>", value, "usefrequency");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyGreaterThan(Integer value) {
            addCriterion("usefrequency >", value, "usefrequency");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("usefrequency >=", value, "usefrequency");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyLessThan(Integer value) {
            addCriterion("usefrequency <", value, "usefrequency");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("usefrequency <=", value, "usefrequency");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyIn(List<Integer> values) {
            addCriterion("usefrequency in", values, "usefrequency");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyNotIn(List<Integer> values) {
            addCriterion("usefrequency not in", values, "usefrequency");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyBetween(Integer value1, Integer value2) {
            addCriterion("usefrequency between", value1, value2, "usefrequency");
            return (Criteria) this;
        }

        public Criteria andUsefrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("usefrequency not between", value1, value2, "usefrequency");
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
     * db_pub_ts
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_pub_ts null
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