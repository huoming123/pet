package com.design.petmanagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Type)实体类
 *
 * @author makejava
 * @since 2022-11-03 09:30:34
 */
public class Type implements Serializable {
    private static final long serialVersionUID = 136720774999128833L;
    
    private Integer id;
    /**
     * 物种名字
     */
    private String name;
    /**
     * 录入时间
     */
    private Date createdAt;
    /**
     * 录入人
     */
    private String createdBy;
    /**
     * 录入人
     */
    private String descb;

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
