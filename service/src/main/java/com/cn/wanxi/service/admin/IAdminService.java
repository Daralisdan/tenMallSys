package com.cn.wanxi.service.admin;

import com.cn.wanxi.entity.admin.AdminEntity;

import java.util.List;
import java.util.Map;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/18,Create by yaodan
 */
public interface IAdminService {
    boolean login(AdminEntity entity);
    boolean logout(String login_name);
    boolean add(AdminEntity entity);
    boolean deleteById(int id);
    AdminEntity findById(int id);
    List<Map<String, Object>> findAll();
}
