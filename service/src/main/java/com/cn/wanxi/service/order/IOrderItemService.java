package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.utils.utils.Msg;

import java.util.List;

/**
 *
 */

public interface IOrderItemService {
    int add(List<OrderItemEntity> orderItemEntityList);

    Msg findAll();

    Msg findById(int id);

    Msg deleteById(int id);

    Msg update(OrderItemEntity orderItemEntity);
}
