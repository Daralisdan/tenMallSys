package com.cn.wanxi.dao.admin;

import com.cn.wanxi.entity.admin.AdminEntity;

import java.util.List;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/18,Create by yaodan
 */
public interface IAdminDao {
    String findPasswordByName(String username);
    boolean checkByName(String username);

    boolean insert(AdminEntity entity);

    AdminEntity findByName(String username);

    boolean updatePasswordByUsername(String username, String password);

    boolean deleteById(Integer id);

    List<AdminEntity> findConditionPage(String username, String status, Integer page, Integer size);

    int countCondition(String username,String status);

    AdminEntity findById(Integer id);

    List<AdminEntity> findAll();
}
