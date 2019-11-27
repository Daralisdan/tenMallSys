package com.cn.wanxi.entity.order;

public class RefundCauseEntity {
    private Integer id;
    private Integer orderId;
    private String applyTime;
    private Integer userId;
    private String userAccount;
    private String linkman;
    private String linkmanMobile;
    private String type;
    private Integer returnMoney;
    private String isReturnFreight;
    private String status;
    private String disposeTime;
    private Integer returnCause;
    private String evidence;
    private String description;
    private String remark;
    private Integer adminId;

    public RefundCauseEntity(Integer orderId, String applyTime, Integer userId, String userAccount, String linkman, String linkmanMobile, String type, Integer returnMoney, String isReturnFreight, String status, String disposeTime, Integer returnCause, String evidence, String description, String remark, Integer adminId) {
        this.orderId = orderId;
        this.applyTime = applyTime;
        this.userId = userId;
        this.userAccount = userAccount;
        this.linkman = linkman;
        this.linkmanMobile = linkmanMobile;
        this.type = type;
        this.returnMoney = returnMoney;
        this.isReturnFreight = isReturnFreight;
        this.status = status;
        this.disposeTime = disposeTime;
        this.returnCause = returnCause;
        this.evidence = evidence;
        this.description = description;
        this.remark = remark;
        this.adminId = adminId;
    }
    public RefundCauseEntity(){

    }

    @Override
    public String toString() {
        return "RefundCauseEntity{" +
                "order_id=" + orderId +
                ", apply_time='" + applyTime + '\'' +
                ", user_id=" + userId +
                ", user_account='" + userAccount + '\'' +
                ", linkman='" + linkman + '\'' +
                ", linkman_mobile='" + linkmanMobile + '\'' +
                ", type='" + type + '\'' +
                ", return_money=" + returnMoney +
                ", is_return_freight='" + isReturnFreight + '\'' +
                ", status='" + status + '\'' +
                ", dispose_time='" + disposeTime + '\'' +
                ", return_cause=" + returnCause +
                ", evidence='" + evidence + '\'' +
                ", description='" + description + '\'' +
                ", remark='" + remark + '\'' +
                ", admin_id=" + adminId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Integer returnMoney) {
        this.returnMoney = returnMoney;
    }

    public String getIsReturnFreight() {
        return isReturnFreight;
    }

    public void setIsReturnFreight(String isReturnFreight) {
        this.isReturnFreight = isReturnFreight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisposeTime() {
        return disposeTime;
    }

    public void setDisposeTime(String disposeTime) {
        this.disposeTime = disposeTime;
    }

    public Integer getReturnCause() {
        return returnCause;
    }

    public void setReturnCause(Integer returnCause) {
        this.returnCause = returnCause;
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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}
