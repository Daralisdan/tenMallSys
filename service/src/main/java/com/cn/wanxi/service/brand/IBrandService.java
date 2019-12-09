package com.cn.wanxi.service.brand;

import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.brand.ByPage;
import com.cn.wanxi.utils.utils.Msg;

import java.util.Map;

/**
 * 2019/11/17,Create by yaodan
 */
public interface IBrandService {
    Msg deleteById(Integer id);

    Msg add(BrandEntity brandEntity);

    Msg findAll();

    Msg findById(Integer id);

    Msg update(BrandEntity brandEntity);

    Msg findList(BrandEntity brandEntity);

    Msg findAllbyPage(Map<String, Integer> param);

    int countAll();

    Msg findListAndPage(ByPage byPage);


    Msg findIdAndName();
}
