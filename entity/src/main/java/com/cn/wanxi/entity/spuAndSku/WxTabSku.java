package com.cn.wanxi.entity.spuAndSku;

import java.sql.Date;

public class WxTabSku {
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
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WxTabSku{" +
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
                ", status='" + status + '\'' +
                '}';
    }
}
