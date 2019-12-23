package com.netlearning.framework.domain.userAuth;

import java.util.ArrayList;
import java.util.List;

public class UserConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserConfigExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andThemeIsNull() {
            addCriterion("THEME is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("THEME is not null");
            return (Criteria) this;
        }

        public Criteria andThemeEqualTo(String value) {
            addCriterion("THEME =", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(String value) {
            addCriterion("THEME <>", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(String value) {
            addCriterion("THEME >", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addCriterion("THEME >=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(String value) {
            addCriterion("THEME <", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(String value) {
            addCriterion("THEME <=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLike(String value) {
            addCriterion("THEME like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(String value) {
            addCriterion("THEME not like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeIn(List<String> values) {
            addCriterion("THEME in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<String> values) {
            addCriterion("THEME not in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(String value1, String value2) {
            addCriterion("THEME between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(String value1, String value2) {
            addCriterion("THEME not between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andLayoutIsNull() {
            addCriterion("LAYOUT is null");
            return (Criteria) this;
        }

        public Criteria andLayoutIsNotNull() {
            addCriterion("LAYOUT is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutEqualTo(String value) {
            addCriterion("LAYOUT =", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotEqualTo(String value) {
            addCriterion("LAYOUT <>", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutGreaterThan(String value) {
            addCriterion("LAYOUT >", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutGreaterThanOrEqualTo(String value) {
            addCriterion("LAYOUT >=", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLessThan(String value) {
            addCriterion("LAYOUT <", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLessThanOrEqualTo(String value) {
            addCriterion("LAYOUT <=", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLike(String value) {
            addCriterion("LAYOUT like", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotLike(String value) {
            addCriterion("LAYOUT not like", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutIn(List<String> values) {
            addCriterion("LAYOUT in", values, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotIn(List<String> values) {
            addCriterion("LAYOUT not in", values, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutBetween(String value1, String value2) {
            addCriterion("LAYOUT between", value1, value2, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotBetween(String value1, String value2) {
            addCriterion("LAYOUT not between", value1, value2, "layout");
            return (Criteria) this;
        }

        public Criteria andMultiPageIsNull() {
            addCriterion("MULTI_PAGE is null");
            return (Criteria) this;
        }

        public Criteria andMultiPageIsNotNull() {
            addCriterion("MULTI_PAGE is not null");
            return (Criteria) this;
        }

        public Criteria andMultiPageEqualTo(String value) {
            addCriterion("MULTI_PAGE =", value, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageNotEqualTo(String value) {
            addCriterion("MULTI_PAGE <>", value, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageGreaterThan(String value) {
            addCriterion("MULTI_PAGE >", value, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageGreaterThanOrEqualTo(String value) {
            addCriterion("MULTI_PAGE >=", value, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageLessThan(String value) {
            addCriterion("MULTI_PAGE <", value, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageLessThanOrEqualTo(String value) {
            addCriterion("MULTI_PAGE <=", value, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageLike(String value) {
            addCriterion("MULTI_PAGE like", value, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageNotLike(String value) {
            addCriterion("MULTI_PAGE not like", value, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageIn(List<String> values) {
            addCriterion("MULTI_PAGE in", values, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageNotIn(List<String> values) {
            addCriterion("MULTI_PAGE not in", values, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageBetween(String value1, String value2) {
            addCriterion("MULTI_PAGE between", value1, value2, "multiPage");
            return (Criteria) this;
        }

        public Criteria andMultiPageNotBetween(String value1, String value2) {
            addCriterion("MULTI_PAGE not between", value1, value2, "multiPage");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarIsNull() {
            addCriterion("FIX_SIDERBAR is null");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarIsNotNull() {
            addCriterion("FIX_SIDERBAR is not null");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarEqualTo(String value) {
            addCriterion("FIX_SIDERBAR =", value, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarNotEqualTo(String value) {
            addCriterion("FIX_SIDERBAR <>", value, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarGreaterThan(String value) {
            addCriterion("FIX_SIDERBAR >", value, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarGreaterThanOrEqualTo(String value) {
            addCriterion("FIX_SIDERBAR >=", value, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarLessThan(String value) {
            addCriterion("FIX_SIDERBAR <", value, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarLessThanOrEqualTo(String value) {
            addCriterion("FIX_SIDERBAR <=", value, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarLike(String value) {
            addCriterion("FIX_SIDERBAR like", value, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarNotLike(String value) {
            addCriterion("FIX_SIDERBAR not like", value, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarIn(List<String> values) {
            addCriterion("FIX_SIDERBAR in", values, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarNotIn(List<String> values) {
            addCriterion("FIX_SIDERBAR not in", values, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarBetween(String value1, String value2) {
            addCriterion("FIX_SIDERBAR between", value1, value2, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixSiderbarNotBetween(String value1, String value2) {
            addCriterion("FIX_SIDERBAR not between", value1, value2, "fixSiderbar");
            return (Criteria) this;
        }

        public Criteria andFixHeaderIsNull() {
            addCriterion("FIX_HEADER is null");
            return (Criteria) this;
        }

        public Criteria andFixHeaderIsNotNull() {
            addCriterion("FIX_HEADER is not null");
            return (Criteria) this;
        }

        public Criteria andFixHeaderEqualTo(String value) {
            addCriterion("FIX_HEADER =", value, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderNotEqualTo(String value) {
            addCriterion("FIX_HEADER <>", value, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderGreaterThan(String value) {
            addCriterion("FIX_HEADER >", value, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("FIX_HEADER >=", value, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderLessThan(String value) {
            addCriterion("FIX_HEADER <", value, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderLessThanOrEqualTo(String value) {
            addCriterion("FIX_HEADER <=", value, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderLike(String value) {
            addCriterion("FIX_HEADER like", value, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderNotLike(String value) {
            addCriterion("FIX_HEADER not like", value, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderIn(List<String> values) {
            addCriterion("FIX_HEADER in", values, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderNotIn(List<String> values) {
            addCriterion("FIX_HEADER not in", values, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderBetween(String value1, String value2) {
            addCriterion("FIX_HEADER between", value1, value2, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andFixHeaderNotBetween(String value1, String value2) {
            addCriterion("FIX_HEADER not between", value1, value2, "fixHeader");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("COLOR is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("COLOR is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("COLOR =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("COLOR <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("COLOR >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("COLOR >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("COLOR <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("COLOR <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("COLOR like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("COLOR not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("COLOR in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("COLOR not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("COLOR between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("COLOR not between", value1, value2, "color");
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
