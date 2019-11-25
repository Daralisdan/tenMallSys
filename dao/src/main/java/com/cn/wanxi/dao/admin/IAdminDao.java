package com.cn.wanxi.dao.admin;

import com.cn.wanxi.entity.admin.AdminEntity;

import java.util.List;
import java.util.Map;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/18,Create by yaodan
 */
public interface IAdminDao {

    int insert(AdminEntity entity);

    int deleteById(int id);

    List<Map<String, Object>> queryAll();

    AdminEntity findById(int id);

    AdminEntity findByName(String login_name);

    int update(AdminEntity entity);
}
