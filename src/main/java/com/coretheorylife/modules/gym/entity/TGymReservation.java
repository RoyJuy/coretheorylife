package com.coretheorylife.modules.gym.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-15
 */
public class TGymReservation extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 教练id 可以为空
     */
    private Long coachId;

    /**
     * 健身房id
     */
    private Long gymId;

    /**
     * 预约人
     */
    private Long purchaserId;

    /**
     * 预约开始时间
     */
    private Date timeFrom;

    /**
     * 预约结束时间
     */
    private Date timeTo;

    /**
     * 预约人数
     */
    private Integer number;

    /**
     * 预约人联系方式
     */
    private String phone;

    /**
     * 预约人微信号
     */
    private String wechart;

    /**
     * 状态 1-默认 2-已预约 3-已到达 4-已过期 5-用户取消 6-健身房取消
     */
    private Integer status;

    /**
     * 取消预约原因
     */
    private String cancelRemark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public Integer getNumberDefaultValue() {
        return number == null ? 1 : number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPhoneDefaultValue() {
        return phone == null ? "" : phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechartDefaultValue() {
        return wechart == null ? "" : wechart;
    }

    public String getWechart() {
        return wechart;
    }

    public void setWechart(String wechart) {
        this.wechart = wechart == null ? null : wechart.trim();
    }

    public Integer getStatusDefaultValue() {
        return status == null ? 2 : status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCancelRemarkDefaultValue() {
        return cancelRemark == null ? "" : cancelRemark;
    }

    public String getCancelRemark() {
        return cancelRemark;
    }

    public void setCancelRemark(String cancelRemark) {
        this.cancelRemark = cancelRemark == null ? null : cancelRemark.trim();
    }
}