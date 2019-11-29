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
    public boolean login(String username,String password) {
        String backPassword = iAdminDao.findPasswordByName(username);
        return password.equalsIgnoreCase(backPassword);
    }

    @Override
    public boolean logout(String login_name) {
        return iAdminDao.checkByName(login_name);
    }
}
