package com.cn.wanxi.dao.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSpu;

import java.util.List;
import java.util.Map;

/**
 * 【商品信息管理】
 * 描述：SPU ：Standard Product Unit （标准产品单位）
 *      SKU：stock keeping unit(库存量单位)
 *
 * 数据表： wx_tab_spu 表--标准产品单元
 *          wx_tab_sku 表--库存量单元
 *          wx_tab_category_brand表--商品分类与品牌对应关系
 *
 * 2019/11/18,Create by yaodan
 */
public interface ISpuDao{

    int insert(WxTabSpu wxTabSpu);

    List<Map<String, Object>> queryAll();

    List<Map<String, Object>> findPage(WxTabSpu wxTabSpu , int page , int size);

    WxTabSpu findById(int id);

    List<Map<String, Object>> daishenheliebiao(WxTabSpu wxTabSpu, int page,int size );

    WxTabSpu findByName(String name);

    int update(WxTabSpu wxTabSpu);

    int deleteById(int id);

    int tijiaoshenhe (WxTabSpu wxTabSpu);

    int shenhechenggong(int id);

    int xiajia( WxTabSpu wxTabSpu);

    int shangjia(int id);

    int piliangshangjia(String id);

    int piliangxiajia(String id);

    List<Map<String, Object>> fenye(WxTabSpu wxTabSpu,int page, int size);

    int zong();

    Map<String, Object> list(int page, int size);



}

