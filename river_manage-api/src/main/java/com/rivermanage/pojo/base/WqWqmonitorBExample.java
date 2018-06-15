package com.rivermanage.pojo.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WqWqmonitorBExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WqWqmonitorBExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStcdIsNull() {
            addCriterion("STCD is null");
            return (Criteria) this;
        }

        public Criteria andStcdIsNotNull() {
            addCriterion("STCD is not null");
            return (Criteria) this;
        }

        public Criteria andStcdEqualTo(String value) {
            addCriterion("STCD =", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdNotEqualTo(String value) {
            addCriterion("STCD <>", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdGreaterThan(String value) {
            addCriterion("STCD >", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdGreaterThanOrEqualTo(String value) {
            addCriterion("STCD >=", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdLessThan(String value) {
            addCriterion("STCD <", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdLessThanOrEqualTo(String value) {
            addCriterion("STCD <=", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdLike(String value) {
            addCriterion("STCD like", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdNotLike(String value) {
            addCriterion("STCD not like", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdIn(List<String> values) {
            addCriterion("STCD in", values, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdNotIn(List<String> values) {
            addCriterion("STCD not in", values, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdBetween(String value1, String value2) {
            addCriterion("STCD between", value1, value2, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdNotBetween(String value1, String value2) {
            addCriterion("STCD not between", value1, value2, "stcd");
            return (Criteria) this;
        }

        public Criteria andDevidIsNull() {
            addCriterion("DEVID is null");
            return (Criteria) this;
        }

        public Criteria andDevidIsNotNull() {
            addCriterion("DEVID is not null");
            return (Criteria) this;
        }

        public Criteria andDevidEqualTo(Integer value) {
            addCriterion("DEVID =", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotEqualTo(Integer value) {
            addCriterion("DEVID <>", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidGreaterThan(Integer value) {
            addCriterion("DEVID >", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEVID >=", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidLessThan(Integer value) {
            addCriterion("DEVID <", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidLessThanOrEqualTo(Integer value) {
            addCriterion("DEVID <=", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidIn(List<Integer> values) {
            addCriterion("DEVID in", values, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotIn(List<Integer> values) {
            addCriterion("DEVID not in", values, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidBetween(Integer value1, Integer value2) {
            addCriterion("DEVID between", value1, value2, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotBetween(Integer value1, Integer value2) {
            addCriterion("DEVID not between", value1, value2, "devid");
            return (Criteria) this;
        }

        public Criteria andParidIsNull() {
            addCriterion("PARID is null");
            return (Criteria) this;
        }

        public Criteria andParidIsNotNull() {
            addCriterion("PARID is not null");
            return (Criteria) this;
        }

        public Criteria andParidEqualTo(Integer value) {
            addCriterion("PARID =", value, "parid");
            return (Criteria) this;
        }

        public Criteria andParidNotEqualTo(Integer value) {
            addCriterion("PARID <>", value, "parid");
            return (Criteria) this;
        }

        public Criteria andParidGreaterThan(Integer value) {
            addCriterion("PARID >", value, "parid");
            return (Criteria) this;
        }

        public Criteria andParidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARID >=", value, "parid");
            return (Criteria) this;
        }

        public Criteria andParidLessThan(Integer value) {
            addCriterion("PARID <", value, "parid");
            return (Criteria) this;
        }

        public Criteria andParidLessThanOrEqualTo(Integer value) {
            addCriterion("PARID <=", value, "parid");
            return (Criteria) this;
        }

        public Criteria andParidIn(List<Integer> values) {
            addCriterion("PARID in", values, "parid");
            return (Criteria) this;
        }

        public Criteria andParidNotIn(List<Integer> values) {
            addCriterion("PARID not in", values, "parid");
            return (Criteria) this;
        }

        public Criteria andParidBetween(Integer value1, Integer value2) {
            addCriterion("PARID between", value1, value2, "parid");
            return (Criteria) this;
        }

        public Criteria andParidNotBetween(Integer value1, Integer value2) {
            addCriterion("PARID not between", value1, value2, "parid");
            return (Criteria) this;
        }

        public Criteria andSptIsNull() {
            addCriterion("SPT is null");
            return (Criteria) this;
        }

        public Criteria andSptIsNotNull() {
            addCriterion("SPT is not null");
            return (Criteria) this;
        }

        public Criteria andSptEqualTo(String value) {
            addCriterion("SPT =", value, "spt");
            return (Criteria) this;
        }

        public Criteria andSptNotEqualTo(String value) {
            addCriterion("SPT <>", value, "spt");
            return (Criteria) this;
        }

        public Criteria andSptGreaterThan(String value) {
            addCriterion("SPT >", value, "spt");
            return (Criteria) this;
        }

        public Criteria andSptGreaterThanOrEqualTo(String value) {
            addCriterion("SPT >=", value, "spt");
            return (Criteria) this;
        }

        public Criteria andSptLessThan(String value) {
            addCriterion("SPT <", value, "spt");
            return (Criteria) this;
        }

        public Criteria andSptLessThanOrEqualTo(String value) {
            addCriterion("SPT <=", value, "spt");
            return (Criteria) this;
        }

        public Criteria andSptLike(String value) {
            addCriterion("SPT like", value, "spt");
            return (Criteria) this;
        }

        public Criteria andSptNotLike(String value) {
            addCriterion("SPT not like", value, "spt");
            return (Criteria) this;
        }

        public Criteria andSptIn(List<String> values) {
            addCriterion("SPT in", values, "spt");
            return (Criteria) this;
        }

        public Criteria andSptNotIn(List<String> values) {
            addCriterion("SPT not in", values, "spt");
            return (Criteria) this;
        }

        public Criteria andSptBetween(String value1, String value2) {
            addCriterion("SPT between", value1, value2, "spt");
            return (Criteria) this;
        }

        public Criteria andSptNotBetween(String value1, String value2) {
            addCriterion("SPT not between", value1, value2, "spt");
            return (Criteria) this;
        }

        public Criteria andMtdaIsNull() {
            addCriterion("MTDA is null");
            return (Criteria) this;
        }

        public Criteria andMtdaIsNotNull() {
            addCriterion("MTDA is not null");
            return (Criteria) this;
        }

        public Criteria andMtdaEqualTo(BigDecimal value) {
            addCriterion("MTDA =", value, "mtda");
            return (Criteria) this;
        }

        public Criteria andMtdaNotEqualTo(BigDecimal value) {
            addCriterion("MTDA <>", value, "mtda");
            return (Criteria) this;
        }

        public Criteria andMtdaGreaterThan(BigDecimal value) {
            addCriterion("MTDA >", value, "mtda");
            return (Criteria) this;
        }

        public Criteria andMtdaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MTDA >=", value, "mtda");
            return (Criteria) this;
        }

        public Criteria andMtdaLessThan(BigDecimal value) {
            addCriterion("MTDA <", value, "mtda");
            return (Criteria) this;
        }

        public Criteria andMtdaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MTDA <=", value, "mtda");
            return (Criteria) this;
        }

        public Criteria andMtdaIn(List<BigDecimal> values) {
            addCriterion("MTDA in", values, "mtda");
            return (Criteria) this;
        }

        public Criteria andMtdaNotIn(List<BigDecimal> values) {
            addCriterion("MTDA not in", values, "mtda");
            return (Criteria) this;
        }

        public Criteria andMtdaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MTDA between", value1, value2, "mtda");
            return (Criteria) this;
        }

        public Criteria andMtdaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MTDA not between", value1, value2, "mtda");
            return (Criteria) this;
        }

        public Criteria andNtIsNull() {
            addCriterion("NT is null");
            return (Criteria) this;
        }

        public Criteria andNtIsNotNull() {
            addCriterion("NT is not null");
            return (Criteria) this;
        }

        public Criteria andNtEqualTo(String value) {
            addCriterion("NT =", value, "nt");
            return (Criteria) this;
        }

        public Criteria andNtNotEqualTo(String value) {
            addCriterion("NT <>", value, "nt");
            return (Criteria) this;
        }

        public Criteria andNtGreaterThan(String value) {
            addCriterion("NT >", value, "nt");
            return (Criteria) this;
        }

        public Criteria andNtGreaterThanOrEqualTo(String value) {
            addCriterion("NT >=", value, "nt");
            return (Criteria) this;
        }

        public Criteria andNtLessThan(String value) {
            addCriterion("NT <", value, "nt");
            return (Criteria) this;
        }

        public Criteria andNtLessThanOrEqualTo(String value) {
            addCriterion("NT <=", value, "nt");
            return (Criteria) this;
        }

        public Criteria andNtLike(String value) {
            addCriterion("NT like", value, "nt");
            return (Criteria) this;
        }

        public Criteria andNtNotLike(String value) {
            addCriterion("NT not like", value, "nt");
            return (Criteria) this;
        }

        public Criteria andNtIn(List<String> values) {
            addCriterion("NT in", values, "nt");
            return (Criteria) this;
        }

        public Criteria andNtNotIn(List<String> values) {
            addCriterion("NT not in", values, "nt");
            return (Criteria) this;
        }

        public Criteria andNtBetween(String value1, String value2) {
            addCriterion("NT between", value1, value2, "nt");
            return (Criteria) this;
        }

        public Criteria andNtNotBetween(String value1, String value2) {
            addCriterion("NT not between", value1, value2, "nt");
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