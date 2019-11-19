package com.cn.wanxi.service.spuAndSku;

import com.cn.wanxi.entity.product.CategoryToBrand;

import java.util.List;
import java.util.Map;

/**
 * @author LessonWong
 * @date 2019/11/19 12:35
 */
public interface ICategoryToBrandService {
    int deleteById(int id);

    int add(CategoryToBrand categoryToBrandEntity);

    List<Map<String, Object>> findAll();

    CategoryToBrand findById(int id);

    int update(CategoryToBrand categoryToBrandEntity);
}
