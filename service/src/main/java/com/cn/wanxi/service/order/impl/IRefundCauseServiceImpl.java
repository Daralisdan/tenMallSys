package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IRefundCauseDao;
import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.service.order.IRefundCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRefundCauseServiceImpl implements IRefundCauseService {
    @Autowired
    private IRefundCauseDao iRefundCauseDao;

    @Override
    public int update(RefundCauseEntity refundCauseEntity) {
        int up=0;
        if ("1".equals(refundCauseEntity.getStatus())) {
            up= iRefundCauseDao.updateStatus1(refundCauseEntity);
        } else if ("2".equals(refundCauseEntity.getStatus())) {
           up= iRefundCauseDao.updateStatus2(refundCauseEntity);
        }else {
            System.out.println("订单申请状态有误，请重新输入!");
        }

        return up;
    }
}
