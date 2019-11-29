package com.cn.wanxi.mall.controller.user;

import com.cn.wanxi.entity.user.UserEntity;
import com.cn.wanxi.service.user.IUserService;
import com.cn.wanxi.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author LeesonWong
 * @date 2019/11/19 19:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 【添加用户】
     *
     * @return
     */
    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Message add(@RequestBody UserEntity entity) {
        Message m = new Message();
        boolean isSuccess = iUserService.addUser(entity);
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

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Message update(String username,String password,String odpassword) {
        Message m = new Message();
        boolean isSuccess = iUserService.modifyPassword(username,password,odpassword);
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
     * 【删除用户】
     *
     * @return
     */
    @PostMapping(value = "/deleteById",produces = "application/json;charset=UTF-8")
    public Message delete(int id) {
        Message m = new Message();
        boolean isSuccess = iUserService.deleteUserById(id);
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
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/reset",produces = "application/json;charset=UTF-8")
    public Message reset(String username,String password) {
        Message m = new Message();
        boolean isSuccess = iUserService.resetUserPassword(username,password);
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

    @PostMapping(value = "/findCondPage",produces = "application/json;charset=UTF-8")
    public Message findCondPage(String username,String status,int page,int size) {
        Message m = new Message();
        ArrayList<UserEntity> list = iUserService.findCondPage(username,status,page,size);
        if(0 < list.size()){
            int total = iUserService.count(username,status);
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
     * @param id
     * @return
     */
    @PostMapping(value = "/findById",produces = "application/json;charset=UTF-8")
    public Message findById(int id) {
        Message m = new Message();
        UserEntity entity;
        entity = iUserService.findUserById(id);
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
    @PostMapping(value = "/findAll",produces = "application/json;charset=UTF-8")
    public Message findAll() {
        Message m = new Message();
        ArrayList<UserEntity> list =  iUserService.findUserAll();
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
