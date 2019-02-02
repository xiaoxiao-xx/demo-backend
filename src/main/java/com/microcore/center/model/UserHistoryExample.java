package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserHistoryExample {
    /**
     * user_history
     */
    protected String orderByClause;

    /**
     * user_history
     */
    protected boolean distinct;

    /**
     * user_history
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public UserHistoryExample() {
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
     * user_history null
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

        public Criteria andNameIdIsNull() {
            addCriterion("name_id is null");
            return (Criteria) this;
        }

        public Criteria andNameIdIsNotNull() {
            addCriterion("name_id is not null");
            return (Criteria) this;
        }

        public Criteria andNameIdEqualTo(String value) {
            addCriterion("name_id =", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotEqualTo(String value) {
            addCriterion("name_id <>", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdGreaterThan(String value) {
            addCriterion("name_id >", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdGreaterThanOrEqualTo(String value) {
            addCriterion("name_id >=", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdLessThan(String value) {
            addCriterion("name_id <", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdLessThanOrEqualTo(String value) {
            addCriterion("name_id <=", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdLike(String value) {
            addCriterion("name_id like", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotLike(String value) {
            addCriterion("name_id not like", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdIn(List<String> values) {
            addCriterion("name_id in", values, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotIn(List<String> values) {
            addCriterion("name_id not in", values, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdBetween(String value1, String value2) {
            addCriterion("name_id between", value1, value2, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotBetween(String value1, String value2) {
            addCriterion("name_id not between", value1, value2, "nameId");
            return (Criteria) this;
        }

        public Criteria andDoManIsNull() {
            addCriterion("do_man is null");
            return (Criteria) this;
        }

        public Criteria andDoManIsNotNull() {
            addCriterion("do_man is not null");
            return (Criteria) this;
        }

        public Criteria andDoManEqualTo(String value) {
            addCriterion("do_man =", value, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManNotEqualTo(String value) {
            addCriterion("do_man <>", value, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManGreaterThan(String value) {
            addCriterion("do_man >", value, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManGreaterThanOrEqualTo(String value) {
            addCriterion("do_man >=", value, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManLessThan(String value) {
            addCriterion("do_man <", value, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManLessThanOrEqualTo(String value) {
            addCriterion("do_man <=", value, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManLike(String value) {
            addCriterion("do_man like", value, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManNotLike(String value) {
            addCriterion("do_man not like", value, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManIn(List<String> values) {
            addCriterion("do_man in", values, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManNotIn(List<String> values) {
            addCriterion("do_man not in", values, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManBetween(String value1, String value2) {
            addCriterion("do_man between", value1, value2, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManNotBetween(String value1, String value2) {
            addCriterion("do_man not between", value1, value2, "doMan");
            return (Criteria) this;
        }

        public Criteria andDoManIdIsNull() {
            addCriterion("do_man_id is null");
            return (Criteria) this;
        }

        public Criteria andDoManIdIsNotNull() {
            addCriterion("do_man_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoManIdEqualTo(String value) {
            addCriterion("do_man_id =", value, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdNotEqualTo(String value) {
            addCriterion("do_man_id <>", value, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdGreaterThan(String value) {
            addCriterion("do_man_id >", value, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdGreaterThanOrEqualTo(String value) {
            addCriterion("do_man_id >=", value, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdLessThan(String value) {
            addCriterion("do_man_id <", value, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdLessThanOrEqualTo(String value) {
            addCriterion("do_man_id <=", value, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdLike(String value) {
            addCriterion("do_man_id like", value, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdNotLike(String value) {
            addCriterion("do_man_id not like", value, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdIn(List<String> values) {
            addCriterion("do_man_id in", values, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdNotIn(List<String> values) {
            addCriterion("do_man_id not in", values, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdBetween(String value1, String value2) {
            addCriterion("do_man_id between", value1, value2, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoManIdNotBetween(String value1, String value2) {
            addCriterion("do_man_id not between", value1, value2, "doManId");
            return (Criteria) this;
        }

        public Criteria andDoTypeIsNull() {
            addCriterion("do_type is null");
            return (Criteria) this;
        }

        public Criteria andDoTypeIsNotNull() {
            addCriterion("do_type is not null");
            return (Criteria) this;
        }

        public Criteria andDoTypeEqualTo(String value) {
            addCriterion("do_type =", value, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeNotEqualTo(String value) {
            addCriterion("do_type <>", value, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeGreaterThan(String value) {
            addCriterion("do_type >", value, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("do_type >=", value, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeLessThan(String value) {
            addCriterion("do_type <", value, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeLessThanOrEqualTo(String value) {
            addCriterion("do_type <=", value, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeLike(String value) {
            addCriterion("do_type like", value, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeNotLike(String value) {
            addCriterion("do_type not like", value, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeIn(List<String> values) {
            addCriterion("do_type in", values, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeNotIn(List<String> values) {
            addCriterion("do_type not in", values, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeBetween(String value1, String value2) {
            addCriterion("do_type between", value1, value2, "doType");
            return (Criteria) this;
        }

        public Criteria andDoTypeNotBetween(String value1, String value2) {
            addCriterion("do_type not between", value1, value2, "doType");
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

        public Criteria andDoTmIsNull() {
            addCriterion("do_tm is null");
            return (Criteria) this;
        }

        public Criteria andDoTmIsNotNull() {
            addCriterion("do_tm is not null");
            return (Criteria) this;
        }

        public Criteria andDoTmEqualTo(Date value) {
            addCriterion("do_tm =", value, "doTm");
            return (Criteria) this;
        }

        public Criteria andDoTmNotEqualTo(Date value) {
            addCriterion("do_tm <>", value, "doTm");
            return (Criteria) this;
        }

        public Criteria andDoTmGreaterThan(Date value) {
            addCriterion("do_tm >", value, "doTm");
            return (Criteria) this;
        }

        public Criteria andDoTmGreaterThanOrEqualTo(Date value) {
            addCriterion("do_tm >=", value, "doTm");
            return (Criteria) this;
        }

        public Criteria andDoTmLessThan(Date value) {
            addCriterion("do_tm <", value, "doTm");
            return (Criteria) this;
        }

        public Criteria andDoTmLessThanOrEqualTo(Date value) {
            addCriterion("do_tm <=", value, "doTm");
            return (Criteria) this;
        }

        public Criteria andDoTmIn(List<Date> values) {
            addCriterion("do_tm in", values, "doTm");
            return (Criteria) this;
        }

        public Criteria andDoTmNotIn(List<Date> values) {
            addCriterion("do_tm not in", values, "doTm");
            return (Criteria) this;
        }

        public Criteria andDoTmBetween(Date value1, Date value2) {
            addCriterion("do_tm between", value1, value2, "doTm");
            return (Criteria) this;
        }

        public Criteria andDoTmNotBetween(Date value1, Date value2) {
            addCriterion("do_tm not between", value1, value2, "doTm");
            return (Criteria) this;
        }
    }

    /**
     * user_history
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * user_history null
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