/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: roleMenuController
 * Author:   Administrator
 * Date:     2019/11/19 17:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.mall.controller.roleMenu;

import com.cn.wanxi.entity.roleMenu.RoleMenuEntity;
import com.cn.wanxi.utils.JDBC;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String roleMenuadd(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        RoleMenuEntity roleMenuEntity=new RoleMenuEntity();
        roleMenuEntity.setMenu_id(Integer.parseInt(request.getParameter("menu_id")));
        roleMenuEntity.setRole_id(Integer.parseInt(request.getParameter("role_id")));
        String aa = "insert into wx_tab_roleMenu(menu_id,role_id) values(" + roleMenuEntity.getMenu_id() + ","+roleMenuEntity.getRole_id()+")";
        int a= JDBC.update(aa);
        System.out.println(a);
        if (a == 1) {
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
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public String roleMenudelete(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        RoleMenuEntity roleMenuEntity = new RoleMenuEntity();
        int id = Integer.parseInt(request.getParameter("id"));
        roleMenuEntity.setId(id);
        String dd = "delete  from wx_tab_roleMenu where id=" + roleMenuEntity.getId();
        int d = JDBC.update(dd);
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
}