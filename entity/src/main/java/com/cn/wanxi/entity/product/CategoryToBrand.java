package com.cn.wanxi.entity.product;

/**
 * 【商品分类与品牌对应信息管理】
 * 描述：描述商品分类与品牌的对应关系
 *
 * 数据表： wx_tab_category_brand表--商品分类与品牌对应关系
 *
 * @author LessonWong
 * @date 2019/11/19 9:38
 */
public class CategoryToBrand {
    private Integer Category_id;
    private Integer Brand_id;

    public CategoryToBrand() {
    }

    public CategoryToBrand(Integer category_id, Integer brand_id) {
        Category_id = category_id;
        Brand_id = brand_id;
    }

    public Integer getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(Integer category_id) {
        Category_id = category_id;
    }

    public Integer getBrand_id() {
        return Brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        Brand_id = brand_id;
    }

    @Override
    public String toString() {
        return "CategoryToBrand{" +
                "Category_id=" + Category_id +
                ", Brand_id=" + Brand_id +
                '}';
    }
}
