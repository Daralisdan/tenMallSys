package com.cn.wanxi.entity.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019/11/16,Create by yaodan
 */
public class Msg {

    /**
     * 状态码 0表示成功，为1表示失败
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;

    /**
     * 用户要返回给浏览器的数据
     */
    private Map<String, Object> extend = new HashMap<String, Object>();

    /**
     * 返回成功状态的信息
     *
     * @return
     */
    public static Msg success() {
        Msg result = new Msg();
    //设置状态码
        result.setCode(0);
        result.setMsg("处理成功！");
        return result;
}

    /**
     * 返回成功状态的信息
     *
     * @return
     */
    public static Msg fail() {
        Msg result = new Msg();
        //设置状态码
        result.setCode(1);
        result.setMsg("处理失败！");
        return result;
    }


    /**
     * 状态信息跟数据一起返回给用户
     */
    public Msg messageData(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
