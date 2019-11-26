package com.cn.wanxi.utils.utils;

import java.util.LinkedList;

/**
 * @author LeesonWong
 * @date 2019/11/20 12:14
 */
public class MsgX {
    private Integer code;
    private String message;
    private LinkedList<Object> list = new LinkedList<>();

    private MsgX(){

    }

    private MsgX(Integer code, String message, LinkedList<Object> list) {
        this.code = code;
        this.message = message;
        this.list = list;
    }

    public static MsgX success(int code, String message){
        MsgX temp = new MsgX();
        temp.setCode(code);
        temp.setMessage(message);
        return temp;
    }

    public static MsgX success(int code, String message, Object...objects){
        MsgX temp = success(code,message);
        for(Object iter : objects){
            temp.setList(iter);
        }
        return temp;
    }

    public static MsgX fail(int code, String message){
        MsgX temp = new MsgX();
        temp.setCode(code);
        temp.setMessage(message);
        return temp;
    }

    public static MsgX fail(int code, String message, Object...objects){
        MsgX temp = fail(code,message);
        for(Object iter : objects){
            temp.setList(iter);
        }
        return temp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(Object object) {
        list.add(object);
    }
}
