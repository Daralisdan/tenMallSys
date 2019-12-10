package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.utils.utils.Msg;

import java.util.Map;


public interface IRefundCauseService {
    Msg updateStatus(RefundCauseEntity refundCauseEntity);

//    Map<String, Object> refundList(int page, int size);

    Msg add(RefundCauseEntity refundCauseEntity);

    Map<String, Object> findAll(Map<String, Object> param);

    Msg findById(int id);

    Msg deleteById(int id);

    Msg update(RefundCauseEntity refundCauseEntity);
    int countAll();

}
