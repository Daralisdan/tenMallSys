package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.RefundCauseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface IRefundCauseService {
    int updateStatus(RefundCauseEntity refundCauseEntity);

//    Map<String, Object> refundList(int page, int size);

    int add(RefundCauseEntity refundCauseEntity);

    List<Map<String, Object>> findAll(int page, int size,String type);

    RefundCauseEntity findById(int id);

    int deleteById(int id);

    int update(RefundCauseEntity refundCauseEntity);
    int countAll();

}
