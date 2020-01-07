package com.netlearning.framework.domain.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseAssessmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseAssessmentExample() {
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

        public Criteria andCourseAssessmentIdIsNull() {
            addCriterion("course_assessment_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdIsNotNull() {
            addCriterion("course_assessment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdEqualTo(Long value) {
            addCriterion("course_assessment_id =", value, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdNotEqualTo(Long value) {
            addCriterion("course_assessment_id <>", value, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdGreaterThan(Long value) {
            addCriterion("course_assessment_id >", value, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_assessment_id >=", value, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdLessThan(Long value) {
            addCriterion("course_assessment_id <", value, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdLessThanOrEqualTo(Long value) {
            addCriterion("course_assessment_id <=", value, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdIn(List<Long> values) {
            addCriterion("course_assessment_id in", values, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdNotIn(List<Long> values) {
            addCriterion("course_assessment_id not in", values, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdBetween(Long value1, Long value2) {
            addCriterion("course_assessment_id between", value1, value2, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentIdNotBetween(Long value1, Long value2) {
            addCriterion("course_assessment_id not between", value1, value2, "courseAssessmentId");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleIsNull() {
            addCriterion("course_assessment_title is null");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleIsNotNull() {
            addCriterion("course_assessment_title is not null");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleEqualTo(String value) {
            addCriterion("course_assessment_title =", value, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleNotEqualTo(String value) {
            addCriterion("course_assessment_title <>", value, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleGreaterThan(String value) {
            addCriterion("course_assessment_title >", value, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleGreaterThanOrEqualTo(String value) {
            addCriterion("course_assessment_title >=", value, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleLessThan(String value) {
            addCriterion("course_assessment_title <", value, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleLessThanOrEqualTo(String value) {
            addCriterion("course_assessment_title <=", value, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleLike(String value) {
            addCriterion("course_assessment_title like", value, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleNotLike(String value) {
            addCriterion("course_assessment_title not like", value, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleIn(List<String> values) {
            addCriterion("course_assessment_title in", values, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleNotIn(List<String> values) {
            addCriterion("course_assessment_title not in", values, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleBetween(String value1, String value2) {
            addCriterion("course_assessment_title between", value1, value2, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentTitleNotBetween(String value1, String value2) {
            addCriterion("course_assessment_title not between", value1, value2, "courseAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentIsNull() {
            addCriterion("course_assessment_content is null");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentIsNotNull() {
            addCriterion("course_assessment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentEqualTo(String value) {
            addCriterion("course_assessment_content =", value, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentNotEqualTo(String value) {
            addCriterion("course_assessment_content <>", value, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentGreaterThan(String value) {
            addCriterion("course_assessment_content >", value, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentGreaterThanOrEqualTo(String value) {
            addCriterion("course_assessment_content >=", value, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentLessThan(String value) {
            addCriterion("course_assessment_content <", value, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentLessThanOrEqualTo(String value) {
            addCriterion("course_assessment_content <=", value, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentLike(String value) {
            addCriterion("course_assessment_content like", value, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentNotLike(String value) {
            addCriterion("course_assessment_content not like", value, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentIn(List<String> values) {
            addCriterion("course_assessment_content in", values, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentNotIn(List<String> values) {
            addCriterion("course_assessment_content not in", values, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentBetween(String value1, String value2) {
            addCriterion("course_assessment_content between", value1, value2, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentContentNotBetween(String value1, String value2) {
            addCriterion("course_assessment_content not between", value1, value2, "courseAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeIsNull() {
            addCriterion("course_assessment_grade is null");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeIsNotNull() {
            addCriterion("course_assessment_grade is not null");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeEqualTo(Double value) {
            addCriterion("course_assessment_grade =", value, "courseAssessmentGrade");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeNotEqualTo(Double value) {
            addCriterion("course_assessment_grade <>", value, "courseAssessmentGrade");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeGreaterThan(Double value) {
            addCriterion("course_assessment_grade >", value, "courseAssessmentGrade");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeGreaterThanOrEqualTo(Double value) {
            addCriterion("course_assessment_grade >=", value, "courseAssessmentGrade");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeLessThan(Double value) {
            addCriterion("course_assessment_grade <", value, "courseAssessmentGrade");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeLessThanOrEqualTo(Double value) {
            addCriterion("course_assessment_grade <=", value, "courseAssessmentGrade");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeIn(List<Double> values) {
            addCriterion("course_assessment_grade in", values, "courseAssessmentGrade");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeNotIn(List<Double> values) {
            addCriterion("course_assessment_grade not in", values, "courseAssessmentGrade");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeBetween(Double value1, Double value2) {
            addCriterion("course_assessment_grade between", value1, value2, "courseAssessmentGrade");
            return (Criteria) this;
        }

        public Criteria andCourseAssessmentGradeNotBetween(Double value1, Double value2) {
            addCriterion("course_assessment_grade not between", value1, value2, "courseAssessmentGrade");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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
