package com.cn.wanxi.entity.order;

public class OrderItemEntity  {
    private  Integer id;
    private  Integer categoryId1;
    private  Integer categoryId2;
    private  Integer categoryId3;
    private  Integer spuId;
    private  Integer skuId;
    private  Integer orderId;
    private  String name;
    private Integer price;
    private Integer num;
    private Integer money;
    private Integer payMoney;
    private String image;
    private Integer weight;
    private Integer postFee;
    private Integer isReturn;

    public OrderItemEntity(Integer categoryId1, Integer categoryId2, Integer categoryId3, Integer spuId, Integer skuId, Integer orderId, String name, Integer price, Integer num, Integer money, Integer payMoney, String image, Integer weight, Integer postFee, Integer isReturn) {
        this.categoryId1 = categoryId1;
        this.categoryId2 = categoryId2;
        this.categoryId3 = categoryId3;
        this.spuId = spuId;
        this.skuId = skuId;
        this.orderId = orderId;
        this.name = name;
        this.price = price;
        this.num = num;
        this.money = money;
        this.payMoney = payMoney;
        this.image = image;
        this.weight = weight;
        this.postFee = postFee;
        this.isReturn = isReturn;
    }
    public OrderItemEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Integer categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Integer getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Integer categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Integer getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Integer categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
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

    public Integer getPostFee() {
        return postFee;
    }

    public void setPostFee(Integer postFee) {
        this.postFee = postFee;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }
}
