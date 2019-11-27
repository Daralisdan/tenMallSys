package com.cn.wanxi.mall.controller.user;

import com.cn.wanxi.dao.universal.IUniversalDao;
import com.cn.wanxi.dao.universal.impl.UniversalDaoImpl;
import com.cn.wanxi.entity.user.UserEntity;
import com.cn.wanxi.service.user.IUserService;
import com.cn.wanxi.utils.message.Message;
import com.cn.wanxi.utils.message.MessageProxy;
import com.cn.wanxi.utils.message.enums.OperationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private IUniversalDao daoTemp;

    /**
     * 【用户登录】
     *
     * @return
     */
    @PostMapping(value = "/login",produces = "application/json;charset=UTF-8")
    public Message login(@RequestBody UserEntity entity) {
        Message m;
        if(0 != daoTemp.findOne(entity).size()){
            m = MessageProxy.success(OperationTypeEnum.LOGIN);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.LOGIN);
        }
        return m;
    }

    /**
     * 【用户退出】
     *
     * @return
     */
    @PostMapping(value = "/logout",produces = "application/json;charset=UTF-8")
    public Message logout(String username) {
        Message m;
        UserEntity entityTemp = new UserEntity();
        entityTemp.setName(username);

        if (0 != daoTemp.findOne(entityTemp).size()) {
            m = MessageProxy.success(OperationTypeEnum.LOGOUT);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.LOGOUT);
        }
        return m;
    }

    /**
     * 【添加用户】
     *
     * @return
     */
    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Message add(@RequestBody UserEntity entity) {
        Message m;
        boolean flag = 0 != daoTemp.insert(entity);
        if (flag) {
            m = MessageProxy.success(OperationTypeEnum.ADD);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.ADD);
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
        Message m;
        UserEntity entity = new UserEntity();
        entity.setId(id);

        if (0 != daoTemp.delete(entity)) {
            m = MessageProxy.success(OperationTypeEnum.DELETE);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.DELETE);
        }
        return m;
    }

    /**
     * 【按照id查询，返回实体】
     *
     * @return
     */
    @PostMapping(value = "/findById",produces = "application/json;charset=UTF-8")
    public Message findById(int id) {
        Message m;
        UserEntity entity = new UserEntity();
        entity.setId(id);
        List<Map<String, Object>> one = daoTemp.findOne(entity);
        if(null != one && 0 != one.size()){
            m = MessageProxy.success(OperationTypeEnum.FIND,one);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.FIND);
        }
        return m;
    }

    /**
     * 【返回全部实体集】
     *
     * @return
     */
    @PostMapping(value = "/findAll",produces = "application/json;charset=UTF-8")
    public Message findAll() {
        Message m;
        List<Map<String,Object>> list =  daoTemp.findAll(new UserEntity());
        if (null != list && !list.isEmpty()) {
            m = MessageProxy.success(OperationTypeEnum.FIND,list);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.FIND);
        }
        return m;
    }
}
