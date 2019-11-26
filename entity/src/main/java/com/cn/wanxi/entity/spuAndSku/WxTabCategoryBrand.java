package com.cn.wanxi.entity.spuAndSku;

public class WxTabCategoryBrand {
    private Integer categoryId;
    private Integer brandId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "WxTabCategoryBrand{" +
                "Category_Id=" + categoryId +
                ", brandId=" + brandId +
                '}';
    }
}
