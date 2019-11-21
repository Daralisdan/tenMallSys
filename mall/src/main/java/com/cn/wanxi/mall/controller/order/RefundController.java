package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.utils.JDBC;
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

@RestController
@RequestMapping("/refund")
public class RefundController {
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<RefundCauseEntity> selectrefund(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        RefundCauseEntity entity = null;
        List<RefundCauseEntity> list = new ArrayList();
        Integer.parseInt(request.getParameter("page"));
        Integer.parseInt(request.getParameter("size"));
//        Total total = new Total();
//        total.setTotal(Integer.parseInt(request.getParameter("size")));
        String sql = "select * from wx_tab_return_order  limit " + (Integer.parseInt(request.getParameter("page")) - 1) * Integer.parseInt(request.getParameter("size")) + "," + Integer.parseInt(request.getParameter("size")) + "";

        ResultSet query = JDBC.query(sql);
        try {
            while (query.next()) {
                entity = new RefundCauseEntity();
                entity.setId(query.getInt("id"));
                entity.setOrder_id(query.getInt("order_id"));
                entity.setApply_time(query.getString("apply_time"));
                entity.setUser_id(query.getInt("user_id"));
                entity.setUser_account(query.getString("user_account"));
                entity.setLinkman(query.getString("linkman"));
                entity.setLinkman_mobile(query.getString("linkman_mobile"));
                entity.setType(query.getString("type"));
                entity.setReturn_money(query.getInt("return_money"));
                entity.setIs_return_freight(query.getString("is_return_freight"));
                entity.setStatus(query.getString("status"));
                entity.setDispose_time(query.getString("dispose_time"));
                entity.setReturn_cause(query.getInt("return_cause"));
                entity.setEvidence(query.getString("evidence"));
                entity.setDescription(query.getString("description"));
                entity.setRemark(query.getString("remark"));
                entity.setAdmin_id(query.getInt("admin_id"));
                list.add(entity);
//                list.add(total);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/approval", method = RequestMethod.POST)
    public String update(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.getParameter("id");
        request.getParameter("status");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String sql = "update wx_tab_return_order set status='" + request.getParameter("status") + "' where id=" + Integer.parseInt(request.getParameter("id")) + "";
        int aa = JDBC.update(sql);
        if (aa == 1) {
            int code = 0;
            String message = "操作成功";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        } else {
            int code = 1;
            String message = "操作失败";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        }
    }

    @RequestMapping(value = "/casue", method = RequestMethod.POST)
    public String updatecause(HttpServletRequest request, HttpServletResponse response) {
//        ReturnCauseEntity entity=new ReturnCauseEntity();
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.getParameter("id");
        String sql = "update wx_tab_return_cause set status='1',seq='1',cause='已经购买' where id=" + Integer.parseInt(request.getParameter("id")) + "";
        JDBC.update(sql);
        int id = 0;
        String cause = "已经购买";
        int seq=1;
        String  status="1";
        JSONObject result = new JSONObject();
        result.put("id", id);
        result.put("cause", cause);
        result.put("seq", seq);
        result.put("status", status);
        return result.toJSONString();
    }

}
