/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleDaoImpl
 * Author:   Administrator
 * Date:     2019/11/21 9:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.dao.role.impl;

import com.cn.wanxi.dao.role.RoleDao;
import com.cn.wanxi.entity.role.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/21
 * @since 1.0.0
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加角色信息
     *
     * @param role
     * @return
     */
    @Override
    public int insert(RoleEntity role) {
        String exeSQL = "INSERT INTO wx_tab_role(role_name) VALUES(?)";
        Object args[] = {role.getRoleName()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 【展示所有角色信息】
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select id, role_name from wx_tab_role";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    /**
     * 【根据id查询角色信息】
     *
     * @param
     */
    @Override
    public RoleEntity findById(int id) {
        RoleEntity roleEntity = null;
        String exeSQL = "select id, role_name as roleName from wx_tab_role where id=?";
        List<RoleEntity> roleEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<RoleEntity>(RoleEntity.class));
        if (null != roleEntities && roleEntities.size() > 0) {
            roleEntity = roleEntities.get(0);
        }
        return roleEntity;
    }


    /**
     * 【修改角色信息】
     *
     * @param roleEntity
     * @return
     */
    @Override
    public int update(RoleEntity roleEntity) {
        String exeSQL = "update wx_tab_role set role_name=?  WHERE id=?";
        Object args[] = {roleEntity.getRoleName(), roleEntity.getId()};
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
        String exeSQL = "DELETE FROM wx_tab_role WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }
}