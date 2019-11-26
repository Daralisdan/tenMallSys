package com.cn.wanxi.service.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSku;

import java.util.List;
import java.util.Map;

public interface ISkuService {

    List<Map<String, Object>>  testQueryForList(String ids );

    int insert(WxTabSku wxTabSku);

    List<Map<String, Object>> queryAll();

    WxTabSku findById(int id);

    int update(WxTabSku WxTabSku);

    int deleteById(int id);

    int xiajia( WxTabSku wxTabSku);

    int piliangxiajia(String id);

    WxTabSku findByIdzj(int id);

    int shangjia(int id);

    WxTabSku findByName(String name);
}
