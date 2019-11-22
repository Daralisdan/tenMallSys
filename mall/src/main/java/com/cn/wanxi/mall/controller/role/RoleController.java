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

import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.role.RoleEntity;
import com.cn.wanxi.entity.utils.Msg;
import com.cn.wanxi.service.brand.IBrandService;
import com.cn.wanxi.service.role.IRoleService;
import com.cn.wanxi.utils.JDBC;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

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
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String roleadd(HttpServletRequest request, HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        RoleEntity roleEntity = new RoleEntity();
//        roleEntity.setRole_name(request.getParameter("role_name"));
//        String aa = "insert into wx_tab_role(role_name) values('" + roleEntity.getRole_name() + "')";
//        int a = JDBC.update(aa);
//        System.out.println(a);
//        if (a == 1) {
//            int code = 0;
//            String message = "新增成功";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        } else {
//            int code = 1;
//            String message = "新增失败";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        }
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String roledelete(HttpServletRequest request, HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        RoleEntity roleEntity = new RoleEntity();
//        int id = Integer.parseInt(request.getParameter("id"));
//        roleEntity.setId(id);
//        String dd = "delete  from wx_tab_role where id=" + roleEntity.getId();
//        int d = JDBC.update(dd);
//        System.out.println(d);
//        if (d == 1) {
//            int code = 0;
//            String message = "删除成功";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        } else {
//            int code = 1;
//            String message = "删除失败";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        }
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String roleupdate(HttpServletRequest request, HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        int id = Integer.parseInt(request.getParameter("id"));
//        RoleEntity roleEntity =new RoleEntity();
//        roleEntity.setRole_name(request.getParameter("role_name"));
//        String ee="update wx_tab_role set role_name='"+roleEntity.getRole_name()+"' where id="+id+"";
//        int e=JDBC.update(ee);
//        System.out.println(e);
//        if (e == 1) {
//            int code = 0;
//            String message = "更新成功";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        } else {
//            int code = 1;
//            String message = "更新失败";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        }

    @Autowired
    private IRoleService iRoleService;

    @PostMapping("/add")
    public Msg add(RoleEntity roleEntity , HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg m;
        int result = iRoleService.add(roleEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("role", roleEntity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    @PostMapping("/findAll")
    public Msg findAll(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        List<Map<String, Object>> list = iRoleService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("role", list);
        }
        return msg;
    }

    @PostMapping(value = "/findById")
    public Msg findById(int id,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        RoleEntity byId = iRoleService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData("role", byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    @PostMapping("/update")
    public Msg updateInfo(RoleEntity roleEntity,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        int up = iRoleService.update(roleEntity);
        if (up > 0) {
            msg = Msg.success().messageData("role", roleEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    @PostMapping("/delete")
    public Msg deleteById(int id,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        int i = iRoleService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }
}