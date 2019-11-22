package com.cn.wanxi.utils.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/22 16:53
 */
public class Message {
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
    private Map<String, Object> extend = new HashMap<>();
}
