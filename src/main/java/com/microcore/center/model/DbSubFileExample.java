package com.microcore.center.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbSubFileExample {
    /**
     * db_sub_file
     */
    protected String orderByClause;

    /**
     * db_sub_file
     */
    protected boolean distinct;

    /**
     * db_sub_file
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DbSubFileExample() {
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
     * db_sub_file null
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

        public Criteria andSubIdIsNull() {
            addCriterion("sub_id is null");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNotNull() {
            addCriterion("sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubIdEqualTo(String value) {
            addCriterion("sub_id =", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotEqualTo(String value) {
            addCriterion("sub_id <>", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThan(String value) {
            addCriterion("sub_id >", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_id >=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThan(String value) {
            addCriterion("sub_id <", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThanOrEqualTo(String value) {
            addCriterion("sub_id <=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLike(String value) {
            addCriterion("sub_id like", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotLike(String value) {
            addCriterion("sub_id not like", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdIn(List<String> values) {
            addCriterion("sub_id in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotIn(List<String> values) {
            addCriterion("sub_id not in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdBetween(String value1, String value2) {
            addCriterion("sub_id between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotBetween(String value1, String value2) {
            addCriterion("sub_id not between", value1, value2, "subId");
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

        public Criteria andSubNameIsNull() {
            addCriterion("sub_name is null");
            return (Criteria) this;
        }

        public Criteria andSubNameIsNotNull() {
            addCriterion("sub_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubNameEqualTo(String value) {
            addCriterion("sub_name =", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotEqualTo(String value) {
            addCriterion("sub_name <>", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThan(String value) {
            addCriterion("sub_name >", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_name >=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThan(String value) {
            addCriterion("sub_name <", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThanOrEqualTo(String value) {
            addCriterion("sub_name <=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLike(String value) {
            addCriterion("sub_name like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotLike(String value) {
            addCriterion("sub_name not like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameIn(List<String> values) {
            addCriterion("sub_name in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotIn(List<String> values) {
            addCriterion("sub_name not in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameBetween(String value1, String value2) {
            addCriterion("sub_name between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotBetween(String value1, String value2) {
            addCriterion("sub_name not between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andSubDescIsNull() {
            addCriterion("sub_desc is null");
            return (Criteria) this;
        }

        public Criteria andSubDescIsNotNull() {
            addCriterion("sub_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSubDescEqualTo(String value) {
            addCriterion("sub_desc =", value, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescNotEqualTo(String value) {
            addCriterion("sub_desc <>", value, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescGreaterThan(String value) {
            addCriterion("sub_desc >", value, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescGreaterThanOrEqualTo(String value) {
            addCriterion("sub_desc >=", value, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescLessThan(String value) {
            addCriterion("sub_desc <", value, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescLessThanOrEqualTo(String value) {
            addCriterion("sub_desc <=", value, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescLike(String value) {
            addCriterion("sub_desc like", value, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescNotLike(String value) {
            addCriterion("sub_desc not like", value, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescIn(List<String> values) {
            addCriterion("sub_desc in", values, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescNotIn(List<String> values) {
            addCriterion("sub_desc not in", values, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescBetween(String value1, String value2) {
            addCriterion("sub_desc between", value1, value2, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubDescNotBetween(String value1, String value2) {
            addCriterion("sub_desc not between", value1, value2, "subDesc");
            return (Criteria) this;
        }

        public Criteria andSubPathIsNull() {
            addCriterion("sub_path is null");
            return (Criteria) this;
        }

        public Criteria andSubPathIsNotNull() {
            addCriterion("sub_path is not null");
            return (Criteria) this;
        }

        public Criteria andSubPathEqualTo(String value) {
            addCriterion("sub_path =", value, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathNotEqualTo(String value) {
            addCriterion("sub_path <>", value, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathGreaterThan(String value) {
            addCriterion("sub_path >", value, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathGreaterThanOrEqualTo(String value) {
            addCriterion("sub_path >=", value, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathLessThan(String value) {
            addCriterion("sub_path <", value, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathLessThanOrEqualTo(String value) {
            addCriterion("sub_path <=", value, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathLike(String value) {
            addCriterion("sub_path like", value, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathNotLike(String value) {
            addCriterion("sub_path not like", value, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathIn(List<String> values) {
            addCriterion("sub_path in", values, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathNotIn(List<String> values) {
            addCriterion("sub_path not in", values, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathBetween(String value1, String value2) {
            addCriterion("sub_path between", value1, value2, "subPath");
            return (Criteria) this;
        }

        public Criteria andSubPathNotBetween(String value1, String value2) {
            addCriterion("sub_path not between", value1, value2, "subPath");
            return (Criteria) this;
        }

        public Criteria andLocPathIsNull() {
            addCriterion("loc_path is null");
            return (Criteria) this;
        }

        public Criteria andLocPathIsNotNull() {
            addCriterion("loc_path is not null");
            return (Criteria) this;
        }

        public Criteria andLocPathEqualTo(String value) {
            addCriterion("loc_path =", value, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathNotEqualTo(String value) {
            addCriterion("loc_path <>", value, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathGreaterThan(String value) {
            addCriterion("loc_path >", value, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathGreaterThanOrEqualTo(String value) {
            addCriterion("loc_path >=", value, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathLessThan(String value) {
            addCriterion("loc_path <", value, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathLessThanOrEqualTo(String value) {
            addCriterion("loc_path <=", value, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathLike(String value) {
            addCriterion("loc_path like", value, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathNotLike(String value) {
            addCriterion("loc_path not like", value, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathIn(List<String> values) {
            addCriterion("loc_path in", values, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathNotIn(List<String> values) {
            addCriterion("loc_path not in", values, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathBetween(String value1, String value2) {
            addCriterion("loc_path between", value1, value2, "locPath");
            return (Criteria) this;
        }

        public Criteria andLocPathNotBetween(String value1, String value2) {
            addCriterion("loc_path not between", value1, value2, "locPath");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNull() {
            addCriterion("extract_type is null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNotNull() {
            addCriterion("extract_type is not null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeEqualTo(String value) {
            addCriterion("extract_type =", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotEqualTo(String value) {
            addCriterion("extract_type <>", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThan(String value) {
            addCriterion("extract_type >", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("extract_type >=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThan(String value) {
            addCriterion("extract_type <", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThanOrEqualTo(String value) {
            addCriterion("extract_type <=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLike(String value) {
            addCriterion("extract_type like", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotLike(String value) {
            addCriterion("extract_type not like", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIn(List<String> values) {
            addCriterion("extract_type in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotIn(List<String> values) {
            addCriterion("extract_type not in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeBetween(String value1, String value2) {
            addCriterion("extract_type between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotBetween(String value1, String value2) {
            addCriterion("extract_type not between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andBackupPathIsNull() {
            addCriterion("backup_path is null");
            return (Criteria) this;
        }

        public Criteria andBackupPathIsNotNull() {
            addCriterion("backup_path is not null");
            return (Criteria) this;
        }

        public Criteria andBackupPathEqualTo(String value) {
            addCriterion("backup_path =", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathNotEqualTo(String value) {
            addCriterion("backup_path <>", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathGreaterThan(String value) {
            addCriterion("backup_path >", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathGreaterThanOrEqualTo(String value) {
            addCriterion("backup_path >=", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathLessThan(String value) {
            addCriterion("backup_path <", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathLessThanOrEqualTo(String value) {
            addCriterion("backup_path <=", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathLike(String value) {
            addCriterion("backup_path like", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathNotLike(String value) {
            addCriterion("backup_path not like", value, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathIn(List<String> values) {
            addCriterion("backup_path in", values, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathNotIn(List<String> values) {
            addCriterion("backup_path not in", values, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathBetween(String value1, String value2) {
            addCriterion("backup_path between", value1, value2, "backupPath");
            return (Criteria) this;
        }

        public Criteria andBackupPathNotBetween(String value1, String value2) {
            addCriterion("backup_path not between", value1, value2, "backupPath");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdIsNull() {
            addCriterion("exchange_info_id is null");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdIsNotNull() {
            addCriterion("exchange_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdEqualTo(String value) {
            addCriterion("exchange_info_id =", value, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdNotEqualTo(String value) {
            addCriterion("exchange_info_id <>", value, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdGreaterThan(String value) {
            addCriterion("exchange_info_id >", value, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_info_id >=", value, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdLessThan(String value) {
            addCriterion("exchange_info_id <", value, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdLessThanOrEqualTo(String value) {
            addCriterion("exchange_info_id <=", value, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdLike(String value) {
            addCriterion("exchange_info_id like", value, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdNotLike(String value) {
            addCriterion("exchange_info_id not like", value, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdIn(List<String> values) {
            addCriterion("exchange_info_id in", values, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdNotIn(List<String> values) {
            addCriterion("exchange_info_id not in", values, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdBetween(String value1, String value2) {
            addCriterion("exchange_info_id between", value1, value2, "exchangeInfoId");
            return (Criteria) this;
        }

        public Criteria andExchangeInfoIdNotBetween(String value1, String value2) {
            addCriterion("exchange_info_id not between", value1, value2, "exchangeInfoId");
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

        public Criteria andRunStatusIsNull() {
            addCriterion("run_status is null");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNotNull() {
            addCriterion("run_status is not null");
            return (Criteria) this;
        }

        public Criteria andRunStatusEqualTo(String value) {
            addCriterion("run_status =", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotEqualTo(String value) {
            addCriterion("run_status <>", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThan(String value) {
            addCriterion("run_status >", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThanOrEqualTo(String value) {
            addCriterion("run_status >=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThan(String value) {
            addCriterion("run_status <", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThanOrEqualTo(String value) {
            addCriterion("run_status <=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLike(String value) {
            addCriterion("run_status like", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotLike(String value) {
            addCriterion("run_status not like", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusIn(List<String> values) {
            addCriterion("run_status in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotIn(List<String> values) {
            addCriterion("run_status not in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusBetween(String value1, String value2) {
            addCriterion("run_status between", value1, value2, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotBetween(String value1, String value2) {
            addCriterion("run_status not between", value1, value2, "runStatus");
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

        public Criteria andSubUserIdIsNull() {
            addCriterion("sub_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSubUserIdIsNotNull() {
            addCriterion("sub_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubUserIdEqualTo(String value) {
            addCriterion("sub_user_id =", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdNotEqualTo(String value) {
            addCriterion("sub_user_id <>", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdGreaterThan(String value) {
            addCriterion("sub_user_id >", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_user_id >=", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdLessThan(String value) {
            addCriterion("sub_user_id <", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdLessThanOrEqualTo(String value) {
            addCriterion("sub_user_id <=", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdLike(String value) {
            addCriterion("sub_user_id like", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdNotLike(String value) {
            addCriterion("sub_user_id not like", value, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdIn(List<String> values) {
            addCriterion("sub_user_id in", values, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdNotIn(List<String> values) {
            addCriterion("sub_user_id not in", values, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdBetween(String value1, String value2) {
            addCriterion("sub_user_id between", value1, value2, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubUserIdNotBetween(String value1, String value2) {
            addCriterion("sub_user_id not between", value1, value2, "subUserId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdIsNull() {
            addCriterion("sub_org_id is null");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdIsNotNull() {
            addCriterion("sub_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdEqualTo(String value) {
            addCriterion("sub_org_id =", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdNotEqualTo(String value) {
            addCriterion("sub_org_id <>", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdGreaterThan(String value) {
            addCriterion("sub_org_id >", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_org_id >=", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdLessThan(String value) {
            addCriterion("sub_org_id <", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdLessThanOrEqualTo(String value) {
            addCriterion("sub_org_id <=", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdLike(String value) {
            addCriterion("sub_org_id like", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdNotLike(String value) {
            addCriterion("sub_org_id not like", value, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdIn(List<String> values) {
            addCriterion("sub_org_id in", values, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdNotIn(List<String> values) {
            addCriterion("sub_org_id not in", values, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdBetween(String value1, String value2) {
            addCriterion("sub_org_id between", value1, value2, "subOrgId");
            return (Criteria) this;
        }

        public Criteria andSubOrgIdNotBetween(String value1, String value2) {
            addCriterion("sub_org_id not between", value1, value2, "subOrgId");
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
     * db_sub_file
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * db_sub_file null
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