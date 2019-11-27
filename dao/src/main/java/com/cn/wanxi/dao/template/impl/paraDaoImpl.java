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
        String exeSQL = "INSERT INTO wx_tab_sepc(name,seq,options,template_id) VALUES(?,?,?,?)";
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
        String exeSQL = "select id,name,options,seq,template_id as templateId from wx_tab_para";
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
        String exeSQL = "UPDATE wx_tab_para SET name = ?,seq = ?,options = ?,template_id = ?";
        Object args[] = {paraEntity.getName(), paraEntity.getSeq(), paraEntity.getOptions(), paraEntity.getTemplateId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 删除
     *
     * @param paraEntity
     * @return
     */
    @Override
    public int delete(ParaEntity paraEntity) {
        String exeSQL = "DELETE FROM wx_tab_para WHERE id = ?";
        Object arg = paraEntity.getId();
        int temp = jdbcTemplate.update(exeSQL, arg);
        return temp;
    }

    @Override
    public Map<String, Object> find(ParaEntity paraEntity) {
        int size = paraEntity.getSize() * paraEntity.getPage();
        int page = (paraEntity.getPage() - 1) * paraEntity.getSize();
        String exeSQL = "select id,name,options,seq,template_id as templateId from wx_tab_para where name = ? and options = ? limit " + page + " , " + size;
        Object[] args = {paraEntity.getName(), paraEntity.getOptions()};
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL, args);
        Map<String, Object> map = new TreeMap();
        map.put("rows", list);
        map.put("total", paraEntity.getSize());
        return map;
    }
}
