package com.cn.wanxi.dao.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSku;

import java.util.List;
import java.util.Map;

public interface ISkuDao {

    List<Map<String, Object>>  testQueryForList(String ids);

    int insert(WxTabSku wxTabSku);

    List<Map<String, Object>> queryAll();

    WxTabSku findById(int id);

    int update(WxTabSku WxTabSku);

    int deleteById(int id);

    int xiajia(WxTabSku wxTabSku);

    int shangjia(int id);

    int piliangxiajia(String id);

    WxTabSku findByIdzj(int id);

    WxTabSku findByName(String name);

}
