/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleMenuDaoImpl
 * Author:   Administrator
 * Date:     2019/11/21 14:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.dao.roleMenu.impl;

import com.cn.wanxi.dao.roleMenu.RoleMenuDao;
import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.role.RoleEntity;
import com.cn.wanxi.entity.roleMenu.RoleMenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class RoleMenuDaoImpl implements RoleMenuDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int[] batchCarFlowInsert(int  ids ,String menid) {
//
        String[] split = menid.split(",");
        String sql =null;
        int[] c= null;
        for (String i : split){
            int menids = Integer.parseInt(i);
            sql =" INSERT INTO wx_tab_roleMenu( role_id, menu_id) VALUES ("+ids+" , "+menids+")";
            c = jdbcTemplate.batchUpdate(sql);
            System.out.println(c.length);
        }
        return c;
    }


    @Override
    public RoleMenuEntity findByRoleId(int roleid) {
        RoleMenuEntity roleMenuEntity = null;
        String exeSQL = "select id, role_id as roleId, menu_id as menuId from wx_tab_roleMenu where role_id=?";
        List<RoleMenuEntity> roleMenuEntities = jdbcTemplate.query(exeSQL, new Object[]{roleid}, new BeanPropertyRowMapper<RoleMenuEntity>(RoleMenuEntity.class));
        if (null != roleMenuEntities && roleMenuEntities.size() > 0) {
            roleMenuEntity = roleMenuEntities.get(0);
        }
        return roleMenuEntity;
    }

    @Override
    public List<RoleMenuEntity> findEntitiesByRoleId(int roleid) {
        String exeSQL = "select id, role_id as roleId, menu_id as menuId from wx_tab_roleMenu where role_id=?";
        List<RoleMenuEntity> roleMenuEntities = jdbcTemplate.query(exeSQL, new Object[]{roleid}, new BeanPropertyRowMapper<RoleMenuEntity>(RoleMenuEntity.class));
        return roleMenuEntities;
    }

    @Override
    public int[] batchCarFlowDelete(int  ids ,String menid) {
//
        String[] split = menid.split(",");
        String sql =null;
        int[] c= null;
        for (String i : split){
            int menids = Integer.parseInt(i);
            sql =" delete  from wx_tab_roleMenu where role_id= "+ids+" and menu_id= "+menids+" ";
            c = jdbcTemplate.batchUpdate(sql);
            System.out.println(c.length);
        }
        return c;
    }

}