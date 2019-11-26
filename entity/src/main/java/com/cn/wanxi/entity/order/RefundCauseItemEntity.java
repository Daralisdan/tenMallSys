package com.cn.wanxi.entity.order;

import lombok.Data;

@Data
public class RefundCauseItemEntity {
    private Integer id;
    private Integer categoryId;
    private Integer spuId;
    private Integer skuId;
    private Integer orderId;
    private Integer orderItemId;
    private Integer returnOrderId;
    private String title;
    private Integer price;
    private Integer num;
    private Integer money;
    private Integer payMoney;
    private String image;
    private Integer weight;

    public RefundCauseItemEntity(Integer id, Integer categoryId, Integer spuId, Integer skuId, Integer orderId, Integer orderItemId, Integer returnOrderId, String title, Integer price, Integer num, Integer money, Integer payMoney, String image, Integer weight) {
        this.id = id;
        this.categoryId = categoryId;
        this.spuId = spuId;
        this.skuId = skuId;
        this.orderId = orderId;
        this.orderItemId = orderItemId;
        this.returnOrderId = returnOrderId;
        this.title = title;
        this.price = price;
        this.num = num;
        this.money = money;
        this.payMoney = payMoney;
        this.image = image;
        this.weight = weight;
    }

    public RefundCauseItemEntity() {
    }

    @Override
    public String toString() {
        return "RefundCauseItemEntity{" +
                "id='" + id + '\'' +
                ", categoryId=" + categoryId +
                ", spuId='" + spuId + '\'' +
                ", skuId='" + skuId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", returnOrderId='" + returnOrderId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", money=" + money +
                ", payMoney=" + payMoney +
                ", image='" + image + '\'' +
                ", weight=" + weight +
                '}';
    }
}
