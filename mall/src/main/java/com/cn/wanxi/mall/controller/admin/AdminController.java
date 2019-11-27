package com.cn.wanxi.mall.controller.admin;

import com.cn.wanxi.dao.universal.IUniversalDao;
import com.cn.wanxi.dao.universal.impl.UniversalDaoImpl;
import com.cn.wanxi.entity.admin.AdminEntity;
import com.cn.wanxi.service.admin.IAdminService;
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

    private IUniversalDao daoTemp = new UniversalDaoImpl();

    /**
     * 【管理员登录】
     *
     * @return
     */
    @PostMapping(value = "/login",produces = "application/json;charset=UTF-8")
    public Message login(@RequestBody AdminEntity adminEntity) {
        Message m;
        if(0 != daoTemp.findOne(adminEntity).size()){
            m = MessageProxy.success(OperationTypeEnum.LOGIN);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.LOGIN);
        }
        return m;
    }

    /**
     * 【管理员登录】
     *
     * @return
     */
    @PostMapping(value = "/logout",produces = "application/json;charset=UTF-8")
    public Message logout(String username){
        Message m;
        AdminEntity entityTemp = new AdminEntity();
        entityTemp.setLoginName(username);

        if (0 != daoTemp.findOne(entityTemp).size()) {
            m = MessageProxy.success(OperationTypeEnum.LOGOUT);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.LOGOUT);
        }
        return m;
    }

    /**
     * 【管理员添加】
     *
     * @return
     */
    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Message add(@RequestBody AdminEntity entity){
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
     * 【管理员查找】
     *
     * @return
     */
    @PostMapping(value = "/findById",produces = "application/json;charset=UTF-8")
    public Message findById(int id){
        Message m;
        AdminEntity entity = new AdminEntity();
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
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findAll",produces = "application/json;charset=UTF-8")
    public Message findByAll(){
        Message m;
        List<Map<String,Object>> list =  daoTemp.findAll(new AdminEntity());
        if (null != list && !list.isEmpty()) {
            m = MessageProxy.success(OperationTypeEnum.FIND,list);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.FIND);
        }
        return m;
    }

    /**
     * 【管理员删除】
     *
     * @return
     */
    @PostMapping(value = "/deleteById",produces = "application/json;charset=UTF-8")
    public Message deleteById(int id){
        Message m;
        AdminEntity entity = new AdminEntity();
        entity.setId(id);

        if (0 != daoTemp.delete(entity)) {
            m = MessageProxy.success(OperationTypeEnum.DELETE);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.DELETE);
        }
        return m;
    }
}
