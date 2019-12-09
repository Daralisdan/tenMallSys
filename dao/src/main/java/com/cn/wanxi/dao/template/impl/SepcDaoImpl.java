package com.cn.wanxi.dao.template.impl;

import com.cn.wanxi.dao.template.SepcDao;
import com.cn.wanxi.entity.template.SepcEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:16
 */
@Repository
public class SepcDaoImpl implements SepcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 新增二级规格名称
     *
     * @param sepcEntity
     * @return
     */
    @Override
    public int addSepcName(SepcEntity sepcEntity) {
        String addSpecNameSQL = "INSERT INTO wx_tab_sepc_name(name,seq,template_id) VALUES(?,?,?)";
        Object addSpecNameArgs[] = {sepcEntity.getName(), sepcEntity.getSeq(), sepcEntity.getTemplateId()};
        return jdbcTemplate.update(addSpecNameSQL, addSpecNameArgs);
    }

    /**
     * 新增三级规格参数
     *
     * @param sepcId
     * @return
     */
    @Override
    public int addSepcOptions(String options, int sepcId) {
        String addSpecOptionsSQL = "INSERT INTO wx_tab_sepc_value(options,sepc_id) VALUE (?,?)";
        Object[] object = {options, sepcId};
        return jdbcTemplate.update(addSpecOptionsSQL, object);
    }

    /**
     * 查询二级规格ID
     *
     * @return 二级规格ID
     */
    @Override
    public Integer getSepcId() {
        String getSepcIdSQL = "SELECT id from wx_tab_sepc_name";
        return jdbcTemplate.queryForObject(getSepcIdSQL, Integer.class);
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
     * 分页查询（规格）
     *
     * @param sepcEntity
     * @return
     */
    @Override
    public List<SepcEntity> findPageBySepcName(SepcEntity sepcEntity) {
        int page = (sepcEntity.getPage() - 1) * sepcEntity.getSize();
        int size = sepcEntity.getSize() * sepcEntity.getSize();
        String findPageBySepcNameSQL = "select id ,name ,seq,template_id as templateID from wx_tab_sepc_name where name = ? limit " + page + " ," + size;
        List list = jdbcTemplate.queryForList(findPageBySepcNameSQL, sepcEntity.getName());
        return list;
    }

    public int findSepcId(String name) {
        String findSepcIdSQL = "select id from wx_tab_sepc_name where name = " + name;
        return jdbcTemplate.queryForObject(findSepcIdSQL, Integer.class);
    }

    @Override
    public List findIdBySepcOptions(int id) {
        String findPageBySepcOptionsSQL = "select options from ex_tab_sepc_options where sepc_id = ?";
        List list = jdbcTemplate.queryForList(findPageBySepcOptionsSQL);
        return list;
    }
}
