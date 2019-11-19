package com.cn.wanxi.entity.order;

public class RefundCauseEntity {
    private Integer id;
    private Integer order_id;
    private String apply_time;
    private Integer user_id;
    private String user_account;
    private String linkman;
    private String linkman_mobile;
    private String type;
    private Integer return_money;
    private String is_return_freight;
    private String status;
    private String dispose_time;
    private Integer return_cause;
    private String evidence;
    private String description;
    private String remark;
    private Integer admin_id;

    public RefundCauseEntity(Integer order_id, String apply_time, Integer user_id, String user_account, String linkman, String linkman_mobile, String type, Integer return_money, String is_return_freight, String status, String dispose_time, Integer return_cause, String evidence, String description, String remark, Integer admin_id) {
        this.order_id = order_id;
        this.apply_time = apply_time;
        this.user_id = user_id;
        this.user_account = user_account;
        this.linkman = linkman;
        this.linkman_mobile = linkman_mobile;
        this.type = type;
        this.return_money = return_money;
        this.is_return_freight = is_return_freight;
        this.status = status;
        this.dispose_time = dispose_time;
        this.return_cause = return_cause;
        this.evidence = evidence;
        this.description = description;
        this.remark = remark;
        this.admin_id = admin_id;
    }
    public RefundCauseEntity(){

    }

    @Override
    public String toString() {
        return "RefundCauseEntity{" +
                "order_id=" + order_id +
                ", apply_time='" + apply_time + '\'' +
                ", user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", linkman='" + linkman + '\'' +
                ", linkman_mobile='" + linkman_mobile + '\'' +
                ", type='" + type + '\'' +
                ", return_money=" + return_money +
                ", is_return_freight='" + is_return_freight + '\'' +
                ", status='" + status + '\'' +
                ", dispose_time='" + dispose_time + '\'' +
                ", return_cause=" + return_cause +
                ", evidence='" + evidence + '\'' +
                ", description='" + description + '\'' +
                ", remark='" + remark + '\'' +
                ", admin_id=" + admin_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getApply_time() {
        return apply_time;
    }

    public void setApply_time(String apply_time) {
        this.apply_time = apply_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkman_mobile() {
        return linkman_mobile;
    }

    public void setLinkman_mobile(String linkman_mobile) {
        this.linkman_mobile = linkman_mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getReturn_money() {
        return return_money;
    }

    public void setReturn_money(Integer return_money) {
        this.return_money = return_money;
    }

    public String getIs_return_freight() {
        return is_return_freight;
    }

    public void setIs_return_freight(String is_return_freight) {
        this.is_return_freight = is_return_freight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDispose_time() {
        return dispose_time;
    }

    public void setDispose_time(String dispose_time) {
        this.dispose_time = dispose_time;
    }

    public Integer getReturn_cause() {
        return return_cause;
    }

    public void setReturn_cause(Integer return_cause) {
        this.return_cause = return_cause;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }
}
