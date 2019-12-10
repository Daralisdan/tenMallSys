package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.utils.utils.Msg;

import java.util.Map;

/**
 * 2019/11/18,Create by yaodan
 */
public interface IOrderService {
    Msg add(OrderEntity orderEntity);

    Msg update();

    Msg batchlist();

    Msg item(int id);

    Msg findById(int id);

    Msg deleteById(int id);


    Msg findAll();

    int countAll();


    Map<String, Object> list(Map<String, Object> param);

    Msg batchSendSubmit(Map<String, Object> param);
}
