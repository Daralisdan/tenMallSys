package com.cn.wanxi.service.advertisin;

import com.cn.wanxi.entity.advertisin.AdvertisinEntity;

import java.sql.Date;
import java.util.List;

/**
 * @author LeesonWong
 * @date 2019/11/29 0:22
 */
public interface IAdvertisinService {
    List<AdvertisinEntity> findAdvertisinAll();

    List<AdvertisinEntity> findByPosition(String position);

    AdvertisinEntity findById(int id);

    List<AdvertisinEntity> findCondPage(int page, int size, String position);

    boolean add(String position, String name, Date startTime, Date endTime, String image, String url, String remarks);

    boolean update(String position, String name, Date startTime, Date endTime, String image, String url, String remarks, int id);

    boolean delete(int id);
}
