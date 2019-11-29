package com.cn.wanxi.dao.admin.impl;

import com.cn.wanxi.dao.admin.IAdminDao;
import com.cn.wanxi.entity.admin.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/18,Create by yaodan
 */
@Repository
public class AdminDaoImp implements IAdminDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public boolean checkByName(String username) {
        String sql = "select id as id,login_name as loginName,password as password,status as status from wx_tab_admin where login_name = ?";
        Object[] args = {username};
        List<AdminEntity> list = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(AdminEntity.class));
        if(0 < list.size()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String findPasswordByName(String username) {
        String sql = "select password as password from wx_tab_admin where login_name = ?";
        Object[] args = {username};
        List<AdminEntity> list = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(AdminEntity.class));
        if(0 < list.size()){
            return list.get(0).getPassword();
        } else {
            return null;
        }
    }
}
