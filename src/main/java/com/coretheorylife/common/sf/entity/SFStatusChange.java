package com.coretheorylife.common.sf.entity;

/**
 * @author Connor
 * 顺丰订单状态改变的实体类
 */
public class SFStatusChange {


    /**
     * shop_id : 3243279847393
     * sf_order_id : 3304998990325583888
     * shop_order_id : 653620327530143747
     * url_index : rider_status
     * operator_name : 李建波
     * operator_phone : 18615501228
     * rider_lng : 116.33507500000000334
     * rider_lat : 39.943297999999998638
     * order_status : 15
     * status_desc : 配送员已取货
     * push_time : 1575955282
     * sf_ucode : 01371895
     */

    private String shop_id;
    private String sf_order_id;
    private String shop_order_id;
    private String url_index;
    private String operator_name;
    private String operator_phone;
    private String rider_lng;
    private String rider_lat;
    private String order_status;
    private String status_desc;
    private String push_time;
    private String sf_ucode;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getSf_order_id() {
        return sf_order_id;
    }

    public void setSf_order_id(String sf_order_id) {
        this.sf_order_id = sf_order_id;
    }

    public String getShop_order_id() {
        return shop_order_id;
    }

    public void setShop_order_id(String shop_order_id) {
        this.shop_order_id = shop_order_id;
    }

    public String getUrl_index() {
        return url_index;
    }

    public void setUrl_index(String url_index) {
        this.url_index = url_index;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public String getOperator_phone() {
        return operator_phone;
    }

    public void setOperator_phone(String operator_phone) {
        this.operator_phone = operator_phone;
    }

    public String getRider_lng() {
        return rider_lng;
    }

    public void setRider_lng(String rider_lng) {
        this.rider_lng = rider_lng;
    }

    public String getRider_lat() {
        return rider_lat;
    }

    public void setRider_lat(String rider_lat) {
        this.rider_lat = rider_lat;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getStatus_desc() {
        return status_desc;
    }

    public void setStatus_desc(String status_desc) {
        this.status_desc = status_desc;
    }

    public String getPush_time() {
        return push_time;
    }

    public void setPush_time(String push_time) {
        this.push_time = push_time;
    }

    public String getSf_ucode() {
        return sf_ucode;
    }

    public void setSf_ucode(String sf_ucode) {
        this.sf_ucode = sf_ucode;
    }
}
