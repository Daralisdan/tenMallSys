package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.OrderLogEntity;

import java.util.List;
import java.util.Map;

public interface IOrderLogService {
    int add(OrderLogEntity orderLogEntity);

    List<Map<String, Object>> findAll();

    OrderLogEntity findById(int id);

    int deleteById(int id);

    int update(OrderLogEntity orderLogEntity);
}
