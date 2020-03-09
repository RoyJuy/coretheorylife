package com.coretheorylife.modules.purchaser.entity;

import com.coretheorylife.modules.common.example.BaseExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPurchaserHealthLogExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPurchaserHealthLogExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterionForJDBCDate("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterionForJDBCDate("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterionForJDBCDate("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("log_time not between", value1, value2, "logTime");
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

        public Criteria andCarbohydrateIsNull() {
            addCriterion("carbohydrate is null");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateIsNotNull() {
            addCriterion("carbohydrate is not null");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateEqualTo(BigDecimal value) {
            addCriterion("carbohydrate =", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotEqualTo(BigDecimal value) {
            addCriterion("carbohydrate <>", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateGreaterThan(BigDecimal value) {
            addCriterion("carbohydrate >", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("carbohydrate >=", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateLessThan(BigDecimal value) {
            addCriterion("carbohydrate <", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("carbohydrate <=", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateIn(List<BigDecimal> values) {
            addCriterion("carbohydrate in", values, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotIn(List<BigDecimal> values) {
            addCriterion("carbohydrate not in", values, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carbohydrate between", value1, value2, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carbohydrate not between", value1, value2, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andAdiposeIsNull() {
            addCriterion("adipose is null");
            return (Criteria) this;
        }

        public Criteria andAdiposeIsNotNull() {
            addCriterion("adipose is not null");
            return (Criteria) this;
        }

        public Criteria andAdiposeEqualTo(BigDecimal value) {
            addCriterion("adipose =", value, "adipose");
            return (Criteria) this;
        }

        public Criteria andAdiposeNotEqualTo(BigDecimal value) {
            addCriterion("adipose <>", value, "adipose");
            return (Criteria) this;
        }

        public Criteria andAdiposeGreaterThan(BigDecimal value) {
            addCriterion("adipose >", value, "adipose");
            return (Criteria) this;
        }

        public Criteria andAdiposeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("adipose >=", value, "adipose");
            return (Criteria) this;
        }

        public Criteria andAdiposeLessThan(BigDecimal value) {
            addCriterion("adipose <", value, "adipose");
            return (Criteria) this;
        }

        public Criteria andAdiposeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("adipose <=", value, "adipose");
            return (Criteria) this;
        }

        public Criteria andAdiposeIn(List<BigDecimal> values) {
            addCriterion("adipose in", values, "adipose");
            return (Criteria) this;
        }

        public Criteria andAdiposeNotIn(List<BigDecimal> values) {
            addCriterion("adipose not in", values, "adipose");
            return (Criteria) this;
        }

        public Criteria andAdiposeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adipose between", value1, value2, "adipose");
            return (Criteria) this;
        }

        public Criteria andAdiposeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adipose not between", value1, value2, "adipose");
            return (Criteria) this;
        }

        public Criteria andKaclIsNull() {
            addCriterion("kacl is null");
            return (Criteria) this;
        }

        public Criteria andKaclIsNotNull() {
            addCriterion("kacl is not null");
            return (Criteria) this;
        }

        public Criteria andKaclEqualTo(BigDecimal value) {
            addCriterion("kacl =", value, "kacl");
            return (Criteria) this;
        }

        public Criteria andKaclNotEqualTo(BigDecimal value) {
            addCriterion("kacl <>", value, "kacl");
            return (Criteria) this;
        }

        public Criteria andKaclGreaterThan(BigDecimal value) {
            addCriterion("kacl >", value, "kacl");
            return (Criteria) this;
        }

        public Criteria andKaclGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kacl >=", value, "kacl");
            return (Criteria) this;
        }

        public Criteria andKaclLessThan(BigDecimal value) {
            addCriterion("kacl <", value, "kacl");
            return (Criteria) this;
        }

        public Criteria andKaclLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kacl <=", value, "kacl");
            return (Criteria) this;
        }

        public Criteria andKaclIn(List<BigDecimal> values) {
            addCriterion("kacl in", values, "kacl");
            return (Criteria) this;
        }

        public Criteria andKaclNotIn(List<BigDecimal> values) {
            addCriterion("kacl not in", values, "kacl");
            return (Criteria) this;
        }

        public Criteria andKaclBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kacl between", value1, value2, "kacl");
            return (Criteria) this;
        }

        public Criteria andKaclNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kacl not between", value1, value2, "kacl");
            return (Criteria) this;
        }

        public Criteria andAllProteinIsNull() {
            addCriterion("all_protein is null");
            return (Criteria) this;
        }

        public Criteria andAllProteinIsNotNull() {
            addCriterion("all_protein is not null");
            return (Criteria) this;
        }

        public Criteria andAllProteinEqualTo(BigDecimal value) {
            addCriterion("all_protein =", value, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllProteinNotEqualTo(BigDecimal value) {
            addCriterion("all_protein <>", value, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllProteinGreaterThan(BigDecimal value) {
            addCriterion("all_protein >", value, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllProteinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_protein >=", value, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllProteinLessThan(BigDecimal value) {
            addCriterion("all_protein <", value, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllProteinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_protein <=", value, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllProteinIn(List<BigDecimal> values) {
            addCriterion("all_protein in", values, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllProteinNotIn(List<BigDecimal> values) {
            addCriterion("all_protein not in", values, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllProteinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_protein between", value1, value2, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllProteinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_protein not between", value1, value2, "allProtein");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateIsNull() {
            addCriterion("all_carbohydrate is null");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateIsNotNull() {
            addCriterion("all_carbohydrate is not null");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateEqualTo(BigDecimal value) {
            addCriterion("all_carbohydrate =", value, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateNotEqualTo(BigDecimal value) {
            addCriterion("all_carbohydrate <>", value, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateGreaterThan(BigDecimal value) {
            addCriterion("all_carbohydrate >", value, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_carbohydrate >=", value, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateLessThan(BigDecimal value) {
            addCriterion("all_carbohydrate <", value, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_carbohydrate <=", value, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateIn(List<BigDecimal> values) {
            addCriterion("all_carbohydrate in", values, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateNotIn(List<BigDecimal> values) {
            addCriterion("all_carbohydrate not in", values, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_carbohydrate between", value1, value2, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllCarbohydrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_carbohydrate not between", value1, value2, "allCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeIsNull() {
            addCriterion("all_adipose is null");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeIsNotNull() {
            addCriterion("all_adipose is not null");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeEqualTo(BigDecimal value) {
            addCriterion("all_adipose =", value, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeNotEqualTo(BigDecimal value) {
            addCriterion("all_adipose <>", value, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeGreaterThan(BigDecimal value) {
            addCriterion("all_adipose >", value, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_adipose >=", value, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeLessThan(BigDecimal value) {
            addCriterion("all_adipose <", value, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_adipose <=", value, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeIn(List<BigDecimal> values) {
            addCriterion("all_adipose in", values, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeNotIn(List<BigDecimal> values) {
            addCriterion("all_adipose not in", values, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_adipose between", value1, value2, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllAdiposeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_adipose not between", value1, value2, "allAdipose");
            return (Criteria) this;
        }

        public Criteria andAllKaclIsNull() {
            addCriterion("all_kacl is null");
            return (Criteria) this;
        }

        public Criteria andAllKaclIsNotNull() {
            addCriterion("all_kacl is not null");
            return (Criteria) this;
        }

        public Criteria andAllKaclEqualTo(BigDecimal value) {
            addCriterion("all_kacl =", value, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllKaclNotEqualTo(BigDecimal value) {
            addCriterion("all_kacl <>", value, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllKaclGreaterThan(BigDecimal value) {
            addCriterion("all_kacl >", value, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllKaclGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_kacl >=", value, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllKaclLessThan(BigDecimal value) {
            addCriterion("all_kacl <", value, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllKaclLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_kacl <=", value, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllKaclIn(List<BigDecimal> values) {
            addCriterion("all_kacl in", values, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllKaclNotIn(List<BigDecimal> values) {
            addCriterion("all_kacl not in", values, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllKaclBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_kacl between", value1, value2, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllKaclNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_kacl not between", value1, value2, "allKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinIsNull() {
            addCriterion("all_day_protein is null");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinIsNotNull() {
            addCriterion("all_day_protein is not null");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinEqualTo(BigDecimal value) {
            addCriterion("all_day_protein =", value, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinNotEqualTo(BigDecimal value) {
            addCriterion("all_day_protein <>", value, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinGreaterThan(BigDecimal value) {
            addCriterion("all_day_protein >", value, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_day_protein >=", value, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinLessThan(BigDecimal value) {
            addCriterion("all_day_protein <", value, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_day_protein <=", value, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinIn(List<BigDecimal> values) {
            addCriterion("all_day_protein in", values, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinNotIn(List<BigDecimal> values) {
            addCriterion("all_day_protein not in", values, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_day_protein between", value1, value2, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayProteinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_day_protein not between", value1, value2, "allDayProtein");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateIsNull() {
            addCriterion("all_day_carbohydrate is null");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateIsNotNull() {
            addCriterion("all_day_carbohydrate is not null");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateEqualTo(BigDecimal value) {
            addCriterion("all_day_carbohydrate =", value, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateNotEqualTo(BigDecimal value) {
            addCriterion("all_day_carbohydrate <>", value, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateGreaterThan(BigDecimal value) {
            addCriterion("all_day_carbohydrate >", value, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_day_carbohydrate >=", value, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateLessThan(BigDecimal value) {
            addCriterion("all_day_carbohydrate <", value, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_day_carbohydrate <=", value, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateIn(List<BigDecimal> values) {
            addCriterion("all_day_carbohydrate in", values, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateNotIn(List<BigDecimal> values) {
            addCriterion("all_day_carbohydrate not in", values, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_day_carbohydrate between", value1, value2, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayCarbohydrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_day_carbohydrate not between", value1, value2, "allDayCarbohydrate");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeIsNull() {
            addCriterion("all_day_adipose is null");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeIsNotNull() {
            addCriterion("all_day_adipose is not null");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeEqualTo(BigDecimal value) {
            addCriterion("all_day_adipose =", value, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeNotEqualTo(BigDecimal value) {
            addCriterion("all_day_adipose <>", value, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeGreaterThan(BigDecimal value) {
            addCriterion("all_day_adipose >", value, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_day_adipose >=", value, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeLessThan(BigDecimal value) {
            addCriterion("all_day_adipose <", value, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_day_adipose <=", value, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeIn(List<BigDecimal> values) {
            addCriterion("all_day_adipose in", values, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeNotIn(List<BigDecimal> values) {
            addCriterion("all_day_adipose not in", values, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_day_adipose between", value1, value2, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayAdiposeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_day_adipose not between", value1, value2, "allDayAdipose");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclIsNull() {
            addCriterion("all_day_kacl is null");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclIsNotNull() {
            addCriterion("all_day_kacl is not null");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclEqualTo(BigDecimal value) {
            addCriterion("all_day_kacl =", value, "allDayKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclNotEqualTo(BigDecimal value) {
            addCriterion("all_day_kacl <>", value, "allDayKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclGreaterThan(BigDecimal value) {
            addCriterion("all_day_kacl >", value, "allDayKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_day_kacl >=", value, "allDayKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclLessThan(BigDecimal value) {
            addCriterion("all_day_kacl <", value, "allDayKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_day_kacl <=", value, "allDayKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclIn(List<BigDecimal> values) {
            addCriterion("all_day_kacl in", values, "allDayKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclNotIn(List<BigDecimal> values) {
            addCriterion("all_day_kacl not in", values, "allDayKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_day_kacl between", value1, value2, "allDayKacl");
            return (Criteria) this;
        }

        public Criteria andAllDayKaclNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_day_kacl not between", value1, value2, "allDayKacl");
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