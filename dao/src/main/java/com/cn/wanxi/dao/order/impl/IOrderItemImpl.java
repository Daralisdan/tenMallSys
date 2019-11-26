package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IOrderItemDao;
import com.cn.wanxi.entity.order.OrderItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class IOrderItemImpl implements IOrderItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加订单详细
     *
     * @param orderItemEntity
     * @return
     */
    @Override
    public int insert(OrderItemEntity orderItemEntity) {
        String exeSQL = "INSERT INTO wx_tab_order_item(category_id1,category_id2,category_id3,spu_id,sku_id,order_id,name,price,num,money,pay_money,image,weight,post_fee,is_return) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {orderItemEntity.getCategoryId1(), orderItemEntity.getCategoryId2(), orderItemEntity.getCategoryId3(),
                orderItemEntity.getSpuId(), orderItemEntity.getSkuId(), orderItemEntity.getOrderId(), orderItemEntity.getName(),
                orderItemEntity.getPrice(), orderItemEntity.getNum(), orderItemEntity.getMoney(), orderItemEntity.getImage(),
                orderItemEntity.getWeight(), orderItemEntity.getPostFee(), orderItemEntity.getIsReturn()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 查找所有的订单详细
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select category_id1 as categoryId1 , category_id2 as categoryId2 , category_id3 as categoryId3 , spu_id as spuId, sku_id as skuId , order_id as orderId , name ,price, num, money, pay_money as payMoney ,image,weight, post_fee as postFee , is_return as  isReturn      from wx_tab_order_item";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public OrderItemEntity findById(int id) {
        OrderItemEntity orderItemEntity = null;
        String exeSQL = "select  category_id1 as categoryId1 , category_id2 as categoryId2 , category_id3 as categoryId3 , spu_id as spuId, sku_id as skuId , order_id as orderId , name ,price, num, money, pay_money as payMoney ,image,weight, post_fee as postFee , is_return as  isReturn from wx_tab_order_item where id=?";
        List<OrderItemEntity> orderItemEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<OrderItemEntity>(OrderItemEntity.class));
        if (null != orderItemEntities && orderItemEntities.size() > 0) {
            orderItemEntity = orderItemEntities.get(0);
        }
        return orderItemEntity;
    }

    @Override
    public int update(OrderItemEntity orderItemEntity) {
        String exeSQL = "update wx_tab_order_item set category_id1=? ,category_id2=?,category_id3=?,spu_id=?,sku_id=?,order_id=?,name=?, price=?,num=?,money=?,pay_money=?," +
                "image=?,weight=?,post_fee=?,is_return=?  WHERE id=?";
        Object args[] = {orderItemEntity.getCategoryId1(), orderItemEntity.getCategoryId2(), orderItemEntity.getCategoryId3(), orderItemEntity.getSpuId(),
                orderItemEntity.getSkuId(), orderItemEntity.getOrderId(), orderItemEntity.getName(), orderItemEntity.getPrice(), orderItemEntity.getNum(), orderItemEntity.getMoney(),
                orderItemEntity.getImage(), orderItemEntity.getWeight(), orderItemEntity.getPostFee(), orderItemEntity.getIsReturn(),orderItemEntity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_order_item WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }

}
