package com.cn.wanxi.dao.template.impl;

import com.cn.wanxi.dao.template.TemplateDao;
import com.cn.wanxi.entity.template.TemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2019/11/18,Create by ssj
 */
@Repository
public class TemplateDaoImpl implements TemplateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Map<String, Object> find(TemplateEntity templateEntity, Integer page, Integer size) {
        String exeSQL = "select * from wx_tab_template where name = ? limit " + ((page - 1) * size) + " , " + (page * size);
        Object arg = templateEntity.getName();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL, arg);
        Map<String, Object> map = new TreeMap();
        map.put("total", size);
        map.put("rows", list);
        return map;
    }

    /**
     * 新增
     *
     * @param templateEntity
     * @return
     */
    @Override
    public int add(TemplateEntity templateEntity) {
        String exeSQL = "INSERT INTO wx_tab_template(name) VALUES (?)";
        Object arg = templateEntity.getName();
        int temp = jdbcTemplate.update(exeSQL, arg);
        return temp;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll() {
        String exeSQL = "select * from wx_tab_template";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    /**
     * 更新
     *
     * @param templateEntity
     * @return
     */
    @Override
    public int update(TemplateEntity templateEntity) {
        String exeSQL = "INSERT INTO wx_tab_template (name) VALUES (?) where name = ?";
        Object arg = templateEntity.getName();
        int temp = jdbcTemplate.update(exeSQL, arg);
        return temp;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int delete(int id) {
        String exeSQL = "DELETE FROM wx_tab_template WHERE id = ?";
        Object arg = id;
        int temp = jdbcTemplate.update(exeSQL, arg);
        return temp;
    }


}
