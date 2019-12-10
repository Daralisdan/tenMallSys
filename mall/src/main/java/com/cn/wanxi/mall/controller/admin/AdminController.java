package com.cn.wanxi.mall.controller.admin;

import com.cn.wanxi.entity.admin.AdminEntity;
import com.cn.wanxi.service.admin.IAdminService;
import com.cn.wanxi.utils.Message;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
@Api(tags = "登陆认证的接口")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    /**
     * 【管理员登录】
     *
     * @return
     */
    @PostMapping(value = "/login",produces = "application/json;charset=UTF-8")
    public Message login(@RequestBody Map<String,String> args) {
        String adminName = args.get("username");
        String password = args.get("password");
        Message m = new Message();
        Integer roleId = iAdminService.login(adminName,password);
        if(null != roleId){
            m.setCode(0);
            m.setMessage("登录成功");
            m.setData(roleId);
        } else {
            m.setCode(1);
            m.setMessage("登录失败测试");
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
    public Message logout(@RequestBody Map<String,String> args){
        String adminName = args.get("username");
        Message m = new Message();
        boolean isSuccess = iAdminService.logout(adminName);
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

    /**
     * 【管理员添加】
     *
     * @return
     */
    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Message add(@RequestBody Map<String,String> args){
        Message m = new Message();
        String adminName = args.get("username");
        String password = args.get("password");
        Integer roleId = Integer.parseInt(args.get("roleId"));
        boolean isSuccess = iAdminService.addAdmin(adminName,password,roleId);
        if(isSuccess){
            m.setCode(0);
            m.setMessage("添加成功");
            m.setData("新增操作无返回数据");
        } else {
            m.setCode(1);
            m.setMessage("添加失败");
            m.setData("新增操作无返回数据");
        }
        return m;
    }


    /**
     * 【管理员更新】
     *
     * @return
     */
    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Message update(@RequestBody Map<String,String> args){
        String adminName = args.get("username");
        String password = args.get("password");
        String odpassword = args.get("odpassword");
        Message m = new Message();
        boolean isSuccess = iAdminService.modifyPassword(adminName,password,odpassword);
        if(isSuccess){
            m.setCode(0);
            m.setMessage("密码修改成功");
            m.setData("密码修改操作无返回数据");
        } else {
            m.setCode(1);
            m.setMessage("密码修改失败");
            m.setData("密码修改操作无返回数据");
        }
        return m;
    }

    /**
     * 【删除管理员】
     *
     * @return
     */
    @PostMapping(value = "/deleteById",produces = "application/json;charset=UTF-8")
    public Message delete(@RequestBody Map<String,String> args) {
        Integer id = Integer.parseInt(args.get("id"));
        Message m = new Message();
        boolean isSuccess = iAdminService.deleteUserById(id);
        if(isSuccess){
            m.setCode(0);
            m.setMessage("用户删除成功");
            m.setData("用户删除操作无返回数据");
        } else {
            m.setCode(1);
            m.setMessage("用户删除失败");
            m.setData("用户删除操作无返回数据");
        }
        return m;
    }

    /**
     * 重置密码
     * @param args
     * @return
     */
    @PostMapping(value = "/reset",produces = "application/json;charset=UTF-8")
    public Message reset(@RequestBody Map<String,String> args) {
        String adminName = args.get("adminName");
        String password = args.get("password");
        Message m = new Message();
        boolean isSuccess = iAdminService.resetUserPassword(adminName,password);
        if(isSuccess){
            m.setCode(0);
            m.setMessage("重置密码成功");
            m.setData("重置密码操作无返回数据");
        } else {
            m.setCode(1);
            m.setMessage("重置密码失败");
            m.setData("重置密码操作无返回数据");
        }
        return m;
    }

    /**
     * 【分页条件查询】
     *
     * @return
     */
    @PostMapping(value = "/findCondPage",produces = "application/json;charset=UTF-8")
    public Message findCondPage(@RequestBody Map<String,String> args) {
        String adminName = args.get("adminName");
        String status = args.get("status");
        Integer page = Integer.parseInt(args.get("page"));
        Integer size = Integer.parseInt(args.get("size"));
        Message m = new Message();
        List<AdminEntity> list = iAdminService.findCondPage(adminName,status,page,size);
        if(0 < list.size()){
            int total = iAdminService.count(adminName,status);
            LinkedHashMap<String,Object> result = new LinkedHashMap<>();
            result.put("rows",list);
            result.put("total",total);
            m.setCode(0);
            m.setMessage("共查找出" + list.size() + "满足条件");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("未共查找出满足条件的数据");
        }
        return m;
    }

    /**
     * 【按照id查询，返回实体】
     * @param args
     * @return
     */
    @PostMapping(value = "/findById",produces = "application/json;charset=UTF-8")
    public Message findById(@RequestBody Map<String,String> args) {
        Integer id = Integer.parseInt(args.get("id"));
        Message m = new Message();
        AdminEntity entity;
        entity = iAdminService.findUserById(id);
        if(null != entity){
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(entity);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
        }
        return m;
    }

    /**
     * 【查询所有】
     *
     * @return
     */
    @PostMapping(value = "/listAll",produces = "application/json;charset=UTF-8")
    public Message findAll() {
        Message m = new Message();
        ArrayList<LinkedHashMap<String, Object>> list =  iAdminService.findAdminAllWithRoleName();
        if(0 < list.size()){
            m.setCode(0);
            m.setMessage("共查找到" + list.size() +"条数据");
            m.setData(list);
        } else {
            m.setCode(1);
            m.setMessage("查询失败或数据库中数据条数为0");
        }
        return m;
    }
}
