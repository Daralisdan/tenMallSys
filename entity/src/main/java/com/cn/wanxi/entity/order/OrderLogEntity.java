package com.cn.wanxi.entity.order;

public class OrderLogEntity {
    private Integer id;
    private String operate;
    private String operate_time;
    private Integer order_id;
    private String order_status;
    private String pay_status;
    private String consign_status;
    private String remarks;

    public OrderLogEntity(String operate, String operate_time, Integer order_id, String order_status, String pay_status, String consign_status, String remarks) {
        this.operate = operate;
        this.operate_time = operate_time;
        this.order_id = order_id;
        this.order_status = order_status;
        this.pay_status = pay_status;
        this.consign_status = consign_status;
        this.remarks = remarks;
    }

    public OrderLogEntity() {
    }

    @Override
    public String toString() {
        return "OrderLogEntity{" +
                "id=" + id +
                ", operate='" + operate + '\'' +
                ", operate_time='" + operate_time + '\'' +
                ", order_id=" + order_id +
                ", order_status='" + order_status + '\'' +
                ", pay_status='" + pay_status + '\'' +
                ", consign_status='" + consign_status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
    }

    public String getConsign_status() {
        return consign_status;
    }

    public void setConsign_status(String consign_status) {
        this.consign_status = consign_status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
