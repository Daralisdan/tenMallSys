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


    List<Map<String, Object>> list(int page, int size);

    List<Map<String, Object>> batchlist(String ids);
    //    Map<String, Object> batchlist(int page, int size);
    OrderEntity findById(int id);

    OrderLogEntity findByOrderId(int orderId);
    int update(RefundCauseEntity refundCauseEntity);

    int batchSendSubmit(int orderId);

    List<Map<String, Object>>  refundList(int page, int size);
}
