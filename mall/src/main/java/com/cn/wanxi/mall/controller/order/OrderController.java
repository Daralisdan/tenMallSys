package com.cn.wanxi.mall.controller.order;

import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.entity.utils.UtilsHelper;
import com.cn.wanxi.utils.JDBC;

import io.swagger.models.auth.In;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 【订单管理】
 * 数据表 ：wx_tab_order 表（订单主表）
 * wx_tab_order_item 表（订单明细表）
 * wx_tab_order_log 表（订单日志）
 * wx_tab_return_cause 表（退货退款原因表）
 * wx_tab_return_order 表 （退货退款申请表）
 * wx_tab_return_order_item （退货退款申请明细表）
 * wx_tab_order_config （订单设置表）
 * <p>
 * 2019/11/18,Create by yaodan
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    //    private OrderService service;

    //        @RequestMapping(value = "/list.do", method = RequestMethod.POST)
//    public String insert(HttpServletRequest request, HttpServletResponse response) {
//
//        response.setHeader("Access-Control-Allow-Origin", "*");
////        Integer.parseInt( request.getParameter("total_num"));
////        System.out.println(aa);
////        service =new OrderServiceImpl();
//
//            OrderEntity entity = new OrderEntity();
//
////        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//        entity.setTotal_num(Integer.parseInt(request.getParameter("total_num")));
//        System.out.println(request.getParameter("total_num"));
//        entity.setTotal_money(Integer.parseInt(request.getParameter("total_money")));
//        entity.setPre_money(Integer.parseInt(request.getParameter("pre_money")));
//        entity.setPost_fee(Integer.parseInt(request.getParameter("post_fee")));
//        entity.setPay_money(Integer.parseInt(request.getParameter("pay_money")));
//        entity.setPay_type(request.getParameter("pay_type"));
//        UtilsHelper helper=new UtilsHelper();
//
//        String timeTemp1 = request.getParameter("create_time");
//        String timeTemp2 = request.getParameter("update_time");
//        String timeTemp3 = request.getParameter("pay_time");
//        String timeTemp4 = request.getParameter("consign_time");
//        String timeTemp5 = request.getParameter("end_time");
//        String timeTemp6 = request.getParameter("close_time");
//        String timeTempX = timeTemp1.substring(0,24);
//        String newDate1 = UtilsHelper.formatDateTimer(timeTemp1);
//        String newDate2= UtilsHelper.formatDateTimer(timeTemp2);
//        String newDate3 = UtilsHelper.formatDateTimer(timeTemp3);
//        String newDate4 = UtilsHelper.formatDateTimer(timeTemp4);
//        String newDate5 = UtilsHelper.formatDateTimer(timeTemp5);
//        String newDate6 = UtilsHelper.formatDateTimer(timeTemp6);
//        entity.setCreate_time(newDate1);
//        entity.setUpdate_time(newDate2);
//        entity.setPay_time(newDate3);
//        entity.setConsign_time(newDate4);
//        entity.setEnd_time(newDate5);
//        entity.setClose_time(newDate6);
//
//        entity.setShipping_name(request.getParameter("shipping_name"));
//        entity.setShipping_code(request.getParameter("shipping_code"));
//        entity.setUsername(request.getParameter("username"));
//        entity.setBuyer_message(request.getParameter("buyer_message"));
//        entity.setBuyer_rate(request.getParameter("buyer_rate"));
//        entity.setReceiver_contact(request.getParameter("receiver_contact"));
//        entity.setReceiver_mobile(request.getParameter("receiver_mobile"));
//        entity.setReceiver_address(request.getParameter("receiver_address"));
//        entity.setSource_type(request.getParameter("source_type"));
//        System.out.println(request.getParameter("transaction_id"));
//        entity.setTransaction_id(Integer.parseInt(request.getParameter("transaction_id")));
//
//        entity.setOrder_status(request.getParameter("order_status"));
//        entity.setPay_status(request.getParameter("pay_status"));
//        entity.setConsign_status(request.getParameter("consign_status"));
//        entity.setIs_delete(request.getParameter("is_delete"));
//
//        String sql = "insert into wx_tab_order (total_num,total_money,pre_money,post_fee,pay_money,pay_type,create_time,update_time,pay_time,consign_time,end_time,close_time,shipping_name,shipping_code,username,buyer_message,buyer_rate,receiver_contact,receiver_mobile,receiver_address,source_type,transaction_id,order_status,pay_status,consign_status,is_delete)\n" +
//                "values(" + entity.getTotal_num() + "," + entity.getTotal_money() + "," + entity.getPre_money() + "," + entity.getPost_fee() + "," + entity.getPay_money() + ",'" + entity.getPay_type() + "','" + entity.getCreate_time() + "','" + entity.getUpdate_time() + "','" + entity.getPay_time() + "','" + entity.getConsign_time() + "','" + entity.getEnd_time() + "','" + entity.getClose_time() + "','" + entity.getShipping_name() + "','" + entity.getShipping_code() + "','" + entity.getUsername() + "','" + entity.getBuyer_message() + "','" + entity.getBuyer_rate() + "','" + entity.getReceiver_contact() + "','" + entity.getReceiver_mobile() + "','" + entity.getReceiver_address() + "','" + entity.getSource_type() + "','" + entity.getTransaction_id() + "','" + entity.getOrder_status() + "','" + entity.getPay_status() + "','" + entity.getConsign_status() + "','" + entity.getIs_delete() + "');";
//
//
//        JDBC.update(sql);
//
////        return aa;
//    return "1";
//    }
    @RequestMapping(value = "/list.do", method = RequestMethod.POST)
    public List<OrderEntity> select(HttpServletRequest request, HttpServletResponse response) {
        OrderEntity entity = null;
        OrderItemEntity entityitem = null;
        List<OrderEntity> list = new ArrayList<>();
        List<OrderItemEntity> list1 = new ArrayList<>();
        response.setHeader("Access-Control-Allow-Origin", "*");
        Integer.parseInt(request.getParameter("page"));
        Integer.parseInt(request.getParameter("size"));
//        int id = Integer.parseInt(request.getParameter("id"));
        String sql1 = "select *  from wx_tab_order  limit " + (Integer.parseInt(request.getParameter("page")) - 1) * Integer.parseInt(request.getParameter("size")) + "," + Integer.parseInt(request.getParameter("size")) + "";
        String sql2 = "select *  from wx_tab_order_item limit " + (Integer.parseInt(request.getParameter("page")) - 1) * Integer.parseInt(request.getParameter("size")) + "," + Integer.parseInt(request.getParameter("size")) + " ";

        ResultSet query1 = JDBC.query(sql1);
        ResultSet query2 = JDBC.query(sql2);

        try {
            while (query1.next()) {
                while (query2.next()) {
                    entityitem = new OrderItemEntity();

                    entityitem.setId(query2.getInt("id"));
                    entityitem.setCategory_id1(query2.getInt("category_id1"));
                    entityitem.setCategory_id2(query2.getInt("category_id2"));
                    entityitem.setCategory_id3(query2.getInt("category_id3"));
                    entityitem.setSpu_id(query2.getInt("spu_id"));
                    entityitem.setSku_id(query2.getInt("sku_id"));
                    entityitem.setOrder_id(query2.getInt("order_id"));
                    entityitem.setName(query2.getString("name"));
                    entityitem.setPrice(query2.getInt("price"));
                    entityitem.setNum(query2.getInt("num"));
                    entityitem.setMoney(query2.getInt("money"));
                    entityitem.setPay_money(query2.getInt("pay_money"));
                    entityitem.setImage(query2.getString("image"));
                    entityitem.setWeight(query2.getInt("weight"));
                    entityitem.setPost_fee(query2.getInt("post_fee"));
                    entityitem.setIs_return(query2.getInt("is_return"));
                    list1.add(entityitem);
                }

                entity = new OrderEntity();
                entity.setId(query1.getInt("id"));
                entity.setTotal_num(query1.getInt("total_num"));
                entity.setTotal_money(query1.getInt("total_money"));
                entity.setPre_money(query1.getInt("pre_money"));
                entity.setPost_fee(query1.getInt("post_fee"));
                entity.setPay_money(query1.getInt("pay_money"));
                entity.setPay_type(query1.getString("pay_type"));
                entity.setCreate_time(query1.getString("create_time"));
                entity.setUpdate_time(query1.getString("update_time"));
                entity.setPay_time(query1.getString("pay_time"));
                entity.setConsign_time(query1.getString("consign_time"));
                entity.setEnd_time(query1.getString("end_time"));
                entity.setClose_time(query1.getString("close_time"));
                entity.setShipping_name(query1.getString("shipping_name"));
                entity.setShipping_name(query1.getString("shipping_code"));
                entity.setUsername(query1.getString("username"));
                entity.setBuyer_message(query1.getString("buyer_message"));
                entity.setBuyer_rate(query1.getString("buyer_rate"));
                entity.setReceiver_contact(query1.getString("receiver_contact"));
                entity.setReceiver_mobile(query1.getString("receiver_mobile"));
                entity.setReceiver_address(query1.getString("receiver_address"));
                entity.setSource_type(query1.getString("source_type"));
                entity.setTransaction_id(query1.getInt("transaction_id"));
                entity.setOrder_status(query1.getString("order_status"));
                entity.setPay_status(query1.getString("pay_status"));
                entity.setConsign_status(query1.getString("consign_status"));
                entity.setIs_delete(query1.getString("is_delete"));
                entity.setSublist(entityitem);
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return list;


    }



    @RequestMapping(value = "/batchlist.do", method = RequestMethod.POST)
    public List<OrderEntity> selectbatchlist(HttpServletRequest request, HttpServletResponse response) {
        OrderEntity entity = null;
        OrderItemEntity entityitem = null;
        response.setHeader("Access-Control-Allow-Origin", "*");
        String idss = request.getParameter("ids");
        System.out.println(idss);
        String[] ids = idss.split(",");
        System.out.println(ids);
        List<OrderEntity> list = new ArrayList<>();
        List<OrderItemEntity> list1 = new ArrayList<>();

        for (int i = 0; i < ids.length; i++) {
            int id = Integer.parseInt(ids[i]);
            String sql1 = "select *  from wx_tab_order where id= " + id + "";
            String sql2 = "select *  from wx_tab_order_item where id= " + id + "";

            ResultSet query1 = JDBC.query(sql1);
            ResultSet query2 = JDBC.query(sql2);


            try {
                while (query1.next()) {
                    while (query2.next()) {
                        entityitem = new OrderItemEntity();

                        entityitem.setId(query2.getInt("id"));
                        entityitem.setCategory_id1(query2.getInt("category_id1"));
                        entityitem.setCategory_id2(query2.getInt("category_id2"));
                        entityitem.setCategory_id3(query2.getInt("category_id3"));
                        entityitem.setSpu_id(query2.getInt("spu_id"));
                        entityitem.setSku_id(query2.getInt("sku_id"));
                        entityitem.setOrder_id(query2.getInt("order_id"));
                        entityitem.setName(query2.getString("name"));
                        entityitem.setPrice(query2.getInt("price"));
                        entityitem.setNum(query2.getInt("num"));
                        entityitem.setMoney(query2.getInt("money"));
                        entityitem.setPay_money(query2.getInt("pay_money"));
                        entityitem.setImage(query2.getString("image"));
                        entityitem.setWeight(query2.getInt("weight"));
                        entityitem.setPost_fee(query2.getInt("post_fee"));
                        entityitem.setIs_return(query2.getInt("is_return"));
                        list1.add(entityitem);
                    }

                    entity = new OrderEntity();
                    entity.setId(query1.getInt("id"));
                    entity.setTotal_num(query1.getInt("total_num"));
                    entity.setTotal_money(query1.getInt("total_money"));
                    entity.setPre_money(query1.getInt("pre_money"));
                    entity.setPost_fee(query1.getInt("post_fee"));
                    entity.setPay_money(query1.getInt("pay_money"));
                    entity.setPay_type(query1.getString("pay_type"));
                    entity.setCreate_time(query1.getString("create_time"));
                    entity.setUpdate_time(query1.getString("update_time"));
                    entity.setPay_time(query1.getString("pay_time"));
                    entity.setConsign_time(query1.getString("consign_time"));
                    entity.setEnd_time(query1.getString("end_time"));
                    entity.setClose_time(query1.getString("close_time"));
                    entity.setShipping_name(query1.getString("shipping_name"));
                    entity.setShipping_name(query1.getString("shipping_code"));
                    entity.setUsername(query1.getString("username"));
                    entity.setBuyer_message(query1.getString("buyer_message"));
                    entity.setBuyer_rate(query1.getString("buyer_rate"));
                    entity.setReceiver_contact(query1.getString("receiver_contact"));
                    entity.setReceiver_mobile(query1.getString("receiver_mobile"));
                    entity.setReceiver_address(query1.getString("receiver_address"));
                    entity.setSource_type(query1.getString("source_type"));
                    entity.setTransaction_id(query1.getInt("transaction_id"));
                    entity.setOrder_status(query1.getString("order_status"));
                    entity.setPay_status(query1.getString("pay_status"));
                    entity.setConsign_status(query1.getString("consign_status"));
                    entity.setIs_delete(query1.getString("is_delete"));
                    entity.setSublist(entityitem);
                    list.add(entity);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    @RequestMapping(value = "/batchSendSubmit.do", method = RequestMethod.POST)
    public String submitbatchsend(HttpServletRequest request, HttpServletResponse response) {
        String orderIdss = request.getParameter("orderId");
        String shippingNamess = request.getParameter("shippingName");
        String shippingCodess = request.getParameter("shippingCode");
        OrderEntity entity = null;
        entity = new OrderEntity();
        System.out.println(orderIdss);
        String[] orderIds = orderIdss.split(",");
        String[] shippingNames = shippingNamess.split(",");
        String[] shippingCodes = shippingCodess.split(",");
        System.out.println(orderIds);
        int bb = 0;
        for (int i = 0; i < orderIds.length; i++) {
            int id = Integer.parseInt(orderIds[i]);
            String shippingName = shippingNames[i];
            String shippingCode = shippingCodes[i];
            entity.setShipping_name(shippingName);
            entity.setShipping_code(shippingCode);
            String sql1 = "update wx_tab_order set order_status='2' where id =" + id + " ";
            String sql2 = "update wx_tab_order set shipping_name='" + entity.getShipping_name() + "' , shipping_code='" + entity.getShipping_code() + "',order_status='2' where id =" + id + "";
            int aa = JDBC.update(sql2);
            System.out.println(aa);
            bb = aa;
        }
        if (bb == 1) {
            int code = 0;
            String message = "发货成功";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        } else {
            int code = 1;
            String message = "发货失败";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        }
    }

//    @RequestMapping(value = "/batchSendSubmit.do", method = RequestMethod.POST)


}

