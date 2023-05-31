package com.design.petmanagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2022-11-03 12:12:31
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = -71332157520141284L;
    
    private Integer id;
    /**
     * 是否显示
     */
    private Integer showIn;
    /**
     * 公告消息
     */
    private String message;
    /**
     * 录入时间
     */
    private Date createdAt;
    /**
     * 录入人
     */
    private String createdBy;

    public Integer getShowIn() {
        return showIn;
    }

    public void setShowIn(Integer showIn) {
        this.showIn = showIn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
