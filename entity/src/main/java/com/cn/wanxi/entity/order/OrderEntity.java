package com.cn.wanxi.entity.order;

import lombok.Data;

import java.util.List;

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
    private List<OrderItemEntity> sublist;




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
