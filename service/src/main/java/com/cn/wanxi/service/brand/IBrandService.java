package com.cn.wanxi.service.brand;

import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.utils.utils.Msg;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/17,Create by yaodan
 */
public interface IBrandService {
    int deleteById(int id);

    Msg add(BrandEntity brandEntity, String path, String imageFileName);

    List<Map<String, Object>> findAll();

    BrandEntity findById(int id);

    Msg update(BrandEntity brandEntity, String path, String imageFileName);

    List<Map<String, Object>> findList(BrandEntity brandEntity);

    List<Map<String, Object>> findAllbyPage(int page, int size);

    int countAll();

    List<Map<String, Object>> findListAndPage(BrandEntity brandEntity, int page, int size);

    int adds(Map<String, BrandEntity> brandEntity);

    int fileUpload(String realName);

}
