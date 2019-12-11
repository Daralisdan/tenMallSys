package com.cn.wanxi.service.advertisin.impl;

import com.cn.wanxi.dao.advertisin.IAdvertisinDao;
import com.cn.wanxi.entity.advertisin.AdvertisinEntity;
import com.cn.wanxi.service.advertisin.IAdvertisinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LeesonWong
 * @date 2019/11/29 0:22
 */
@Service
public class AdvertisinServiceImp implements IAdvertisinService {

    @Autowired
    private IAdvertisinDao iAdvertisinDao;
    
    @Override
    public List<AdvertisinEntity> findAdvertisinAll() {
        return iAdvertisinDao.findAdvertisinAll();
    }

    @Override
    public List<AdvertisinEntity> findByPosition(String position) {
        return iAdvertisinDao.findByPosition(position);
    }

    @Override
    public AdvertisinEntity findById(int id) {
        return iAdvertisinDao.findById(id);
    }

    @Override
    public List<AdvertisinEntity> findCondPage(int page, int size, String position) {
        return iAdvertisinDao.findCondPage(page,size,position);
    }

    @Override
    public boolean add(String position, String name, String startTime, String endTime,String status, String image, String url, String remarks) {
        return iAdvertisinDao.add(position,name,startTime,endTime,status,image,url,remarks);
    }

    @Override
    public boolean update(String position, String name, String startTime, String endTime,String status, String image, String url, String remarks, int id) {
        return iAdvertisinDao.update(position,name,startTime,endTime,status,image,url,remarks,id);
    }

    @Override
    public boolean delete(int id) {
        return iAdvertisinDao.delete(id);
    }
}
