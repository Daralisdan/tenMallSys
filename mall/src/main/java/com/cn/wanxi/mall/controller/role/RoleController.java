/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleController
 * Author:   Administrator
 * Date:     2019/11/19 16:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.mall.controller.role;

import com.cn.wanxi.entity.role.RoleEntity;
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
@RequestMapping("/role")
public class RoleController {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String roleadd(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(request.getParameter("role_name"));
        String aa = "insert into wx_tab_role(role_name) values('" + roleEntity.getRoleName() + "')";
        int a = JDBC.update(aa);
        System.out.println(a);
        if (a == 1) {
            int code = 0;
            String message = "新增成功";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        } else {
            int code = 1;
            String message = "新增失败";
            JSONObject result = new JSONObject();
            result.put("code", code);
            result.put("message", message);
            return result.toJSONString();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String roledelete(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        RoleEntity roleEntity = new RoleEntity();
        int id = Integer.parseInt(request.getParameter("id"));
        roleEntity.setId(id);
        String dd = "delete  from wx_tab_role where id=" + roleEntity.getId();
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

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String roleupdate(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        int id = Integer.parseInt(request.getParameter("id"));
        RoleEntity roleEntity =new RoleEntity();
        roleEntity.setRoleName(request.getParameter("role_name"));
        String ee="update wx_tab_role set role_name='"+roleEntity.getRoleName()+"' where id="+id+"";
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
}