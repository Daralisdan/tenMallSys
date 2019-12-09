package com.cn.wanxi.service.order;


import com.cn.wanxi.entity.order.RefundCauseItemEntity;
import com.cn.wanxi.utils.utils.Msg;

public interface IRefundCauseItemService {
    Msg add(RefundCauseItemEntity refundCauseItemEntity);

    Msg findAll();

    Msg findById(int id);

    Msg deleteById(int id);

    Msg update(RefundCauseItemEntity refundCauseItemEntity);
}
