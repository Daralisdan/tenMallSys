package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IOrderDao;
import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/18,Create by yaodan
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao iOrderDao;
    /**
     * 【查询所有订单信息】
     *
     * @return
     */
    @Override
    public
    List<Map<String, Object>> list(int page,int size) {
        return iOrderDao.list(page, size);
    }

    @Override
    public List<Map<String, Object>>  batchlist(String ids) {
        return iOrderDao.batchlist(ids);
    }

    @Override
    public OrderEntity findById(int id) {
        return iOrderDao.findById(id);
    }

    @Override
    public OrderLogEntity findByOrderId(int orderId) {
        return iOrderDao.findByOrderId(orderId);
    }

//    @Override
//    public int update(RefundCauseEntity refundCauseEntity) {
//        int up = iOrderDao.update(refundCauseEntity);
//
//
//
//        return up;
//    }

    @Override
    public int batchSendSubmit(int orderId) {
        return iOrderDao.batchSendSubmit(orderId);
    }

    @Override
    public List<Map<String, Object>>  refundList(int page, int size) {
        return iOrderDao.refundList(page, size);
    }
}
