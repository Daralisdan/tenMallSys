package com.cn.wanxi.entity.spuAndSku;

public class WxTabCategoryBrand {
    private Integer Category_Id;
    private Integer brandId;

    public Integer getCategory_Id() {
        return Category_Id;
    }

    public void setCategory_Id(Integer category_Id) {
        Category_Id = category_Id;
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
                "Category_Id=" + Category_Id +
                ", brandId=" + brandId +
                '}';
    }
}
