package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IOrderDao;
import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.utils.utils.UtilsHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.*;

@Slf4j
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
        String exeSQL = "INSERT INTO wx_tab_order( total_num,total_money,pre_money,post_fee,pay_money,pay_type,create_time,update_time,pay_time,consign_time,end_time,close_time,shipping_name,shipping_code," +
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
                "                              create_time as createTime,  update_time as updateTime, pay_time as payTime,  consign_time as consignTime, end_time  as endTime  , close_time as closeTime , shipping_name as  shippingName," +
                "                                shipping_code as shippingCode ,username, buyer_message as  buyerMessage,  buyer_rate as buyerRate , receiver_contact as  receiverContact," +
                "                                   receiver_mobile as receiverMobile  ,  receiver_address as receiverAddress ,  source_type as sourceType ,  transaction_id as transactionId ," +
                "                                order_status as orderStatus ,  pay_status as  payStatus, consign_status as consignStatus , is_delete as isDelete   from wx_tab_order";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    /**
     * 根据page和size分页查询所有订单主表以及详细表
     *
     * @param orderEntity
     * @param page
     * @param orderEntity
     * @return
     */
    @Override
    public Map<String, Object> list(int page, int size, OrderEntity orderEntity) {
        StringBuffer sql = getQuerySql(orderEntity);
        sql.append("    ORDER BY id ASC LIMIT  " + (page - 1) * size + " , " + size);
        String exeSQL = sql.toString();
//        String exeSQL = "select id, total_num as totalNum , total_money as totalMoney ,  pre_money as preMoney,  post_fee as postFee, pay_money as payMoney, pay_type as payType," +
//                "                 create_time as createTime,  update_time as updateTime, pay_time as payTime,  consign_time as consignTime, end_time  as endTime  , close_time as closeTime , shipping_name as  shippingName," +
//                "                  shipping_code as shippingCode ,username, buyer_message as  buyerMessage,  buyer_rate as buyerRate , receiver_contact as  receiverContact," +
//                "                   receiver_mobile as receiverMobile  ,  receiver_address as receiverAddress ,  source_type as sourceType ,  transaction_id as transactionId ," +
//                "                  order_status as orderStatus ,  pay_status as  payStatus, consign_status as consignStatus , is_delete as isDelete  from wx_tab_order " +
//
//
//                "limit " + (page - 1) * size + " , " + size;
        List<Map<String, Object>> listzhu = jdbcTemplate.queryForList(exeSQL);
        List<Map<String, Object>> listss = new ArrayList();
        Map<String, Object> map = new LinkedHashMap<>();
        for (Map<String, Object> sss : listzhu) {
            String sql2 = "select id, category_id1 as categoryId1 , category_id2 as categoryId2, category_id3 as categoryId3 , spu_id as spuId , sku_id as skuId , order_id as orderId, name ,price, num, money, pay_money as payMoney,image,weight, post_fee as postFee , is_return as isReturn from wx_tab_order_item where order_id = " + sss.get("id");
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql2);

            sss.put("sublist", list);
            listss.add(sss);
        }
        map.put("rows", listss);
        return map;
    }

    /**
     * 根据ids查询所有待发货订单主表以及主表对应的详细表
     *
     * @return
     */
    @Override
    public Map<String, Object> batchlist() {
//        Map<String, Object> map;
        String sql = "select id, total_num as totalNum , total_money as totalMoney ,  pre_money as preMoney,  post_fee as postFee, pay_money as payMoney, pay_type as payType," +
                "                DATE_FORMAT(create_time,'%Y-%m-%d %H:%i:%s') as createTime,  DATE_FORMAT(update_time,'%Y-%m-%d %H:%i:%s') as updateTime,  DATE_FORMAT(pay_time,'%Y-%m-%d %H:%i:%s') as payTime,   " +
                "                DATE_FORMAT(consign_time,'%Y-%m-%d %H:%i:%s') as consignTime , DATE_FORMAT(end_time,'%Y-%m-%d %H:%i:%s')  as endTime  ,DATE_FORMAT(close_time,'%Y-%m-%d %H:%i:%s')  as closeTime , shipping_name as  shippingName," +
                "                shipping_code as shippingCode ,username, buyer_message as  buyerMessage,  buyer_rate as buyerRate , receiver_contact as  receiverContact," +
                "                receiver_mobile as receiverMobile  ,  receiver_address as receiverAddress ,  source_type as sourceType ,  transaction_id as transactionId ," +
                "                order_status as orderStatus ,  pay_status as  payStatus, consign_status as consignStatus , is_delete as isDelete from wx_tab_order where order_status='1'";
//        String exeSQL = "select * from wx_tab_order limit " + (page - 1) * size + " , " + size;
        List<Map<String, Object>> listzhu = jdbcTemplate.queryForList(sql);
        List<Map<String, Object>> listss = new ArrayList();
        Map<String, Object> map = new LinkedHashMap<>();
//        List<Map<String, Object>> listsss = new ArrayList();
        for (Map<String, Object> sss : listzhu) {

            String sql2 = "select id, category_id1 as categoryId1 , category_id2 as categoryId2, category_id3 as categoryId3 , spu_id as spuId , sku_id as skuId , order_id as orderId, name ,price, num, money, pay_money as payMoney,image,weight, post_fee as postFee , is_return as isReturn from wx_tab_order_item where order_id = " + sss.get("id");
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql2);

            sss.put("sublist", list);
            listss.add(sss);
        }

        map.put("rows", listss);
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
                "                          DATE_FORMAT(create_time,'%Y-%m-%d %H:%i:%s') as createTime,  DATE_FORMAT(update_time,'%Y-%m-%d %H:%i:%s') as updateTime,  DATE_FORMAT(pay_time,'%Y-%m-%d %H:%i:%s') as payTime,   DATE_FORMAT(consign_time,'%Y-%m-%d %H:%i:%s') as consignTime, DATE_FORMAT(end_time,'%Y-%m-%d %H:%i:%s')  as endTime  , DATE_FORMAT(close_time,'%Y-%m-%d %H:%i:%s')  as closeTime , shipping_name as  shippingName," +
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
        return jdbcTemplate.update(exeSQL);
    }

    @Override
    public void update() {
        String exeSQL1 = "select * from wx_tab_order where order_status ='0' and (now()-create_time)>48 ";
        List<Map<String, Object>> listzhu = jdbcTemplate.queryForList(exeSQL1);
        for (Map<String, Object> sss : listzhu) {
            String exeSQL = "update wx_tab_order set order_status='4' where id=" + sss.get("id");
            jdbcTemplate.update(exeSQL);
        }

    }

    /**
     * 批量发货提交并记录发货日志
     *
     * @param id
     * @param orderId
     * @param shippingName
     * @param shippingCode
     * @return
     */
    @Override
    public int batchSendSubmit(int id, Object orderId, Object shippingName, Object shippingCode) {
        String exeSQL2 = "update wx_tab_order set shipping_name=? ,shipping_code=?,order_status=?,consign_status=? where id=?";
        String exeSQL = "INSERT INTO wx_tab_order_log (operate,operate_time,order_id,order_status,pay_status,consign_status,remarks) values(?,?,?,?,?,?,?)";
//        Object args[] = {"1", UtilsHelper.formatDateTimer(new Date()), orderId, "1", "1", "1", "aaa"};
        Object args[] = {"1",UtilsHelper.formatDateTimer(new Date()), orderId, "1", "1", "1", "aaa"};
        int tempX = jdbcTemplate.update(exeSQL, args);

        Object args2[] = {shippingName, shippingCode, "2", "1", id};
//        jdbcTemplate.update(exeSQL2);
        int temp =jdbcTemplate.update(exeSQL2, args2);
        return temp;
    }

    /**
     * @return
     */
    @Override
    public Map<String, Object> item(int id) {
//        Map<String, Object> map;
        String sql = "select id, total_num as totalNum , total_money as totalMoney ,  pre_money as preMoney,  post_fee as postFee, pay_money as payMoney, pay_type as payType," +
                "                DATE_FORMAT(create_time,'%Y-%m-%d %H:%i:%s') as createTime,  DATE_FORMAT(update_time,'%Y-%m-%d %H:%i:%s') as updateTime,  DATE_FORMAT(pay_time,'%Y-%m-%d %H:%i:%s') as payTime,   " +
                "                DATE_FORMAT(consign_time,'%Y-%m-%d %H:%i:%s') as consignTime , DATE_FORMAT(end_time,'%Y-%m-%d %H:%i:%s')  as endTime  ,DATE_FORMAT(close_time,'%Y-%m-%d %H:%i:%s')  as closeTime , shipping_name as  shippingName," +
                "                shipping_code as shippingCode ,username, buyer_message as  buyerMessage,  buyer_rate as buyerRate , receiver_contact as  receiverContact," +
                "                receiver_mobile as receiverMobile  ,  receiver_address as receiverAddress ,  source_type as sourceType ,  transaction_id as transactionId ," +
                "                order_status as orderStatus ,  pay_status as  payStatus, consign_status as consignStatus , is_delete as isDelete from wx_tab_order where id="+id;
//        String exeSQL = "select * from wx_tab_order limit " + (page - 1) * size + " , " + size;
        List<Map<String, Object>> listzhu = jdbcTemplate.queryForList(sql);
        List<Map<String, Object>> listss = new ArrayList();
        Map<String, Object> map = new LinkedHashMap<>();
//        List<Map<String, Object>> listsss = new ArrayList();
        for (Map<String, Object> sss : listzhu) {

            String sql2 = "select id, category_id1 as categoryId1 , category_id2 as categoryId2, category_id3 as categoryId3 , spu_id as spuId , sku_id as skuId , order_id as orderId, name ,price, num, money, pay_money as payMoney,image,weight, post_fee as postFee , is_return as isReturn from wx_tab_order_item where order_id = " + sss.get("id");
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql2);

            sss.put("sublist", list);
            listss.add(sss);
        }

        map.put("rows", listss);
        return map;
    }

    /**
     * 【统计查询数据库所有数据】
     *
     * @return
     */
    @Override
    public int countAll() {
        String sql = "select * from wx_tab_order";
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query(sql, countCallback);
        int count = countCallback.getRowCount();
        System.out.println("目前的总条数是" + count);
        return count;
    }

    /**
     * 【提取公共方法】条件查询
     *
     * @param orderEntity
     * @return
     */
    private StringBuffer getQuerySql(OrderEntity orderEntity) {
        StringBuffer sql = new StringBuffer();
        sql.append("select id, total_num as totalNum , total_money as totalMoney ,  pre_money as preMoney,  post_fee as postFee, pay_money as payMoney, pay_type as payType," +
                " create_time as createTime,  update_time as updateTime, pay_time as payTime,  consign_time as consignTime, end_time  as endTime  , close_time as closeTime , shipping_name as  shippingName," +
                " shipping_code as shippingCode ,username, buyer_message as  buyerMessage,  buyer_rate as buyerRate , receiver_contact as  receiverContact," +
                "                                  receiver_mobile as receiverMobile  ,  receiver_address as receiverAddress ,  source_type as sourceType ,  transaction_id as transactionId ," +
                "                                 order_status as orderStatus ,  pay_status as  payStatus, consign_status as consignStatus , is_delete as isDelete  from wx_tab_order WHERE 1=1");
        if (!StringUtils.isEmpty(orderEntity.getUsername())) {
            sql.append("    AND username='" + orderEntity.getUsername() + "'");
        }
        if (!StringUtils.isEmpty(orderEntity.getOrderStatus())) {
            sql.append("    AND order_status='" + orderEntity.getOrderStatus() + "'");
        }
        if (!StringUtils.isEmpty(orderEntity.getCreateTime()) && !StringUtils.isEmpty(orderEntity.getEndTime())) {
            sql.append("    AND create_time between '" + orderEntity.getCreateTime() + "' and '" + orderEntity.getEndTime() + "'");
        }
        if (!StringUtils.isEmpty(orderEntity.getCreateTime())) {
            sql.append("    AND create_time > '" + orderEntity.getCreateTime() + "'");
        }
        if (!StringUtils.isEmpty(orderEntity.getEndTime())) {
            sql.append("    AND end_time < '" + orderEntity.getEndTime() + "'");
        }


//        if (!StringUtils.isEmpty(brandEntity.getLetter())) {
//            sql.append("    AND letter='" + brandEntity.getLetter() + "'");
//        }
//        if (!StringUtils.isEmpty(brandEntity.getSeq()) && brandEntity.getSeq() != 0) {
//            sql.append("    AND seq=" + brandEntity.getSeq());
//        }
        return sql;
    }
}



