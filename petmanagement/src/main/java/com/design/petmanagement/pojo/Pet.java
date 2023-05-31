package com.design.petmanagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Pet)实体类
 *
 * @author makejava
 * @since 2022-11-01 14:06:30
 */
public class Pet implements Serializable {
    private static final long serialVersionUID = 307054535489086344L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 宠物名字
     */
    private String petName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 宠物品种
     */
    private String name;
    /**
     * 照片 存个路劲
     */
    private String image;
    /**
     * 照片 前端显示
     */
    private String imageUrl;
    /**
     * 宠物出生年月 时间戳
     */
    private Date birthday;
    /**
     * 品种
     */
    private Integer varietyId;
    /**
     * 录入时间
     */
    private Date createdAt;
    /**
     * 录入人
     */
    private String createdBy;
    /**
     * 修改人
     */
    private String updatedBy;
    /**
     * 修改时间
     */
    private Date updatedAt;
    /**
     * 是否领养 1为是 0为否
     */
    private Integer adopt;
    /**
     * 监护人
     */
    private Integer userId;
    /**
     * 疫苗接种 1 为是 0 为否
     */
    private Integer vaccinat;
    /**
     * 接种证明图片
     */
    private String vaccinatImages;
    /**
     * 接种证明图片 前端显示
     */
    private String vaccinatImagesUrl;
    /**
     * 体貌特征
     */
    private String descb;
    /**
     * 购买门店地址
     */
    private String buyShop;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVaccinatImagesUrl() {
        return vaccinatImagesUrl;
    }

    public void setVaccinatImagesUrl(String vaccinatImagesUrl) {
        this.vaccinatImagesUrl = vaccinatImagesUrl;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(Integer varietyId) {
        this.varietyId = varietyId;
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getAdopt() {
        return adopt;
    }

    public void setAdopt(Integer adopt) {
        this.adopt = adopt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVaccinat() {
        return vaccinat;
    }

    public void setVaccinat(Integer vaccinat) {
        this.vaccinat = vaccinat;
    }

    public String getVaccinatImages() {
        return vaccinatImages;
    }

    public void setVaccinatImages(String vaccinatImages) {
        this.vaccinatImages = vaccinatImages;
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb;
    }

    public String getBuyShop() {
        return buyShop;
    }

    public void setBuyShop(String buyShop) {
        this.buyShop = buyShop;
    }

}
