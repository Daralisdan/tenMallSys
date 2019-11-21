package com.cn.wanxi.entity.category;

/**
 * @author LeesonWong
 * @date 2019/11/19 16:47
 */
public class BrandToCategory {
    private int brand_id;
    private int Category_id;

    public BrandToCategory() {
    }

    public BrandToCategory(int brand_id, int category_id) {
        this.brand_id = brand_id;
        Category_id = category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(int category_id) {
        Category_id = category_id;
    }

    @Override
    public String toString() {
        return "BrandToCategory{" +
                "brand_id=" + brand_id +
                ", Category_id=" + Category_id +
                '}';
    }
}
