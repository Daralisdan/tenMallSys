package com.cn.wanxi.mall.controller.admin;

import com.cn.wanxi.service.admin.IAdminService;
import com.cn.wanxi.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/26,Create by LessonWong
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    /**
     * 【管理员登录】
     *
     * @return
     */
    @PostMapping(value = "/login",produces = "application/json;charset=UTF-8")
    public Message login(String username,String password) {
        Message m = new Message();
        boolean isSuccess = iAdminService.login(username,password);
        if(isSuccess){
            m.setCode(0);
            m.setMessage("登录成功");
            m.setData("登录操作无返回数据");
        } else {
            m.setCode(1);
            m.setMessage("登录失败");
            m.setData("登录操作无返回数据");
        }
        return m;
    }

    /**
     * 【管理员退出】
     *
     * @return
     */
    @PostMapping(value = "/logout",produces = "application/json;charset=UTF-8")
    public Message logout(String username){
        Message m = new Message();
        boolean isSuccess = iAdminService.logout(username);
        if(isSuccess){
            m.setCode(0);
            m.setMessage("退出成功");
            m.setData("退出操作无返回数据");
        } else {
            m.setCode(1);
            m.setMessage("退出失败");
            m.setData("退出操作无返回数据");
        }
        return m;
    }
}
