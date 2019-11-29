package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.OrderItemEntity;

import java.util.List;
import java.util.Map;

/**
 *
 */

public interface IOrderItemService {
    int add(List<OrderItemEntity> orderItemEntityList);

    List<Map<String, Object>> findAll();

    OrderItemEntity findById(int id);

    int deleteById(int id);

    int update(OrderItemEntity orderItemEntity);
}
