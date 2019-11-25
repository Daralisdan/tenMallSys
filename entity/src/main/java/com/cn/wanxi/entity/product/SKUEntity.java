package com.cn.wanxi.entity.product;

import java.util.Date;

/**
 * 【库存量单位信息管理】
 * 描述：SKU：stock keeping unit(库存量单位)
 *
 * 数据表： wx_tab_sku 表--库存量单元
 *
 * @author LessonWong
 * @date 2019/11/18 18:35
 */
public class SKUEntity {
    private Integer id;
    private String sn;
    private String name;
    private Integer price;
    private Integer num;
    private Integer alert_num;
    private String image;
    private String images;
    private Integer weight;
    private Date create_time;
    private Date update_time;
    private Integer spu_id;
    private Integer category_id;
    private String category_name;
    private String brand_name;
    private String spec;
    private Integer sale_num;
    private Integer comment_num;
    private Character status;

    public SKUEntity() {
    }

    public SKUEntity(Integer id, String sn, String name, Integer price, Integer num, Integer alert_num, String image, String images, Integer weight, Date create_time, Date update_time, Integer spu_id, Integer category_id, String category_name, String brand_name, String spec, Integer sale_num, Integer comment_num, Character status) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.price = price;
        this.num = num;
        this.alert_num = alert_num;
        this.image = image;
        this.images = images;
        this.weight = weight;
        this.create_time = create_time;
        this.update_time = update_time;
        this.spu_id = spu_id;
        this.category_id = category_id;
        this.category_name = category_name;
        this.brand_name = brand_name;
        this.spec = spec;
        this.sale_num = sale_num;
        this.comment_num = comment_num;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getAlert_num() {
        return alert_num;
    }

    public void setAlert_num(Integer alert_num) {
        this.alert_num = alert_num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Integer spu_id) {
        this.spu_id = spu_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getSale_num() {
        return sale_num;
    }

    public void setSale_num(Integer sale_num) {
        this.sale_num = sale_num;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SKUEntity{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", alert_num=" + alert_num +
                ", image='" + image + '\'' +
                ", images='" + images + '\'' +
                ", weight=" + weight +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", spu_id=" + spu_id +
                ", category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", brand_name='" + brand_name + '\'' +
                ", spec='" + spec + '\'' +
                ", sale_num=" + sale_num +
                ", comment_num=" + comment_num +
                ", status=" + status +
                '}';
    }
}
