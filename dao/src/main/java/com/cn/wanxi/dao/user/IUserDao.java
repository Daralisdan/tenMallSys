package com.cn.wanxi.dao.user;

import com.cn.wanxi.entity.user.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 19:06
 */
public interface IUserDao {
    int insert(UserEntity entity);

    int deleteById(int id);

    UserEntity findById(int id);

    UserEntity findByName(String username);

    List<Map<String,Object>> queryAll();

    int update(UserEntity entity);
}
