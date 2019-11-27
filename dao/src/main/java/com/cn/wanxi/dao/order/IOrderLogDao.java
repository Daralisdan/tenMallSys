package com.cn.wanxi.dao.order;

import com.cn.wanxi.entity.order.OrderLogEntity;

import java.util.List;
import java.util.Map;

public interface IOrderLogDao {
    int insert(OrderLogEntity orderLogEntity);
    List<Map<String, Object>> queryAll();
    OrderLogEntity findById(int id);
    int deleteById(int id);
    int update(OrderLogEntity orderLogEntity);
}
