package com.cn.wanxi.service.admin.impl;

import com.cn.wanxi.dao.admin.IAdminDao;
import com.cn.wanxi.entity.admin.AdminEntity;
import com.cn.wanxi.service.admin.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/18,Create by yaodan
 */
@Service
public class AdminServiceImp implements IAdminService {

    @Autowired
    private IAdminDao iAdminDao;

    @Override
    public boolean login(AdminEntity entity) {
//        if(null == entity || null == entity.getLogin_name() || null == entity.getPassword()){
//            return false;
//        }
//        AdminEntity temp = iAdminDao.findByName(entity.getLogin_name());
//        if(null == temp || null == temp.getPassword()){
//            return false;
//        }else{
//            return temp.getPassword().equals(entity.getPassword());
//        }
        return false;
    }

    @Override
    public boolean logout(String login_name) {
        return !(null == login_name || null == iAdminDao.findByName(login_name));
    }

    @Override
    public boolean add(AdminEntity entity) {
        return 0 != iAdminDao.insert(entity);
    }

    @Override
    public boolean deleteById(int id) {
        return 0 != iAdminDao.deleteById(id);
    }

    @Override
    public AdminEntity findById(int id) {
        return iAdminDao.findById(id);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return iAdminDao.queryAll();
    }


}
