package com.coretheorylife.common.sf.entity;

/**
 * @author Connor
 * 预订单创建返回的实体类
 */
public class CreateOrderQueryResult {

    /**
     * error_code : 0
     * error_msg :
     * error_data :
     * result : {"delivery_type":1,"expect_time":1546845547,"start_time":1546841347,"promise_delivery_time":70,"delivery_distance_meter":"6145","charge_price_list":{"shop_pay_price":1200,"charges_detail":{"basic_fee":1100,"basic":900,"over_distance":100,"over_weight":0,"cancel_excess_fee":0,"special_time_fee":0,"vas_fee":0,"vas_fee_detail":{"packing_fee":0,"low_temp_fee":0,"take_goods_sms_fee":0,"insured":{"fee":0,"declared_price":0},"big_order":{"fee":0,"amount":0},"collection":{"fee":0,"price":0}},"extra_fee":0,"extra_fee_detail":{"geography_fee":0}}},"gratuity_fee":100,"push_time":1546841347,"total_price":1300,"weight_gram":1000,"total_pay_money":1300,"real_pay_money":1300,"coupons_total_fee":1300,"settlement_type":1}
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
         * delivery_type : 1
         * expect_time : 1546845547
         * start_time : 1546841347
         * promise_delivery_time : 70
         * delivery_distance_meter : 6145
         * charge_price_list : {"shop_pay_price":1200,"charges_detail":{"basic_fee":1100,"basic":900,"over_distance":100,"over_weight":0,"cancel_excess_fee":0,"special_time_fee":0,"vas_fee":0,"vas_fee_detail":{"packing_fee":0,"low_temp_fee":0,"take_goods_sms_fee":0,"insured":{"fee":0,"declared_price":0},"big_order":{"fee":0,"amount":0},"collection":{"fee":0,"price":0}},"extra_fee":0,"extra_fee_detail":{"geography_fee":0}}}
         * gratuity_fee : 100
         * push_time : 1546841347
         * total_price : 1300
         * weight_gram : 1000
         * total_pay_money : 1300
         * real_pay_money : 1300
         * coupons_total_fee : 1300
         * settlement_type : 1
         */

        private int delivery_type;
        private int expect_time;
        private int start_time;
        private int promise_delivery_time;
        private String delivery_distance_meter;
        private ChargePriceListBean charge_price_list;
        private int gratuity_fee;
        private int push_time;
        private int total_price;
        private int weight_gram;
        private int total_pay_money;
        private int real_pay_money;
        private int coupons_total_fee;
        private int settlement_type;

        public int getDelivery_type() {
            return delivery_type;
        }

        public void setDelivery_type(int delivery_type) {
            this.delivery_type = delivery_type;
        }

        public int getExpect_time() {
            return expect_time;
        }

        public void setExpect_time(int expect_time) {
            this.expect_time = expect_time;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getPromise_delivery_time() {
            return promise_delivery_time;
        }

        public void setPromise_delivery_time(int promise_delivery_time) {
            this.promise_delivery_time = promise_delivery_time;
        }

        public String getDelivery_distance_meter() {
            return delivery_distance_meter;
        }

        public void setDelivery_distance_meter(String delivery_distance_meter) {
            this.delivery_distance_meter = delivery_distance_meter;
        }

        public ChargePriceListBean getCharge_price_list() {
            return charge_price_list;
        }

        public void setCharge_price_list(ChargePriceListBean charge_price_list) {
            this.charge_price_list = charge_price_list;
        }

        public int getGratuity_fee() {
            return gratuity_fee;
        }

        public void setGratuity_fee(int gratuity_fee) {
            this.gratuity_fee = gratuity_fee;
        }

        public int getPush_time() {
            return push_time;
        }

        public void setPush_time(int push_time) {
            this.push_time = push_time;
        }

        public int getTotal_price() {
            return total_price;
        }

        public void setTotal_price(int total_price) {
            this.total_price = total_price;
        }

        public int getWeight_gram() {
            return weight_gram;
        }

        public void setWeight_gram(int weight_gram) {
            this.weight_gram = weight_gram;
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

        public static class ChargePriceListBean {
            /**
             * shop_pay_price : 1200
             * charges_detail : {"basic_fee":1100,"basic":900,"over_distance":100,"over_weight":0,"cancel_excess_fee":0,"special_time_fee":0,"vas_fee":0,"vas_fee_detail":{"packing_fee":0,"low_temp_fee":0,"take_goods_sms_fee":0,"insured":{"fee":0,"declared_price":0},"big_order":{"fee":0,"amount":0},"collection":{"fee":0,"price":0}},"extra_fee":0,"extra_fee_detail":{"geography_fee":0}}
             */

            private int shop_pay_price;
            private ChargesDetailBean charges_detail;

            public int getShop_pay_price() {
                return shop_pay_price;
            }

            public void setShop_pay_price(int shop_pay_price) {
                this.shop_pay_price = shop_pay_price;
            }

            public ChargesDetailBean getCharges_detail() {
                return charges_detail;
            }

            public void setCharges_detail(ChargesDetailBean charges_detail) {
                this.charges_detail = charges_detail;
            }

            public static class ChargesDetailBean {
                /**
                 * basic_fee : 1100
                 * basic : 900
                 * over_distance : 100
                 * over_weight : 0
                 * cancel_excess_fee : 0
                 * special_time_fee : 0
                 * vas_fee : 0
                 * vas_fee_detail : {"packing_fee":0,"low_temp_fee":0,"take_goods_sms_fee":0,"insured":{"fee":0,"declared_price":0},"big_order":{"fee":0,"amount":0},"collection":{"fee":0,"price":0}}
                 * extra_fee : 0
                 * extra_fee_detail : {"geography_fee":0}
                 */

                private int basic_fee;
                private int basic;
                private int over_distance;
                private int over_weight;
                private int cancel_excess_fee;
                private int special_time_fee;
                private int vas_fee;
                private VasFeeDetailBean vas_fee_detail;
                private int extra_fee;
                private ExtraFeeDetailBean extra_fee_detail;

                public int getBasic_fee() {
                    return basic_fee;
                }

                public void setBasic_fee(int basic_fee) {
                    this.basic_fee = basic_fee;
                }

                public int getBasic() {
                    return basic;
                }

                public void setBasic(int basic) {
                    this.basic = basic;
                }

                public int getOver_distance() {
                    return over_distance;
                }

                public void setOver_distance(int over_distance) {
                    this.over_distance = over_distance;
                }

                public int getOver_weight() {
                    return over_weight;
                }

                public void setOver_weight(int over_weight) {
                    this.over_weight = over_weight;
                }

                public int getCancel_excess_fee() {
                    return cancel_excess_fee;
                }

                public void setCancel_excess_fee(int cancel_excess_fee) {
                    this.cancel_excess_fee = cancel_excess_fee;
                }

                public int getSpecial_time_fee() {
                    return special_time_fee;
                }

                public void setSpecial_time_fee(int special_time_fee) {
                    this.special_time_fee = special_time_fee;
                }

                public int getVas_fee() {
                    return vas_fee;
                }

                public void setVas_fee(int vas_fee) {
                    this.vas_fee = vas_fee;
                }

                public VasFeeDetailBean getVas_fee_detail() {
                    return vas_fee_detail;
                }

                public void setVas_fee_detail(VasFeeDetailBean vas_fee_detail) {
                    this.vas_fee_detail = vas_fee_detail;
                }

                public int getExtra_fee() {
                    return extra_fee;
                }

                public void setExtra_fee(int extra_fee) {
                    this.extra_fee = extra_fee;
                }

                public ExtraFeeDetailBean getExtra_fee_detail() {
                    return extra_fee_detail;
                }

                public void setExtra_fee_detail(ExtraFeeDetailBean extra_fee_detail) {
                    this.extra_fee_detail = extra_fee_detail;
                }

                public static class VasFeeDetailBean {
                    /**
                     * packing_fee : 0
                     * low_temp_fee : 0
                     * take_goods_sms_fee : 0
                     * insured : {"fee":0,"declared_price":0}
                     * big_order : {"fee":0,"amount":0}
                     * collection : {"fee":0,"price":0}
                     */

                    private int packing_fee;
                    private int low_temp_fee;
                    private int take_goods_sms_fee;
                    private InsuredBean insured;
                    private BigOrderBean big_order;
                    private CollectionBean collection;

                    public int getPacking_fee() {
                        return packing_fee;
                    }

                    public void setPacking_fee(int packing_fee) {
                        this.packing_fee = packing_fee;
                    }

                    public int getLow_temp_fee() {
                        return low_temp_fee;
                    }

                    public void setLow_temp_fee(int low_temp_fee) {
                        this.low_temp_fee = low_temp_fee;
                    }

                    public int getTake_goods_sms_fee() {
                        return take_goods_sms_fee;
                    }

                    public void setTake_goods_sms_fee(int take_goods_sms_fee) {
                        this.take_goods_sms_fee = take_goods_sms_fee;
                    }

                    public InsuredBean getInsured() {
                        return insured;
                    }

                    public void setInsured(InsuredBean insured) {
                        this.insured = insured;
                    }

                    public BigOrderBean getBig_order() {
                        return big_order;
                    }

                    public void setBig_order(BigOrderBean big_order) {
                        this.big_order = big_order;
                    }

                    public CollectionBean getCollection() {
                        return collection;
                    }

                    public void setCollection(CollectionBean collection) {
                        this.collection = collection;
                    }

                    public static class InsuredBean {
                        /**
                         * fee : 0
                         * declared_price : 0
                         */

                        private int fee;
                        private int declared_price;

                        public int getFee() {
                            return fee;
                        }

                        public void setFee(int fee) {
                            this.fee = fee;
                        }

                        public int getDeclared_price() {
                            return declared_price;
                        }

                        public void setDeclared_price(int declared_price) {
                            this.declared_price = declared_price;
                        }
                    }

                    public static class BigOrderBean {
                        /**
                         * fee : 0
                         * amount : 0
                         */

                        private int fee;
                        private int amount;

                        public int getFee() {
                            return fee;
                        }

                        public void setFee(int fee) {
                            this.fee = fee;
                        }

                        public int getAmount() {
                            return amount;
                        }

                        public void setAmount(int amount) {
                            this.amount = amount;
                        }
                    }

                    public static class CollectionBean {
                        /**
                         * fee : 0
                         * price : 0
                         */

                        private int fee;
                        private int price;

                        public int getFee() {
                            return fee;
                        }

                        public void setFee(int fee) {
                            this.fee = fee;
                        }

                        public int getPrice() {
                            return price;
                        }

                        public void setPrice(int price) {
                            this.price = price;
                        }
                    }
                }

                public static class ExtraFeeDetailBean {
                    /**
                     * geography_fee : 0
                     */

                    private int geography_fee;

                    public int getGeography_fee() {
                        return geography_fee;
                    }

                    public void setGeography_fee(int geography_fee) {
                        this.geography_fee = geography_fee;
                    }
                }
            }
        }
    }
}
