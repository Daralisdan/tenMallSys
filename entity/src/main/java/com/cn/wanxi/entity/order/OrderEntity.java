package com.cn.wanxi.entity.order;

import lombok.Data;

/**
 * 2019/11/18,Create by yaodan
 */
@Data
public class OrderEntity {
    private  Integer id;
    private  Integer totalNum;
    private  Integer totalMoney;
    private  Integer preMoney;
    private  Integer postFee;
    private  Integer payMoney;
    private  String payType;
    private String createTime;
    private String updateTime;
    private String payTime;
    private String consignTime;
    private String endTime;
    private String closeTime;
    private String shippingName;
    private String shippingCode;
    private String username;
    private String buyerMessage;
    private String buyerRate;
    private String receiverContact;
    private String receiverMobile;
    private String receiverAddress;
    private String sourceType;
    private Integer transactionId;
    private String orderStatus;
    private String payStatus;
    private String consignStatus;
    private String isDelete;
    private OrderItemEntity sublist;



    public OrderEntity() {
    }

    public OrderEntity(Integer id, Integer totalNum, Integer totalMoney, Integer preMoney, Integer postFee, Integer payMoney, String payType, String createTime, String updateTime, String payTime, String consignTime, String endTime, String closeTime, String shippingName, String shippingCode, String username, String buyerMessage, String buyerRate, String receiverContact, String receiverMobile, String receiverAddress, String sourceType, Integer transactionId, String orderStatus, String payStatus, String consignStatus, String isDelete, OrderItemEntity sublist) {
        this.id = id;
        this.totalNum = totalNum;
        this.totalMoney = totalMoney;
        this.preMoney = preMoney;
        this.postFee = postFee;
        this.payMoney = payMoney;
        this.payType = payType;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.payTime = payTime;
        this.consignTime = consignTime;
        this.endTime = endTime;
        this.closeTime = closeTime;
        this.shippingName = shippingName;
        this.shippingCode = shippingCode;
        this.username = username;
        this.buyerMessage = buyerMessage;
        this.buyerRate = buyerRate;
        this.receiverContact = receiverContact;
        this.receiverMobile = receiverMobile;
        this.receiverAddress = receiverAddress;
        this.sourceType = sourceType;
        this.transactionId = transactionId;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
        this.consignStatus = consignStatus;
        this.isDelete = isDelete;
        this.sublist = sublist;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", total_num=" + totalNum +
                ", total_money=" + totalMoney +
                ", pre_money=" + preMoney +
                ", post_fee=" + postFee +
                ", pay_money=" + payMoney +
                ", pay_type='" + payType + '\'' +
                ", create_time='" + createTime + '\'' +
                ", update_time='" + updateTime + '\'' +
                ", pay_time='" + payTime + '\'' +
                ", consign_time='" + consignTime + '\'' +
                ", end_time='" + endTime + '\'' +
                ", close_time='" + closeTime + '\'' +
                ", shipping_name='" + shippingName + '\'' +
                ", shipping_code='" + shippingCode + '\'' +
                ", username='" + username + '\'' +
                ", buyer_message='" + buyerMessage + '\'' +
                ", buyer_rate='" + buyerRate + '\'' +
                ", receiver_contact='" + receiverContact + '\'' +
                ", receiver_mobile='" + receiverMobile + '\'' +
                ", receiver_address='" + receiverAddress + '\'' +
                ", source_type='" + sourceType + '\'' +
                ", transaction_id=" + transactionId +
                ", order_status='" + orderStatus + '\'' +
                ", pay_status='" + payStatus + '\'' +
                ", consign_status='" + consignStatus + '\'' +
                ", is_delete='" + isDelete + '\'' +
                ", sublist=" + sublist +
                '}';
    }
}
