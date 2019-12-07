package com.cn.wanxi.utils.utils;

import lombok.Data;

/**
 * 2019/11/16,Create by yaodan
 */
@Data
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
    private Object rows;

    private MsgData data;

    private Msg() {
    }

    /**
     * 返回状态跟信息
     *
     * @param code
     * @param msg
     */
    public Msg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Msg(Integer code, MsgData data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 返回状态，信息，数据对象
     *
     * @param code
     * @param msg
     * @param data
     */
    public Msg(Integer code, String msg, MsgData data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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
    public Msg messageData(Object data) {
        this.rows = data;
        return this;
    }

}
