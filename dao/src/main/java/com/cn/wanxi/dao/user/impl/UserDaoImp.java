package com.cn.wanxi.dao.user.impl;

import com.cn.wanxi.dao.user.IUserDao;
import com.cn.wanxi.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 19:06
 */
@Repository
public class UserDaoImp implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(UserEntity entity) {
        String exeSQL = "INSERT INTO wx_tab_user(username,password) VALUES(?,?)";
        Object args[] = {entity.getUsername(),entity.getPassword()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_user WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }

    @Override
    public UserEntity findById(int id) {
        UserEntity userEntity = null;
        String exeSQL = "select * from wx_tab_user where id=?";
        List<UserEntity> userEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<UserEntity>(UserEntity.class));
        if (null != userEntities && userEntities.size() > 0) {
            userEntity = userEntities.get(0);
        }
        return userEntity;
    }

    @Override
    public UserEntity findByName(String username) {
        UserEntity userEntity = null;
        String exeSQL = "select * from wx_tab_user where username=?";
        List<UserEntity> userEntities = jdbcTemplate.query(exeSQL, new Object[]{username}, new BeanPropertyRowMapper<UserEntity>(UserEntity.class));
        if (null != userEntities && userEntities.size() > 0) {
            userEntity = userEntities.get(0);
        }
        return userEntity;
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select * from wx_tab_user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public int update(UserEntity entity) {
        String exeSQL = "update wx_tab_user set username=?,password=?  WHERE id=?";
        Object args[] = {entity.getUsername(),entity.getPassword(),entity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }
}
