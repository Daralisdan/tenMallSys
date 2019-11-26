package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IOrderDao;
import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.entity.order.RefundCauseEntity;
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

    @Override
    public List<Map<String, Object>> list(int page, int size) {
        String exeSQL = "select * from wx_tab_order limit " + (page - 1) * size + " , " + size;
        List<Map<String, Object>> listzhu = jdbcTemplate.queryForList(exeSQL);
        List<Map<String, Object>> listss=new ArrayList();
        for(Map<String, Object> sss:listzhu){
            String exeSQLitem = "select * from wx_tab_order_item limit " + (page - 1) * size + " , " + size;sss.get("id");
            List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQLitem);
            Map<String, Object> map=new HashMap<>();
            map.put("",sss);
            map.put("sublist",list);
            listss.add(map);
        }
        return listss;
    }

    @Override
    public List<Map<String, Object>> batchlist(String ids) {
//        Map<String, Object> map;


        String sql = "select * from wx_tab_order where id in" + "(" + ids + ")";
//        String exeSQL = "select * from wx_tab_order limit " + (page - 1) * size + " , " + size;
        List<Map<String, Object>> listzhu = jdbcTemplate.queryForList(sql);
        List<Map<String, Object>> listss=new ArrayList();
        for(Map<String, Object> sss:listzhu){

            String sql2 = "select * from wx_tab_order_item where id =" + "(" + sss.get("id") + ")";
//            sss.get("id");
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql2);
            Map<String, Object> map=new HashMap<>();
            map.put("",sss);
            map.put("sublist",list);
            listss.add(map);
        }
        return listss;
    }


    @Override
    public OrderEntity findById(int id) {
        OrderEntity orderEntity = null;
        String exeSQL = "select * from wx_tab_order where id=?";
        List<OrderEntity> orderEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<OrderEntity>(OrderEntity.class));
        if (null != orderEntities && orderEntities.size() > 0) {
            orderEntity = orderEntities.get(0);
        }
        return orderEntity;
    }

    @Override
    public OrderLogEntity findByOrderId(int orderId) {
        OrderLogEntity orderLogEntity = null;
        String exeSQL = "select * from wx_tab_order where id=?";
        List<OrderLogEntity> orderLogEntities = jdbcTemplate.query(exeSQL, new Object[]{orderId}, new BeanPropertyRowMapper<OrderLogEntity>(OrderLogEntity.class));
        if (null != orderLogEntity && orderLogEntities.size() > 0) {
            orderLogEntity = orderLogEntities.get(0);
        }
        return orderLogEntity;
    }

    @Override
    public int update(RefundCauseEntity refundCauseEntity) {
        String sql1 = "";
        String sql2 = "";
        Object args1[] = {refundCauseEntity.getStatus(), UtilsHelper.formatDateTimer(new Date()), refundCauseEntity.getId()};
//        Object args2[] = {refundCauseEntity.getStatus(), UtilsHelper.formatDateTimer(new Date()), "驳回理由：sss", refundCauseEntity.getId()};

        sql1 = "update wx_tab_return_order set status=? set dispose_time=? where id=?";
        int temp1 = jdbcTemplate.update(sql1, args1);
//            sql2 = "update wx_tab_return_order set status=? set dispose_time=? set remark=? where id=?";

//        System.out.println("错误的订单申请状态");

//        String sql3 = "insert into  wx_tab_order_log ()";

//        int temp2 = jdbcTemplate.update(sql2, args2);

        return temp1;
    }


    @Override
    public int batchSendSubmit(int orderId) {
        String exeSQL = "INSERT INTO wx_tab_order_log (operate,operate_time,order_id,order_status,pay_status,consign_status,remarks) values(?,?,?,?,?,?,?)";
        Object args[] = {"1", UtilsHelper.formatDateTimer(new Date()), orderId, "1", "1", "1", "aaa"};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public List<Map<String, Object>> refundList(int page, int size) {

        String exeSQL = "select * from wx_tab_return_order limit " + (page - 1) * size + " , " + size;

//        map=jdbcTemplate.queryForMap(exeSQL,);

        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);


        return list;
    }


}
