package com.cn.wanxi.service.user;

import com.cn.wanxi.entity.user.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 22:13
 */
public interface IUserService {
    boolean addUserByEntity(UserEntity entity);

    boolean deleteUserById(int id);

    UserEntity findUserById(int id);

    UserEntity findUserByName(String username);

    List<Map<String,Object>> findAll();

    boolean updateUserByEntity(UserEntity entity);

    boolean checkUserInfo(UserEntity entity);
}
