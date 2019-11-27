package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IOrderItemDao;
import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.service.order.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author FENGDOU
 */
@Service
public class IOrderItemServiceImpl implements IOrderItemService {
    @Autowired
    private IOrderItemDao iOrderItemDao;

    /**
     * 添加订单详细列表
     * @param orderItemEntity
     * @return
     */
    @Override
    public int add(OrderItemEntity orderItemEntity) {
        //判断页面传的值中名字不能为空
        String name = orderItemEntity.getName().trim();
        int result = 0;
        //不为空时，添加数据
        if (!StringUtils.isEmpty(name)) {
            result = iOrderItemDao.insert(orderItemEntity);
        }
        return result;
    }

    /**
     * 查找所有的订单详细
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll() {
        return iOrderItemDao.queryAll();
    }

    /**
     * 根据订单详细id 查询
     * @param id
     * @return
     */
    @Override
    public OrderItemEntity findById(int id) {
        return iOrderItemDao.findById(id);
    }

    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return iOrderItemDao.deleteById(id);
    }

    /**
     * 根据订单详细id 修改
     * @param orderItemEntity
     * @return
     */
    @Override
    public int update(OrderItemEntity orderItemEntity) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = orderItemEntity.getId();
        OrderItemEntity byId = iOrderItemDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = iOrderItemDao.update(orderItemEntity);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }




}
