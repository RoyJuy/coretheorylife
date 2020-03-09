package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.example.BaseExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TShopAccountLogExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TShopAccountLogExample() {
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountIsNull() {
            addCriterion("not_settle_amount is null");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountIsNotNull() {
            addCriterion("not_settle_amount is not null");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountEqualTo(BigDecimal value) {
            addCriterion("not_settle_amount =", value, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountNotEqualTo(BigDecimal value) {
            addCriterion("not_settle_amount <>", value, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountGreaterThan(BigDecimal value) {
            addCriterion("not_settle_amount >", value, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("not_settle_amount >=", value, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountLessThan(BigDecimal value) {
            addCriterion("not_settle_amount <", value, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("not_settle_amount <=", value, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountIn(List<BigDecimal> values) {
            addCriterion("not_settle_amount in", values, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountNotIn(List<BigDecimal> values) {
            addCriterion("not_settle_amount not in", values, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("not_settle_amount between", value1, value2, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("not_settle_amount not between", value1, value2, "notSettleAmount");
            return (Criteria) this;
        }

        public Criteria andAmountAfterIsNull() {
            addCriterion("amount_after is null");
            return (Criteria) this;
        }

        public Criteria andAmountAfterIsNotNull() {
            addCriterion("amount_after is not null");
            return (Criteria) this;
        }

        public Criteria andAmountAfterEqualTo(BigDecimal value) {
            addCriterion("amount_after =", value, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andAmountAfterNotEqualTo(BigDecimal value) {
            addCriterion("amount_after <>", value, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andAmountAfterGreaterThan(BigDecimal value) {
            addCriterion("amount_after >", value, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andAmountAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_after >=", value, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andAmountAfterLessThan(BigDecimal value) {
            addCriterion("amount_after <", value, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andAmountAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_after <=", value, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andAmountAfterIn(List<BigDecimal> values) {
            addCriterion("amount_after in", values, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andAmountAfterNotIn(List<BigDecimal> values) {
            addCriterion("amount_after not in", values, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andAmountAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_after between", value1, value2, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andAmountAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_after not between", value1, value2, "amountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterIsNull() {
            addCriterion("not_settle_amount_after is null");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterIsNotNull() {
            addCriterion("not_settle_amount_after is not null");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterEqualTo(BigDecimal value) {
            addCriterion("not_settle_amount_after =", value, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterNotEqualTo(BigDecimal value) {
            addCriterion("not_settle_amount_after <>", value, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterGreaterThan(BigDecimal value) {
            addCriterion("not_settle_amount_after >", value, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("not_settle_amount_after >=", value, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterLessThan(BigDecimal value) {
            addCriterion("not_settle_amount_after <", value, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("not_settle_amount_after <=", value, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterIn(List<BigDecimal> values) {
            addCriterion("not_settle_amount_after in", values, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterNotIn(List<BigDecimal> values) {
            addCriterion("not_settle_amount_after not in", values, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("not_settle_amount_after between", value1, value2, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andNotSettleAmountAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("not_settle_amount_after not between", value1, value2, "notSettleAmountAfter");
            return (Criteria) this;
        }

        public Criteria andBankIdIsNull() {
            addCriterion("bank_id is null");
            return (Criteria) this;
        }

        public Criteria andBankIdIsNotNull() {
            addCriterion("bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andBankIdEqualTo(Long value) {
            addCriterion("bank_id =", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotEqualTo(Long value) {
            addCriterion("bank_id <>", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThan(Long value) {
            addCriterion("bank_id >", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bank_id >=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThan(Long value) {
            addCriterion("bank_id <", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThanOrEqualTo(Long value) {
            addCriterion("bank_id <=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdIn(List<Long> values) {
            addCriterion("bank_id in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotIn(List<Long> values) {
            addCriterion("bank_id not in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdBetween(Long value1, Long value2) {
            addCriterion("bank_id between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotBetween(Long value1, Long value2) {
            addCriterion("bank_id not between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdIsNull() {
            addCriterion("sf_order_id is null");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdIsNotNull() {
            addCriterion("sf_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdEqualTo(String value) {
            addCriterion("sf_order_id =", value, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdNotEqualTo(String value) {
            addCriterion("sf_order_id <>", value, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdGreaterThan(String value) {
            addCriterion("sf_order_id >", value, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("sf_order_id >=", value, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdLessThan(String value) {
            addCriterion("sf_order_id <", value, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdLessThanOrEqualTo(String value) {
            addCriterion("sf_order_id <=", value, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdLike(String value) {
            addCriterion("sf_order_id like", value, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdNotLike(String value) {
            addCriterion("sf_order_id not like", value, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdIn(List<String> values) {
            addCriterion("sf_order_id in", values, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdNotIn(List<String> values) {
            addCriterion("sf_order_id not in", values, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdBetween(String value1, String value2) {
            addCriterion("sf_order_id between", value1, value2, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andSfOrderIdNotBetween(String value1, String value2) {
            addCriterion("sf_order_id not between", value1, value2, "sfOrderId");
            return (Criteria) this;
        }

        public Criteria andShipDistanceIsNull() {
            addCriterion("ship_distance is null");
            return (Criteria) this;
        }

        public Criteria andShipDistanceIsNotNull() {
            addCriterion("ship_distance is not null");
            return (Criteria) this;
        }

        public Criteria andShipDistanceEqualTo(Integer value) {
            addCriterion("ship_distance =", value, "shipDistance");
            return (Criteria) this;
        }

        public Criteria andShipDistanceNotEqualTo(Integer value) {
            addCriterion("ship_distance <>", value, "shipDistance");
            return (Criteria) this;
        }

        public Criteria andShipDistanceGreaterThan(Integer value) {
            addCriterion("ship_distance >", value, "shipDistance");
            return (Criteria) this;
        }

        public Criteria andShipDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_distance >=", value, "shipDistance");
            return (Criteria) this;
        }

        public Criteria andShipDistanceLessThan(Integer value) {
            addCriterion("ship_distance <", value, "shipDistance");
            return (Criteria) this;
        }

        public Criteria andShipDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("ship_distance <=", value, "shipDistance");
            return (Criteria) this;
        }

        public Criteria andShipDistanceIn(List<Integer> values) {
            addCriterion("ship_distance in", values, "shipDistance");
            return (Criteria) this;
        }

        public Criteria andShipDistanceNotIn(List<Integer> values) {
            addCriterion("ship_distance not in", values, "shipDistance");
            return (Criteria) this;
        }

        public Criteria andShipDistanceBetween(Integer value1, Integer value2) {
            addCriterion("ship_distance between", value1, value2, "shipDistance");
            return (Criteria) this;
        }

        public Criteria andShipDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("ship_distance not between", value1, value2, "shipDistance");
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

        public Criteria andSysAmountIsNull() {
            addCriterion("sys_amount is null");
            return (Criteria) this;
        }

        public Criteria andSysAmountIsNotNull() {
            addCriterion("sys_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSysAmountEqualTo(BigDecimal value) {
            addCriterion("sys_amount =", value, "sysAmount");
            return (Criteria) this;
        }

        public Criteria andSysAmountNotEqualTo(BigDecimal value) {
            addCriterion("sys_amount <>", value, "sysAmount");
            return (Criteria) this;
        }

        public Criteria andSysAmountGreaterThan(BigDecimal value) {
            addCriterion("sys_amount >", value, "sysAmount");
            return (Criteria) this;
        }

        public Criteria andSysAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sys_amount >=", value, "sysAmount");
            return (Criteria) this;
        }

        public Criteria andSysAmountLessThan(BigDecimal value) {
            addCriterion("sys_amount <", value, "sysAmount");
            return (Criteria) this;
        }

        public Criteria andSysAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sys_amount <=", value, "sysAmount");
            return (Criteria) this;
        }

        public Criteria andSysAmountIn(List<BigDecimal> values) {
            addCriterion("sys_amount in", values, "sysAmount");
            return (Criteria) this;
        }

        public Criteria andSysAmountNotIn(List<BigDecimal> values) {
            addCriterion("sys_amount not in", values, "sysAmount");
            return (Criteria) this;
        }

        public Criteria andSysAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sys_amount between", value1, value2, "sysAmount");
            return (Criteria) this;
        }

        public Criteria andSysAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sys_amount not between", value1, value2, "sysAmount");
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