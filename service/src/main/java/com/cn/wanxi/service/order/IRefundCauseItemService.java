package com.cn.wanxi.service.order;



import com.cn.wanxi.entity.order.RefundCauseItemEntity;

import java.util.List;
import java.util.Map;

public interface IRefundCauseItemService {
    int add(RefundCauseItemEntity refundCauseItemEntity);
    List<Map<String, Object>> findAll();
    RefundCauseItemEntity findById(int id);
    int deleteById(int id);
    int update(RefundCauseItemEntity refundCauseItemEntity);
}
