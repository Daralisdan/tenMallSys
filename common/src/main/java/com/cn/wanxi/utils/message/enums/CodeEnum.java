package com.cn.wanxi.utils.message.enums;

/**
 * 除了0和1不接受其他的值
 *
 * @author LeesonWong
 * @date 2019/11/22 22:31
 */
public enum CodeEnum {
    SUCCESS("成功"),FAIL("失败");
    private String type;
    CodeEnum(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
