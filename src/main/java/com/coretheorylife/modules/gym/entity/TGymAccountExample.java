package com.coretheorylife.modules.gym.entity;

import com.coretheorylife.modules.common.example.BaseExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TGymAccountExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TGymAccountExample() {
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

        public Criteria andGymIdIsNull() {
            addCriterion("gym_id is null");
            return (Criteria) this;
        }

        public Criteria andGymIdIsNotNull() {
            addCriterion("gym_id is not null");
            return (Criteria) this;
        }

        public Criteria andGymIdEqualTo(Long value) {
            addCriterion("gym_id =", value, "gymId");
            return (Criteria) this;
        }

        public Criteria andGymIdNotEqualTo(Long value) {
            addCriterion("gym_id <>", value, "gymId");
            return (Criteria) this;
        }

        public Criteria andGymIdGreaterThan(Long value) {
            addCriterion("gym_id >", value, "gymId");
            return (Criteria) this;
        }

        public Criteria andGymIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gym_id >=", value, "gymId");
            return (Criteria) this;
        }

        public Criteria andGymIdLessThan(Long value) {
            addCriterion("gym_id <", value, "gymId");
            return (Criteria) this;
        }

        public Criteria andGymIdLessThanOrEqualTo(Long value) {
            addCriterion("gym_id <=", value, "gymId");
            return (Criteria) this;
        }

        public Criteria andGymIdIn(List<Long> values) {
            addCriterion("gym_id in", values, "gymId");
            return (Criteria) this;
        }

        public Criteria andGymIdNotIn(List<Long> values) {
            addCriterion("gym_id not in", values, "gymId");
            return (Criteria) this;
        }

        public Criteria andGymIdBetween(Long value1, Long value2) {
            addCriterion("gym_id between", value1, value2, "gymId");
            return (Criteria) this;
        }

        public Criteria andGymIdNotBetween(Long value1, Long value2) {
            addCriterion("gym_id not between", value1, value2, "gymId");
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

        public Criteria andSettleTimeIsNull() {
            addCriterion("settle_time is null");
            return (Criteria) this;
        }

        public Criteria andSettleTimeIsNotNull() {
            addCriterion("settle_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettleTimeEqualTo(String value) {
            addCriterion("settle_time =", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotEqualTo(String value) {
            addCriterion("settle_time <>", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeGreaterThan(String value) {
            addCriterion("settle_time >", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeGreaterThanOrEqualTo(String value) {
            addCriterion("settle_time >=", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeLessThan(String value) {
            addCriterion("settle_time <", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeLessThanOrEqualTo(String value) {
            addCriterion("settle_time <=", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeLike(String value) {
            addCriterion("settle_time like", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotLike(String value) {
            addCriterion("settle_time not like", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeIn(List<String> values) {
            addCriterion("settle_time in", values, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotIn(List<String> values) {
            addCriterion("settle_time not in", values, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeBetween(String value1, String value2) {
            addCriterion("settle_time between", value1, value2, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotBetween(String value1, String value2) {
            addCriterion("settle_time not between", value1, value2, "settleTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeIsNull() {
            addCriterion("withdrawal_time is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeIsNotNull() {
            addCriterion("withdrawal_time is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeEqualTo(String value) {
            addCriterion("withdrawal_time =", value, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeNotEqualTo(String value) {
            addCriterion("withdrawal_time <>", value, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeGreaterThan(String value) {
            addCriterion("withdrawal_time >", value, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeGreaterThanOrEqualTo(String value) {
            addCriterion("withdrawal_time >=", value, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeLessThan(String value) {
            addCriterion("withdrawal_time <", value, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeLessThanOrEqualTo(String value) {
            addCriterion("withdrawal_time <=", value, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeLike(String value) {
            addCriterion("withdrawal_time like", value, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeNotLike(String value) {
            addCriterion("withdrawal_time not like", value, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeIn(List<String> values) {
            addCriterion("withdrawal_time in", values, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeNotIn(List<String> values) {
            addCriterion("withdrawal_time not in", values, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeBetween(String value1, String value2) {
            addCriterion("withdrawal_time between", value1, value2, "withdrawalTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimeNotBetween(String value1, String value2) {
            addCriterion("withdrawal_time not between", value1, value2, "withdrawalTime");
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