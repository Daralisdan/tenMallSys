package com.cn.wanxi.dao.brand.impl;

import com.cn.wanxi.dao.brand.BrandDao;
import com.cn.wanxi.entity.brand.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/16,Create by yaodan
 */

@Repository
public class BrandDaoImpl implements BrandDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加品牌信息
     *
     * @param brand
     * @return
     */
    @Override
    public int insert(BrandEntity brand) {
        String exeSQL = "INSERT INTO wx_tab_brand(name,image,letter,seq) VALUES(?,?,?,?)";
        Object args[] = {brand.getName(), brand.getImage(), brand.getLetter(), brand.getSeq()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 【展示所有品牌信息】
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select id,name,image,letter,seq from wx_tab_brand";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    /**
     * 【根据id查询品牌信息】
     *
     * @param
     */
    @Override
    public BrandEntity findById(int id) {
        BrandEntity brandEntitiy = null;
        String exeSQL = "select id,name,image,letter,seq from wx_tab_brand where id=?";
        List<BrandEntity> brandEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<BrandEntity>(BrandEntity.class));
        if (null != brandEntities && brandEntities.size() > 0) {
            brandEntitiy = brandEntities.get(0);
        }
        return brandEntitiy;
    }


    /**
     * 【修改品牌信息】
     *
     * @param brandEntity
     * @return
     */
    @Override
    public int update(BrandEntity brandEntity) {
        String exeSQL = "update wx_tab_brand set name=?,image=?,letter=?,seq=?  WHERE id=?";
        Object args[] = {brandEntity.getName(), brandEntity.getImage(), brandEntity.getLetter(), brandEntity.getSeq(), brandEntity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }


    /**
     * 【根据id删除数据】
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_brand WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }

    /**
     * 【条件查询】
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> findList(BrandEntity brandEntity) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT id,NAME,image,letter,seq FROM wx_tab_brand WHERE 1=1");
        if (!StringUtils.isEmpty(brandEntity.getId())) {
            sql.append("    AND id=" + brandEntity.getId());
        }
        if (!StringUtils.isEmpty(brandEntity.getName())) {
            sql.append("    AND name='" + brandEntity.getName() + "'");
        }
        if (!StringUtils.isEmpty(brandEntity.getImage())) {
            sql.append("    AND image='" + brandEntity.getImage() + "'");
        }
        if (!StringUtils.isEmpty(brandEntity.getLetter())) {
            sql.append("    AND letter='" + brandEntity.getLetter() + "'");
        }
        if (!StringUtils.isEmpty(brandEntity.getSeq()) && brandEntity.getSeq() != 0) {
            sql.append("    AND seq=" + brandEntity.getSeq());
        }
        String exeSQL = sql.toString();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(exeSQL);
        return maps;
    }

    /**
     * 【分页查询】
     *
     * @param page
     * @param size
     * @return
     */

    @Override
    public List<Map<String, Object>> findAllbyPage(int page, int size) {
        int starter = (page - 1) * size;
        String sql = "SELECT id,NAME,image,letter,seq FROM wx_tab_brand ORDER BY id ASC LIMIT  " + starter + " , " + size;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    /**
     * 【统计查询数据库所有数据】
     *
     * @return
     */
    @Override
    public int countAll() {
        String sql = "select * from wx_tab_brand";
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query(sql, countCallback);
        int count = countCallback.getRowCount();
        System.out.println("目前的条数是" + count);
        return count;
    }

    /**
     * 【条件+分页】
     */
    @Override
    public List<Map<String, Object>> findListAndPage(BrandEntity brandEntity, int page, int size) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT id,NAME,image,letter,seq FROM wx_tab_brand WHERE 1=1");
        if (!StringUtils.isEmpty(brandEntity.getId())) {
            sql.append("    AND id=" + brandEntity.getId());
        }
        if (!StringUtils.isEmpty(brandEntity.getName())) {
            sql.append("    AND name='" + brandEntity.getName() + "'");
        }
        if (!StringUtils.isEmpty(brandEntity.getImage())) {
            sql.append("    AND image='" + brandEntity.getImage() + "'");
        }
        if (!StringUtils.isEmpty(brandEntity.getLetter())) {
            sql.append("    AND letter='" + brandEntity.getLetter() + "'");
        }
        if (!StringUtils.isEmpty(brandEntity.getSeq()) && brandEntity.getSeq() != 0) {
            sql.append("    AND seq=" + brandEntity.getSeq());
        }
//        sql.append("    ORDER BY id ASC LIMIT  " + page + " , " + size);
        String exeSQL = sql.toString();
        List<Map<String, Object>> con = jdbcTemplate.queryForList(exeSQL);
        return con;
    }

}
