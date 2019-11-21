package com.cn.wanxi.service.category;

import com.cn.wanxi.entity.category.BrandToCategory;

import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 17:08
 */
public interface IBrandToCategoryService {
    int deleteById(int id);

    int add(BrandToCategory brandToCategoryEntity);

    List<Map<String, Object>> findAll();

    BrandToCategory findById(int id);

    int update(BrandToCategory brandToCategoryEntity);
}
