package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IOrderLogDao;
import com.cn.wanxi.entity.order.OrderLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class IOrderLogImpl implements IOrderLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加订单日志详细
     *
     * @param orderLogEntity
     * @return
     */
    @Override
    public int insert(OrderLogEntity orderLogEntity) {
        String exeSQL = "INSERT INTO wx_tab_order_log(operater,operate_time,order_id,order_status,pay_status,consign_status,remarks) VALUES(?,?,?,?,?,?,?)";
        Object args[] = {orderLogEntity.getOperater(), orderLogEntity.getOperateTime(), orderLogEntity.getOrderId(), orderLogEntity.getOrderStatus(),
                orderLogEntity.getPayStatus(), orderLogEntity.getConsignStatus(), orderLogEntity.getRemarks()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 查找所有的订单日志
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select operater , operate_time as operateTime , order_id as orderId  ,   order_status as  orderStatus, pay_status as  payStatus ,  consign_status as consignStatus ,remarks   from wx_tab_order_log";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public OrderLogEntity findById(int id) {
        OrderLogEntity orderLogEntity = null;
        String exeSQL = "select operater , operate_time as operateTime , order_id as orderId  ,   order_status as  orderStatus, pay_status as  payStatus ,  consign_status as consignStatus ,remarks from wx_tab_order_log where id=?";
        List<OrderLogEntity> orderLogEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<OrderLogEntity>(OrderLogEntity.class));
        if (null != orderLogEntities && orderLogEntities.size() > 0) {
            orderLogEntity = orderLogEntities.get(0);
        }
        return orderLogEntity;
    }

    @Override
    public int update(OrderLogEntity orderLogEntity) {
        String exeSQL = "update wx_tab_order_log set operater=? ,operate_time=?,order_id=?,order_status=?,pay_status=?,consign_status=?,remarks=?  WHERE id=?";
        Object args[] = {orderLogEntity.getOperater(), orderLogEntity.getOperateTime(), orderLogEntity.getOrderId(), orderLogEntity.getOrderStatus(),
                orderLogEntity.getPayStatus(), orderLogEntity.getConsignStatus(), orderLogEntity.getRemarks(),orderLogEntity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_order_log WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }
}
