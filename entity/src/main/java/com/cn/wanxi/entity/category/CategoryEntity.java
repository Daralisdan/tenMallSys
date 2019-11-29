package com.cn.wanxi.entity.category;

import com.cn.wanxi.entity.Universal;

/**
 * 【商品分类管理】：商品分类，主要用户对商品进行类别管理。一个分类对应一种模板类型的参数
 *
 * 数据表： wx_tab_category （商品分类表）
 *
 * 2019/11/18,Create by yaodan
 */
public class CategoryEntity implements Universal {
    private Integer id;
    private String name;
    private Integer goodsNum;
    private Integer isShow;
    private Integer isMenu;
    private Integer seq;
    private Integer parentId;
    private Integer templateId;

    public CategoryEntity() {
    }

    public CategoryEntity(Integer id, String name, Integer goodsNum, Integer isShow, Integer isMenu, Integer seq, Integer parentId, Integer templateId) {
        this.id = id;
        this.name = name;
        this.goodsNum = goodsNum;
        this.isShow = isShow;
        this.isMenu = isMenu;
        this.seq = seq;
        this.parentId = parentId;
        this.templateId = templateId;
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

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goodsNum=" + goodsNum +
                ", isShow=" + isShow +
                ", isMenu=" + isMenu +
                ", seq=" + seq +
                ", parentId=" + parentId +
                ", templateId=" + templateId +
                '}';
    }
}
