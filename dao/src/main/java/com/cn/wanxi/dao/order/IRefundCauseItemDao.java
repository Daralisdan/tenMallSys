package com.cn.wanxi.dao.order;

import com.cn.wanxi.entity.order.RefundCauseItemEntity;

import java.util.List;
import java.util.Map;

public interface IRefundCauseItemDao  {
    int insert(RefundCauseItemEntity refundCauseItemEntity);
    List<Map<String, Object>> queryAll();
    RefundCauseItemEntity findById(int id);
    int deleteById(int id);
    int update(RefundCauseItemEntity refundCauseItemEntity);
}
