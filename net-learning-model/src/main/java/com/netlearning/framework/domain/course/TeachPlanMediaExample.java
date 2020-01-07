package com.netlearning.framework.domain.course;

import java.util.ArrayList;
import java.util.List;

public class TeachPlanMediaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeachPlanMediaExample() {
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

        public Criteria andTeachplanMediaIdIsNull() {
            addCriterion("teachplan_media_id is null");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdIsNotNull() {
            addCriterion("teachplan_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdEqualTo(Long value) {
            addCriterion("teachplan_media_id =", value, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdNotEqualTo(Long value) {
            addCriterion("teachplan_media_id <>", value, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdGreaterThan(Long value) {
            addCriterion("teachplan_media_id >", value, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("teachplan_media_id >=", value, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdLessThan(Long value) {
            addCriterion("teachplan_media_id <", value, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdLessThanOrEqualTo(Long value) {
            addCriterion("teachplan_media_id <=", value, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdIn(List<Long> values) {
            addCriterion("teachplan_media_id in", values, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdNotIn(List<Long> values) {
            addCriterion("teachplan_media_id not in", values, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdBetween(Long value1, Long value2) {
            addCriterion("teachplan_media_id between", value1, value2, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaIdNotBetween(Long value1, Long value2) {
            addCriterion("teachplan_media_id not between", value1, value2, "teachplanMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdIsNull() {
            addCriterion("media_id is null");
            return (Criteria) this;
        }

        public Criteria andMediaIdIsNotNull() {
            addCriterion("media_id is not null");
            return (Criteria) this;
        }

        public Criteria andMediaIdEqualTo(Long value) {
            addCriterion("media_id =", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotEqualTo(Long value) {
            addCriterion("media_id <>", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdGreaterThan(Long value) {
            addCriterion("media_id >", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("media_id >=", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLessThan(Long value) {
            addCriterion("media_id <", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLessThanOrEqualTo(Long value) {
            addCriterion("media_id <=", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdIn(List<Long> values) {
            addCriterion("media_id in", values, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotIn(List<Long> values) {
            addCriterion("media_id not in", values, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdBetween(Long value1, Long value2) {
            addCriterion("media_id between", value1, value2, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotBetween(Long value1, Long value2) {
            addCriterion("media_id not between", value1, value2, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameIsNull() {
            addCriterion("media_fileoriginal_name is null");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameIsNotNull() {
            addCriterion("media_fileoriginal_name is not null");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameEqualTo(String value) {
            addCriterion("media_fileoriginal_name =", value, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameNotEqualTo(String value) {
            addCriterion("media_fileoriginal_name <>", value, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameGreaterThan(String value) {
            addCriterion("media_fileoriginal_name >", value, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameGreaterThanOrEqualTo(String value) {
            addCriterion("media_fileoriginal_name >=", value, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameLessThan(String value) {
            addCriterion("media_fileoriginal_name <", value, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameLessThanOrEqualTo(String value) {
            addCriterion("media_fileoriginal_name <=", value, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameLike(String value) {
            addCriterion("media_fileoriginal_name like", value, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameNotLike(String value) {
            addCriterion("media_fileoriginal_name not like", value, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameIn(List<String> values) {
            addCriterion("media_fileoriginal_name in", values, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameNotIn(List<String> values) {
            addCriterion("media_fileoriginal_name not in", values, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameBetween(String value1, String value2) {
            addCriterion("media_fileoriginal_name between", value1, value2, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaFileoriginalNameNotBetween(String value1, String value2) {
            addCriterion("media_fileoriginal_name not between", value1, value2, "mediaFileoriginalName");
            return (Criteria) this;
        }

        public Criteria andMediaUrlIsNull() {
            addCriterion("media_url is null");
            return (Criteria) this;
        }

        public Criteria andMediaUrlIsNotNull() {
            addCriterion("media_url is not null");
            return (Criteria) this;
        }

        public Criteria andMediaUrlEqualTo(String value) {
            addCriterion("media_url =", value, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlNotEqualTo(String value) {
            addCriterion("media_url <>", value, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlGreaterThan(String value) {
            addCriterion("media_url >", value, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlGreaterThanOrEqualTo(String value) {
            addCriterion("media_url >=", value, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlLessThan(String value) {
            addCriterion("media_url <", value, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlLessThanOrEqualTo(String value) {
            addCriterion("media_url <=", value, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlLike(String value) {
            addCriterion("media_url like", value, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlNotLike(String value) {
            addCriterion("media_url not like", value, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlIn(List<String> values) {
            addCriterion("media_url in", values, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlNotIn(List<String> values) {
            addCriterion("media_url not in", values, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlBetween(String value1, String value2) {
            addCriterion("media_url between", value1, value2, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andMediaUrlNotBetween(String value1, String value2) {
            addCriterion("media_url not between", value1, value2, "mediaUrl");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Long value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Long value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Long value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Long> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Long value1, Long value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdIsNull() {
            addCriterion("teachplan_id is null");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdIsNotNull() {
            addCriterion("teachplan_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdEqualTo(Long value) {
            addCriterion("teachplan_id =", value, "teachplanId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdNotEqualTo(Long value) {
            addCriterion("teachplan_id <>", value, "teachplanId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdGreaterThan(Long value) {
            addCriterion("teachplan_id >", value, "teachplanId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("teachplan_id >=", value, "teachplanId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdLessThan(Long value) {
            addCriterion("teachplan_id <", value, "teachplanId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdLessThanOrEqualTo(Long value) {
            addCriterion("teachplan_id <=", value, "teachplanId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdIn(List<Long> values) {
            addCriterion("teachplan_id in", values, "teachplanId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdNotIn(List<Long> values) {
            addCriterion("teachplan_id not in", values, "teachplanId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdBetween(Long value1, Long value2) {
            addCriterion("teachplan_id between", value1, value2, "teachplanId");
            return (Criteria) this;
        }

        public Criteria andTeachplanIdNotBetween(Long value1, Long value2) {
            addCriterion("teachplan_id not between", value1, value2, "teachplanId");
            return (Criteria) this;
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
