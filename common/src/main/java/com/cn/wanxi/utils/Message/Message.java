package com.cn.wanxi.utils.message;

import com.cn.wanxi.utils.message.enums.CodeEnum;
import com.cn.wanxi.utils.message.enums.OperationTypeEnum;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/22 22:59
 */

public class Message {
    private int code;
    private String message;

    /**
     * 保留字段，建议将所有的返回格式统一为
     *  code : 0 | 1
     *  message : "XXXX"
     *  date : MessageData
     * @param code
     * @param type
     */
    private List<Map<String, Object>> data;

    public int setSuccess(){
        return code = 0;
    }

    public int setFault(){
        return code = 1;
    }

    public void setMessage(int code, OperationTypeEnum type) {
        message = CodeEnum.values()[code].getType() + type.getOperation();
    }

    /**
     *
     * @param code
     * @param type
     * @param moduleName
     */
    public void setDetailMessage(int code ,OperationTypeEnum type,String moduleName) {
        message = moduleName + CodeEnum.values()[code].getType() + type.getOperation();
    }

    /*
    没有get、set方法的对象不能作为页面的返回格式
     */

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

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
