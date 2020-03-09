package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.example.BaseExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOrderExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNull() {
            addCriterion("pay_price is null");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNotNull() {
            addCriterion("pay_price is not null");
            return (Criteria) this;
        }

        public Criteria andPayPriceEqualTo(BigDecimal value) {
            addCriterion("pay_price =", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotEqualTo(BigDecimal value) {
            addCriterion("pay_price <>", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThan(BigDecimal value) {
            addCriterion("pay_price >", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_price >=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThan(BigDecimal value) {
            addCriterion("pay_price <", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_price <=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceIn(List<BigDecimal> values) {
            addCriterion("pay_price in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotIn(List<BigDecimal> values) {
            addCriterion("pay_price not in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_price between", value1, value2, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_price not between", value1, value2, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPackageFeeIsNull() {
            addCriterion("package_fee is null");
            return (Criteria) this;
        }

        public Criteria andPackageFeeIsNotNull() {
            addCriterion("package_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPackageFeeEqualTo(BigDecimal value) {
            addCriterion("package_fee =", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeNotEqualTo(BigDecimal value) {
            addCriterion("package_fee <>", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeGreaterThan(BigDecimal value) {
            addCriterion("package_fee >", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("package_fee >=", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeLessThan(BigDecimal value) {
            addCriterion("package_fee <", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("package_fee <=", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeIn(List<BigDecimal> values) {
            addCriterion("package_fee in", values, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeNotIn(List<BigDecimal> values) {
            addCriterion("package_fee not in", values, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_fee between", value1, value2, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_fee not between", value1, value2, "packageFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeIsNull() {
            addCriterion("ship_fee is null");
            return (Criteria) this;
        }

        public Criteria andShipFeeIsNotNull() {
            addCriterion("ship_fee is not null");
            return (Criteria) this;
        }

        public Criteria andShipFeeEqualTo(BigDecimal value) {
            addCriterion("ship_fee =", value, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeNotEqualTo(BigDecimal value) {
            addCriterion("ship_fee <>", value, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeGreaterThan(BigDecimal value) {
            addCriterion("ship_fee >", value, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_fee >=", value, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeLessThan(BigDecimal value) {
            addCriterion("ship_fee <", value, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_fee <=", value, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeIn(List<BigDecimal> values) {
            addCriterion("ship_fee in", values, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeNotIn(List<BigDecimal> values) {
            addCriterion("ship_fee not in", values, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_fee between", value1, value2, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_fee not between", value1, value2, "shipFee");
            return (Criteria) this;
        }

        public Criteria andShipPlatformIsNull() {
            addCriterion("ship_platform is null");
            return (Criteria) this;
        }

        public Criteria andShipPlatformIsNotNull() {
            addCriterion("ship_platform is not null");
            return (Criteria) this;
        }

        public Criteria andShipPlatformEqualTo(Integer value) {
            addCriterion("ship_platform =", value, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipPlatformNotEqualTo(Integer value) {
            addCriterion("ship_platform <>", value, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipPlatformGreaterThan(Integer value) {
            addCriterion("ship_platform >", value, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_platform >=", value, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipPlatformLessThan(Integer value) {
            addCriterion("ship_platform <", value, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("ship_platform <=", value, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipPlatformIn(List<Integer> values) {
            addCriterion("ship_platform in", values, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipPlatformNotIn(List<Integer> values) {
            addCriterion("ship_platform not in", values, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipPlatformBetween(Integer value1, Integer value2) {
            addCriterion("ship_platform between", value1, value2, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("ship_platform not between", value1, value2, "shipPlatform");
            return (Criteria) this;
        }

        public Criteria andShipTypeIsNull() {
            addCriterion("ship_type is null");
            return (Criteria) this;
        }

        public Criteria andShipTypeIsNotNull() {
            addCriterion("ship_type is not null");
            return (Criteria) this;
        }

        public Criteria andShipTypeEqualTo(Integer value) {
            addCriterion("ship_type =", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeNotEqualTo(Integer value) {
            addCriterion("ship_type <>", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeGreaterThan(Integer value) {
            addCriterion("ship_type >", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_type >=", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeLessThan(Integer value) {
            addCriterion("ship_type <", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ship_type <=", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeIn(List<Integer> values) {
            addCriterion("ship_type in", values, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeNotIn(List<Integer> values) {
            addCriterion("ship_type not in", values, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeBetween(Integer value1, Integer value2) {
            addCriterion("ship_type between", value1, value2, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ship_type not between", value1, value2, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipPersonIsNull() {
            addCriterion("ship_person is null");
            return (Criteria) this;
        }

        public Criteria andShipPersonIsNotNull() {
            addCriterion("ship_person is not null");
            return (Criteria) this;
        }

        public Criteria andShipPersonEqualTo(String value) {
            addCriterion("ship_person =", value, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonNotEqualTo(String value) {
            addCriterion("ship_person <>", value, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonGreaterThan(String value) {
            addCriterion("ship_person >", value, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonGreaterThanOrEqualTo(String value) {
            addCriterion("ship_person >=", value, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonLessThan(String value) {
            addCriterion("ship_person <", value, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonLessThanOrEqualTo(String value) {
            addCriterion("ship_person <=", value, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonLike(String value) {
            addCriterion("ship_person like", value, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonNotLike(String value) {
            addCriterion("ship_person not like", value, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonIn(List<String> values) {
            addCriterion("ship_person in", values, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonNotIn(List<String> values) {
            addCriterion("ship_person not in", values, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonBetween(String value1, String value2) {
            addCriterion("ship_person between", value1, value2, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipPersonNotBetween(String value1, String value2) {
            addCriterion("ship_person not between", value1, value2, "shipPerson");
            return (Criteria) this;
        }

        public Criteria andShipNumberIsNull() {
            addCriterion("ship_number is null");
            return (Criteria) this;
        }

        public Criteria andShipNumberIsNotNull() {
            addCriterion("ship_number is not null");
            return (Criteria) this;
        }

        public Criteria andShipNumberEqualTo(String value) {
            addCriterion("ship_number =", value, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberNotEqualTo(String value) {
            addCriterion("ship_number <>", value, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberGreaterThan(String value) {
            addCriterion("ship_number >", value, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ship_number >=", value, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberLessThan(String value) {
            addCriterion("ship_number <", value, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberLessThanOrEqualTo(String value) {
            addCriterion("ship_number <=", value, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberLike(String value) {
            addCriterion("ship_number like", value, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberNotLike(String value) {
            addCriterion("ship_number not like", value, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberIn(List<String> values) {
            addCriterion("ship_number in", values, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberNotIn(List<String> values) {
            addCriterion("ship_number not in", values, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberBetween(String value1, String value2) {
            addCriterion("ship_number between", value1, value2, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipNumberNotBetween(String value1, String value2) {
            addCriterion("ship_number not between", value1, value2, "shipNumber");
            return (Criteria) this;
        }

        public Criteria andShipPrefixIsNull() {
            addCriterion("ship_prefix is null");
            return (Criteria) this;
        }

        public Criteria andShipPrefixIsNotNull() {
            addCriterion("ship_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andShipPrefixEqualTo(String value) {
            addCriterion("ship_prefix =", value, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixNotEqualTo(String value) {
            addCriterion("ship_prefix <>", value, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixGreaterThan(String value) {
            addCriterion("ship_prefix >", value, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("ship_prefix >=", value, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixLessThan(String value) {
            addCriterion("ship_prefix <", value, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixLessThanOrEqualTo(String value) {
            addCriterion("ship_prefix <=", value, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixLike(String value) {
            addCriterion("ship_prefix like", value, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixNotLike(String value) {
            addCriterion("ship_prefix not like", value, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixIn(List<String> values) {
            addCriterion("ship_prefix in", values, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixNotIn(List<String> values) {
            addCriterion("ship_prefix not in", values, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixBetween(String value1, String value2) {
            addCriterion("ship_prefix between", value1, value2, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipPrefixNotBetween(String value1, String value2) {
            addCriterion("ship_prefix not between", value1, value2, "shipPrefix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixIsNull() {
            addCriterion("ship_suffix is null");
            return (Criteria) this;
        }

        public Criteria andShipSuffixIsNotNull() {
            addCriterion("ship_suffix is not null");
            return (Criteria) this;
        }

        public Criteria andShipSuffixEqualTo(String value) {
            addCriterion("ship_suffix =", value, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixNotEqualTo(String value) {
            addCriterion("ship_suffix <>", value, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixGreaterThan(String value) {
            addCriterion("ship_suffix >", value, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixGreaterThanOrEqualTo(String value) {
            addCriterion("ship_suffix >=", value, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixLessThan(String value) {
            addCriterion("ship_suffix <", value, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixLessThanOrEqualTo(String value) {
            addCriterion("ship_suffix <=", value, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixLike(String value) {
            addCriterion("ship_suffix like", value, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixNotLike(String value) {
            addCriterion("ship_suffix not like", value, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixIn(List<String> values) {
            addCriterion("ship_suffix in", values, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixNotIn(List<String> values) {
            addCriterion("ship_suffix not in", values, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixBetween(String value1, String value2) {
            addCriterion("ship_suffix between", value1, value2, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipSuffixNotBetween(String value1, String value2) {
            addCriterion("ship_suffix not between", value1, value2, "shipSuffix");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeIsNull() {
            addCriterion("ship_longitude is null");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeIsNotNull() {
            addCriterion("ship_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeEqualTo(BigDecimal value) {
            addCriterion("ship_longitude =", value, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("ship_longitude <>", value, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeGreaterThan(BigDecimal value) {
            addCriterion("ship_longitude >", value, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_longitude >=", value, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeLessThan(BigDecimal value) {
            addCriterion("ship_longitude <", value, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_longitude <=", value, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeIn(List<BigDecimal> values) {
            addCriterion("ship_longitude in", values, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("ship_longitude not in", values, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_longitude between", value1, value2, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_longitude not between", value1, value2, "shipLongitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeIsNull() {
            addCriterion("ship_latitude is null");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeIsNotNull() {
            addCriterion("ship_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeEqualTo(BigDecimal value) {
            addCriterion("ship_latitude =", value, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("ship_latitude <>", value, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeGreaterThan(BigDecimal value) {
            addCriterion("ship_latitude >", value, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_latitude >=", value, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeLessThan(BigDecimal value) {
            addCriterion("ship_latitude <", value, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_latitude <=", value, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeIn(List<BigDecimal> values) {
            addCriterion("ship_latitude in", values, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("ship_latitude not in", values, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_latitude between", value1, value2, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andShipLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_latitude not between", value1, value2, "shipLatitude");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNull() {
            addCriterion("receiver_mobile is null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNotNull() {
            addCriterion("receiver_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileEqualTo(String value) {
            addCriterion("receiver_mobile =", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotEqualTo(String value) {
            addCriterion("receiver_mobile <>", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThan(String value) {
            addCriterion("receiver_mobile >", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_mobile >=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThan(String value) {
            addCriterion("receiver_mobile <", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            addCriterion("receiver_mobile <=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLike(String value) {
            addCriterion("receiver_mobile like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotLike(String value) {
            addCriterion("receiver_mobile not like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIn(List<String> values) {
            addCriterion("receiver_mobile in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotIn(List<String> values) {
            addCriterion("receiver_mobile not in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileBetween(String value1, String value2) {
            addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotBetween(String value1, String value2) {
            addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andEatNumberIsNull() {
            addCriterion("eat_number is null");
            return (Criteria) this;
        }

        public Criteria andEatNumberIsNotNull() {
            addCriterion("eat_number is not null");
            return (Criteria) this;
        }

        public Criteria andEatNumberEqualTo(Integer value) {
            addCriterion("eat_number =", value, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andEatNumberNotEqualTo(Integer value) {
            addCriterion("eat_number <>", value, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andEatNumberGreaterThan(Integer value) {
            addCriterion("eat_number >", value, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andEatNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("eat_number >=", value, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andEatNumberLessThan(Integer value) {
            addCriterion("eat_number <", value, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andEatNumberLessThanOrEqualTo(Integer value) {
            addCriterion("eat_number <=", value, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andEatNumberIn(List<Integer> values) {
            addCriterion("eat_number in", values, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andEatNumberNotIn(List<Integer> values) {
            addCriterion("eat_number not in", values, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andEatNumberBetween(Integer value1, Integer value2) {
            addCriterion("eat_number between", value1, value2, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andEatNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("eat_number not between", value1, value2, "eatNumber");
            return (Criteria) this;
        }

        public Criteria andShipTimeIsNull() {
            addCriterion("ship_time is null");
            return (Criteria) this;
        }

        public Criteria andShipTimeIsNotNull() {
            addCriterion("ship_time is not null");
            return (Criteria) this;
        }

        public Criteria andShipTimeEqualTo(Date value) {
            addCriterion("ship_time =", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotEqualTo(Date value) {
            addCriterion("ship_time <>", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeGreaterThan(Date value) {
            addCriterion("ship_time >", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ship_time >=", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeLessThan(Date value) {
            addCriterion("ship_time <", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeLessThanOrEqualTo(Date value) {
            addCriterion("ship_time <=", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeIn(List<Date> values) {
            addCriterion("ship_time in", values, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotIn(List<Date> values) {
            addCriterion("ship_time not in", values, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeBetween(Date value1, Date value2) {
            addCriterion("ship_time between", value1, value2, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotBetween(Date value1, Date value2) {
            addCriterion("ship_time not between", value1, value2, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipStatusIsNull() {
            addCriterion("ship_status is null");
            return (Criteria) this;
        }

        public Criteria andShipStatusIsNotNull() {
            addCriterion("ship_status is not null");
            return (Criteria) this;
        }

        public Criteria andShipStatusEqualTo(Integer value) {
            addCriterion("ship_status =", value, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andShipStatusNotEqualTo(Integer value) {
            addCriterion("ship_status <>", value, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andShipStatusGreaterThan(Integer value) {
            addCriterion("ship_status >", value, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andShipStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_status >=", value, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andShipStatusLessThan(Integer value) {
            addCriterion("ship_status <", value, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andShipStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ship_status <=", value, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andShipStatusIn(List<Integer> values) {
            addCriterion("ship_status in", values, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andShipStatusNotIn(List<Integer> values) {
            addCriterion("ship_status not in", values, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andShipStatusBetween(Integer value1, Integer value2) {
            addCriterion("ship_status between", value1, value2, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andShipStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ship_status not between", value1, value2, "shipStatus");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagIsNull() {
            addCriterion("urge_flag is null");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagIsNotNull() {
            addCriterion("urge_flag is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagEqualTo(Boolean value) {
            addCriterion("urge_flag =", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagNotEqualTo(Boolean value) {
            addCriterion("urge_flag <>", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagGreaterThan(Boolean value) {
            addCriterion("urge_flag >", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("urge_flag >=", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagLessThan(Boolean value) {
            addCriterion("urge_flag <", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("urge_flag <=", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagIn(List<Boolean> values) {
            addCriterion("urge_flag in", values, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagNotIn(List<Boolean> values) {
            addCriterion("urge_flag not in", values, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("urge_flag between", value1, value2, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("urge_flag not between", value1, value2, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeIsNull() {
            addCriterion("urge_time is null");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeIsNotNull() {
            addCriterion("urge_time is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeEqualTo(Date value) {
            addCriterion("urge_time =", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeNotEqualTo(Date value) {
            addCriterion("urge_time <>", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeGreaterThan(Date value) {
            addCriterion("urge_time >", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("urge_time >=", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeLessThan(Date value) {
            addCriterion("urge_time <", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeLessThanOrEqualTo(Date value) {
            addCriterion("urge_time <=", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeIn(List<Date> values) {
            addCriterion("urge_time in", values, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeNotIn(List<Date> values) {
            addCriterion("urge_time not in", values, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeBetween(Date value1, Date value2) {
            addCriterion("urge_time between", value1, value2, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeNotBetween(Date value1, Date value2) {
            addCriterion("urge_time not between", value1, value2, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeIsNull() {
            addCriterion("expected_ship_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeIsNotNull() {
            addCriterion("expected_ship_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeEqualTo(Date value) {
            addCriterion("expected_ship_time =", value, "expectedShipTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeNotEqualTo(Date value) {
            addCriterion("expected_ship_time <>", value, "expectedShipTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeGreaterThan(Date value) {
            addCriterion("expected_ship_time >", value, "expectedShipTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expected_ship_time >=", value, "expectedShipTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeLessThan(Date value) {
            addCriterion("expected_ship_time <", value, "expectedShipTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeLessThanOrEqualTo(Date value) {
            addCriterion("expected_ship_time <=", value, "expectedShipTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeIn(List<Date> values) {
            addCriterion("expected_ship_time in", values, "expectedShipTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeNotIn(List<Date> values) {
            addCriterion("expected_ship_time not in", values, "expectedShipTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeBetween(Date value1, Date value2) {
            addCriterion("expected_ship_time between", value1, value2, "expectedShipTime");
            return (Criteria) this;
        }

        public Criteria andExpectedShipTimeNotBetween(Date value1, Date value2) {
            addCriterion("expected_ship_time not between", value1, value2, "expectedShipTime");
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

        public Criteria andDiscountFeeIsNull() {
            addCriterion("discount_fee is null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIsNotNull() {
            addCriterion("discount_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeEqualTo(BigDecimal value) {
            addCriterion("discount_fee =", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotEqualTo(BigDecimal value) {
            addCriterion("discount_fee <>", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThan(BigDecimal value) {
            addCriterion("discount_fee >", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_fee >=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThan(BigDecimal value) {
            addCriterion("discount_fee <", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_fee <=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIn(List<BigDecimal> values) {
            addCriterion("discount_fee in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotIn(List<BigDecimal> values) {
            addCriterion("discount_fee not in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_fee between", value1, value2, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_fee not between", value1, value2, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionIsNull() {
            addCriterion("discount_description is null");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionIsNotNull() {
            addCriterion("discount_description is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionEqualTo(String value) {
            addCriterion("discount_description =", value, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionNotEqualTo(String value) {
            addCriterion("discount_description <>", value, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionGreaterThan(String value) {
            addCriterion("discount_description >", value, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("discount_description >=", value, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionLessThan(String value) {
            addCriterion("discount_description <", value, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionLessThanOrEqualTo(String value) {
            addCriterion("discount_description <=", value, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionLike(String value) {
            addCriterion("discount_description like", value, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionNotLike(String value) {
            addCriterion("discount_description not like", value, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionIn(List<String> values) {
            addCriterion("discount_description in", values, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionNotIn(List<String> values) {
            addCriterion("discount_description not in", values, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionBetween(String value1, String value2) {
            addCriterion("discount_description between", value1, value2, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andDiscountDescriptionNotBetween(String value1, String value2) {
            addCriterion("discount_description not between", value1, value2, "discountDescription");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdIsNull() {
            addCriterion("purchaser_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdIsNotNull() {
            addCriterion("purchaser_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdEqualTo(Long value) {
            addCriterion("purchaser_coupon_id =", value, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdNotEqualTo(Long value) {
            addCriterion("purchaser_coupon_id <>", value, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdGreaterThan(Long value) {
            addCriterion("purchaser_coupon_id >", value, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdGreaterThanOrEqualTo(Long value) {
            addCriterion("purchaser_coupon_id >=", value, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdLessThan(Long value) {
            addCriterion("purchaser_coupon_id <", value, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdLessThanOrEqualTo(Long value) {
            addCriterion("purchaser_coupon_id <=", value, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdIn(List<Long> values) {
            addCriterion("purchaser_coupon_id in", values, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdNotIn(List<Long> values) {
            addCriterion("purchaser_coupon_id not in", values, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdBetween(Long value1, Long value2) {
            addCriterion("purchaser_coupon_id between", value1, value2, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserCouponIdNotBetween(Long value1, Long value2) {
            addCriterion("purchaser_coupon_id not between", value1, value2, "purchaserCouponId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdIsNull() {
            addCriterion("purchaser_envelope_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdIsNotNull() {
            addCriterion("purchaser_envelope_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdEqualTo(Long value) {
            addCriterion("purchaser_envelope_id =", value, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdNotEqualTo(Long value) {
            addCriterion("purchaser_envelope_id <>", value, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdGreaterThan(Long value) {
            addCriterion("purchaser_envelope_id >", value, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("purchaser_envelope_id >=", value, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdLessThan(Long value) {
            addCriterion("purchaser_envelope_id <", value, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdLessThanOrEqualTo(Long value) {
            addCriterion("purchaser_envelope_id <=", value, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdIn(List<Long> values) {
            addCriterion("purchaser_envelope_id in", values, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdNotIn(List<Long> values) {
            addCriterion("purchaser_envelope_id not in", values, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdBetween(Long value1, Long value2) {
            addCriterion("purchaser_envelope_id between", value1, value2, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andPurchaserEnvelopeIdNotBetween(Long value1, Long value2) {
            addCriterion("purchaser_envelope_id not between", value1, value2, "purchaserEnvelopeId");
            return (Criteria) this;
        }

        public Criteria andHasRateIsNull() {
            addCriterion("has_rate is null");
            return (Criteria) this;
        }

        public Criteria andHasRateIsNotNull() {
            addCriterion("has_rate is not null");
            return (Criteria) this;
        }

        public Criteria andHasRateEqualTo(Boolean value) {
            addCriterion("has_rate =", value, "hasRate");
            return (Criteria) this;
        }

        public Criteria andHasRateNotEqualTo(Boolean value) {
            addCriterion("has_rate <>", value, "hasRate");
            return (Criteria) this;
        }

        public Criteria andHasRateGreaterThan(Boolean value) {
            addCriterion("has_rate >", value, "hasRate");
            return (Criteria) this;
        }

        public Criteria andHasRateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_rate >=", value, "hasRate");
            return (Criteria) this;
        }

        public Criteria andHasRateLessThan(Boolean value) {
            addCriterion("has_rate <", value, "hasRate");
            return (Criteria) this;
        }

        public Criteria andHasRateLessThanOrEqualTo(Boolean value) {
            addCriterion("has_rate <=", value, "hasRate");
            return (Criteria) this;
        }

        public Criteria andHasRateIn(List<Boolean> values) {
            addCriterion("has_rate in", values, "hasRate");
            return (Criteria) this;
        }

        public Criteria andHasRateNotIn(List<Boolean> values) {
            addCriterion("has_rate not in", values, "hasRate");
            return (Criteria) this;
        }

        public Criteria andHasRateBetween(Boolean value1, Boolean value2) {
            addCriterion("has_rate between", value1, value2, "hasRate");
            return (Criteria) this;
        }

        public Criteria andHasRateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_rate not between", value1, value2, "hasRate");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNull() {
            addCriterion("order_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNotNull() {
            addCriterion("order_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountEqualTo(Integer value) {
            addCriterion("order_count =", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotEqualTo(Integer value) {
            addCriterion("order_count <>", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThan(Integer value) {
            addCriterion("order_count >", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count >=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThan(Integer value) {
            addCriterion("order_count <", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_count <=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIn(List<Integer> values) {
            addCriterion("order_count in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotIn(List<Integer> values) {
            addCriterion("order_count not in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("order_count between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count not between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutIsNull() {
            addCriterion("pay_timeout is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutIsNotNull() {
            addCriterion("pay_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutEqualTo(Integer value) {
            addCriterion("pay_timeout =", value, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutNotEqualTo(Integer value) {
            addCriterion("pay_timeout <>", value, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutGreaterThan(Integer value) {
            addCriterion("pay_timeout >", value, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_timeout >=", value, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutLessThan(Integer value) {
            addCriterion("pay_timeout <", value, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("pay_timeout <=", value, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutIn(List<Integer> values) {
            addCriterion("pay_timeout in", values, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutNotIn(List<Integer> values) {
            addCriterion("pay_timeout not in", values, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("pay_timeout between", value1, value2, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andPayTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_timeout not between", value1, value2, "payTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutIsNull() {
            addCriterion("receiver_timeout is null");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutIsNotNull() {
            addCriterion("receiver_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutEqualTo(Integer value) {
            addCriterion("receiver_timeout =", value, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutNotEqualTo(Integer value) {
            addCriterion("receiver_timeout <>", value, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutGreaterThan(Integer value) {
            addCriterion("receiver_timeout >", value, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiver_timeout >=", value, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutLessThan(Integer value) {
            addCriterion("receiver_timeout <", value, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("receiver_timeout <=", value, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutIn(List<Integer> values) {
            addCriterion("receiver_timeout in", values, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutNotIn(List<Integer> values) {
            addCriterion("receiver_timeout not in", values, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("receiver_timeout between", value1, value2, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andReceiverTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("receiver_timeout not between", value1, value2, "receiverTimeout");
            return (Criteria) this;
        }

        public Criteria andShipSelfIsNull() {
            addCriterion("ship_self is null");
            return (Criteria) this;
        }

        public Criteria andShipSelfIsNotNull() {
            addCriterion("ship_self is not null");
            return (Criteria) this;
        }

        public Criteria andShipSelfEqualTo(Boolean value) {
            addCriterion("ship_self =", value, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andShipSelfNotEqualTo(Boolean value) {
            addCriterion("ship_self <>", value, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andShipSelfGreaterThan(Boolean value) {
            addCriterion("ship_self >", value, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andShipSelfGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ship_self >=", value, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andShipSelfLessThan(Boolean value) {
            addCriterion("ship_self <", value, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andShipSelfLessThanOrEqualTo(Boolean value) {
            addCriterion("ship_self <=", value, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andShipSelfIn(List<Boolean> values) {
            addCriterion("ship_self in", values, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andShipSelfNotIn(List<Boolean> values) {
            addCriterion("ship_self not in", values, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andShipSelfBetween(Boolean value1, Boolean value2) {
            addCriterion("ship_self between", value1, value2, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andShipSelfNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ship_self not between", value1, value2, "shipSelf");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeIsNull() {
            addCriterion("send_ship_fee is null");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeIsNotNull() {
            addCriterion("send_ship_fee is not null");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeEqualTo(BigDecimal value) {
            addCriterion("send_ship_fee =", value, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeNotEqualTo(BigDecimal value) {
            addCriterion("send_ship_fee <>", value, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeGreaterThan(BigDecimal value) {
            addCriterion("send_ship_fee >", value, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("send_ship_fee >=", value, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeLessThan(BigDecimal value) {
            addCriterion("send_ship_fee <", value, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("send_ship_fee <=", value, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeIn(List<BigDecimal> values) {
            addCriterion("send_ship_fee in", values, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeNotIn(List<BigDecimal> values) {
            addCriterion("send_ship_fee not in", values, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("send_ship_fee between", value1, value2, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andSendShipFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("send_ship_fee not between", value1, value2, "sendShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeIsNull() {
            addCriterion("shop_ship_fee is null");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeIsNotNull() {
            addCriterion("shop_ship_fee is not null");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeEqualTo(BigDecimal value) {
            addCriterion("shop_ship_fee =", value, "shopShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeNotEqualTo(BigDecimal value) {
            addCriterion("shop_ship_fee <>", value, "shopShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeGreaterThan(BigDecimal value) {
            addCriterion("shop_ship_fee >", value, "shopShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shop_ship_fee >=", value, "shopShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeLessThan(BigDecimal value) {
            addCriterion("shop_ship_fee <", value, "shopShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shop_ship_fee <=", value, "shopShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeIn(List<BigDecimal> values) {
            addCriterion("shop_ship_fee in", values, "shopShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeNotIn(List<BigDecimal> values) {
            addCriterion("shop_ship_fee not in", values, "shopShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shop_ship_fee between", value1, value2, "shopShipFee");
            return (Criteria) this;
        }

        public Criteria andShopShipFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shop_ship_fee not between", value1, value2, "shopShipFee");
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

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
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