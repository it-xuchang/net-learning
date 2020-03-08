package com.netlearning.framework.domain.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LearningTeachplanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LearningTeachplanExample() {
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

        public Criteria andLearningTeachplanIdIsNull() {
            addCriterion("learning_teachplan_id is null");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdIsNotNull() {
            addCriterion("learning_teachplan_id is not null");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdEqualTo(Long value) {
            addCriterion("learning_teachplan_id =", value, "learningTeachplanId");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdNotEqualTo(Long value) {
            addCriterion("learning_teachplan_id <>", value, "learningTeachplanId");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdGreaterThan(Long value) {
            addCriterion("learning_teachplan_id >", value, "learningTeachplanId");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("learning_teachplan_id >=", value, "learningTeachplanId");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdLessThan(Long value) {
            addCriterion("learning_teachplan_id <", value, "learningTeachplanId");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdLessThanOrEqualTo(Long value) {
            addCriterion("learning_teachplan_id <=", value, "learningTeachplanId");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdIn(List<Long> values) {
            addCriterion("learning_teachplan_id in", values, "learningTeachplanId");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdNotIn(List<Long> values) {
            addCriterion("learning_teachplan_id not in", values, "learningTeachplanId");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdBetween(Long value1, Long value2) {
            addCriterion("learning_teachplan_id between", value1, value2, "learningTeachplanId");
            return (Criteria) this;
        }

        public Criteria andLearningTeachplanIdNotBetween(Long value1, Long value2) {
            addCriterion("learning_teachplan_id not between", value1, value2, "learningTeachplanId");
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

        public Criteria andLearningTimeIsNull() {
            addCriterion("learning_time is null");
            return (Criteria) this;
        }

        public Criteria andLearningTimeIsNotNull() {
            addCriterion("learning_time is not null");
            return (Criteria) this;
        }

        public Criteria andLearningTimeEqualTo(Double value) {
            addCriterion("learning_time =", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeNotEqualTo(Double value) {
            addCriterion("learning_time <>", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeGreaterThan(Double value) {
            addCriterion("learning_time >", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("learning_time >=", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeLessThan(Double value) {
            addCriterion("learning_time <", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeLessThanOrEqualTo(Double value) {
            addCriterion("learning_time <=", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeIn(List<Double> values) {
            addCriterion("learning_time in", values, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeNotIn(List<Double> values) {
            addCriterion("learning_time not in", values, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeBetween(Double value1, Double value2) {
            addCriterion("learning_time between", value1, value2, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeNotBetween(Double value1, Double value2) {
            addCriterion("learning_time not between", value1, value2, "learningTime");
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

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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
