package com.netlearning.framework.domain.course;

import java.util.ArrayList;
import java.util.List;

public class SystemNavExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemNavExample() {
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

        public Criteria andSystemNavIdIsNull() {
            addCriterion("system_nav_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdIsNotNull() {
            addCriterion("system_nav_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdEqualTo(Long value) {
            addCriterion("system_nav_id =", value, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdNotEqualTo(Long value) {
            addCriterion("system_nav_id <>", value, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdGreaterThan(Long value) {
            addCriterion("system_nav_id >", value, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdGreaterThanOrEqualTo(Long value) {
            addCriterion("system_nav_id >=", value, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdLessThan(Long value) {
            addCriterion("system_nav_id <", value, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdLessThanOrEqualTo(Long value) {
            addCriterion("system_nav_id <=", value, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdIn(List<Long> values) {
            addCriterion("system_nav_id in", values, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdNotIn(List<Long> values) {
            addCriterion("system_nav_id not in", values, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdBetween(Long value1, Long value2) {
            addCriterion("system_nav_id between", value1, value2, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavIdNotBetween(Long value1, Long value2) {
            addCriterion("system_nav_id not between", value1, value2, "systemNavId");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlIsNull() {
            addCriterion("system_nav_url is null");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlIsNotNull() {
            addCriterion("system_nav_url is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlEqualTo(String value) {
            addCriterion("system_nav_url =", value, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlNotEqualTo(String value) {
            addCriterion("system_nav_url <>", value, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlGreaterThan(String value) {
            addCriterion("system_nav_url >", value, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlGreaterThanOrEqualTo(String value) {
            addCriterion("system_nav_url >=", value, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlLessThan(String value) {
            addCriterion("system_nav_url <", value, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlLessThanOrEqualTo(String value) {
            addCriterion("system_nav_url <=", value, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlLike(String value) {
            addCriterion("system_nav_url like", value, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlNotLike(String value) {
            addCriterion("system_nav_url not like", value, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlIn(List<String> values) {
            addCriterion("system_nav_url in", values, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlNotIn(List<String> values) {
            addCriterion("system_nav_url not in", values, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlBetween(String value1, String value2) {
            addCriterion("system_nav_url between", value1, value2, "systemNavUrl");
            return (Criteria) this;
        }

        public Criteria andSystemNavUrlNotBetween(String value1, String value2) {
            addCriterion("system_nav_url not between", value1, value2, "systemNavUrl");
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

        public Criteria andSystemNavHandlersIsNull() {
            addCriterion("system_nav_handlers is null");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersIsNotNull() {
            addCriterion("system_nav_handlers is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersEqualTo(String value) {
            addCriterion("system_nav_handlers =", value, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersNotEqualTo(String value) {
            addCriterion("system_nav_handlers <>", value, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersGreaterThan(String value) {
            addCriterion("system_nav_handlers >", value, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersGreaterThanOrEqualTo(String value) {
            addCriterion("system_nav_handlers >=", value, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersLessThan(String value) {
            addCriterion("system_nav_handlers <", value, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersLessThanOrEqualTo(String value) {
            addCriterion("system_nav_handlers <=", value, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersLike(String value) {
            addCriterion("system_nav_handlers like", value, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersNotLike(String value) {
            addCriterion("system_nav_handlers not like", value, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersIn(List<String> values) {
            addCriterion("system_nav_handlers in", values, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersNotIn(List<String> values) {
            addCriterion("system_nav_handlers not in", values, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersBetween(String value1, String value2) {
            addCriterion("system_nav_handlers between", value1, value2, "systemNavHandlers");
            return (Criteria) this;
        }

        public Criteria andSystemNavHandlersNotBetween(String value1, String value2) {
            addCriterion("system_nav_handlers not between", value1, value2, "systemNavHandlers");
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
