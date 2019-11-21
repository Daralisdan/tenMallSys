package com.cn.wanxi.entity.category;

/**
 * 【商品分类管理】：商品分类，主要用户对商品进行类别管理。一个分类对应一种模板类型的参数
 *
 * 数据表： wx_tab_category （商品分类表）
 *
 * 2019/11/18,Create by yaodan
 */
public class CategoryEntity {
    private int id;
    private String name;
    private int goods_num;
    private int is_show;
    private int is_menu;
    private int seq;
    private int parent_id;
    private int template_id;

    public CategoryEntity() {
    }

    public CategoryEntity(int id, String name, int goods_num, int is_show, int is_menu, int seq, int parent_id, int template_id) {
        this.id = id;
        this.name = name;
        this.goods_num = goods_num;
        this.is_show = is_show;
        this.is_menu = is_menu;
        this.seq = seq;
        this.parent_id = parent_id;
        this.template_id = template_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public int getIs_show() {
        return is_show;
    }

    public void setIs_show(int is_show) {
        this.is_show = is_show;
    }

    public int getIs_menu() {
        return is_menu;
    }

    public void setIs_menu(int is_menu) {
        this.is_menu = is_menu;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(int template_id) {
        this.template_id = template_id;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goods_num=" + goods_num +
                ", is_show='" + is_show + '\'' +
                ", is_menu='" + is_menu + '\'' +
                ", seq=" + seq +
                ", parent_id=" + parent_id +
                ", template_id=" + template_id +
                '}';
    }
}
