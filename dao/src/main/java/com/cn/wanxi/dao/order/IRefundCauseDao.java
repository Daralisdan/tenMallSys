package com.cn.wanxi.dao.order;

import com.cn.wanxi.entity.order.RefundCauseEntity;

import java.util.List;
import java.util.Map;

public interface IRefundCauseDao {
    int updateStatus1(RefundCauseEntity refundCauseEntity);
    int updateStatus2(RefundCauseEntity refundCauseEntity);
    int insert(RefundCauseEntity refundCauseEntity);
    List<Map<String, Object>> queryAll();
    RefundCauseEntity findById(int id);
    int deleteById(int id);
    int update(RefundCauseEntity refundCauseEntity);
    List<Map<String, Object>>  refundList(int page, int size);
}
