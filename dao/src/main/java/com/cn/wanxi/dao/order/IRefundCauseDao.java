package com.cn.wanxi.dao.order;

import com.cn.wanxi.entity.order.RefundCauseEntity;

public interface IRefundCauseDao {
    int updateStatus1(RefundCauseEntity refundCauseEntity);
    int updateStatus2(RefundCauseEntity refundCauseEntity);
}
