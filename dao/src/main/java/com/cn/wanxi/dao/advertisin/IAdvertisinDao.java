package com.cn.wanxi.dao.advertisin;

import com.cn.wanxi.entity.advertisin.AdvertisinEntity;

import java.util.List;

/**
 * @author LeesonWong
 * @date 2019/11/29 0:40
 */
public interface IAdvertisinDao {
    List<AdvertisinEntity> findAdvertisinAll();

    List<AdvertisinEntity> findByPosition(String position);

    AdvertisinEntity findById(int id);

    List<AdvertisinEntity> findCondPage(int page, int size, String position);

    Integer findCondPageSum(String position);

    boolean add(String position, String name, String startTime, String endTime,String status, String image, String url, String remarks);

    boolean update(String position, String name, String startTime, String endTime,String status, String image, String url, String remarks, int id);

    boolean delete(int id);
}
