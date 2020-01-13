package com.netlearning.framework.domain.course;

import java.util.ArrayList;
import java.util.List;

public class TeachPlanMediaTencentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeachPlanMediaTencentExample() {
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

        public Criteria andTeachplanMediaTencentIdIsNull() {
            addCriterion("teachplan_media_tencent_id is null");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdIsNotNull() {
            addCriterion("teachplan_media_tencent_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdEqualTo(Long value) {
            addCriterion("teachplan_media_tencent_id =", value, "teachplanMediaTencentId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdNotEqualTo(Long value) {
            addCriterion("teachplan_media_tencent_id <>", value, "teachplanMediaTencentId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdGreaterThan(Long value) {
            addCriterion("teachplan_media_tencent_id >", value, "teachplanMediaTencentId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("teachplan_media_tencent_id >=", value, "teachplanMediaTencentId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdLessThan(Long value) {
            addCriterion("teachplan_media_tencent_id <", value, "teachplanMediaTencentId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdLessThanOrEqualTo(Long value) {
            addCriterion("teachplan_media_tencent_id <=", value, "teachplanMediaTencentId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdIn(List<Long> values) {
            addCriterion("teachplan_media_tencent_id in", values, "teachplanMediaTencentId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdNotIn(List<Long> values) {
            addCriterion("teachplan_media_tencent_id not in", values, "teachplanMediaTencentId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdBetween(Long value1, Long value2) {
            addCriterion("teachplan_media_tencent_id between", value1, value2, "teachplanMediaTencentId");
            return (Criteria) this;
        }

        public Criteria andTeachplanMediaTencentIdNotBetween(Long value1, Long value2) {
            addCriterion("teachplan_media_tencent_id not between", value1, value2, "teachplanMediaTencentId");
            return (Criteria) this;
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

        public Criteria andTencentMediaUrlIsNull() {
            addCriterion("tencent_media_url is null");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlIsNotNull() {
            addCriterion("tencent_media_url is not null");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlEqualTo(String value) {
            addCriterion("tencent_media_url =", value, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlNotEqualTo(String value) {
            addCriterion("tencent_media_url <>", value, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlGreaterThan(String value) {
            addCriterion("tencent_media_url >", value, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlGreaterThanOrEqualTo(String value) {
            addCriterion("tencent_media_url >=", value, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlLessThan(String value) {
            addCriterion("tencent_media_url <", value, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlLessThanOrEqualTo(String value) {
            addCriterion("tencent_media_url <=", value, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlLike(String value) {
            addCriterion("tencent_media_url like", value, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlNotLike(String value) {
            addCriterion("tencent_media_url not like", value, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlIn(List<String> values) {
            addCriterion("tencent_media_url in", values, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlNotIn(List<String> values) {
            addCriterion("tencent_media_url not in", values, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlBetween(String value1, String value2) {
            addCriterion("tencent_media_url between", value1, value2, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentMediaUrlNotBetween(String value1, String value2) {
            addCriterion("tencent_media_url not between", value1, value2, "tencentMediaUrl");
            return (Criteria) this;
        }

        public Criteria andTencentFileidIsNull() {
            addCriterion("tencent_fileId is null");
            return (Criteria) this;
        }

        public Criteria andTencentFileidIsNotNull() {
            addCriterion("tencent_fileId is not null");
            return (Criteria) this;
        }

        public Criteria andTencentFileidEqualTo(Long value) {
            addCriterion("tencent_fileId =", value, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentFileidNotEqualTo(Long value) {
            addCriterion("tencent_fileId <>", value, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentFileidGreaterThan(Long value) {
            addCriterion("tencent_fileId >", value, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentFileidGreaterThanOrEqualTo(Long value) {
            addCriterion("tencent_fileId >=", value, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentFileidLessThan(Long value) {
            addCriterion("tencent_fileId <", value, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentFileidLessThanOrEqualTo(Long value) {
            addCriterion("tencent_fileId <=", value, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentFileidIn(List<Long> values) {
            addCriterion("tencent_fileId in", values, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentFileidNotIn(List<Long> values) {
            addCriterion("tencent_fileId not in", values, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentFileidBetween(Long value1, Long value2) {
            addCriterion("tencent_fileId between", value1, value2, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentFileidNotBetween(Long value1, Long value2) {
            addCriterion("tencent_fileId not between", value1, value2, "tencentFileid");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlIsNull() {
            addCriterion("tencent_cover_url is null");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlIsNotNull() {
            addCriterion("tencent_cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlEqualTo(String value) {
            addCriterion("tencent_cover_url =", value, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlNotEqualTo(String value) {
            addCriterion("tencent_cover_url <>", value, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlGreaterThan(String value) {
            addCriterion("tencent_cover_url >", value, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("tencent_cover_url >=", value, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlLessThan(String value) {
            addCriterion("tencent_cover_url <", value, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("tencent_cover_url <=", value, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlLike(String value) {
            addCriterion("tencent_cover_url like", value, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlNotLike(String value) {
            addCriterion("tencent_cover_url not like", value, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlIn(List<String> values) {
            addCriterion("tencent_cover_url in", values, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlNotIn(List<String> values) {
            addCriterion("tencent_cover_url not in", values, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlBetween(String value1, String value2) {
            addCriterion("tencent_cover_url between", value1, value2, "tencentCoverUrl");
            return (Criteria) this;
        }

        public Criteria andTencentCoverUrlNotBetween(String value1, String value2) {
            addCriterion("tencent_cover_url not between", value1, value2, "tencentCoverUrl");
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
