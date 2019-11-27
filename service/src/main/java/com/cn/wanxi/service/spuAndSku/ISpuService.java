package com.cn.wanxi.service.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSpu;

import java.util.List;
import java.util.Map;

public interface ISpuService {

    int insert(WxTabSpu wxTabSpu);

    List<Map<String, Object>> queryAll();

    WxTabSpu findById(int id);

    WxTabSpu findByName(String name);

    int update(WxTabSpu wxTabSpu);

    int deleteById(int id);

    List<Map<String, Object>> daishenheliebiao(WxTabSpu wxTabSpu, int page, int size);

    int tijiaoshenhe(WxTabSpu wxTabSpu);

    int shenhechenggong(WxTabSpu wxTabSpu);

    List<Map<String, Object>> fenye(WxTabSpu wxTabSpu, int page, int size);

    int zong();

}
