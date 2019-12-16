package com.cnlxc.zhongan.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private Integer ageLimitStart;

    private Integer ageLimitEnd;

    private Integer versionCount;

    private String mainImage;

    private BigDecimal price;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Product(Integer id, Integer categoryId, String name, String subtitle, Integer ageLimitStart, Integer ageLimitEnd, Integer versionCount, String mainImage, BigDecimal price, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.subtitle = subtitle;
        this.ageLimitStart = ageLimitStart;
        this.ageLimitEnd = ageLimitEnd;
        this.versionCount = versionCount;
        this.mainImage = mainImage;
        this.price = price;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Product() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public Integer getAgeLimitStart() {
        return ageLimitStart;
    }

    public void setAgeLimitStart(Integer ageLimitStart) {
        this.ageLimitStart = ageLimitStart;
    }

    public Integer getAgeLimitEnd() {
        return ageLimitEnd;
    }

    public void setAgeLimitEnd(Integer ageLimitEnd) {
        this.ageLimitEnd = ageLimitEnd;
    }

    public Integer getVersionCount() {
        return versionCount;
    }

    public void setVersionCount(Integer versionCount) {
        this.versionCount = versionCount;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}