package com.cn.wanxi.service.brand;

import com.cn.wanxi.entity.brand.BrandEntity;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/17,Create by yaodan
 */
public interface IBrandService {
    int deleteById(int id);

    int add(BrandEntity brandEntity);

    List<Map<String, Object>> findAll();

    BrandEntity findById(int id);

    int update(BrandEntity brandEntity);

    List<Map<String, Object>> findList(BrandEntity brandEntity);

    List<Map<String, Object>> findAllbyPage(int page, int size);

    int countAll();

    List<Map<String, Object>> findListAndPage(BrandEntity brandEntity, int page, int size);
}
