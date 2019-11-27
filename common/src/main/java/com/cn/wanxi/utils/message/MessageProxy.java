package com.cn.wanxi.utils.message;

import com.cn.wanxi.utils.message.enums.OperationTypeEnum;

import java.util.List;
import java.util.Map;

/**
 * 这一版本的添加仅考虑使用的便捷，不考虑性能上的消耗
 *
 * @author LeesonWong
 * @date 2019/11/22 16:51
 */
public class MessageProxy {
    private MessageProxy() {
    }

    public static Message success(OperationTypeEnum type){
        Message msg = new Message();
        msg.setSuccess();
        msg.setMessage(0,type);
        return msg;
    }



    public static Message success(OperationTypeEnum type, List<Map<String, Object>> data){
        Message msg = new Message();
        msg.setSuccess();
        msg.setMessage(0,type);
        msg.setData(data);
        return msg;
    }

    public static Message success(OperationTypeEnum type, String moduleName, List<Map<String, Object>> data){
        Message msg = new Message();
        msg.setSuccess();
        msg.setDetailMessage(0,type,moduleName);
        msg.setData(data);
        return msg;
    }


    /*
    失败一定没有数据
     */
    public static Message fail(OperationTypeEnum type){
        Message msg = new Message();
        msg.setFault();
        msg.setMessage(1,type);
        return msg;
    }

    public static Message fail(OperationTypeEnum type, String moduleName){
        Message msg = new Message();
        msg.setFault();
        msg.setDetailMessage(1,type,moduleName);
        return msg;
    }
}
