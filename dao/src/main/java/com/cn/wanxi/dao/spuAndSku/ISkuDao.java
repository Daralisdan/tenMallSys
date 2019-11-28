package com.cn.wanxi.dao.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSku;

import java.util.List;
import java.util.Map;

public interface ISkuDao {


    int insert( List<WxTabSku> wxTabSku);

    List<Map<String, Object>> queryAll();

    WxTabSku findById(int id);

    List<WxTabSku> findByIds(int id);

    int update(List<WxTabSku> wxTabSku);

    int update(WxTabSku WxTabSku);

    int deleteById(int id);

    int xiajia(WxTabSku wxTabSku);

    int shangjia(int id);

    int piliangxiajia(String id);

    WxTabSku findByIdzj(int id);

    WxTabSku findByName(String name);

}
