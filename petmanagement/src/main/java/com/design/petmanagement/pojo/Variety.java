package com.design.petmanagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Variety)实体类
 *
 * @author makejava
 * @since 2022-11-01 14:26:31
 */
public class Variety implements Serializable {
    private static final long serialVersionUID = 144213028344672998L;
    
    private Integer id;
    private Integer count;
    /**
     * 品种名字
     */
    private String name;
    /**
     * 描述
     */
    private String descb;
    /**
     * 照片 存个路劲
     */
    private String image;
    /**
     * 照片 前端显示
     */
    private String imageUrl;
    /**
     * 物种 猫狗鸡鸭等
     */
    private Integer typeId;
    /**
     * 录入时间
     */
    private Date createdAt;
    /**
     * 录入人
     */
    private String createdBy;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
