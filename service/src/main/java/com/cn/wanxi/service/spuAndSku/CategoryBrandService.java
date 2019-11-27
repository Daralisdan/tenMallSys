package com.cn.wanxi.service.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabCategoryBrand;

import java.util.List;
import java.util.Map;

public interface CategoryBrandService {
    int insert(WxTabCategoryBrand wxTabCategoryBrand);

    List<Map<String, Object>> queryAll();

    WxTabCategoryBrand findById(int brandid, int categoryid);

    WxTabCategoryBrand findByName(String name);

    int update(WxTabCategoryBrand wxTabCategoryBrand);

    int deleteById(int brandid, int categoryid);
}