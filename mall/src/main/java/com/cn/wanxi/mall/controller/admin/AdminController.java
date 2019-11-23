package com.cn.wanxi.mall.controller.admin;

import com.cn.wanxi.entity.admin.AdminEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.utils.utils.MsgX;
import com.cn.wanxi.service.admin.IAdminService;
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
 * 2019/11/18,Create by yaodan
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
    @PostMapping("/login")
    public MsgX login(AdminEntity adminEntity) {
        MsgX m;
        boolean flag = iAdminService.login(adminEntity);
        if (flag) {
            m = MsgX.success(0,"登录");
        } else {
            m = MsgX.fail(1,"登录");
        }
        return m;
    }

    /**
     * 【管理员登录】
     *
     * @return
     */
    @PostMapping("/logout")
    public MsgX logout(String username){
        MsgX m;
        boolean flag = iAdminService.logout(username);
        if (flag) {
            m = MsgX.success(0,"退出");
        } else {
            m = MsgX.fail(1,"退出");
        }
        return m;
    }

    /**
     * 【管理员添加】
     *
     * @return
     */
    @PostMapping("/add")
    public MsgX add(AdminEntity entity){
        MsgX m;
        boolean flag = iAdminService.add(entity);
        if (flag) {
            m = MsgX.success(0,"添加");
        } else {
            m = MsgX.fail(1,"添加");
        }
        return m;
    }

    /**
     * 【管理员查找】
     *
     * @return
     */
    @PostMapping("/findById")
    public AdminEntity findById(int id){
        AdminEntity entity = iAdminService.findById(id);
        return entity;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping("/findAll")
    public Msg findByAll(){
        Msg m;
        List<Map<String,Object>> list =  iAdminService.findAll();
        if (null != list && !list.isEmpty()) {
            m = Msg.success().messageData("admin",list);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 【管理员删除】
     *
     * @return
     */
    @PostMapping("/deleteById")
    public MsgX deleteById(int id){
        MsgX m;
        boolean flag = iAdminService.deleteById(id);
        if (flag) {
            m = MsgX.success(0,"删除");
        } else {
            m = MsgX.fail(1,"删除");
        }
        return m;
    }


}
