package com.cn.wanxi.dao.order;

import com.cn.wanxi.entity.order.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/18,Create by yaodan
 */

public interface IOrderDao {
    int insert(OrderEntity orderEntity);

    List<Map<String, Object>> queryAll();

    Map<String, Object> list(int page, int size, OrderEntity orderEntity);

    Map<String, Object> batchlist();

    OrderEntity findById(int id);

    int deleteById(int id);

    void update();


    int batchSendSubmit(int id, Object orderId, Object shippingName, Object shippingCode);

    int countAll();

//    Map<String, Object> list(Object username, Object page, Object size, Object orderStatus, Object bgDate, Object edDate);
}
