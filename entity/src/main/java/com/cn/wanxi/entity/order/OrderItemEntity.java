package com.cn.wanxi.entity.order;

public class OrderItemEntity  {
    private  Integer id;
    private  Integer category_id1;
    private  Integer category_id2;
    private  Integer category_id3;
    private  Integer spu_id;
    private  Integer sku_id;
    private  Integer order_id;
    private  String name;
    private Integer price;
    private Integer num;
    private Integer money;
    private Integer pay_money;
    private String image;
    private Integer weight;
    private Integer post_fee;
    private Integer is_return;

    public OrderItemEntity(Integer category_id1, Integer category_id2, Integer category_id3, Integer spu_id, Integer sku_id, Integer order_id, String name, Integer price, Integer num, Integer money, Integer pay_money, String image, Integer weight, Integer post_fee, Integer is_return) {
        this.category_id1 = category_id1;
        this.category_id2 = category_id2;
        this.category_id3 = category_id3;
        this.spu_id = spu_id;
        this.sku_id = sku_id;
        this.order_id = order_id;
        this.name = name;
        this.price = price;
        this.num = num;
        this.money = money;
        this.pay_money = pay_money;
        this.image = image;
        this.weight = weight;
        this.post_fee = post_fee;
        this.is_return = is_return;
    }
    public OrderItemEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory_id1() {
        return category_id1;
    }

    public void setCategory_id1(Integer category_id1) {
        this.category_id1 = category_id1;
    }

    public Integer getCategory_id2() {
        return category_id2;
    }

    public void setCategory_id2(Integer category_id2) {
        this.category_id2 = category_id2;
    }

    public Integer getCategory_id3() {
        return category_id3;
    }

    public void setCategory_id3(Integer category_id3) {
        this.category_id3 = category_id3;
    }

    public Integer getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Integer spu_id) {
        this.spu_id = spu_id;
    }

    public Integer getSku_id() {
        return sku_id;
    }

    public void setSku_id(Integer sku_id) {
        this.sku_id = sku_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPay_money() {
        return pay_money;
    }

    public void setPay_money(Integer pay_money) {
        this.pay_money = pay_money;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPost_fee() {
        return post_fee;
    }

    public void setPost_fee(Integer post_fee) {
        this.post_fee = post_fee;
    }

    public Integer getIs_return() {
        return is_return;
    }

    public void setIs_return(Integer is_return) {
        this.is_return = is_return;
    }
}
