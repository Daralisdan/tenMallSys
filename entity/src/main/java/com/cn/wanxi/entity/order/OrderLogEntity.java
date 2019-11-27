package com.cn.wanxi.entity.order;

public class OrderLogEntity {
       private Integer id;
    private String operater;
    private String operateTime;
    private Integer orderId;
    private String orderStatus;
    private String payStatus;
    private String consignStatus;
    private String remarks;

    public OrderLogEntity(String operater, String operateTime, Integer orderId, String orderStatus, String payStatus, String consignStatus, String remarks) {
        this.operater = operater;
        this.operateTime = operateTime;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
        this.consignStatus = consignStatus;
        this.remarks = remarks;
    }

    public OrderLogEntity() {
    }

    @Override
    public String toString() {
        return "OrderLogEntity{" +
                "id=" + id +
                ", operate='" + operater + '\'' +
                ", operate_time='" + operateTime + '\'' +
                ", order_id=" + orderId +
                ", order_status='" + orderStatus + '\'' +
                ", pay_status='" + payStatus + '\'' +
                ", consign_status='" + consignStatus + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getConsignStatus() {
        return consignStatus;
    }

    public void setConsignStatus(String consignStatus) {
        this.consignStatus = consignStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
