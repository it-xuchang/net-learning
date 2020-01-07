package com.netlearning.framework.domain.fss;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Long value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Long value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Long value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Long value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Long> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Long> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Long value1, Long value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(String value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(String value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(String value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(String value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(String value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLike(String value) {
            addCriterion("content_type like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotLike(String value) {
            addCriterion("content_type not like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<String> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<String> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(String value1, String value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(String value1, String value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameIsNull() {
            addCriterion("remote_file_name is null");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameIsNotNull() {
            addCriterion("remote_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameEqualTo(String value) {
            addCriterion("remote_file_name =", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameNotEqualTo(String value) {
            addCriterion("remote_file_name <>", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameGreaterThan(String value) {
            addCriterion("remote_file_name >", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("remote_file_name >=", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameLessThan(String value) {
            addCriterion("remote_file_name <", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameLessThanOrEqualTo(String value) {
            addCriterion("remote_file_name <=", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameLike(String value) {
            addCriterion("remote_file_name like", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameNotLike(String value) {
            addCriterion("remote_file_name not like", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameIn(List<String> values) {
            addCriterion("remote_file_name in", values, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameNotIn(List<String> values) {
            addCriterion("remote_file_name not in", values, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameBetween(String value1, String value2) {
            addCriterion("remote_file_name between", value1, value2, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameNotBetween(String value1, String value2) {
            addCriterion("remote_file_name not between", value1, value2, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Long value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Long value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Long value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Long value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Long> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Long> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Long value1, Long value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathIsNull() {
            addCriterion("file_absolute_path is null");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathIsNotNull() {
            addCriterion("file_absolute_path is not null");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathEqualTo(String value) {
            addCriterion("file_absolute_path =", value, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathNotEqualTo(String value) {
            addCriterion("file_absolute_path <>", value, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathGreaterThan(String value) {
            addCriterion("file_absolute_path >", value, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_absolute_path >=", value, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathLessThan(String value) {
            addCriterion("file_absolute_path <", value, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathLessThanOrEqualTo(String value) {
            addCriterion("file_absolute_path <=", value, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathLike(String value) {
            addCriterion("file_absolute_path like", value, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathNotLike(String value) {
            addCriterion("file_absolute_path not like", value, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathIn(List<String> values) {
            addCriterion("file_absolute_path in", values, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathNotIn(List<String> values) {
            addCriterion("file_absolute_path not in", values, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathBetween(String value1, String value2) {
            addCriterion("file_absolute_path between", value1, value2, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andFileAbsolutePathNotBetween(String value1, String value2) {
            addCriterion("file_absolute_path not between", value1, value2, "fileAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andUniqueIdIsNull() {
            addCriterion("unique_id is null");
            return (Criteria) this;
        }

        public Criteria andUniqueIdIsNotNull() {
            addCriterion("unique_id is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueIdEqualTo(Long value) {
            addCriterion("unique_id =", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdNotEqualTo(Long value) {
            addCriterion("unique_id <>", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdGreaterThan(Long value) {
            addCriterion("unique_id >", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("unique_id >=", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdLessThan(Long value) {
            addCriterion("unique_id <", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdLessThanOrEqualTo(Long value) {
            addCriterion("unique_id <=", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdIn(List<Long> values) {
            addCriterion("unique_id in", values, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdNotIn(List<Long> values) {
            addCriterion("unique_id not in", values, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdBetween(Long value1, Long value2) {
            addCriterion("unique_id between", value1, value2, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdNotBetween(Long value1, Long value2) {
            addCriterion("unique_id not between", value1, value2, "uniqueId");
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

        public Criteria andOrigFileNameIsNull() {
            addCriterion("orig_file_name is null");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameIsNotNull() {
            addCriterion("orig_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameEqualTo(String value) {
            addCriterion("orig_file_name =", value, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameNotEqualTo(String value) {
            addCriterion("orig_file_name <>", value, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameGreaterThan(String value) {
            addCriterion("orig_file_name >", value, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("orig_file_name >=", value, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameLessThan(String value) {
            addCriterion("orig_file_name <", value, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameLessThanOrEqualTo(String value) {
            addCriterion("orig_file_name <=", value, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameLike(String value) {
            addCriterion("orig_file_name like", value, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameNotLike(String value) {
            addCriterion("orig_file_name not like", value, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameIn(List<String> values) {
            addCriterion("orig_file_name in", values, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameNotIn(List<String> values) {
            addCriterion("orig_file_name not in", values, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameBetween(String value1, String value2) {
            addCriterion("orig_file_name between", value1, value2, "origFileName");
            return (Criteria) this;
        }

        public Criteria andOrigFileNameNotBetween(String value1, String value2) {
            addCriterion("orig_file_name not between", value1, value2, "origFileName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdIsNull() {
            addCriterion("from_system_id is null");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdIsNotNull() {
            addCriterion("from_system_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdEqualTo(Long value) {
            addCriterion("from_system_id =", value, "fromSystemId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdNotEqualTo(Long value) {
            addCriterion("from_system_id <>", value, "fromSystemId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdGreaterThan(Long value) {
            addCriterion("from_system_id >", value, "fromSystemId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("from_system_id >=", value, "fromSystemId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdLessThan(Long value) {
            addCriterion("from_system_id <", value, "fromSystemId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdLessThanOrEqualTo(Long value) {
            addCriterion("from_system_id <=", value, "fromSystemId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdIn(List<Long> values) {
            addCriterion("from_system_id in", values, "fromSystemId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdNotIn(List<Long> values) {
            addCriterion("from_system_id not in", values, "fromSystemId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdBetween(Long value1, Long value2) {
            addCriterion("from_system_id between", value1, value2, "fromSystemId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIdNotBetween(Long value1, Long value2) {
            addCriterion("from_system_id not between", value1, value2, "fromSystemId");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
