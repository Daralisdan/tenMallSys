package com.cn.wanxi.dao.spuAndSku.impl;

import com.cn.wanxi.dao.spuAndSku.ISkuDao;
import com.cn.wanxi.entity.spuAndSku.WxTabSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class SkuDaoImpl implements ISkuDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(WxTabSku wxTabSku) {
        String exeSQL = "INSERT INTO wx_tab_sku(sn,name,price,num,alert_num,image,images,weight,create_time,update_time,spu_id,category_id,category_name,brand_name,spec,sale_num,comment_num,status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {wxTabSku.getSn(),wxTabSku.getName(),wxTabSku.getPrice(),wxTabSku.getNum(),wxTabSku.getAlert_num(),wxTabSku.getImage(),wxTabSku.getImages(),wxTabSku.getWeight(),wxTabSku.getCreate_time(),wxTabSku.getUpdate_time(),wxTabSku.getSpu_id(),wxTabSku.getCategory_id(),wxTabSku.getCategory_name(),wxTabSku.getBrand_name(),wxTabSku.getSpec(),wxTabSku.getSale_num(),wxTabSku.getComment_num(),wxTabSku.getStatus()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public List<Map<String, Object>> testQueryForList(String ids ){
        String sql = "select * from wx_tab_sku where id in "+"("+ids+")";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select * from wx_tab_sku";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public WxTabSku findById(int id) {

        WxTabSku wxTabSku = null;
        String exeSQL = "select * from wx_tab_sku where spu_id=?";
        List<WxTabSku> wxTabSkuu = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<WxTabSku>(WxTabSku.class));
        if (null != wxTabSkuu && wxTabSkuu.size() > 0) {
            wxTabSku = wxTabSkuu.get(0);
        }
        return wxTabSku;
    }

    @Override
    public int update(WxTabSku wxTabSku) {
        String exeSQL = "update wx_tab_sku set sn=?,name=?,price=?,num=?,alert_num=?,image=?,images=?,weight=?,create_time=?,update_time=?,spu_id=?,category_id=?,category_name=?,brand_name=?,spec=?,sale_num=?,comment_num=?,status=? WHERE id=?";
        Object args[] = {wxTabSku.getSn(),wxTabSku.getName(),wxTabSku.getPrice(),wxTabSku.getNum(),wxTabSku.getAlert_num(),wxTabSku.getImage(),wxTabSku.getImages(),wxTabSku.getWeight(),wxTabSku.getCreate_time(),wxTabSku.getUpdate_time(),wxTabSku.getSpu_id(),wxTabSku.getCategory_id(),wxTabSku.getCategory_name(),wxTabSku.getBrand_name(),wxTabSku.getSpec(),wxTabSku.getSale_num(),wxTabSku.getComment_num(),wxTabSku.getStatus()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_sku WHERE spu_id=?";
        return jdbcTemplate.update(exeSQL, id);
    }

    @Override
    public int xiajia(WxTabSku wxTabSku) {
        String exeSQL = "update wx_tab_sku set status='2' WHERE id=?";
        Object args[] = {wxTabSku.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int shangjia(int id) {
        String exeSQL = "update wx_tab_sku set status='1' WHERE id=?";

        return jdbcTemplate.update(exeSQL, id);
    }

    @Override
    public int piliangxiajia(String id) {

        String sql = "update  wx_tab_sku set status='2' where id in "+"("+id+")";

        int temp = jdbcTemplate.update(sql);
        return temp;
    }

    @Override
    public WxTabSku findByIdzj(int id) {
        WxTabSku wxTabSku = null;
        String exeSQL = "select * from wx_tab_sku where id=?";
        List<WxTabSku> wxTabSkuu = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<WxTabSku>(WxTabSku.class));
        if (null != wxTabSkuu && wxTabSkuu.size() > 0) {
            wxTabSku = wxTabSkuu.get(0);
        }
        return wxTabSku;
    }
}
