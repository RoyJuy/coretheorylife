package com.coretheorylife.common.sf.entity;

/**
 * @author Connor
 * 顺丰创建订单返回的实体类
 */
public class CreateOrderResult {

    /**
     * error_code : 0
     * error_msg :
     * error_data : null
     * result : {"sf_order_id":"3165848793513984","sf_bill_id":"509008343346","shop_order_id":"15104092022333","push_time":"1510680568","total_price":1300,"delivery_distance_meter":1234,"weight_gram":1000,"start_time":123456789,"expect_time":123456789,"total_pay_money":1300,"real_pay_money":1300,"coupons_total_fee":1300,"settlement_type":1}
     */

    private int error_code;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sf_order_id : 3165848793513984
         * sf_bill_id : 509008343346
         * shop_order_id : 15104092022333
         * push_time : 1510680568
         * total_price : 1300
         * delivery_distance_meter : 1234
         * weight_gram : 1000
         * start_time : 123456789
         * expect_time : 123456789
         * total_pay_money : 1300
         * real_pay_money : 1300
         * coupons_total_fee : 1300
         * settlement_type : 1
         */

        private String sf_order_id;
        private String sf_bill_id;
        private String shop_order_id;
        private String push_time;
        private int total_price;
        private int delivery_distance_meter;
        private int weight_gram;
        private int start_time;
        private int expect_time;
        private int total_pay_money;
        private int real_pay_money;
        private int coupons_total_fee;
        private int settlement_type;

        public String getSf_order_id() {
            return sf_order_id;
        }

        public void setSf_order_id(String sf_order_id) {
            this.sf_order_id = sf_order_id;
        }

        public String getSf_bill_id() {
            return sf_bill_id;
        }

        public void setSf_bill_id(String sf_bill_id) {
            this.sf_bill_id = sf_bill_id;
        }

        public String getShop_order_id() {
            return shop_order_id;
        }

        public void setShop_order_id(String shop_order_id) {
            this.shop_order_id = shop_order_id;
        }

        public String getPush_time() {
            return push_time;
        }

        public void setPush_time(String push_time) {
            this.push_time = push_time;
        }

        public int getTotal_price() {
            return total_price;
        }

        public void setTotal_price(int total_price) {
            this.total_price = total_price;
        }

        public int getDelivery_distance_meter() {
            return delivery_distance_meter;
        }

        public void setDelivery_distance_meter(int delivery_distance_meter) {
            this.delivery_distance_meter = delivery_distance_meter;
        }

        public int getWeight_gram() {
            return weight_gram;
        }

        public void setWeight_gram(int weight_gram) {
            this.weight_gram = weight_gram;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getExpect_time() {
            return expect_time;
        }

        public void setExpect_time(int expect_time) {
            this.expect_time = expect_time;
        }

        public int getTotal_pay_money() {
            return total_pay_money;
        }

        public void setTotal_pay_money(int total_pay_money) {
            this.total_pay_money = total_pay_money;
        }

        public int getReal_pay_money() {
            return real_pay_money;
        }

        public void setReal_pay_money(int real_pay_money) {
            this.real_pay_money = real_pay_money;
        }

        public int getCoupons_total_fee() {
            return coupons_total_fee;
        }

        public void setCoupons_total_fee(int coupons_total_fee) {
            this.coupons_total_fee = coupons_total_fee;
        }

        public int getSettlement_type() {
            return settlement_type;
        }

        public void setSettlement_type(int settlement_type) {
            this.settlement_type = settlement_type;
        }
    }
}
