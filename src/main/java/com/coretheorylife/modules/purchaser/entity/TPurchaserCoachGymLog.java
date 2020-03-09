package com.coretheorylife.modules.purchaser.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TPurchaserCoachGymLog extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 教练id（也是普通用户）
     */
    private Long coachId;

    /**
     * 旧的教练id（也是普通用户）
     */
    private Long oldCoachId;

    /**
     * 健身房id
     */
    private Long gymId;

    /**
     * 旧的健身房id
     */
    private Long oldGymId;

    /**
     * 变化类型 1-增长 2-减少 3-教练变化（和健身房用户数无关）
     */
    private Integer type;

    /**
     * 用于计算的类型 0-默认没有什么用 1-是增长（今天该用户之前的要改成0） 2-减少（今天该用户之前的要改为0）
     */
    private Integer queryType;

    /**
     * 创建时间用于提高查询效率，保存为yyyy-MM-dd
     */
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Long getOldCoachId() {
        return oldCoachId;
    }

    public void setOldCoachId(Long oldCoachId) {
        this.oldCoachId = oldCoachId;
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public Long getOldGymId() {
        return oldGymId;
    }

    public void setOldGymId(Long oldGymId) {
        this.oldGymId = oldGymId;
    }

    public Integer getTypeDefaultValue() {
        return type == null ? 1 : type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getQueryTypeDefaultValue() {
        return queryType == null ? 0 : queryType;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}