package com.cn.wanxi.dao.template.impl;

import com.cn.wanxi.dao.template.SepcDao;
import com.cn.wanxi.entity.template.SepcEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
     * 新增二级规格名称
     *
     * @return
     */
    @Override
    public int addSepcName(String name, int seq, int templateId) {
        String addSpecNameSQL = "INSERT INTO wx_tab_sepc_name(name,seq,template_id) VALUES(?,?,?)";
        Object addSpecNameArgs[] = {name, seq, templateId};
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
        String addSpecOptionsSQL = "INSERT INTO wx_tab_sepc_options(options,sepc_id) VALUE (?,?)";
        Object[] object = {options, sepcId};
        return jdbcTemplate.update(addSpecOptionsSQL, object);
    }


    /**
     * 查找所有
     *
     * @return
     */
    @Override
    public Map<String, Object> findAll() {
        String findSepcNoOptionsSQL = "select id,name,seq,template_id as templateId from wx_tab_sepc_name";
        String findSepcOptionsSQL = "select options,sepc_id as sepcId from wx_tab_sepc_options";
        List findSepcNoOptionsList = jdbcTemplate.queryForList(findSepcNoOptionsSQL);
        List findSepcOptionsList = jdbcTemplate.queryForList(findSepcOptionsSQL);
        Map<String, Object> map = new TreeMap<>();
        map.put("options", findSepcOptionsList);
        map.put("rows", findSepcNoOptionsList);
        return map;
    }

    /**
     * 修改二级规格名称
     *
     * @param id
     * @param name
     * @param seq
     * @return
     */
    @Override
    public int updateSepcName(int id, String name, int seq) {
        String updateSepcNameSQL = "UPDATE wx_tab_sepc_name SET name = ? , seq = ? where id = ?";
        Object[] objects = {name, seq, id};
        return jdbcTemplate.update(updateSepcNameSQL, objects);
    }

    /**
     * 修改二级规格数据
     *
     * @param options
     * @param sepcId
     * @return
     */
    @Override
    public int updateSepcOptions(String options, int sepcId) {
        String updateSepcOptions = "UPDATE wx_tab_sepc_options SET options = ? where id = ? ";
        Object[] objects = {options, sepcId};
        return jdbcTemplate.update(updateSepcOptions, objects);
    }

    /**
     * 按照规格ID删除
     *
     * @param id
     * @return
     */
    @Override
    public int delete(int id) {
        String deleteNameByIdSQL = "DELETE FROM wx_tab_sepc_name WHERE id = ?";
        String deleteOptionsByIdSQL = "DELETE FROM wx_tab_sepc_options where sepc_id = ?";
        int deleteNameByIdTemp = jdbcTemplate.update(deleteNameByIdSQL, id);
        int deleteOptionsByIdTemp = jdbcTemplate.update(deleteOptionsByIdSQL, id);
        return deleteNameByIdTemp + deleteOptionsByIdTemp;
    }

    /**
     * 规格查询
     *
     * @param name
     * @return
     */
    @Override
    public List<SepcEntity> findPageBySepcName(String name) {
        String findPageBySepcNameSQL = "select id ,name ,seq,template_id as templateID from wx_tab_sepc_name where name = ?";
        List list = jdbcTemplate.queryForList(findPageBySepcNameSQL, name);
        return list;
    }


    /**
     * 通过规格ID查询规格参数
     *
     * @param id
     * @return
     */
    @Override
    public List findIdBySepcOptions(int id) {
        String findPageBySepcOptionsSQL = "select options from ex_tab_sepc_options where sepc_id = ?";
        List list = jdbcTemplate.queryForList(findPageBySepcOptionsSQL);
        return list;
    }

    /**
     * 判断输入的name是否存在
     *
     * @param name
     * @return
     */
    @Override
    public List isNameExist(String name) {
        String isNameExistSQL = "select * from wx_tab_sepc_name where name = ?";
        List list = jdbcTemplate.queryForList(isNameExistSQL, name);
        return list;
    }

    /**
     * 通过新插入规格名字查询规格id
     *
     * @param name
     * @return
     */
    @Override
    public int findIdBySepcName(String name) {
        String findIdBySepcNameSQL = "select id from wx_tab_sepc_name where name =  '" + name + "'";
        return jdbcTemplate.queryForObject(findIdBySepcNameSQL, Integer.class);
    }


}
