package com.coretheorylife.modules.gym.vo;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-15
 */
public class TGymReservationCVO {

    /**
     * 教练id 可以为空
     */
    private Long coachId;

    /**
     * 健身房id
     */
    @NotNull(message = "健身房不能为空")
    private Long gymId;

    /**
     * 预约开始时间
     */
    @NotNull(message = "开始时间不能为空")
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
    @NotNull(message = "联系方式不能为空")
    private String phone;

    /**
     * 预约人微信号
     */
    private String wechart;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechart() {
        return wechart;
    }

    public void setWechart(String wechart) {
        this.wechart = wechart;
    }
}