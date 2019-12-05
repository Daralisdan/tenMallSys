package com.cn.wanxi.service.user.impl;

import com.cn.wanxi.dao.user.IUserDao;
import com.cn.wanxi.entity.user.UserEntity;
import com.cn.wanxi.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 22:25
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public boolean addUser(UserEntity entity) {
        return iUserDao.insert(entity);
    }

    @Override
    public boolean modifyPassword(String username, String password, String odpassword) {
        UserEntity byName = iUserDao.findByName(username);
        if(odpassword.equals(byName.getPassword())){
            return iUserDao.updatePasswordByUsername(username,password);
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUserById(int id) {
        return iUserDao.deleteById(id);
    }

    @Override
    public boolean resetUserPassword(String username, String password) {
        return iUserDao.updatePasswordByUsername(username,password);
    }

    @Override
    public List<UserEntity> findCondPage(String username, String status, int page, int size) {
        return iUserDao.findConditionPage(page,size);
    }

    @Override
    public int count(String username, String status) {
        return iUserDao.countCondition();
    }

    @Override
    public UserEntity findUserById(int id) {
        return iUserDao.findById(id);
    }

    @Override
    public List<UserEntity> findUserAll() {
        return iUserDao.findAll();
    }
}
