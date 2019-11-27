package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IOrderDao;
import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.utils.utils.UtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class IOrderDaoImpl implements IOrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加订单主表
     *
     * @param orderEntity
     * @return
     */
    @Override
    public int insert(OrderEntity orderEntity) {
        String exeSQL = "INSERT INTO wx_tab_order(total_num,total_money,pre_money,post_fee,pay_money,pay_type,create_time,update_time,num,money,pay_money,pay_time,consign_time,end_time,close_time,shipping_name,shipping_code," +
                "username,buyer_message,buyer_rate,receiver_contact,receiver_mobile,receiver_address,source_type,transaction_id,order_status,pay_status,consign_status,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {orderEntity.getTotalNum(), orderEntity.getTotalMoney(), orderEntity.getPreMoney(), orderEntity.getPostFee(), orderEntity.getPayMoney(), orderEntity.getPayType(), orderEntity.getCreateTime(), orderEntity.getUpdateTime(),
                orderEntity.getPayTime(), orderEntity.getConsignTime(), orderEntity.getEndTime(), orderEntity.getCloseTime(), orderEntity.getShippingName(), orderEntity.getShippingCode(),
                orderEntity.getUsername(), orderEntity.getBuyerMessage(), orderEntity.getBuyerRate(), orderEntity.getReceiverContact(), orderEntity.getReceiverMobile(), orderEntity.getReceiverAddress(),
                orderEntity.getSourceType(), orderEntity.getTransactionId(), orderEntity.getOrderStatus(), orderEntity.getPayStatus(), orderEntity.getConsignStatus(), orderEntity.getIsDelete()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 查找所有的订单主表
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select id, total_num as totalNum , total_money as totalMoney ,  pre_money as preMoney,  post_fee as postFee, pay_money as payMoney, pay_type as payType," +
                "                              create_time as createTime,  DATE_FORMAT(update_time,'%Y-%m-%d %H:%i:%s') as updateTime, pay_time as payTime,  consign_time as consignTime, end_time  as endTime  , close_time as closeTime , shipping_name as  shippingName," +
                "                                shipping_code as shippingCode ,username, buyer_message as  buyerMessage,  buyer_rate as buyerRate , receiver_contact as  receiverContact," +
                "                                   receiver_mobile as receiverMobile  ,  receiver_address as receiverAddress ,  source_type as sourceType ,  transaction_id as transactionId ," +
                "                                order_status as orderStatus ,  pay_status as  payStatus, consign_status as consignStatus , is_delete as isDelete   from wx_tab_order";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    /**
     * 根据page和size分页查询所有订单主表以及详细表
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Map<String, Object> list(int page, int size) {
        String exeSQL = "select id, total_num as totalNum , total_money as totalMoney ,  pre_money as preMoney,  post_fee as postFee, pay_money as payMoney, pay_type as payType," +
                "                 create_time as createTime,  update_time as updateTime, pay_time as payTime,  consign_time as consignTime, end_time  as endTime  , close_time as closeTime , shipping_name as  shippingName," +
                "                  shipping_code as shippingCode ,username, buyer_message as  buyerMessage,  buyer_rate as buyerRate , receiver_contact as  receiverContact," +
                "                   receiver_mobile as receiverMobile  ,  receiver_address as receiverAddress ,  source_type as sourceType ,  transaction_id as transactionId ," +
                "                  order_status as orderStatus ,  pay_status as  payStatus, consign_status as consignStatus , is_delete as isDelete  from wx_tab_order " +

                

                "limit " + (page - 1) * size + " , " + size;
        List<Map<String, Object>> listzhu = jdbcTemplate.queryForList(exeSQL);
        List<Map<String, Object>> listss = new ArrayList();
        Map<String, Object> map = new LinkedHashMap<>();
        for (Map<String, Object> sss : listzhu) {
            String sql2 = "select id, category_id1 as categoryId1 , category_id2 as categoryId2, category_id3 as categoryId3 , spu_id as spuId , sku_id as skuId , order_id as orderId, name ,price, num, money, pay_money as payMoney,image,weight, post_fee as postFee , is_return as isReturn from wx_tab_order_item where order_id = " +sss.get("id");
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql2);

            sss.put("sublist", list);
            listss.add(sss);
        }
        map.put("rows",listss);
        return map;
    }

    /**
     * 根据ids查询所有待发货订单主表以及主表对应的详细表
     *
     * @param ids
     * @return
     */
    @Override
    public Map<String, Object> batchlist(String ids) {
//        Map<String, Object> map;
        String sql = "select id, total_num as totalNum , total_money as totalMoney ,  pre_money as preMoney,  post_fee as postFee, pay_money as payMoney, pay_type as payType," +
                "                create_time as createTime,  update_time as updateTime, pay_time as payTime,  consign_time as consignTime, end_time  as endTime  , close_time as closeTime , shipping_name as  shippingName," +
                "                shipping_code as shippingCode ,username, buyer_message as  buyerMessage,  buyer_rate as buyerRate , receiver_contact as  receiverContact," +
                "                receiver_mobile as receiverMobile  ,  receiver_address as receiverAddress ,  source_type as sourceType ,  transaction_id as transactionId ," +
                "  order_status as orderStatus ,  pay_status as  payStatus, consign_status as consignStatus , is_delete as isDelete from wx_tab_order where id in" + "(" + ids + ")";
//        String exeSQL = "select * from wx_tab_order limit " + (page - 1) * size + " , " + size;
        List<Map<String, Object>> listzhu = jdbcTemplate.queryForList(sql);
        List<Map<String, Object>> listss = new ArrayList();
        Map<String, Object> map = new LinkedHashMap<>();
//        List<Map<String, Object>> listsss = new ArrayList();
        for (Map<String, Object> sss : listzhu) {

            String sql2 = "select id, category_id1 as categoryId1 , category_id2 as categoryId2, category_id3 as categoryId3 , spu_id as spuId , sku_id as skuId , order_id as orderId, name ,price, num, money, pay_money as payMoney,image,weight, post_fee as postFee , is_return as isReturn from wx_tab_order_item where order_id = " +sss.get("id");
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql2);

            sss.put("sublist", list);
            listss.add(sss);
        }

        map.put("rows",listss);
        return map;
    }

    /**
     * 根据详细id查询订单主表
     *
     * @param id
     * @return
     */
    @Override
    public OrderEntity findById(int id) {
        OrderEntity orderEntity = null;
        String exeSQL = "select id, total_num as totalNum , total_money as totalMoney ,  pre_money as preMoney,  post_fee as postFee, pay_money as payMoney, pay_type as payType," +
                "                         create_time as createTime,  update_time as updateTime, pay_time as payTime,  consign_time as consignTime, end_time  as endTime  , close_time as closeTime , shipping_name as  shippingName," +
                "                              shipping_code as shippingCode ,username, buyer_message as  buyerMessage,  buyer_rate as buyerRate , receiver_contact as  receiverContact," +
                "                                receiver_mobile as receiverMobile  ,  receiver_address as receiverAddress ,  source_type as sourceType ,  transaction_id as transactionId ," +
                "                                order_status as orderStatus ,  pay_status as  payStatus, consign_status as consignStatus , is_delete as isDelete from wx_tab_order where id=?";
        List<OrderEntity> orderEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<OrderEntity>(OrderEntity.class));
        if (null != orderEntities && orderEntities.size() > 0) {
            orderEntity = orderEntities.get(0);
        }
        return orderEntity;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_order WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }


    /**
     * 批量发货提交并记录发货日志
     *
     * @param orderId
     * @return
     */

    @Override
    public int batchSendSubmit(int orderId) {
        String exeSQL = "INSERT INTO wx_tab_order_log (operate,operate_time,order_id,order_status,pay_status,consign_status,remarks) values(?,?,?,?,?,?,?)";
        Object args[] = {"1", UtilsHelper.formatDateTimer(new Date()), orderId, "1", "1", "1", "aaa"};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }


}
