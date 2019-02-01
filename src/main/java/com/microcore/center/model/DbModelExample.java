package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbModelExample {
    /**
     * db_model
     */
    protected String orderByClause;

    /**
     * db_model
     */
    protected boolean distinct;

    /**
     * db_model
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbModelExample() {
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
     * db_model null
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelIsNull() {
            addCriterion("model_data_level is null");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelIsNotNull() {
            addCriterion("model_data_level is not null");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelEqualTo(String value) {
            addCriterion("model_data_level =", value, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelNotEqualTo(String value) {
            addCriterion("model_data_level <>", value, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelGreaterThan(String value) {
            addCriterion("model_data_level >", value, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelGreaterThanOrEqualTo(String value) {
            addCriterion("model_data_level >=", value, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelLessThan(String value) {
            addCriterion("model_data_level <", value, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelLessThanOrEqualTo(String value) {
            addCriterion("model_data_level <=", value, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelLike(String value) {
            addCriterion("model_data_level like", value, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelNotLike(String value) {
            addCriterion("model_data_level not like", value, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelIn(List<String> values) {
            addCriterion("model_data_level in", values, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelNotIn(List<String> values) {
            addCriterion("model_data_level not in", values, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelBetween(String value1, String value2) {
            addCriterion("model_data_level between", value1, value2, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDataLevelNotBetween(String value1, String value2) {
            addCriterion("model_data_level not between", value1, value2, "modelDataLevel");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameIsNull() {
            addCriterion("model_display_name is null");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameIsNotNull() {
            addCriterion("model_display_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameEqualTo(String value) {
            addCriterion("model_display_name =", value, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameNotEqualTo(String value) {
            addCriterion("model_display_name <>", value, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameGreaterThan(String value) {
            addCriterion("model_display_name >", value, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_display_name >=", value, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameLessThan(String value) {
            addCriterion("model_display_name <", value, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("model_display_name <=", value, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameLike(String value) {
            addCriterion("model_display_name like", value, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameNotLike(String value) {
            addCriterion("model_display_name not like", value, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameIn(List<String> values) {
            addCriterion("model_display_name in", values, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameNotIn(List<String> values) {
            addCriterion("model_display_name not in", values, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameBetween(String value1, String value2) {
            addCriterion("model_display_name between", value1, value2, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelDisplayNameNotBetween(String value1, String value2) {
            addCriterion("model_display_name not between", value1, value2, "modelDisplayName");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelEnameIsNull() {
            addCriterion("model_ename is null");
            return (Criteria) this;
        }

        public Criteria andModelEnameIsNotNull() {
            addCriterion("model_ename is not null");
            return (Criteria) this;
        }

        public Criteria andModelEnameEqualTo(String value) {
            addCriterion("model_ename =", value, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameNotEqualTo(String value) {
            addCriterion("model_ename <>", value, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameGreaterThan(String value) {
            addCriterion("model_ename >", value, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameGreaterThanOrEqualTo(String value) {
            addCriterion("model_ename >=", value, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameLessThan(String value) {
            addCriterion("model_ename <", value, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameLessThanOrEqualTo(String value) {
            addCriterion("model_ename <=", value, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameLike(String value) {
            addCriterion("model_ename like", value, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameNotLike(String value) {
            addCriterion("model_ename not like", value, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameIn(List<String> values) {
            addCriterion("model_ename in", values, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameNotIn(List<String> values) {
            addCriterion("model_ename not in", values, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameBetween(String value1, String value2) {
            addCriterion("model_ename between", value1, value2, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelEnameNotBetween(String value1, String value2) {
            addCriterion("model_ename not between", value1, value2, "modelEname");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNull() {
            addCriterion("model_type is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("model_type is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(String value) {
            addCriterion("model_type =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(String value) {
            addCriterion("model_type <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(String value) {
            addCriterion("model_type >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("model_type >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(String value) {
            addCriterion("model_type <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(String value) {
            addCriterion("model_type <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLike(String value) {
            addCriterion("model_type like", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotLike(String value) {
            addCriterion("model_type not like", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<String> values) {
            addCriterion("model_type in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<String> values) {
            addCriterion("model_type not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(String value1, String value2) {
            addCriterion("model_type between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(String value1, String value2) {
            addCriterion("model_type not between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelDescIsNull() {
            addCriterion("model_desc is null");
            return (Criteria) this;
        }

        public Criteria andModelDescIsNotNull() {
            addCriterion("model_desc is not null");
            return (Criteria) this;
        }

        public Criteria andModelDescEqualTo(String value) {
            addCriterion("model_desc =", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescNotEqualTo(String value) {
            addCriterion("model_desc <>", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescGreaterThan(String value) {
            addCriterion("model_desc >", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescGreaterThanOrEqualTo(String value) {
            addCriterion("model_desc >=", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescLessThan(String value) {
            addCriterion("model_desc <", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescLessThanOrEqualTo(String value) {
            addCriterion("model_desc <=", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescLike(String value) {
            addCriterion("model_desc like", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescNotLike(String value) {
            addCriterion("model_desc not like", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescIn(List<String> values) {
            addCriterion("model_desc in", values, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescNotIn(List<String> values) {
            addCriterion("model_desc not in", values, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescBetween(String value1, String value2) {
            addCriterion("model_desc between", value1, value2, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescNotBetween(String value1, String value2) {
            addCriterion("model_desc not between", value1, value2, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelTradeIsNull() {
            addCriterion("model_trade is null");
            return (Criteria) this;
        }

        public Criteria andModelTradeIsNotNull() {
            addCriterion("model_trade is not null");
            return (Criteria) this;
        }

        public Criteria andModelTradeEqualTo(String value) {
            addCriterion("model_trade =", value, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeNotEqualTo(String value) {
            addCriterion("model_trade <>", value, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeGreaterThan(String value) {
            addCriterion("model_trade >", value, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeGreaterThanOrEqualTo(String value) {
            addCriterion("model_trade >=", value, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeLessThan(String value) {
            addCriterion("model_trade <", value, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeLessThanOrEqualTo(String value) {
            addCriterion("model_trade <=", value, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeLike(String value) {
            addCriterion("model_trade like", value, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeNotLike(String value) {
            addCriterion("model_trade not like", value, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeIn(List<String> values) {
            addCriterion("model_trade in", values, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeNotIn(List<String> values) {
            addCriterion("model_trade not in", values, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeBetween(String value1, String value2) {
            addCriterion("model_trade between", value1, value2, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelTradeNotBetween(String value1, String value2) {
            addCriterion("model_trade not between", value1, value2, "modelTrade");
            return (Criteria) this;
        }

        public Criteria andModelVersionIsNull() {
            addCriterion("model_version is null");
            return (Criteria) this;
        }

        public Criteria andModelVersionIsNotNull() {
            addCriterion("model_version is not null");
            return (Criteria) this;
        }

        public Criteria andModelVersionEqualTo(Integer value) {
            addCriterion("model_version =", value, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andModelVersionNotEqualTo(Integer value) {
            addCriterion("model_version <>", value, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andModelVersionGreaterThan(Integer value) {
            addCriterion("model_version >", value, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andModelVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_version >=", value, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andModelVersionLessThan(Integer value) {
            addCriterion("model_version <", value, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andModelVersionLessThanOrEqualTo(Integer value) {
            addCriterion("model_version <=", value, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andModelVersionIn(List<Integer> values) {
            addCriterion("model_version in", values, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andModelVersionNotIn(List<Integer> values) {
            addCriterion("model_version not in", values, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andModelVersionBetween(Integer value1, Integer value2) {
            addCriterion("model_version between", value1, value2, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andModelVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("model_version not between", value1, value2, "modelVersion");
            return (Criteria) this;
        }

        public Criteria andPubCountIsNull() {
            addCriterion("pub_count is null");
            return (Criteria) this;
        }

        public Criteria andPubCountIsNotNull() {
            addCriterion("pub_count is not null");
            return (Criteria) this;
        }

        public Criteria andPubCountEqualTo(Integer value) {
            addCriterion("pub_count =", value, "pubCount");
            return (Criteria) this;
        }

        public Criteria andPubCountNotEqualTo(Integer value) {
            addCriterion("pub_count <>", value, "pubCount");
            return (Criteria) this;
        }

        public Criteria andPubCountGreaterThan(Integer value) {
            addCriterion("pub_count >", value, "pubCount");
            return (Criteria) this;
        }

        public Criteria andPubCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pub_count >=", value, "pubCount");
            return (Criteria) this;
        }

        public Criteria andPubCountLessThan(Integer value) {
            addCriterion("pub_count <", value, "pubCount");
            return (Criteria) this;
        }

        public Criteria andPubCountLessThanOrEqualTo(Integer value) {
            addCriterion("pub_count <=", value, "pubCount");
            return (Criteria) this;
        }

        public Criteria andPubCountIn(List<Integer> values) {
            addCriterion("pub_count in", values, "pubCount");
            return (Criteria) this;
        }

        public Criteria andPubCountNotIn(List<Integer> values) {
            addCriterion("pub_count not in", values, "pubCount");
            return (Criteria) this;
        }

        public Criteria andPubCountBetween(Integer value1, Integer value2) {
            addCriterion("pub_count between", value1, value2, "pubCount");
            return (Criteria) this;
        }

        public Criteria andPubCountNotBetween(Integer value1, Integer value2) {
            addCriterion("pub_count not between", value1, value2, "pubCount");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeIsNull() {
            addCriterion("copyright_notice is null");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeIsNotNull() {
            addCriterion("copyright_notice is not null");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeEqualTo(String value) {
            addCriterion("copyright_notice =", value, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeNotEqualTo(String value) {
            addCriterion("copyright_notice <>", value, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeGreaterThan(String value) {
            addCriterion("copyright_notice >", value, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("copyright_notice >=", value, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeLessThan(String value) {
            addCriterion("copyright_notice <", value, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeLessThanOrEqualTo(String value) {
            addCriterion("copyright_notice <=", value, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeLike(String value) {
            addCriterion("copyright_notice like", value, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeNotLike(String value) {
            addCriterion("copyright_notice not like", value, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeIn(List<String> values) {
            addCriterion("copyright_notice in", values, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeNotIn(List<String> values) {
            addCriterion("copyright_notice not in", values, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeBetween(String value1, String value2) {
            addCriterion("copyright_notice between", value1, value2, "copyrightNotice");
            return (Criteria) this;
        }

        public Criteria andCopyrightNoticeNotBetween(String value1, String value2) {
            addCriterion("copyright_notice not between", value1, value2, "copyrightNotice");
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
     * db_model
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_model null
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