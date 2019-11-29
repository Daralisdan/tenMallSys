package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IOrderDao;
import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/18,Create by yaodan
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao iOrderDao;

    @Override
    public int add(OrderEntity orderEntity) {
        //判断页面传的值中名字不能为空
        String name = orderEntity.getUsername().trim();
        int result = 0;
        //不为空时，添加数据
        if (!StringUtils.isEmpty(name)) {
            result = iOrderDao.insert(orderEntity);
        }
        return result;
    }


    @Override
    public Map<String, Object> batchlist(String ids) {
        return iOrderDao.batchlist(ids);
    }

    @Override
    public OrderEntity findById(int id) {
        return iOrderDao.findById(id);
    }


    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return iOrderDao.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return iOrderDao.queryAll();
    }

    @Override
    public int batchSendSubmit(int id,Object  orderId,Object  shippingName,Object shippingCode) {
        return iOrderDao.batchSendSubmit(id,orderId, shippingName, shippingCode);
    }

    @Override
    public Map<String, Object> list(int page, int size, OrderEntity orderEntity) {
        return iOrderDao.list(page, size,orderEntity);
    }

    /**
     * 统计所有数据
     *
     * @return
     */
    @Override
    public int countAll() {
        return iOrderDao.countAll();
    }
}
