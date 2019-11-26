package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IOrderLogDao;
import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.service.order.IOrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;


@Service
public class IOrderLogServiceImpl implements IOrderLogService {
    @Autowired
    private IOrderLogDao iOrderLogDao;
    /**
     * 添加订单日志列表
     * @param orderLogEntity
     * @return
     */
    @Override
    public int add(OrderLogEntity orderLogEntity) {
        //判断页面传的值中orderid不能为空
        Integer orderid = orderLogEntity.getOrderId();
        int result = 0;
        //不为空时，添加数据
        if (!StringUtils.isEmpty(orderid)) {
            result = iOrderLogDao.insert(orderLogEntity);
        }
        return result;
    }
    /**
     * 查找所有的日志详细
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll() {
        return iOrderLogDao.queryAll();
    }
    /**
     * 根据日志详细id 查询
     * @param id
     * @return
     */
    @Override
    public OrderLogEntity findById(int id) {
        return iOrderLogDao.findById(id);
    }
    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return iOrderLogDao.deleteById(id);
    }

    /**
     * 根据日志详细id 修改
     * @param orderLogEntity
     * @return
     */
    @Override
    public int update(OrderLogEntity orderLogEntity) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = orderLogEntity.getId();
        OrderLogEntity byId = iOrderLogDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = iOrderLogDao.update(orderLogEntity);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }
}
