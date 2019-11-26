package com.cn.wanxi.entity.product;

/**
 * 【标准产品单位信息管理】
 * 描述：SPU ：Standard Product Unit （标准产品单位）
 *
 * 数据表： wx_tab_spu 表--标准产品单元
 *
 * @author LessonWong
 * @date 2019/11/18 18:32
 */
public class SPUEntity {
    private Integer id;
    private String sn;
    private String name;
    private String caption;
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
    private Character is_marketable;
    private Character is_enable_spec;
    private Character is_delete;
    private Character status;

    public SPUEntity() {
    }

    public SPUEntity(Integer id, String sn, String name, String caption, Integer brand_id, Integer category1_id, Integer category2_id, Integer category3_id, Integer template_id, Integer freight_id, String image, String images, String sale_service, String introduction, String spec_items, String para_items, Integer sale_num, Integer comment_num, Character is_marketable, Character is_enable_spec, Character is_delete, Character status) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.caption = caption;
        this.brand_id = brand_id;
        this.category1_id = category1_id;
        this.category2_id = category2_id;
        this.category3_id = category3_id;
        this.template_id = template_id;
        this.freight_id = freight_id;
        this.image = image;
        this.images = images;
        this.sale_service = sale_service;
        this.introduction = introduction;
        this.spec_items = spec_items;
        this.para_items = para_items;
        this.sale_num = sale_num;
        this.comment_num = comment_num;
        this.is_marketable = is_marketable;
        this.is_enable_spec = is_enable_spec;
        this.is_delete = is_delete;
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
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

    public Character getIs_marketable() {
        return is_marketable;
    }

    public void setIs_marketable(Character is_marketable) {
        this.is_marketable = is_marketable;
    }

    public Character getIs_enable_spec() {
        return is_enable_spec;
    }

    public void setIs_enable_spec(Character is_enable_spec) {
        this.is_enable_spec = is_enable_spec;
    }

    public Character getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Character is_delete) {
        this.is_delete = is_delete;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SPUEntity{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", caption='" + caption + '\'' +
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
                ", is_marketable=" + is_marketable +
                ", is_enable_spec=" + is_enable_spec +
                ", is_delete=" + is_delete +
                ", status=" + status +
                '}';
    }
}
