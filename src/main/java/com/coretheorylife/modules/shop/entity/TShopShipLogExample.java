package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.example.BaseExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TShopShipLogExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TShopShipLogExample() {
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

        public Criteria andShopOrderIdIsNull() {
            addCriterion("shop_order_id is null");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdIsNotNull() {
            addCriterion("shop_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdEqualTo(String value) {
            addCriterion("shop_order_id =", value, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdNotEqualTo(String value) {
            addCriterion("shop_order_id <>", value, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdGreaterThan(String value) {
            addCriterion("shop_order_id >", value, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_order_id >=", value, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdLessThan(String value) {
            addCriterion("shop_order_id <", value, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdLessThanOrEqualTo(String value) {
            addCriterion("shop_order_id <=", value, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdLike(String value) {
            addCriterion("shop_order_id like", value, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdNotLike(String value) {
            addCriterion("shop_order_id not like", value, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdIn(List<String> values) {
            addCriterion("shop_order_id in", values, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdNotIn(List<String> values) {
            addCriterion("shop_order_id not in", values, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdBetween(String value1, String value2) {
            addCriterion("shop_order_id between", value1, value2, "shopOrderId");
            return (Criteria) this;
        }

        public Criteria andShopOrderIdNotBetween(String value1, String value2) {
            addCriterion("shop_order_id not between", value1, value2, "shopOrderId");
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

        public Criteria andSfBillIdIsNull() {
            addCriterion("sf_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andSfBillIdIsNotNull() {
            addCriterion("sf_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andSfBillIdEqualTo(String value) {
            addCriterion("sf_bill_id =", value, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdNotEqualTo(String value) {
            addCriterion("sf_bill_id <>", value, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdGreaterThan(String value) {
            addCriterion("sf_bill_id >", value, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("sf_bill_id >=", value, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdLessThan(String value) {
            addCriterion("sf_bill_id <", value, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdLessThanOrEqualTo(String value) {
            addCriterion("sf_bill_id <=", value, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdLike(String value) {
            addCriterion("sf_bill_id like", value, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdNotLike(String value) {
            addCriterion("sf_bill_id not like", value, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdIn(List<String> values) {
            addCriterion("sf_bill_id in", values, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdNotIn(List<String> values) {
            addCriterion("sf_bill_id not in", values, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdBetween(String value1, String value2) {
            addCriterion("sf_bill_id between", value1, value2, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andSfBillIdNotBetween(String value1, String value2) {
            addCriterion("sf_bill_id not between", value1, value2, "sfBillId");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("push_time is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("push_time is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(String value) {
            addCriterion("push_time =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(String value) {
            addCriterion("push_time <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(String value) {
            addCriterion("push_time >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(String value) {
            addCriterion("push_time >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(String value) {
            addCriterion("push_time <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(String value) {
            addCriterion("push_time <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLike(String value) {
            addCriterion("push_time like", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotLike(String value) {
            addCriterion("push_time not like", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<String> values) {
            addCriterion("push_time in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<String> values) {
            addCriterion("push_time not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(String value1, String value2) {
            addCriterion("push_time between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(String value1, String value2) {
            addCriterion("push_time not between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterIsNull() {
            addCriterion("delivery_distance_meter is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterIsNotNull() {
            addCriterion("delivery_distance_meter is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterEqualTo(BigDecimal value) {
            addCriterion("delivery_distance_meter =", value, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterNotEqualTo(BigDecimal value) {
            addCriterion("delivery_distance_meter <>", value, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterGreaterThan(BigDecimal value) {
            addCriterion("delivery_distance_meter >", value, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("delivery_distance_meter >=", value, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterLessThan(BigDecimal value) {
            addCriterion("delivery_distance_meter <", value, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("delivery_distance_meter <=", value, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterIn(List<BigDecimal> values) {
            addCriterion("delivery_distance_meter in", values, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterNotIn(List<BigDecimal> values) {
            addCriterion("delivery_distance_meter not in", values, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("delivery_distance_meter between", value1, value2, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceMeterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("delivery_distance_meter not between", value1, value2, "deliveryDistanceMeter");
            return (Criteria) this;
        }

        public Criteria andWeightGramIsNull() {
            addCriterion("weight_gram is null");
            return (Criteria) this;
        }

        public Criteria andWeightGramIsNotNull() {
            addCriterion("weight_gram is not null");
            return (Criteria) this;
        }

        public Criteria andWeightGramEqualTo(Integer value) {
            addCriterion("weight_gram =", value, "weightGram");
            return (Criteria) this;
        }

        public Criteria andWeightGramNotEqualTo(Integer value) {
            addCriterion("weight_gram <>", value, "weightGram");
            return (Criteria) this;
        }

        public Criteria andWeightGramGreaterThan(Integer value) {
            addCriterion("weight_gram >", value, "weightGram");
            return (Criteria) this;
        }

        public Criteria andWeightGramGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight_gram >=", value, "weightGram");
            return (Criteria) this;
        }

        public Criteria andWeightGramLessThan(Integer value) {
            addCriterion("weight_gram <", value, "weightGram");
            return (Criteria) this;
        }

        public Criteria andWeightGramLessThanOrEqualTo(Integer value) {
            addCriterion("weight_gram <=", value, "weightGram");
            return (Criteria) this;
        }

        public Criteria andWeightGramIn(List<Integer> values) {
            addCriterion("weight_gram in", values, "weightGram");
            return (Criteria) this;
        }

        public Criteria andWeightGramNotIn(List<Integer> values) {
            addCriterion("weight_gram not in", values, "weightGram");
            return (Criteria) this;
        }

        public Criteria andWeightGramBetween(Integer value1, Integer value2) {
            addCriterion("weight_gram between", value1, value2, "weightGram");
            return (Criteria) this;
        }

        public Criteria andWeightGramNotBetween(Integer value1, Integer value2) {
            addCriterion("weight_gram not between", value1, value2, "weightGram");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Integer value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Integer value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Integer value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Integer value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Integer value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Integer> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Integer> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Integer value1, Integer value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeIsNull() {
            addCriterion("expect_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectTimeIsNotNull() {
            addCriterion("expect_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectTimeEqualTo(Integer value) {
            addCriterion("expect_time =", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotEqualTo(Integer value) {
            addCriterion("expect_time <>", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeGreaterThan(Integer value) {
            addCriterion("expect_time >", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("expect_time >=", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeLessThan(Integer value) {
            addCriterion("expect_time <", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeLessThanOrEqualTo(Integer value) {
            addCriterion("expect_time <=", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeIn(List<Integer> values) {
            addCriterion("expect_time in", values, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotIn(List<Integer> values) {
            addCriterion("expect_time not in", values, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeBetween(Integer value1, Integer value2) {
            addCriterion("expect_time between", value1, value2, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("expect_time not between", value1, value2, "expectTime");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyIsNull() {
            addCriterion("total_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyIsNotNull() {
            addCriterion("total_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyEqualTo(BigDecimal value) {
            addCriterion("total_pay_money =", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_pay_money <>", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_pay_money >", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_pay_money >=", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyLessThan(BigDecimal value) {
            addCriterion("total_pay_money <", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_pay_money <=", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyIn(List<BigDecimal> values) {
            addCriterion("total_pay_money in", values, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_pay_money not in", values, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_pay_money between", value1, value2, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_pay_money not between", value1, value2, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyIsNull() {
            addCriterion("real_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyIsNotNull() {
            addCriterion("real_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyEqualTo(BigDecimal value) {
            addCriterion("real_pay_money =", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("real_pay_money <>", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyGreaterThan(BigDecimal value) {
            addCriterion("real_pay_money >", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_pay_money >=", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyLessThan(BigDecimal value) {
            addCriterion("real_pay_money <", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_pay_money <=", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyIn(List<BigDecimal> values) {
            addCriterion("real_pay_money in", values, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("real_pay_money not in", values, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_pay_money between", value1, value2, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_pay_money not between", value1, value2, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeIsNull() {
            addCriterion("coupons_total_fee is null");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeIsNotNull() {
            addCriterion("coupons_total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeEqualTo(BigDecimal value) {
            addCriterion("coupons_total_fee =", value, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeNotEqualTo(BigDecimal value) {
            addCriterion("coupons_total_fee <>", value, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeGreaterThan(BigDecimal value) {
            addCriterion("coupons_total_fee >", value, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupons_total_fee >=", value, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeLessThan(BigDecimal value) {
            addCriterion("coupons_total_fee <", value, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupons_total_fee <=", value, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeIn(List<BigDecimal> values) {
            addCriterion("coupons_total_fee in", values, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeNotIn(List<BigDecimal> values) {
            addCriterion("coupons_total_fee not in", values, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupons_total_fee between", value1, value2, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andCouponsTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupons_total_fee not between", value1, value2, "couponsTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNull() {
            addCriterion("settlement_type is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNotNull() {
            addCriterion("settlement_type is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeEqualTo(Integer value) {
            addCriterion("settlement_type =", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotEqualTo(Integer value) {
            addCriterion("settlement_type <>", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThan(Integer value) {
            addCriterion("settlement_type >", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("settlement_type >=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThan(Integer value) {
            addCriterion("settlement_type <", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThanOrEqualTo(Integer value) {
            addCriterion("settlement_type <=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIn(List<Integer> values) {
            addCriterion("settlement_type in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotIn(List<Integer> values) {
            addCriterion("settlement_type not in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeBetween(Integer value1, Integer value2) {
            addCriterion("settlement_type between", value1, value2, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("settlement_type not between", value1, value2, "settlementType");
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