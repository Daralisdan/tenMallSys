package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IOrderDao;
import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.entity.utils.UtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class IOrderDaoImpl implements IOrderDao {
//    @Autowired
//    private JdbcTemplate jdbcTemplateSentence;
//
//    //    @Override
////    public List<Map<String, Object>> list(int page, int size) {
////        List<Map<String, Object>> list;
////        String exeSQL = "select * from wx_tab_order limit " + (page - 1) * size + " , " + size;
////        String exeSQLitem = "select * from wx_tab_order_item limit " + (page - 1) * size + " , " + size;
////        List<Map<String, Object>> listitem = jdbcTemplateSentence.queryForList(exeSQLitem);
////        list = jdbcTemplateSentence.queryForList(exeSQL);
////
////        return list;
//
//
//
//    @Override
//    public  Map<String, Object> list(int page, int size) {
//        Map<String, Object> map ;
//        String exeSQL = "select * from wx_tab_order limit " + (page - 1) * size + " , " + size;
//        String exeSQLitem = "select * from wx_tab_order_item limit " + (page - 1) * size + " , " + size;
//        List<Map<String, Object>> list = jdbcTemplateSentence.queryForList(exeSQLitem);
//        List<Map<String, Object>> list2 = jdbcTemplateSentence.queryForList(exeSQL);
//        map=jdbcTemplateSentence.queryForMap(exeSQL);
//
//        map.put("sublist",list);
////        list2.(list);
//        return map;
//    }
//
//    @Override
//    public List<Map<String, Object>> batchlist(String ids) {
//        Map<String, Object> map ;
////        System.out.println(idss);
////        int id = Integer.parseInt(idss);
//
//        String sql = "select * from wx_tab_order where id in" + "(" + ids + ")";
//        List<Map<String, Object>> list = null;
////        for (int i = 0; i <idss.length; ++i) {
////            int id = Integer.parseInt(idss[i]);
//////            if (i <idss.length-1){
//////                String sql1= " id=" +id +" or";
//////                sql=sql+sql1;
//////
//////            }else {
//////                String sql2= " id=" +id;
//////                sql=sql+sql2;
//////            }
////
////        }
//        List<Map<String, Object>> list2 = jdbcTemplateSentence.queryForList(sql);
//        return list2;
//    }
//
//
//    @Override
//    public OrderEntity findById(int id) {
//        OrderEntity orderEntity = null;
//        String exeSQL = "select * from wx_tab_order where id=?";
//        List<OrderEntity> orderEntities = jdbcTemplateSentence.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<OrderEntity>(OrderEntity.class));
//        if (null != orderEntities && orderEntities.size() > 0) {
//            orderEntity = orderEntities.get(0);
//        }
//        return orderEntity;
//    }
//
//    @Override
//    public int batchSendSubmit(OrderLogEntity orderLogEntity) {
//        String exeSQL = "INSERT INTO wx_tab_order_log (operate,operate_time,order_id,order_status,pay_status,consign_status,remarks) values(?,?,?,?,?,?,?)";
//        Object args[] = {"1", UtilsHelper.formatDateTimer(new Date()),orderLogEntity.getOrder_id(),"1","1","1","aaa"};
//        int temp = jdbcTemplateSentence.update(exeSQL, args);
//        return temp;
//    }
//


}
