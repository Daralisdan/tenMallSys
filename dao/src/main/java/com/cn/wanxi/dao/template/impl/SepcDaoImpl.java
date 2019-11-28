package com.cn.wanxi.dao.template.impl;

import com.cn.wanxi.dao.template.SepcDao;
import com.cn.wanxi.entity.template.SepcEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:16
 */
@Repository
public class SepcDaoImpl implements SepcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 新增
     *
     * @param sepcEntity
     * @return
     */
    @Override
    public int add(SepcEntity sepcEntity) {
        String exeSQL = "INSERT INTO wx_tab_sepc(name,options,seq,template_id) VALUES(?,?,?,?)";
        Object args[] = {sepcEntity.getName(), sepcEntity.getOptions(), sepcEntity.getSeq(), sepcEntity.getTemplateId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 查找所有
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll() {
        String exeSQL = "select id,name,options,seq,template_id as templateId from wx_tab_sepc";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    /**
     * 修改
     *
     * @param sepcEntity
     * @return
     */
    @Override
    public int update(SepcEntity sepcEntity) {
        String exeSQL = "UPDATE wx_tab_para SET name = ?,seq = ?,options = ?,template_id = ?";
        Object args[] = {sepcEntity.getName(), sepcEntity.getOptions(), sepcEntity.getSeq(), sepcEntity.getTemplateId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 删除
     *
     * @param sepcEntity
     * @return
     */
    @Override
    public int delete(SepcEntity sepcEntity) {
        String exeSQL = "DELETE FROM wx_tab_sepc WHERE id = ?";
        Object arg = sepcEntity.getId();
        int temp = jdbcTemplate.update(exeSQL, arg);
        return temp;
    }

    /**
     * 分页查询
     * @param sepcEntity
     * @return
     */
    @Override
    public Map<String, Object> find(SepcEntity sepcEntity) {
        int page = (sepcEntity.getPage() - 1) * sepcEntity.getSize();
        int size = sepcEntity.getSize() * sepcEntity.getPage();
        String exeSQL = "select id,name,options,seq,template_id as templateId from wx_tab_sepc where name = ? and options = ? limit " + page + " , " + size;
        Object[] args = {sepcEntity.getName(), sepcEntity.getOptions()};
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL, args);
        Map<String, Object> map = new TreeMap();
        map.put("rows", list);
        map.put("total", sepcEntity.getSize());
        return map;
    }
}
