package com.cn.wanxi.dao.order;

import com.cn.wanxi.entity.order.OrderItemEntity;

import java.util.List;
import java.util.Map;

 public interface IOrderItemDao  {
    int insert(List<OrderItemEntity> orderItemEntityList);
    List<Map<String, Object>> queryAll();
    OrderItemEntity findById(int id);
    int deleteById(int id);
    int update(OrderItemEntity orderItemEntity);


}
