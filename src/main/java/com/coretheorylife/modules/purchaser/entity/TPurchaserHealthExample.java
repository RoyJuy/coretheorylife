package com.coretheorylife.modules.purchaser.entity;

import com.coretheorylife.modules.common.example.BaseExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPurchaserHealthExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPurchaserHealthExample() {
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

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2020-01-14
     */
    protected abstract static class GeneratedCriteria extends BaseCriteria {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdIsNull() {
            addCriterion("purchaser_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdIsNotNull() {
            addCriterion("purchaser_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdEqualTo(Long value) {
            addCriterion("purchaser_id =", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdNotEqualTo(Long value) {
            addCriterion("purchaser_id <>", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdGreaterThan(Long value) {
            addCriterion("purchaser_id >", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("purchaser_id >=", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdLessThan(Long value) {
            addCriterion("purchaser_id <", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdLessThanOrEqualTo(Long value) {
            addCriterion("purchaser_id <=", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdIn(List<Long> values) {
            addCriterion("purchaser_id in", values, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdNotIn(List<Long> values) {
            addCriterion("purchaser_id not in", values, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdBetween(Long value1, Long value2) {
            addCriterion("purchaser_id between", value1, value2, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdNotBetween(Long value1, Long value2) {
            addCriterion("purchaser_id not between", value1, value2, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(BigDecimal value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(BigDecimal value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(BigDecimal value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(BigDecimal value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<BigDecimal> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<BigDecimal> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andTargetIsNull() {
            addCriterion("target is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("target is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(Integer value) {
            addCriterion("target =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(Integer value) {
            addCriterion("target <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(Integer value) {
            addCriterion("target >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(Integer value) {
            addCriterion("target >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(Integer value) {
            addCriterion("target <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(Integer value) {
            addCriterion("target <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(List<Integer> values) {
            addCriterion("target in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(List<Integer> values) {
            addCriterion("target not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(Integer value1, Integer value2) {
            addCriterion("target between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(Integer value1, Integer value2) {
            addCriterion("target not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andStandardWeightIsNull() {
            addCriterion("standard_weight is null");
            return (Criteria) this;
        }

        public Criteria andStandardWeightIsNotNull() {
            addCriterion("standard_weight is not null");
            return (Criteria) this;
        }

        public Criteria andStandardWeightEqualTo(BigDecimal value) {
            addCriterion("standard_weight =", value, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andStandardWeightNotEqualTo(BigDecimal value) {
            addCriterion("standard_weight <>", value, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andStandardWeightGreaterThan(BigDecimal value) {
            addCriterion("standard_weight >", value, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andStandardWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("standard_weight >=", value, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andStandardWeightLessThan(BigDecimal value) {
            addCriterion("standard_weight <", value, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andStandardWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("standard_weight <=", value, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andStandardWeightIn(List<BigDecimal> values) {
            addCriterion("standard_weight in", values, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andStandardWeightNotIn(List<BigDecimal> values) {
            addCriterion("standard_weight not in", values, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andStandardWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("standard_weight between", value1, value2, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andStandardWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("standard_weight not between", value1, value2, "standardWeight");
            return (Criteria) this;
        }

        public Criteria andExerciseIsNull() {
            addCriterion("exercise is null");
            return (Criteria) this;
        }

        public Criteria andExerciseIsNotNull() {
            addCriterion("exercise is not null");
            return (Criteria) this;
        }

        public Criteria andExerciseEqualTo(Integer value) {
            addCriterion("exercise =", value, "exercise");
            return (Criteria) this;
        }

        public Criteria andExerciseNotEqualTo(Integer value) {
            addCriterion("exercise <>", value, "exercise");
            return (Criteria) this;
        }

        public Criteria andExerciseGreaterThan(Integer value) {
            addCriterion("exercise >", value, "exercise");
            return (Criteria) this;
        }

        public Criteria andExerciseGreaterThanOrEqualTo(Integer value) {
            addCriterion("exercise >=", value, "exercise");
            return (Criteria) this;
        }

        public Criteria andExerciseLessThan(Integer value) {
            addCriterion("exercise <", value, "exercise");
            return (Criteria) this;
        }

        public Criteria andExerciseLessThanOrEqualTo(Integer value) {
            addCriterion("exercise <=", value, "exercise");
            return (Criteria) this;
        }

        public Criteria andExerciseIn(List<Integer> values) {
            addCriterion("exercise in", values, "exercise");
            return (Criteria) this;
        }

        public Criteria andExerciseNotIn(List<Integer> values) {
            addCriterion("exercise not in", values, "exercise");
            return (Criteria) this;
        }

        public Criteria andExerciseBetween(Integer value1, Integer value2) {
            addCriterion("exercise between", value1, value2, "exercise");
            return (Criteria) this;
        }

        public Criteria andExerciseNotBetween(Integer value1, Integer value2) {
            addCriterion("exercise not between", value1, value2, "exercise");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismIsNull() {
            addCriterion("basal_metabolism is null");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismIsNotNull() {
            addCriterion("basal_metabolism is not null");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismEqualTo(BigDecimal value) {
            addCriterion("basal_metabolism =", value, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismNotEqualTo(BigDecimal value) {
            addCriterion("basal_metabolism <>", value, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismGreaterThan(BigDecimal value) {
            addCriterion("basal_metabolism >", value, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basal_metabolism >=", value, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismLessThan(BigDecimal value) {
            addCriterion("basal_metabolism <", value, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basal_metabolism <=", value, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismIn(List<BigDecimal> values) {
            addCriterion("basal_metabolism in", values, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismNotIn(List<BigDecimal> values) {
            addCriterion("basal_metabolism not in", values, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basal_metabolism between", value1, value2, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andBasalMetabolismNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basal_metabolism not between", value1, value2, "basalMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismIsNull() {
            addCriterion("sport_metabolism is null");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismIsNotNull() {
            addCriterion("sport_metabolism is not null");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismEqualTo(BigDecimal value) {
            addCriterion("sport_metabolism =", value, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismNotEqualTo(BigDecimal value) {
            addCriterion("sport_metabolism <>", value, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismGreaterThan(BigDecimal value) {
            addCriterion("sport_metabolism >", value, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sport_metabolism >=", value, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismLessThan(BigDecimal value) {
            addCriterion("sport_metabolism <", value, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sport_metabolism <=", value, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismIn(List<BigDecimal> values) {
            addCriterion("sport_metabolism in", values, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismNotIn(List<BigDecimal> values) {
            addCriterion("sport_metabolism not in", values, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sport_metabolism between", value1, value2, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andSportMetabolismNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sport_metabolism not between", value1, value2, "sportMetabolism");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateIsNull() {
            addCriterion("body_fat_rate is null");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateIsNotNull() {
            addCriterion("body_fat_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateEqualTo(BigDecimal value) {
            addCriterion("body_fat_rate =", value, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateNotEqualTo(BigDecimal value) {
            addCriterion("body_fat_rate <>", value, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateGreaterThan(BigDecimal value) {
            addCriterion("body_fat_rate >", value, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("body_fat_rate >=", value, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateLessThan(BigDecimal value) {
            addCriterion("body_fat_rate <", value, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("body_fat_rate <=", value, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateIn(List<BigDecimal> values) {
            addCriterion("body_fat_rate in", values, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateNotIn(List<BigDecimal> values) {
            addCriterion("body_fat_rate not in", values, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("body_fat_rate between", value1, value2, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andBodyFatRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("body_fat_rate not between", value1, value2, "bodyFatRate");
            return (Criteria) this;
        }

        public Criteria andFatNeedIsNull() {
            addCriterion("fat_need is null");
            return (Criteria) this;
        }

        public Criteria andFatNeedIsNotNull() {
            addCriterion("fat_need is not null");
            return (Criteria) this;
        }

        public Criteria andFatNeedEqualTo(BigDecimal value) {
            addCriterion("fat_need =", value, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andFatNeedNotEqualTo(BigDecimal value) {
            addCriterion("fat_need <>", value, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andFatNeedGreaterThan(BigDecimal value) {
            addCriterion("fat_need >", value, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andFatNeedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fat_need >=", value, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andFatNeedLessThan(BigDecimal value) {
            addCriterion("fat_need <", value, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andFatNeedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fat_need <=", value, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andFatNeedIn(List<BigDecimal> values) {
            addCriterion("fat_need in", values, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andFatNeedNotIn(List<BigDecimal> values) {
            addCriterion("fat_need not in", values, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andFatNeedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fat_need between", value1, value2, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andFatNeedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fat_need not between", value1, value2, "fatNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedIsNull() {
            addCriterion("protein_need is null");
            return (Criteria) this;
        }

        public Criteria andProteinNeedIsNotNull() {
            addCriterion("protein_need is not null");
            return (Criteria) this;
        }

        public Criteria andProteinNeedEqualTo(BigDecimal value) {
            addCriterion("protein_need =", value, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedNotEqualTo(BigDecimal value) {
            addCriterion("protein_need <>", value, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedGreaterThan(BigDecimal value) {
            addCriterion("protein_need >", value, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("protein_need >=", value, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedLessThan(BigDecimal value) {
            addCriterion("protein_need <", value, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("protein_need <=", value, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedIn(List<BigDecimal> values) {
            addCriterion("protein_need in", values, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedNotIn(List<BigDecimal> values) {
            addCriterion("protein_need not in", values, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("protein_need between", value1, value2, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andProteinNeedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("protein_need not between", value1, value2, "proteinNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedIsNull() {
            addCriterion("carbohydrate_need is null");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedIsNotNull() {
            addCriterion("carbohydrate_need is not null");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedEqualTo(BigDecimal value) {
            addCriterion("carbohydrate_need =", value, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedNotEqualTo(BigDecimal value) {
            addCriterion("carbohydrate_need <>", value, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedGreaterThan(BigDecimal value) {
            addCriterion("carbohydrate_need >", value, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("carbohydrate_need >=", value, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedLessThan(BigDecimal value) {
            addCriterion("carbohydrate_need <", value, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("carbohydrate_need <=", value, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedIn(List<BigDecimal> values) {
            addCriterion("carbohydrate_need in", values, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedNotIn(List<BigDecimal> values) {
            addCriterion("carbohydrate_need not in", values, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carbohydrate_need between", value1, value2, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNeedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carbohydrate_need not between", value1, value2, "carbohydrateNeed");
            return (Criteria) this;
        }

        public Criteria andExamerIsNull() {
            addCriterion("examer is null");
            return (Criteria) this;
        }

        public Criteria andExamerIsNotNull() {
            addCriterion("examer is not null");
            return (Criteria) this;
        }

        public Criteria andExamerEqualTo(Boolean value) {
            addCriterion("examer =", value, "examer");
            return (Criteria) this;
        }

        public Criteria andExamerNotEqualTo(Boolean value) {
            addCriterion("examer <>", value, "examer");
            return (Criteria) this;
        }

        public Criteria andExamerGreaterThan(Boolean value) {
            addCriterion("examer >", value, "examer");
            return (Criteria) this;
        }

        public Criteria andExamerGreaterThanOrEqualTo(Boolean value) {
            addCriterion("examer >=", value, "examer");
            return (Criteria) this;
        }

        public Criteria andExamerLessThan(Boolean value) {
            addCriterion("examer <", value, "examer");
            return (Criteria) this;
        }

        public Criteria andExamerLessThanOrEqualTo(Boolean value) {
            addCriterion("examer <=", value, "examer");
            return (Criteria) this;
        }

        public Criteria andExamerIn(List<Boolean> values) {
            addCriterion("examer in", values, "examer");
            return (Criteria) this;
        }

        public Criteria andExamerNotIn(List<Boolean> values) {
            addCriterion("examer not in", values, "examer");
            return (Criteria) this;
        }

        public Criteria andExamerBetween(Boolean value1, Boolean value2) {
            addCriterion("examer between", value1, value2, "examer");
            return (Criteria) this;
        }

        public Criteria andExamerNotBetween(Boolean value1, Boolean value2) {
            addCriterion("examer not between", value1, value2, "examer");
            return (Criteria) this;
        }

        public Criteria andDreamWeightIsNull() {
            addCriterion("dream_weight is null");
            return (Criteria) this;
        }

        public Criteria andDreamWeightIsNotNull() {
            addCriterion("dream_weight is not null");
            return (Criteria) this;
        }

        public Criteria andDreamWeightEqualTo(BigDecimal value) {
            addCriterion("dream_weight =", value, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andDreamWeightNotEqualTo(BigDecimal value) {
            addCriterion("dream_weight <>", value, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andDreamWeightGreaterThan(BigDecimal value) {
            addCriterion("dream_weight >", value, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andDreamWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dream_weight >=", value, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andDreamWeightLessThan(BigDecimal value) {
            addCriterion("dream_weight <", value, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andDreamWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dream_weight <=", value, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andDreamWeightIn(List<BigDecimal> values) {
            addCriterion("dream_weight in", values, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andDreamWeightNotIn(List<BigDecimal> values) {
            addCriterion("dream_weight not in", values, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andDreamWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dream_weight between", value1, value2, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andDreamWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dream_weight not between", value1, value2, "dreamWeight");
            return (Criteria) this;
        }

        public Criteria andKclNeedIsNull() {
            addCriterion("kcl_need is null");
            return (Criteria) this;
        }

        public Criteria andKclNeedIsNotNull() {
            addCriterion("kcl_need is not null");
            return (Criteria) this;
        }

        public Criteria andKclNeedEqualTo(BigDecimal value) {
            addCriterion("kcl_need =", value, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andKclNeedNotEqualTo(BigDecimal value) {
            addCriterion("kcl_need <>", value, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andKclNeedGreaterThan(BigDecimal value) {
            addCriterion("kcl_need >", value, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andKclNeedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kcl_need >=", value, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andKclNeedLessThan(BigDecimal value) {
            addCriterion("kcl_need <", value, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andKclNeedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kcl_need <=", value, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andKclNeedIn(List<BigDecimal> values) {
            addCriterion("kcl_need in", values, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andKclNeedNotIn(List<BigDecimal> values) {
            addCriterion("kcl_need not in", values, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andKclNeedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kcl_need between", value1, value2, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andKclNeedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kcl_need not between", value1, value2, "kclNeed");
            return (Criteria) this;
        }

        public Criteria andDreamDateIsNull() {
            addCriterion("dream_date is null");
            return (Criteria) this;
        }

        public Criteria andDreamDateIsNotNull() {
            addCriterion("dream_date is not null");
            return (Criteria) this;
        }

        public Criteria andDreamDateEqualTo(Date value) {
            addCriterion("dream_date =", value, "dreamDate");
            return (Criteria) this;
        }

        public Criteria andDreamDateNotEqualTo(Date value) {
            addCriterion("dream_date <>", value, "dreamDate");
            return (Criteria) this;
        }

        public Criteria andDreamDateGreaterThan(Date value) {
            addCriterion("dream_date >", value, "dreamDate");
            return (Criteria) this;
        }

        public Criteria andDreamDateGreaterThanOrEqualTo(Date value) {
            addCriterion("dream_date >=", value, "dreamDate");
            return (Criteria) this;
        }

        public Criteria andDreamDateLessThan(Date value) {
            addCriterion("dream_date <", value, "dreamDate");
            return (Criteria) this;
        }

        public Criteria andDreamDateLessThanOrEqualTo(Date value) {
            addCriterion("dream_date <=", value, "dreamDate");
            return (Criteria) this;
        }

        public Criteria andDreamDateIn(List<Date> values) {
            addCriterion("dream_date in", values, "dreamDate");
            return (Criteria) this;
        }

        public Criteria andDreamDateNotIn(List<Date> values) {
            addCriterion("dream_date not in", values, "dreamDate");
            return (Criteria) this;
        }

        public Criteria andDreamDateBetween(Date value1, Date value2) {
            addCriterion("dream_date between", value1, value2, "dreamDate");
            return (Criteria) this;
        }

        public Criteria andDreamDateNotBetween(Date value1, Date value2) {
            addCriterion("dream_date not between", value1, value2, "dreamDate");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Long> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Long> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Boolean value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Boolean value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Boolean value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Boolean value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Boolean> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Boolean> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}