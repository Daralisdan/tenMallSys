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
     * 模板新增
     *
     * @param templateEntity
     * @return
     */
    @Override
    public int add(TemplateEntity templateEntity) {
        String exeSQL = "INSERT INTO wx_tab_template (name) VALUES (?)";
        String templateNameSql = "select name from wx_tab_template where name = ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(templateNameSql,templateEntity.getName());
        if (list.size() == 0) {
            int temp = jdbcTemplate.update(exeSQL, templateEntity.getName());
            return temp;
        } else {
            return 0;
        }
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

    @Override
    public Map<String, Object> findSpecsById(TemplateEntity templateEntity) {
        String templateSQL = "select id,name,spec_num as specNum,para_num as paraNum from wx_tab_template where id = ?";
        String paraSQL = "select id,name,options,seq,template_id as templateId from wx_tab_para where template_id = ?";
        String sepcSQL = "select id,name,options,seq,template_id as templateId from wx_tab_sepc where template_id = ?";
        Object arg = templateEntity.getId();
        List<Map<String, Object>> sepcList = jdbcTemplate.queryForList(sepcSQL, arg);
        List<Map<String, Object>> paraList = jdbcTemplate.queryForList(paraSQL, arg);
        Map<String, Object> map = jdbcTemplate.queryForMap(templateSQL, arg);
        map.put("specs", sepcList);
        map.put("paras", paraList);
        return map;

    }
}
