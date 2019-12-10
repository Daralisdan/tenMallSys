package com.cn.wanxi.service.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
import com.cn.wanxi.utils.utils.Msg;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface ISpuService {

    Msg insert(WxTabSpu wxTabSpu);

    List<Map<String, Object>> queryAll();

    LinkedHashMap findById(Integer id);

    WxTabSpu findByName(String name);

    Msg update(WxTabSpu wxTabSpu);

    Msg deleteById(Integer id);

    Msg daishenheliebiao(Map<String, Object> param);

    Msg tijiaoshenhe(WxTabSpu wxTabSpu);

    Msg shenhechenggong( Map<String,Integer> page);

    Msg fenye(Map<String, Object> param);

    int zong();

    Msg list(Map<String,Integer> param);

    Msg xiajia( WxTabSpu wxTabSpu);

    Msg shangjia(Integer id);

    Msg piliangshangjia(String id);

    Msg piliangxiajia(String id);

    Msg fenyeye(Map<String, Integer> param);

}
