package com.cn.wanxi.mall.controller.user;

import com.cn.wanxi.entity.user.UserEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.utils.utils.MsgX;
import com.cn.wanxi.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
     * 【用户登录】
     *
     * @return
     */
    @PostMapping("/login")
    public MsgX login(UserEntity entity) {
        MsgX m;
        boolean flag = iUserService.checkUserInfo(entity);

        if (flag) {
            m = MsgX.success(0,"登录");
        } else {
            m = MsgX.fail(1,"登录");
        }
        return m;
    }

    /**
     * 【用户退出】
     *
     * @return
     */
    @PostMapping("/logout")
    public MsgX logout(String username) {
        MsgX m;
        boolean flag = iUserService.findUserByName(username) != null;
        if (flag) {
            m = MsgX.success(0,"退出");
        } else {
            m = MsgX.fail(1,"退出");
        }
        return m;
    }

    /**
     * 【添加用户】
     *
     * @return
     */
    @PostMapping("/add")
    public Msg add(UserEntity entity) {
        Msg m;
        boolean flag = iUserService.addUserByEntity(entity);
        if (flag) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 【删除用户】
     *
     * @return
     */
    @PostMapping("/deleteById")
    public Msg delete(int id) {
        Msg m;
        boolean flag = iUserService.deleteUserById(id);
        if (flag) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 【按照id查询，返回实体】
     *
     * @return
     */
    @PostMapping("/findById")
    public Msg findById(int id) {
        Msg m;
        UserEntity entity = iUserService.findUserById(id);
        if (null != entity) {
            m = Msg.success().messageData(entity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 【返回全部实体集】
     *
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        Msg m;
        List<Map<String,Object>>list =  iUserService.findAll();
        if (null != list && !list.isEmpty()) {
            m = Msg.success().messageData(list);
        } else {
            m = Msg.fail();
        }
        return m;
    }
}
