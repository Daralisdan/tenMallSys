package com.cn.wanxi.dao.spuAndSku.impl;

import com.cn.wanxi.dao.spuAndSku.ISpuDao;
import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
@Repository
public class SpuDaoImpl implements ISpuDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(WxTabSpu wxTabSpu) {
        String exeSQL = "INSERT INTO wx_tab_spu(sn,name,caption,brand_id,category1_id,category2_id,category3_id,template_id,freight_id," +
                "image,images,sale_service,introduction,spec_items,para_items,sale_num,comment_num,is_marketable,is_enable_pec,is_delete,status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {wxTabSpu.getSn(),wxTabSpu.getName(),wxTabSpu.getCaption(),wxTabSpu.getBrandId(),wxTabSpu.getCategory1Id(),wxTabSpu.getCategory2Id(),wxTabSpu.getCategory3Id(),
                wxTabSpu.getTemplateId(),wxTabSpu.getFreightId(),wxTabSpu.getImage(),wxTabSpu.getImages(),wxTabSpu.getSaleService(),wxTabSpu.getIntroduction(),wxTabSpu.getSpecItems(),wxTabSpu.getParaItems(),wxTabSpu.getSaleNum(),
                wxTabSpu.getCommentNum(),wxTabSpu.getIsMarkeTable(),wxTabSpu.getIsEnablePec(),wxTabSpu.getIsDelete(),wxTabSpu.getStatus()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select id, sn, name, caption, brand_id as brandId, category1_id as category1Id, category2_id as category2Id, category3_id as category3Id, template_id as templateId, freight_id as freightId, image, images, sale_service as saleService, introduction, spec_items as specItems, para_items as paraItms, sale_num as saleNum, comment_num as commentNum, is_marketable as isMakeTable, is_enable_pec as isEnablePec, is_delete as isDelete, status from wx_tab_spu";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public List<Map<String, Object>> findPage(WxTabSpu wxTabSpu , int page , int size) {
        int starter = (page - 1) * size;
        StringBuffer sql = getQuerySql(wxTabSpu);
        sql.append("   ORDER BY id ASC LIMIT  " + starter + " , " + size) ;
        String exeSQL = sql.toString();
        System.out.println("执行的SQL:" + exeSQL);
        List<Map<String, Object>> con = jdbcTemplate.queryForList(exeSQL);
        return con;
    }


    @Override
    public WxTabSpu findById(int id) {

        WxTabSpu wxTabSpu = null;
        String exeSQL = "select id, sn, name, caption, brand_id as brandId, category1_id as category1Id, category2_id as category2Id, category3_id as category3Id, template_id as templateId, freight_id as freightId, image, images, sale_service as saleService, introduction, spec_items as specItems, para_items as paraItms, sale_num as saleNum, comment_num as commentNum, is_marketable as isMakeTable, is_enable_pec as isEnablePec, is_delete as isDelete, status from wx_tab_spu where id=?";
        List<WxTabSpu> wxTabSpuu = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<WxTabSpu>(WxTabSpu.class));
        if (null != wxTabSpuu && wxTabSpuu.size() > 0) {
            wxTabSpu = wxTabSpuu.get(0);
        }
        return wxTabSpu;
    }

    @Override
    public List<Map<String, Object>> daishenheliebiao(WxTabSpu wxTabSpu, int page,int size ) {
        int starter = (page - 1) * size;
        StringBuffer sql = getQuerySql(wxTabSpu);
        sql.append("   ORDER BY id ASC LIMIT  " + starter + " , " + size);
        String exeSQL = sql.toString();
        System.out.println("执行的SQL:" + exeSQL);
        List<Map<String, Object>> con = jdbcTemplate.queryForList(exeSQL);
        return con;
    }
    private StringBuffer getQuerySql(WxTabSpu wxTabSpu) {
        StringBuffer sql = new StringBuffer();
        sql.append("select id, sn, name, caption, brand_id as brandId, category1_id as category1Id, category2_id as category2Id, category3_id as category3Id, template_id as templateId, freight_id as freightId, image, images, sale_service as saleService, introduction, spec_items as specItems, para_items as paraItms, sale_num as saleNum, comment_num as commentNum, is_marketable as isMakeTable, is_enable_pec as isEnablePec, is_delete as isDelete, status from wx_tab_spu where 1=1");
        if (!StringUtils.isEmpty(wxTabSpu.getId()) && wxTabSpu.getId() != 0) {
            sql.append("    AND id=" + wxTabSpu.getId());
        }
        if (!StringUtils.isEmpty(wxTabSpu.getStatus())) {
            sql.append("    AND status='" + wxTabSpu.getStatus() + "'");
        }
        if (!StringUtils.isEmpty(wxTabSpu.getName())) {
            sql.append("    AND name='" + wxTabSpu.getName() + "'");
        }
        if (!StringUtils.isEmpty(wxTabSpu.getCaption())) {
            sql.append("    AND caption='" + wxTabSpu.getCaption() + "'");
        }
        if (!StringUtils.isEmpty(wxTabSpu.getBrandId())) {
            sql.append("    AND brandId='" + wxTabSpu.getBrandId() + "'");
        }
        return sql;
    }

    @Override
    public WxTabSpu findByName(String name) {
        WxTabSpu wxTabSpu = null;
        String exeSQL = "select id, sn, name, caption, brand_id as brandId, category1_id as category1Id, category2_id as category2Id, category3_id as category3Id, template_id as templateId, freight_id as freightId, image, images, sale_service as saleService, introduction, spec_items as specItems, para_items as paraItms, sale_num as saleNum, comment_num as commentNum, is_marketable as isMakeTable, is_enable_pec as isEnablePec, is_delete as isDelete, status from wx_tab_spu where name=?";
        List<WxTabSpu> wxTabSpuu = jdbcTemplate.query(exeSQL, new Object[]{name}, new BeanPropertyRowMapper<WxTabSpu>(WxTabSpu.class));
        if (null != wxTabSpuu && wxTabSpuu.size() > 0) {
            wxTabSpu = wxTabSpuu.get(0);
        }
        return wxTabSpu;
    }



    @Override
    public int update(WxTabSpu wxTabSpu) {
        String exeSQL = "update wx_tab_spu set sn=?,name=?,caption=?,brand_id=?,category1_id=?,category2_id=?,category3_id=?,template_id=?,freight_id=?,image=?,images=?,sale_service=?,introduction=?,spec_items=?,para_items=?,sale_num=?,comment_num=?,is_marketable=?,is_enable_pec=?,is_delete=?,status=? WHERE id=?";
        Object args[] = {wxTabSpu.getSn(),wxTabSpu.getName(),wxTabSpu.getCaption(),wxTabSpu.getBrandId(),wxTabSpu.getCategory1Id(),wxTabSpu.getCategory2Id(),wxTabSpu.getCategory3Id(), wxTabSpu.getTemplateId(),wxTabSpu.getFreightId(),wxTabSpu.getImage(),wxTabSpu.getImages(),wxTabSpu.getSaleService(),wxTabSpu.getIntroduction(),wxTabSpu.getSpecItems(),wxTabSpu.getParaItems(),wxTabSpu.getSaleNum(),  wxTabSpu.getCommentNum(),wxTabSpu.getIsMarkeTable(),wxTabSpu.getIsEnablePec(),wxTabSpu.getIsDelete(),wxTabSpu.getStatus(),wxTabSpu.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_spu WHERE id=?";
        int temp = jdbcTemplate.update(exeSQL, id);
        return temp;
    }


    @Override
    public int tijiaoshenhe(WxTabSpu wxTabSpu) {
        String exeSQL = "update wx_tab_spu set status='9' WHERE id=?";
        Object args[] = {wxTabSpu.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int shenhechenggong(int id) {
        String exeSQL = "update wx_tab_spu set  is_marketable='1' , status='1'   WHERE id=?";
        int temp = jdbcTemplate.update(exeSQL,id);
        return temp;
    }

    @Override
    public List<Map<String, Object>> fenye(WxTabSpu wxTabSpu, int page, int size) {
        int starter = (page - 1) * size;
        StringBuffer sql = getQuerySql(wxTabSpu);
        sql.append("   ORDER BY id ASC LIMIT  " + starter + " , " + size);
        String exeSQL = sql.toString();
        System.out.println("执行的SQL:" + exeSQL);
        List<Map<String, Object>> conn = jdbcTemplate.queryForList(exeSQL);
        return conn;
    }

    @Override
    public Map<String, Object> list(int page, int size) {
        String exeSQL = "select id, sn, name, caption, brand_id as brandId, category1_id as category1Id, category2_id as category2Id, category3_id as category3Id, template_id as templateId, freight_id as freightId, image, images, sale_service as saleService, introduction, spec_items as specItems, para_items as paraItms, sale_num as saleNum, comment_num as commentNum, is_marketable as isMakeTable, is_enable_pec as isEnablePec, is_delete as isDelete, status from wx_tab_spu limit " + (page - 1)*size+" ,"+size;
        List<Map<String, Object>> listzhu = jdbcTemplate.queryForList(exeSQL);
        List<Map<String, Object>> listss = new ArrayList();
        LinkedHashMap map = new LinkedHashMap<>();
        for (Map<String, Object> sss : listzhu) {
            String sql2 = "select id, sn, name, price, num, alert_num as alertNum, image, images, weight, create_time as createTime, update_time as updateTime, spu_id as spuId, category_id as categoryId, category_name as categoryName, brand_name as barndName, spec, sale_num as saleNum, comment_num commentNum, status from wx_tab_sku where spu_id = " +sss.get("id");
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql2);
            sss.put("sublist", list);
            listss.add(sss);
        }
        map.put("row",listss);
        return map;
    }
    public List<Map<String, Object>> fe1nye(int page, int size) {
        String exeSQL = "select id, sn, name, caption, brand_id as brandId, category1_id as category1Id, category2_id as category2Id, category3_id as category3Id, template_id as templateId, freight_id as freightId, image, images, sale_service as saleService, introduction, spec_items as specItems, para_items as paraItms, sale_num as saleNum, comment_num as commentNum, is_marketable as isMakeTable, is_enable_pec as isEnablePec, is_delete as isDelete, status from wx_tab_spu limit "+(page-1)*size+","+size;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public int zong() {
        String exeSQL = "select count(*) from wx_tab_spu";
        int conut = jdbcTemplate.queryForObject(exeSQL, Integer.class);
        return conut;
    }

    @Override
    public int xiajia(WxTabSpu wxTabSpu) {
        String exeSQL = "update wx_tab_spu set is_marketable='2' WHERE id=?";
        Object args[] = {wxTabSpu.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int shangjia(int id) {
        String exeSQL = "update wx_tab_spu set is_marketable='1' WHERE id=?";

        return jdbcTemplate.update(exeSQL, id);
    }

    @Override
    public int piliangshangjia(String id) {
        String sql = "update  wx_tab_spu set is_marketable='1' where id in "+"("+id+")";

        int temp = jdbcTemplate.update(sql);
        return temp;
    }

    @Override
    public int piliangxiajia(String id) {
        String sql = "update  wx_tab_spu set is_marketable='2' where id in "+"("+id+")";

        int temp = jdbcTemplate.update(sql);
        return temp;
    }
}
