package com.rainyhon.common.model;

import java.util.ArrayList;
import java.util.List;

public class DeptInfoExample {
    /**
     * dept_info
     */
    protected String orderByClause;

    /**
     * dept_info
     */
    protected boolean distinct;

    /**
     * dept_info
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DeptInfoExample() {
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
     * dept_info null
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

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(String value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(String value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(String value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(String value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(String value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLike(String value) {
            addCriterion("dept_id like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotLike(String value) {
            addCriterion("dept_id not like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<String> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<String> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(String value1, String value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(String value1, String value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("dept_name is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("dept_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("dept_name =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("dept_name <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("dept_name >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_name >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("dept_name <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("dept_name <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("dept_name like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("dept_name not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("dept_name in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("dept_name not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("dept_name between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("dept_name not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameIsNull() {
            addCriterion("dept_fullname is null");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameIsNotNull() {
            addCriterion("dept_fullname is not null");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameEqualTo(String value) {
            addCriterion("dept_fullname =", value, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameNotEqualTo(String value) {
            addCriterion("dept_fullname <>", value, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameGreaterThan(String value) {
            addCriterion("dept_fullname >", value, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_fullname >=", value, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameLessThan(String value) {
            addCriterion("dept_fullname <", value, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameLessThanOrEqualTo(String value) {
            addCriterion("dept_fullname <=", value, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameLike(String value) {
            addCriterion("dept_fullname like", value, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameNotLike(String value) {
            addCriterion("dept_fullname not like", value, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameIn(List<String> values) {
            addCriterion("dept_fullname in", values, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameNotIn(List<String> values) {
            addCriterion("dept_fullname not in", values, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameBetween(String value1, String value2) {
            addCriterion("dept_fullname between", value1, value2, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptFullnameNotBetween(String value1, String value2) {
            addCriterion("dept_fullname not between", value1, value2, "deptFullname");
            return (Criteria) this;
        }

        public Criteria andDeptLevIsNull() {
            addCriterion("dept_lev is null");
            return (Criteria) this;
        }

        public Criteria andDeptLevIsNotNull() {
            addCriterion("dept_lev is not null");
            return (Criteria) this;
        }

        public Criteria andDeptLevEqualTo(Integer value) {
            addCriterion("dept_lev =", value, "deptLev");
            return (Criteria) this;
        }

        public Criteria andDeptLevNotEqualTo(Integer value) {
            addCriterion("dept_lev <>", value, "deptLev");
            return (Criteria) this;
        }

        public Criteria andDeptLevGreaterThan(Integer value) {
            addCriterion("dept_lev >", value, "deptLev");
            return (Criteria) this;
        }

        public Criteria andDeptLevGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_lev >=", value, "deptLev");
            return (Criteria) this;
        }

        public Criteria andDeptLevLessThan(Integer value) {
            addCriterion("dept_lev <", value, "deptLev");
            return (Criteria) this;
        }

        public Criteria andDeptLevLessThanOrEqualTo(Integer value) {
            addCriterion("dept_lev <=", value, "deptLev");
            return (Criteria) this;
        }

        public Criteria andDeptLevIn(List<Integer> values) {
            addCriterion("dept_lev in", values, "deptLev");
            return (Criteria) this;
        }

        public Criteria andDeptLevNotIn(List<Integer> values) {
            addCriterion("dept_lev not in", values, "deptLev");
            return (Criteria) this;
        }

        public Criteria andDeptLevBetween(Integer value1, Integer value2) {
            addCriterion("dept_lev between", value1, value2, "deptLev");
            return (Criteria) this;
        }

        public Criteria andDeptLevNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_lev not between", value1, value2, "deptLev");
            return (Criteria) this;
        }

        public Criteria andParentDeptidIsNull() {
            addCriterion("parent_deptid is null");
            return (Criteria) this;
        }

        public Criteria andParentDeptidIsNotNull() {
            addCriterion("parent_deptid is not null");
            return (Criteria) this;
        }

        public Criteria andParentDeptidEqualTo(String value) {
            addCriterion("parent_deptid =", value, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidNotEqualTo(String value) {
            addCriterion("parent_deptid <>", value, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidGreaterThan(String value) {
            addCriterion("parent_deptid >", value, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidGreaterThanOrEqualTo(String value) {
            addCriterion("parent_deptid >=", value, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidLessThan(String value) {
            addCriterion("parent_deptid <", value, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidLessThanOrEqualTo(String value) {
            addCriterion("parent_deptid <=", value, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidLike(String value) {
            addCriterion("parent_deptid like", value, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidNotLike(String value) {
            addCriterion("parent_deptid not like", value, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidIn(List<String> values) {
            addCriterion("parent_deptid in", values, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidNotIn(List<String> values) {
            addCriterion("parent_deptid not in", values, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidBetween(String value1, String value2) {
            addCriterion("parent_deptid between", value1, value2, "parentDeptid");
            return (Criteria) this;
        }

        public Criteria andParentDeptidNotBetween(String value1, String value2) {
            addCriterion("parent_deptid not between", value1, value2, "parentDeptid");
            return (Criteria) this;
        }
    }

    /**
     * dept_info
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * dept_info null
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