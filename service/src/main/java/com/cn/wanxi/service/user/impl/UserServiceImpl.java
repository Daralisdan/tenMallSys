package com.cn.wanxi.service.user.impl;

import com.cn.wanxi.dao.user.IUserDao;
import com.cn.wanxi.entity.user.UserEntity;
import com.cn.wanxi.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean addUserByEntity(UserEntity entity) {
        return 0 != iUserDao.insert(entity);
    }

    @Override
    public boolean deleteUserById(int id) {
        return 0 != iUserDao.deleteById(id);
    }

    @Override
    public UserEntity findUserById(int id) {
        return iUserDao.findById(id);
    }

    @Override
    public UserEntity findUserByName(String username) {
        return iUserDao.findByName(username);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return iUserDao.queryAll();
    }

    @Override
    public boolean updateUserByEntity(UserEntity entity) {
        return 0 != iUserDao.update(entity);
    }

    @Override
    public boolean checkUserInfo(UserEntity entity) {
        if(null == entity || null == entity.getUsername() || null == entity.getPassword()){
            return false;
        }
        return entity.getPassword().equals(iUserDao.findByName(entity.getUsername()).getPassword());
    }
}
