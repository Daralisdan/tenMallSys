package com.cn.wanxi.entity.spuAndSku;

public class WxTabSpu {
    private Integer id;
    private String sn;
    private String name;
    private Integer brand_id;
    private Integer category1_id;
    private Integer category2_id;
    private Integer category3_id;
    private Integer template_id;
    private Integer freight_id;
    private String image;
    private String images;
    private String sale_service;
    private String introduction;
    private String spec_items;
    private String para_items;
    private Integer sale_num;
    private Integer comment_num;
    private String is_marketable;
    private String is_enable_pec;
    private String is_delete;
    private String status;
    private WxTabSku SkuList;

    public WxTabSku getSkuList() {
        return SkuList;
    }

    public void setSkuList(WxTabSku skuList) {
        SkuList = skuList;
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

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public Integer getCategory1_id() {
        return category1_id;
    }

    public void setCategory1_id(Integer category1_id) {
        this.category1_id = category1_id;
    }

    public Integer getCategory2_id() {
        return category2_id;
    }

    public void setCategory2_id(Integer category2_id) {
        this.category2_id = category2_id;
    }

    public Integer getCategory3_id() {
        return category3_id;
    }

    public void setCategory3_id(Integer category3_id) {
        this.category3_id = category3_id;
    }

    public Integer getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(Integer template_id) {
        this.template_id = template_id;
    }

    public Integer getFreight_id() {
        return freight_id;
    }

    public void setFreight_id(Integer freight_id) {
        this.freight_id = freight_id;
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

    public String getSale_service() {
        return sale_service;
    }

    public void setSale_service(String sale_service) {
        this.sale_service = sale_service;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSpec_items() {
        return spec_items;
    }

    public void setSpec_items(String spec_items) {
        this.spec_items = spec_items;
    }

    public String getPara_items() {
        return para_items;
    }

    public void setPara_items(String para_items) {
        this.para_items = para_items;
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

    public String getIs_marketable() {
        return is_marketable;
    }

    public void setIs_marketable(String is_marketable) {
        this.is_marketable = is_marketable;
    }

    public String getIs_enable_pec() {
        return is_enable_pec;
    }

    public void setIs_enable_pec(String is_enable_pec) {
        this.is_enable_pec = is_enable_pec;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WxTabSpu{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", brand_id=" + brand_id +
                ", category1_id=" + category1_id +
                ", category2_id=" + category2_id +
                ", category3_id=" + category3_id +
                ", template_id=" + template_id +
                ", freight_id=" + freight_id +
                ", image='" + image + '\'' +
                ", images='" + images + '\'' +
                ", sale_service='" + sale_service + '\'' +
                ", introduction='" + introduction + '\'' +
                ", spec_items='" + spec_items + '\'' +
                ", para_items='" + para_items + '\'' +
                ", sale_num=" + sale_num +
                ", comment_num=" + comment_num +
                ", is_marketable='" + is_marketable + '\'' +
                ", is_enable_pec='" + is_enable_pec + '\'' +
                ", is_delete='" + is_delete + '\'' +
                ", status='" + status + '\'' +
                ", SkuList=" + SkuList +
                '}';
    }
}
