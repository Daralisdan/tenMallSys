package com.cn.wanxi.mall.controller.menu;

import com.cn.wanxi.entity.menu.MenuEntity;
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

/**
 * 【菜单管理】 菜单为三级菜单
 * 数据表： wx_tab_menu （菜单表）
 * <p>
 * 2019/11/18,Create by yaodan
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String menuadd(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setName(request.getParameter("name"));
        menuEntity.setIcon(request.getParameter("icon"));
        menuEntity.setParent_id(request.getParameter("parent_id"));
        menuEntity.setUrl(request.getParameter("url"));
        String cc = "insert into wx_tab_menu(name,icon,parent_id,url) values('" + menuEntity.getName() + "','" + menuEntity.getIcon() + "','" + menuEntity.getParent_id() + "','" + menuEntity.getUrl() + "')";
        int c = JDBC.update(cc);
        System.out.println(c);
        if (c == 1) {
            int code = 0;
            String message = "添加成功";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        } else {
            int code = 1;
            String message = "添加失败";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        }
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String menudelete(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        MenuEntity menuEntity = new MenuEntity();
        int id=Integer.parseInt(request.getParameter("id"));
        menuEntity.setId(id);
        String dd="delete  from wx_tab_menu where id=" + menuEntity.getId();
        int d=JDBC.update(dd);
        System.out.println(d);
        if (d == 1) {
            int code = 0;
            String message = "删除成功";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        } else {
            int code = 1;
            String message = "删除失败";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        }
}
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String menuupdate(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        int id = Integer.parseInt(request.getParameter("id"));
        MenuEntity menuEntity =new MenuEntity();
        menuEntity.setName(request.getParameter("name"));
        menuEntity.setIcon(request.getParameter("icon"));
        menuEntity.setParent_id(request.getParameter("parent_id"));
        menuEntity.setUrl(request.getParameter("url"));
        String ee="update wx_tab_menu set name='"+menuEntity.getName()+"',icon='"+menuEntity.getIcon()+"',parent_id='"+menuEntity.getParent_id()+"',url='"+menuEntity.getUrl()+"' where id="+id+"";
        int e=JDBC.update(ee);
        System.out.println(e);
        if (e == 1) {
            int code = 0;
            String message = "更新成功";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        } else {
            int code = 1;
            String message = "更新失败";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        }

}
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public List<MenuEntity> menufindAll(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String aa="select * from wx_tab_menu ";
        ResultSet resultSet=JDBC.query(aa);
        List<MenuEntity> list=new ArrayList<>();
        try {
            while (resultSet.next()) {
                MenuEntity menuEntity=new MenuEntity();
                menuEntity.setId(resultSet.getInt("id"));
                menuEntity.setName(resultSet.getString("name"));
                menuEntity.setIcon(resultSet.getString("icon"));
                menuEntity.setParent_id(resultSet.getString("parent_id"));
                menuEntity.setUrl(resultSet.getString("url"));
                list.add(menuEntity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/findCondMenu", method = RequestMethod.POST)
    public List<MenuEntity> menufindCondMenu(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
            List<MenuEntity> list = new ArrayList();
            Integer.parseInt(request.getParameter("page"));
            Integer.parseInt(request.getParameter("size"));
            Integer Total=0;
            String sql = "select * from wx_tab_menu  limit " + (Integer.parseInt(request.getParameter("page")) - 1) * Integer.parseInt(request.getParameter("size")) + "," + Integer.parseInt(request.getParameter("size")) + "";

            ResultSet query = JDBC.query(sql);
            try {
                while (query.next()) {
                    MenuEntity menuEntity=new MenuEntity();
                    menuEntity.setId(query.getInt("id"));
                    menuEntity.setName(query.getString("name"));
                    menuEntity.setIcon(query.getString("icon"));
                    menuEntity.setParent_id(query.getString("parent_id"));
                    menuEntity.setUrl(query.getString("url"));
                    list.add(menuEntity);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }



}
