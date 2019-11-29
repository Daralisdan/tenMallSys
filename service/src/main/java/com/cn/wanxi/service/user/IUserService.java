package com.cn.wanxi.service.user;

import com.cn.wanxi.entity.user.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 22:13
 */
public interface IUserService {

    boolean addUser(UserEntity entity);

    boolean modifyPassword(String username, String password, String odpassword);

    boolean deleteUserById(int id);

    boolean resetUserPassword(String username, String password);

    ArrayList<UserEntity> findCondPage(String username, String status, int page, int size);

    int count(String username, String status);

    UserEntity findUserById(int id);

    ArrayList<UserEntity> findUserAll();
}
