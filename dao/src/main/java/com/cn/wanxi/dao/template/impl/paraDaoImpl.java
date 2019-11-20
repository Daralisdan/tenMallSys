package com.cn.wanxi.dao.template.impl;

import com.cn.wanxi.dao.template.ParaDao;
import com.cn.wanxi.entity.template.ParaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:15
 */
@Repository
public class paraDaoImpl implements ParaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 新增
     *
     * @param paraEntity
     * @return
     */
    @Override
    public int add(ParaEntity paraEntity) {
        String exeSQL = "INSERT INTO wx_tab_para VALUES?";
        Object arg = paraEntity.getName();
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
        String exeSQL = "select * from wx_tab_para";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    /**
     * 更新
     *
     * @param paraEntity
     * @return
     */
    @Override
    public int update(ParaEntity paraEntity) {
        String exeSQL = "INSERT INTO wx_tab_para(name,seq,options,template_id) VALUES(?,?,?,?)";
        Object args[] = {paraEntity.getName(), paraEntity.getSeq(), paraEntity.getOptions(), paraEntity.getTemplateId()};
        int temp = jdbcTemplate.update(exeSQL, args);
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
        String exeSQL = "DELETE FROM wx_tab_para WHERE id = ?";
        Object arg = id;
        int temp = jdbcTemplate.update(exeSQL, arg);
        return temp;
    }

    @Override
    public Map<String, Object> find(ParaEntity paraEntity, Integer page, Integer size) {
        String exeSQL = "select * from wx_tab_para where name = ? and options = ? limit " + ((page - 1) * size) + " , " + (page * size);
        Object[] args = {paraEntity.getName(), paraEntity.getOptions()};
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL, args);
        Map<String, Object> map = new TreeMap();
        map.put("total", size);
        map.put("rows", list);
        return map;
    }
}