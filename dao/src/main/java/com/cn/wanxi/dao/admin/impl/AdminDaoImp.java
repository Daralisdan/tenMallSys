package com.cn.wanxi.dao.admin.impl;

import com.cn.wanxi.dao.admin.IAdminDao;
import com.cn.wanxi.entity.admin.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        String sql = "insert into wx_tab_admin(login_name,password,name,phone,email,status)";
        Object[] args = {entity.getLoginName(),entity.getPassword(),entity.getName(),entity.getPhone(),entity.getEmail(),entity.getStatus()};
        int temp = jdbcTemplate.update(sql, args);
        return 0 < temp;
    }

    @Override
    public AdminEntity findByName(String username) {
        String sql = "select " + attrMapper + " from wx_tab_admin where login_name = ?";
        Object[] args = {username};
        AdminEntity entity = jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(AdminEntity.class));
        return entity;
    }

    @Override
    public boolean updatePasswordByUsername(String username, String password) {
        String sql = "update wx_tab_admin set password = ? where login_name = ?";
        Object[] args = {password,username};
        int temp = jdbcTemplate.update(sql,args);
        return 0 < temp;
    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = "delete from wx_tab_admin where id = ?";
        Object[] args = {id};
        int temp = jdbcTemplate.update(sql,args);
        return 0 < temp;
    }

    @Override
    public List<AdminEntity> findConditionPage(String username, String status, Integer page, Integer size) {
        String sql = "select " + attrMapper + " from wx_tab_admin where username = ? and status = ? limit " + (page - 1)*size + "," + size;
        Object[] args = {username,status};
        List<AdminEntity> list = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(AdminEntity.class));
        return list;
    }


    @Override
    public int countCondition(String username,String status) {
        String sql = "select count(*) from from wx_tab_admin where username = ? and status = ?";
        Object[] args = {username,status};
        Integer total = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(Integer.class));
        return total;
    }

    @Override
    public AdminEntity findById(Integer id) {
        String sql = "select " + attrMapper + " from wx_tab_admin where id = ?";
        Object[] args = {id};
        AdminEntity entity = jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(AdminEntity.class));
        return entity;
    }

    @Override
    public List<AdminEntity> findAll() {
        String sql = "select " + attrMapper + " from wx_tab_admin";
        List<AdminEntity> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AdminEntity.class));
        return list;
    }
}
