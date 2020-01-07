package com.netlearning.framework.domain.course;

import java.util.ArrayList;
import java.util.List;

public class TeachPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeachPlanExample() {
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

        public Criteria andTeachplanNameIsNull() {
            addCriterion("teachplan_name is null");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameIsNotNull() {
            addCriterion("teachplan_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameEqualTo(String value) {
            addCriterion("teachplan_name =", value, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameNotEqualTo(String value) {
            addCriterion("teachplan_name <>", value, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameGreaterThan(String value) {
            addCriterion("teachplan_name >", value, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameGreaterThanOrEqualTo(String value) {
            addCriterion("teachplan_name >=", value, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameLessThan(String value) {
            addCriterion("teachplan_name <", value, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameLessThanOrEqualTo(String value) {
            addCriterion("teachplan_name <=", value, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameLike(String value) {
            addCriterion("teachplan_name like", value, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameNotLike(String value) {
            addCriterion("teachplan_name not like", value, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameIn(List<String> values) {
            addCriterion("teachplan_name in", values, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameNotIn(List<String> values) {
            addCriterion("teachplan_name not in", values, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameBetween(String value1, String value2) {
            addCriterion("teachplan_name between", value1, value2, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andTeachplanNameNotBetween(String value1, String value2) {
            addCriterion("teachplan_name not between", value1, value2, "teachplanName");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeIsNull() {
            addCriterion("teachplan_type is null");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeIsNotNull() {
            addCriterion("teachplan_type is not null");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeEqualTo(String value) {
            addCriterion("teachplan_type =", value, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeNotEqualTo(String value) {
            addCriterion("teachplan_type <>", value, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeGreaterThan(String value) {
            addCriterion("teachplan_type >", value, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("teachplan_type >=", value, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeLessThan(String value) {
            addCriterion("teachplan_type <", value, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeLessThanOrEqualTo(String value) {
            addCriterion("teachplan_type <=", value, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeLike(String value) {
            addCriterion("teachplan_type like", value, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeNotLike(String value) {
            addCriterion("teachplan_type not like", value, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeIn(List<String> values) {
            addCriterion("teachplan_type in", values, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeNotIn(List<String> values) {
            addCriterion("teachplan_type not in", values, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeBetween(String value1, String value2) {
            addCriterion("teachplan_type between", value1, value2, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andTeachplanTypeNotBetween(String value1, String value2) {
            addCriterion("teachplan_type not between", value1, value2, "teachplanType");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIsNull() {
            addCriterion("time_length is null");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIsNotNull() {
            addCriterion("time_length is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLengthEqualTo(Double value) {
            addCriterion("time_length =", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotEqualTo(Double value) {
            addCriterion("time_length <>", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthGreaterThan(Double value) {
            addCriterion("time_length >", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthGreaterThanOrEqualTo(Double value) {
            addCriterion("time_length >=", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLessThan(Double value) {
            addCriterion("time_length <", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLessThanOrEqualTo(Double value) {
            addCriterion("time_length <=", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIn(List<Double> values) {
            addCriterion("time_length in", values, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotIn(List<Double> values) {
            addCriterion("time_length not in", values, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthBetween(Double value1, Double value2) {
            addCriterion("time_length between", value1, value2, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotBetween(Double value1, Double value2) {
            addCriterion("time_length not between", value1, value2, "timeLength");
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

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_id like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_id not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNull() {
            addCriterion("orderby is null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNotNull() {
            addCriterion("orderby is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbyEqualTo(String value) {
            addCriterion("orderby =", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotEqualTo(String value) {
            addCriterion("orderby <>", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThan(String value) {
            addCriterion("orderby >", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThanOrEqualTo(String value) {
            addCriterion("orderby >=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThan(String value) {
            addCriterion("orderby <", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThanOrEqualTo(String value) {
            addCriterion("orderby <=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLike(String value) {
            addCriterion("orderby like", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotLike(String value) {
            addCriterion("orderby not like", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyIn(List<String> values) {
            addCriterion("orderby in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotIn(List<String> values) {
            addCriterion("orderby not in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyBetween(String value1, String value2) {
            addCriterion("orderby between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotBetween(String value1, String value2) {
            addCriterion("orderby not between", value1, value2, "orderby");
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

        public Criteria andTryLearnIsNull() {
            addCriterion("try_learn is null");
            return (Criteria) this;
        }

        public Criteria andTryLearnIsNotNull() {
            addCriterion("try_learn is not null");
            return (Criteria) this;
        }

        public Criteria andTryLearnEqualTo(String value) {
            addCriterion("try_learn =", value, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnNotEqualTo(String value) {
            addCriterion("try_learn <>", value, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnGreaterThan(String value) {
            addCriterion("try_learn >", value, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnGreaterThanOrEqualTo(String value) {
            addCriterion("try_learn >=", value, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnLessThan(String value) {
            addCriterion("try_learn <", value, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnLessThanOrEqualTo(String value) {
            addCriterion("try_learn <=", value, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnLike(String value) {
            addCriterion("try_learn like", value, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnNotLike(String value) {
            addCriterion("try_learn not like", value, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnIn(List<String> values) {
            addCriterion("try_learn in", values, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnNotIn(List<String> values) {
            addCriterion("try_learn not in", values, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnBetween(String value1, String value2) {
            addCriterion("try_learn between", value1, value2, "tryLearn");
            return (Criteria) this;
        }

        public Criteria andTryLearnNotBetween(String value1, String value2) {
            addCriterion("try_learn not between", value1, value2, "tryLearn");
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
