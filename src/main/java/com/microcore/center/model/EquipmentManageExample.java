package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentManageExample {
    /**
     * equipment_manage
     */
    protected String orderByClause;

    /**
     * equipment_manage
     */
    protected boolean distinct;

    /**
     * equipment_manage
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public EquipmentManageExample() {
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
     * equipment_manage null
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

        public Criteria andChargeUserIsNull() {
            addCriterion("charge_user is null");
            return (Criteria) this;
        }

        public Criteria andChargeUserIsNotNull() {
            addCriterion("charge_user is not null");
            return (Criteria) this;
        }

        public Criteria andChargeUserEqualTo(String value) {
            addCriterion("charge_user =", value, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserNotEqualTo(String value) {
            addCriterion("charge_user <>", value, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserGreaterThan(String value) {
            addCriterion("charge_user >", value, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserGreaterThanOrEqualTo(String value) {
            addCriterion("charge_user >=", value, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserLessThan(String value) {
            addCriterion("charge_user <", value, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserLessThanOrEqualTo(String value) {
            addCriterion("charge_user <=", value, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserLike(String value) {
            addCriterion("charge_user like", value, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserNotLike(String value) {
            addCriterion("charge_user not like", value, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserIn(List<String> values) {
            addCriterion("charge_user in", values, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserNotIn(List<String> values) {
            addCriterion("charge_user not in", values, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserBetween(String value1, String value2) {
            addCriterion("charge_user between", value1, value2, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andChargeUserNotBetween(String value1, String value2) {
            addCriterion("charge_user not between", value1, value2, "chargeUser");
            return (Criteria) this;
        }

        public Criteria andAlarmNumIsNull() {
            addCriterion("alarm_num is null");
            return (Criteria) this;
        }

        public Criteria andAlarmNumIsNotNull() {
            addCriterion("alarm_num is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmNumEqualTo(String value) {
            addCriterion("alarm_num =", value, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumNotEqualTo(String value) {
            addCriterion("alarm_num <>", value, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumGreaterThan(String value) {
            addCriterion("alarm_num >", value, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_num >=", value, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumLessThan(String value) {
            addCriterion("alarm_num <", value, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumLessThanOrEqualTo(String value) {
            addCriterion("alarm_num <=", value, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumLike(String value) {
            addCriterion("alarm_num like", value, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumNotLike(String value) {
            addCriterion("alarm_num not like", value, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumIn(List<String> values) {
            addCriterion("alarm_num in", values, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumNotIn(List<String> values) {
            addCriterion("alarm_num not in", values, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumBetween(String value1, String value2) {
            addCriterion("alarm_num between", value1, value2, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andAlarmNumNotBetween(String value1, String value2) {
            addCriterion("alarm_num not between", value1, value2, "alarmNum");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIsNull() {
            addCriterion("equi_type is null");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIsNotNull() {
            addCriterion("equi_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquiTypeEqualTo(String value) {
            addCriterion("equi_type =", value, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeNotEqualTo(String value) {
            addCriterion("equi_type <>", value, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeGreaterThan(String value) {
            addCriterion("equi_type >", value, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equi_type >=", value, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeLessThan(String value) {
            addCriterion("equi_type <", value, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeLessThanOrEqualTo(String value) {
            addCriterion("equi_type <=", value, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeLike(String value) {
            addCriterion("equi_type like", value, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeNotLike(String value) {
            addCriterion("equi_type not like", value, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIn(List<String> values) {
            addCriterion("equi_type in", values, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeNotIn(List<String> values) {
            addCriterion("equi_type not in", values, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeBetween(String value1, String value2) {
            addCriterion("equi_type between", value1, value2, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeNotBetween(String value1, String value2) {
            addCriterion("equi_type not between", value1, value2, "equiType");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdIsNull() {
            addCriterion("equi_type_id is null");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdIsNotNull() {
            addCriterion("equi_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdEqualTo(String value) {
            addCriterion("equi_type_id =", value, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdNotEqualTo(String value) {
            addCriterion("equi_type_id <>", value, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdGreaterThan(String value) {
            addCriterion("equi_type_id >", value, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("equi_type_id >=", value, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdLessThan(String value) {
            addCriterion("equi_type_id <", value, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdLessThanOrEqualTo(String value) {
            addCriterion("equi_type_id <=", value, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdLike(String value) {
            addCriterion("equi_type_id like", value, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdNotLike(String value) {
            addCriterion("equi_type_id not like", value, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdIn(List<String> values) {
            addCriterion("equi_type_id in", values, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdNotIn(List<String> values) {
            addCriterion("equi_type_id not in", values, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdBetween(String value1, String value2) {
            addCriterion("equi_type_id between", value1, value2, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andEquiTypeIdNotBetween(String value1, String value2) {
            addCriterion("equi_type_id not between", value1, value2, "equiTypeId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceIsNull() {
            addCriterion("equi_place is null");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceIsNotNull() {
            addCriterion("equi_place is not null");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceEqualTo(String value) {
            addCriterion("equi_place =", value, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceNotEqualTo(String value) {
            addCriterion("equi_place <>", value, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceGreaterThan(String value) {
            addCriterion("equi_place >", value, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("equi_place >=", value, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceLessThan(String value) {
            addCriterion("equi_place <", value, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceLessThanOrEqualTo(String value) {
            addCriterion("equi_place <=", value, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceLike(String value) {
            addCriterion("equi_place like", value, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceNotLike(String value) {
            addCriterion("equi_place not like", value, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceIn(List<String> values) {
            addCriterion("equi_place in", values, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceNotIn(List<String> values) {
            addCriterion("equi_place not in", values, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceBetween(String value1, String value2) {
            addCriterion("equi_place between", value1, value2, "equiPlace");
            return (Criteria) this;
        }

        public Criteria andEquiPlaceNotBetween(String value1, String value2) {
            addCriterion("equi_place not between", value1, value2, "equiPlace");
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

        public Criteria andTroubleIsNull() {
            addCriterion("trouble is null");
            return (Criteria) this;
        }

        public Criteria andTroubleIsNotNull() {
            addCriterion("trouble is not null");
            return (Criteria) this;
        }

        public Criteria andTroubleEqualTo(String value) {
            addCriterion("trouble =", value, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleNotEqualTo(String value) {
            addCriterion("trouble <>", value, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleGreaterThan(String value) {
            addCriterion("trouble >", value, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleGreaterThanOrEqualTo(String value) {
            addCriterion("trouble >=", value, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleLessThan(String value) {
            addCriterion("trouble <", value, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleLessThanOrEqualTo(String value) {
            addCriterion("trouble <=", value, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleLike(String value) {
            addCriterion("trouble like", value, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleNotLike(String value) {
            addCriterion("trouble not like", value, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleIn(List<String> values) {
            addCriterion("trouble in", values, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleNotIn(List<String> values) {
            addCriterion("trouble not in", values, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleBetween(String value1, String value2) {
            addCriterion("trouble between", value1, value2, "trouble");
            return (Criteria) this;
        }

        public Criteria andTroubleNotBetween(String value1, String value2) {
            addCriterion("trouble not between", value1, value2, "trouble");
            return (Criteria) this;
        }

        public Criteria andOnlineTmIsNull() {
            addCriterion("online_tm is null");
            return (Criteria) this;
        }

        public Criteria andOnlineTmIsNotNull() {
            addCriterion("online_tm is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineTmEqualTo(Date value) {
            addCriterion("online_tm =", value, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andOnlineTmNotEqualTo(Date value) {
            addCriterion("online_tm <>", value, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andOnlineTmGreaterThan(Date value) {
            addCriterion("online_tm >", value, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andOnlineTmGreaterThanOrEqualTo(Date value) {
            addCriterion("online_tm >=", value, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andOnlineTmLessThan(Date value) {
            addCriterion("online_tm <", value, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andOnlineTmLessThanOrEqualTo(Date value) {
            addCriterion("online_tm <=", value, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andOnlineTmIn(List<Date> values) {
            addCriterion("online_tm in", values, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andOnlineTmNotIn(List<Date> values) {
            addCriterion("online_tm not in", values, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andOnlineTmBetween(Date value1, Date value2) {
            addCriterion("online_tm between", value1, value2, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andOnlineTmNotBetween(Date value1, Date value2) {
            addCriterion("online_tm not between", value1, value2, "onlineTm");
            return (Criteria) this;
        }

        public Criteria andUpStatusIsNull() {
            addCriterion("up_status is null");
            return (Criteria) this;
        }

        public Criteria andUpStatusIsNotNull() {
            addCriterion("up_status is not null");
            return (Criteria) this;
        }

        public Criteria andUpStatusEqualTo(String value) {
            addCriterion("up_status =", value, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusNotEqualTo(String value) {
            addCriterion("up_status <>", value, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusGreaterThan(String value) {
            addCriterion("up_status >", value, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusGreaterThanOrEqualTo(String value) {
            addCriterion("up_status >=", value, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusLessThan(String value) {
            addCriterion("up_status <", value, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusLessThanOrEqualTo(String value) {
            addCriterion("up_status <=", value, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusLike(String value) {
            addCriterion("up_status like", value, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusNotLike(String value) {
            addCriterion("up_status not like", value, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusIn(List<String> values) {
            addCriterion("up_status in", values, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusNotIn(List<String> values) {
            addCriterion("up_status not in", values, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusBetween(String value1, String value2) {
            addCriterion("up_status between", value1, value2, "upStatus");
            return (Criteria) this;
        }

        public Criteria andUpStatusNotBetween(String value1, String value2) {
            addCriterion("up_status not between", value1, value2, "upStatus");
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
     * equipment_manage
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * equipment_manage null
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