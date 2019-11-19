package com.cn.wanxi.dao.product.impl;

import com.cn.wanxi.dao.product.SPUDao;
import com.cn.wanxi.entity.product.SPUEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 【标准产品单位信息管理】
 * 描述：SPU ：Standard Product Unit （标准产品单位）
 *
 * 数据表： wx_tab_spu 表--标准产品单元
 *
 * 2019/11/18,Create by yaodan
 */
public class SPUDaoImpl implements SPUDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(SPUEntity entity) {
        String exeSQL = "INSERT INTO wx_tab_spu(name,products_num,is_show,is_menu,seq,parent_id,template_id) VALUES(?,?,?,?)";
        Object args[] = getObjectValues(entity);
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select * from wx_tab_spu";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public SPUEntity findById(int id) {
        SPUEntity categoryEntity = null;
        String exeSQL = "select * from wx_tab_spu where id=?";
        List<SPUEntity> categoryEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<SPUEntity>(SPUEntity.class));
        if (null != categoryEntities && categoryEntities.size() > 0) {
            categoryEntity = categoryEntities.get(0);
        }
        return categoryEntity;
    }

    @Override
    public int update(SPUEntity entity) {
        String exeSQL = "update wx_tab_spu set name=?,image=?,letter=?,seq=?  WHERE id=?";
        Object args[] = getObjectValues(entity);
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_spu WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }

    private Object[] getObjectValues(SPUEntity entity){
        Object args[] = {entity.getSn(),entity.getName(),entity.getCaption(),entity.getBrand_id(),entity.getCategory1_id(),entity.getCategory2_id(),entity.getCategory3_id(),
                entity.getTemplate_id(),entity.getFreight_id(),entity.getImage(),entity.getImages(),entity.getSale_service(),entity.getIntroduction(),
                entity.getSpec_items(),entity.getPara_items(),entity.getSale_num(),entity.getComment_num(),entity.getIs_marketable(),entity.getIs_enable_spec(),
                entity.getIs_delete(),entity.getStatus()};
        return args;
    }
}
