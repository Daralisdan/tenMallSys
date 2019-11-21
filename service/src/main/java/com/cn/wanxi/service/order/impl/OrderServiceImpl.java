package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IOrderDao;
import com.cn.wanxi.dao.order.impl.IOrderDaoImpl;
import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderLogEntity;
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
//    @Autowired
//    private IOrderDao iOrderDao;
//    /**
//     * 【查询所有订单信息】
//     *
//     * @return
//     */
//    @Override
//    public
//    Map<String, Object>  list(int page,int size) {
//        return iOrderDao.list(page, size);
//    }
//
//    @Override
//    public List<Map<String, Object>>  batchlist(String ids) {
//        return iOrderDao.batchlist(ids);
//    }
//
//    @Override
//    public OrderEntity findById(int id) {
//        return iOrderDao.findById(id);
//    }
//
//    @Override
//    public int update(OrderLogEntity orderLogEntity) {
//        int result = 0;
//        //先根据id查询，当前数据是否存在
//        int id = orderLogEntity.getOrder_id();
//        OrderLogEntity  byOrderId= iOrderDao.findById(id);
//        //如果查询当前数据存在，则修改
//        if (byOrderId != null) {
//            int up = iOrderDao.update(orderLogEntity);
//            //如果修改成功，返回true
//            if (up > 0) {
//                result = up;
//            }
//        }
//        return result;
//    }
}
