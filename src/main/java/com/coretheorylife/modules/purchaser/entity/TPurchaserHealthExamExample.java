package com.coretheorylife.modules.purchaser.entity;

import com.coretheorylife.modules.common.example.BaseExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPurchaserHealthExamExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPurchaserHealthExamExample() {
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

        public Criteria andBmiIsNull() {
            addCriterion("bmi is null");
            return (Criteria) this;
        }

        public Criteria andBmiIsNotNull() {
            addCriterion("bmi is not null");
            return (Criteria) this;
        }

        public Criteria andBmiEqualTo(BigDecimal value) {
            addCriterion("bmi =", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotEqualTo(BigDecimal value) {
            addCriterion("bmi <>", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThan(BigDecimal value) {
            addCriterion("bmi >", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bmi >=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThan(BigDecimal value) {
            addCriterion("bmi <", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bmi <=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiIn(List<BigDecimal> values) {
            addCriterion("bmi in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotIn(List<BigDecimal> values) {
            addCriterion("bmi not in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bmi between", value1, value2, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bmi not between", value1, value2, "bmi");
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

        public Criteria andMuscleIsNull() {
            addCriterion("muscle is null");
            return (Criteria) this;
        }

        public Criteria andMuscleIsNotNull() {
            addCriterion("muscle is not null");
            return (Criteria) this;
        }

        public Criteria andMuscleEqualTo(BigDecimal value) {
            addCriterion("muscle =", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleNotEqualTo(BigDecimal value) {
            addCriterion("muscle <>", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleGreaterThan(BigDecimal value) {
            addCriterion("muscle >", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("muscle >=", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleLessThan(BigDecimal value) {
            addCriterion("muscle <", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("muscle <=", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleIn(List<BigDecimal> values) {
            addCriterion("muscle in", values, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleNotIn(List<BigDecimal> values) {
            addCriterion("muscle not in", values, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("muscle between", value1, value2, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("muscle not between", value1, value2, "muscle");
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

        public Criteria andBodyFatIsNull() {
            addCriterion("body_fat is null");
            return (Criteria) this;
        }

        public Criteria andBodyFatIsNotNull() {
            addCriterion("body_fat is not null");
            return (Criteria) this;
        }

        public Criteria andBodyFatEqualTo(BigDecimal value) {
            addCriterion("body_fat =", value, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyFatNotEqualTo(BigDecimal value) {
            addCriterion("body_fat <>", value, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyFatGreaterThan(BigDecimal value) {
            addCriterion("body_fat >", value, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyFatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("body_fat >=", value, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyFatLessThan(BigDecimal value) {
            addCriterion("body_fat <", value, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyFatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("body_fat <=", value, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyFatIn(List<BigDecimal> values) {
            addCriterion("body_fat in", values, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyFatNotIn(List<BigDecimal> values) {
            addCriterion("body_fat not in", values, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyFatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("body_fat between", value1, value2, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyFatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("body_fat not between", value1, value2, "bodyFat");
            return (Criteria) this;
        }

        public Criteria andBodyWaterIsNull() {
            addCriterion("body_water is null");
            return (Criteria) this;
        }

        public Criteria andBodyWaterIsNotNull() {
            addCriterion("body_water is not null");
            return (Criteria) this;
        }

        public Criteria andBodyWaterEqualTo(BigDecimal value) {
            addCriterion("body_water =", value, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andBodyWaterNotEqualTo(BigDecimal value) {
            addCriterion("body_water <>", value, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andBodyWaterGreaterThan(BigDecimal value) {
            addCriterion("body_water >", value, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andBodyWaterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("body_water >=", value, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andBodyWaterLessThan(BigDecimal value) {
            addCriterion("body_water <", value, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andBodyWaterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("body_water <=", value, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andBodyWaterIn(List<BigDecimal> values) {
            addCriterion("body_water in", values, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andBodyWaterNotIn(List<BigDecimal> values) {
            addCriterion("body_water not in", values, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andBodyWaterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("body_water between", value1, value2, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andBodyWaterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("body_water not between", value1, value2, "bodyWater");
            return (Criteria) this;
        }

        public Criteria andProteinIsNull() {
            addCriterion("protein is null");
            return (Criteria) this;
        }

        public Criteria andProteinIsNotNull() {
            addCriterion("protein is not null");
            return (Criteria) this;
        }

        public Criteria andProteinEqualTo(BigDecimal value) {
            addCriterion("protein =", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotEqualTo(BigDecimal value) {
            addCriterion("protein <>", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThan(BigDecimal value) {
            addCriterion("protein >", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("protein >=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThan(BigDecimal value) {
            addCriterion("protein <", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("protein <=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinIn(List<BigDecimal> values) {
            addCriterion("protein in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotIn(List<BigDecimal> values) {
            addCriterion("protein not in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("protein between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("protein not between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andVisceralFatIsNull() {
            addCriterion("visceral_fat is null");
            return (Criteria) this;
        }

        public Criteria andVisceralFatIsNotNull() {
            addCriterion("visceral_fat is not null");
            return (Criteria) this;
        }

        public Criteria andVisceralFatEqualTo(BigDecimal value) {
            addCriterion("visceral_fat =", value, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andVisceralFatNotEqualTo(BigDecimal value) {
            addCriterion("visceral_fat <>", value, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andVisceralFatGreaterThan(BigDecimal value) {
            addCriterion("visceral_fat >", value, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andVisceralFatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("visceral_fat >=", value, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andVisceralFatLessThan(BigDecimal value) {
            addCriterion("visceral_fat <", value, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andVisceralFatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("visceral_fat <=", value, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andVisceralFatIn(List<BigDecimal> values) {
            addCriterion("visceral_fat in", values, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andVisceralFatNotIn(List<BigDecimal> values) {
            addCriterion("visceral_fat not in", values, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andVisceralFatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("visceral_fat between", value1, value2, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andVisceralFatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("visceral_fat not between", value1, value2, "visceralFat");
            return (Criteria) this;
        }

        public Criteria andBoneMassIsNull() {
            addCriterion("bone_mass is null");
            return (Criteria) this;
        }

        public Criteria andBoneMassIsNotNull() {
            addCriterion("bone_mass is not null");
            return (Criteria) this;
        }

        public Criteria andBoneMassEqualTo(BigDecimal value) {
            addCriterion("bone_mass =", value, "boneMass");
            return (Criteria) this;
        }

        public Criteria andBoneMassNotEqualTo(BigDecimal value) {
            addCriterion("bone_mass <>", value, "boneMass");
            return (Criteria) this;
        }

        public Criteria andBoneMassGreaterThan(BigDecimal value) {
            addCriterion("bone_mass >", value, "boneMass");
            return (Criteria) this;
        }

        public Criteria andBoneMassGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bone_mass >=", value, "boneMass");
            return (Criteria) this;
        }

        public Criteria andBoneMassLessThan(BigDecimal value) {
            addCriterion("bone_mass <", value, "boneMass");
            return (Criteria) this;
        }

        public Criteria andBoneMassLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bone_mass <=", value, "boneMass");
            return (Criteria) this;
        }

        public Criteria andBoneMassIn(List<BigDecimal> values) {
            addCriterion("bone_mass in", values, "boneMass");
            return (Criteria) this;
        }

        public Criteria andBoneMassNotIn(List<BigDecimal> values) {
            addCriterion("bone_mass not in", values, "boneMass");
            return (Criteria) this;
        }

        public Criteria andBoneMassBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bone_mass between", value1, value2, "boneMass");
            return (Criteria) this;
        }

        public Criteria andBoneMassNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bone_mass not between", value1, value2, "boneMass");
            return (Criteria) this;
        }

        public Criteria andMuscleRateIsNull() {
            addCriterion("muscle_rate is null");
            return (Criteria) this;
        }

        public Criteria andMuscleRateIsNotNull() {
            addCriterion("muscle_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMuscleRateEqualTo(BigDecimal value) {
            addCriterion("muscle_rate =", value, "muscleRate");
            return (Criteria) this;
        }

        public Criteria andMuscleRateNotEqualTo(BigDecimal value) {
            addCriterion("muscle_rate <>", value, "muscleRate");
            return (Criteria) this;
        }

        public Criteria andMuscleRateGreaterThan(BigDecimal value) {
            addCriterion("muscle_rate >", value, "muscleRate");
            return (Criteria) this;
        }

        public Criteria andMuscleRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("muscle_rate >=", value, "muscleRate");
            return (Criteria) this;
        }

        public Criteria andMuscleRateLessThan(BigDecimal value) {
            addCriterion("muscle_rate <", value, "muscleRate");
            return (Criteria) this;
        }

        public Criteria andMuscleRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("muscle_rate <=", value, "muscleRate");
            return (Criteria) this;
        }

        public Criteria andMuscleRateIn(List<BigDecimal> values) {
            addCriterion("muscle_rate in", values, "muscleRate");
            return (Criteria) this;
        }

        public Criteria andMuscleRateNotIn(List<BigDecimal> values) {
            addCriterion("muscle_rate not in", values, "muscleRate");
            return (Criteria) this;
        }

        public Criteria andMuscleRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("muscle_rate between", value1, value2, "muscleRate");
            return (Criteria) this;
        }

        public Criteria andMuscleRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("muscle_rate not between", value1, value2, "muscleRate");
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

        public Criteria andBodyWaterRateIsNull() {
            addCriterion("body_water_rate is null");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateIsNotNull() {
            addCriterion("body_water_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateEqualTo(BigDecimal value) {
            addCriterion("body_water_rate =", value, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateNotEqualTo(BigDecimal value) {
            addCriterion("body_water_rate <>", value, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateGreaterThan(BigDecimal value) {
            addCriterion("body_water_rate >", value, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("body_water_rate >=", value, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateLessThan(BigDecimal value) {
            addCriterion("body_water_rate <", value, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("body_water_rate <=", value, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateIn(List<BigDecimal> values) {
            addCriterion("body_water_rate in", values, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateNotIn(List<BigDecimal> values) {
            addCriterion("body_water_rate not in", values, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("body_water_rate between", value1, value2, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andBodyWaterRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("body_water_rate not between", value1, value2, "bodyWaterRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateIsNull() {
            addCriterion("protein_rate is null");
            return (Criteria) this;
        }

        public Criteria andProteinRateIsNotNull() {
            addCriterion("protein_rate is not null");
            return (Criteria) this;
        }

        public Criteria andProteinRateEqualTo(BigDecimal value) {
            addCriterion("protein_rate =", value, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateNotEqualTo(BigDecimal value) {
            addCriterion("protein_rate <>", value, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateGreaterThan(BigDecimal value) {
            addCriterion("protein_rate >", value, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("protein_rate >=", value, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateLessThan(BigDecimal value) {
            addCriterion("protein_rate <", value, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("protein_rate <=", value, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateIn(List<BigDecimal> values) {
            addCriterion("protein_rate in", values, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateNotIn(List<BigDecimal> values) {
            addCriterion("protein_rate not in", values, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("protein_rate between", value1, value2, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andProteinRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("protein_rate not between", value1, value2, "proteinRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateIsNull() {
            addCriterion("visceral_fat_rate is null");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateIsNotNull() {
            addCriterion("visceral_fat_rate is not null");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateEqualTo(BigDecimal value) {
            addCriterion("visceral_fat_rate =", value, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateNotEqualTo(BigDecimal value) {
            addCriterion("visceral_fat_rate <>", value, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateGreaterThan(BigDecimal value) {
            addCriterion("visceral_fat_rate >", value, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("visceral_fat_rate >=", value, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateLessThan(BigDecimal value) {
            addCriterion("visceral_fat_rate <", value, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("visceral_fat_rate <=", value, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateIn(List<BigDecimal> values) {
            addCriterion("visceral_fat_rate in", values, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateNotIn(List<BigDecimal> values) {
            addCriterion("visceral_fat_rate not in", values, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("visceral_fat_rate between", value1, value2, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andVisceralFatRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("visceral_fat_rate not between", value1, value2, "visceralFatRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateIsNull() {
            addCriterion("bone_mass_rate is null");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateIsNotNull() {
            addCriterion("bone_mass_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateEqualTo(BigDecimal value) {
            addCriterion("bone_mass_rate =", value, "boneMassRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateNotEqualTo(BigDecimal value) {
            addCriterion("bone_mass_rate <>", value, "boneMassRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateGreaterThan(BigDecimal value) {
            addCriterion("bone_mass_rate >", value, "boneMassRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bone_mass_rate >=", value, "boneMassRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateLessThan(BigDecimal value) {
            addCriterion("bone_mass_rate <", value, "boneMassRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bone_mass_rate <=", value, "boneMassRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateIn(List<BigDecimal> values) {
            addCriterion("bone_mass_rate in", values, "boneMassRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateNotIn(List<BigDecimal> values) {
            addCriterion("bone_mass_rate not in", values, "boneMassRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bone_mass_rate between", value1, value2, "boneMassRate");
            return (Criteria) this;
        }

        public Criteria andBoneMassRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bone_mass_rate not between", value1, value2, "boneMassRate");
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

        public Criteria andAdiposeNeedIsNull() {
            addCriterion("adipose_need is null");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedIsNotNull() {
            addCriterion("adipose_need is not null");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedEqualTo(BigDecimal value) {
            addCriterion("adipose_need =", value, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedNotEqualTo(BigDecimal value) {
            addCriterion("adipose_need <>", value, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedGreaterThan(BigDecimal value) {
            addCriterion("adipose_need >", value, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("adipose_need >=", value, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedLessThan(BigDecimal value) {
            addCriterion("adipose_need <", value, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("adipose_need <=", value, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedIn(List<BigDecimal> values) {
            addCriterion("adipose_need in", values, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedNotIn(List<BigDecimal> values) {
            addCriterion("adipose_need not in", values, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adipose_need between", value1, value2, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andAdiposeNeedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adipose_need not between", value1, value2, "adiposeNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedIsNull() {
            addCriterion("kacl_need is null");
            return (Criteria) this;
        }

        public Criteria andKaclNeedIsNotNull() {
            addCriterion("kacl_need is not null");
            return (Criteria) this;
        }

        public Criteria andKaclNeedEqualTo(BigDecimal value) {
            addCriterion("kacl_need =", value, "kaclNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedNotEqualTo(BigDecimal value) {
            addCriterion("kacl_need <>", value, "kaclNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedGreaterThan(BigDecimal value) {
            addCriterion("kacl_need >", value, "kaclNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kacl_need >=", value, "kaclNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedLessThan(BigDecimal value) {
            addCriterion("kacl_need <", value, "kaclNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kacl_need <=", value, "kaclNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedIn(List<BigDecimal> values) {
            addCriterion("kacl_need in", values, "kaclNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedNotIn(List<BigDecimal> values) {
            addCriterion("kacl_need not in", values, "kaclNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kacl_need between", value1, value2, "kaclNeed");
            return (Criteria) this;
        }

        public Criteria andKaclNeedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kacl_need not between", value1, value2, "kaclNeed");
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