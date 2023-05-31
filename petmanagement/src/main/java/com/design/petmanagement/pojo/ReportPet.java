package com.design.petmanagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (ReportPet)实体类
 *
 * @author makejava
 * @since 2022-11-02 09:32:55
 */
public class ReportPet implements Serializable {
    private static final long serialVersionUID = 877481038282225273L;
    
    private Integer id;
    private Integer count;
    /**
     * 宠物名字
     */
    private String petName;
    /**
     * 品种
     */
    private Integer varietyId;
    private String varietyName;

    /**
     * 挂失人姓名
     */
    private String reporter;
    /**
     * 手机号码
     */
    private String telephone;
    /**
     * 住址
     */
    private String address;
    /**
     * 宠物描述
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
     * 录入时间
     */
    private Date createdAt;
    /**
     * 录入人
     */
    private String createdBy;
    /**
     * 是否找回 1 为是 0为否
     */
    private Integer getBack;
    /**
     * 性别
     */
    private String sex;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(Integer varietyId) {
        this.varietyId = varietyId;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getGetBack() {
        return getBack;
    }

    public void setGetBack(Integer getBack) {
        this.getBack = getBack;
    }

}
