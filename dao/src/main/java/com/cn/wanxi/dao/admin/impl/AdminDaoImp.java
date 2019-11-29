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

    private static final String attrMapper =
            "id as id," +
            "login_name as loginName," +
            "password as password," +
            "name as name," +
            "phone as phone," +
            "email as email," +
            "status as status";

    @Override
    public String findPasswordByName(String username) {
        String sql = "select " + attrMapper + " from wx_tab_admin where login_name = ?";
        Object[] args = {username};
        AdminEntity entity = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(AdminEntity.class));
        if(null != entity){
            return entity.getPassword();
        } else {
            return null;
        }
    }

    @Override
    public boolean checkByName(String username) {
        String sql = "select " + attrMapper +" from wx_tab_admin where login_name = ?";
        Object[] args = {username};
        AdminEntity entity = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(AdminEntity.class));
        if(null != entity){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insert(AdminEntity entity) {
        String sql = "insert into wx_tab_admin";
        return false;
    }

    @Override
    public AdminEntity findByName(String username) {
        return null;
    }

    @Override
    public boolean updatePasswordByUsername(String username, String password) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public List<AdminEntity> findConditionPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public int countCondition(String status) {
        return 0;
    }

    @Override
    public AdminEntity findById(Integer id) {
        return null;
    }

    @Override
    public List<AdminEntity> findAll() {
        return null;
    }
}
