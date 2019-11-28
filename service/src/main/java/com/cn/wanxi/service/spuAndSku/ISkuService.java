package com.cn.wanxi.service.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSku;

import java.util.List;
import java.util.Map;

public interface ISkuService {
    
    int insert( List<WxTabSku> wxTabSku);

    List<Map<String, Object>> queryAll();

    WxTabSku findById(int id);

    List<WxTabSku> findByIds(int id);

    int update(WxTabSku WxTabSku);

    int deleteById(int id);

    int xiajia(WxTabSku wxTabSku);

    int piliangxiajia(String id);

    WxTabSku findByIdzj(int id);

    int shangjia(int id);

    WxTabSku findByName(String name);

}
