package com.cn.wanxi.service.admin.impl;

import com.cn.wanxi.dao.AdminRole.IAdminRoleDao;
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

    @Autowired
    private IAdminRoleDao iAdminRoleDao;

    @Override
    public Integer login(String username,String password) {
        Integer roleId = null;
        String backPassword = iAdminDao.findPasswordByName(username);
        if(password.equals(backPassword)){
            return roleId = iAdminRoleDao.selectRoleByUsername(username);
        } else {
            return null;
        }
    }

    @Override
    public boolean logout(String login_name) {
        return iAdminDao.checkByName(login_name);
    }

    @Override
    public boolean addAdmin(AdminEntity entity) {
        return iAdminDao.insert(entity);
    }

    @Override
    public boolean modifyPassword(String username, String password, String odpassword) {
        AdminEntity byName = iAdminDao.findByName(username);
        if(odpassword.equals(byName.getPassword())){
            return iAdminDao.updatePasswordByUsername(username,password);
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUserById(Integer id) {
        return iAdminDao.deleteById(id);
    }

    @Override
    public boolean resetUserPassword(String username, String password) {
        return iAdminDao.updatePasswordByUsername(username,password);
    }

    @Override
    public List<AdminEntity> findCondPage(String username, String status, Integer page, Integer size) {
        return iAdminDao.findConditionPage(username,status,page,size);
    }

    @Override
    public int count(String username, String status) {
        return iAdminDao.countCondition(username,status);
    }

    @Override
    public AdminEntity findUserById(Integer id) {
        return iAdminDao.findById(id);
    }

    @Override
    public List<AdminEntity> findUserAll() {
        return iAdminDao.findAll();
    }
}
