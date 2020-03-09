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
public class TGymReservationUVO {
    /**
     * 主键id
     */
    @NotNull(message = "id不能为空")
    private Long id;

    /**
     * 教练id 可以为空
     */
    private Long coachId;

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