package com.cn.wanxi.utils.message;

import java.util.List;
import java.util.Map;

/**
 * 这个类只是赶进度的妥协，会将data类型抽象出来统一格式
 * @author LeesonWong
 * @date 2019/11/26 18:33
 */
public class MessageLimit {
    private int code;
    private String message;
    private Map<String, Object> data;

    public MessageLimit() {
    }

    public MessageLimit(int code, String message, Map<String, Object> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageLimit{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
