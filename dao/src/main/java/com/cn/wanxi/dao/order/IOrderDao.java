package com.cn.wanxi.dao.order;
import com.cn.wanxi.entity.order.OrderEntity;

import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.entity.order.RefundCauseEntity;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/18,Create by yaodan
 */

public interface IOrderDao {
    int insert(OrderEntity orderEntity);
    List<Map<String, Object>> queryAll();

    Map<String, Object> list(int page, int size);

    Map<String, Object> batchlist(String ids);

    OrderEntity findById(int id);
    int deleteById(int id);

    int batchSendSubmit(int orderId);

}
