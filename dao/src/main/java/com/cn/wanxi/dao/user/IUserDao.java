package com.cn.wanxi.dao.user;

import com.cn.wanxi.entity.user.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 19:06
 */
public interface IUserDao {
    boolean insert(UserEntity entity);

    UserEntity findByName(String username);

    boolean updatePasswordByUsername(String username, String password);

    boolean deleteById(int id);

    List<UserEntity> findConditionPage(int page, int size);

    int countCondition();

    UserEntity findById(int id);

    List<UserEntity> findAll();
}
