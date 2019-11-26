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


    /**
     * 模板分页查询
     *
     * @param templateEntity
     * @return
     */
    @Override
    public Map<String, Object> find(TemplateEntity templateEntity) {
        int page = (templateEntity.getPage() - 1) * templateEntity.getSize();
        int size = templateEntity.getSize() * templateEntity.getPage();
        String exeSQL = "select id , name , spec_num as specNum , para_num as paraNum from wx_tab_template where name = ? limit " + page + "," + size;
        Object arg = templateEntity.getName();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL, arg);
        Map<String, Object> map = new TreeMap();
        map.put("rows", list);
        map.put("total", templateEntity.getSize());
        return map;
    }

    /**
     * 模板新增
     *
     * @param templateEntity
     * @return
     */
    @Override
    public int add(TemplateEntity templateEntity) {
        String exeSQL = "INSERT INTO wx_tab_template (name) VALUES (?)";
        Object arg[] = {templateEntity.getName()};
        System.out.println(arg[0]);
        int temp = jdbcTemplate.update(exeSQL, arg[0]);
        return temp;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll() {
        String exeSQL = "select id , name , spec_num as specNum , para_num as paraNum from wx_tab_template";
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
        String exeSQL = "update wx_tab_template  set name=? WHERE id =?";
        Object[] args = {templateEntity.getName(), templateEntity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 删除
     *
     * @param templateEntity
     * @return
     */
    @Override
    public int delete(TemplateEntity templateEntity) {
        String exeSQL = "DELETE FROM wx_tab_template WHERE id = ?";
        Object arg = templateEntity.getId();
        int temp = jdbcTemplate.update(exeSQL, arg);
        return temp;
    }


}
