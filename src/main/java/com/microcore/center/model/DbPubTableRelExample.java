package com.microcore.center.model;

import java.util.ArrayList;
import java.util.List;

public class DbPubTableRelExample {
    /**
     * db_pub_table_rel
     */
    protected String orderByClause;

    /**
     * db_pub_table_rel
     */
    protected boolean distinct;

    /**
     * db_pub_table_rel
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbPubTableRelExample() {
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
     * db_pub_table_rel null
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

        public Criteria andPubIdIsNull() {
            addCriterion("pub_id is null");
            return (Criteria) this;
        }

        public Criteria andPubIdIsNotNull() {
            addCriterion("pub_id is not null");
            return (Criteria) this;
        }

        public Criteria andPubIdEqualTo(String value) {
            addCriterion("pub_id =", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdNotEqualTo(String value) {
            addCriterion("pub_id <>", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdGreaterThan(String value) {
            addCriterion("pub_id >", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdGreaterThanOrEqualTo(String value) {
            addCriterion("pub_id >=", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdLessThan(String value) {
            addCriterion("pub_id <", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdLessThanOrEqualTo(String value) {
            addCriterion("pub_id <=", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdLike(String value) {
            addCriterion("pub_id like", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdNotLike(String value) {
            addCriterion("pub_id not like", value, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdIn(List<String> values) {
            addCriterion("pub_id in", values, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdNotIn(List<String> values) {
            addCriterion("pub_id not in", values, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdBetween(String value1, String value2) {
            addCriterion("pub_id between", value1, value2, "pubId");
            return (Criteria) this;
        }

        public Criteria andPubIdNotBetween(String value1, String value2) {
            addCriterion("pub_id not between", value1, value2, "pubId");
            return (Criteria) this;
        }

        public Criteria andTableName1IsNull() {
            addCriterion("table_name1 is null");
            return (Criteria) this;
        }

        public Criteria andTableName1IsNotNull() {
            addCriterion("table_name1 is not null");
            return (Criteria) this;
        }

        public Criteria andTableName1EqualTo(String value) {
            addCriterion("table_name1 =", value, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1NotEqualTo(String value) {
            addCriterion("table_name1 <>", value, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1GreaterThan(String value) {
            addCriterion("table_name1 >", value, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1GreaterThanOrEqualTo(String value) {
            addCriterion("table_name1 >=", value, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1LessThan(String value) {
            addCriterion("table_name1 <", value, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1LessThanOrEqualTo(String value) {
            addCriterion("table_name1 <=", value, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1Like(String value) {
            addCriterion("table_name1 like", value, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1NotLike(String value) {
            addCriterion("table_name1 not like", value, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1In(List<String> values) {
            addCriterion("table_name1 in", values, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1NotIn(List<String> values) {
            addCriterion("table_name1 not in", values, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1Between(String value1, String value2) {
            addCriterion("table_name1 between", value1, value2, "tableName1");
            return (Criteria) this;
        }

        public Criteria andTableName1NotBetween(String value1, String value2) {
            addCriterion("table_name1 not between", value1, value2, "tableName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1IsNull() {
            addCriterion("column_name1 is null");
            return (Criteria) this;
        }

        public Criteria andColumnName1IsNotNull() {
            addCriterion("column_name1 is not null");
            return (Criteria) this;
        }

        public Criteria andColumnName1EqualTo(String value) {
            addCriterion("column_name1 =", value, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1NotEqualTo(String value) {
            addCriterion("column_name1 <>", value, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1GreaterThan(String value) {
            addCriterion("column_name1 >", value, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1GreaterThanOrEqualTo(String value) {
            addCriterion("column_name1 >=", value, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1LessThan(String value) {
            addCriterion("column_name1 <", value, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1LessThanOrEqualTo(String value) {
            addCriterion("column_name1 <=", value, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1Like(String value) {
            addCriterion("column_name1 like", value, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1NotLike(String value) {
            addCriterion("column_name1 not like", value, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1In(List<String> values) {
            addCriterion("column_name1 in", values, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1NotIn(List<String> values) {
            addCriterion("column_name1 not in", values, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1Between(String value1, String value2) {
            addCriterion("column_name1 between", value1, value2, "columnName1");
            return (Criteria) this;
        }

        public Criteria andColumnName1NotBetween(String value1, String value2) {
            addCriterion("column_name1 not between", value1, value2, "columnName1");
            return (Criteria) this;
        }

        public Criteria andTableName2IsNull() {
            addCriterion("table_name2 is null");
            return (Criteria) this;
        }

        public Criteria andTableName2IsNotNull() {
            addCriterion("table_name2 is not null");
            return (Criteria) this;
        }

        public Criteria andTableName2EqualTo(String value) {
            addCriterion("table_name2 =", value, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2NotEqualTo(String value) {
            addCriterion("table_name2 <>", value, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2GreaterThan(String value) {
            addCriterion("table_name2 >", value, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2GreaterThanOrEqualTo(String value) {
            addCriterion("table_name2 >=", value, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2LessThan(String value) {
            addCriterion("table_name2 <", value, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2LessThanOrEqualTo(String value) {
            addCriterion("table_name2 <=", value, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2Like(String value) {
            addCriterion("table_name2 like", value, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2NotLike(String value) {
            addCriterion("table_name2 not like", value, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2In(List<String> values) {
            addCriterion("table_name2 in", values, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2NotIn(List<String> values) {
            addCriterion("table_name2 not in", values, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2Between(String value1, String value2) {
            addCriterion("table_name2 between", value1, value2, "tableName2");
            return (Criteria) this;
        }

        public Criteria andTableName2NotBetween(String value1, String value2) {
            addCriterion("table_name2 not between", value1, value2, "tableName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2IsNull() {
            addCriterion("column_name2 is null");
            return (Criteria) this;
        }

        public Criteria andColumnName2IsNotNull() {
            addCriterion("column_name2 is not null");
            return (Criteria) this;
        }

        public Criteria andColumnName2EqualTo(String value) {
            addCriterion("column_name2 =", value, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2NotEqualTo(String value) {
            addCriterion("column_name2 <>", value, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2GreaterThan(String value) {
            addCriterion("column_name2 >", value, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2GreaterThanOrEqualTo(String value) {
            addCriterion("column_name2 >=", value, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2LessThan(String value) {
            addCriterion("column_name2 <", value, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2LessThanOrEqualTo(String value) {
            addCriterion("column_name2 <=", value, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2Like(String value) {
            addCriterion("column_name2 like", value, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2NotLike(String value) {
            addCriterion("column_name2 not like", value, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2In(List<String> values) {
            addCriterion("column_name2 in", values, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2NotIn(List<String> values) {
            addCriterion("column_name2 not in", values, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2Between(String value1, String value2) {
            addCriterion("column_name2 between", value1, value2, "columnName2");
            return (Criteria) this;
        }

        public Criteria andColumnName2NotBetween(String value1, String value2) {
            addCriterion("column_name2 not between", value1, value2, "columnName2");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }
    }

    /**
     * db_pub_table_rel
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_pub_table_rel null
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