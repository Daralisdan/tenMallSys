package com.cn.wanxi.dao.user.impl;

import com.cn.wanxi.dao.user.IUserDao;
import com.cn.wanxi.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    private static final String attrMapper = "id as id,username as username,password as password," +
            "phone as phone,email as email,created as created,updated as updated,source_type as sourceType," +
            "nick_name as nickName,name as name,status as status,head_pic as headPic,qq as qq,is_mobile_check as isMobileCheck," +
            "is_mail_check as isMailCheck,sex as sex,user_level as userLevel,points as points,experience_value as experienceValue," +
            "birthday as birthday,last_login_time as lastLoginTime";

    @Override
    public boolean insert(UserEntity entity) {
        String exeSQL = "INSERT INTO wx_tab_user(username,password) VALUES(?,?)";
        Object args[] = {entity.getUsername(),entity.getPassword()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return 0 < temp;
    }

    @Override
    public UserEntity findByName(String username) {
        UserEntity userEntity = null;
        String exeSQL = "select " + attrMapper + " from wx_tab_user where username=?";
        List<UserEntity> userEntities = jdbcTemplate.query(exeSQL, new Object[]{username}, new BeanPropertyRowMapper<>(UserEntity.class));
        if (null != userEntities && 0 < userEntities.size()) {
            userEntity = userEntities.get(0);
        }
        return userEntity;
    }

    @Override
    public boolean updatePasswordByUsername(String username, String password) {
        String exeSQL = "update wx_tab_user set password=? WHERE username=?";
        Object args[] = {username,password};
        int temp = jdbcTemplate.update(exeSQL, args);
        return 0 < temp;
    }

    @Override
    public boolean deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_user WHERE id=?";
        Object[] args = {id};
        int temp = jdbcTemplate.update(exeSQL, args);
        return 0 < temp;
    }

    @Override
    public ArrayList<UserEntity> findConditionPage(int page, int size) {
        String exeSQL = "select id as id,username as username,status as status from wx_tab_user limit" + (page-1)*size + "," + size;
        List<UserEntity> userEntities = jdbcTemplate.query(exeSQL,new BeanPropertyRowMapper<>(UserEntity.class));
        return (ArrayList<UserEntity>)userEntities;
    }

    @Override
    public int countCondition() {
        String exeSQL = "select count(*) from wx_tab_user";
        int total = jdbcTemplate.queryForObject(exeSQL,new BeanPropertyRowMapper<>(Integer.class));
        return total;
    }

    @Override
    public UserEntity findById(int id) {
        UserEntity userEntity = null;
        String exeSQL = "select " + attrMapper + " from wx_tab_user where id=?";
        List<UserEntity> userEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<>(UserEntity.class));
        if (null != userEntities && 0 < userEntities.size()) {
            userEntity = userEntities.get(0);
        }
        return userEntity;
    }

    @Override
    public ArrayList<UserEntity> findAll() {
        String exeSQL = "select " + attrMapper + " from wx_tab_user";
        List<UserEntity> userEntities = jdbcTemplate.query(exeSQL,new BeanPropertyRowMapper<>(UserEntity.class));
        return (ArrayList<UserEntity>)userEntities;
    }
}
