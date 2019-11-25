package com.cn.wanxi.entity.order;

/**
 * 2019/11/18,Create by yaodan
 */
public class OrderEntity {
    private  Integer id;
    private  Integer total_num;
    private  Integer total_money;
    private  Integer pre_money;
    private  Integer post_fee;
    private  Integer pay_money;
    private  String pay_type;
    private String  create_time;
    private String  update_time;
    private String  pay_time;
    private String  consign_time;
    private String  end_time;
    private String close_time;
    private String shipping_name;
    private String shipping_code;
    private String username;
    private String buyer_message;
    private String buyer_rate;
    private String receiver_contact;
    private String receiver_mobile;
    private String receiver_address;
    private String source_type;
    private Integer transaction_id;
    private String order_status;
    private String pay_status;
    private String consign_status;
    private String is_delete;
    private OrderItemEntity sublist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public Integer getTotal_money() {
        return total_money;
    }

    public void setTotal_money(Integer total_money) {
        this.total_money = total_money;
    }

    public Integer getPre_money() {
        return pre_money;
    }

    public void setPre_money(Integer pre_money) {
        this.pre_money = pre_money;
    }

    public Integer getPost_fee() {
        return post_fee;
    }

    public void setPost_fee(Integer post_fee) {
        this.post_fee = post_fee;
    }

    public Integer getPay_money() {
        return pay_money;
    }

    public void setPay_money(Integer pay_money) {
        this.pay_money = pay_money;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getConsign_time() {
        return consign_time;
    }

    public void setConsign_time(String consign_time) {
        this.consign_time = consign_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getClose_time() {
        return close_time;
    }

    public void setClose_time(String close_time) {
        this.close_time = close_time;
    }

    public String getShipping_name() {
        return shipping_name;
    }

    public void setShipping_name(String shipping_name) {
        this.shipping_name = shipping_name;
    }

    public String getShipping_code() {
        return shipping_code;
    }

    public void setShipping_code(String shipping_code) {
        this.shipping_code = shipping_code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBuyer_message() {
        return buyer_message;
    }

    public void setBuyer_message(String buyer_message) {
        this.buyer_message = buyer_message;
    }

    public String getBuyer_rate() {
        return buyer_rate;
    }

    public void setBuyer_rate(String buyer_rate) {
        this.buyer_rate = buyer_rate;
    }

    public String getReceiver_contact() {
        return receiver_contact;
    }

    public void setReceiver_contact(String receiver_contact) {
        this.receiver_contact = receiver_contact;
    }

    public String getReceiver_mobile() {
        return receiver_mobile;
    }

    public void setReceiver_mobile(String receiver_mobile) {
        this.receiver_mobile = receiver_mobile;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
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

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public OrderItemEntity getSublist() {
        return sublist;
    }

    public void setSublist(OrderItemEntity sublist) {
        this.sublist = sublist;
    }

    public OrderEntity() {
    }

    public OrderEntity(Integer id, Integer total_num, Integer total_money, Integer pre_money, Integer post_fee, Integer pay_money, String pay_type, String create_time, String update_time, String pay_time, String consign_time, String end_time, String close_time, String shipping_name, String shipping_code, String username, String buyer_message, String buyer_rate, String receiver_contact, String receiver_mobile, String receiver_address, String source_type, Integer transaction_id, String order_status, String pay_status, String consign_status, String is_delete, OrderItemEntity sublist) {
        this.id = id;
        this.total_num = total_num;
        this.total_money = total_money;
        this.pre_money = pre_money;
        this.post_fee = post_fee;
        this.pay_money = pay_money;
        this.pay_type = pay_type;
        this.create_time = create_time;
        this.update_time = update_time;
        this.pay_time = pay_time;
        this.consign_time = consign_time;
        this.end_time = end_time;
        this.close_time = close_time;
        this.shipping_name = shipping_name;
        this.shipping_code = shipping_code;
        this.username = username;
        this.buyer_message = buyer_message;
        this.buyer_rate = buyer_rate;
        this.receiver_contact = receiver_contact;
        this.receiver_mobile = receiver_mobile;
        this.receiver_address = receiver_address;
        this.source_type = source_type;
        this.transaction_id = transaction_id;
        this.order_status = order_status;
        this.pay_status = pay_status;
        this.consign_status = consign_status;
        this.is_delete = is_delete;
        this.sublist = sublist;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", total_num=" + total_num +
                ", total_money=" + total_money +
                ", pre_money=" + pre_money +
                ", post_fee=" + post_fee +
                ", pay_money=" + pay_money +
                ", pay_type='" + pay_type + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", pay_time='" + pay_time + '\'' +
                ", consign_time='" + consign_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", close_time='" + close_time + '\'' +
                ", shipping_name='" + shipping_name + '\'' +
                ", shipping_code='" + shipping_code + '\'' +
                ", username='" + username + '\'' +
                ", buyer_message='" + buyer_message + '\'' +
                ", buyer_rate='" + buyer_rate + '\'' +
                ", receiver_contact='" + receiver_contact + '\'' +
                ", receiver_mobile='" + receiver_mobile + '\'' +
                ", receiver_address='" + receiver_address + '\'' +
                ", source_type='" + source_type + '\'' +
                ", transaction_id=" + transaction_id +
                ", order_status='" + order_status + '\'' +
                ", pay_status='" + pay_status + '\'' +
                ", consign_status='" + consign_status + '\'' +
                ", is_delete='" + is_delete + '\'' +
                ", sublist=" + sublist +
                '}';
    }
}
