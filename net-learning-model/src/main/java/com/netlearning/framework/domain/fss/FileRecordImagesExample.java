package com.netlearning.framework.domain.fss;

import java.util.ArrayList;
import java.util.List;

public class FileRecordImagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileRecordImagesExample() {
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

        public Criteria andRecordImageIdIsNull() {
            addCriterion("record_image_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdIsNotNull() {
            addCriterion("record_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdEqualTo(Long value) {
            addCriterion("record_image_id =", value, "recordImageId");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdNotEqualTo(Long value) {
            addCriterion("record_image_id <>", value, "recordImageId");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdGreaterThan(Long value) {
            addCriterion("record_image_id >", value, "recordImageId");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("record_image_id >=", value, "recordImageId");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdLessThan(Long value) {
            addCriterion("record_image_id <", value, "recordImageId");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdLessThanOrEqualTo(Long value) {
            addCriterion("record_image_id <=", value, "recordImageId");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdIn(List<Long> values) {
            addCriterion("record_image_id in", values, "recordImageId");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdNotIn(List<Long> values) {
            addCriterion("record_image_id not in", values, "recordImageId");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdBetween(Long value1, Long value2) {
            addCriterion("record_image_id between", value1, value2, "recordImageId");
            return (Criteria) this;
        }

        public Criteria andRecordImageIdNotBetween(Long value1, Long value2) {
            addCriterion("record_image_id not between", value1, value2, "recordImageId");
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

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(String value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(String value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(String value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(String value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(String value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(String value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLike(String value) {
            addCriterion("is_default like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotLike(String value) {
            addCriterion("is_default not like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<String> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<String> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(String value1, String value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(String value1, String value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconIsNull() {
            addCriterion("is_default_icon is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconIsNotNull() {
            addCriterion("is_default_icon is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconEqualTo(String value) {
            addCriterion("is_default_icon =", value, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconNotEqualTo(String value) {
            addCriterion("is_default_icon <>", value, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconGreaterThan(String value) {
            addCriterion("is_default_icon >", value, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconGreaterThanOrEqualTo(String value) {
            addCriterion("is_default_icon >=", value, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconLessThan(String value) {
            addCriterion("is_default_icon <", value, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconLessThanOrEqualTo(String value) {
            addCriterion("is_default_icon <=", value, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconLike(String value) {
            addCriterion("is_default_icon like", value, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconNotLike(String value) {
            addCriterion("is_default_icon not like", value, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconIn(List<String> values) {
            addCriterion("is_default_icon in", values, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconNotIn(List<String> values) {
            addCriterion("is_default_icon not in", values, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconBetween(String value1, String value2) {
            addCriterion("is_default_icon between", value1, value2, "isDefaultIcon");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIconNotBetween(String value1, String value2) {
            addCriterion("is_default_icon not between", value1, value2, "isDefaultIcon");
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
