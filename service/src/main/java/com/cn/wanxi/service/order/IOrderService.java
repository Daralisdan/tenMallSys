package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.entity.order.RefundCauseEntity;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/18,Create by yaodan
 */
public interface IOrderService {
    int add(OrderEntity orderEntity);

    Map<String, Object> batchlist(String ids);

    OrderEntity findById(int id);

    int deleteById(int id);

    //    int update(RefundCauseEntity refundCauseEntity);
    List<Map<String, Object>> findAll();

    //    int batchSendSubmit( orderId,String shippingName,String shippingCode);
    int countAll();

    int batchSendSubmit(int id, Object orderId, Object shippingName, Object shippingCode);

    Map<String, Object> list(int page, int size, OrderEntity orderEntity);
}
