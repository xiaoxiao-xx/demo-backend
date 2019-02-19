package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PsmPersonInfoExample {
    /**
     * psm_person_info_t
     */
    protected String orderByClause;

    /**
     * psm_person_info_t
     */
    protected boolean distinct;

    /**
     * psm_person_info_t
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public PsmPersonInfoExample() {
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
     * psm_person_info_t null
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

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(String value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(String value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(String value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(String value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(String value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLike(String value) {
            addCriterion("person_id like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotLike(String value) {
            addCriterion("person_id not like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<String> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<String> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(String value1, String value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(String value1, String value2) {
            addCriterion("person_id not between", value1, value2, "personId");
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

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Date value) {
            addCriterionForJDBCDate("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Date value) {
            addCriterionForJDBCDate("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<Date> values) {
            addCriterionForJDBCDate("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNull() {
            addCriterion("join_date is null");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNotNull() {
            addCriterion("join_date is not null");
            return (Criteria) this;
        }

        public Criteria andJoinDateEqualTo(Date value) {
            addCriterionForJDBCDate("join_date =", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("join_date <>", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThan(Date value) {
            addCriterionForJDBCDate("join_date >", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("join_date >=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThan(Date value) {
            addCriterionForJDBCDate("join_date <", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("join_date <=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateIn(List<Date> values) {
            addCriterionForJDBCDate("join_date in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("join_date not in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("join_date between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("join_date not between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(String value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(String value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(String value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(String value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(String value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(String value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLike(String value) {
            addCriterion("rank like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotLike(String value) {
            addCriterion("rank not like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<String> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<String> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(String value1, String value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(String value1, String value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1IsNull() {
            addCriterion("personal_photo1 is null");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1IsNotNull() {
            addCriterion("personal_photo1 is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1EqualTo(String value) {
            addCriterion("personal_photo1 =", value, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1NotEqualTo(String value) {
            addCriterion("personal_photo1 <>", value, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1GreaterThan(String value) {
            addCriterion("personal_photo1 >", value, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1GreaterThanOrEqualTo(String value) {
            addCriterion("personal_photo1 >=", value, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1LessThan(String value) {
            addCriterion("personal_photo1 <", value, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1LessThanOrEqualTo(String value) {
            addCriterion("personal_photo1 <=", value, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1Like(String value) {
            addCriterion("personal_photo1 like", value, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1NotLike(String value) {
            addCriterion("personal_photo1 not like", value, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1In(List<String> values) {
            addCriterion("personal_photo1 in", values, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1NotIn(List<String> values) {
            addCriterion("personal_photo1 not in", values, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1Between(String value1, String value2) {
            addCriterion("personal_photo1 between", value1, value2, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto1NotBetween(String value1, String value2) {
            addCriterion("personal_photo1 not between", value1, value2, "personalPhoto1");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2IsNull() {
            addCriterion("personal_photo2 is null");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2IsNotNull() {
            addCriterion("personal_photo2 is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2EqualTo(String value) {
            addCriterion("personal_photo2 =", value, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2NotEqualTo(String value) {
            addCriterion("personal_photo2 <>", value, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2GreaterThan(String value) {
            addCriterion("personal_photo2 >", value, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2GreaterThanOrEqualTo(String value) {
            addCriterion("personal_photo2 >=", value, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2LessThan(String value) {
            addCriterion("personal_photo2 <", value, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2LessThanOrEqualTo(String value) {
            addCriterion("personal_photo2 <=", value, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2Like(String value) {
            addCriterion("personal_photo2 like", value, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2NotLike(String value) {
            addCriterion("personal_photo2 not like", value, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2In(List<String> values) {
            addCriterion("personal_photo2 in", values, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2NotIn(List<String> values) {
            addCriterion("personal_photo2 not in", values, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2Between(String value1, String value2) {
            addCriterion("personal_photo2 between", value1, value2, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoto2NotBetween(String value1, String value2) {
            addCriterion("personal_photo2 not between", value1, value2, "personalPhoto2");
            return (Criteria) this;
        }

        public Criteria andCareStatusIsNull() {
            addCriterion("care_status is null");
            return (Criteria) this;
        }

        public Criteria andCareStatusIsNotNull() {
            addCriterion("care_status is not null");
            return (Criteria) this;
        }

        public Criteria andCareStatusEqualTo(String value) {
            addCriterion("care_status =", value, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusNotEqualTo(String value) {
            addCriterion("care_status <>", value, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusGreaterThan(String value) {
            addCriterion("care_status >", value, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusGreaterThanOrEqualTo(String value) {
            addCriterion("care_status >=", value, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusLessThan(String value) {
            addCriterion("care_status <", value, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusLessThanOrEqualTo(String value) {
            addCriterion("care_status <=", value, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusLike(String value) {
            addCriterion("care_status like", value, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusNotLike(String value) {
            addCriterion("care_status not like", value, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusIn(List<String> values) {
            addCriterion("care_status in", values, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusNotIn(List<String> values) {
            addCriterion("care_status not in", values, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusBetween(String value1, String value2) {
            addCriterion("care_status between", value1, value2, "careStatus");
            return (Criteria) this;
        }

        public Criteria andCareStatusNotBetween(String value1, String value2) {
            addCriterion("care_status not between", value1, value2, "careStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusIsNull() {
            addCriterion("impt_care_status is null");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusIsNotNull() {
            addCriterion("impt_care_status is not null");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusEqualTo(String value) {
            addCriterion("impt_care_status =", value, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusNotEqualTo(String value) {
            addCriterion("impt_care_status <>", value, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusGreaterThan(String value) {
            addCriterion("impt_care_status >", value, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusGreaterThanOrEqualTo(String value) {
            addCriterion("impt_care_status >=", value, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusLessThan(String value) {
            addCriterion("impt_care_status <", value, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusLessThanOrEqualTo(String value) {
            addCriterion("impt_care_status <=", value, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusLike(String value) {
            addCriterion("impt_care_status like", value, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusNotLike(String value) {
            addCriterion("impt_care_status not like", value, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusIn(List<String> values) {
            addCriterion("impt_care_status in", values, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusNotIn(List<String> values) {
            addCriterion("impt_care_status not in", values, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusBetween(String value1, String value2) {
            addCriterion("impt_care_status between", value1, value2, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareStatusNotBetween(String value1, String value2) {
            addCriterion("impt_care_status not between", value1, value2, "imptCareStatus");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonIsNull() {
            addCriterion("impt_care_reason is null");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonIsNotNull() {
            addCriterion("impt_care_reason is not null");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonEqualTo(String value) {
            addCriterion("impt_care_reason =", value, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonNotEqualTo(String value) {
            addCriterion("impt_care_reason <>", value, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonGreaterThan(String value) {
            addCriterion("impt_care_reason >", value, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonGreaterThanOrEqualTo(String value) {
            addCriterion("impt_care_reason >=", value, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonLessThan(String value) {
            addCriterion("impt_care_reason <", value, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonLessThanOrEqualTo(String value) {
            addCriterion("impt_care_reason <=", value, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonLike(String value) {
            addCriterion("impt_care_reason like", value, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonNotLike(String value) {
            addCriterion("impt_care_reason not like", value, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonIn(List<String> values) {
            addCriterion("impt_care_reason in", values, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonNotIn(List<String> values) {
            addCriterion("impt_care_reason not in", values, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonBetween(String value1, String value2) {
            addCriterion("impt_care_reason between", value1, value2, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andImptCareReasonNotBetween(String value1, String value2) {
            addCriterion("impt_care_reason not between", value1, value2, "imptCareReason");
            return (Criteria) this;
        }

        public Criteria andParaIsNull() {
            addCriterion("para is null");
            return (Criteria) this;
        }

        public Criteria andParaIsNotNull() {
            addCriterion("para is not null");
            return (Criteria) this;
        }

        public Criteria andParaEqualTo(String value) {
            addCriterion("para =", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotEqualTo(String value) {
            addCriterion("para <>", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaGreaterThan(String value) {
            addCriterion("para >", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaGreaterThanOrEqualTo(String value) {
            addCriterion("para >=", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaLessThan(String value) {
            addCriterion("para <", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaLessThanOrEqualTo(String value) {
            addCriterion("para <=", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaLike(String value) {
            addCriterion("para like", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotLike(String value) {
            addCriterion("para not like", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaIn(List<String> values) {
            addCriterion("para in", values, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotIn(List<String> values) {
            addCriterion("para not in", values, "para");
            return (Criteria) this;
        }

        public Criteria andParaBetween(String value1, String value2) {
            addCriterion("para between", value1, value2, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotBetween(String value1, String value2) {
            addCriterion("para not between", value1, value2, "para");
            return (Criteria) this;
        }
    }

    /**
     * psm_person_info_t
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * psm_person_info_t null
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