package com.cn.wanxi.utils.message.enums;

/**
 * @author LeesonWong
 * @date 2019/11/22 23:42
 */
public enum OperationTypeEnum {
    ADD("新增"),
    DELETE("删除"),
    UPDATE("更新"),
    //修改与更新其实是一个意思
    SUBMIT("提交"),
    REVIEW("审核"),
    SHELVEON("上架"),
    SHELVEOFF("下架"),
    DELIVERY("发货"),
    OPERATION("操作"),
    LOGIN("登录"),
    LOGOUT("退出"),
    FIND("查询"),
    SAVE("保存"),
    MODIFY("修改"),
    CANCEL("取消"),
    RESET("重置");

    private String operation;

    OperationTypeEnum(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
