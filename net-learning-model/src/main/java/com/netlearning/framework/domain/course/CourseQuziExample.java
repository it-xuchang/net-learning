package com.netlearning.framework.domain.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseQuziExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseQuziExample() {
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

        public Criteria andCourseQuziIdIsNull() {
            addCriterion("course_quzi_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdIsNotNull() {
            addCriterion("course_quzi_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdEqualTo(Long value) {
            addCriterion("course_quzi_id =", value, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdNotEqualTo(Long value) {
            addCriterion("course_quzi_id <>", value, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdGreaterThan(Long value) {
            addCriterion("course_quzi_id >", value, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_quzi_id >=", value, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdLessThan(Long value) {
            addCriterion("course_quzi_id <", value, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdLessThanOrEqualTo(Long value) {
            addCriterion("course_quzi_id <=", value, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdIn(List<Long> values) {
            addCriterion("course_quzi_id in", values, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdNotIn(List<Long> values) {
            addCriterion("course_quzi_id not in", values, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdBetween(Long value1, Long value2) {
            addCriterion("course_quzi_id between", value1, value2, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziIdNotBetween(Long value1, Long value2) {
            addCriterion("course_quzi_id not between", value1, value2, "courseQuziId");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleIsNull() {
            addCriterion("course_quzi_title is null");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleIsNotNull() {
            addCriterion("course_quzi_title is not null");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleEqualTo(String value) {
            addCriterion("course_quzi_title =", value, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleNotEqualTo(String value) {
            addCriterion("course_quzi_title <>", value, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleGreaterThan(String value) {
            addCriterion("course_quzi_title >", value, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleGreaterThanOrEqualTo(String value) {
            addCriterion("course_quzi_title >=", value, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleLessThan(String value) {
            addCriterion("course_quzi_title <", value, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleLessThanOrEqualTo(String value) {
            addCriterion("course_quzi_title <=", value, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleLike(String value) {
            addCriterion("course_quzi_title like", value, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleNotLike(String value) {
            addCriterion("course_quzi_title not like", value, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleIn(List<String> values) {
            addCriterion("course_quzi_title in", values, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleNotIn(List<String> values) {
            addCriterion("course_quzi_title not in", values, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleBetween(String value1, String value2) {
            addCriterion("course_quzi_title between", value1, value2, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTitleNotBetween(String value1, String value2) {
            addCriterion("course_quzi_title not between", value1, value2, "courseQuziTitle");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentIsNull() {
            addCriterion("course_quzi_content is null");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentIsNotNull() {
            addCriterion("course_quzi_content is not null");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentEqualTo(String value) {
            addCriterion("course_quzi_content =", value, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentNotEqualTo(String value) {
            addCriterion("course_quzi_content <>", value, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentGreaterThan(String value) {
            addCriterion("course_quzi_content >", value, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentGreaterThanOrEqualTo(String value) {
            addCriterion("course_quzi_content >=", value, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentLessThan(String value) {
            addCriterion("course_quzi_content <", value, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentLessThanOrEqualTo(String value) {
            addCriterion("course_quzi_content <=", value, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentLike(String value) {
            addCriterion("course_quzi_content like", value, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentNotLike(String value) {
            addCriterion("course_quzi_content not like", value, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentIn(List<String> values) {
            addCriterion("course_quzi_content in", values, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentNotIn(List<String> values) {
            addCriterion("course_quzi_content not in", values, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentBetween(String value1, String value2) {
            addCriterion("course_quzi_content between", value1, value2, "courseQuziContent");
            return (Criteria) this;
        }

        public Criteria andCourseQuziContentNotBetween(String value1, String value2) {
            addCriterion("course_quzi_content not between", value1, value2, "courseQuziContent");
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

        public Criteria andIsOverHeadIsNull() {
            addCriterion("is_over_head is null");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadIsNotNull() {
            addCriterion("is_over_head is not null");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadEqualTo(String value) {
            addCriterion("is_over_head =", value, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadNotEqualTo(String value) {
            addCriterion("is_over_head <>", value, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadGreaterThan(String value) {
            addCriterion("is_over_head >", value, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadGreaterThanOrEqualTo(String value) {
            addCriterion("is_over_head >=", value, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadLessThan(String value) {
            addCriterion("is_over_head <", value, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadLessThanOrEqualTo(String value) {
            addCriterion("is_over_head <=", value, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadLike(String value) {
            addCriterion("is_over_head like", value, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadNotLike(String value) {
            addCriterion("is_over_head not like", value, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadIn(List<String> values) {
            addCriterion("is_over_head in", values, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadNotIn(List<String> values) {
            addCriterion("is_over_head not in", values, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadBetween(String value1, String value2) {
            addCriterion("is_over_head between", value1, value2, "isOverHead");
            return (Criteria) this;
        }

        public Criteria andIsOverHeadNotBetween(String value1, String value2) {
            addCriterion("is_over_head not between", value1, value2, "isOverHead");
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

        public Criteria andCourseQuziTypeIsNull() {
            addCriterion("course_quzi_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeIsNotNull() {
            addCriterion("course_quzi_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeEqualTo(String value) {
            addCriterion("course_quzi_type =", value, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeNotEqualTo(String value) {
            addCriterion("course_quzi_type <>", value, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeGreaterThan(String value) {
            addCriterion("course_quzi_type >", value, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeGreaterThanOrEqualTo(String value) {
            addCriterion("course_quzi_type >=", value, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeLessThan(String value) {
            addCriterion("course_quzi_type <", value, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeLessThanOrEqualTo(String value) {
            addCriterion("course_quzi_type <=", value, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeLike(String value) {
            addCriterion("course_quzi_type like", value, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeNotLike(String value) {
            addCriterion("course_quzi_type not like", value, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeIn(List<String> values) {
            addCriterion("course_quzi_type in", values, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeNotIn(List<String> values) {
            addCriterion("course_quzi_type not in", values, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeBetween(String value1, String value2) {
            addCriterion("course_quzi_type between", value1, value2, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andCourseQuziTypeNotBetween(String value1, String value2) {
            addCriterion("course_quzi_type not between", value1, value2, "courseQuziType");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(String value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(String value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(String value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(String value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(String value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(String value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLike(String value) {
            addCriterion("is_show like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotLike(String value) {
            addCriterion("is_show not like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<String> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<String> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(String value1, String value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(String value1, String value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
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
